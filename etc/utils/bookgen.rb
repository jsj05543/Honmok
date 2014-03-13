#!/usr/bin/env ruby
# coding: utf-8
#
# ----------------------------------------------------------------------------
# The MIT License
#
# Copyright (c) 2010 MAEDA Go
# 
# Permission is hereby granted, free of charge, to any person obtaining a copy
# of this software and associated documentation files (the "Software"), to deal
# in the Software without restriction, including without limitation the rights
# to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
# copies of the Software, and to permit persons to whom the Software is
# furnished to do so, subject to the following conditions:
# 
# The above copyright notice and this permission notice shall be included in
# all copies or substantial portions of the Software.
# 
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
# IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
# FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
# AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
# LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
# OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
# THE SOFTWARE.
# ----------------------------------------------------------------------------
require 'securerandom'

SEI = %w(
一圓
一色
一関
三上
三原
三和
三好
三宅
三島
三嶋
三木
三村
三枝
三浦
三瀧
三角
三谷
三輪
三須
上
上元
上原
上坂
上埜
上山
上岡
上島
上念
上木
上本
上林
上森
上田
上茶谷
上野
上領
下村
下森
下田
下見
中
中ノ瀬
中井
中元
中務
中原
中司
中園
中塚
中尾
中山
中島
中嶋
中川
中川路
中平
中村
中条
中林
中橋
中澤
中田
中筋
中西
中谷
中貝
中越
中辻
中郷
中野
丸安
丸尾
丸山
丸本
丸林
丸谷
丹羽
久保
久保田
久岡
久常
久後
久松
久米
久谷
久間
九鬼
亀井
亀山
亀田
五代
五十嵐
五島
井上
井之上
井内
井原
井口
井戸
井本
井村
井澤
井町
井門
井関
井阪
京保
人見
仁木
今井
今岡
今川
今本
今村
今田
今藤
今西
仙波
以倉
仲
仲尾
仲島
仲村
仲田
任勢
伊丹
伊井
伊原
伊志嶺
伊藤
伊賀
伊賀上
伊達
伊集
会所
伴野
住岡
住田
佐々木
佐々野
佐久間
佐伯
佐古
佐喜本
佐竹
佐藤
佐野
來女木
依田
依藤
保尾
倉橋
倉田
倉谷
元藤
光岡
光嶋
光延
光森
児嶋
児玉
入江
全
全本
八木
八瀬
八納
八重尾
六峰
六車
共田
兼田
内川
内海
内田
内藤
冨元
冨士枝
冨尾
冨永
出口
出島
出西
出雲
別府
別所
前中
前川
前田
前野
副田
加奥
加川
加藤
勝井
勝屋
勝山
勝谷
勝部
北
北中
北出
北原
北口
北尾
北山
北島
北嶋
北川
北本
北村
北條
北浦
北西
北野
匡
十家
十河
千村
千田
半田
南
南埜
南山
南本
南石
南角
南谷
南野
卜部
厚東
原
原田
友中
友安
友川
友成
友景
友松
友田
古原
古寺
古屋
古岩
古島
古川
古本
古林
古淵
古田
古藤
古谷
古賀
古都
古里
古野
右田
吉
吉井
吉原
吉奥
吉岡
吉川
吉成
吉末
吉本
吉村
吉水
吉津
吉田
吉良
吉荒
吉野
名倉
吐合
向井
向坂
向山
吾郷
呉
和倉
和田
品田
唐木
四方
四郎丸
国松
國司
國富
國村
國橋
國米
國谷
園
園田
圓山
土井
土屋
土明
土橋
土江
土肥
土路生
坂上
坂井
坂元
坂口
坂本
坂田
坂部
坪井
坪田
城後
城田
城野
堀
堀上
堀井
堀内
堀口
堀川
堀江
堀田
堂山
堂庭
堤
塔筋
塚本
塩月
塩田
塩見
塩路
増上
増井
増田
墨田
壬生
外囿
夘田
多久和
多田
多田羅
大中
大久保
大井
大友
大和
大和田
大坪
大堀
大塚
大塩
大多和
大子
大宅
大宮路
大居
大岡
大島
大川
大平
大志万
大曲
大月
大木
大村
大森
大橋
大江
大津
大浦
大澤
大畠
大石
大竹
大西
大谷
大道
大里
大野
大野木
大針
天川
天白
太田
太麻
夷
奥
奥出
奥原
奥山
奥川
奥村
奥田
奥西
奥谷
奥迫
奥野
好川
妹尾
姫野
威徳井
嬉野
宇山
宇川
宇根川
宇治
宇津木
宇畑
宇野
守安
守藤
守谷
安中
安井
安堂
安宅
安川
安延
安東
安楽
安河内
安田
安福
安藝
安藤
安道
安達
安部
安間
宍戸
実光
室
宮下
宮井
宮原
宮原田
宮城
宮家
宮尾
宮崎
宮嶌
宮川
宮平
宮後
宮本
宮村
宮永
宮田
宮脇
宮西
宮野
家
富本
富松
富田
富重
實原
寺井
寺内
寺島
寺崎
寺本
寺村
寺田
寺西
小井
小俣
小倉
小原
小坂
小塚
小室
小宮
小山
小島
小嶋
小川
小木曽
小杉
小松
小林
小森
小橋
小池
小河原
小泉
小清水
小湊
小澤
小玉
小田
小畑
小笠原
小薗
小西
小見山
小谷
小野
小黒
尼ヶ崎
尾上
尾崎
尾形
尾花
尾野
尾鼻
屠
山ヵ
山下
山中
山元
山内
山北
山口
山名
山室
山岡
山崎
山川
山本
山村
山東
山根
山森
山水
山河
山浦
山田
山谷
山越
山里
山野
山際
岡
岡ヵ
岡下
岡井
岡崎
岡本
岡村
岡田
岡藤
岡谷
岡部
岩ヵ
岩井
岩井迫
岩佐
岩城
岩尾
岩山
岩崎
岩本
岩村
岩永
岩波
岩田
岩見
岩谷
岩重
岩野
岸
岸上
岸本
岸村
岸田
峰尾
島岡
島崎
島本
島津
島田
崔
嶋岡
嶌岡
川ヵ
川上
川井
川勝
川原
川口
川名
川島
川崎
川嶋
川本
川村
川森
川瀬
川田
川端
川西
川野
工藤
巴
巻尾
市坪
市岡
市川
市成
市田
布施
常包
常盤
平井
平出
平向
平尾
平山
平岡
平岩
平川
平木
平松
平林
平澤
平田
平野
年盛
広瀬
広田
庄田
廣
廣兼
廣原
廣島
廣瀬
廣田
廣野
延原
引地
形山
後藤
徐
得津
御手洗
徳光
徳松
徳永
徳田
志和
志磨
惠
惣定
愛須
慶島
應谷
成川
成松
成瀬
成願
戸成
戸次
戸田
戸部
折出
折田
抱
持田
指方
捻金
揚
数井
斉藤
斎藤
斧山
新井
新保
新川
新谷
日下
日下部
日向
日岡
日比
日置
日高
早原
早瀬
早石
明渡
明石
星住
星川
星野
春澤
是久
時岡
時本
景山
曽我部
月村
有光
有冨
有川
有方
有本
有松
有馬
服部
望月
朝井
朝倉
朝尾
朝日
朝比奈
朝間
木ヵ
木下
木原
木山
木戸口
木暮
木本
木村
木林
木田
木良
末光
末富
末広
末廣
末次
末永
末満
本田
本間
朴
杉
杉井
杉原
杉山
杉岡
杉本
杉江
杉浦
杉谷
杉野
李
村上
村中
村井
村嶋
村田
来住
来海
東
東向
東山
東條
東矢
東野
松ヵ
松下
松井
松元
松原
松場
松塚
松宮
松尾
松山
松岡
松島
松崎
松川
松廣
松木
松本
松村
松林
松永
松沼
松浦
松田
松葉
板橋
板金
林
林田
柏井
柏木
柚江
柞磨
柳
柳内
柳川
柳本
柳瀬
柳田
柴田
柿園
柿本
柿窪
柿谷
栃本
栄
栗原
栗山
栗本
栗栖
栗田
根木
根本
根石
桂
桂木
桐山
桑原
桑島
桑木野
桑本
桑田
桶川
梅ヵ
梅原
梅景
梅林
梅澤
梅田
梅谷
梶山
梶岡
梶谷
森
森下
森中
森井
森山
森岡
森崎
森川
森戸
森方
森本
森田
森脇
森迫
森重
森野
椋本
椋田
植原
植木
植村
植田
植良
植野
椎本
椎谷
椿
椿野
楊
楠
楠戸
楠木
楠本
楠田
楠見
楢原
榎木
榎本
槇
槇野
樋口
横井
横尾
横山
横田
樹林
樹野
樽谷
橋元
橋木
橋本
橋爪
橋田
橘
檜山
檜田
櫻井
櫻木
正保
正森
武内
武山
武田
武者小路
武部
段
毎熊
毛利
氏原
民秋
水内
水原
水岡
水森
水沼
水田
水谷
水野
永井
永元
永原
永吉
永尾
永岡
永島
永座
永田
永砂
永見
永谷
江ヵ
江上
江國
江坂
江守
江川
江浪
江馬
池
池上
池下
池中
池内
池本
池永
池田
池神
沢井
河下
河井
河内
河原
河原崎
河合
河尻
河崎
河本
河村
河渕
河田
河野
沼本
泉
泉家
波田
波野
津ヵ
津岡
津島
津田
洪
浅井
浅利
浅田
浅谷
浅野
浜口
浜崎
浜田
浦
浦島
浦川
浦田
浦郷
浦野
海老澤
深口
深堀
深山
深江
深澤
深瀬
淺井
添田
清原
清宮
清水
清水谷
渋谷
渕山
渡辺
渡邉
渡邊
渡部
温井
湯口
湯川
湯浅
源田
溝川
溝端
滝澤
潤井
澤
澤入
澤田
濱
濱中
濱井
濱村
濱浦
濱田
瀧
瀧口
瀧川
瀧本
瀬尾
瀬藤
灰庭
炭谷
照尾
熊城
片寄
片山
片岡
牛原
牧之内
牧山
牧村
牧浦
犬塚
狩野
狭川
狭間
猪原
猪野
猪飼
猶原
猿渡
玉井
玉牧
玉田
王
王本
環
瓦谷
生賀
生駒
田中
田丸
田井
田代
田仲
田原
田口
田和
田坂
田嶋
田川
田村
田淵
田渕
田畑
田窪
田財
田路
田辺
田邉
田邊
田部
田阪
田頭
由留木
畑
畑中
畑崎
畑村
畠中
當山
疋田
発知
白井
白山
白岩
白川
白木
白根
白石
的早
益田
盛岡
盛田
相田
相良
眞田
真西
真鍋
矢口
矢吹
矢嶋
矢野
矢鍋
石丸
石井
石倉
石原
石岡
石崎
石川
石本
石橋
石灰
石田
石碕
石金
砂川
砂村
砂田
磯田
磯部
礒山
礒谷
神原
神吉
神垣
神徳
神戸
神波
神田
神野
福井
福元
福原
福城
福山
福島
福嶋
福川
福本
福永
福田
福間
秀
秋山
秋田
秋葉
秋道
秦
秦野
程野
稲垣
稲木
稲毛
稲津
稲田
稲留
稲葉
稲角
穴吹
穴釜
窪田
立川
立成
立野
竹上
竹中
竹元
竹内
竹安
竹岡
竹林
竹治
竹澤
竹田
笠原
笠嶋
笹井
笹部
箱上
篠池
篠田
簗田
米原
米本
米沢
米田
粂
粕谷
糟谷
糸井
糸畑
系谷
紀本
細井
細川
細目
緒方
縄舟
繁本
織田
置田
美濃
美田
美馬
羽尻
羽山
羽田
羽立
羽野
耕
肥田
胡内
胤森
能勢
能口
能澤
脇
脇坂
脇田
舛田
舩木
船橋
船留
芋野
芝
芝好
芦達
花田
花登
芳山
芳崎
芳澤
若宮
若松
若林
若江
若生
草川
荒井
荒山
荒川
荒木
荒谷
荻野
菅
菅井
菅原
菅村
菅沼
菅生
菅田
菅野
菊地
菊池
菱沼
菱田
萩原
萬野
萱野
落司
葉室
葉山
葛井
葛原
蔦原
蔵田
薄井
薫森
藤
藤上
藤中
藤井
藤代
藤原
藤宮
藤山
藤岡
藤崎
藤嶋
藤川
藤木
藤本
藤村
藤浪
藤澤
藤田
藤谷
藩
衣斐
衣笠
裏谷
西
西久保
西井
西原
西口
西垣
西場
西塚
西尾
西山
西岡
西島
西崎
西川
西本
西村
西東
西森
西浦
西海
西澤
西田
西端
西脇
西見
西谷
西邑
西部
西野
西願
見吉
角
角川
角田
角谷
諸林
谷
谷井
谷全
谷原
谷口
谷垣
谷奥
谷孝
谷岡
谷本
谷村
谷澤
谷田
谷藤
豊口
豊島
豊田
豊福
貫定
貴島
貴田
賀谷
赤井
赤松
赤澤
赤田
赤見
赤谷
赤金
越智
越谷
辰己
辰巳
辻
辻井
辻本
辻村
辻野
近藤
迫
迫井
追立
逆瀬川
速見
進藤
遅越
道上
道尾
道根
遠山
遠崎
遠藤
郷間
都
都倉
都築
酒井
里田
重岡
重松
重田
重石
重谷
野原
野口
野崎
野木
野村
野林
野津
野澤
野瀬
野田
野間
金
金井
金原
金口
金堀
金子
金山
金岡
金本
金桝
金澤
金田
金谷
金野
釜下
釣流
鈴木
鈴田
鈴鹿
鍋倉
鎌田
鎌野
長堀
長尾
長岡
長嶋
長嶺
長村
長橋
長江
長沼
長瀬
長畑
長石
長谷川
長谷部
長野
間宮
関
関井
関山
関本
関根
関貫
阪下
阪田
阿南
阿川
阿曽
阿武
阿部
隅川
隅田
雑部
難波
雨坂
霜
露谷
青山
青戸
青木
面谷
須山
須斉
須方
須江
須田
須藤
須麻
顧
風間
飛龍
飯塚
飯尾
飯田
養安
首藤
馬場
馬塲
駒沢
駒田
高垣
高尾
高山
高島
高崎
高木
高本
高村
高橋
高津
高濱
高田
高畑
高石
高羽
高良
高見澤
高野
高須賀
鮎川
鮫島
鳥居
鳥居本
鳥本
鳥羽
鳴島
鳴滝
鴛田
鴨井
鴻山
鵜野
鶴岡
鷹野
鹿島
鹿庭
鹿毛
麥田
麻生
黒川
黒澤
黒田
齊藤
齋藤
)

