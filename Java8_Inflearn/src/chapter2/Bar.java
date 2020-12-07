package chapter2;

public interface Bar {
    default void printNameUpperCase() {
        System.out.println("test");
    }
}
