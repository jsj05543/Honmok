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
INSERT INTO users ( userNo, uname, address, tel ) VALUES ( 100009, '延滞　する蔵', '延滞町888-456', '0120-3121-9999' );
INSERT INTO users ( userNo, uname, address, tel ) VALUES ( 100010, '3冊　借りる蔵', 'MAX888-456', '0120-3121-9999' );
INSERT INTO users ( userNo, uname, address, tel , deleteFlag) VALUES ( 100100, '削除　された蔵', 'DEL888-456', '0120-3121-8888', TRUE );

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

INSERT INTO books ( bname, author, publisher ) VALUES ( 'まんがでわかる7つの習慣', 'フランクリン・コヴィー・ジャパン', '帝国文学' );
SET @d = (SELECT bid FROM books WHERE bname = 'まんがでわかる7つの習慣' );
INSERT INTO libraryBooks ( bid, bookNo ) VALUES ( @d, 200004 );

INSERT INTO books ( bname, author, publisher ) VALUES ( '稲盛和夫の経営問答 従業員をやる気にさせる7つのカギ', '稲盛 和夫', '帝国文学' );
SET @d = (SELECT bid FROM books WHERE bname = '稲盛和夫の経営問答 従業員をやる気にさせる7つのカギ' );
INSERT INTO libraryBooks ( bid, bookNo ) VALUES ( @d, 200005 );

INSERT INTO books ( bname, author, publisher ) VALUES ( 'ジェフ・ベゾス 果てなき野望', '井口耕二', '帝国文学' );
SET @d = (SELECT bid FROM books WHERE bname = 'ジェフ・ベゾス 果てなき野望' );
INSERT INTO libraryBooks ( bid, bookNo ) VALUES ( @d, 200006 );

INSERT INTO books ( bname, author, publisher ) VALUES ( 'ビジネスモデル・イノベーション', '藤井清美', '帝国文学' );
SET @d = (SELECT bid FROM books WHERE bname = 'ビジネスモデル・イノベーション' );
INSERT INTO libraryBooks ( bid, bookNo ) VALUES ( @d, 200007 );

-- circulationsデータを作成
SET @d = now() - INTERVAL 2 DAY;
-- 返却済み
INSERT INTO circulations ( issueDay, returnDay, uid, lbid ) VALUES ( '2014-03-10 13:49:22', '2014-03-10 15:49:22', 1, 1);
-- 貸し出し中
INSERT INTO circulations ( issueDay, uid, lbid ) VALUES ( @d, 2, 2 );
-- 貸し出し＆延滞
INSERT INTO circulations ( issueDay, uid, lbid ) VALUES ( '2014-02-01 15:49:22', 3, 3 );
SET @d = now() - INTERVAL 7 DAY;
INSERT INTO circulations ( issueDay, uid, lbid ) VALUES ( @d, 4, 3 );
-- 3冊借りている状態
SET @d = now() - INTERVAL 2 DAY;
INSERT INTO circulations ( issueDay, uid, lbid ) VALUES ( @d, 5, 6 );
INSERT INTO circulations ( issueDay, uid, lbid ) VALUES ( @d, 5, 7 );
INSERT INTO circulations ( issueDay, uid, lbid ) VALUES ( @d, 5, 8 );
-- 削除済み
INSERT INTO circulations ( issueDay, returnDay, uid, lbid, deleteFlag ) VALUES ( '2014-02-10 13:49:22', '2014-02-10 15:49:22', 1, 1, true);
