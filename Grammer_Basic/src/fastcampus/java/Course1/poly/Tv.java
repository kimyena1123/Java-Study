package fastcampus.java.Course1.poly;

public class Tv implements RemoCon{
    //chUp(), chDown(), volUp(), volDown()
    private int currentCH = 10;

    @Override
    public void chUp() {
        currentCH++;
        if(currentCH > RemoCon.MAXCH){
            System.out.println("채널 끝부분 도달. 처음으로 돌아감");
            currentCH = RemoCon.MINCH;
        }
        System.out.println("TV 채널 UP");
    }

    @Override
    public void chDown() {
        currentCH--;
        if(currentCH < RemoCon.MINCH){
            System.out.println("채널 최소부분 도달. 끝으로 돌아감");
            currentCH =RemoCon. MAXCH;
        }
        System.out.println("TV 채널 DOWN");
    }

    @Override
    public void volUp() {
        System.out.println("TV VOL UP");
    }

    @Override
    public void volDown() {
        System.out.println("TV VOL DOWN");
    }

    @Override
    public void internet() {
        System.out.println("TV에서 인터넷 사용 가능함");
    }

}
