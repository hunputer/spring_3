package com.choa.s3.util;

public class DBMain {

	public static void main(String[] args) {
		DBConnector dbConnector = new DBConnector();
		
		try {
			dbConnector.getConnect();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
