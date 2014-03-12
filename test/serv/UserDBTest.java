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
		for( int i = 0; i < result.size(); i++ )
		{
			assertEquals("肥後　太郎",result.get(i).getUname());
			assertEquals("100000",result.get(i).getUserNo());
		}
		/*
		 * 該当したデータが配列で返る。複数該当
		 */
		/*
		ArrayList<User> result = db.getUserDetailByUname("肥後　太郎");
		for( int i = 0; i < result.size(); i++ )
		{
			assertEquals("肥後　太郎",result.get(i).getUname());
			assertEquals("100000",result.get(i).getUserNo());
		}
		*/
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
