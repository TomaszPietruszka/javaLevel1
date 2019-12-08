package zajecia3.kolejki;

public class MainClass {
    public static void main(String[] args) {
        Person p1 = new Person("A", "C");
        Person p2 = new Person("X", "Y");
        Person p3 = new Person("E", "F");
        Person p4 = new Person("P", "K");
        Person p5 = new Person("V", "L");
        Person p6 = new Person("H", "I");
        Person p7 = new Person("Q", "U");
        CustomList list = new CustomList();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        list.add(p6);
        list.add(p7);
        System.out.println(list.remove(7));
    }
}

class CustomList {
    private Person last;
    private int size;

    public void add(Person person) {
        if (last == null) {
            last = person;
        } else {
            person.setPrev(last);
            last = person;
        }
        size++;
    }

    public Person remove(int personToRemove) {
        Person result = null;
        if (size == 1) {
            result = last;
            last = null;
        } else {
            Person temp = last;
            int indeks = 0;
            while (temp.getPrev().getPrev() != null) {
                indeks++;
                temp = temp.getPrev();
                if (indeks == personToRemove - 1){
                    temp.setPrev(temp.getPrev().getPrev());
                    result = temp.getPrev();
                }
            }
        }
        size--;
        return result;
    }

    public int size() {
        return size;
    }
}

class Person {
    private String name;
    private String surname;
    private Person prev;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person getPrev() {
        return prev;
    }

    public void setPrev(Person prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {
        return "Person[name=" + name
                + ", surname=" + surname
                + "]";
    }
}
