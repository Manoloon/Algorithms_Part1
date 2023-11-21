# Java_Queues

-Data Structures : Queues
*Deque<T> : Dequeue. A double-ended queue or deque (pronounced “deck”) is a generalization of a stack and a queue that
supports adding and removing items from either the front or the back of the data structure.

*RandomizeQueue<T> : A randomized queue is similar to a stack or queue, except that the item removed is chosen uniformly
at random among items in the data structure.

*Permutation.class : that takes an integer k as a command-line argument; reads a sequence of strings from standard input
using StdIn.readString(); and prints exactly k of them, uniformly at random. Print each item from the sequence at most
once.
********************************************************************************
*  ASSESSMENT SUMMARY                                                                    
********************************************************************************

Compilation:  FAILED (0 errors, 4 warnings)
API:          PASSED

SpotBugs:     PASSED
PMD:          PASSED
Checkstyle:   PASSED

Correctness:  37/49 tests passed
Memory:       123/133 tests passed
Timing:       193/193 tests passed

Aggregate score: 79.55%
[ Compilation: 5%, API: 5%, Style: 0%, Correctness: 60%, Timing: 10%, Memory: 20% ]



ASSESSMENT DETAILS


The following files were submitted:
----------------------------------
3.3K Nov 20 07:38 Deque.java
 998 Nov 20 07:38 Permutation.java
3.6K Nov 20 07:38 RandomizedQueue.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac Deque.java
*-----------------------------------------------------------
Deque.java:19: warning: [unchecked] unchecked cast
        items = (Item[]) new Object[INITIALCAPACITY];
                         ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class Deque
Deque.java:78: warning: [unchecked] unchecked cast
        Item[] copy = (Item[]) new Object[cap];
                               ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class Deque
2 warnings

% javac RandomizedQueue.java
*-----------------------------------------------------------
RandomizedQueue.java:18: warning: [unchecked] unchecked cast
        items = (Item[]) new Object[1];
                         ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class RandomizedQueue
RandomizedQueue.java:74: warning: [unchecked] unchecked cast
        Item[] copy = (Item[]) new Object[cap];
                               ^
  required: Item[]
  found:    Object[]
  where Item is a type-variable:
    Item extends Object declared in class RandomizedQueue
2 warnings

% javac Permutation.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
Deque:

RandomizedQueue:

Permutation:

================================================================


********************************************************************************
*  CHECKING STYLE AND COMMON BUG PATTERNS                                       
********************************************************************************


% spotbugs *.class
*-----------------------------------------------------------


================================================================


% pmd .
*-----------------------------------------------------------


================================================================


% checkstyle *.java
*-----------------------------------------------------------

% custom checkstyle checks for Deque.java
*-----------------------------------------------------------

% custom checkstyle checks for RandomizedQueue.java
*-----------------------------------------------------------

% custom checkstyle checks for Permutation.java
*-----------------------------------------------------------


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of Deque
*-----------------------------------------------------------
Running 19 total tests.

Tests 1-8 make random intermixed calls to addFirst(), addLast(),
removeFirst(), removeLast(), isEmpty(), and size(), and iterator().
The probabilities of each operation are (p1, p2, p3, p4, p5, p6, p7),
respectively.

Test 1: check random calls to addFirst(), addLast(), and size()
  *    5 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2, 0.0)
  *   50 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2, 0.0)
  *  500 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2, 0.0)
  * 1000 random calls (0.4, 0.4, 0.0, 0.0, 0.0, 0.2, 0.0)
==> passed

Test 2: check random calls to addFirst(), removeFirst(), and isEmpty()
  *    5 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0, 0.0)
  *   50 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0, 0.0)
  *  500 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0, 0.0)
  * 1000 random calls (0.8, 0.0, 0.1, 0.0, 0.1, 0.0, 0.0)
  *    5 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0, 0.0)
  *   50 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0, 0.0)
  *  500 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0, 0.0)
  * 1000 random calls (0.1, 0.0, 0.8, 0.0, 0.1, 0.0, 0.0)
==> passed

Test 3: check random calls to addFirst(), removeLast(), and isEmpty()
  *    5 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0, 0.0)
    - failed on operation 3 of 5
    - student   removeLast() = 2
    - reference removeLast() = 1
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addFirst(1)
         deque.addFirst(2)
         deque.removeLast()      ==> 2

  *   50 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0, 0.0)
    - failed on operation 14 of 50
    - student   removeLast() = null
    - reference removeLast() = 1

  *  500 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0, 0.0)
    - failed on operation 13 of 500
    - student   removeLast() = null
    - reference removeLast() = 4

  * 1000 random calls (0.8, 0.0, 0.0, 0.1, 0.1, 0.0, 0.0)
    - failed on operation 9 of 1000
    - student   removeLast() = null
    - reference removeLast() = 1
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addFirst(1)
         deque.isEmpty()         ==> false
         deque.addFirst(3)
         deque.addFirst(4)
         deque.addFirst(5)
         deque.addFirst(6)
         deque.isEmpty()         ==> false
         deque.addFirst(8)
         deque.removeLast()      ==> null

  *    5 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0, 0.0)
  *   50 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0, 0.0)
    - failed on operation 29 of 50
    - student   removeLast() = null
    - reference removeLast() = 26

  *  500 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0, 0.0)
    - failed on operation 13 of 500
    - student   removeLast() = 12
    - reference removeLast() = 11

  * 1000 random calls (0.1, 0.0, 0.0, 0.8, 0.1, 0.0, 0.0)
    - failed on operation 10 of 1000
    - student   removeLast() = 9
    - reference removeLast() = 7
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addFirst(1)
         deque.isEmpty()         ==> false
         deque.removeLast()      ==> 1
         deque.addFirst(4)
         deque.removeLast()      ==> 4
         deque.isEmpty()         ==> true
         deque.addFirst(7)
         deque.isEmpty()         ==> false
         deque.addFirst(9)
         deque.removeLast()      ==> 9

==> FAILED

