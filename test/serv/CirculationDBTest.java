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
