/**
 *
 */
package serv;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 利用者番号の発行を管理するクラス
 * @author sakuragi
 *
 */
public class UserNo {
	private static int MAX_NUM = 9999;
	private static String prefixChar = "U";
	private static String prefixNum  = "001";
	private static String DATE_FORMAT ="yyMMdd";
	private static String NUM_FORMAT = "%04d";
	private String str_date;
	private int num;
	private String userNo;

	/**
	 * コンストラクタ（日付文字列はここで作る）
	 */
	public UserNo() {
		num = -1;
		Calendar calendar = Calendar.getInstance();
		str_date = (new SimpleDateFormat(DATE_FORMAT)).format(calendar.getTime());
	}

	/**
	 * 利用者番号（U001-yyyyMMdd0000）を発行する
	 * @return String 利用者番号
	 * @return null 発行数の上限を超えた場合
	 */
	public String createUserNo () {
		num++;
		if ( num > MAX_NUM ) {
			return null;
		}
		userNo = prefixChar + prefixNum + "-" + str_date + String.format(NUM_FORMAT, num);
		return userNo;
	}

}