Test 4: check random calls to addLast(), removeLast(), and isEmpty()
  *    5 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0, 0.0)
  *   50 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0, 0.0)
  *  500 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0, 0.0)
  * 1000 random calls (0.0, 0.8, 0.0, 0.1, 0.1, 0.0, 0.0)
  *    5 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0, 0.0)
  *   50 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0, 0.0)
    - failed on operation 34 of 50
    - student   removeLast() = null
    - reference removeLast() = 31

  *  500 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0, 0.0)
    - failed on operation 15 of 500
    - student   removeLast() = null
    - reference removeLast() = 11

  * 1000 random calls (0.0, 0.1, 0.0, 0.8, 0.1, 0.0, 0.0)
    - failed on operation 7 of 1000
    - student   removeLast() = null
    - reference removeLast() = 4
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.isEmpty()         ==> true
         deque.isEmpty()         ==> true
         deque.isEmpty()         ==> true
         deque.addLast(4)
         deque.addLast(5)
         deque.removeLast()      ==> 5
         deque.removeLast()      ==> null

==> FAILED

Test 5: check random calls to addLast(), removeFirst(), and isEmpty()
  *    5 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0, 0.0)
  *   50 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0, 0.0)
    - failed on operation 14 of 50
    - student   removeFirst() = 12
    - reference removeFirst() = 3

  *  500 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0, 0.0)
    - failed on operation 5 of 500
    - student   removeFirst() = 4
    - reference removeFirst() = 1
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addLast(1)
         deque.addLast(2)
         deque.addLast(3)
         deque.addLast(4)
         deque.removeFirst()     ==> 4

  * 1000 random calls (0.0, 0.8, 0.1, 0.0, 0.1, 0.0, 0.0)
    - failed on operation 11 of 1000
    - student   removeFirst() = 10
    - reference removeFirst() = 3
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addLast(1)
         deque.removeFirst()     ==> 1
         deque.addLast(3)
         deque.addLast(4)
         deque.addLast(5)
         deque.addLast(6)
         deque.addLast(7)
         deque.addLast(8)
         deque.addLast(9)
         deque.addLast(10)
         deque.removeFirst()     ==> 10

  *    5 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0, 0.0)
  *   50 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0, 0.0)
    - failed on operation 9 of 50
    - student   removeFirst() = 8
    - reference removeFirst() = 7
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addLast(1)
         deque.isEmpty()         ==> false
         deque.removeFirst()     ==> 1
         deque.isEmpty()         ==> true
         deque.isEmpty()         ==> true
         deque.isEmpty()         ==> true
         deque.addLast(7)
         deque.addLast(8)
         deque.removeFirst()     ==> 8

  *  500 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0, 0.0)
    - failed on operation 5 of 500
    - student   removeFirst() = 4
    - reference removeFirst() = 3
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.isEmpty()         ==> true
         deque.isEmpty()         ==> true
         deque.addLast(3)
         deque.addLast(4)
         deque.removeFirst()     ==> 4

  * 1000 random calls (0.0, 0.1, 0.8, 0.0, 0.1, 0.0, 0.0)
    - failed on operation 10 of 1000
    - student   removeFirst() = 9
    - reference removeFirst() = 8
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.isEmpty()         ==> true
         deque.addLast(2)
         deque.removeFirst()     ==> 2
         deque.isEmpty()         ==> true
         deque.isEmpty()         ==> true
         deque.isEmpty()         ==> true
         deque.isEmpty()         ==> true
         deque.addLast(8)
         deque.addLast(9)
         deque.removeFirst()     ==> 9

==> FAILED

Test 6: check random calls to addFirst(), removeFirst(), and iterator()
  *    5 random calls (0.8, 0.0, 0.1, 0.0, 0.0, 0.0, 0.1)
  *   50 random calls (0.8, 0.0, 0.1, 0.0, 0.0, 0.0, 0.1)
    - failed on operation 13 of 50
    - student iterator() returns wrong set of values
    - student   iterator() = [12]
    - reference iterator() = [12, 11, 8, 7, 4, 3, 2, 1]
    - number of integers returned by student   iterator() = 1
    - number of integers returned by reference iterator() = 8


  *  500 random calls (0.8, 0.0, 0.1, 0.0, 0.0, 0.0, 0.1)
    - failed on operation 21 of 500
    - student iterator() returns wrong set of values
    - student   iterator() = [20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 7, 6, 5,  ...
    - reference iterator() = [20, 19, 18, 17, 16, 15, 14, 13, 12, 11, 10, 7, 6, 5,  ...
    - number of integers returned by student   iterator() = 18
    - number of integers returned by reference iterator() = 18
    - number of null values returned by student   iterator() = 1
    - number of null values returned by reference iterator() = 0


  * 1000 random calls (0.8, 0.0, 0.1, 0.0, 0.0, 0.0, 0.1)
    - failed on operation 3 of 1000
    - student iterator() returns wrong set of values
    - student   iterator() = [2]
    - reference iterator() = [2, 1]
    - number of integers returned by student   iterator() = 1
    - number of integers returned by reference iterator() = 2

    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addFirst(1)
         deque.addFirst(2)
         deque.iterator()    ==> [2]

  *    5 random calls (0.1, 0.0, 0.8, 0.0, 0.0, 0.0, 0.1)
  *   50 random calls (0.1, 0.0, 0.8, 0.0, 0.0, 0.0, 0.1)
    - failed on operation 8 of 50
    - student iterator() returns wrong set of values
    - student   iterator() = []
    - reference iterator() = [7]
    - number of integers returned by student   iterator() = 0
    - number of integers returned by reference iterator() = 1

    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addFirst(1)
         deque.removeFirst()     ==> 1
         deque.addFirst(3)
         deque.removeFirst()     ==> 3
         deque.addFirst(5)
         deque.removeFirst()     ==> 5
         deque.addFirst(7)
         deque.iterator()    ==> []

  *  500 random calls (0.1, 0.0, 0.8, 0.0, 0.0, 0.0, 0.1)
    - failed on operation 2 of 500
    - student iterator() returns wrong set of values
    - student   iterator() = []
    - reference iterator() = [1]
    - number of integers returned by student   iterator() = 0
    - number of integers returned by reference iterator() = 1

    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addFirst(1)
         deque.iterator()    ==> []

  * 1000 random calls (0.1, 0.0, 0.8, 0.0, 0.0, 0.0, 0.1)
    - failed on operation 12 of 1000
    - student iterator() returns wrong set of values
    - student   iterator() = []
    - reference iterator() = [11]
    - number of integers returned by student   iterator() = 0
    - number of integers returned by reference iterator() = 1


==> FAILED

Test 7: check random calls to all methods except iterator()
  *    5 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1, 0.0)
    - failed on operation 4 of 5
    - student   removeLast() = null
    - reference removeLast() = 1
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addLast(1)
         deque.addFirst(2)
         deque.addFirst(3)
         deque.removeLast()      ==> null

  *   50 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1, 0.0)
  *  500 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1, 0.0)
    - failed on operation 4 of 500
    - student   removeLast() = 2
    - reference removeLast() = 1
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addFirst(1)
         deque.addFirst(2)
         deque.size()            ==> 2
         deque.removeLast()      ==> 2

  * 1000 random calls (0.3, 0.3, 0.1, 0.1, 0.1, 0.1, 0.0)
    - failed on operation 4 of 1000
    - student   removeLast() = 3
    - reference removeLast() = 2
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.isEmpty()         ==> true
         deque.addFirst(2)
         deque.addFirst(3)
         deque.removeLast()      ==> 3

  *    5 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1, 0.0)
    - failed on operation 5 of 5
    - student   removeLast() = null
    - reference removeLast() = 1
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addLast(1)
         deque.addFirst(2)
         deque.size()            ==> 2
         deque.removeFirst()     ==> 2
         deque.removeLast()      ==> null

  *   50 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1, 0.0)
    - failed on operation 14 of 50
    - student   removeFirst() = 13
    - reference removeFirst() = 12

  *  500 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1, 0.0)
    - failed on operation 38 of 500
    - student   removeFirst() = 36
    - reference removeFirst() = 35

  * 1000 random calls (0.1, 0.1, 0.3, 0.3, 0.1, 0.1, 0.0)
    - failed on operation 7 of 1000
    - student   removeLast() = null
    - reference removeLast() = 6
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addLast(1)
         deque.addFirst(2)
         deque.removeFirst()     ==> 2
         deque.isEmpty()         ==> false
         deque.removeFirst()     ==> 1
         deque.addFirst(6)
         deque.removeLast()      ==> null

