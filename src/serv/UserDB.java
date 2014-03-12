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
public class UserDB extends DBAccess{

	/**
	 * "user"テーブルへのアクセス。削除されたユーザ情報は取得しない。
	 * @return ArrayList uersテーブルの配列データ、DBアクセスエラーの場合は、nullを返す。
	 */
	public ArrayList<User> getUsers()
	{
		String sql = null;
		sql = "SELECT * FROM users WHERE deleteFlag = false";
		return _getUsers(sql);
	}

	/**
	 * "user"テーブルへのアクセス。true指定で削除ユーザを含む全データを出力。flase指定の場合は、引数なしと同等。
	 * @param delete_flag
	 * @return ArrayList uersテーブルの配列データ、DBアクセスエラーの場合は、nullを返す。
	 */
	public ArrayList<User> getUsers(Boolean deletFlag)
	{
		String sql = null;
		if ( deletFlag ){
			sql = "SELECT * FROM users";
		}else{
			sql = "SELECT * FROM users WHERE deleteFlag = false";
		}
		return _getUsers(sql);
	}

	/**
	 * "user"テーブルへのアクセス本体
	 * @return ArrayList uersテーブルの配列データ、DBアクセスエラーの場合は、nullを返す。
	 */
	private ArrayList<User> _getUsers(String sql)
	{
		ArrayList<User> list = new ArrayList<User>();
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User u = new User();
				// UIDをDBから取得
				u.setUid(rs.getInt("uid"));
				// 利用者番号をDBから取得
				u.setUserNo(rs.getString("userNo"));
				// ユーザ名
				u.setUname(rs.getString("uname"));
				// 住所
				u.setAddress(rs.getString("address"));
				// 電話番号
				u.setTel(rs.getString("tel"));
				// Limitフラグ
				u.setLimitFlag(rs.getBoolean("limitFlag"));
				// Limitフラグ
				u.setDeleteFlag(rs.getBoolean("deleteFlag"));
				// 配列に保存
				list.add(u);
			}

			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
		return list;
	}

	/**
	 * UIDから、ユーザ情報を取得。該当なしの場合は、nullを返す。
	 * @param uid UID
	 * @return User 該当するデータ。該当なしの場合は、nullを返す
	 */
	public User getUserDetail(int uid)
	{
		User u = new User();
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM users WHERE uid = ?");
			stmt.setInt(1,uid);
			ResultSet rs = stmt.executeQuery();

			if ( rs.next() ){
				u.setUid(rs.getInt("uid"));
				// 利用者番号をDBから取得
				u.setUserNo(rs.getString("userNo"));
				// ユーザ名
				u.setUname(rs.getString("uname"));
				// 住所
				u.setAddress(rs.getString("address"));
				// 電話番号
				u.setTel(rs.getString("tel"));
				// Limitフラグ
				u.setLimitFlag(rs.getBoolean("limitFlag"));
				// Limitフラグ
				u.setDeleteFlag(rs.getBoolean("deleteFlag"));
			}else{
				u = null;
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			u = null;
		}
		return u;
	}

	/**
	 * ユーザNoから、ユーザ情報を取得。該当なしの場合は、nullを返す。
	 * @param userNo ユーザNo
	 * @return User  該当するデータ。該当なしの場合は、nullを返す
	 */
	public User getUserDetail(String userNo)
	{
		User u = new User();
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM users WHERE userNo = ?");
			stmt.setString(1,userNo);
			ResultSet rs = stmt.executeQuery();

			if ( rs.next() ){
				u.setUid(rs.getInt("uid"));
				// 利用者番号をDBから取得
				u.setUserNo(rs.getString("userNo"));
				// ユーザ名
				u.setUname(rs.getString("uname"));
				// 住所
				u.setAddress(rs.getString("address"));
				// 電話番号
				u.setTel(rs.getString("tel"));
				// Limitフラグ
				u.setLimitFlag(rs.getBoolean("limitFlag"));
				// Limitフラグ
				u.setDeleteFlag(rs.getBoolean("deleteFlag"));
			}else{
				u = null;
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			u = null;
		}
		return u;
	}

	/**
	 * "users"テーブルから、最新のデータを取得
	 * @return Userオブジェクト
	 */
	public User getLatestUser()
	{
		User u = new User();
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM users WHERE uid = (SELECT LAST_INSERT_ID())");
			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				u.setUid(rs.getInt("uid"));
				// 利用者番号をDBから取得
				u.setUserNo(rs.getString("userNo"));
				// ユーザ名
				u.setUname(rs.getString("uname"));
				// 住所
				u.setAddress(rs.getString("address"));
				// 電話番号
				u.setTel(rs.getString("tel"));
				// Limitフラグ
				u.setLimitFlag(rs.getBoolean("limitFlag"));
				// Limitフラグ
				u.setDeleteFlag(rs.getBoolean("deleteFlag"));
			}

			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			return null;
		}
		return u;
	}

	/**
	 * 入力された氏名から該当するユーザ情報を返す。検索は部分一致。
	 * @param uname 氏名
	 * @return ArrayList<User>  該当するUserデータの配列。一致するデータがない場合はNULLを返す
	 */
	public ArrayList<User> getUserDetailByUname(String uname)
	{
		ArrayList<User> list = new ArrayList<User>();
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM users WHERE uname LIKE ?");
			stmt.setString(1,  "%" + uname + "%");
			ResultSet rs = stmt.executeQuery();

			while ( rs.next() ){
				User u = new User();
				u.setUid(rs.getInt("uid"));
				// 利用者番号をDBから取得
				u.setUserNo(rs.getString("userNo"));
				// ユーザ名
				u.setUname(rs.getString("uname"));
				// 住所
				u.setAddress(rs.getString("address"));
				// 電話番号
				u.setTel(rs.getString("tel"));
				// Limitフラグ
				u.setLimitFlag(rs.getBoolean("limitFlag"));
				// Limitフラグ
				u.setDeleteFlag(rs.getBoolean("deleteFlag"));

				list.add(u);
			}
			rs.close();
			stmt.close();
			if ( list.isEmpty() ){
				list = null;
			}
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			list = null;
		}
		return list;
	}


	/**
	 * ユーザ情報追加
	 * @param uname 氏名
	 * @param address 住所
	 * @param tel 電話番号
	 * @return データ適用数(-1の場合：同一データが存在、0の場合：挿入処理エラー)
	 */
	public int insert(String userNo, String uname, String address, String tel)
	{
		try
		{
			if( ! this.isSameData(uname,address,tel) ){
				//	プリペアードステートメント
				String 	sql = "INSERT INTO users (userNo, uname, address, tel) values (?, ?, ?, ?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,userNo);
				stmt.setString(2,uname);
				stmt.setString(3,address);
				stmt.setString(4,tel);
				//	SQLの実行
				return stmt.executeUpdate();
			}else{
				return -1;
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
	 * @param uid 削除対象となるUID
	 * @return データベースへの適用数(0であった場合は、更新エラー）
	 */
	public int delete(int uid)
	{
		try
		{
			if( this.searchId(uid) ){
				String sql = "UPDATE users SET deleteFlag = true WHERE uid = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,uid);
				//	SQLの実行
				return stmt.executeUpdate();
			}else{
				System.out.println("指定された番号のユーザーは存在しません。");
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
	 * 特定データ削除(DELETE)
	 * @param uid 削除対象となるUID
	 * @return データベースへの適用数(0であった場合は、更新エラー）
	 */
	protected int deleteForce(int uid)
	{
		try
		{
			if( this.searchId(uid) ){
				String sql = "DELETE FROM users WHERE uid = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,uid);
				//	SQLの実行
				return stmt.executeUpdate();
			}else{
				System.out.println("指定された番号のユーザーは存在しません。");
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
			String sql = "DELETE FROM users";
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
	 * データ更新(名前、住所、電話番号の更新。利用者番号の更新はしない)
	 * @param uid
	 * @param uname
	 * @param address
	 * @param tel
	 * @return データベースへの適用数(0であった場合は更新エラー)
	 */
	public int update(int uid, String uname, String address, String tel)
	{
		try
		{
			if( this.searchId(uid)){
				//	プリペアードステートメント
				String sql = "UPDATE users SET uname = ?, address = ?, tel = ? WHERE uid = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,uname);
				stmt.setString(2,address);
				stmt.setString(3,tel);
				stmt.setInt(4,uid);
								//	SQLの実行
				return stmt.executeUpdate();
			}else{
				System.out.println("指定されたUIDは存在しません");
				return -1;
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
	private Boolean isSameData(String uname, String address, String tel)
	{
		try
		{
			//	プリペアードステートメント
			String sql = "SELECT * FROM users WHERE uname=? AND address=? AND tel=?";
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
			return false;
		}

	}

	/**
	 * 既存データがあるかどうかのサーチ
	 * @param id ID
	 * @return true:既存データあり、false:既存データなし
	 */
	private Boolean searchId(int id)
	{
		try
		{
			//	プリペアードステートメント
			String sql = "SELECT * FROM users WHERE uid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			return null;
		}
	}


	/**
	 * 利用者番号が使われているか？
	 * @param userNo 利用者番号
	 * @return true 使われている
	 * @return false 使われていない
	 * @return null 内部エラー
	 */
	public Boolean usedUserNo(String userNo)
	{
		try
		{
			//	プリペアードステートメント
			String sql = "SELECT * FROM users WHERE userNo=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,userNo);
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
