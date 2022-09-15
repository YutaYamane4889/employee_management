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

import model.dao.EmployeeDAO;
import model.entity.EmployeeBean;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/insert-servlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("servlethanter.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//長木さん記述
		//リクエストのエンコーディング方式を指定
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		EmployeeBean employee=(EmployeeBean)session.getAttribute("employee");
		String code = employee.getEmployee_code();
//	 if(!code.matches("^E" + "[0-9]{3}$")){
//			request.setAttribute("codeerror", "従業員コードが間違っています");
//		 }


//			String lName = employee.getLast_name();
//			String fName = employee.getFirst_name();
//			String lNameKana = employee.getLast_kana_name();
//			String fNameKana = employee.getFirst_kana_name();
//			byte g = employee.getGender();
//			Date birthday= employee.getBirth_day();
//			String sectionCode = employee.getSection_code();
//			Date hireDay= employee.getHire_date();

		//DAOの生成
		EmployeeDAO dao = new EmployeeDAO();
		int processingNumber = 0;


		try {
			//DAOの利用
			processingNumber = dao.insert(employee);
		} catch (SQLException | ClassNotFoundException e) {
			RequestDispatcher rd = request.getRequestDispatcher("error_page.jsp");
			rd.forward(request, response);
		}
		//リクエストスコープへの属性の設定
		request.setAttribute("processingNumber", processingNumber);

		//リクエストの転送
		RequestDispatcher rd = request.getRequestDispatcher("registration-completion.jsp");
		rd.forward(request, response);
	}
}
