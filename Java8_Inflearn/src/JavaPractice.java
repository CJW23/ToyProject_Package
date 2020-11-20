import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class JavaPractice {
    public static void main(String[] args) {
        Function<Integer, Integer> plus10 = (n) -> n + 10;
        Function<Integer, Integer> mul10 = (n) -> n * 10;
        //plus10 실행전에 mul10함수에 입력값을 넣어 결과값을 plus10넣음
        System.out.println(Integer.toString(plus10.compose(mul10).apply(2)));
        System.out.println(Integer.toString(plus10.andThen(mul10).apply(2)));

        //리턴값이 없음
        Consumer<Integer> print = (i) -> System.out.println(i);
        print.accept(2);

        //true, false 반환
        Predicate<String> pre = (str) -> {
            return str.equals("a");
        };
        System.out.println(pre.test("a"));
        System.out.println(pre.test("b"));
    }
}
