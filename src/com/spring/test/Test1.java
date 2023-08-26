// jdbc Batch Updates with Statement

package com.spring.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test1 {

	public static void main(String[] args) throws Exception{
		
		Connection connection = null;
		Statement statement = null;
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost/26aug23?user=root&password=root");
			statement = connection.createStatement();
			statement.addBatch("insert into employee values (777, 'BBB', 2100, 'Goa')");
			statement.addBatch("insert into employee values (888, 'KKK', 2500, 'Gujurat')");
			statement.addBatch("update employee set esal = esal+500 where esal<6000");
			statement.addBatch("delete from employee where eid= 333");
			int[] rowCount = statement.executeBatch();
			//first way
			/*for(int x : rowCount) {
				System.out.println("Row Count: "+x);
				
			}
			*/
			//second way
			
			for(int x = 0; x<rowCount.length; x++) {
				
				System.out.println("Row Count: "+rowCount[x]);
			}
			
			
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		statement.close();
		connection.close();

	}

}
