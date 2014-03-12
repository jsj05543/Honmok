/**
 *
 */
package serv;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author USER
 *
 */
public class LibraryBookDBTest {

	public LibraryBookDBTest() {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * {@link serv.LibraryBookDB#getLibraryBooks()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetLibraryBooks() {
	}

	/**
	 * {@link serv.LibraryBookDB#getLibraryBookDetailByBookNo(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testGetLibraryBookDetailByBookNo() {
		LibraryBookDB db = new LibraryBookDB();
		ArrayList<LibraryBook> result = db.getLibraryBookDetailByBookNo("200000");
		for( int i = 0; i < result.size(); i++ )
		{
			assertEquals("フェイスブックをつくったザッカーバーグの仕事術",result.get(i).getBname());
		}

	}

	/**
	 * {@link serv.LibraryBookDB#getLibraryBookDetailByBname(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testGetLibraryBookDetailByBname() {
		LibraryBookDB db = new LibraryBookDB();
		ArrayList<LibraryBook> result = db.getLibraryBookDetailByBname("フェイスブック");
		for( int i = 0; i < result.size(); i++ )
		{
			assertEquals(result.get(i).getBname(),"フェイスブックをつくったザッカーバーグの仕事術");
		}
	}

	/**
	 * {@link serv.LibraryBookDB#deleteAll()} のためのテスト・メソッド。
	 */
	@Test
	public void testDeleteAll() {
	}

	/**
	 * {@link serv.LibraryBookDB#exist(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testExist() {
		LibraryBookDB db = new LibraryBookDB();
		// 正常系
		assertEquals(db.exist("200000"),true);
		// 異常系
		assertEquals(db.exist("300000"),false);
		assertEquals(db.exist("あああ"),false);
	}

}
