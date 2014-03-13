/**
 *
 */
package serv;

import java.sql.Timestamp;

/**
 * Circulationテーブルのフィールドを表現したクラス。Circulationテーブルから取り込んだデータは、このクラスのオブジェクトとなる。
 * Circulationテーブルの詳細は（ https://docs.google.com/spreadsheets/d/1q4n8OspzfguMMyw81PzMV2DuyXX8DAA5NSqxy6kBJ7c/edit#gid=0 ）
 *
 * @author Koji Hijikuro
 */
public class Circulation {
	/**
	 * Circulation ID
	 */
	private int cid;
	/**
	 * 貸出日
	 */
	private Timestamp issueDay;
	/**
	 * 返却日
	 */
	private Timestamp returnDay;
	/**
	 * 貸借人
	 */
	private User user;
	/**
	 * 貸借本
	 */
	private LibraryBook librarybook;
	/**
	 * 削除フラグ
	 */
	private Boolean deleteFlag;


	/**
	 * @return cid
	 */
	public int getCid() {
		return cid;
	}
	/**
	 * @param cid セットする cid
	 */
	public void setCid(int cid) {
		this.cid = cid;
	}
	/**
	 * @return issueDay
	 */
	public Timestamp getIssueDay() {
		return issueDay;
	}
	/**
	 * @param issueDay セットする貸出日
	 */
	public void setIssueDay(Timestamp issueDay) {
		this.issueDay = issueDay;
	}
	/**
	 * @return returnDay
	 */
	public Timestamp getReturnDay() {
		return returnDay;
	}
	/**
	 * @param returnDay セットする返却日
	 */
	public void setReturnDay(Timestamp returnDay) {
		this.returnDay = returnDay;
	}
	/**
	 * @return uid
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user セットするUserオブジェクト
	 */
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * @return lbid
	 */
	public LibraryBook getLibraryBook() {
		return librarybook;
	}
	/**
	 * @param librarybook セットするLibraryBookオブジェクト
	 */
	public void setLibraryBook(LibraryBook librarybook) {
		this.librarybook = librarybook;
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