==> FAILED

Test 8: check random calls to all methods, including iterator()
  *    5 random calls (0.2, 0.2, 0.1, 0.1, 0.1, 0.1, 0.2)
  *   50 random calls (0.2, 0.2, 0.1, 0.1, 0.1, 0.1, 0.2)
    - failed on operation 8 of 50
    - student   removeFirst() = 7
    - reference removeFirst() = 6
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.isEmpty()         ==> true
         deque.addLast(3)
         deque.isEmpty()         ==> false
         deque.removeLast()      ==> 3
         deque.addFirst(6)
         deque.addLast(7)
         deque.removeFirst()     ==> 7

  *  500 random calls (0.2, 0.2, 0.1, 0.1, 0.1, 0.1, 0.2)
    - failed on operation 10 of 500
    - student   removeFirst() = null
    - reference removeFirst() = 5
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.isEmpty()         ==> true
         deque.addFirst(2)
         deque.addLast(3)
         deque.isEmpty()         ==> false
         deque.addFirst(5)
         deque.isEmpty()         ==> false
         deque.addLast(8)
         deque.removeLast()      ==> 8
         deque.removeFirst()     ==> null

  * 1000 random calls (0.2, 0.2, 0.1, 0.1, 0.1, 0.1, 0.2)
    - failed on operation 3 of 1000
    - student iterator() returns wrong set of values
    - student   iterator() = [2]
    - reference iterator() = [2, 1]
    - number of integers returned by student   iterator() = 1
    - number of integers returned by reference iterator() = 2

    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addLast(1)
         deque.addFirst(2)
         deque.iterator()    ==> [2]

  *    5 random calls (0.1, 0.1, 0.2, 0.2, 0.1, 0.1, 0.2)
  *   50 random calls (0.1, 0.1, 0.2, 0.2, 0.1, 0.1, 0.2)
    - failed on operation 13 of 50
    - student   removeFirst() = 9
    - reference removeFirst() = 8

  *  500 random calls (0.1, 0.1, 0.2, 0.2, 0.1, 0.1, 0.2)
    - failed on operation 10 of 500
    - student   removeLast() = null
    - reference removeLast() = 8
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.isEmpty()         ==> true
         deque.isEmpty()         ==> true
         deque.isEmpty()         ==> true
         deque.size()            ==> 0
         deque.addFirst(6)
         deque.isEmpty()         ==> false
         deque.addLast(8)
         deque.addFirst(9)
         deque.removeLast()      ==> null

  * 1000 random calls (0.1, 0.1, 0.2, 0.2, 0.1, 0.1, 0.2)
    - failed on operation 9 of 1000
    - student iterator() returns wrong set of values
    - student   iterator() = []
    - reference iterator() = [8]
    - number of integers returned by student   iterator() = 0
    - number of integers returned by reference iterator() = 1

    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addLast(1)
         deque.removeFirst()     ==> 1
         deque.addLast(4)
         deque.size()            ==> 1
         deque.removeFirst()     ==> 4
         deque.size()            ==> 0
         deque.addLast(8)
         deque.iterator()    ==> []

==> FAILED

Test 9: check removeFirst() and removeLast() from an empty deque
  * removeFirst()
  * removeLast()
==> passed

Test 10: check whether two Deque objects can be created at the same time
  * n = 10
  * n = 1000
==> passed

Test 11: check iterator() after n calls to addFirst()
  * n = 10
    - number of student   entries = 11
    - number of reference entries = 10

  * n = 50
    - number of student   entries = 51
    - number of reference entries = 50

==> FAILED

