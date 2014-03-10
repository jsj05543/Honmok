/**
 *
 */
package serv;

/**
 * @author Koji Hijikuro
 * Bookテーブルのフィールドを表現したクラス。Bookテーブルから取り込んだデータは、Bookクラスに入る。
 * Bookテーブルの詳細は（https://docs.google.com/spreadsheets/d/1q4n8OspzfguMMyw81PzMV2DuyXX8DAA5NSqxy6kBJ7c/edit#gid=0）
 */
public class Book {
	private String isbn;        // ISBN番号（現時点では使用しない。予約フィールド）
	private String bname;       // 書籍名
	private String author;      // 著者
	private String publisher;   // 出版社
	private int page;           // ページ数（現時点では使用しない。予約フィールド）
	private Boolean deleteFlag; // 削除フラグ（現時点では使用しない。予約フィールド）
	/**
	 * @return isbn
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn セットする isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * @return bname
	 */
	public String getBname() {
		return bname;
	}
	/**
	 * @param bname セットする bname
	 */
	public void setBname(String bname) {
		this.bname = bname;
	}
	/**
	 * @return author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author セットする author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * @param publisher セットする publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * @return page
	 */
	public int getPage() {
		return page;
	}
	/**
	 * @param page セットする page
	 */
	public void setPage(int page) {
		this.page = page;
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
