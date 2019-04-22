import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public  class MysqlConnect {
	public  Connection baglan() {
		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/market?serverTimezone=Turkey", "root",
					"1234");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.toString());
		}
		return con;

	}

}