Test 12: check iterator() after random calls to addFirst(), addLast(),
         removeFirst(), and removeLast() with probabilities (p1, p2, p3, p4)
  * 20 random operations (0.8, 0.0, 0.2, 0.0)
    - number of student   entries = 0
    - number of reference entries = 1
    - student iterator() yields wrong result
      after applying add/remove operation 1 of 20
    - student   iterator() = []
    - reference iterator() = [1]
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addFirst(1)
         deque.iterator()     ==> []

  * 20 random operations (0.8, 0.0, 0.0, 0.2)
    - number of student   entries = 0
    - number of reference entries = 1
    - student iterator() yields wrong result
      after applying add/remove operation 1 of 20
    - student   iterator() = []
    - reference iterator() = [1]
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addFirst(1)
         deque.iterator()     ==> []

  * 20 random operations (0.0, 0.8, 0.0, 0.2)
    - number of student   entries = 0
    - number of reference entries = 1
    - student iterator() yields wrong result
      after applying add/remove operation 1 of 20
    - student   iterator() = []
    - reference iterator() = [1]
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addLast(1)
         deque.iterator()     ==> []

  * 20 random operations (0.0, 0.8, 0.2, 0.0)
    - number of student   entries = 0
    - number of reference entries = 1
    - student iterator() yields wrong result
      after applying add/remove operation 1 of 20
    - student   iterator() = []
    - reference iterator() = [1]
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addLast(1)
         deque.iterator()     ==> []

  * 20 random operations (0.4, 0.4, 0.1, 0.1)
    - number of student   entries = 0
    - number of reference entries = 1
    - student iterator() yields wrong result
      after applying add/remove operation 1 of 20
    - student   iterator() = []
    - reference iterator() = [1]
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addLast(1)
         deque.iterator()     ==> []

  * 20 random operations (0.2, 0.0, 0.8, 0.0)
    - number of student   entries = 0
    - number of reference entries = 1
    - student iterator() yields wrong result
      after applying add/remove operation 1 of 20
    - student   iterator() = []
    - reference iterator() = [1]
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addFirst(1)
         deque.iterator()     ==> []

  * 20 random operations (0.2, 0.0, 0.0, 0.8)
    - number of student   entries = 0
    - number of reference entries = 1
    - student iterator() yields wrong result
      after applying add/remove operation 1 of 20
    - student   iterator() = []
    - reference iterator() = [1]
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addFirst(1)
         deque.iterator()     ==> []

  * 20 random operations (0.0, 0.2, 0.0, 0.8)
    - number of student   entries = 0
    - number of reference entries = 1
    - student iterator() yields wrong result
      after applying add/remove operation 1 of 20
    - student   iterator() = []
    - reference iterator() = [1]
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addLast(1)
         deque.iterator()     ==> []

  * 20 random operations (0.0, 0.2, 0.8, 0.0)
    - number of student   entries = 0
    - number of reference entries = 1
    - student iterator() yields wrong result
      after applying add/remove operation 1 of 20
    - student   iterator() = []
    - reference iterator() = [1]
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addLast(1)
         deque.iterator()     ==> []

  * 20 random operations (0.1, 0.1, 0.4, 0.4)
    - number of student   entries = 0
    - number of reference entries = 1
    - student iterator() yields wrong result
      after applying add/remove operation 1 of 20
    - student   iterator() = []
    - reference iterator() = [1]
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addFirst(1)
         deque.iterator()     ==> []

  * 100 random operations (0.4, 0.4, 0.1, 0.1)
    - number of student   entries = 0
    - number of reference entries = 1
    - student iterator() yields wrong result
      after applying add/remove operation 1 of 100
    - student   iterator() = []
    - reference iterator() = [1]
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addLast(1)
         deque.iterator()     ==> []

  * 1000 random operations (0.4, 0.4, 0.1, 0.1)
    - number of student   entries = 0
    - number of reference entries = 1
    - student iterator() yields wrong result
      after applying add/remove operation 1 of 1000
    - student   iterator() = []
    - reference iterator() = [1]
    - sequence of operations was:
         Deque<Integer> deque = new Deque<>()
         deque.addFirst(1)
         deque.iterator()     ==> []

==> FAILED

Test 13: create two nested iterators to same deque of size n
  * n = 10
    - failed on outer loop 0
    - student   outer iterator returned 7
    - reference outer iterator returned 0

  * n = 50
    - failed on outer loop 0
    - student   outer iterator returned 31
    - reference outer iterator returned 0

==> FAILED

Test 14: create two parallel iterators to same deque of size n
  * n = 10
    - failed on call 0 to next()
    - student   iterator 1 next() = 7
    - student   iterator 2 next() = 7
    - reference iterator   next() = 0

  * n = 50
    - failed on call 0 to next()
    - student   iterator 1 next() = 31
    - student   iterator 2 next() = 31
    - reference iterator   next() = 0

==> FAILED

Test 15: create an iterator and check calls to next() and hasNext()
  * 10 consecutive calls to hasNext() on a deque of size 10
  * 10 consecutive calls to next() on a deque of size 10
  * 50 random intermixed calls to next() and hasNext() on a deque of size 10
    - failed on operation 18 of 50
    - student   hasNext() = true
    - reference hasNext() = false

  * 1000 random intermixed calls to next() and hasNext() on a deque of size 100
    - failed on operation 188 of 1000
    - student   hasNext() = true
    - reference hasNext() = false

==> FAILED

Test 16: create Deque objects of different parameterized types
==> passed

Test 17: call addFirst() and addLast() with null argument
==> passed

Test 18: check that remove() and next() throw the specified exceptions in iterator()
    - failed trying to call next() twice on an iterator with two items


    java.util.NoSuchElementException

    Deque$QueueIterator.next(Deque.java:100)
    TestDeque.test18(TestDeque.java:994)
    TestDeque.main(TestDeque.java:1115)

==> FAILED

Test 19: call iterator() when the deque is empty
==> passed


Total: 7/19 tests passed!


================================================================
Testing correctness of RandomizedQueue
*-----------------------------------------------------------
Running 21 total tests.

Tests 1-6 make random intermixed calls to enqueue(), dequeue(), sample(),
isEmpty(), size(), and iterator(). The probabilities of each operation
are (p1, p2, p3, p4, p5, p6), respectively.

Test 1: check random calls to enqueue() and size()
  *    5 random calls (0.8, 0.0, 0.0, 0.0, 0.2, 0.0)
  *   50 random calls (0.8, 0.0, 0.0, 0.0, 0.2, 0.0)
  *  500 random calls (0.8, 0.0, 0.0, 0.0, 0.2, 0.0)
  * 1000 random calls (0.8, 0.0, 0.0, 0.0, 0.2, 0.0)
==> passed

Test 2: check random calls to enqueue() and dequeue()
  *    5 random calls (0.7, 0.1, 0.0, 0.1, 0.1, 0.0)
  *   50 random calls (0.7, 0.1, 0.0, 0.1, 0.1, 0.0)
  *  500 random calls (0.7, 0.1, 0.0, 0.1, 0.1, 0.0)
  * 1000 random calls (0.7, 0.1, 0.0, 0.1, 0.1, 0.0)
  *    5 random calls (0.1, 0.7, 0.0, 0.1, 0.1, 0.0)
  *   50 random calls (0.1, 0.7, 0.0, 0.1, 0.1, 0.0)
  *  500 random calls (0.1, 0.7, 0.0, 0.1, 0.1, 0.0)
  * 1000 random calls (0.1, 0.7, 0.0, 0.1, 0.1, 0.0)