MEI = %w(
あきを
いずみ
しげ子
たか子
つう
つきか
とし亨
のぶ子
まゆみ
まゆり
セツ子
ヒロシ
一
一三
一之
一九昌
一也
一二
一仁
一信
一史
一哉
一善
一喜
一夫
一孝
一宏
一幸
一弘
一彦
一志
一憲
一成
一智
一樹
一正
一江
一泰
一生
一産
一男
一直
一秋
一紀
一美
一義
一郎
一雄
一馬
七幸
万二
丈裕
丈詞
三博
三喜男
三希夫
三郎
丹
主一
主昭
主男
主税
久
久一
久仁子
久仁郎
久勝
久史
久夫
久実子
久志
久昭
久重
久隆
之治
也寸志
二郎
五朗
五郎
亘
亜希
亜希子
亨
享
京子
亮
亮一
亮二
亮介
仁
仁作
仁史
仁吉
仁志
仁浩
今日子
仙奈
伊久雄
伴啓
伸
伸一
伸一朗
伸二
伸介
伸哉
伸夫
伸幸
伸彰
伸悟
伸樹
伸雄
作三
佳久
佳代子
佳子
佳孝
佳幸
佳明
佳昭
佳晃
佳樹
佳澄
俊一
俊一郎
俊之
俊二
俊二朗
俊介
俊則
俊和
俊夫
俊平
俊幸
俊廣
俊彦
俊彰
俊思
俊昌
俊明
俊昭
俊樹
俊治
俊男
俊範
俊行
俊裕
俊輔
俊雄
保
保之
保則
保夫
保子
保弘
保志子
保正
保淑
保良
信
信の助
信一
信一郎
信久
信之
信也
信二
信亮
信代
信助
信吉
信吾
信太郎
信夫
信子
信宏
信尚
信幸
信弘
信彦
信悦
信敏
信明
信晶
信治
信生
信義
信英
信行
信貴
信雄
修
修一
修二
修司
修實
修滋
倫世
健
健一
健三
健二
健二郎
健介
健史
健司
健太郎
健彦
健志
健次
健次郎
健治
健祐
健輔
傳
優
優一
優子
允伯
元
元夫
元彦
元彰
元秀
元義
元行
充
充啓
充康
充扶朱
充智
充洋
光
光一
光二
光人
光伸
光信
光史
光士
光太郎
光夫
光子
光孝
光宏
光寛
光弘
光徳
光晃
光晴
光民
光治朗
光男
光雄
克三
克之
克也
克典
克則
克己
克弘
克彦
克志
克明
克昭
全伸
公一
公三
公信
公司
公啓
公子
公孝
公市
公彦
公方
公昭
公次
公男
公秀
公義
公郎
公雄
六郎
具公
典勝
典史
典子
典幸
典男
典隆
兼三
兼二
兼千代
冨士夫
出
利之
利人
利典
利夫
利彦
利彰
利明
利春
利晃
利江
利治
利章
利雄
利香
則之
則光
則史
則和
則夫
則子
則幸
則昭
則男
則行
前
剛
剛也
剛児
剛司
剛志
創
力令
功
功二
加代子
勇
勇人
勇次
勇輔
勇雄
勉
務
勝
勝三
勝久
勝之
勝人
勝利
勝則
勝博
勝司
勝嘉
勝宏
勝己
勝已
勝幸
勝弘
勝彦
勝昭
勝治
勝行
勲
勲人
匠邦
千代美
千恵子
千春
千昭
千江美
千秋
千里
千鳥
升吾
卓
卓也
卓治
卓男
卓身
博
博久
博之
博仁
博光
博助
博史
博司
博和
博士
博希
博幸
博志
博敏
博文
博昭
博朗
博次
博治
博継
博義
博視
博身
博道
博隆
卯宏
厚
厚志
厚龍
友則
友博
友子
友清
収
史
史也
史明
史朗
司
司郎
吉之
吉則
吉喜
吉孝
吉宏
吉將
吉映
吉清
吉男
吉隆
吉雄
吉高
君人
君代
周二
周治
和一
和久
和也
和人
和仁
和伸
和則
和博
和司
和壽
和夫
和好
和子
和宏
和己
和幸
和広
和弘
和彦
和徳
和憲
和成
和政
和明
和樹
和浩
和温
和男
和秀
和美
和義
和輝
和郎
和雄
哲
哲一郎
哲也
哲典
哲司
哲夫
哲子
哲弘
哲彦
哲朗
哲治
哲男
哲美
哲良
哲見
哲郎
哲雄
啓
啓一
啓之
啓二
啓亮
啓介
啓史
啓吾
善久
善博
善和
善啓
善嗣
善夫
善広
善晴
善治
善浩
善秀
善紀
善胤
善規
喜一
喜一朗
喜一郎
喜三
喜久
喜久夫
喜久次
喜久雄
喜代志
喜映
喜昭
喜治
喜男
喜芳
喬
喬年
嘉久
嘉人
嘉宏
嘉恭
嘉章
嘉裕
嘉郎
国夫
国弘
国彦
國男
國興
圭一
圭三
圭二
圭基
圭徳
均
基三郎
基光
基治
基浩
堅一
士郎
壽
壽博
壽宏
壽成
多一郎
多美子
多賀夫
大
大三
大二郎
大介
大助
大吾
大地
大樹
大毅
大祐
大蔵
大貴
大資
大輔
太
太一
太市郎
太朗
太郎
好則
好孝
好宏
好弘
好美
好邦
威
孝
孝一
孝之
孝仁
孝充
孝司
孝夫
孝平
孝幸
孝彦
孝徳
孝志
孝憲
孝明
孝昭
孝浩
孝秀
孝章
孝行
孝雄
季和
学
守
守八
守男
安一
安子
安孝
安幸
安浩
安矩
安雄
完治
宏
宏一
宏史
宏和
宏幸
宏文
宏明
宏朋
宏次
宏治
宏禎
宏章
宏紀
宏美
宗一
宗七
宗孝
宗弘
宗昭
宗治
宗男
宗衛
宙平
定一
定幸
定義
定雄
宜正
実
寅雄
富三
富夫
富子
富巳
富春
富男
富美子
富美恵
富雄
寛
寛之
寛巳
寛志
寛昭
寛爾
寛紀
實
實造
寿一
寿夫
寿宏
専司
将
将二
将武
將
尊史
尊善
尋幸
小八郎
尚
尚三
尚久
尚之
尚史
尚雄
展生
展門
岩夫
岩男
岳
峰子
峰生
崇克
崇司
崇将
巖
常夫
常雄
常雅
平
平藏
年のり
年典
年勝
年治
年裕
幸
幸一
幸三
幸俊
幸司
幸太
幸太郎
幸夫
幸好
幸彦
幸治
幸洋
幸生
幸男
幸造
幸雄
幹也
幹夫
幹男
幹矢
幹郎
幹雄
広一
広光
広司
広幸
広志
庄之助
庄司
庄平
康一
康久
康之
康二
康人
康伸
康信
康則
康博
康夫
康宏
康平
康弘
康彦
康徳
康次
康正
康洋
康浩
康男
康義
康裕
康隆
康雄
庸正
廣敏
廣道
延幸
建三
建二
建敬
弘
弘一
弘三
弘之
弘人
弘光
弘吉
弘幸
弘志
弘文
弘明
弘昭
弘次
弘照
弘祐
弘美
弘行
弘通
弘道
彩乃
彰
彰一
彰司
彰太
彰弘
彰洋
彰男
征則
征四郎
征矢
征紀
待子
律次
御
徳子
徳昭
徳次
徳隆
徹
徹之
徹也
徹治
徹雄
忍
志津男
志郎
忠
忠一
忠久
忠之
忠司
忠孝
忠寛
忠幸
忠廣
忠志
忠文
忠直
忠茂
忠雄
忠顯
怜
怡之
恒
恒夫
恒彦
恒樹
恒裕
恭吾
恭子
恭平
恭敬
恵
恵一
恵三
恵吾
恵子
恵理
悟
悟史
悟志
悟視
悦三
悦二
悦司
悦嗣
惠二
惠司
惠吾
惣二
愛
愼
愼一郎
愼二
慎一
慎一郎
慎也
慎二
慎介
慎史
慎司
慎吾
慎治
慧
慶喜
慶太
慶太郎
慶治
憲一
憲一郎
憲二
憲史
憲司
憲彦
憲治
憲雄
憲鶴
成
成一
成人
成佳
成夫
成治
成隆
拓
拓哉
拓浩
拓真
拓行
摂
政信
政光
政則
政勝
政博
政安
政幸
政植
政樹
政次
政範
政義
政雄
敏一
敏三
敏之
敏勝
敏博
敏和
敏夫
敏子
敏幸
敏彦
敏文
敏明
敏昭
敏晴
敏樹
敏正
敏治
敏秀
敏章
敏道
敏郎
敏雄
敦
敦史
敦子
敦実
敦徳
敦志
敦浩
敬
敬一
敬之
敬之助
敬二
敬幸
敬志
敬次
数郎
整治
文一
文人
文仁
文代
文保
文信
文和
文夫
文子
文孝
文幸
文弘
文彦
文昭
文江
文男
文磨
文規
文鑑
文雄
新一郎
新二
新作
新弥
日出夫
日出男
日吉
昇
昌一
昌三
昌之
昌二
昌人
昌信
昌典
昌則
昌史
昌司
昌和
昌子
昌宏
昌年
昌弘
昌彦
昌慶
昌昭
昌浩
昌男
昌穂
昌範
昌行
明
明三
明久
明俊
明則
明夫
明子
明定
明彦
明憲
明男
明真
明貞
春弘
春樹
春江
春海
昭
昭二
昭光
昭利
昭博
昭嗣
昭太郎
昭夫
昭孝
昭宏
昭彦
昭敏
昭治
昭洋
昭裕
昭隆
昭雄
時一
時人
時治
晃
晃一
晃久
晃典
晃司
晃宏
晃年
晃弘
晃徳
晃敏
晃爾
晃良
晃造
晋也
晋吾
晋平
晋示
晏甫
晴久
晴仁
晴基
晴夫
晴子
晴彦
晶一郎
晶利
智
智久
智之
智之助
智也
智充
智史
智基
智子
智尋
智己
智広
智恵
智恵美
智昭
智洋
智絵
智行
智賀子
智輝
暁
暢人
暢幸
暢彦
暢浩
有彦
有生
有美
有香
朋之
朋代
朋美
朗文
朗紀
朝和
朝子
未春
末寸美
東
東一
東輝
栄
栄一郎
栄二郎
栄作
栄治郎
栄美
桂一
桂子
榮一
榮司
榮次
榮起
次夫
次郎
次雄
欣一郎
欣也
欽哉
欽士
正
正一
正一郎
正之
正人
正伸
正俊
正信
正光
正公
正則
正剛
正勝
正博
正司
正吉
正和
正城
正夫
正孝
正宏
正実
正己
正幸
正廣
正弘
正彌
正彦
正徳
正志
正敏
正敬
正文
正明
正昭
正晃
正晴
正植
正樹
正治
正浩
正深
正男
正盛
正祉
正祥
正継
正義
正行
正裕
正規
正躬
正道
正陽
正隆
正雄
武
武久
武則
武史
武司
武平
武弘
武彦
武志
武昭
武治
武雄
毅
民生
民雄
永昌
求
江利子
江利架
江宏
沙織
治
治夫
治彦
治郎
治雄
泉
法人
法憲
法行
泰
泰之
泰伸
泰典
泰博
泰史
泰大
泰夫
泰宏
泰弘
泰彦
泰志
泰成
泰正
泰治
泰男
泰翁
泰行
泰裕
洋
洋一
洋三
洋二
洋介
洋伸
洋司
洋平
洋明
洋美
洪
浩
浩一
浩三
浩之
浩二
浩人
浩司
浩和
浩基
浩子
浩志
浩明
浩朗
浩樹
浩正
浩治
浩至
浩行
淳
淳一
淳也
淳二
淳克
淳司
淳嗣
淳彦
清
清二
清人
清俊
清司
清和
清太郎
清孝
清弘
清徳
清志
清次
清治
清祐
清秀
清美
清行
清高
渉
渡
渥美
温平
満
満喜
満義
源一
源太
源太郎
滋
滋久
滋和
滋男
漢俊
潔
潤
潤二
潤二郎
潤治
澄和
澄夫
澄雄
澤蒼
照夫
照子
照秋
照美
照芳
爽
牧人
猛
猛史
猛夫
玄三
玄任
玉委
玉幸
玲
玲子
理
理枝
琢司
甚吾
生一
由久
由佳里
由加里
由宗
由幸
由彦
由樹
由洋
由紀
由紀雄
由美子
由記夫
甲
申
畢順
登
登志子
登貴久
皎三
皓俊
皓司
益充
益稔
盛司
盛幸
盛洋
直
直一
直也
直人
直史
直和
直哉
直大
直子
直明
直樹
直紀
直行
直誠
省
省二
省吾
眞
眞一
眞一郎
眞人
眞佐史
眞己
眞治
眞理子
眞知子
眞紀
眞藏
眞輔
真
真一
真一郎
真也
真人
真介
真佐代
真佐夫
真史
真司
真哉
真嗣
真実
真希男
真幸
真徳
真樹
真次
真理
真理子
真生
真由美
真登
真知子
真行
睦
睦則
睦美
睦雄
瞳
知也
知二
知史
知子
知宏
知弘
知彦
知昭
知治
知生
知男
知穂
研一
研二
研弥
研治
研至
磊
礼彦
礼征
祐
祐一
祐一郎
祐介
祐子
祐民子
祐治
祐輔
祥一
祥三
祥公
祥子
祥悟
祥是
祥登
祥道
禎
禎一郎
禎夫
禎桐
禎秋
禪
禮次郎
秀
秀一
秀之
秀人
秀俊
秀信
秀光
秀典
秀司
秀吾
秀和
秀哉
秀士
秀夫
秀実
秀己
秀年
秀幸
秀彦
秀憲
秀明
秀樹
秀次
秀比古
秀治
秀泰
秀男
秀美
秀郎
秀雄
秀麿
税
稔
稔夫
稔子
穣
竜一郎
竜作
竜治
竜義
章
章二
章夫
章生
竹司
等
節士
節子
節憲
範行
築
篤
篤司
篤士
篤夫
篤憲
米一
米雄
紀一郎
紀彦
紀朗
紀男
紀秋
紀雄
純
純一
純一郎
純三
純也
純子
純次
純生
純行
紳和
経祐
綽宏
綾香
緯一
繁
繁人
繁城
繁夫
繁樹
繁正
繁清
繁隆
繁雄
美代子
美加
美喜男
美奈子
美幸
美晴
美桐雄
美津明
美由紀
美知
美穂
美紀子
美紗子
美鈴
美香
義久
義之
義光
義則
義博
義和
義嗣
義夫
義幸
義康
義弘
義忠
義数
義方
義明
義昭
義栄
義樹
義治
義浩
義紀
義美
義裕
義郎
義雄
翔
翔吾
耕一
耕史
耕司
耕太
耕太郎
耕平
耕治
聖
聖二
聖治
聡
聡哉
聡太
聡志
育伸
育夫
育宏
育男
育登
育郎
至
與志夫
興一
良
良一
良三
良之
良二
良人
良介
良作
良則
良和
良夫
良宗
良寛
良幸
良彦
良明
良晃
良樹
良治
良隆
良雄
芳信
芳宏
芳寛
芳彦
芳樹
芳玉
芳生
英
英一
英一郎
英世
英之
英也
英二
英俊
英典
英勝
英喜
英嗣
英地
英士
英太郎
英夫
英子
英孝
英寿
英幸
英昭
英樹
英治
英男
英良
英郎
英隆
英雄
茂
茂信
茂文
茂樹
茂正
茂治
茂男
茂穂
茂雄
茉莉
荒志
荘太郎
荘平
華子
華津男
薫
行弘
行彦
行敏
行文
行男
行良
行規
行雄
衛
裕
裕一
裕一郎
裕三
裕之
裕也
裕二
裕介
裕伊
裕則
裕司
裕子
裕幸
裕彦
裕晴
裕樹
裕次
裕正
裕治
裕章
裕美
裕行
裕計
裕道
裕順
要
覚
親保
親民
計泉
詳介
誓
誠
誠一
誠三
誠也
誠二
誠治
諭
謙一
謙二
謙吾
譲
譲二
譲治
護博
豊
豊司
豊和
豊徳
豊明
豊樹
貞彦
貞治郎
貞男
貞紅
貞雄
貢
貢二
貴仁
貴博
貴史
貴司
貴哉
貴士
貴弘
貴志
貴澄
貴章
貴義
貴雄
賢
賢一
賢三
賢二
賢司
賢士
賢次
賢治
賢石
賢秀
賢芳
越夫
輝
輝之
輝彦
輝治
輝浩
輝規
辰三
辰二
辰昭
辰生
辰行
透
通夫
速人
進
進一
進一郎
進次
進道
逸二
逸子
逸雄
道啓
道夫
道子
道宜
道彦
道正
道生
道行
道雄
達也
達史
達哉
達夫
達朗
達男
達紀
達雄
邦且
邦光
邦夫
邦子
邦宏
邦弘
邦昭
邦男
邦芳
邦雄
郁
郁也
郁二
郁夫
郁子
郁洋
郁男
郁雄
郷太郎
里子
重夫
重孝
重幸
重治
重男
重道
量則
金吾
鈴子
鉄夫
銘祺
錦栄
鎭生
長嗣
長昭
開
陸奥
陽
陽一
陽一郎
陽子
隆
隆一
隆之
隆也
隆二
隆介
隆俊
隆信
隆典
隆博
隆史
隆司
隆吉
隆嗣
隆士
隆夫
隆子
隆尚
隆幸
隆徳
隆志
隆文
隆樹
隆正
隆治
隆男
隆盛
隆章
隆聖
隆道
雄一
雄一郎
雄三
雄之亮
雄二
雄司
雄吾
雄大
雄樹
雄良
雅
雅一
雅一朗
雅之
雅也
雅人
雅仁
雅伸
雅俊
雅則
雅史
雅司
雅喜
雅夫
雅央
雅子
雅弘
雅彦
雅敏
雅文
雅明
雅樹
雅洋
雅英
雅茂
雅行
雅裕
雅郷
雅雄
雍史
青也
靖
靖二
靖則
靖史
靖子
靖彦
靖昭
靖男
靖祐
靖雄
静也
静子
静江
静香
靜子
順
順一
順二
順子
順彦
頼美
顕子
顯
香代子
馨
高史
高夫
高幸
高志
高治
麻利子
麻記
麻里
龍一
龍三
龍二
龍哉
龍樹
龍次
龍紀
龍蔵
)

