package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import model.User_info;


// Data Access Object（DAO）
public class UserDAO {
	//*************************************
	// メンバ変数の定義
	//*************************************
	private Connection db;
	private PreparedStatement ps;
	private ResultSet rs;

	//*************************************
	// メソッドの定義
	//*************************************
	// MySQLとの接続処理
	private void getConnection() throws NamingException, SQLException{	
			Context context=new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/jsp");
			this.db=ds.getConnection();	
	}
	
	// MySQLとの切断処理
	private void disconnect(){
		try{
			if(rs != null){rs.close();}
			if(ps != null){ps.close();}
			if(db != null){db.close();}
		}catch(SQLException e){
			e.printStackTrace();
		}	
	}
	
	// priductsテーブルのデータを全て取得
	public List<User_info> findAll(){
		
		List<User_info> userList=new ArrayList<>();
		try {
			this.getConnection();
			ps=db.prepareStatement("SELECT * FROM user ORDER BY id DESC");
			rs=ps.executeQuery();
			while(rs.next()){
				int id=rs.getInt("id");
				String name=rs.getString("name");
				String sex=rs.getString("sex");
				SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				String born=sdf.format(rs.getTimestamp("born"));
				User_info user_info=new User_info(id,name,sex,born);
				userList.add(user_info);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NamingException e) {
			e.printStackTrace();
		}finally{
			this.disconnect();
		}
		return userList;
	}
	
	// 引数でしたProductデータを新規追加
	public boolean insertOne(User_info user_info){
		try {
			this.getConnection();
			ps=db.prepareStatement("INSERT INTO user(name,sex,born) VALUES(?,?,?)");
			ps.setString(1,user_info.getName());
			ps.setString(2,user_info.getSex());
			ps.setString(3, user_info.getBorn());
			int result=ps.executeUpdate();
			if(result != 1){
				return false;
			}
		} catch (SQLException e) {	
			e.printStackTrace();
		} catch (NamingException e) {	
			e.printStackTrace();
		}finally{
			this.disconnect();
		}
		return true;
	}
	
}