==> passed

Test 3: check random calls to enqueue() and sample()
  *    5 random calls (0.8, 0.0, 0.2, 0.0, 0.0, 0.0)
  *   50 random calls (0.8, 0.0, 0.2, 0.0, 0.0, 0.0)
  *  500 random calls (0.8, 0.0, 0.2, 0.0, 0.0, 0.0)
  * 1000 random calls (0.8, 0.0, 0.2, 0.0, 0.0, 0.0)
  *    5 random calls (0.2, 0.0, 0.8, 0.0, 0.0, 0.0)
  *   50 random calls (0.2, 0.0, 0.8, 0.0, 0.0, 0.0)
  *  500 random calls (0.2, 0.0, 0.8, 0.0, 0.0, 0.0)
  * 1000 random calls (0.2, 0.0, 0.8, 0.0, 0.0, 0.0)
==> passed

Test 4: check random calls to enqueue() and iterator()
  *    5 random calls (0.8, 0.0, 0.0, 0.0, 0.0, 0.2)
  *   50 random calls (0.8, 0.0, 0.0, 0.0, 0.0, 0.2)
  *  500 random calls (0.8, 0.0, 0.0, 0.0, 0.0, 0.2)
  * 1000 random calls (0.8, 0.0, 0.0, 0.0, 0.0, 0.2)
==> passed

Test 5: check random calls to all methods except iterator()
  *    5 random calls (0.6, 0.1, 0.1, 0.1, 0.1, 0.0)
  *   50 random calls (0.6, 0.1, 0.1, 0.1, 0.1, 0.0)
  *  500 random calls (0.6, 0.1, 0.1, 0.1, 0.1, 0.0)
  * 1000 random calls (0.6, 0.1, 0.1, 0.1, 0.1, 0.0)
  *    5 random calls (0.1, 0.6, 0.1, 0.1, 0.1, 0.0)
  *   50 random calls (0.1, 0.6, 0.1, 0.1, 0.1, 0.0)
  *  500 random calls (0.1, 0.6, 0.1, 0.1, 0.1, 0.0)
  * 1000 random calls (0.1, 0.6, 0.1, 0.1, 0.1, 0.0)
==> passed

Test 6: check random calls to all methods, including iterator()
  *    5 random calls (0.5, 0.1, 0.1, 0.1, 0.1, 0.1)
  *   50 random calls (0.5, 0.1, 0.1, 0.1, 0.1, 0.1)
  *  500 random calls (0.5, 0.1, 0.1, 0.1, 0.1, 0.1)
  * 1000 random calls (0.5, 0.1, 0.1, 0.1, 0.1, 0.1)
  *    5 random calls (0.1, 0.5, 0.1, 0.1, 0.1, 0.1)
  *   50 random calls (0.1, 0.5, 0.1, 0.1, 0.1, 0.1)
  *  500 random calls (0.1, 0.5, 0.1, 0.1, 0.1, 0.1)
  * 1000 random calls (0.1, 0.5, 0.1, 0.1, 0.1, 0.1)
==> passed

Test 7: call dequeue() and sample() from an empty randomized queue
  * dequeue()
  * sample()
==> passed

Test 8: create multiple randomized queue objects at the same time
  * n = 10
  * n = 100
==> passed

Test 9: check that iterator() returns correct items after a sequence
        of n enqueue() operations
  * n = 10
  * n = 50
==> passed

Test 10: check that iterator() returns correct items after intermixed
         sequence of m enqueue() and dequeue() operations
  * m = 10
  * m = 1000
==> passed

Test 11: create two nested iterators over the same randomized queue of size n
  * n = 10
  * n = 50
==> passed

Test 12: create two parallel iterators over the same randomized queue of size n
  * n = 10
  * n = 50
==> passed

Test 13: create two iterators over different randomized queues,
         each of length 10
==> passed

Test 14: create an iterator and check calls to next() and hasNext()
  * 10 consecutive calls to hasNext() on a deque of size 10
  * 10 consecutive calls to next() on a deque of size 10
  * 50 random intermixed calls to next() and hasNext() on a deque of size 10
  * 1000 random intermixed calls to next() and hasNext() on a deque of size 100
==> passed

Test 15: create RandomizedQueue objects of different parameterized types
==> passed

Test 16: check randomness of sample() by enqueueing n items, repeatedly calling
         sample(), and counting the frequency of each item
  * n = 3, trials = 12000
  * n = 5, trials = 12000
  * n = 8, trials = 12000
  * n = 10, trials = 12000
==> passed

Test 17: check randomness of dequeue() by enqueueing n items, dequeueing n items,
         and seeing whether each of the n! permutations is equally likely
  * n = 2, trials = 12000
  * n = 3, trials = 12000
  * n = 4, trials = 12000
  * n = 5, trials = 12000
==> passed

Test 18: check randomness of iterator() by enqueueing n items, iterating over those
         n items, and seeing whether each of the n! permutations is equally likely
  * n = 2, trials = 12000
  * n = 3, trials = 12000
  * n = 4, trials = 12000
  * n = 5, trials = 12000
==> passed

Test 19: call enqueue() with a null argument
==> passed

Test 20: check that remove() and next() throw the specified exceptions in iterator()
==> passed

Test 21: call iterator() when randomized queue is empty
==> passed


Total: 21/21 tests passed!


================================================================
********************************************************************************
*  TESTING CORRECTNESS (substituting reference RandomizedQueue and Deque)
********************************************************************************

Testing correctness of Permutation
*-----------------------------------------------------------
Tests 1-5 call the main() function directly, resetting standard input
before each call.

Running 9 total tests.

Test 1a: check formatting for sample inputs from assignment specification
  % java Permutation 3 < distinct.txt
  I
  E
  G

  % java Permutation 3 < distinct.txt
  C
  H
  A

  % java Permutation 8 < duplicates.txt
  BB
  BB
  BB
  BB
  AA
  BB
  CC
  CC

==> passed

Test 1b: check formatting for other inputs
  % java Permutation 8 < mediumTale.txt
  was
  age
  times
  of
  of
  of
  it
  age

  % java Permutation 0 < distinct.txt
  [no output]

==> passed

Test 2: check that main() reads all data from standard input
  * filename = distinct.txt, k = 3
  * filename = distinct.txt, k = 3
  * filename = duplicates.txt, k = 8
  * filename = mediumTale.txt, k = 8
==> passed

