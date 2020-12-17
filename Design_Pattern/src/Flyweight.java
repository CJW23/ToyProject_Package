import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Flyweight {
    private static Map<String, Subject> map = new HashMap<>();

    public Subject getSubject(String key) {
        Subject subject = map.get(key);
        if(subject == null) {
            subject = new Subject(key);
            map.put(key, subject);
            System.out.println("새로 생성 : " + key);
        } else {
            System.out.println("재사용 : " + key);
        }
        return subject;
    }
}

class Subject {
    private String name;

    public Subject(String name) {
        this.name = name;
    }
}

/*
public class Main {
    public static void main(String[] args) {
        Flyweight flyweight = new Flyweight();
        flyweight.getSubject("a");
        flyweight.getSubject("a");
        flyweight.getSubject("b");
        flyweight.getSubject("b");
    }
}*/
