package Controlador;

import java.sql.*;

public class DatabaseManager {
	
	private static Connection databaseConnection;
	
	private static String CONNECTION_STRING = "jdbc:oracle:thin:@localhost:1521:xe";
	private static String USUARIO = "PROYECTO";
	private static String CLAVE = "PROYECTO";
	
	static {
		
		databaseConnection = null;
		
		try { 
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			try {
				
				databaseConnection = DriverManager.getConnection(CONNECTION_STRING, USUARIO, CLAVE); 
				
			}catch(SQLException e){
				
				System.out.println("No logramos instanciar una conexión");
				e.printStackTrace();
			
			}
				
	
			
		}catch(ClassNotFoundException e) {
			System.out.println("No tienes el driver en tu build-patch?");
			e.printStackTrace();
			
		}
	}
	
	public static Connection getConnection() {
		return databaseConnection;
	}
	
	
}
