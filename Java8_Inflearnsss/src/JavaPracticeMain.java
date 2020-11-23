import chapter3.OnlineClass;
import chapter4.Progress;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

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
    /*public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        *//*Spliterator<String> spliterator = list.spliterator();
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
        while(spliterator1.tryAdvance(System.out::println));*//*

        //removeIf -> Predicate -> 구현문의 boolean을 따진다
        list.removeIf(s -> s.equals("a"));
        list.forEach(System.out::println);

        //자바8부터 인터페이스에 default 함수를 통해 구현체를 넣을 수 있고, static 메소드의 구현체로 넣을 수 있다.
    }*/

    /**
     * Chapter3-1
     * Stream 소개
     */
    /*public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");

        //stream은 element의 연속
        //stream은 소스를 변경하지 않는다.
        //중개와 종료 오퍼레이션이 있다. -> 두개의 차이는 중개는 stream을 반환, 종료는 stream을 반환하지 않음.
        //stream 파이프라인은 0또는 다수의 중개 오퍼레이션과 한개의 종료 오퍼레이션으로 구성.
        //중개는 근본적으로 lazy하다. -> 아래 코드는 실행되지 않는다. 왜냐하면 종료 오퍼레이션을 정의하지 않았기 때문에
        list.stream().map((s) -> {
            System.out.println(s);
            return s.toUpperCase();
        });

        //일반적 처리 (stream)
        List<String> parel1 = list.stream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        parel1.forEach(System.out::println);

        //병렬 처리
        List<String> parel = list.parallelStream().map((s) -> {
            System.out.println(s + " " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).collect(Collectors.toList());
        parel.forEach(System.out::println);
    }*/

    /**
     * Chapter3-2
     * Stream API
     */
    /*public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        System.out.println("spring 으로 시작하는 수업");
        //stream을 반환하지 않으면 모두 종료 오퍼레이션이다
        springClasses.stream()
                .filter(c -> c.getTitle().startsWith("spring"))
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("close 되지 않은 수업");
        springClasses.stream()
                //.filter(oc -> oc.isClosed())
                //static한 메소드 레퍼런스를 호출 하는 것처럼 보이지만 임의 객체의 인스턴스 메소드를 참조하는
                .filter(Predicate.not(OnlineClass::isClosed))   //Predicate.not을 통해 !를 표현
                .forEach(oc -> System.out.println(oc.getId()));

        System.out.println("수업 이름만 모아서 스트림 만들기");
        springClasses.stream()
                .map(OnlineClass::getTitle) //map은 가져오는 데이터를 정해준다
                .forEach(System.out::println);

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> keesunEvents = new ArrayList<>();
        keesunEvents.add(springClasses);
        keesunEvents.add(javaClasses);

        System.out.println("두 수업 목록에 들어있는 모든 수업 아이디 출력");
        keesunEvents.stream()
                .flatMap(Collection::stream)    //두개의 onlineclass리스트의 onlineclass 인스턴스를 일렬로 풀어낸다
                .forEach(onlineClass -> System.out.println(onlineClass.getId()));

        System.out.println("10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");

        //이런 경우 무제한으로 계속 생성 10부터 1씩 증가하면서
        *//*Stream.iterate(10, i -> i + 1)
                .forEach(System.out::println);*//*
        Stream.iterate(10, i -> i + 1)
                .skip(10)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean test = javaClasses.stream().anyMatch(oc -> oc.getTitle().contains("Test"));
        System.out.println(test);

        System.out.println("스프링 수업 중에 제목에 spring이 들어간 것만 모아서 List로 만들기");
        List<String> spring = springClasses.stream()
                .filter(oc -> oc.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                .collect(Collectors.toList());
        spring.forEach(System.out::println);
    }*/

    /**
     * Chapter4
     * Optional
     */
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        //이 경우 jpa가 들은 데이터가 존재하지 않으므로 null pointer exception
        Optional<OnlineClass> optional = springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .findFirst();
        //OnlineClass onlineClass = optional.get();   //권장되지 않음
        //System.out.println(onlineClass.getTitle());
        List<OnlineClass> s = optional.stream().filter(o -> o.getTitle().startsWith("aw")).collect(Collectors.toList());
        optional.ifPresent(oc -> System.out.println(oc.getTitle()));

        //있으면 가져오고 없으면 새로 만든다. //존재해도 실행된다.
        OnlineClass onlineClass = optional.orElse(createNewClasses());
        System.out.println(onlineClass.getTitle());

        //존재하지 않을때만 가져온다.
        OnlineClass onlineClass1 = optional.orElseGet(JavaPracticeMain::createNewClasses);
        System.out.println((onlineClass1.getTitle()));

        //없으면 에러를 던진다.
        OnlineClass onlineClass2 = optional.orElseThrow(IllegalArgumentException::new);

        Optional<OnlineClass> onlineClass3 = optional.filter(Predicate.not(OnlineClass::isClosed));     //비어있다.
        System.out.println(onlineClass3.isEmpty());


        /*Optional<Optional<Progress>> progress = optional.map(OnlineClass::getProgress);
        Optional<Progress> progress1 = progress.orElseThrow();
        progress1.orElseThrow(); //이 구문을 flatMap을 사용하여 한번 optional을 까줄 수 있다.*/

        Optional<Progress> progress2 = optional.flatMap(OnlineClass::getProgress);

        optional.ifPresent(awd -> {
            System.out.println(awd.getTitle());
            //return 0; -> consumer이기때문에 return형이 안된다.
        });
    }


    private static OnlineClass createNewClasses() {
        System.out.println("create new online class");
        return new OnlineClass(10, "new class", false);
    }
}
