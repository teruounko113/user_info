package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

@WebServlet("/main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// **********************************************
	// POSTで来た場合
	// **********************************************
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 文字コード設定
		request.setCharacterEncoding("UTF-8");
		
		// nameパラメーター取得
		String name=request.getParameter("name");
		
		// priceパラメーター取得
		String sex=request.getParameter("sex");
		
		//bornバラメータ取得
		String born=request.getParameter("born");
		
		// 入力値チェック
		if(name.isEmpty() || sex.isEmpty() || born.isEmpty()){
			request.setAttribute("err","未記入の項目があります！");
		}else{
			Date date=new Date();
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String updated=sdf.format(date);
			UserDAO dao=new UserDAO();
			String id=request.getParameter("id");

			// 未登録の場合は、新規追加
			request.setAttribute("msg","1件登録しました。");
			}	
		doGet(request,response);
	
	}
}
	