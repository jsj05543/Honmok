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
	private int uid;
	/**
	 * 貸借本
	 */
	private int lbid;
	/**
	 * 削除フラグ
	 */
	private Boolean deleteFlag;
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
	public int getUid() {
		return uid;
	}
	/**
	 * @param uid セットする uid
	 */
	public void setUid(int uid) {
		this.uid = uid;
	}
	/**
	 * @return lbid
	 */
	public int getLbid() {
		return lbid;
	}
	/**
	 * @param lbid セットする lbid
	 */
	public void setLbid(int lbid) {
		this.lbid = lbid;
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
