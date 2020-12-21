public class AdapterTest {
    public static void main(String[] args) {
        APlayer p1 = new APlayerImpl();
        p1.play("aaa.mp3");

        //계약기간 만료로 APlayerImpl()를 사용할 수 없다.
        //이제 BPlayer를 새로 도입
        BPlayer p2 = new BPlayerImpl();
        p2.playFile("bbb.mp3");

        //Adapter
        //Aplayer obj = (어댑터) = new BPlayerImpl();
        /*
        기존의 잘 동작하던 코드와 새로 도입된 코드를
        변경 없이 사용하고 싶다.
        어댑터 적용 후 에러가 난다면 어댑터 부분만 보면 될 것.
        * */
        BPlayer p3 = new BPlayerImpl();
        APlayer p4 = new BToAAdapter1(p3);
        p4.play("aaa.mp3");

        /*
        현재 모든 코드가 APlayer 인터페이스에 맞춰서 코딩되어 있다.
        그러므로 여기서 APlayer에 대입되는 객체만 수정해주면
        APlayer 인터페이스가 사용되는 부분에서는 수정할 필요가 없다.
        * */
    }
}

interface APlayer {
    void play(String fileName);
    void stop();
}

class APlayerImpl implements APlayer {

    @Override
    public void play(String fileName) {
        System.out.println("A " + fileName);
    }

    @Override
    public void stop() {

    }
}

interface BPlayer {
    void playFile(String fileName);
    void stopFile();
}

class BPlayerImpl implements BPlayer {

    @Override
    public void playFile(String fileName) {
        System.out.println("B " + fileName);
    }

    @Override
    public void stopFile() {

    }
}

class BToAAdapter1 implements APlayer {

    private BPlayer media;

    public BToAAdapter1(BPlayer media) {
        this.media = media;
    }

    @Override
    public void play(String fileName) {
        System.out.println("Using Adapter : ");
        media.playFile(fileName);
    }

    @Override
    public void stop() {

    }
}

abstract class BPlayer2 {
    public abstract void playFile(String fileName);
    public abstract void stopFile();
}

class BPlayer2Impl extends BPlayer2 {

    @Override
    public void playFile(String fileName) {
        System.out.println("BEx : " + fileName);
    }

    @Override
    public void stopFile() {

    }
}
class BToAAdapter2 extends BPlayer2Impl implements APlayer {

    @Override
    public void play(String fileName) {
        System.out.println("Using Adapter : ");
        playFile(fileName);     //BPlayer2Impl에 정의 되어있음.
    }

    @Override
    public void stop() {

    }
}