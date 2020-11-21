package chapter2;

public interface Foo{
    void printName();
    default void printNameUpperCase() {
        System.out.println(getName().toUpperCase());
    }

    static void printAnything() {
        System.out.println("static");
    }
    /*
    //Object 메소드는 default 메소드로 제공 불가
    default String toString();
    */
    String getName();
}
