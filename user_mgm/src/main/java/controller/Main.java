package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;
import model.User_info;

@WebServlet("/main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO dao=new UserDAO();
		
		String action=request.getParameter("action");
		
		// パラメーター判定
		if(action != null && action.equals("delete")){
			// deleteの場合
			// 対象データを削除
			dao.deleteOne(Integer.parseInt(request.getParameter("id")));
			
			// 応答データ作成
			request.setAttribute("msg", "1件削除しました。");
			
		}else if(action != null && action.equals("update")){
			// updateの場合
			// 対象データを更新
			// 対象データを検索
			User_info user_info = dao.findOne(Integer.parseInt(request.getParameter("id")));
			
			// 応答データ作成
			request.setAttribute("user_info", user_info);
			request.setAttribute("title", "項目を編集してください。");
		}
		
		List<User_info> list=dao.findAll();
		request.setAttribute("list", list);
		RequestDispatcher rd= request.getRequestDispatcher("/WEB-INF/view/main.jsp");
		rd.forward(request, response);
		
	}
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
			UserDAO dao=new UserDAO();
			String id=request.getParameter("id");
			if(id != ""){
				// 既に登録済みデータの場合は更新
				dao.updateOne(new User_info(Integer.parseInt(id),name,sex,born));
				request.setAttribute("msg","1件更新しました。");
			}else {
			// 未登録の場合は、新規追加
				dao.insertOne(new User_info(name,sex,born));
				request.setAttribute("msg","1件登録しました。");
			}	
		}
		doGet(request,response);
	}
}
	