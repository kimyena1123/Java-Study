package fastcampus.java.Course1.poly;

public class Radio implements RemoCon{
    //chUp(), chDown(), volUp(), volDown()

    private int currentCH = 10;

    @Override
    public void chUp() {
        currentCH++;
        if(currentCH > RemoCon.MAXCH){
            System.out.println("채널 끝부분 도달. 처음으로 돌아감");
            currentCH = RemoCon.MINCH;
        }
        System.out.println("RADIO 채널 UP");
    }

    @Override
    public void chDown() {
        currentCH--;
        if(currentCH < RemoCon.MINCH){
            System.out.println("채널 최소부분 도달. 끝으로 돌아감");
            currentCH =RemoCon. MAXCH;
        }
        System.out.println("RADIO 채널 DOWN");
    }

    @Override
    public void volUp() {
        System.out.println("RADIO VOL UP");

    }

    @Override
    public void volDown() {
        System.out.println("RADIO VOL DOWN");

    }

    @Override
    public void internet() {
        System.out.println("Radio에서는 인터넷 지원 X");
    }
}
