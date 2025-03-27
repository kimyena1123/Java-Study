package fastcampus.java.Course2.Part1.model;

public class MySQLDriver implements Connection{

    @Override
    public void getConnection(String url, String username, String password) {
        System.out.println("url, username, password 정보를 이용해 MySQL DB 접속 시도");

    }
}
