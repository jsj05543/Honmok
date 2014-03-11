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
	 * "user"テーブルへのアクセス
	 * @return ArrayList uersテーブルの配列データ
	 */
	public ArrayList<Circulation> getCirculations()
	{
		ArrayList<Circulation> list = new ArrayList<Circulation>();
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM circulation WHERE delete_flag = false");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Circulation c = new Circulation();
				// CIDをDBから取得
				c.setCid(rs.getInt("cid"));
				// 貸出日
				c.setIssueDay(rs.getTimestamp("issueDay"));
				// 返却日
				c.setReturnDay(rs.getTimestamp("returnDay"));
				// UID
				c.setUid(rs.getInt("uid"));
				// LBID
				c.setLbid(rs.getInt("lbid"));
				list.add(c);
			}

			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return list;
	}


	/**
	 * 貸し出し情報追加(本の貸し出し処理の際に実行。貸出日は処理実行時のデータを使用）
	 * @param uid ユーザID
	 * @param lbid 書籍ID
	 * @return
	 */
	public int insert(int uid, int lbid)
	{
		try
		{
			//	プリペアードステートメント
			String 	sql = "INSERT INTO circulations (issueDay, uid, bid) values (now(), ?, ?)";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,uid);
			stmt.setInt(2,lbid);
			//	SQLの実行
			return stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * 特定データ削除
	 * @param lbid
	 * @return データベースへの適用数(0であった場合は、更新エラー）
	 */
	public int delete(int lbid)
	{
		try
		{
			if( this.searchId(lbid) ){
				String sql = "UPDATE circulations SET delete_flag = true WHERE lbid = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,lbid);
				//	SQLの実行
				return stmt.executeUpdate();
			}else{
				System.out.println("指定された番号のLBIDは存在しません。");
				return 0;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
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
			e.printStackTrace();
			return 0;
		}
	}

	/**
	 * データ更新(本の返却があった場合に実行。返却時間を設定)
	 * @param lbid
	 * @return データベースへの適用数(0であった場合は更新エラー)
	 */
	public int update(int lbid)
	{
		try
		{
			if( this.searchId(lbid)){
				//	プリペアードステートメント
				String sql = "UPDATE circulations SET returnDay = now() WHERE lbid = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,lbid);
				//	SQLの実行
				return stmt.executeUpdate();
			}else{
				System.out.println("指定された番号のメモは存在しません。");
				return 0;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
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
	 * 既存データがあるかどうかのサーチ
	 * @param lbid LBID
	 * @return true:既存データあり、false:既存データなし
	 */
	private Boolean searchId(int lbid)
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
			e.printStackTrace();
			return true;
		}
	}




}
