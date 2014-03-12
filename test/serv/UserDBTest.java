/**
 *
 */
package serv;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import org.junit.Test;

/**
 * @author Koji HIJIKURO
 *
 */
public class UserDBTest {

	/**
	 * {@link serv.UserDB#getUsers()} のためのテスト・メソッド。
	 * 正常系：テストデータとして既に入れている情報が取得できることを確認する。
	 * 異常系：なし
	 */
	@Test
	public void testGetUsers() {
		UserDB db = new UserDB();
		// 数
        assertEquals(5, db.getUsers().size());

        // 一人目
        assertEquals(1, db.getUsers().get(0).getUid());
        assertEquals("肥後　太郎", db.getUsers().get(0).getUname());
        assertEquals("肥後123-456", db.getUsers().get(0).getAddress());
        assertEquals("0120-1515-3776", db.getUsers().get(0).getTel());
        assertEquals(false, db.getUsers().get(0).getLimitFlag());
        // 二人目
        assertEquals(2, db.getUsers().get(1).getUid());
        assertEquals("大阿蘇 次郎", db.getUsers().get(1).getUname());
        assertEquals("阿蘇888-456", db.getUsers().get(1).getAddress());
        assertEquals("0120-1515-4231", db.getUsers().get(1).getTel());
        assertEquals(false, db.getUsers().get(1).getLimitFlag());
        // 三人目
        assertEquals(3, db.getUsers().get(2).getUid());
        assertEquals("水前寺　花子", db.getUsers().get(2).getUname());
        assertEquals("水前寺888-456", db.getUsers().get(2).getAddress());
        assertEquals("0120-3121-9999", db.getUsers().get(2).getTel());
        assertEquals(false, db.getUsers().get(2).getLimitFlag());
        // 四人目
        assertEquals(4, db.getUsers().get(3).getUid());
        assertEquals("延滞　する蔵", db.getUsers().get(3).getUname());
        assertEquals("延滞町888-456", db.getUsers().get(3).getAddress());
        assertEquals("0120-3121-9999", db.getUsers().get(3).getTel());
        assertEquals(false, db.getUsers().get(3).getLimitFlag());
        // 五人目
        assertEquals(5, db.getUsers().get(4).getUid());
        assertEquals("3冊　借りる蔵", db.getUsers().get(4).getUname());
        assertEquals("MAX888-456", db.getUsers().get(4).getAddress());
        assertEquals("0120-3121-9999", db.getUsers().get(4).getTel());
        assertEquals(false, db.getUsers().get(4).getLimitFlag());

	}

	/**
	 * {@link serv.UserDB#getUsers()} のためのテスト・メソッド。
	 * 正常系：テストデータとして既に入れている情報が取得できることを確認する。
	 * 異常系：なし
	 */
	@Test
	public void testGetUsersAll() {
		UserDB db = new UserDB();
		// 数
        assertEquals(6, db.getUsers(true).size());

        // 六人目
        assertEquals(6, db.getUsers(true).get(5).getUid());
        assertEquals("削除　された蔵", db.getUsers(true).get(5).getUname());
        assertEquals("DEL888-456", db.getUsers(true).get(5).getAddress());
        assertEquals("0120-3121-8888", db.getUsers(true).get(5).getTel());
        assertEquals(false, db.getUsers(true).get(5).getLimitFlag());
        assertEquals(true, db.getUsers(true).get(5).getDeleteFlag());
	}

	/**
	 * {@link serv.UserDB#getUserDetail(int)} のためのテスト・メソッド。
	 */
	@Test
	public void testGetUserDetailInt() {
		UserDB db = new UserDB();
	}

