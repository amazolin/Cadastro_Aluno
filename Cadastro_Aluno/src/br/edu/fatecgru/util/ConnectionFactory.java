package br.edu.fatecgru.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;

public class ConnectionFactory {
	public static Connection getConnection() throws Exception {
	    try {
	        // Verifica se o driver está no classpath
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        System.out.println("Driver JDBC carregado com sucesso!"); // Debug
	        
	        String url = "jdbc:mysql://localhost:3306/cadastroaluno";
	        String user = "root";
	        String senha = "";
	        
	        Connection conn = DriverManager.getConnection(url, user, senha);
	        System.out.println("Conexão estabelecida com sucesso!"); // Debug
	        return conn;
	    } catch (ClassNotFoundException e) {
	        throw new Exception("Driver JDBC não encontrado! Verifique o Build Path.", e);
	    } catch (SQLException e) {
	        throw new Exception("Erro ao conectar ao banco de dados: " + e.getMessage(), e);
	    }
	}

	// fecha uma conexão de três formas: conn, stmt, rs
	public static void closeConnection(Connection conn, Statement stmt, ResultSet rs) throws Exception {
		close(conn, stmt, rs);
	}

	public static void closeConnection(Connection conn, Statement stmt) throws Exception {
		close(conn, stmt, null);
	}

	public static void closeConnection(Connection conn) throws Exception {
		close(conn, null, null);
	}

	private static void close(Connection conn, Statement stmt, ResultSet rs) throws Exception {
	    try {
	        if (rs != null) rs.close();
	        if (stmt != null) stmt.close();
	        if (conn != null) {
	            if (!conn.getAutoCommit()) {
	                conn.commit(); // ⭐ Confirma pendências se auto-commit estiver desligado
	            }
	            conn.close();
	        }
	    } catch (Exception e) {
	        throw new Exception("Erro ao fechar conexão: " + e.getMessage(), e);
	    }
	}

}