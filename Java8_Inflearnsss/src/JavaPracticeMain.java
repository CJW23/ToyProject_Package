import chapter1.Greeting;
import chapter1.Plus10;
import chapter2.DefaultFoo;
import chapter2.Foo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;
import java.util.function.*;

public class JavaPracticeMain {
    /**
     * Chapter1-2
     * 람다, 함수형 인터페이스
     * 2020.11.19
     */
    /*public static void main(String[] args) {
        Plus10 p = new Plus10();
        System.out.println(p.apply(2));

        Function<Integer, Integer> plus10 = (n) -> n + 10;
        Function<Integer, Integer> mul10 = (n) -> n * 10;
        //plus10 실행전에 mul10함수에 입력값을 넣어 결과값을 plus10넣음
        System.out.println(Integer.toString(plus10.compose(mul10).apply(2)));
        System.out.println(Integer.toString(plus10.andThen(mul10).apply(2)));

        //리턴값이 없음
        Consumer<Integer> print = (i) -> System.out.println(i);
        print.accept(2);

        //인자값 없이 타입 값 제공
        Supplier<String> s = () -> "test";
        System.out.println(s.get());

        //true, false 반환
        Predicate<String> pre = (str) -> {
            return str.equals("a");
        };
        System.out.println(pre.test("a"));
        System.out.println(pre.test("b"));
    }*/

    /**
     * Chapter1-4
     * 메소드 레퍼런스
     * 2020.11.20
     */
    /*public static void main(String[] args){
        //.Greeting 클래스의 static method hi()를 사용, 이러한 형태를 '메소드 레퍼런스' 라고 함
        UnaryOperator<String> hi = Greeting::hi;
        System.out.println(hi.apply("hi"));

        //hello()가 static 이 아니라 객체 생성후 사용
        Greeting greeting = new Greeting();
        Function<String, String> hello = greeting::hello;
        System.out.println(hello.apply("hello"));

        Supplier<Greeting> newGreeting = Greeting::new;
        Greeting g = newGreeting.get();
        System.out.println(g.hello("awd"));

        Function<String, Greeting> newGreeting2 = Greeting::new;
        Greeting g2 = newGreeting2.apply("constructor");
        System.out.println(g2.getName());

        String[] names = {"a", "b", "c"};
        Arrays.sort(names, String::compareToIgnoreCase);
    }*/

    /**
     * Chapter2-1
     * 인터페이스 기본 메소드와 스태틱 메소드
     * 2020.11.21
     */
    /*public static void main(String[] args) {
        Foo foo = new DefaultFoo("cjw");
        foo.printName();
        //default 메소드 호출
        foo.printNameUpperCase();
        Foo.printAnything();
    }*/

    /**
     * Chapter2-2
     * 자바8 API의 기본메소드와 스태틱 메소드
     */
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        /*Spliterator<String> spliterator = list.spliterator();
        //List의 forEach
        list.forEach(System.out::println);
        list.forEach((str) -> {
            System.out.println(str);
        });
        //두개는 똑같음
        //while(spliterator.tryAdvance(System.out::println));
        //while(spliterator.tryAdvance((str) -> {System.out.println(str);}));

        //Spliterator는 두번 순환을 안하는듯.
        Spliterator<String> spliterator1 = spliterator.trySplit();
        while(spliterator.tryAdvance(System.out::println));
        while(spliterator1.tryAdvance(System.out::println));*/

        //removeIf -> Predicate -> 구현문의 boolean을 따진다
        list.removeIf(s -> s.equals("a"));
        list.forEach(System.out::println);
    }
}
