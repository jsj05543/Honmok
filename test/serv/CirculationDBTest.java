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
		// データの数をチェック
        assertEquals(7, result.size());
        // 一番目のデータの詳細をチェック
        int i = 0;
        assertEquals(1,result.get(i).getCid());
        assertEquals("肥後　太郎",result.get(i).getUser().getUname());
        assertEquals("肥後123-456",result.get(i).getUser().getAddress());
        assertEquals("0120-1515-3776",result.get(i).getUser().getTel());
        assertEquals("U001-1401010001",result.get(i).getUser().getUserNo());
        assertEquals(1,result.get(i).getLibraryBook().getLbid());
        assertEquals("桑原晃弥",result.get(i).getLibraryBook().getAuthor());
        assertEquals("幻冬舎",result.get(i).getLibraryBook().getPublisher());
        assertEquals("フェイスブックをつくったザッカーバーグの仕事術",result.get(i).getLibraryBook().getBname());
        // 五番目データの詳細をチェック
        i = 5;
        assertEquals(6,result.get(i).getCid());
        assertEquals("3冊　借りる蔵",result.get(i).getUser().getUname());
        assertEquals("MAX888-456",result.get(i).getUser().getAddress());
        assertEquals("0120-3121-9999",result.get(i).getUser().getTel());
        assertEquals("U001-1401010005",result.get(i).getUser().getUserNo());
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
		// データの数をチェック
        assertEquals(8, db.getCirculations(true).size());
		// データの数をチェック
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
		// それぞれのUIDに対して該当するデータの数をチェック
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
		// テスト用のデータを挿入
		db.insert(2, 2);
		Circulation  result = new Circulation();
		result = db.getLatestCirculation();
        assertEquals("大阿蘇 次郎", result.getUser().getUname());
        assertEquals("あなたへの伝言", result.getLibraryBook().getBname());
        // 後処理。挿入したデータを削除（DELETE)
        db.deleteForce(result.getCid());
	}

	/**
	 * {@link serv.CirculationDB#getCirculationOnIssueByBookNo()} のためのテスト・メソッド。
	 */
	@Test
	public void testGetCirculationOnIssueByBookNo() {
		CirculationDB db = new CirculationDB();
		Circulation  result = new Circulation();
		result = db.getCirculationOnIssueByBookNo("B001-1401019999");
        assertEquals("3冊　借りる蔵", result.getUser().getUname());
        assertEquals("ビジネスモデル・イノベーション", result.getLibraryBook().getBname());
	}


	/**
	 * {@link serv.CirculationDB#canRent(java.lang.String)} のためのテスト・メソッド。
	 * 利用者番号を指定して、メソッドの戻り値を判定。trueが返る場合と、falseが返る場合をチェック
	 */
	@Test
	public void testCanRent() {
		CirculationDB db = new CirculationDB();
		assertEquals(true,db.canRent("U001-1401010001"));
		assertEquals(false,db.canRent("U001-1401010005"));
	}

	/**
	 * {@link serv.CirculationDB#insert(int, int)} のためのテスト・メソッド。
	 * データを挿入して、戻り値をチェック
	 */
	@Test
	public void testInsert() {
		CirculationDB db = new CirculationDB();
		assertEquals(1,db.insert(2, 2));
        // 後処理。挿入したデータを削除（DELETE)
        db.deleteForce(db.getLatestCirculation().getCid());
	}

	/**
	 * {@link serv.CirculationDB#delete(int)} のためのテスト・メソッド。
	 * データを削除して、戻り値をチェック
	 */
	@Test
	public void testDelete() {
		CirculationDB db = new CirculationDB();
		db.insert(2, 2);
		int cid = db.getLatestCirculation().getCid();
		assertEquals(1,db.delete(cid));
        // 後処理。挿入したデータを削除（DELETE)
        db.deleteForce(cid);
	}

	/**
	 * {@link serv.CirculationDB#deleteAll()} のためのテスト・メソッド。
	 */
	@Test
	public void testDeleteAll() {
	}

	/**
	 * {@link serv.CirculationDB#update(int)} のためのテスト・メソッド。
	 * - 返却処理を行って、1が返ってくること。かつ、その貸し出し情報の中身もチェック
	 */
	@Test
	public void testUpdate() {
		CirculationDB db = new CirculationDB();

		// 貸し出し処理
		db.insert(2, 4);
		// 異常な返却処理
		assertEquals(0,db.update(-1));
		// 正常な返却処理
		int cid = db.getCirculationOnIssueByBookNo("B001-1401015013").getCid();
		assertEquals(1,db.update(cid));
		// 各内容をチェック
		Circulation result = db.getCirculationDetailByCid(cid);
		assertEquals("大阿蘇 次郎",result.getUser().getUname());
		assertEquals("羅生門",result.getLibraryBook().getBname());
		assertNotNull(result.getReturnDay());
        // 後処理。挿入したデータを削除（DELETE)
        db.deleteForce(cid);
	}

}
