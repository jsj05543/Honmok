/************************************************************
 ************************************************************
 *
 * Honmokデータベース作成SQLファイル
 *    Author : Koji HIJIKURO <koji0903@gmail.com>  
 *
 ************************************************************
 *************************************************************/

-- データベースの作成（既存のデータベースはいったん削除）
DROP DATABASE IF EXISTS honmokdb;
CREATE DATABASE honmokdb;
USE honmokdb;

/************************************************************
 *
 * テーブル作成
 * フィールドの詳細は、"https://docs.google.com/spreadsheets/d/1q4n8OspzfguMMyw81PzMV2DuyXX8DAA5NSqxy6kBJ7c/edit#gid=0"参照
 *
 ************************************************************/

-- userテーブル
CREATE TABLE users
(
	uid INT PRIMARY KEY NOT NULL AUTO_INCREMENT, 
	rid INT NOT NULL UNIQUE, 
	uname VARCHAR(50) NOT NULL,
	address VARCHAR(50) NOT NULL,
	tel VARCHAR(30) NOT NULL,
	limitFlag BOOLEAN NOT NULL DEFAULT FALSE,
	deleteFlag BOOLEAN NOT NULL DEFAULT FALSE
);

-- bookテーブル
CREATE TABLE books
(
	bid INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	isbn INT,
	bname VARCHAR(30) NOT NULL,
	author VARCHAR(30) NOT NULL,
	publisher VARCHAR(30) NOT NULL,
	page INT,
	deleteFlag BOOLEAN NOT NULL DEFAULT FALSE
);
-- circulationテーブル
CREATE TABLE circulations
(
	cid INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
	issueDay DATETIME NOT NULL,
	returnDay DATETIME,
	uid INT NOT NULL,
	bid INT NOT NULL,
	term INT DEFAULT 7,
	deleteFlag BOOLEAN NOT NULL DEFAULT FALSE
);