ADDRESS = %w(
東京
大阪
熊本
福岡
東区
阿蘇
宇土
人吉
天草
新潟
大矢野
天草
長崎
新宿
渋谷
)

require "optparse"

gen_count = 9998

opt = OptionParser.new
opt.on("-c COUNT", Integer) {|v| gen_count = v}
opt.parse!(ARGV)

gen_count.times do |t|
#  puts "#{SEI[rand(SEI.size)]} #{MEI[rand(MEI.size)]}"	
	bookNo = "U001-131211" + format("%0#{4}d", t)
	bname = SEI[rand(SEI.size)] + MEI[rand(MEI.size)] + "さんが書いた本-" + t.to_s
	author = SEI[rand(SEI.size)] + " " + MEI[rand(MEI.size)]
	publisher = SEI[rand(SEI.size)] + "出版社"
#  puts "#{name} #{address} #{tel}"
	num = (t+1).to_s
	puts "INSERT INTO books ( bname, author, publisher ) VALUES ( '#{bname}', '#{author}', '#{publisher}' );"
#	puts "SET @d = (SELECT bid FROM books WHERE bname = '#{bname}' );"
  puts "INSERT INTO libraryBooks ( bid, bookNo ) VALUES ( #{num}, '#{bookNo}' );"
  puts ""
end
