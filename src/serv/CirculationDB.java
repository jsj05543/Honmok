/**
 *
 */
package serv;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Userテーブルへのデータアクセスクラス
 *
 * @author Koji Hijikuro
 */
public class CirculationDB extends DBAccess{

	/**
	 * "circulation"テーブルの削除済みデータを除く、全情報を取得
	 * @return ArrayList circulationテーブルの配列データ
	 */
	public ArrayList<Circulation> getCirculations(){
		String sql = "SELECT * FROM CirculationsDetail";
		return _getCirculations(sql);
	}

	/**
	 * "circulation"テーブルの削除済み全データを含む、全データを取得
	 * @return ArrayList circulationテーブルの配列データ
	 */
	public ArrayList<Circulation> getCirculations(Boolean deleteFlag){
		String sql = null;

		if ( deleteFlag ){
			sql = "SELECT * FROM CirculationsDetailAll";
		}else{
			sql = "SELECT * FROM CirculationsDetail";
		}
		return _getCirculations(sql);
	}



	/**
	 * Circulation情報をとってくる本体
	 * @param sql
	 * @return
	 */
	private ArrayList<Circulation> _getCirculations(String sql)
	{
		ArrayList<Circulation> list = new ArrayList<Circulation>();
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Circulation c = new Circulation();
				makeCirculation(rs,c);
				list.add(c);
			}

			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			return null;
		}
		return list;
	}



	/**
	 * "circulation"テーブルから、指定したUIDに該当する未返却データを取得
	 * @return ArrayList circulationテーブルの配列データ
	 */
	public ArrayList<Circulation> getCirculationsOnIssueByUid(int uid)
	{
		ArrayList<Circulation> list = new ArrayList<Circulation>();
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement("SELECT  * FROM CirculationsDetail WHERE returnDay IS NULL AND uid = ?");
			stmt.setInt(1,uid);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Circulation c = new Circulation();
				makeCirculation(rs,c);
				list.add(c);
			}

			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			return null;
		}
		return list;
	}


	/**
	 * "circulation"テーブルから、最新のデータを取得
	 * @return Circulationオブジェクト
	 */
	public Circulation getLatestCirculation()
	{
		Circulation c = new Circulation();
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM CirculationsDetail WHERE cid = (SELECT LAST_INSERT_ID())");
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				c = makeCirculation(rs,c);
			}

			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			return null;
		}
		return c;
	}

	/**
	 * "circulation"テーブルから、CIDに該当する情報を取得
	 * @return Circulationオブジェクト
	 */
	public Circulation getCirculationDetailByCid(Integer cid)
	{
		Circulation c = new Circulation();
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM CirculationsDetail WHERE cid = ?");
			stmt.setInt(1,cid);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				c = makeCirculation(rs,c);
			}

			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			return null;
		}
		return c;
	}

	/**
	 * 貸し出し中のリストの中から、指定したBookNoに該当するデータを取得
	 * @param bookNo
	 * @return Circulation 指定されたBookNoの貸し出し情報
	 */
	public Circulation getCirculationOnIssueByBookNo(String bookNo){
		Circulation c = new Circulation();
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM CirculationsDetail WHERE returnDay IS NULL AND bookNo = ?");
			stmt.setString(1,bookNo);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				c = makeCirculation(rs,c);
			}else{
				c = null;
			}

			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			return null;
		}
		return c;
	}


	/**
	 * "circulations"テーブルから貸し出しを延滞しているリストを返す。
	 * 条件：返却日(returnDay)がNULL、かつ貸出日(issueDay)が、7日前。（deleteFlag == false)
	 * @return Circulation circulationテーブル
	 */
	public ArrayList<Circulation> getOverDueList()
	{
		ArrayList<Circulation> list = new ArrayList<Circulation>();
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement("SELECT  * FROM CirculationsDetail WHERE returnDAY IS NULL AND issueDay < DATE_SUB(CURDATE(), INTERVAL 6 DAY)");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Circulation c = new Circulation();
				makeCirculation(rs,c);
				list.add(c);
			}

			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			return null;
		}
		return list;
	}

	/**
	 * 貸し出し可能かどうかをチェックする（本の貸し出し状況が3冊に到達していなければOK）
	 * 条件：返却日(returnDay)がNULLである貸し出しリストが3件になっているもの。
	 * @param userNo 利用者番号
	 * @return true: 3冊未満。false: 3冊以下
	 */
	public Boolean canRent(String userNo)
	{
		Boolean rent_flag = false;
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement("SELECT count(*) as num FROM circulations, users WHERE circulations.uid = users.uid AND returnDAY IS NULL AND users.userNo = ?");
			stmt.setString(1,userNo);
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				if( rs.getInt("num") < 3 ){
					// 3冊以下であれば貸し出し可能
					rent_flag = true;
				}
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			return null;
		}
		return rent_flag;
	}

	/**
	 * 貸し出し情報追加(本の貸し出し処理の際に実行。貸出日は処理実行時のデータを使用）
	 * @param uid ユーザID
	 * @param lbid 書籍ID
	 * @return INSERT処理適用数(1:正常実行、0:以上実行）
	 */
	public int insert(int uid, int lbid)
	{
		try
		{
			//	プリペアードステートメント
			String 	sql = "INSERT INTO circulations (issueDay, uid, lbid) values (now(), ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,uid);
			stmt.setInt(2,lbid);
			//	SQLの実行
			return stmt.executeUpdate();
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 特定データ削除
	 * @param lbid
	 * @return データベースへの適用数(0であった場合は、更新エラー）
	 */
	public int delete(int cid)
	{
		try
		{
			if( this.searchCid(cid) ){
				String sql = "UPDATE circulations SET deleteFlag = true WHERE cid = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,cid);
				//	SQLの実行
				return stmt.executeUpdate();
			}else{
				System.out.println("指定された番号のLBIDは存在しません。");
				return 0;
			}
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 特定データ削除
	 * @param lbid
	 * @return データベースへの適用数(0であった場合は、更新エラー）
	 */
	protected int deleteForce(int cid)
	{
		try
		{
			if( this.searchCid(cid) ){
				String sql = "DELETE FROM circulations WHERE cid = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,cid);
				//	SQLの実行
				return stmt.executeUpdate();
			}else{
				System.out.println("指定された番号のCID(" + cid + ")は存在しません。");
				return 0;
			}
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			return 0;
		}
	}


	/**
	 * 全データ削除
	 * @return データベースへの適用数
	 */
	public int deleteAll()
	{
		try
		{
			//	プリペアードステートメント
			String sql = "DELETE FROM circulations";
			PreparedStatement stmt = con.prepareStatement(sql);
			//	SQLの実行
			return stmt.executeUpdate();
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * データ更新(本の返却があった場合に実行。返却時間を設定)
	 * @param bookNo
	 * @return データベースへの適用数(0であった場合は更新エラー)
	 */
	public int update(int cid)
	{
		try
		{
			if( this.searchCid(cid) ){
				//	プリペアードステートメント
				String sql = "UPDATE circulations SET returnDay = now() WHERE cid = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,cid);
				//	SQLの実行
				return stmt.executeUpdate();
			}else{
//				System.out.println("指定された番号のメモは存在しません。");
				return 0;
			}
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 同一データ（氏名、住所、電話番号が全て同じ）があるかどうかのサーチ
	 * @param uname 氏名
	 * @param address 住所
	 * @param tel 電話番号
	 * @return true:既存データあり、false:既存データなし
	 */
	/*
	private Boolean isSameData(String uname, String address, String tel)
	{
		try
		{
			//	プリペアードステートメント
			String sql = "SELECT * FROM user WHERE uname=? address=? tel=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,uname);
			stmt.setString(2,address);
			stmt.setString(3,tel);
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return true;
		}
	}
	*/

	/**
	 * LBID既存データがあるかどうかのサーチ
	 * @param lbid LBID
	 * @return true:既存データあり、false:既存データなし
	 */
	public Boolean searchLbid(int lbid)
	{
		try
		{
			//	プリペアードステートメント
			String sql = "SELECT * FROM circulations WHERE lbid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,lbid);
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			return false;
		}
	}

	/**
	 * CID既存データがあるかどうかのサーチ
	 * @param lbid LBID
	 * @return true:既存データあり、false:既存データなし
	 */
	public Boolean searchCid(int cid)
	{
		try
		{
			//	プリペアードステートメント
			String sql = "SELECT * FROM circulations WHERE cid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,cid);
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			return false;
		}
	}



	private Circulation makeCirculation(ResultSet rs, Circulation c) throws SQLException{
		// CIDをDBから取得
		c.setCid(rs.getInt("cid"));
		// 貸出日
		c.setIssueDay(rs.getTimestamp("issueDay"));
		// 返却日
		c.setReturnDay(rs.getTimestamp("returnDay"));
		// deleteFlag
		c.setDeleteFlag(rs.getBoolean("deleteFlag"));

		// User
		User user = new User();
		user.setUid(rs.getInt("uid"));
		user.setUserNo(rs.getString("userNo"));
		user.setUname(rs.getString("uname"));
		user.setAddress(rs.getString("address"));
		user.setTel(rs.getString("tel"));
		// Userオブジェクトをセット
		c.setUser(user);

		// Book
		LibraryBook book = new LibraryBook();
		book.setLbid(rs.getInt("lbid"));
		book.setBid(rs.getInt("bid"));
		book.setBookNo(rs.getString("bookNo"));
		book.setIsbn(rs.getString("isbn"));
		book.setAuthor(rs.getString("author"));
		book.setBname(rs.getString("bname"));
		book.setPublisher(rs.getString("publisher"));
		book.setPage(rs.getInt("page"));
		// LibraryBookオブジェクトをセット
		c.setLibraryBook(book);

		return c;
	}




}
