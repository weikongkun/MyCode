import java.sql.*;

public class SimpleJDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/javabook", "scott", "tiger");
		System.out.println("Database connected");
		
		Statement statement = connection.createStatement();
		
		ResultSet resultSet = statement.executeQuery("select * from course");
		
		while (resultSet.next())
			System.out.println(resultSet.getString(1) + "\t" +
		resultSet.getString(2) + "\t");
		
		ResultSetMetaData rsMetaData = resultSet.getMetaData();
		
		for (int i = 1; i <= rsMetaData.getColumnCount(); i++)
			System.out.printf("%-12s\t", rsMetaData.getColumnName(i));
		System.out.println();
		resultSet = statement.executeQuery("select * from course");
		while(resultSet.next()) {
			for (int i = 1; i <= rsMetaData.getColumnCount(); i++)
				System.out.printf("%-12s\t", resultSet.getString(i));
			System.out.println();
		}
		connection.close();
	}

}
