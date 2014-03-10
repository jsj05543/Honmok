/**
 *
 */
package serv;

/**
 * Bookテーブルのフィールドを表現したクラス。Bookテーブルから取り込んだデータは、このクラスのオブジェクトとなる。
 * Bookテーブルの詳細は（ https://docs.google.com/spreadsheets/d/1q4n8OspzfguMMyw81PzMV2DuyXX8DAA5NSqxy6kBJ7c/edit#gid=0 ）
 *
 * @author Koji Hijikuro
 */
public class Book {
	/**
	 * ISBN番号（現時点では使用しない。予約フィールド）
	 */
	private String isbn;
	/**
	 * 書籍名
	 */
	private String bname;
	/**
	 * 著者
	 */
	private String author;
	/**
	 * 出版社
	 */
	private String publisher;
	/**
	 * ページ数（現時点では使用しない。予約フィールド）
	 */
	private int page;
	/**
	 * 削除フラグ（本情報を削除する場合に、値にTRUEをセットする。）
	 */
	private Boolean deleteFlag;


	/**
	 * @return isbn ISBN番号
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * @param isbn セットするISBN番号
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
	 * @param bname セットする書籍名
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
	 * @param author セットする著者名
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
	 * @param publisher セットする出版社名
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
	 * @param page セットするページ数
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
