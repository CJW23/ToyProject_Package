public class Builder {
    /*public static void main(String[] args) {
        Person person = Person.builder()
                .a("a")
                .b("b")
                .c("c")
                .d("d")
                .build();
        System.out.println(
                person.getA() +
                        person.getB() +
                        person.getC() + person.getD());
    }*/
}

class Person {
    private String a;
    private String b;
    private String c;
    private String d;

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    String getA() {
        return a;
    }

    String getB() {
        return b;
    }

    String getC() {
        return c;
    }

    String getD() {
        return d;
    }

    static class PersonBuilder {
        String a;
        String b;
        String c;
        String d;

        PersonBuilder a(String a) {
            this.a = a;
            return this;
        }

        PersonBuilder b(String b) {
            this.b = b;
            return this;
        }

        PersonBuilder c(String c) {
            this.c = c;
            return this;
        }

        PersonBuilder d(String d) {
            this.d = d;
            return this;
        }

        Person build() {
            Person person = new Person();
            person.a = this.a;
            person.b = this.b;
            person.c = this.c;
            person.d = this.d;
            return person;
        }
    }
}