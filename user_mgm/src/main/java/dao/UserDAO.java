package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


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
	
	
}