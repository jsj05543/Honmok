/**
 *
 */
package serv;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import serv.LibraryBookDB;

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
		fail("まだ実装されていません"); // TODO
	}

	/**
	 * {@link serv.LibraryBookDB#getLibraryBookDetail(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testGetLibraryBookDetail() {
		fail("まだ実装されていません"); // TODO
	}

	/**
	 * {@link serv.LibraryBookDB#deleteAll()} のためのテスト・メソッド。
	 */
	@Test
	public void testDeleteAll() {
		fail("まだ実装されていません"); // TODO
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
