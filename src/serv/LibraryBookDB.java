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
	 * @return ArrayList LibraryBookテーブルの配列データ、DBアクセスエラーの場合は、nullを返す。
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
				makeLibraryBook(rs,lb);
				list.add(lb);
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
	 * BookNoから、書籍情報の詳細を返すメソッド。bookNo完全一致判定。該当なしの場合は、nullを返す。
	 * @param bookNo BookNo
	 * @return  LibraryBook LibraryBookデータ、DBアクセスエラーの場合は、nullを返す。
	 */
	public LibraryBook getLibraryBookDetailByBookNo(String bookNo)
	{
		LibraryBook lb = new LibraryBook();
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM librarybooks LEFT JOIN books ON librarybooks.bid = books.bid WHERE librarybooks.bookNo = ?");
			stmt.setString(1,bookNo);
			ResultSet rs = stmt.executeQuery();
			if ( rs.next() ) {
				makeLibraryBook(rs,lb);
			}else{
				lb = null;
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			lb = null;
		}
		return lb;
	}

	/**
	 * 書籍名(bname)から、書籍情報の詳細を返すメソッド。該当なしの場合は、nullを返す。
	 * @param bname 書籍名
	 * @return ArrayList<LibraryBook>  LibraryBookの配列、DBアクセスエラーの場合は、nullを返す。
	 */
	public  ArrayList<LibraryBook> getLibraryBookDetailByBname(String bname)
	{
		ArrayList<LibraryBook> list = new ArrayList<LibraryBook>();
		try
		{
			// SQL操作
			PreparedStatement stmt = this.con.prepareStatement("SELECT * FROM librarybooks LEFT JOIN books ON librarybooks.bid = books.bid WHERE books.bname LIKE ?");
			stmt.setString(1,  "%" + bname + "%");
			ResultSet rs = stmt.executeQuery();

			while ( rs.next() ) {
				LibraryBook lb = new LibraryBook();
				makeLibraryBook(rs,lb);
				list.add(lb);
			}
			rs.close();
			stmt.close();
		}
		catch(SQLException e)
		{
//			e.printStackTrace();
			System.out.println(e);
		}
		return list;
	}


	/**
	 * 全データ削除
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
	 * 指定した書籍番号が存在するかどうかの判定
	 * @param bookNo 書籍番号
	 * @return true:既存データあり、false:既存データなし
	 */
	public Boolean exist(String bookNo)
	{
		try
		{
			//	プリペアードステートメント
			String sql = "SELECT * FROM librarybooks WHERE bookNo=?";
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1,bookNo);
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
	 * DBから取得したデータをLibraryBookオブジェクトに格納
	 * @param rs
	 * @param book
	 * @throws SQLException
	 */
	private void makeLibraryBook(ResultSet rs, LibraryBook book) throws SQLException{
		book.setLbid(rs.getInt("lbid"));
		book.setBid(rs.getInt("bid"));
		book.setBookNo(rs.getString("bookNo"));
		book.setIsbn(rs.getString("isbn"));
		book.setAuthor(rs.getString("author"));
		book.setBname(rs.getString("bname"));
		book.setPublisher(rs.getString("publisher"));
		book.setPage(rs.getInt("page"));
	}


}
