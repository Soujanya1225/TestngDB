package com.toolsqa.main;

import com.toolsqa.beans.FillFormData;
import com.toolsqa.dao.FillformDAO;

public class Tester {

	public static void main(String[] args) {
		FillformDAO ffDao = new FillformDAO();
		FillFormData ffData = ffDao.getFormData("1");
		System.out.println(ffData.getFirstName());
	}

}
