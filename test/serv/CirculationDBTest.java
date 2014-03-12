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
		ArrayList<Circulation> result = db.getCirculations();
		// 数
        assertEquals(7, result.size());
        // 一番目のデータ
        int i = 0;
        assertEquals(1,result.get(i).getCid());
        assertEquals("肥後　太郎",result.get(i).getUser().getUname());
        assertEquals("肥後123-456",result.get(i).getUser().getAddress());
        assertEquals("0120-1515-3776",result.get(i).getUser().getTel());
        assertEquals("100000",result.get(i).getUser().getUserNo());
        assertEquals(1,result.get(i).getLibraryBook().getLbid());
        assertEquals("桑原晃弥",result.get(i).getLibraryBook().getAuthor());
        assertEquals("幻冬舎",result.get(i).getLibraryBook().getPublisher());
        assertEquals("フェイスブックをつくったザッカーバーグの仕事術",result.get(i).getLibraryBook().getBname());
        i = 5;
        assertEquals(6,result.get(i).getCid());
        assertEquals("3冊　借りる蔵",result.get(i).getUser().getUname());
        assertEquals("MAX888-456",result.get(i).getUser().getAddress());
        assertEquals("0120-3121-9999",result.get(i).getUser().getTel());
        assertEquals("100010",result.get(i).getUser().getUserNo());
        assertEquals(7,result.get(i).getLibraryBook().getLbid());
        assertEquals("井口耕二",result.get(i).getLibraryBook().getAuthor());
        assertEquals("帝国文学",result.get(i).getLibraryBook().getPublisher());
        assertEquals("ジェフ・ベゾス 果てなき野望",result.get(i).getLibraryBook().getBname());
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
		CirculationDB db = new CirculationDB();
		// 数
        assertEquals(0, db.getCirculationsOnIssueByUid(1).size());
        assertEquals(1, db.getCirculationsOnIssueByUid(2).size());
        assertEquals(1, db.getCirculationsOnIssueByUid(3).size());
        assertEquals(1, db.getCirculationsOnIssueByUid(4).size());
        assertEquals(3, db.getCirculationsOnIssueByUid(5).size());
	}

	/**
	 * {@link serv.CirculationDB#getLatestCirculation()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetLatestCirculation() {
		CirculationDB db = new CirculationDB();
		db.insert(2, 2);
		Circulation  result = new Circulation();
		result = db.getLatestCirculation();
        assertEquals("大阿蘇 次郎", result.getUser().getUname());
        assertEquals("あなたへの伝言", result.getLibraryBook().getBname());
        db.deleteForce(result.getCid());
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
