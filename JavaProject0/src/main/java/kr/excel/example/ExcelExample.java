package kr.excel.example;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelExample {
    public static void main(String[] args) {
        try{
            //파일 읽어들이기
            //example.xlsx를 File 객체로 생성해서 FileInputStream과 연결해주면 엑셀파일을 읽을 수 있다
            FileInputStream file = new FileInputStream(new File("example.xlsx"));

            //실제 엑셀 파일을 핸들링 하려면 메모리에 가상의 엑셀을 만들어야 한다.
            //이 메모리에 있는 가상의 엑셀을 "workbook"이라고 한다. 이 workbook 형태로 만들어줘야 한다.
            //스트림을 통해 엑셀 파일을 읽어서 workbook을 만들어준다
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);

            for(Row row : sheet) {
                for(Cell cell: row){
                    switch(cell.getCellType()){
                        case NUMERIC: // 숫자 데이터 타입
                            if(DateUtil.isCellDateFormatted(cell)){ //하나의 셀(cell)이 날짜 형식이면, cell에 들어있는 값의 형식이 날짜이면
                                Date dateValue = cell.getDateCellValue(); //getDateCellValue로 날짜형식의 값을 가져온다
                                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd"); //이 형식으로 날짜를 지정하고 싶다
                                String formattedDate = dateFormat.format(dateValue); //위 형식에 맞게 가져온 값을 적용

                                System.out.print(formattedDate + "\t");
                            }else{ // 숫자 데이터 타입이고, 날짜 형식이 아니라면
                                double numericValue = cell.getNumericCellValue(); //getNumericCellValue로 cell의 값을 가져와 double형으로 저장

                                if(numericValue == Math.floor(numericValue)){ //정수형 데이터 타입이라면(Math.floor로 정수형인지 확인)
                                    int intValue = (int) numericValue; // 위에 double 형으로 저장해둔걸 int형으로 변경

                                    System.out.print(intValue + "\t");
                                }else{ //정수형 데이터 타입이 아니라면
                                    System.out.print(numericValue + "\t");
                                }
                            }
                            break;

                        case STRING:
                            String stringValue = cell.getStringCellValue();
                            System.out.print(stringValue + "\t");
                            break;
                        case BOOLEAN:
                            boolean booleanValue = cell.getBooleanCellValue();
                            System.out.print(booleanValue + "\t");
                            break;
                        case FORMULA: // 수식같은 경우
                            String formulaValue = cell.getCellFormula();
                            System.out.print(formulaValue + "\t");
                            break;
                        case BLANK: // 아무것도 없는 경우(빈칸)
                            System.out.print("\t");
                            break;
                        default:
                            System.out.print("\t");
                            break;
                    }
                }
                System.out.println();
            }
            file.close();
            System.out.println("엑셀에서 데이터 읽어오기 성공");

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
