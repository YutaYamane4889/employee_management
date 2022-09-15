package model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.entity.EmployeeBean;

public class EmployeeDAO {
	//一覧表示メソッド

	public List<EmployeeBean> allEmployee(String order) throws SQLException, ClassNotFoundException, SQLException {
		List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
		String sqlOder = order;
		String sql = "SELECT * FROM m_employee INNER JOIN m_section ON m_employee.section_code=m_section.section_code ORDER BY "+sqlOder+";";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				String code = (res.getString("employee_code"));
				String lName = (res.getString("last_name"));
				String fName = (res.getString("first_name"));
				String lNameKana = (res.getString("last_kana_name"));
				String fNameKana = (res.getString("first_kana_name"));
				byte gender = (res.getByte("gender"));
				String birth_days = (res.getString("birth_day"));
				Date birth_day = Date.valueOf(birth_days);
				String sectionName = (res.getString("section_name"));
				String hireDates = (res.getString("hire_date"));
				Date hireDate = Date.valueOf(hireDates);

				EmployeeBean employee = new EmployeeBean();
				employee.setEmployee_code(code);
				employee.setLast_name(lName);
				employee.setFirst_name(fName);
				employee.setLast_kana_name(lNameKana);
				employee.setFirst_kana_name(fNameKana);
				employee.setGender(gender);
				employee.setBirth_day(birth_day);
				employee.setSection_name(sectionName);
				employee.setHire_date(hireDate);
				employeeList.add(employee);
			}
		}
		return employeeList;
	}
	//一覧表示メソッド(部署ごと)
	public List<EmployeeBean> sectionAllEmployee(String order,String section) throws SQLException, ClassNotFoundException, SQLException {
		List<EmployeeBean> employeeList = new ArrayList<EmployeeBean>();
		String sqlOder = order;
		String sql = "SELECT * FROM m_employee INNER JOIN m_section ON m_employee.section_code=m_section.section_code WHERE m_employee.section_code LIKE ? ORDER BY "+sqlOder+";";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, section);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				String code = (res.getString("employee_code"));
				String lName = (res.getString("last_name"));
				String fName = (res.getString("first_name"));
				String lNameKana = (res.getString("last_kana_name"));
				String fNameKana = (res.getString("first_kana_name"));
				byte gender = (res.getByte("gender"));
				String birth_days = (res.getString("birth_day"));
				Date birth_day = Date.valueOf(birth_days);
				String sectionName = (res.getString("section_name"));
				String hireDates = (res.getString("hire_date"));
				Date hireDate = Date.valueOf(hireDates);

				EmployeeBean employee = new EmployeeBean();
				employee.setEmployee_code(code);
				employee.setLast_name(lName);
				employee.setFirst_name(fName);
				employee.setLast_kana_name(lNameKana);
				employee.setFirst_kana_name(fNameKana);
				employee.setGender(gender);
				employee.setBirth_day(birth_day);
				employee.setSection_name(sectionName);
				employee.setHire_date(hireDate);
				employeeList.add(employee);
			}
		}
		return employeeList;
	}
	//所属部署リターン
	public String SectionReturn(String sectionCode) throws ClassNotFoundException, SQLException {
		String sectionName = null;
		String sql = "SELECT * FROM m_section WHERE section_code LIKE ?";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, sectionCode);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
					sectionName=res.getString("section_name");
			}
		}
		return sectionName;
	}

	//従業員選択メソッド
	public EmployeeBean selectEmployee(String code) throws SQLException, ClassNotFoundException, SQLException {
		String sql = "SELECT * FROM m_employee INNER JOIN m_section ON m_employee.section_code=m_section.section_code WHERE employee_code=?";
		String employeeCode = code;
		EmployeeBean employee = new EmployeeBean();
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, employeeCode);
			ResultSet res = pstmt.executeQuery();
			while (res.next()) {
				employee.setEmployee_code(res.getString("employee_code"));
				employee.setLast_name(res.getString("last_name"));
				employee.setFirst_name(res.getString("first_name"));
				employee.setLast_kana_name(res.getString("last_kana_name"));
				employee.setFirst_kana_name(res.getString("first_kana_name"));
				employee.setGender(res.getByte("gender"));
				employee.setBirth_day(res.getDate("birth_day"));
				employee.setSection_name(res.getString("section_name"));
				employee.setSection_code(res.getString("section_code"));
				employee.setHire_date(res.getDate("hire_date"));
			}
		}
		return employee;
	}
	//従業員登録メソッド
	public int insert(EmployeeBean employee) throws ClassNotFoundException, SQLException {
		String employeeCode=employee.getEmployee_code();
		String lastName=employee.getLast_name();
		String firstName=employee.getFirst_name();
		String lastNameKana=employee.getLast_kana_name();
		String firstNameKana=employee.getFirst_kana_name();
		byte gender = employee.getGender();
		Date birthDay=employee.getBirth_day();
		String section=employee.getSection_code();
		Date hireday=employee.getHire_date();
		int res=0;//更新件数
		String sql = "INSERT INTO m_employee VALUES(?,?,?,?,?,?,?,?,?,CURRENT_TIMESTAMP)";
		try (Connection con = ConnectionManager.getConnection();

				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1,employeeCode);
			pstmt.setString(2,lastName);
			pstmt.setString(3,firstName);
			pstmt.setString(4,lastNameKana);
			pstmt.setString(5,firstNameKana);
			pstmt.setByte(6,gender);
			pstmt.setDate(7,birthDay);
			pstmt.setString(8,section);
			pstmt.setDate(9,hireday);
			res = pstmt.executeUpdate();
		}
		return res;
	}
	//従業員編集メソッド
	public int edit(EmployeeBean employee,String codomae) throws ClassNotFoundException, SQLException {
		String employeeCode=employee.getEmployee_code();
		String lastName=employee.getLast_name();
		String firstName=employee.getFirst_name();
		String lastNameKana=employee.getLast_kana_name();
		String firstNameKana=employee.getFirst_kana_name();
		byte gender = employee.getGender();
		Date birthDay=employee.getBirth_day();
		String section=employee.getSection_code();
		Date hireday=employee.getHire_date();
		int res=0;//更新件数
		String sql = "UPDATE m_employee SET employee_code=?,last_name=?,first_name=?,last_kana_name=?,first_kana_name=?,gender=?,birth_day=?,section_code=?,hire_date=?,update_datetime=CURRENT_TIMESTAMP WHERE employee_code LIKE ?";
		try (Connection con = ConnectionManager.getConnection();

				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1,employeeCode);
			pstmt.setString(2,lastName);
			pstmt.setString(3,firstName);
			pstmt.setString(4,lastNameKana);
			pstmt.setString(5,firstNameKana);
			pstmt.setByte(6,gender);
			pstmt.setDate(7,birthDay);
			pstmt.setString(8,section);
			pstmt.setDate(9,hireday);
			pstmt.setString(10,codomae);
			res = pstmt.executeUpdate();
		}
		return res;
	}

	//従業員削除メソッド
	public int delete(String code) throws SQLException, ClassNotFoundException, SQLException {
		int res = 0;
		String employeeCode = code;
		String sql = "DELETE FROM m_employee WHERE employee_code = ?";
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, employeeCode);
			res = pstmt.executeUpdate();

		}
		return res;
	}
}
