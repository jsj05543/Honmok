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
	 */
	@Test
	public void testGetUsers() {
	}

	/**
	 * {@link serv.UserDB#getUserDetail(int)} のためのテスト・メソッド。
	 */
	@Test
	public void testGetUserDetailInt() {
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
		// 2番目の該当
		assertEquals(5,result.get(1).getUid());
		assertEquals("3冊　借りる蔵",result.get(1).getUname());
		assertEquals("100010",result.get(1).getUserNo());
		assertEquals("MAX888-456",result.get(1).getAddress());
		assertEquals("0120-3121-9999",result.get(1).getTel());

	}


	/**
	 * {@link serv.UserDB#insert(java.lang.String, java.lang.String, java.lang.String, java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testInsert() {
	}

	/**
	 * {@link serv.UserDB#delete(int)} のためのテスト・メソッド。
	 */
	@Test
	public void testDelete() {
	}

	/**
	 * {@link serv.UserDB#deleteAll()} のためのテスト・メソッド。
	 */
	@Test
	public void testDeleteAll() {
	}

	/**
	 * {@link serv.UserDB#update(int, java.lang.String, java.lang.String, java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testUpdate() {
	}

	/**
	 * {@link serv.UserDB#usedUserNo(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testUsedUserNo() {
	}

}
