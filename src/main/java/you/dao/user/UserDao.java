package you.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import you.pojo.AdminVO;

public interface UserDao {
//	增
//	public void insertUser(Connection conn,PreparedStatement ps);
//	刪
	public void deleteUser(Connection conn,PreparedStatement ps,Integer usPos);
//	修
	public void alterUser(Connection conn,PreparedStatement ps,Integer usPos,Object...paras);
//	查
	public ResultSet selectUsers(Connection conn,PreparedStatement ps,String username);
//	帳號登入
	public AdminVO adminLogin(Connection conn,PreparedStatement ps, String username, String password);
	
	public void insDiaryLike(Connection conn,PreparedStatement ps,Integer idCustomer,Integer diaryID);
	
	public void delDiaryLike(Connection conn,PreparedStatement ps,Integer diaryLikeID,Integer diaryID);
	
	public Integer selDiaryLike(Connection conn,PreparedStatement ps,Integer diaryID);
	
	public void userAddFriend(Connection conn,PreparedStatement ps,String authorName,Integer custID);
	
}
