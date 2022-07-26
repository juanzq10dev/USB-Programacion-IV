package person;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PersonTest {
    @Test
    public void compareTo_DifferentDateBirthday_Negative1() {
        Person john = new Person("John", "2000-01-01", "123456789");
        Person brandon = new Person("Brandon", "2000-01-02", "123456789");
        
        int expected = -1;
        int actual = john.compareTo(brandon);
        assertEquals(expected, actual);
    }

    @Test
    public void compareTo_DifferentDateBirthday_1() {
        Person john = new Person("John", "2000-01-01", "123456789");
        Person brandon = new Person("Brandon", "2000-01-02", "123456789");
        
        int expected = 1;
        int actual = brandon.compareTo(john);
        assertEquals(expected, actual);
    }

    @Test
    public void compareTo_DifferentMonthBirthday_Negative1() {
        Person john = new Person("John", "2000-01-01", "123456789");
        Person brandon = new Person("Brandon", "2000-02-01", "123456789");
        
        int expected = -1;
        int actual = john.compareTo(brandon);
        assertEquals(expected, actual);
    }

    @Test
    public void compareTo_DifferentMonthBirthday_1() {
        Person john = new Person("John", "2000-01-01", "123456789");
        Person brandon = new Person("Brandon", "2000-02-01", "123456789");
        
        int expected = 1;
        int actual = brandon.compareTo(john);
        assertEquals(expected, actual);
    }

    @Test
    public void compareTo_DifferentYearBirthday_Negative1() {
        Person john = new Person("John", "2000-01-01", "123456789");
        Person brandon = new Person("Brandon", "2001-01-01", "123456789");
        
        int expected = -1;
        int actual = john.compareTo(brandon);
        assertEquals(expected, actual);
    }

    @Test
    public void compareTo_DifferentYearBirthday_1() {
        Person john = new Person("John", "2000-01-01", "123456789");
        Person brandon = new Person("Brandon", "2001-01-01", "123456789");
        
        int expected = 1;
        int actual = brandon.compareTo(john);
        assertEquals(expected, actual);
    }

    @Test
    public void compareTo_DifferentCI_Negative1() {
        Person john = new Person("John", "2000-01-01", "123456788");
        Person brandon = new Person("Brandon", "2000-01-01", "123456789");
        
        int expected = -1;
        int actual = john.compareTo(brandon);
        assertEquals(expected, actual); 
    }

    @Test
    public void compareTo_DifferentCI_1() {
        Person john = new Person("John", "2000-01-01", "123456788");
        Person brandon = new Person("Brandon", "2000-01-01", "123456789");
        
        int expected = 1;
        int actual = brandon.compareTo(john);
        assertEquals(expected, actual);
    }

    @Test
    public void compareTo_Same_0() {
        Person john = new Person("John", "2000-01-01", "123456789");
        Person brandon = new Person("Brandon", "2000-01-01", "123456789");
        
        int expected = 0;
        int actual = john.compareTo(brandon);
        assertEquals(expected, actual);
    }
 }
