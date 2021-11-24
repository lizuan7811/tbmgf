package com.static_file.model;

public class FinalStaticFile {
	public final static String ADMIN_UPDATE="UPDATE Admin SET idAdmin=?,account=?,password=?,createdTime=?,authority=? WHERE idAdmin=?;";
	public final static String ADMIN_DELETE="DELETE FROM Admin";
	public final static String ADMIN_SELECT="SELECT * FROM Admin";
	public final static String SGADMIN_SELECT="SELECT * FROM Group4_db.Admin WHERE account=?";

	public final static String ADMIN_INSERT="INSERT INTO Admin(idAdmin,account,password,createdTime,authority)values(?,?,?,?,?);";

	public final static String USER_UPDATE="UPDATE Customer SET commentReportedNum=?,diaryReportedNum=?,suspended=? WHERE idCustomer=?;";

	public final static String SGUSER_DELETE="DELETE FROM Group4_db.Customer WHERE idCustomer= ?;";

	public final static String USER_SELECT="SELECT * FROM Group4_db.Customer;";
	public final static String SGUSER_SELECT="SELECT * FROM Customer WHERE account=?;";
	public final static String USER_INSERT="INSERT INTO Group4_db.Customer(idCustomer,name,profic,nickName,account,password,email,phone,createdTime,suspended,externalAcc,externalIdToken,commentReportedNum,diaryReportedNum)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?);";

	public final static String ADMIN_SESSION="ADMIN_SESSION";

	public final static String DIARYLIKE_SELECT="SELECT * FROM DiaryLike;";

	public final static String DIARYLIKESG_SELECT="SELECT * FROM `DiaryLike` WHERE idCustomer=?;";

	public final static String DIARYLIKESG_INSERT="INSERT INTO `DiaryLike`(diaryLikeID,diaryID,idCustomer,createdTime)values(?,?,?,?);";

	public final static String DIARYLIKESG_DELETE="DELETE FROM `DiaryLike` WHERE diarylikeID=?;";
//	留言檢舉
	public final static String COMMENTREPORT_ALTER="UPDATE CommentReport SET createdTime=?,reportReason=?,reportResult=? WHERE diaryID = ? and custID = ?;";



	public final static String COMMENTREPORT_INSERT="INSERT INTO CommentReport(commentReportID,diaryID,custID,createdTime,reportReason,reportResult)VALUES(?,?,?,?,?,?);";

//	搜尋留言檢舉表
	public final static String COMMENTREPORT_SELECT="SELECT * FROM CommentReport WHERE custID = ? and diaryID = ?;";

//	會員登入後，取得所有文章的每個按讚數，前端網頁使用

//	會員按讚後，資料寫入Jedis

	public final static String DIARYLIKE="DiaryLikeVO";
//	執行新增好友申請指令V
	public final static String FRIEND_INSERT="INSERT INTO Group4_db.Friend(friendCharID,custID,myfriendID,friendStatusNum,statusUpdate)VALUES(?,?,?,?,?);";
//	執行刪除好友指令
	public final static String FRIEND_DELETE="DELETE FROM Group4_db.Friend WHERE custID = ? and myfriendID = ?;";
//	執行同意後，將狀態修改為成為好友的指令
	public final static String FRIEND_UPDAET="UPDATE Group4_db.Friend SET friendStatusNum = 1 WHERE custID = ? and myfriendID = ?";
//	執行同意後，將狀態修改為成為好友的指令
	public final static String FRIEND_AGREE="UPDATE Group4_db.Friend SET friendStatusNum = ? ,statusUpdate = ? where (custID=? and myFriendID=?) or (custID=? and myFriendID=?);";

//	判斷資料庫中好友是否已存在，並返回ResultSet
//	為空，判斷就為false，若存在，就送出同意，然後更改狀態。
//	按同意就會執行agree

//	執行搜尋判斷搜尋好友狀態
	public final static String FRIENDCOMP_SELECT="SELECT * FROM Group4_db.Friend where (custID=? and myFriendID=?) or (custID=? and myFriendID=?);";
//	執行搜尋目前使用者登入後所有好友ID的指令，判斷登入的ID在好友表中的custID或myFriendID中存在的，搜尋到就顯示出來。
/*SELECT cu.idCustomer,cu.`name`,cu.profic,cu.nickName,cu.`account`,cu.email,cu.phone FROM Friend fr
join Customer cu
on fr.custID=cu.idCustomer or fr.myFriendID=cu.idCustomer
WHERE custID=4 or myFriendID=4*/
	public final static String FRIENDLIST_SELECT="SELECT distinct(cu.idCustomer),cu.`name`,cu.profic,cu.nickName,cu.`account`,cu.email,cu.phone FROM Friend fr join Customer cu on fr.custID=cu.idCustomer or fr.myFriendID=cu.idCustomer WHERE custID=? or myFriendID=?";

}