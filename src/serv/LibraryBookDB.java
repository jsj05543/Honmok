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
public class LibraryBookDB extends DBAccess{

	/**
	 * "LibraryBook"テーブルへのアクセス
	 * @return ArrayList LibraryBookテーブルの配列データ
	 */
	public ArrayList<LibraryBook> getLibraryBooks()
	{
		ArrayList<LibraryBook> list = new ArrayList<LibraryBook>();
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM librarybooks, books WHERE librarybooks.bid = books.bid AND librarybooks.deleteFlag = false");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				LibraryBook lb = new LibraryBook();
				// LibraryBook ID
				lb.setLbid(rs.getInt("lbid"));
				// Book ID
				lb.setBid(rs.getInt("bid"));
				// 図書書籍管理番号
				lb.setBookNo(rs.getString("bookNo"));
				// ISBN
				lb.setIsbn(rs.getString("isbn"));
				// 書籍名
				lb.setBname(rs.getString("bname"));
				// 筆者
				lb.setAuthor(rs.getString("author"));
				// 出版社
				lb.setPublisher(rs.getString("publisher"));
				// ページ数
				list.add(lb);
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
	 * BookNoから、書籍情報の詳細を返すメソッド
	 * @param bookNo BookNo
	 * @return LibraryBook LibraryBookテーブル
	 */
	public LibraryBook getLibraryBookDetail(String bookNo)
	{
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM librarybooks, books WHERE librarybooks.bid = books.bid AND librarybooks.bookNo = ?");
			stmt.setString(1,bookNo);
			ResultSet rs = stmt.executeQuery();

			LibraryBook lb = new LibraryBook();
			// LibraryBook ID
			lb.setLbid(rs.getInt("lbid"));
			// Book ID
			lb.setBid(rs.getInt("bid"));
			// 図書書籍管理番号
			lb.setBookNo(bookNo);
			// ISBN
			lb.setIsbn(rs.getString("isbn"));
			// 書籍名
			lb.setBname(rs.getString("bname"));
			// 筆者
			lb.setAuthor(rs.getString("author"));
			// 出版社
			lb.setPublisher(rs.getString("publisher"));

			rs.close();
			stmt.close();

			return lb;

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}


	/**
	 * 書籍情報追加
	 * @param uname 氏名
	 * @param address 住所
	 * @param tel 電話番号
	 * @return データ適用数(-1の場合：同一データが存在、0の場合：挿入処理エラー)
	 */
	/*
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
				return -1;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return 0;
		}
	}
	*/

	/**
	 * 特定データ削除
	 * @param mid
	 * @return データベースへの適用数(0であった場合は、更新エラー）
	 */
	/*
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
	*/


	/**
	 * 全データ削除
	 * @return データベースへの適用数
	 */
	public void deleteAll()
	{
		try
		{
			//	プリペアードステートメント
			String sql = "DELETE FROM librarybooks";
			PreparedStatement stmt = con.prepareStatement(sql);
			//	SQLの実行
			stmt.executeUpdate();

			//	プリペアードステートメント
			sql = "DELETE FROM books";
			stmt = con.prepareStatement(sql);
			//	SQLの実行
			stmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * データ更新
	 * @param mid
	 * @return データベースへの適用数(0であった場合は更新エラー)
	 */
	/*
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
	*/

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
	 * @param id ID
	 * @return true:既存データあり、false:既存データなし
	 */
	/*
	private Boolean searchId(int id)
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
	*/




}
