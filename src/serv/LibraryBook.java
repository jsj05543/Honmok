/**
 *
 */
package serv;

/**
 * LibraryBookテーブルのフィールドを表現したクラス。LibraryBookテーブルから取り込んだデータは、このクラスのオブジェクトとなる。
 * LibraryBookテーブルの詳細は（ https://docs.google.com/spreadsheets/d/1q4n8OspzfguMMyw81PzMV2DuyXX8DAA5NSqxy6kBJ7c/edit#gid=0 ）
 *
 * @author Koji Hijikuro
 */
public class LibraryBook extends Book{
	/**
	 * Bookテーブルを指すID
	 */
	private int bid;
	/**
	 * 図書館管理用の書籍番号
	 */
	private String bookNo;
	/**
	 * 削除フラグ（本情報を削除する場合に、値にTRUEをセットする。）
	 */
	private Boolean deleteFlag;

	/**
	 * @return bid
	 */
	public int getBid() {
		return bid;
	}
	/**
	 * @param bid セットするBookテーブルID
	 */
	public void setBid(int bid) {
		this.bid = bid;
	}
	/**
	 * @return bookNo
	 */
	public String getBookNo() {
		return bookNo;
	}
	/**
	 * @param bookNo セットする書籍番号
	 */
	public void setBookNo(String bookNo) {
		this.bookNo = bookNo;
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
