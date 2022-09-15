package servlet;

import java.io.IOException;
import java.sql.Date;
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
 * Servlet implementation class EditConfirmServlet
 */
@WebServlet("/edit-confirm-servlet")
public class EditConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditConfirmServlet() {
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


		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String maeCode = (String)session.getAttribute("maeCode");
		//データベースから持ってくるようのもの

		String employee_code = request.getParameter("employee_code");
		String lnameKana = request.getParameter("lname_kana");
		String fnameKana = request.getParameter("fname_kana");
		String lname = request.getParameter("lname");
		String fname= request.getParameter("fname");
		String genders = request.getParameter("gender");
		String birthdays = request.getParameter("birthday");
		String section = request.getParameter("section");
		String hireDates = request.getParameter("hire_date");
		Date birthday= Date.valueOf(birthdays);
		Date hireDate= Date.valueOf(hireDates);
		Byte gender = new Byte(genders);

		EmployeeBean employee = new EmployeeBean();
		employee.setEmployee_code(employee_code);
		employee.setLast_name(lname);
		employee.setFirst_name(fname);
		employee.setLast_kana_name(lnameKana);
		employee.setFirst_kana_name(fnameKana);
		employee.setGender(gender);
		employee.setBirth_day(birthday);
		employee.setSection_code(section);
		employee.setHire_date(hireDate);
		EmployeeDAO dao = new EmployeeDAO();
		String sectionName="";
		try {
			sectionName=dao.SectionReturn(section);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		employee.setSection_name(sectionName);
		session.setAttribute("employee", employee);

		//変更前データを取得
		EmployeeBean employeemae = new EmployeeBean();
		try {
			employeemae = dao.selectEmployee(maeCode);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		session.setAttribute("employeemae",employeemae );
		RequestDispatcher rd = request.getRequestDispatcher("edit-confirm.jsp");
		rd.forward(request, response);
	}

}
