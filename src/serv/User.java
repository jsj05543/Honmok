/**
 *
 */
package serv;

/**
 * Userテーブルのフィールドを表現したクラス。Userテーブルから取り込んだデータは、このクラスのオブジェクトとなる。
 * Userテーブルの詳細は（ https://docs.google.com/spreadsheets/d/1q4n8OspzfguMMyw81PzMV2DuyXX8DAA5NSqxy6kBJ7c/edit#gid=0 ）
 *
 * @author Koji Hijikuro
 */
public class User {
	/**
	 * 利用者番号
	 */
	private String userNo;
	/**
	 * ユーザ名（利用者情報登録時の"氏名"情報）
	 */
	private String uname;
	/**
	 * 住所（利用者情報登録時の"住所"情報）
	 */
	private String address;
	/**
	 * 電話番号（利用者情報登録時の"電話番号"情報）
	 */
	private String tel;
	/**
	 * ユーザが3冊目を借りているかどうかの情報
	 */
	private Boolean limitFlag;
	/**
	 * 削除フラグ( ユーザ削除のときに削除される ）
	 */
	private Boolean deleteFlag;



	/**
	 * @return userNo
	 */
	public String getUserNo() {
		return userNo;
	}
	/**
	 * @param userNo セットする利用者番号
	 */
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	/**
	 * @return uname
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * @param uname セットする氏名
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * @return address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address セットする住所
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * @param tel セットする電話番号
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	/**
	 * @return limitFlag
	 */
	public Boolean getLimitFlag() {
		return limitFlag;
	}
	/**
	 * @param limitFlag セットする limitFlag
	 */
	public void setLimitFlag(Boolean limitFlag) {
		this.limitFlag = limitFlag;
	}
	/**
	 * @return deleteFlag
	 */
	public Boolean getDeleteFlag() {
		return deleteFlag;
	}
	/**
	 * @param deleteFlag セットする deleteFlag
	 */
	public void setDeleteFlag(Boolean deleteFlag) {
		this.deleteFlag = deleteFlag;
	}


}
