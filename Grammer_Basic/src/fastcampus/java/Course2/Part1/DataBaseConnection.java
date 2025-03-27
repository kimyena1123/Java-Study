package fastcampus.java.Course2.Part1;

import fastcampus.java.Course2.Part1.model.Connection;
import fastcampus.java.Course2.Part1.model.MSSQLDriver;
import fastcampus.java.Course2.Part1.model.MySQLDriver;
import fastcampus.java.Course2.Part1.model.OracleDriver;

public class DataBaseConnection {
    public static void main(String[] args) {
        //oracle DB 접속
        Connection conn = new OracleDriver();
        conn.getConnection("jdbc:oracle:thin:@localhost:1521:XE","kimyena", "7777");

        //MySQL DB 접속
        conn = new MySQLDriver();
        conn.getConnection("jdbc:mysql://localhost:3306/test", "kimyena", "7777");

        //MSSQL DB 접속
        conn = new MSSQLDriver();
        conn.getConnection("jdbc:sqlserver://localhost:1433;DatabaseName=test", "kimyena", "7777");

    }
}
