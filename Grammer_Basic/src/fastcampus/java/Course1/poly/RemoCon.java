package fastcampus.java.Course1.poly;

//추상클래스 = 추상 메서드 + 구현 메서드
public interface RemoCon {
    //chUp(), chDown(), volUp(), volDown()
    public final static int MAXCH = 99; // public int MAXCH = 99;
    public static final int MINCH = 1; // public int MINCH = 1;

    public void chUp();
    public void chDown();
    public void volUp();
    public void volDown();

//    public void internet(){
//        System.out.println("인터넷 사용중");
//    }
    public void internet();
}
