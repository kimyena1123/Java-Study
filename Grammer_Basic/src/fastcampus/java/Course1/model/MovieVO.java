package fastcampus.java.Course1.model;

public class MovieVO {
    private String title;
    private int day;
    private String major;
    private String part;
    private float time;
    private int level;

    //default constructor (기본 생성자)
    public MovieVO() {
    }

    //생성자 오버로딩(Overloading)
    public MovieVO(String title, int day, String major, String part, float time, int level) {
        this.title = title;
        this.day = day;
        this.major = major;
        this.part = part;
        this.time = time;
        this.level = level;
    }

    //setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setPart(String part) {
        this.part = part;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    //getter

    public String getTitle() {
        return title;
    }

    public int getDay() {
        return day;
    }

    public String getMajor() {
        return major;
    }

    public String getPart() {
        return part;
    }

    public float getTime() {
        return time;
    }

    public int getLevel() {
        return level;
    }

    //toString()

    @Override
    public String toString() {
        return "MovieVO{" +
                "title='" + title + '\'' +
                ", day=" + day +
                ", major='" + major + '\'' +
                ", part='" + part + '\'' +
                ", time=" + time +
                ", level=" + level +
                '}';
    }
}
