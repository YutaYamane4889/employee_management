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
 * Servlet implementation class 　EditServlet
 */
@WebServlet("/edit-servlet")
public class EditServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO ccAuto-generated method stub
		RequestDispatcher rd = request.getRequestDispatcher("servlethanter.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		EmployeeBean employee=(EmployeeBean)session.getAttribute("employee");
		String maeCode = (String)session.getAttribute("maeCode");
		//WHERE句に使うコード
//		String employee_code = employee.getEmployee_code();
//		String lnameKana = employee.getLast_kana_name();
//		String fnameKana = employee.getFirst_kana_name();
//		String lname = employee.getLast_name();
//		String fname= employee.getFirst_name();
//		byte gender = employee.getGender();
//		Date birthday = employee.getBirth_day();
//		String section = employee.getSection_code();
//		Date hireDate = employee.getHire_date();
		int res = 0;
		EmployeeDAO dao=new EmployeeDAO();
		try {
			res=dao.edit(employee, maeCode);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			RequestDispatcher rd = request.getRequestDispatcher("error_page.jsp");
			rd.forward(request, response);
		}
		request.setAttribute("res", res);

		RequestDispatcher rd = request.getRequestDispatcher("edit-complete.jsp");
		rd.forward(request, response);
	}

}
