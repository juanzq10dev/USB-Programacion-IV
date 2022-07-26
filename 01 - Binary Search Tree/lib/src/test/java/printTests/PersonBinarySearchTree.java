package printTests;

import binarySearchTree.BinarySearchTree;
import person.Person;

public class PersonBinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree<Person> tree = new BinarySearchTree<Person>();
        tree.insert(new Person("John", "2010-05-01", "123456789"));
        tree.insert(new Person("Brandon", "2010-05-01", "123456788"));
        tree.insert(new Person("Pedro", "2011-05-01", "123456787"));
        tree.insert(new Person("Carlos", "2009-05-01", "123456786"));
        tree.insert(new Person("Roman", "2012-05-01", "123456785"));
        tree.insert(new Person("Romario", "2009-06-01", "123456784"));
        tree.insert(new Person("Rusev", "2011-04-01", "123456783"));

        tree.print();
    }
}