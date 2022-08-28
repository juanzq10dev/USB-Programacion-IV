package person;

import java.time.LocalDate;
import java.util.Objects;

public class Person implements Comparable<Person> {
    private String name;
    private LocalDate birthday;
    private String CI;

    public Person(String name, String birthday, String CI) {
        this.name = name;
        this.CI = CI;
        this.birthday = LocalDate.parse(birthday);
    }

    @Override
    public int compareTo(Person o) {
        if (this.birthday.equals(o.birthday)) {
            return this.CI.compareTo(o.CI);
        } else {
            return this.birthday.compareTo(o.birthday);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(birthday, person.birthday) && Objects.equals(CI, person.CI);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthday, CI);
    }

    @Override
    public String toString() {
        return "{" + name + ", " + birthday + ", " + CI + '}';
    }    
}
