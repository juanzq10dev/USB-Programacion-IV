package binarySearchTree;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import person.Person;

public class BinarySearchTreeTest {
    @Test
    public void insert_String_True() {
        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        tree.insert("John");
        tree.insert("Brandon");
        tree.insert("Pedro");
        tree.insert("Carlos");

        Node<String> john = new Node<>("John");
        Node<String> brandon = new Node<>("Brandon");
        Node<String> pedro = new Node<>("Pedro");
        Node<String> carlos = new Node<>("Carlos");
        john.setLeftNode(brandon);
        john.setRightNode(pedro);
        brandon.setRightNode(carlos);
        BinarySearchTree<String> tree2 = new BinarySearchTree<String>(john);

        assertTrue(tree.equals(tree2));
    }

    @Test
    public void insert_Integer_True() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(-2);

        Node<Integer> one = new Node<>(1);
        Node<Integer> two = new Node<>(2);
        Node<Integer> three = new Node<>(3);
        Node<Integer> negativeTwo = new Node<>(-2);
        one.setRightNode(two);
        one.setLeftNode(negativeTwo);
        two.setRightNode(three);
        BinarySearchTree<Integer> tree2 = new BinarySearchTree<Integer>(one);

        assertTrue(tree.equals(tree2));
    }

    @Test
    public void insert_Person_True() {
        BinarySearchTree<Person> tree = new BinarySearchTree<Person>();
        tree.insert(new Person("John", "2010-05-01", "123456789"));
        tree.insert(new Person("Brandon", "2010-05-01", "123456788"));
        tree.insert(new Person("Pedro", "2011-05-01", "123456787"));
        tree.insert(new Person("Carlos", "2009-05-01", "123456786"));

        Node<Person> john = new Node<>(new Person("John", "2010-05-01", "123456789"));
        Node<Person> brandon = new Node<>(new Person("Brandon", "2010-05-01", "123456788"));
        Node<Person> pedro = new Node<>(new Person("Pedro", "2011-05-01", "123456787"));
        Node<Person> carlos = new Node<>(new Person("Carlos", "2009-05-01", "123456786"));
        john.setLeftNode(brandon);
        john.setRightNode(pedro);
        brandon.setLeftNode(carlos);
        BinarySearchTree<Person> tree2 = new BinarySearchTree<Person>(john);

        assertTrue(tree.equals(tree2));
    }

    @Test
    public void search_String_ValidSearchValue() {
        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        tree.insert("John");
        tree.insert("Brandon");
        tree.insert("Pedro");
        tree.insert("Carlos");

        
        Node<String> actual = tree.search("Brandon");
        Node<String> expected = new Node<>("Brandon");
        assertEquals(expected.getData(), actual.getData());
    }

    @Test
    public void search_String_InvalidSearchValue() {
        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        tree.insert("John");
        tree.insert("Brandon");
        tree.insert("Pedro");
        tree.insert("Carlos");

        assertThrows(IllegalArgumentException.class, () -> tree.search("Roman"));
    }

    @Test
    public void search_Integer_ValidSearchValue() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(-2);

        Node<Integer> actual = tree.search(-2);
        Node<Integer> expected = new Node<>(-2);
        assertEquals(expected.getData(), actual.getData());
    }

    @Test
    public void search_Integer_InvalidSearchValue() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(-2);

        assertThrows(IllegalArgumentException.class, () -> tree.search(4));
    }

    @Test
    public void search_Person_ValidSearchValue() {
        BinarySearchTree<Person> tree = new BinarySearchTree<Person>();
        tree.insert(new Person("John", "2010-05-01", "123456789"));
        tree.insert(new Person("Brandon", "2010-05-01", "123456788"));
        tree.insert(new Person("Pedro", "2011-05-01", "123456787"));
        tree.insert(new Person("Carlos", "2009-05-01", "123456786"));

        Node<Person> actual = tree.search(new Person("Carlos", "2009-05-01", "123456786"));
        Node<Person> expected = new Node<>(new Person("Carlos", "2009-05-01", "123456786"));
        assertEquals(expected.getData(), actual.getData());
    }

    @Test
    public void search_Person_InvalidSearchValue() {
        BinarySearchTree<Person> tree = new BinarySearchTree<Person>();
        tree.insert(new Person("John", "2010-05-01", "123456789"));
        tree.insert(new Person("Brandon", "2010-05-01", "123456788"));
        tree.insert(new Person("Pedro", "2011-05-01", "123456787"));
        tree.insert(new Person("Carlos", "2009-05-01", "123456786"));

        assertThrows(IllegalArgumentException.class, () -> tree.search(new Person("Roman", "2010-06-01", "123456789")));
    }

    @Test
    public void delete_String_ValidValue() {
        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        tree.insert("John");
        tree.insert("Brandon");
        tree.insert("Pedro");
        tree.insert("Carlos");

        tree.delete("Brandon");

        Node<String> john = new Node<String>("John");
        Node<String> pedro = new Node<String>("Pedro");
        Node<String> carlos = new Node<String>("Carlos");
        john.setRightNode(pedro);
        john.setLeftNode(carlos);
        BinarySearchTree<String> tree2 = new BinarySearchTree<String>(john);

        assertTrue(tree.equals(tree2));
    }

    @Test
    public void delete_String_InvalidValue() {
        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        tree.insert("John");
        tree.insert("Brandon");
        tree.insert("Pedro");
        tree.insert("Carlos");

        assertThrows(IllegalArgumentException.class, () -> tree.delete("Roman"));
    }

    @Test
    public void delete_Integer_ValidValue() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(3);
        tree.insert(2);
        tree.insert(-2);
        tree.insert(4);
        tree.insert(-5);
        tree.insert(-3);
        tree.insert(-1);
        tree.delete(-2);

        Node<Integer> one = new Node<Integer>(1);
        Node<Integer> three = new Node<Integer>(3);
        Node<Integer> two = new Node<Integer>(2);
        Node<Integer> four = new Node<Integer>(4);
        Node<Integer> negativeFive = new Node<Integer>(-5);
        Node<Integer> negativeThree = new Node<Integer>(-3);
        Node<Integer> negativeOne = new Node<Integer>(-1);
        one.setRightNode(three);
        one.setLeftNode(negativeOne);
        three.setRightNode(four);
        three.setLeftNode(two);
        negativeOne.setLeftNode(negativeFive);
        negativeFive.setRightNode(negativeThree);

        BinarySearchTree<Integer> tree2 = new BinarySearchTree<Integer>(one);

        assertTrue(tree.equals(tree2));
    }

    @Test  
    public void delete_Integer_InvalidValue() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(3);
        tree.insert(2);
        tree.insert(-2);
        tree.insert(4);
        tree.insert(-5);
        tree.insert(-3);
        tree.insert(-1);
        assertThrows(IllegalArgumentException.class, () -> tree.delete(5));
    }

    @Test
    public void delete_Person_ValidValue() {
        BinarySearchTree<Person> tree = new BinarySearchTree<Person>();
        tree.insert(new Person("John", "2010-05-01", "123456789"));
        tree.insert(new Person("Brandon", "2010-05-01", "123456788"));
        tree.insert(new Person("Pedro", "2011-05-01", "123456787"));
        tree.insert(new Person("Carlos", "2009-05-01", "123456786"));
        tree.delete(new Person("Carlos", "2009-05-01", "123456786"));

        Node<Person> john = new Node<Person>(new Person("John", "2010-05-01", "123456789"));
        Node<Person> brandon = new Node<Person>(new Person("Brandon", "2010-05-01", "123456788"));
        Node<Person> pedro = new Node<Person>(new Person("Pedro", "2011-05-01", "123456787"));
        john.setLeftNode(brandon);
        john.setRightNode(pedro);
        BinarySearchTree<Person> tree2 = new BinarySearchTree<Person>(john);

        assertTrue(tree.equals(tree2));
    }

    @Test
    public void delete_Person_InvalidValue() {
        BinarySearchTree<Person> tree = new BinarySearchTree<Person>();
        tree.insert(new Person("John", "2010-05-01", "123456789"));
        tree.insert(new Person("Brandon", "2010-05-01", "123456788"));
        tree.insert(new Person("Pedro", "2011-05-01", "123456787"));
        tree.insert(new Person("Carlos", "2009-05-01", "123456786"));

        assertThrows(IllegalArgumentException.class, () -> tree.delete(new Person("Carlos", "2009-05-01", "123456787")));
    }

    @Test
    public void oCount_StringSearch_Two() {
        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        tree.insert("John");
        tree.insert("Brandon");
        tree.insert("Pedro");
        tree.insert("Carlos");

        int actual = tree.oCount(() -> tree.search("Carlos"));
        int expected = 2;
        assertEquals(expected, actual);
    }

    @Test
    public void oCount_IntegerInsert_Three() {
        BinarySearchTree<Integer> tree = new BinarySearchTree<Integer>();
        tree.insert(1);
        tree.insert(3);
        tree.insert(2);
        tree.insert(-2);
        tree.insert(4);
        tree.insert(-5);
        tree.insert(-3);
        tree.insert(-1);

        int actual = tree.oCount(() -> tree.insert(5));
        int expected = 3;
        assertEquals(expected, actual);
    }

    @Test
    public void oCount_PrintPerson_Four() {
        BinarySearchTree<Person> tree = new BinarySearchTree<Person>();
        tree.insert(new Person("John", "2010-05-01", "123456789"));
        tree.insert(new Person("Brandon", "2010-05-01", "123456788"));
        tree.insert(new Person("Pedro", "2011-05-01", "123456787"));
        tree.insert(new Person("Carlos", "2009-05-01", "123456786"));

        int actual = tree.oCount(() -> tree.print());
        int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void oCount_DeleteString_Three() {
        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        tree.insert("John");
        tree.insert("Brandon");
        tree.insert("Pedro");
        tree.insert("Carlos");

        int actual = tree.oCount(() -> tree.delete("Carlos"));
        int expected = 3;
        assertEquals(expected, actual);
    }
}
