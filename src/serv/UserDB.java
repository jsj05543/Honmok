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
	 * "user"テーブルへのアクセス
	 * @return ArrayList uersテーブルの配列データ、DBアクセスエラーの場合は、nullを返す。
	 */
	public ArrayList<User> getUsers()
	{
		ArrayList<User> list = new ArrayList<User>();
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM users WHERE delete_flag = false");
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
				// 配列に保存
				list.add(u);
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
			if( !this.isSameData(uname,address,tel)){
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
	 * @param mid
	 * @return データベースへの適用数(0であった場合は、更新エラー）
	 */
	public int delete(int uid)
	{
		try
		{
			if( this.searchId(uid) ){
				String sql = "UPDATE users SET delete_flag = true WHERE uid = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,uid);
				//	SQLの実行
				return stmt.executeUpdate();
			}else{
				System.out.println("指定された番号のメモは存在しません。");
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
			String sql = "SELECT * FROM users WHERE uname=? address=? tel=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,uname);
			stmt.setString(2,address);
			stmt.setString(3,tel);
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


}
