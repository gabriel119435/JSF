package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Repo {
	private Connection connection;

	private void conect() {
		this.connection = new DataBase().connectDB();
	}

	public void insert(String msg) throws SQLException {
		String sql = "insert into mytable " + "values (?)";
		this.conect();
		PreparedStatement preparedStatement = connection.prepareStatement(sql);
		try {
			preparedStatement.setString(1, msg);
			preparedStatement.execute();
		} catch (Exception e) {
			System.out.println("no insert done - " + e);
		} finally {
			preparedStatement.close();
			connection.close();
		}
	}

	public List<Message> all() throws SQLException {
		List<Message> list = new ArrayList<>();
		String sql = "select * from mytable";
		this.conect();
		Statement statement = connection.createStatement();
		try {
			ResultSet resultSet = statement.executeQuery(sql);
			while (resultSet.next())
				list.add(new Message(resultSet.getString("msg")));
		} catch (Exception e) {
			System.out.println("failed to read entire table - " + e);
		} finally {
			statement.close();
			connection.close();
		}
		return list;
	}

	public void clear() throws Exception {
		String sql = "truncate mytable";
		this.conect();
		Statement statement = connection.createStatement();
		try {
			statement.execute(sql);
		} catch (Exception e) {
			System.out.println("not truncated - " + e);
		} finally {
			statement.close();
			connection.close();
		}
	}

}
