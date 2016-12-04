package domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Repo {
	private Connection conexao;

	private void conecta() {
		this.conexao = new ConexaoDB().conectarDB();
	}

	public void insert(String s) throws SQLException {
		String sql = "INSERT INTO tabela " + "VALUES (?)";
		this.conecta();
		PreparedStatement pst = conexao.prepareStatement(sql);
		try {
			pst.setString(1, s);
			pst.execute();
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("no insert done");
		} finally {
			pst.close();
			conexao.close();
		}
	}

	public List<Message> all() throws SQLException {
		List<Message> lista = new ArrayList<Message>();
		String sql = "SELECT * FROM tabela";
		this.conecta();
		Statement stm = (Statement) conexao.createStatement();

		try {
			ResultSet rs = stm.executeQuery(sql);
			while (rs.next()) {
				lista.add(new Message(rs.getString("msg")));
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("failed to read entire table");
		} finally {
			stm.close();
			conexao.close();
		}
		return lista;
	}

	public void delete() throws Exception {
		String sql = "TRUNCATE tabela";
		this.conecta();
		Statement stm = (Statement) conexao.createStatement();
		try {
			stm.execute(sql);
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("not erased");
		} finally {
			stm.close();
			conexao.close();
		}
	}

}
