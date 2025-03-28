package kr.pet.mvc;

public class MedicalRecord {
    private String phoneNumber;
    private String date;
    private String content;

    public MedicalRecord(){};

    public MedicalRecord(String phoneNumber, String date, String content) {
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.content = content;
    }

    //setter
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setContent(String content) {
        this.content = content;
    }

    //getter
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getDate() {
        return date;
    }

    public String getContent() {
        return content;
    }

    @Override
    public String toString() {
        return "MedicalRecord{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", date='" + date + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
