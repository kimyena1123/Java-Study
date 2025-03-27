package fastcampus.java.Course2.Part1.model;

public class MSSQLDriver implements Connection{

    @Override
    public void getConnection(String url, String username, String password) {
        System.out.println("url, username, password 정보를 이용해 MSSQL DB 접속 시도");
    }
}
