package com.lab4dx.l06_mvc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    //싱글톤패톤 : public static 으로 선언한 변수는 class 로더가 메소드와 클래스를 분석할때 객체로 만들어서 저장 후
    //어디서든 접근 가능한데 객체가 존재하지 않거나 닫혀있을 수 있기 때문에 반환하는 함수에서 if문을 작성하는 디자인 패턴!
    //=> 객체를 한번만 생성해서 사용가능(메모리 절약), 구현이 어렵다.(오류 많다)
    //static 으로 선언된 변수나 메소드는 GC이 정리하지 않는다-> 불변 데이터(상수)
    private static Connection conn; //캡슐화(private:class 내부에서만 접근, public:어디서든 )

    public static Connection getConnection() throws Exception {
        if(conn==null || conn.isClosed()){
            //만약에 비어있거나 닫혀있으면 컨넥션을 맺어준다.
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String driver = "oracle.jdbc.driver.OracleDriver";
            String username = "c##lab4dx";
            String password = "oracle";
            Class.forName(driver);
            conn= DriverManager.getConnection(url, username, password);
            return conn;
        }
        return conn; //컨넥션이 맺어져있으면 그냥 바로 반환
    }
    //
    public static void main(String[] args) {
        try {
            System.out.println(DBConnection.getConnection());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
