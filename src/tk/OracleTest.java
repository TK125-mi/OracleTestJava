package tk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleTest {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		String id=args[0];
		String pass=args[1];
		//Class.forName("oracle.jdbc.driver.OracleDriver");
		// Oracle8iに接続
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEXDB", id, pass);
		// ステートメントを作成
		Statement stmt = conn.createStatement();
		// 問合せの実行
		ResultSet rset = stmt.executeQuery("SELECT * FROM TABLE1");
		// 問合せ結果の表示
		while (rset.next()) {
			// 列番号による指定
			System.out.println(rset.getInt(1) + "\t" + rset.getString(2));
		}
		// 結果セットをクローズ
		rset.close();
		// ステートメントをクローズ
		stmt.close();
		// 接続をクローズ
		conn.close();
	}

}
