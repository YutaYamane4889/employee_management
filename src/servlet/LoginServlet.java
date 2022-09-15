package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login-servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("servlethanter.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String userid = request.getParameter("user_id");//フォームから取得
		String password = request.getParameter("password");
		String daopass = "";
		HttpSession session = request.getSession();//セッション
		String flg = "false";
		UserDAO userdao = new UserDAO();//userdao生成
		try {
			daopass = userdao.passReturn(userid);//daoからユーザidのパスもってくる
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		if (password.equals(daopass)) {
			if(!password.equals("")) {
				RequestDispatcher rd = request.getRequestDispatcher("menu.jsp");
				session.setAttribute("userid", userid);
				flg="true";//フラグにtrue ログインできたため
				session.setAttribute("flg",flg);
				rd.forward(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("login-failure.html");
				rd.forward(request, response);
			}

		} else {
			RequestDispatcher rd = request.getRequestDispatcher("login-failure.html");
			rd.forward(request, response);
		}
	}

}
