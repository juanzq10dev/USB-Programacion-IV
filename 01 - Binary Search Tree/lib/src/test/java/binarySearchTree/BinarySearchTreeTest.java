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

        assertThrows(IllegalArgumentException.class, () -> tree.search(new Person("Roman", "2010-05-01", "123456789")));
    }

    @Test
    public void print_String_ValidTree() {
        BinarySearchTree<String> tree = new BinarySearchTree<String>();
        tree.insert("John");
        tree.insert("Brandon");
        tree.insert("Pedro");
        tree.insert("Carlos");
        tree.insert("Roman");
        tree.insert("Romario");
        tree.insert("Roma");
        tree.insert("Brald");
        
        tree.print();
    }
}
