import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//이벤트 발생시키는 객체 인터페이스
interface Publisher {
    //관찰자 객체 추가
    public void addObserver(Observer o);
    //관찰자 객체 삭제
    public void deleteObserver(Observer o);
    //관찰자들에게 이벤트 발생 전달
    public void notifyObservers();
}

//이벤트 객체 구현
class PlayController implements Publisher {
    private List<Observer> observers = new ArrayList<>();
    private boolean play;
    private Observer myOb;

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deleteObserver(Observer o) {
        observers.remove(o);
    }

    //옵저버들에게 변경사항을 전달
    @Override
    public void notifyObservers() {
        //옵저버 목록들에게 이벤트 전달
        for (int i=0; i<observers.size(); i++) {
            observers.get(i).notify(play);
        }
    }

    //이벤트 발생 함수
    public void setFlag(boolean play) {
        this.play = play;
        notifyObservers();
    }

    public boolean getFlag() {
        return play;
    }
}

//관찰자 객체 인터페이스
interface Observer {
    //이벤트 발생에 따른 행위
    public void notify(boolean play);
}

//관찰자 객체 구현
class ObserverA implements Observer {
    private boolean bPlay;
    private Publisher publisher;

    public ObserverA(Publisher publisher) {
        this.publisher = publisher;
        publisher.addObserver(this);
    }

    @Override
    public void notify(boolean play) {
        this.bPlay = play;
        myActControl();
    }

    public void myActControl() {
        if (bPlay) {
            System.out.println("MyClassA : 동작을 시작합니다.");
        } else {
            System.out.println("MyClassA : 동작을 정지합니다.");
        }
    }
}

///관찰자 객체 구현
class ObserverB implements Observer {
    private boolean bPlay;

    public ObserverB(Publisher publisher) {
        publisher.addObserver(this);
    }

    @Override
    public void notify(boolean play) {
        this.bPlay = play;
        myActControl();
    }

    public void myActControl() {
        if (bPlay) {
            System.out.println("MyClassB : 동작을 시작합니다.");
        } else {
            System.out.println("MyClassB : 동작을 정지합니다.");
        }
    }
}

//main 테스트
public class ObserverTest {
    public static void main(String[] args) {
        PlayController playController = new PlayController();
        Observer ob1 = new ObserverA(playController);
        Observer ob2 = new ObserverB(playController);

        playController.setFlag(true);

        playController.deleteObserver(ob1);
        playController.setFlag(false);



        Button button1 = new Button();
        button1.setButtonListener(() -> {
            System.out.println("버튼 클릭");
        });

        button1.notifyButton();
    }
}



interface ButtonPublisher {
    public void setButtonListener(Button.OnClickListener listener);
    public void notifyButton();
}


class Button implements ButtonPublisher {
    OnClickListener listener;

    @Override
    public void setButtonListener(OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void notifyButton() {
        listener.Onclick();
    }

    interface OnClickListener {
        void Onclick();
    }
}