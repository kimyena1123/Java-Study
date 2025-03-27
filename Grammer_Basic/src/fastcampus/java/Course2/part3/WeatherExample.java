package fastcampus.java.Course2.part3;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherExample {
    public static void main(String[] args) {
        String apiKey = "e64f5c065c4b4b210995aaf3c995cc47";
        String city = "Seoul";
        String urlString = "https://api.openweathermap.org/data/2.5/weather?lat=37.29851944&lon=-126.8468194&appid=" + apiKey + "&units=metric";


        try{
            URL url = new URL(urlString); // 1. URL 생성
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // 2. HttpURLConnection 초기화
            connection.setRequestMethod("GET"); // 3. HTTP 메서드 설정(예. GET)
            connection.setRequestProperty("Accept", "application/json"); //4. 요청 헤더 설정(선택사항)

            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode); // 6. 응답 헤더 읽기

            if(responseCode == 200){
               //스트림(Stream = 입력, 출력)의 연결
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();
                while((inputLine = in.readLine()) != null) {
                    content.append(inputLine);
                }
                in.close();

                //Gson 라이브러릴 사용하여 온도를 추출
                JsonObject weatherData = JsonParser.parseString(content.toString()).getAsJsonObject();
                JsonObject mainData = weatherData.getAsJsonObject("main");
                double temp = mainData.get("temp").getAsDouble();

                //안산의 온도 출력
                System.out.println("Ansan's temperature: " + temp + "C");

                connection.disconnect();
            }else{
                System.out.println("응답 에러");
            }


        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
