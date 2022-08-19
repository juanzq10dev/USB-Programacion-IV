SKIP LIST 
===================
Adding more than 100000 elements to Priority Queue lasts too much because 
a simple LinkedList is not efficient to keep track of the order of the elements. 
Searching for a better algorithm to easily search values on a LinkedList to order them I found the SkipList.

A SkipList is a type of LinkedList that has a random number of levels. Each level has a random number of nodes. 
Each node has a value and a reference to the next node on the same level. 

SkipList compared vs LinkedList:
- Fast search
- It already keeps the elements ordered.
- It consumes more memory than LinkedList.
- It is a better options to keep the record of the elements ordered.

Advantages of using SkipList on the PriorityQueue vs LinkedList: 
- The enqueue efficiency increases significantly.
- The dequeue efficiency decreases a little, despites, it is still a better option for a PriorityQueue than LinkedList.

On the image is a graphic comparing PriorityQueue with SkipList.

