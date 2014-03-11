/**
 *
 */
package serv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

/**
 * Userテーブルへのデータアクセスクラス
 *
 * @author Koji Hijikuro
 */
public class UserDB {
	private Connection con = null;

	/**
	 * コンストラクタ
	 *  - データベースへの接続
	 */
	public UserDB()
	{
		try
		{
			// JDBCドライバのロード
			Class.forName("com.mysql.jdbc.Driver");
			// データベースへの接続
			this.con = DriverManager.getConnection("jdbc:mysql://localhost/honmokdb", "root", "root");
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * "user"テーブルへのアクセス
	 * @return ArrayList memoテーブルの配列データ
	 */
	public ArrayList<User> getMemoList()
	{
		ArrayList<User> list = new ArrayList<User>();
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM users WHERE delete_flag = false");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				User u = new User();
				u.setUserNo("利用者番号");
				list.add(u);
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
	 * 同一データ（氏名、住所、電話番号が全て同じ）があるかどうかのサーチ
	 * @param uname 氏名
	 * @param address 住所
	 * @param tel 電話番号
	 * @return true:既存データあり、false:既存データなし
	 */
	public Boolean isSameData(String uname, String address, String tel)
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

	/**
	 * 既存データがあるかどうかのサーチ
	 * @param id ID
	 * @return true:既存データあり、false:既存データなし
	 */
	public Boolean searchId(int id)
	{
		try
		{
			//	プリペアードステートメント
			String sql = "SELECT * FROM user WHERE uid=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1,id);
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return true;
		}
	}


	/**
	 * ユーザ情報追加
	 * @param uname 氏名
	 * @param address 住所
	 * @param tel 電話番号
	 * @return データ適用数
	 */
	public int insert(String uname, String address, String tel)
	{
		try
		{
			if( !this.isSameData(uname,address,tel)){
				//	プリペアードステートメント
				String 	sql = "INSERT INTO user (userNo, uname, address, tel) values (?, ?, ?, ?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(2,uname);
				stmt.setString(3,address);
				stmt.setString(4,tel);
				//	SQLの実行
				return stmt.executeUpdate();
			}else{
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
	 * 特定データ削除
	 * @param mid
	 * @return データベースへの適用数
	 */
	public int delete(int uid)
	{
		try
		{
			int num=0;
			if( this.searchId(uid) ){
				String sql = "UPDATE user SET delete_flag = true WHERE uid = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,uid);
				//	SQLの実行
				num = stmt.executeUpdate();
			}else{
				System.out.println("指定された番号のメモは存在しません。");
			}
			return num;
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
			String sql = "DELETE FROM user";
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
	 * データ更新
	 * @param mid
	 * @return データベースへの適用数
	 */
	public int update(int mid, String body)
	{
		try
		{
			int num=0;
			if( this.searchId(mid)){
				//	プリペアードステートメント
				String sql = "UPDATE memo SET body = ?, mtime = ? WHERE mid = ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1,body);
				Timestamp ts = new Timestamp(System.currentTimeMillis());
				stmt.setTimestamp(2,ts);
				stmt.setInt(3,mid);

//	SQLの実行
				num = stmt.executeUpdate();
			}else{
				System.out.println("指定された番号のメモは存在しません。");
			}
			return num;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
	}


	/**
	 * データベースのクローズ
	 */
	public void close()
	{
		if ( con != null)
		{
			try
			{
				this.con.close();
			}
			catch(SQLException e)
			{
				e.printStackTrace();
			}

		}
	}

}
