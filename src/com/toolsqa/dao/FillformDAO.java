package com.toolsqa.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.toolsqa.beans.FillFormData;


public class FillformDAO {
	
	private FillFormData formdata;
	
	public FillFormData getFormData(String testCaseID){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = null;
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "soujanya", "Hello123");
			PreparedStatement statement = connection.prepareStatement("SELECT * from FORM_TABLE WHERE TC_ID=?");
			statement.setString(1,testCaseID);
			ResultSet rs=statement.executeQuery();
			while (rs.next()) {
				formdata = new FillFormData(rs.getString("FIRST_NAME"), rs.getString("LAST_NAME"),
						rs.getString("PICK_DATE"),rs.getInt("TC_ID"));
			}
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return formdata;
	}

}
