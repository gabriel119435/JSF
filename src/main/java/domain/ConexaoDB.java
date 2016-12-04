package domain;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoDB {
	public Connection conectarDB() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/banco", "postgres", "postgres");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("connection failed");
			return null;
		}
	}
}
