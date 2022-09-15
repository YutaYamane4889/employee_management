package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	//ログイン用dao
	public String passReturn(String code) throws SQLException, ClassNotFoundException, SQLException {
		String usercode = code;
		String pass = "";
		String sql = "SELECT * FROM m_user WHERE BINARY user_id LIKE ?";
		try (Connection con = ConnectionManager.getConnection();

				PreparedStatement pstmt = con.prepareStatement(sql)) {
			pstmt.setString(1, usercode);

			ResultSet res = pstmt.executeQuery();

			// 結果の操作
			while (res.next()) {
				pass = (res.getString("password"));
			}
		}

		return pass;

	}
}