Test 3a: check that main() prints each item from the sequence at most once
         (for inputs with no duplicate strings)
  * filename = distinct.txt, k = 3
  * filename = distinct.txt, k = 1
  * filename = distinct.txt, k = 9
  * filename = permutation6.txt, k = 6
  * filename = permutation10.txt, k = 10
==> passed

Test 3b: check that main() prints each item from the sequence at most once
         (for inputs with duplicate strings)
  * filename = duplicates.txt, k = 8
  * filename = duplicates.txt, k = 3
  * filename = permutation8.txt, k = 6
  * filename = permutation8.txt, k = 2
  * filename = tinyTale.txt, k = 10
==> passed

Test 3c: check that main() prints each item from the sequence at most once
         (for inputs with newlines)
  * filename = mediumTale.txt, k = 10
  * filename = mediumTale.txt, k = 20
  * filename = tale.txt, k = 10
  * filename = tale.txt, k = 50
==> passed

Test 4: check main() when k = 0
  * filename = distinct.txt, k = 0
  * filename = distinct.txt, k = 0
==> passed

Test 5a: check that permutations are uniformly random
         (for inputs with no duplicate strings)
  * filename = permutation4.txt, k = 1
  * filename = permutation4.txt, k = 2
  * filename = permutation4.txt, k = 3
  * filename = permutation4.txt, k = 4
  * filename = permutation6.txt, k = 2
==> passed

Test 5b: check that permutations are uniformly random
         (for inputs with duplicate strings)
  * filename = permutation5.txt, k = 1
  * filename = permutation5.txt, k = 2
  * filename = permutation5.txt, k = 3
  * filename = duplicates.txt, k = 3
  * filename = permutation8.txt, k = 2
==> passed

Total: 9/9 tests passed!


================================================================
********************************************************************************
*  TIMING (substituting reference RandomizedQueue and Deque)
********************************************************************************

Timing Permutation
*-----------------------------------------------------------
Running 23 total tests.

Test 1: count calls to methods in StdIn
  * java Permutation 5 < distinct.txt
  * java Permutation 10 < permutation10.txt
  * java Permutation 1 < mediumTale.txt
  * java Permutation 20 < tale.txt
  * java Permutation 100 < tale.txt
  * java Permutation 16412 < tale.txt
==> passed

Test 2: count calls to methods in Deque and RandomizedQueue
  * java Permutation 5 < distinct.txt
  * java Permutation 10 < permutation10.txt
  * java Permutation 1 < mediumTale.txt
  * java Permutation 20 < tale.txt
  * java Permutation 100 < tale.txt
  * java Permutation 16412 < tale.txt
==> passed

Test 3: count calls to methods in StdRandom
  * java Permutation 5 < distinct.txt
  * java Permutation 10 < permutation10.txt
  * java Permutation 1 < mediumTale.txt
  * java Permutation 20 < tale.txt
  * java Permutation 100 < tale.txt
  * java Permutation 16412 < tale.txt
==> passed

Test 4: Time main() with k = 5, for inputs containing n random strings

                    n  seconds
------------------------------
=> passed        1000     0.00
=> passed        2000     0.00
=> passed        4000     0.00
=> passed        8000     0.00
=> passed       16000     0.00
=> passed       32000     0.01
=> passed       64000     0.02
=> passed      128000     0.04
=> passed      256000     0.08
=> passed      512000     0.15
==> 10/10 tests passed


Test 5: Time main() with k = 1000, for inputs containing n random strings

                    n  seconds
------------------------------
=> passed        1000     0.00
=> passed        2000     0.00
=> passed        4000     0.00
=> passed        8000     0.00
=> passed       16000     0.01
=> passed       32000     0.01
=> passed       64000     0.02
=> passed      128000     0.04
=> passed      256000     0.08
=> passed      512000     0.15
==> 10/10 tests passed


Total: 23/23 tests passed!


================================================================



********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Permutation
*-----------------------------------------------------------
Running 2 total tests.

Test 1: check that only one Deque or RandomizedQueue object is created
  * filename = distinct.txt, n = 9, k = 1
  * filename = distinct.txt, n = 9, k = 2
  * filename = distinct.txt, n = 9, k = 4
  * filename = tinyTale.txt, n = 12, k = 10
  * filename = tale.txt, n = 138653, k = 50
==> passed

Test 2: check that the maximum size of any Deque or RandomizedQueue object
        created is between k and n
  * filename = distinct.txt, n = 9, k = 1
  * filename = distinct.txt, n = 9, k = 2
  * filename = distinct.txt, n = 9, k = 4
  * filename = tinyTale.txt, n = 12, k = 10
  * filename = tale.txt, n = 138653, k = 5
  * filename = tale.txt, n = 138653, k = 50
  * filename = tale.txt, n = 138653, k = 500
  * filename = tale.txt, n = 138653, k = 5000
  * filename = tale.txt, n = 138653, k = 50000
==> passed

Test 3 (bonus): check that maximum size of any or Deque or RandomizedQueue object
                created is equal to k
  * filename = tale.txt, n = 138653, k = 5
  * filename = tale.txt, n = 138653, k = 50
  * filename = tale.txt, n = 138653, k = 500
  * filename = tale.txt, n = 138653, k = 5000
  * filename = tale.txt, n = 138653, k = 50000
==> passed

Total: 3/2 tests passed!


================================================================



********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Deque
*-----------------------------------------------------------
For tests 1-4, the maximum amount of memory allowed for a Deque
containing n items is 48n + 192.

Running 49 total tests.

Test 1a-1i: total memory usage after inserting n items,
            where n is a power of 2

                 n        bytes
----------------------------------------------------------
=> passed       32          320         
=> passed       64          576         
=> passed      128         1088         
=> passed      256         2112         
=> passed      512         4160         
=> passed     1024         8256         
=> passed     2048        16448         
=> passed     4096        32832         
=> passed     8192        65600         
==> 9/9 tests passed

Memory: 8.00 n + 64.00   (R^2 = 1.000)


Test 2a-2i: Total memory usage after inserting n items,
            when n is one more than a power of 2.

                 n        bytes
----------------------------------------------------------
=> passed       33          576         
=> passed       65         1088         
=> passed      129         2112         
=> passed      257         4160         
=> passed      513         8256         
=> passed     1025        16448         
=> passed     2049        32832         
=> passed     4097        65600         
=> passed     8193       131136         
==> 9/9 tests passed

