import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ObserverTest {
    public static void main(String[] args) {
        PlayController playController = new PlayController();
        Observer ob1 = new MyClassA(playController);
        Observer ob2 = new MyClassB(playController);

        //playController.setFlag(true);
        //playController.setFlag(false);

        playController.deleteObserver(ob1);
        playController.setFlag(false);


        //Listener
        PlayController button = new PlayController();
        button.setListener(new Observer() {
            @Override
            public void update(boolean play) {

            }

            @Override
            public void onClick() {
                System.out.println("onClick Listener");
            }
        });
        button.play();
    }
}

interface Observer {
    public void update(boolean play);
    public void onClick();
}

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
        for (int i=0; i<observers.size(); i++) {
            observers.get(i).update(play);
        }
    }

    public void setFlag(boolean play) {
        this.play = play;
        notifyObservers();
    }

    public boolean getFlag() {
        return play;
    }

/////Listener처럼 구현
    public void play() {
        myOb.onClick();
    }
    public void setListener(Observer o) {
        this.myOb = o;
    }
}

interface Publisher {
    public void addObserver(Observer o);

    public void deleteObserver(Observer o);

    public void notifyObservers();
}

class MyClassA implements Observer {
    private boolean bPlay;
    private Publisher publisher;

    public MyClassA(Publisher publisher) {
        this.publisher = publisher;
        publisher.addObserver(this);
    }

    @Override
    public void update(boolean play) {
        this.bPlay = play;
        myActControl();
    }

    @Override
    public void onClick() {

    }

    public void myActControl() {
        if (bPlay) {
            System.out.println("MyClassA : 동작을 시작합니다.");
        } else {
            System.out.println("MyClassA : 동작을 정지합니다.");
        }
    }
}

class MyClassB implements Observer {
    private boolean bPlay;
    private Publisher publisher;

    public MyClassB(Publisher publisher) {
        this.publisher = publisher;
        publisher.addObserver(this);
    }

    @Override
    public void update(boolean play) {
        this.bPlay = play;
        myActControl();
    }

    @Override
    public void onClick() {

    }

    public void myActControl() {
        if (bPlay) {
            System.out.println("MyClassB : 동작을 시작합니다.");
        } else {
            System.out.println("MyClassB : 동작을 정지합니다.");
        }
    }
}