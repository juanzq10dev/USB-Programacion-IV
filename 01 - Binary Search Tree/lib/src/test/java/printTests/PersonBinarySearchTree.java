package printTests;

import binarySearchTree.BinarySearchTree;
import person.Person;

public class PersonBinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree<Person> tree = new BinarySearchTree<Person>();
        tree.add(new Person("John", "2010-05-01", "123456789"));
        tree.add(new Person("Brandon", "2010-05-01", "123456788"));
        tree.add(new Person("Pedro", "2011-05-01", "123456787"));
        tree.add(new Person("Carlos", "2009-05-01", "123456786"));
        tree.add(new Person("Roman", "2012-05-01", "123456785"));
        tree.add(new Person("Romario", "2009-06-01", "123456784"));
        tree.add(new Person("Rusev", "2011-04-01", "123456783"));

        tree.print();
    }
}