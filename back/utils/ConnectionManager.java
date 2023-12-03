package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager {
	private static final Logger logger = Logger.getLogger(ConnectionManager.class.getName());
	private static final ResourceBundle bundleConfig = ResourceBundle.getBundle("config");
//	static {
//		try {
//			Class.forName(bundleConfig.getString("jdbc.driver.classname"));
//		} catch (ClassNotFoundException e) {
//			
//			e.printStackTrace();
//			logger.log(Level.SEVERE, e.getMessage());
//		}
//	}

	private static final String DB_URL = bundleConfig.getString("jdbc.url");

	private static final String DBUser = bundleConfig.getString("jdbc.user");

	private static final String DBPasword = bundleConfig.getString("jdbc.password");

	private static final String DBClassname = bundleConfig.getString("jdbc.driver.classname");

	public static final Connection getConnection() throws SQLException {
		
		try {
			Class.forName(DBClassname);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection connection = DriverManager.getConnection(DB_URL, DBUser, DBPasword);

		return connection;
	}

	public static void closeResultSet(ResultSet resultset) throws SQLException {
		if (resultset != null) {
			resultset.close();
		}
	}

	public static void closePreparedStatement(PreparedStatement preparedStatement) throws SQLException {
		if (preparedStatement != null) {
			preparedStatement.close();
		}
	}

	public static void closeConnection(Connection connection, boolean commit) {
		try {
			if (connection != null) {
				if (commit) {
					connection.commit();
				} else {
					connection.rollback();
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			try {
				connection.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

//	TODO: ESTO ES CON CLASSLOADER.
//	private static final java.util.Properties properties = new Properties();	
//	//static { 
//	    try {
//	      java.lang.Class classDevice = ConnectionManager.class; // podemos programalo nun Singleton
//	      java.lang.ClassLoader classLoader = classDevice.getClassLoader();
//	      InputStream is= classLoader.getResourceAsStream("config.properties");
//	      properties.load(is);
//	    } catch (Exception e) {
//		e.fillInStackTrace();
//	    }

}
