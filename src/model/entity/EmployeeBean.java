package model.entity;

import java.io.Serializable;
import java.sql.Date;


public class EmployeeBean implements Serializable{
	private String employee_code;
	private String last_name;
	private String first_name;
	private String last_kana_name;
	private String first_kana_name;
	private byte gender;
	private Date birth_day;
	private String section_code;
	private String section_name;
	private Date hire_date;
	public String getEmployee_code() {
		return employee_code;
	}
	public void setEmployee_code(String employee_code) {
		this.employee_code = employee_code;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_kana_name() {
		return last_kana_name;
	}
	public void setLast_kana_name(String last_kana_name) {
		this.last_kana_name = last_kana_name;
	}
	public String getFirst_kana_name() {
		return first_kana_name;
	}
	public void setFirst_kana_name(String first_kana_name) {
		this.first_kana_name = first_kana_name;
	}
	public byte getGender() {
		return gender;
	}
	public void setGender(byte gender) {
		this.gender = gender;
	}
	public Date getBirth_day() {
		return birth_day;
	}
	public void setBirth_day(Date birth_day) {
		this.birth_day = birth_day;
	}
	public String getSection_code() {
		return section_code;
	}
	public void setSection_code(String section_code) {
		this.section_code = section_code;
	}
	public String getSection_name() {
		return section_name;
	}
	public void setSection_name(String section_name) {
		this.section_name = section_name;
	}
	public Date getHire_date() {
		return hire_date;
	}
	public void setHire_date(Date hire_date) {
		this.hire_date = hire_date;
	}
}
