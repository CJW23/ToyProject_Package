package chapter2;

public class DefaultFoo implements Foo{
    String name;

    public DefaultFoo(String name) {
        this.name = name;
    }

    /*
    //default 메소드는 재정의 가능
    //Bar 클래스에도 동일 default메소드가 존재한다 만약 Foo, Bar 두개를 상속할 시 무조건 재정의를 해야줘함
    @Override
    public void printNameUpperCase() {
        System.out.println(this.name.toUpperCase());
    }*/

    @Override
    public void printName() {
        System.out.println(this.name);
    }

    @Override
    public String getName() {
        return this.name;
    }
}
