//  Jdbc Batch Updates with PreparedStatement

package com.spring.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Test2 {

	public static void main(String[] args) throws Exception{
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/26aug23?user=root&password=root");
			preparedStatement = connection.prepareStatement("insert into student values(?,?,?,?)");
			
			preparedStatement.setInt(1, 111);
			preparedStatement.setString(2, "AAA");
			preparedStatement.setInt(3, 13);
			preparedStatement.setString(4, "A");
			preparedStatement.addBatch();
			
			preparedStatement.setInt(1, 222);
			preparedStatement.setString(2, "BBB");
			preparedStatement.setInt(3, 5);
			preparedStatement.setString(4, "C");
			preparedStatement.addBatch();
			
			preparedStatement.setInt(1, 333);
			preparedStatement.setString(2, "CCC");
			preparedStatement.setInt(3, 11);
			preparedStatement.setString(4, "C");
			preparedStatement.addBatch();
			
			preparedStatement.setInt(1, 444);
			preparedStatement.setString(2, "DDD");
			preparedStatement.setInt(3, 45);
			preparedStatement.setString(4, "D");
			preparedStatement.addBatch();
			
			int[] rowCount = preparedStatement.executeBatch();
			for(int i : rowCount) {
				System.out.println("Row Count: "+i);
			}
			
			System.out.println("table updated successfully");
			
			
			
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		
		connection.close();

	}

}
