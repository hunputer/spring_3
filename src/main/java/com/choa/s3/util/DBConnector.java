package com.choa.s3.util;

import java.sql.Connection;
import java.sql.DriverManager;

import org.springframework.stereotype.Component;

@Component
public class DBConnector {
	
	public Connection getConnect() throws Exception {
		//1. 연결정보
		String id = "hr";
		String pw = "tiger";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String driver ="oracle.jdbc.driver.OracleDriver";
		//2. 드라이버를 메모리에 로딩
		Class.forName(driver);
		
		//3. 드라이버를 
		System.out.println("driver 로딩 완료");
		
		Connection con = DriverManager.getConnection(url, id, pw);
		System.out.println("로그인 성공");
		System.out.println(con);
		
		return con;
	}
}
