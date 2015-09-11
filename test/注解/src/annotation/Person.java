package annotation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Person {

    private int    id;
    private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public boolean equals(Person person) {
        return person.id == id;
    }

    public int hashCode() {
        return id;
    }

    public static void main(String[] args) {

        Map<Person,Integer> set = new HashMap<Person,Integer>();
        for (int i = 0; i < 10; i++) {
            set.put(new Person(1, "Jim"),1);
        }
        System.out.println(set.size());
    }
}