Memory: 16.00 n + 48.00   (R^2 = 1.000)


Test 3a-3i: Total memory usage after inserting 2n-1 items, and then
            deleting n-1 items, when n is one more than a power of 2.

                 n        bytes
----------------------------------------------------------
=> passed       33         1088         
=> passed       65         2112         
=> passed      129         4160         
=> passed      257         8256         
=> passed      513        16448         
=> passed     1025        32832         
=> passed     2049        65600         
=> passed     4097       131136         
=> passed     8193       262208         
==> 9/9 tests passed

Memory: 32.00 n + 32.00   (R^2 = 1.000)


Test 4a-4e: Total memory usage after inserting n items,
            and then deleting all but one item
            (should not grow with n or be too large of a constant).

                 n        bytes
----------------------------------------------------------
=> FAILED       32          320   (1.3x)
=> FAILED       64          576   (2.4x)
=> FAILED      128         1088   (4.5x)
=> FAILED      256         2112   (8.8x)
=> FAILED      512         4160  (17.3x)
=> FAILED     1024         8256  (34.4x)
=> FAILED     2048        16448  (68.5x)
=> FAILED     4096        32832 (136.8x)
=> FAILED     8192        65600 (273.3x)
==> 0/9 tests passed

Memory: 8.00 n + 64.00   (R^2 = 1.000)


Test 5a-5e: Total memory usage of iterator after inserting n items
            (should not grow with n or be too large of a constant).

                 n        bytes
----------------------------------------------------------
=> passed       32           32         
=> passed       64           32         
=> passed      128           32         
=> passed      256           32         
=> passed      512           32         
=> passed     1024           32         
=> passed     2048           32         
=> passed     4096           32         
=> passed     8192           32         
==> 9/9 tests passed

Memory: 32.00   (R^2 = 1.000)


Test 6a: Insert n strings; delete them one at a time, checking for
         loitering after each deletion. The probabilities of addFirst()
         and addLast() are (p1, p2), respectively. The probabilities of
         removeFirst() and removeLast() are (q1, q2), respectively.
  * 100 random insertions (1.0, 0.0) and 100 random deletions (1.0, 0.0)
  * 100 random insertions (1.0, 0.0) and 100 random deletions (0.0, 1.0)
  * 100 random insertions (0.0, 1.0) and 100 random deletions (1.0, 0.0)
  * 100 random insertions (0.0, 1.0) and 100 random deletions (0.0, 1.0)
  * 100 random insertions (0.5, 0.5) and 100 random deletions (0.5, 0.5)
==> passed

Test 6b: Perform random operations, checking for loitering after
         each operation. The probabilities of addFirst(), addLast(),
         removeFirst(), and removeLast() are (p1, p2, p3, p4),
         respectively.
  * 100 random operations (0.8, 0.0, 0.2, 0.0)
  * 100 random operations (0.8, 0.0, 0.0, 0.2)
  * 100 random operations (0.0, 0.8, 0.2, 0.0)
  * 100 random operations (0.0, 0.8, 0.0, 0.2)
  * 100 random operations (0.4, 0.4, 0.1, 0.1)
  * 100 random operations (0.2, 0.2, 0.3, 0.3)
==> passed

Test 7: Perform m random add/remove operations in the deque and check
        that only constant memory is allocated/deallocated per operation
  * m = 128
    - failed on operation 31 of 128
    - when current size of Deque was 16 objects;
    - the call to addLast() caused a change in memory of 128 bytes
    - any change of more than 96 bytes fails the test

  * m = 256
    - failed on operation 26 of 256
    - when current size of Deque was 16 objects;
    - the call to addFirst() caused a change in memory of 128 bytes
    - any change of more than 96 bytes fails the test

  * m = 512
    - failed on operation 23 of 512
    - when current size of Deque was 16 objects;
    - the call to addFirst() caused a change in memory of 128 bytes
    - any change of more than 96 bytes fails the test

==> FAILED

Test 8: Insert m items into deque; then iterate over deque and check
        that only constant memory is allocated/deallocated per operation
  * m = 64

    java.util.NoSuchElementException

    Deque$QueueIterator.next(Deque.java:100)
    MemoryOfDeque.checkConstantMemoryPerIteratorOperation(MemoryOfDeque.java:671)
    MemoryOfDeque.test8(MemoryOfDeque.java:712)
    MemoryOfDeque.main(MemoryOfDeque.java:741)

  * m = 128

    java.util.NoSuchElementException

    Deque$QueueIterator.next(Deque.java:100)
    MemoryOfDeque.checkConstantMemoryPerIteratorOperation(MemoryOfDeque.java:671)
    MemoryOfDeque.test8(MemoryOfDeque.java:713)
    MemoryOfDeque.main(MemoryOfDeque.java:741)

  * m = 256

    java.util.NoSuchElementException

    Deque$QueueIterator.next(Deque.java:100)
    MemoryOfDeque.checkConstantMemoryPerIteratorOperation(MemoryOfDeque.java:671)
    MemoryOfDeque.test8(MemoryOfDeque.java:714)
    MemoryOfDeque.main(MemoryOfDeque.java:741)

==> FAILED


Min observed memory for Deque: 8.00 n + 64.00   (R^2 = 1.000)
Max observed memory for Deque: 32.00 n + 32.00   (R^2 = 1.000)

Total: 38/49 tests passed!


================================================================



Analyzing memory of RandomizedQueue
*-----------------------------------------------------------
For Tests 1-5, the maximum amount of memory allowed for
a RandomizedQueue containing n items is 48n + 192.

For Test 6, the maximum amount of memory allowed for
a RandomizedQueue iterator over n items is 8n + 72.

Test 1a-1i: Total memory usage after inserting n items
            when n is a power of 2.

                 n        bytes
----------------------------------------------------------
=> passed       32          312         
=> passed       64          568         
=> passed      128         1080         
=> passed      256         2104         
=> passed      512         4152         
=> passed     1024         8248         
=> passed     2048        16440         
=> passed     4096        32824         
=> passed     8192        65592         
==> 9/9 tests passed

Memory: 8.00 n + 56.00   (R^2 = 1.000)


Test 2a-2i: Total memory usage after inserting n items,
            when n is one more than a power of 2.

                 n        bytes
----------------------------------------------------------
=> passed       33          568         
=> passed       65         1080         
=> passed      129         2104         
=> passed      257         4152         
=> passed      513         8248         
=> passed     1025        16440         
=> passed     2049        32824         
=> passed     4097        65592         
=> passed     8193       131128         
==> 9/9 tests passed

