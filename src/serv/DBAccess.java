package serv;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

abstract public class DBAccess {
	 /**
	 * データベースクラス
	 **/
	 static public final String DB_CLASS = "com.mysql.jdbc.Driver";
	 /**
	  * データベースURL
	  */
	 static public final String DB_URL = "jdbc:mysql://localhost/honmokdb";
	 /**
	  *
	  *  データベース：ユーザ
	 */
	 static public final String DB_USER = "root";
	 /**
	  * データベース：パス
	 **/
	 static public final String DB_PASS = "root";

	 /**
	  * DBオブジェクト
	  */
	 public Connection con = null;

	 /**
	  * コンストラクタ
	  * - データベースへの接続
	  */
	 public DBAccess()
	 {
		 try
		 {
			 // JDBCドライバのロード
			 Class.forName(DB_CLASS);
			 // データベースへの接続
			 this.con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
		 }
		 catch(ClassNotFoundException | SQLException e)
		 {
			 e.printStackTrace();
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
