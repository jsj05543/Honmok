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
public class CirculationDBTest {

	public CirculationDBTest() {
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
	 * {@link serv.CirculationDB#getCirculations()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetCirculations() {
		CirculationDB db = new CirculationDB();
		// 数
        assertEquals(7, db.getCirculations().size());
	}

	/**
	 * {@link serv.CirculationDB#getCirculations(boolean)} のためのテスト・メソッド。
	 */
	@Test
	public void testGetCirculationsBool() {
		CirculationDB db = new CirculationDB();
		// 数
        assertEquals(8, db.getCirculations(true).size());
		// 数
        assertEquals(7, db.getCirculations(false).size());
	}

	/**
	 * {@link serv.CirculationDB#getOverDueList()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetOverDueList() {
		// CAUTION!!! テスト前にはデータベースSQLを再実行する必要あり！！
		CirculationDB db = new CirculationDB();
		ArrayList<Circulation> golden = new ArrayList<Circulation>();
		Circulation c = new Circulation();
		c.setCid(3);
		golden.add(c);
		c = new Circulation();
		c.setCid(4);
		golden.add(c);
		ArrayList<Circulation> result = db.getOverDueList();
		for( int i = 0; i < result.size(); i++ )
		{
			assertEquals(result.get(i).getCid(),golden.get(i).getCid());
		}
	}

	/**
	 * {@link serv.CirculationDB#getCirculationsOnIssueByUid()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetCirculationsOnIssueByUid() {
		// CAUTION!!! テスト前にはデータベースSQLを再実行する必要あり！！
		CirculationDB db = new CirculationDB();
		// 数
        assertEquals(0, db.getCirculationsOnIssueByUid(1).size());
        assertEquals(1, db.getCirculationsOnIssueByUid(2).size());
        assertEquals(1, db.getCirculationsOnIssueByUid(3).size());
        assertEquals(1, db.getCirculationsOnIssueByUid(4).size());
        assertEquals(3, db.getCirculationsOnIssueByUid(5).size());
	}



	/**
	 * {@link serv.CirculationDB#canRent(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testCanRent() {
		CirculationDB db = new CirculationDB();
		assertEquals(db.canRent("100000"),true);
		assertEquals(db.canRent("100010"),false);
	}

	/**
	 * {@link serv.CirculationDB#insert(int, int)} のためのテスト・メソッド。
	 */
	@Test
	public void testInsert() {
	}

	/**
	 * {@link serv.CirculationDB#delete(int)} のためのテスト・メソッド。
	 */
	@Test
	public void testDelete() {
	}

	/**
	 * {@link serv.CirculationDB#deleteAll()} のためのテスト・メソッド。
	 */
	@Test
	public void testDeleteAll() {
	}

	/**
	 * {@link serv.CirculationDB#update(int)} のためのテスト・メソッド。
	 */
	@Test
	public void testUpdate() {
	}

}
