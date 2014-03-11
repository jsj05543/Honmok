-- 既存データを削除
DELETE from users;
DELETE from books;
DELETE from libraryBooks;
DELETE from circulations;


SET NAMES utf8;

-- userデータを作成
INSERT INTO users ( userNo, uname, address, tel ) VALUES ( 100000, '肥後　太郎', '肥後123-456', '0120-1515-3776' );
INSERT INTO users ( userNo, uname, address, tel ) VALUES ( 100001, '大阿蘇 次郎', '阿蘇888-456', '0120-1515-4231' );
INSERT INTO users ( userNo, uname, address, tel ) VALUES ( 100008, '水前寺　花子', '水前寺888-456', '0120-3121-9999' );

-- book/libraryBooksデータを作成
SET @d = 0;

INSERT INTO books ( bname, author, publisher ) VALUES ( 'フェイスブックをつくったザッカーバーグの仕事術', '桑原晃弥', '幻冬舎' );
SET @d = (SELECT bid FROM books WHERE bname = 'フェイスブックをつくったザッカーバーグの仕事術' );
INSERT INTO libraryBooks ( bid, bookNo ) VALUES ( @d, 200000 );

INSERT INTO books ( bname, author, publisher ) VALUES ( 'あなたへの伝言', '高田郁', '幻冬舎' );
SET @d = (SELECT bid FROM books WHERE bname = 'あなたへの伝言' );
INSERT INTO libraryBooks ( bid, bookNo ) VALUES ( @d, 200001 );

INSERT INTO books ( bname, author, publisher ) VALUES ( '三毛猫ホームズは階段を上る', '赤川次郎', '光文社文庫' );
SET @d = (SELECT bid FROM books WHERE bname = '三毛猫ホームズは階段を上る' );
INSERT INTO libraryBooks ( bid, bookNo ) VALUES ( @d, 200002 );

INSERT INTO books ( bname, author, publisher ) VALUES ( '羅生門', '芥川竜之介', '帝国文学' );
SET @d = (SELECT bid FROM books WHERE bname = '羅生門' );
INSERT INTO libraryBooks ( bid, bookNo ) VALUES ( @d, 200003 );

-- circulationsデータを作成

-- 返却済み
INSERT INTO circulations ( issueDay, returnDay, uid, lbid ) VALUES ( '2014-03-10 13:49:22', '2014-03-10 15:49:22', 1, 1);
-- 貸し出し中
INSERT INTO circulations ( issueDay, uid, lbid ) VALUES ( '2014-03-11 15:49:22', 2, 2);
-- 貸し出し＆延滞
INSERT INTO circulations ( issueDay, uid, lbid ) VALUES ( '2014-02-01 15:49:22', 3, 3);