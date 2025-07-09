package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB{
	
	private static Connection conn = null; /*Objeto responsável por 
											armazenar a conexão 
											com o banco de dados JDBC*/
	
	
	
	
	//Método para estabelecer a conexão com o banco de dados
	public static Connection getConnection() {
		Properties props = loadProperties();
		String url = props.getProperty("dburl");
		try {
			conn =  DriverManager.getConnection(url, props);
			return conn;
		}
		catch(SQLException e) { 
			throw new DbException(e.getMessage());
		}
	}
	//Método para encerrar o conexão com o banco de dados
	public static void closeConnection() {
		if(conn!=null) {
			try {
				conn.close();
			}	
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
		
	}
	
	
	//Método auxiliar para obter as propriedades para conexão
	private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")) {
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch(IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	//Métodos auxiliares para fechar objetos do  tipo ResultSet e Statement
	
	public static void closeStatement (Statement st) {
		if(st!=null) {
			try {
				st.close();
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			}
			catch(SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
}