Memory: 16.00 n + 40.00   (R^2 = 1.000)


Test 3a-3i: Total memory usage after inserting 2n-1 items, and then
            deleting n-1 items, when n is one more than a power of 2.

                 n        bytes
----------------------------------------------------------
=> passed       33         1080         
=> passed       65         2104         
=> passed      129         4152         
=> passed      257         8248         
=> passed      513        16440         
=> passed     1025        32824         
=> passed     2049        65592         
=> passed     4097       131128         
=> passed     8193       262200         
==> 9/9 tests passed

Memory: 32.00 n + 24.00   (R^2 = 1.000)


Test 4a-4i: Total memory usage after inserting n items, deleting n items,
            then inserting n times, when n is a power of 2.

                 n        bytes
----------------------------------------------------------
=> passed       32          312         
=> passed       64          568         
=> passed      128         1080         
=> passed      256         2104         
=> passed      512         4152         
=> passed     1024         8248         
=> passed     2048        16440         
=> passed     4096        32824         
=> passed     8192        65592         
==> 9/9 tests passed

Memory: 8.00 n + 56.00   (R^2 = 1.000)


Test 5a-5i: Total memory usage after inserting n items,
            and then deleting all but one item.

                 n        bytes
----------------------------------------------------------
=> passed       32           72         
=> passed       64           72         
=> passed      128           72         
=> passed      256           72         
=> passed      512           72         
=> passed     1024           72         
=> passed     2048           72         
=> passed     4096           72         
=> passed     8192           72         
==> 9/9 tests passed

Memory: 72.00   (R^2 = 1.000)


Test 6a-6i: Total memory usage of iterator after inserting n items.

                 n        bytes
----------------------------------------------------------
=> passed       32          192         
=> passed       64          320         
=> passed      128          576         
=> passed      256         1088         
=> passed      512         2112         
=> passed     1024         4160         
=> passed     2048         8256         
=> passed     4096        16448         
=> passed     8192        32832         
==> 9/9 tests passed

Memory: 4.00 n + 64.00   (R^2 = 1.000)


Test 6j-6r: Total memory usage of iterator after inserting n items.

                 n        bytes
----------------------------------------------------------
=> passed       34          200         
=> passed       66          328         
=> passed      130          584         
=> passed      258         1096         
=> passed      514         2120         
=> passed     1026         4168         
=> passed     2050         8264         
=> passed     4098        16456         
=> passed     8194        32840         
==> 9/9 tests passed

Memory: 4.00 n + 64.00   (R^2 = 1.000)


Test 7a: Insert 100 strings; delete them one at a time, checking
         for loitering after each deletion.
==> passed

Test 7b: Perform random operations, checking for loitering after
         each operation. The probabilities of enqueue(), dequeue(),
         and sample() are (p1, p2, p3), respectively.
  * 200 random operations (0.8, 0.2, 0.0)
  * 200 random operations (0.2, 0.8, 0.0)
  * 200 random operations (0.6, 0.2, 0.2)
  * 200 random operations (0.2, 0.4, 0.4)
==> passed

Test 8: Insert m items into queue; then iterate over deque and check
        that only constant memory is allocated/deallocated per operation
  * m = 64
  * m = 128
  * m = 256
==> passed

Test 9: Total memory usage after inserting n items, seeking to identify
        values of n where memory usage is minimized as a function of n.

                 n        bytes
----------------------------------------------------------
=> passed       32          312         
=> passed       64          568         
=> passed      128         1080         
=> passed      256         2104         
=> passed      512         4152         
=> passed     1024         8248         
=> passed     2048        16440         
==> 7/7 tests passed

Memory: 8.00 n + 56.00   (R^2 = 1.000)


Test 10: Total memory usage after inserting 4096 items, then successively
         deleting items, seeking values of n where memory usage is maximized
         as a function of n

                 n        bytes
----------------------------------------------------------
=> passed     2049        65592         
=> passed     1025        32824         
=> passed      513        16440         
=> passed      257         8248         
=> passed      129         4152         
=> passed       65         2104         
=> passed       33         1080         
=> passed       17          568         
=> passed        9          312         
==> 9/9 tests passed

Memory: 32.00 n + 24.00   (R^2 = 1.000)


Min observed memory for RandomizedQueue: 8.00 n + 56.00   (R^2 = 1.000)
Max observed memory for RandomizedQueue: 32.00 n + 24.00   (R^2 = 1.000)

Running 82 total tests.

Total: 82/82 tests passed!


================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing Deque
*-----------------------------------------------------------
Running 103 total tests.

Test 1a-1k: make n calls to addFirst() followed by n calls to removeFirst()
                    n  seconds
----------------------------------
=> passed        1024     0.00
=> passed        2048     0.00
=> passed        4096     0.00
=> passed        8192     0.00
=> passed       16384     0.00
=> passed       32768     0.00
=> passed       65536     0.00
=> passed      128000     0.00
=> passed      256000     0.01
=> passed      512000     0.01
=> passed     1024000     0.02
==> 11/11 tests passed


Test 2a-2k: make n calls to addLast() followed by n calls to removeLast()
                    n  seconds
----------------------------------
=> passed        1024     0.00
=> passed        2048     0.00
=> passed        4096     0.00
=> passed        8192     0.00
=> passed       16384     0.00
=> passed       32768     0.00
=> passed       65536     0.00
=> passed      128000     0.00
=> passed      256000     0.01
=> passed      512000     0.01
=> passed     1024000     0.02
==> 11/11 tests passed


Test 3a-3k: make n calls to addFirst() followed by n calls to removeLast()
                    n  seconds
----------------------------------
=> passed        1024     0.00
=> passed        2048     0.00
=> passed        4096     0.00
=> passed        8192     0.00
=> passed       16384     0.00
=> passed       32768     0.00
=> passed       65536     0.00
=> passed      128000     0.00
=> passed      256000     0.01
=> passed      512000     0.01
=> passed     1024000     0.02
==> 11/11 tests passed


Test 4a-4k: make n calls to addLast() followed by n calls to removeFirst()
                    n  seconds
----------------------------------
=> pa

...

WARNING: the grading output was truncated due to excessive length.
Typically, this is because you have a method that has an unanticipated side effect
(such as printing to standard output or throwing an exception). A large amount of output
can also arise from failing many tests.