	/**
	 * {@link serv.UserDB#isSameData()} のためのテスト・メソッド。
	 *  - 同一情報がない場合は、falseが返ってくること
	 *  - 全ての情報が同じ場合は、trueが返ってくること
	 */
	@Test
	public void testIsSameData() throws NoSuchMethodException,
    SecurityException,
    IllegalAccessException,
    IllegalArgumentException,
    InvocationTargetException
    {
		Method method =  UserDB.class.getDeclaredMethod("isSameData", String.class, String.class, String.class);

        // trueをセットすることで、privateメソッドへアクセス可能となります。
        method.setAccessible(true);

        // privateメソッドを実行します。
        UserDB db = new UserDB();

        Boolean result;
        // Case 1 : 同一情報がない場合
        result = (Boolean)method.invoke(db, new String("aa"), new String("bb"), new String("cc"));
        assertEquals(false, result);
        // Case 2 : ひとつか異なる場合
        result = (Boolean)method.invoke(db, new String("肥後太郎"), new String("肥後123-456"), new String("0120-1515-3776"));
        assertEquals(false, result);
        // Case 3 : ひとつが異なる場合
        result = (Boolean)method.invoke(db, new String("肥後　太郎"), new String("肥後123456"), new String("0120-1515-3776"));
        // Case 4 : ひとつが異なる場合
        result = (Boolean)method.invoke(db, new String("肥後　太郎"), new String("肥後123-456"), new String("01201515-3776"));
        assertEquals(false, result);
        // Case 5 : 全てが同一である場合
        result = (Boolean)method.invoke(db, new String("肥後　太郎"), new String("肥後123-456"), new String("0120-1515-3776"));
        assertEquals(true, result);
	}

	/**
	 * {@link serv.UserDB#getUserDetail(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testGetUserDetailString() {
		UserDB db = new UserDB();
	}

	/**
	 * {@link serv.UserDB#getUserDetailByUname(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testGetUserDetailByUname() {
		UserDB db = new UserDB();
		/**
		 * 該当しない氏名を入力した場合はNullが返る。
		 */
		assertEquals(null, db.getUserDetailByUname("aa"));
		assertEquals(null, db.getUserDetailByUname("大阿蘇村"));
		assertEquals(null, db.getUserDetailByUname("肥後123-45"));
		/*
		 * 該当したデータが配列で返る。1件該当
		 */
		ArrayList<User> result = db.getUserDetailByUname("肥後　太郎");
		assertEquals(1,result.get(0).getUid());
		assertEquals("肥後　太郎",result.get(0).getUname());
		assertEquals("100000",result.get(0).getUserNo());
		assertEquals("肥後123-456",result.get(0).getAddress());
		assertEquals("0120-1515-3776",result.get(0).getTel());
		assertEquals(false,result.get(0).getLimitFlag());
		assertEquals(false,result.get(0).getDeleteFlag());
		/*
		 * 該当したデータが配列で返る。複数該当
		 */
		result = db.getUserDetailByUname("蔵");
		// 1番目の該当
		assertEquals(4,result.get(0).getUid());
		assertEquals("延滞　する蔵",result.get(0).getUname());
		assertEquals("100009",result.get(0).getUserNo());
		assertEquals("延滞町888-456",result.get(0).getAddress());
		assertEquals("0120-3121-9999",result.get(0).getTel());
		assertEquals(false,result.get(0).getLimitFlag());
		assertEquals(false,result.get(0).getDeleteFlag());
		// 2番目の該当
		assertEquals(5,result.get(1).getUid());
		assertEquals("3冊　借りる蔵",result.get(1).getUname());
		assertEquals("100010",result.get(1).getUserNo());
		assertEquals("MAX888-456",result.get(1).getAddress());
		assertEquals("0120-3121-9999",result.get(1).getTel());
		assertEquals(false,result.get(1).getLimitFlag());
		assertEquals(false,result.get(1).getDeleteFlag());

	}


	/**
	 * {@link serv.UserDB#insert(java.lang.String, java.lang.String, java.lang.String, java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testInsert() {
		UserDB db = new UserDB();
	}

	/**
	 * {@link serv.UserDB#delete(int)} のためのテスト・メソッド。
	 */
	@Test
	public void testDelete() {
		UserDB db = new UserDB();
	}

	/**
	 * {@link serv.UserDB#deleteAll()} のためのテスト・メソッド。
	 */
	@Test
	public void testDeleteAll() {
		UserDB db = new UserDB();
	}

	/**
	 * {@link serv.UserDB#update(int, java.lang.String, java.lang.String, java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testUpdate() {
		UserDB db = new UserDB();
	}

	/**
	 * {@link serv.UserDB#usedUserNo(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testUsedUserNo() {
		UserDB db = new UserDB();
	}

}
