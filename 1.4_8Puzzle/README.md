# Slider Puzzle

*Write a program to solve the 8-puzzle problem (and its natural generalizations) using the A* search algorithm

*The problem. The 8-puzzle is a sliding puzzle that is played on a 3-by-3 grid with 8 square tiles labeled 1 through 8, plus a blank square. The goal is to rearrange the tiles so that they are in row-major order, using as few moves as possible. You are permitted to slide tiles either horizontally or vertically into the blank square. The following diagram shows a sequence of moves from an initial board (left) to the goal board (right). 



********************************************************************************
*  ASSESSMENT SUMMARY                                                                    
********************************************************************************


See the Assessment Guide for information on how to interpret this report.

ASSESSMENT SUMMARY


Compilation:  PASSED
API:          PASSED

SpotBugs:     PASSED
PMD:          PASSED
Checkstyle:   PASSED

Correctness:  44/52 tests passed
Memory:       22/22 tests passed
Timing:       100/125 tests passed

Aggregate score: 86.77%
[ Compilation: 5%, API: 5%, Style: 0%, Correctness: 60%, Timing: 10%, Memory: 20% ]



ASSESSMENT DETAILS


The following files were submitted:
----------------------------------
8.6K Dec 22 13:22 Board.java
3.9K Dec 22 13:22 Solver.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac Board.java
*-----------------------------------------------------------

% javac Solver.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
Board:

Solver:

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

% custom checkstyle checks for Board.java
*-----------------------------------------------------------

% custom checkstyle checks for Solver.java
*-----------------------------------------------------------


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of Board
*-----------------------------------------------------------
Running 26 total tests.

Tests 4-7 and 14-17 rely upon toString() returning results in prescribed format.

Test 1a: check hamming() with file inputs
  * puzzle04.txt
  * puzzle00.txt
  * puzzle07.txt
  * puzzle17.txt
  * puzzle27.txt
  * puzzle2x2-unsolvable1.txt
==> passed

Test 1b: check hamming() with random n-by-n boards
  * 2-by-2
  * 3-by-3
  * 4-by-4
  * 5-by-5
  * 9-by-9
  * 10-by-10
  * 127-by-127
==> passed

Test 2a: check manhattan() with file inputs
  * puzzle04.txt
  * puzzle00.txt
  * puzzle07.txt
  * puzzle17.txt
  * puzzle27.txt
  * puzzle2x2-unsolvable1.txt
==> passed

Test 2b: check manhattan() with random n-by-n boards
  * 2-by-2
  * 3-by-3
  * 4-by-4
  * 5-by-5
  * 9-by-9
  * 10-by-10
  * 127-by-127
==> passed

Test 3: check dimension() with random n-by-n boards
  * 2-by-2
  * 3-by-3
  * 4-by-4
  * 5-by-5
  * 6-by-6
==> passed

Test 4a: check toString() with file inputs
  * puzzle04.txt
  * puzzle00.txt
  * puzzle06.txt
  * puzzle09.txt
  * puzzle23.txt
  * puzzle2x2-unsolvable1.txt
==> passed

Test 4b: check toString() with random n-by-n boards
  * 2-by-2
  * 3-by-3
  * 4-by-4
  * 5-by-5
  * 9-by-9
  * 10-by-10
  * 127-by-127
==> passed

Test 5a: check neighbors() with file inputs
  * puzzle04.txt
    - neighbor not found by student:
        3
         1  0  3 
         4  2  5 
         7  8  6 


  * puzzle00.txt
    - neighbor not found by student:
        [suppressed]


  * puzzle06.txt
    - neighbor not found by student:
        4
         1  0  2  3 
         5  6  7  4 
         9 10 11  8 
        13 14 15 12 


  * puzzle09.txt
    - neighbor not found by student:
        4
         0  2  3  4 
         1 10  6  8 
         5  9  7 12 
        13 14 11 15 


  * puzzle23.txt
    - neighbor not found by student:
        3
         0  5  4 
         2  3  8 
         7  1  6 


  * puzzle2x2-unsolvable1.txt
    - neighbor not found by student:
        2
         0  1 
         2  3 


==> FAILED

Test 5b: check neighbors() with random n-by-n boards
  * 2-by-2
    - neighbor not found by student:
        2
         0  3 
         2  1 


    - failed on trial 1 of 1000

  * 3-by-3
    - neighbor not found by student:
        3
         7  2  5 
         4  1  0 
         8  6  3 


    - failed on trial 1 of 1000

  * 4-by-4
    - neighbor not found by student:
        4
         6 12  0  5 
         1  7 13  2 
        10  4  8  3 
        11  9 14 15 


    - failed on trial 1 of 1000

  * 5-by-5
    - neighbor not found by student:
        5
         8  1 14  6 17 
         4 22 15 11 18 
        21 13 24 19 12 
         3 23  0 20  7 
         5 10  9  2 16 


    - failed on trial 1 of 1000

  * 9-by-9
    - neighbor not found by student:
        9
        25 34 61 64 60 79 56 26 59 
        27  8 78 53  3 19 28 70 71 
        21 48 62 72  9 68 54 80 11 
        42 66 13  4 18 20 63  5 46 
        73 74 31  2 16 38 37 41 35 
        10 50 51  1 43 23 22  0 44 
        69 30 77 15  7 67 47 76 45 
        49 57 52 24 36 40 17  6 39 
        55 12 58 65 32 29 33 75 14 


    - failed on trial 1 of 1000

  * 10-by-10
    - neighbor not found by student:
        [suppressed]


    - failed on trial 1 of 1000

  * 127-by-127
    - neighbor not found by student:
        [suppressed]


    - failed on trial 1 of 10

==> FAILED

Test 6a: check neighbors() of neighbors() with file inputs
  * puzzle04.txt
    - number of entries in student   solution: 6
    - number of entries in reference solution: 6
    - 6 extra entries in student solution, including:
      '3
       4  1  3 
       0  0  0 
       0  0  0 
      '

    - 6 missing entries in student solution, including:
      '3
       4  1  3 
       7  2  5 
       0  8  6 
      '

    - board
        3
         0  1  3 
         4  2  5 
         7  8  6 

  * puzzle00.txt
    - number of entries in student   solution: 6
    - number of entries in reference solution: 6
    - 6 extra entries in student solution, including:
      '10
       1  2  3  4  5  6  7  8  9 10 
       0  0  0  0  0  0  0  0  0  0 
       0  0  0  0  0  0  0  0  0  0 
       0  0  0  0  0  0  0  0  0  0 
       0  0  0  0  0  0  0  0  0  0 
       0  0  0  0  0  0  0  0  0  0 
       0  0  0  0  0  0  0  0  0  0 
       0  0  0  0  0  0  0  0  0  0 
       0  0  0  0  0  0  0  0  0  0 
       0  0  0  0  0  0  0  0  0  0 
      '

    - 6 missing entries in student solution, including:
      '10
       1  2  3  4  5  6  7  8  9 10 
      11 12 13 14 15 16 17 18 19 20 
      21 22 23 24 25 26 27 28 29 30 
      31 32 33 34 35 36 37 38 39 40 
      41 42 43 44 45 46 47 48 49 50 
      51 52 53 54 55 56 57 58 59 60 
      61 62 63 64 65 66 67 68 69 70 
      71 72 73 74 75 76 77 78 79 80 
      81 82 83 84 85 86 87 88 89 90 
      91 92 93 94 95 96 97 98 99  0 
      '

    - board
        10
         1  2  3  4  5  6  7  8  9 10 
        11 12 13 14 15 16 17 18 19 20 
        21 22 23 24 25 26 27 28 29 30 
        31 32 33 34 35 36 37 38 39 40 
        41 42 43 44 45 46 47 48 49 50 
        51 52 53 54 55 56 57 58 59 60 
        61 62 63 64 65 66 67 68 69 70 
        71 72 73 74 75 76 77 78 79 80 
        81 82 83 84 85 86 87 88 89 90 
        91 92 93 94 95 96 97 98 99  0 

  * puzzle06.txt
    - number of entries in student   solution: 6
    - number of entries in reference solution: 6
    - 6 extra entries in student solution, including:
      '4
       5  1  2  3 
       0  0  0  0 
       0  0  0  0 
       0  0  0  0 
      '

    - 6 missing entries in student solution, including:
      '4
       5  1  2  3 
       9  6  7  4 
       0 10 11  8 
      13 14 15 12 
      '

    - board
        4
         0  1  2  3 
         5  6  7  4 
         9 10 11  8 
        13 14 15 12 

  * puzzle09.txt
    - incorrect number of neighbors of neighbors
    - student   neighbors = 8
    - reference neighbors = 9
    - board
        4
         2  0  3  4 
         1 10  6  8 
         5  9  7 12 
        13 14 11 15 


  * puzzle23.txt
    - incorrect number of neighbors of neighbors
    - student   neighbors = 7
    - reference neighbors = 8
    - board
        3
         5  0  4 
         2  3  8 
         7  1  6 


  * puzzle2x2-unsolvable1.txt
    - number of entries in student   solution: 4
    - number of entries in reference solution: 4
    - 4 extra entries in student solution, including:
      '2
       1  3 
       0  0 
      '

    - 4 missing entries in student solution, including:
      '2
       2  1 
       0  3 
      '

    - board
        2
         1  0 
         2  3 

==> FAILED

Test 6b: check neighbors() of neighbors() with random n-by-n boards
  * 2-by-2
    - number of entries in student   solution: 4
    - number of entries in reference solution: 4
    - 4 extra entries in student solution, including:
      '2
       2  0 
       0  0 
      '

    - 4 missing entries in student solution, including:
      '2
       2  3 
       1  0 
      '

    - board
        2
         0  2 
         1  3 

    - failed on trial 1 of 1000

  * 3-by-3
    - number of entries in student   solution: 8
    - number of entries in reference solution: 8
    - 8 extra entries in student solution, including:
      '3
       8  5  2 
       0  0  0 
       0  0  0 
      '

    - 8 missing entries in student solution, including:
      '3
       8  5  2 
       7  6  3 
       4  0  1 
      '

    - board
        3
         8  5  2 
         0  6  3 
         7  4  1 

    - failed on trial 1 of 1000

  * 4-by-4
    - incorrect number of neighbors of neighbors
    - student   neighbors = 12
    - reference neighbors = 14
    - board
        4
        11  5 15  7 
        14 13  6  9 
         8  1  0 10 
         3  4 12  2 


    - failed on trial 1 of 1000

  * 5-by-5
    - number of entries in student   solution: 9
    - number of entries in reference solution: 9
    - 9 extra entries in student solution, including:
      '5
      16  2 11 10 18 
       0  0  0  0  0 
       0  0  0  0  0 
       0  0  0  0  0 
       0  0  0  0  0 
      '

    - 9 missing entries in student solution, including:
      '5
      16  2 11 10 18 
      15 19 22  3 23 
      17 14 24 12  8 
      20  6  0  7  5 
       9  4 21  1 13 
      '

    - board
        5
        16  2 11 10 18 
        15 19 22  3 23 
        17 14 24 12  8 
         0 20  6  7  5 
         9  4 21  1 13 

    - failed on trial 1 of 1000

  * 9-by-9
    - incorrect number of neighbors of neighbors
    - student   neighbors = 12
    - reference neighbors = 15
    - board
        9
        56  8 65 66 47 55 11 76 67 
        15 40 21 18 57  0 35 46 62 
        24 14 61  7 42  2 49 38  4 
        63 68 23 31 41 28 19  5 75 
        51 17 74 52 59 48 64 29 50 
        69 37 39 12 43 77 44 13 20 
        58 79 60  3 45 72 27 78 34 
        71 10 26 36 54 32 25 70 73 
        33  6 16 22 53 30  9 80  1 


    - failed on trial 1 of 1000

  * 10-by-10
    - incorrect number of neighbors of neighbors
    - student   neighbors = 9
    - reference neighbors = 10
    - board
        10
        51 78 31 53 92  3 67 17 90 61 
        72 48  1 40 81 44 58 47 45 64 
        74 11 20 62 66 69 76 93 95 55 
        23 43 19  5 85 59 26 75 46 63 
        88 54 21 57 41  9  2 49 10 77 
        28 39 68 33 24 94 56 84 86 22 
        73 16 87  8 14  4 97  7 60 52 
        89 13 30 12 91 29 25 96 36 50 
        70 15 42 38 35 34 18 71 27 98 
        65 37  6 82 80  0 32 99 79 83 


    - failed on trial 1 of 1000

==> FAILED

Test 7a: check twin() with file inputs
  * puzzle04.txt
    - twin() doesn't return a twin
    - twin
        3
         0  3  1 
         0  0  0 
         0  0  0 

  * puzzle00.txt
    - twin() doesn't return a twin
    - twin
        10
         2  1  3  4  5  6  7  8  9 10 
         0  0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0  0 

  * puzzle06.txt
    - twin() doesn't return a twin
    - twin
        4
         0  2  1  3 
         0  0  0  0 
         0  0  0  0 
         0  0  0  0 

  * puzzle09.txt
    - twin() doesn't return a twin
    - twin
        4
         2  0  4  3 
         0  0  0  0 
         0  0  0  0 
         0  0  0  0 

  * puzzle23.txt
    - twin() doesn't return a twin
    - twin
        3
         5  0  4 
         0  0  0 
         0  0  0 

  * puzzle2x2-unsolvable1.txt
    - twin() doesn't return a twin
    - twin
        2
         2  0 
         0  0 

==> FAILED

Test 7b: check twin() with random n-by-n boards
  * 2-by-2
    - twin() doesn't return a twin
    - twin
        2
         0  2 
         0  0 

    - failed on trial 1 of 1000

  * 3-by-3
    - twin() doesn't return a twin
    - twin
        3
         0  4  6 
         0  0  0 
         0  0  0 

    - failed on trial 1 of 1000

  * 4-by-4
    - twin() doesn't return a twin
    - twin
        4
        15  3  5  8 
         0  0  0  0 
         0  0  0  0 
         0  0  0  0 

    - failed on trial 1 of 1000

  * 5-by-5
    - twin() doesn't return a twin
    - twin
        5
         2  9 20 24  4 
         0  0  0  0  0 
         0  0  0  0  0 
         0  0  0  0  0 
         0  0  0  0  0 

    - failed on trial 1 of 1000

  * 9-by-9
    - twin() doesn't return a twin
    - twin
        9
        32 47 69 57  0 29  1 79 26 
         0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0 

    - failed on trial 1 of 100

  * 10-by-10
    - twin() doesn't return a twin
    - twin
        10
        56 83  3 84 41 61 58 53 66 78 
         0  0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0  0 
         0  0  0  0  0  0  0  0  0  0 

    - failed on trial 1 of 10

==> FAILED

Test 8a: check isGoal() with file inputs
  * puzzle00.txt
    - isGoal() returns wrong answer
    - student   isGoal() = false
    - reference isGoal() = true
    - board
        10
         1  2  3  4  5  6  7  8  9 10 
        11 12 13 14 15 16 17 18 19 20 
        21 22 23 24 25 26 27 28 29 30 
        31 32 33 34 35 36 37 38 39 40 
        41 42 43 44 45 46 47 48 49 50 
        51 52 53 54 55 56 57 58 59 60 
        61 62 63 64 65 66 67 68 69 70 
        71 72 73 74 75 76 77 78 79 80 
        81 82 83 84 85 86 87 88 89 90 
        91 92 93 94 95 96 97 98 99  0 

  * puzzle04.txt
  * puzzle16.txt
  * puzzle06.txt
  * puzzle09.txt
  * puzzle23.txt
  * puzzle2x2-unsolvable1.txt
  * puzzle3x3-unsolvable1.txt
  * puzzle3x3-00.txt
    - isGoal() returns wrong answer
    - student   isGoal() = false
    - reference isGoal() = true
    - board
        3
         1  2  3 
         4  5  6 
         7  8  0 

  * puzzle4x4-00.txt
    - isGoal() returns wrong answer
    - student   isGoal() = false
    - reference isGoal() = true
    - board
        4
         1  2  3  4 
         5  6  7  8 
         9 10 11 12 
        13 14 15  0 

==> FAILED

Test 8b: check isGoal() on n-by-n goal boards
  * 2-by-2
    - isGoal() returns wrong answer
    - student   isGoal() = false
    - reference isGoal() = true
    - board
        2
         1  2 
         3  0 

  * 3-by-3
    - isGoal() returns wrong answer
    - student   isGoal() = false
    - reference isGoal() = true
    - board
        3
         1  2  3 
         4  5  6 
         7  8  0 

  * 4-by-4
    - isGoal() returns wrong answer
    - student   isGoal() = false
    - reference isGoal() = true
    - board
        4
         1  2  3  4 
         5  6  7  8 
         9 10 11 12 
        13 14 15  0 

  * 5-by-5
    - isGoal() returns wrong answer
    - student   isGoal() = false
    - reference isGoal() = true
    - board
        5
         1  2  3  4  5 
         6  7  8  9 10 
        11 12 13 14 15 
        16 17 18 19 20 
        21 22 23 24  0 

  * 6-by-6
    - isGoal() returns wrong answer
    - student   isGoal() = false
    - reference isGoal() = true
    - board
        6
         1  2  3  4  5  6 
         7  8  9 10 11 12 
        13 14 15 16 17 18 
        19 20 21 22 23 24 
        25 26 27 28 29 30 
        31 32 33 34 35  0 

  * 100-by-100
    - isGoal() returns wrong answer
    - student   isGoal() = false
    - reference isGoal() = true

==> FAILED

Test 9: check that two Board objects can be created at the same time
  * random 3-by-3 and 3-by-3 boards
  * random 4-by-4 and 4-by-4 boards
  * random 2-by-2 and 2-by-2 boards
  * random 3-by-3 and 4-by-4 boards
  * random 4-by-4 and 3-by-3 boards
==> passed

Test 10a: check equals()
  * reflexive
  * symmetric
  * transitive
  * argument is null
  * argument is of type String
  * argument is of type UncastableString
  * argument is of type Object and contains a reference to a Board
  * argument is of type Object containing a reference to a String
==> passed

Test 10b: check correctness of equals() on random n-by-n boards
  * n = 2
  * n = 3
  * n = 4
  * 5 <= n < 10
==> passed

Test 10c: check equals() when board sizes m and n are different
  * m = 4, n = 5
  * m = 2, n = 5
  * m = 5, n = 3
  * m = 2, n = 3
  * m = 3, n = 2
==> passed

Test 11: check that Board is immutable by changing argument array after
         construction and making sure Board does not mutate
==> passed

Test 12: check that Board is immutable by testing whether methods
         return the same value, regardless of order in which called
  * puzzle10.txt
  * puzzle20.txt
  * puzzle30.txt
  * 2-by-2
  * 3-by-3
  * 4-by-4
==> passed

Test 13: check dimension() on a board that is kth neighbor of a board
  * 0th neighbor of puzzle27.txt
  * 1st neighbor of puzzle27.txt
  * 2nd neighbor of puzzle27.txt
  * 13th neighbor of puzzle27.txt
  * 13th neighbor of puzzle00.txt
  * 13th neighbor of puzzle2x2-unsolvable1.txt
==> passed

Test 14: check hamming() on a board that is kth neighbor of a board
  * 0th neighbor of puzzle27.txt
  * 1st neighbor of puzzle27.txt
  * 2nd neighbor of puzzle27.txt
  * 13th neighbor of puzzle27.txt
  * 13th neighbor of puzzle00.txt
  * 13th neighbor of puzzle2x2-unsolvable1.txt
==> passed

Test 15: check manhattan() on a board that is a kth neighbor of a board
  * 0th neighbor of puzzle27.txt
  * 1st neighbor of puzzle27.txt
  * 2nd neighbor of puzzle27.txt
  * 13th neighbor of puzzle27.txt
  * 13th neighbor of puzzle00.txt
  * 13th neighbor of puzzle2x2-unsolvable1.txt
==> passed

Test 16: check hamming() on a board that is a kth twin of a board
  * 0th twin of puzzle27.txt
  * 1st twin of puzzle27.txt
  * 2nd twin of puzzle27.txt
  * 13th twin of puzzle27.txt
  * 13th twin of puzzle00.txt
  * 13th twin of puzzle2x2-unsolvable1.txt
==> passed

Test 17: check manhattan() on a board that is a kth twin of a board
  * 0th twin of puzzle27.txt
  * 1st twin of puzzle27.txt
  * 2nd twin of puzzle27.txt
  * 13th twin of puzzle27.txt
  * 13th twin of puzzle00.txt
  * 13th twin of puzzle2x2-unsolvable1.txt
==> passed


Total: 18/26 tests passed!


================================================================
********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Board
*-----------------------------------------------------------
Running 10 total tests.

Memory usage of an n-by-n board
[ must be at most 4n^2 + 32n + 64 bytes ]


              n       student (bytes)    reference (bytes)
----------------------------------------------------------
=> passed     2            72                  128
=> passed     3            96                  192
=> passed     4           120                  240
=> passed     8           312                  560
=> passed    12           632                 1008
=> passed    16          1080                 1584
=> passed    20          1656                 2288
=> passed    37          5536                 6856
=> passed    72         20792                23088
=> passed   120         57656                61488
==> 10/10 tests passed

Total: 10/10 tests passed!

Student   memory = 4.00 n^2 + 0.00 n + 56.00   (R^2 = 1.000)
Reference memory = 4.00 n^2 + 32.00 n + 48.00   (R^2 = 1.000)


================================================================



********************************************************************************
*  TESTING CORRECTNESS (substituting reference Board)
********************************************************************************

Testing correctness of Solver
*-----------------------------------------------------------
Running 26 total tests.

Test 1: check that Solver doesn't mutate objects added to MinPQ
        after they've been added
  * puzzle00.txt
  * puzzle01.txt
  * puzzle02.txt
  * puzzle03.txt
  * puzzle04.txt
  * puzzle05.txt
  * puzzle06.txt
  * puzzle07.txt
  * puzzle08.txt
==> passed

Test 2a: check moves() with file inputs
  * puzzle00.txt
  * puzzle01.txt
  * puzzle02.txt
  * puzzle03.txt
  * puzzle04.txt
  * puzzle05.txt
  * puzzle06.txt
  * puzzle07.txt
  * puzzle08.txt
  * puzzle09.txt
  * puzzle10.txt
  * puzzle11.txt
  * puzzle12.txt
  * puzzle13.txt
==> passed

Test 2b: check solution() with file inputs
  * puzzle00.txt
  * puzzle01.txt
  * puzzle02.txt
  * puzzle03.txt
  * puzzle04.txt
  * puzzle05.txt
  * puzzle06.txt
  * puzzle07.txt
  * puzzle08.txt
  * puzzle09.txt
  * puzzle10.txt
  * puzzle11.txt
  * puzzle12.txt
  * puzzle13.txt
==> passed

Test 3a: check moves() with more file inputs
  * puzzle14.txt
  * puzzle15.txt
  * puzzle16.txt
  * puzzle17.txt
  * puzzle18.txt
  * puzzle19.txt
  * puzzle20.txt
  * puzzle21.txt
  * puzzle22.txt
  * puzzle23.txt
  * puzzle24.txt
  * puzzle25.txt
  * puzzle26.txt
  * puzzle27.txt
  * puzzle28.txt
  * puzzle29.txt
  * puzzle30.txt
  * puzzle31.txt
==> passed

Test 3b: check solution() with more file inputs
  * puzzle14.txt
  * puzzle15.txt
  * puzzle16.txt
  * puzzle17.txt
  * puzzle18.txt
  * puzzle19.txt
  * puzzle20.txt
  * puzzle21.txt
  * puzzle22.txt
  * puzzle23.txt
  * puzzle24.txt
  * puzzle25.txt
  * puzzle26.txt
  * puzzle27.txt
  * puzzle28.txt
  * puzzle29.txt
  * puzzle30.txt
  * puzzle31.txt
==> passed

Test 4a: check moves() with random solvable n-by-n boards
  * 1000 random 3-by-3 boards that are exactly 1 move from goal
  * 1000 random 3-by-3 boards that are exactly 2 moves from goal
  * 1000 random 3-by-3 boards that are exactly 3 moves from goal
  * 1000 random 3-by-3 boards that are exactly 4 moves from goal
  * 1000 random 3-by-3 boards that are exactly 5 moves from goal
  * 1000 random 3-by-3 boards that are exactly 6 moves from goal
  * 1000 random 3-by-3 boards that are exactly 7 moves from goal
  * 1000 random 3-by-3 boards that are exactly 8 moves from goal
  * 1000 random 3-by-3 boards that are exactly 9 moves from goal
  * 1000 random 3-by-3 boards that are exactly 10 moves from goal
  * 1000 random 3-by-3 boards that are exactly 11 moves from goal
  * 1000 random 3-by-3 boards that are exactly 12 moves from goal
==> passed

Test 4b: check solution() with random solvable n-by-n boards
  * 1000 random 3-by-3 boards that are exactly 1 move from goal
  * 1000 random 3-by-3 boards that are exactly 2 moves from goal
  * 1000 random 3-by-3 boards that are exactly 3 moves from goal
  * 1000 random 3-by-3 boards that are exactly 4 moves from goal
  * 1000 random 3-by-3 boards that are exactly 5 moves from goal
  * 1000 random 3-by-3 boards that are exactly 6 moves from goal
  * 1000 random 3-by-3 boards that are exactly 7 moves from goal
  * 1000 random 3-by-3 boards that are exactly 8 moves from goal
  * 1000 random 3-by-3 boards that are exactly 9 moves from goal
  * 1000 random 3-by-3 boards that are exactly 10 moves from goal
  * 1000 random 3-by-3 boards that are exactly 11 moves from goal
  * 1000 random 3-by-3 boards that are exactly 12 moves from goal
==> passed

Test 5: create two Solver objects at the same time
  * puzzle04.txt and puzzle04.txt
  * puzzle00.txt and puzzle04.txt
  * puzzle04.txt and puzzle00.txt
==> passed

Test 6a: call isSolvable() with file inputs
  * puzzle01.txt
  * puzzle03.txt
  * puzzle04.txt
  * puzzle17.txt
  * puzzle3x3-unsolvable1.txt
  * puzzle3x3-unsolvable2.txt
  * puzzle4x4-unsolvable.txt
==> passed

Test 6b: call isSolvable() on random n-by-n boards
  * 100 random 2-by-2 boards
==> passed

Test 7: check moves() on unsolvable puzzles
  * puzzle2x2-unsolvable1.txt
  * puzzle2x2-unsolvable2.txt
  * puzzle3x3-unsolvable1.txt
  * puzzle3x3-unsolvable2.txt
  * puzzle4x4-unsolvable.txt
==> passed

Test 8: check solution() on unsolvable puzzles
  * puzzle2x2-unsolvable1.txt
  * puzzle2x2-unsolvable2.txt
  * puzzle3x3-unsolvable1.txt
  * puzzle3x3-unsolvable2.txt
  * puzzle4x4-unsolvable.txt
==> passed

Test 9a: check that Solver is immutable by testing whether methods
         return the same value, regardless of order in which called
  * puzzle3x3-00.txt
  * puzzle3x3-01.txt
  * puzzle3x3-05.txt
  * puzzle3x3-10.txt
  * random 2-by-2 solvable boards
==> passed

Test 9b: check that Solver is immutable by testing whether methods
         return the same value, regardless of order in which called
  * puzzle3x3-unsolvable1.txt
  * puzzle3x3-unsolvable2.txt
  * puzzle4x4-unsolvable.txt
  * random 2-by-2 unsolvable boards
==> passed

Test 10a: check that equals() method in Board is called
  * puzzle04.txt
  * puzzle05.txt
  * puzzle10.txt
==> passed

Test 10b: check that equals() method in Board is called only
          with an argument of type Board
  * puzzle00.txt
  * puzzle04.txt
  * puzzle05.txt
  * puzzle10.txt
==> passed

Test 10c: check that equals() method in Board is called only
          with a neighbor of a neighbor as an argument
  * puzzle00.txt
  * puzzle04.txt
  * puzzle05.txt
  * puzzle10.txt
  * puzzle27.txt
==> passed

Test 11: check that constructor throws exception if board is null
==> passed

Test 12a: check moves() with 2-by-2 file inputs
  * puzzle2x2-00.txt
  * puzzle2x2-01.txt
  * puzzle2x2-02.txt
  * puzzle2x2-03.txt
  * puzzle2x2-04.txt
  * puzzle2x2-05.txt
  * puzzle2x2-06.txt
==> passed

Test 12b: check solution() with 2-by-2 file inputs
  * puzzle2x2-00.txt
  * puzzle2x2-01.txt
  * puzzle2x2-02.txt
  * puzzle2x2-03.txt
  * puzzle2x2-04.txt
  * puzzle2x2-05.txt
  * puzzle2x2-06.txt
==> passed

Test 13a: check moves() with 3-by-3 file inputs
  * puzzle3x3-00.txt
  * puzzle3x3-01.txt
  * puzzle3x3-02.txt
  * puzzle3x3-03.txt
  * puzzle3x3-04.txt
  * puzzle3x3-05.txt
  * puzzle3x3-06.txt
  * puzzle3x3-07.txt
  * puzzle3x3-08.txt
  * puzzle3x3-09.txt
  * puzzle3x3-10.txt
  * puzzle3x3-11.txt
  * puzzle3x3-12.txt
  * puzzle3x3-13.txt
  * puzzle3x3-14.txt
  * puzzle3x3-15.txt
  * puzzle3x3-16.txt
  * puzzle3x3-17.txt
  * puzzle3x3-18.txt
  * puzzle3x3-19.txt
  * puzzle3x3-20.txt
  * puzzle3x3-21.txt
  * puzzle3x3-22.txt
  * puzzle3x3-23.txt
  * puzzle3x3-24.txt
  * puzzle3x3-25.txt
  * puzzle3x3-26.txt
  * puzzle3x3-27.txt
  * puzzle3x3-28.txt
  * puzzle3x3-29.txt
  * puzzle3x3-30.txt
==> passed

Test 13b: check solution() with 3-by-3 file inputs
  * puzzle3x3-00.txt
  * puzzle3x3-01.txt
  * puzzle3x3-02.txt
  * puzzle3x3-03.txt
  * puzzle3x3-04.txt
  * puzzle3x3-05.txt
  * puzzle3x3-06.txt
  * puzzle3x3-07.txt
  * puzzle3x3-08.txt
  * puzzle3x3-09.txt
  * puzzle3x3-10.txt
  * puzzle3x3-11.txt
  * puzzle3x3-12.txt
  * puzzle3x3-13.txt
  * puzzle3x3-14.txt
  * puzzle3x3-15.txt
  * puzzle3x3-16.txt
  * puzzle3x3-17.txt
  * puzzle3x3-18.txt
  * puzzle3x3-19.txt
  * puzzle3x3-20.txt
  * puzzle3x3-21.txt
  * puzzle3x3-22.txt
  * puzzle3x3-23.txt
  * puzzle3x3-24.txt
  * puzzle3x3-25.txt
  * puzzle3x3-26.txt
  * puzzle3x3-27.txt
  * puzzle3x3-28.txt
  * puzzle3x3-29.txt
  * puzzle3x3-30.txt
==> passed

Test 14a: check moves() with 4-by-4 file inputs
  * puzzle4x4-00.txt
  * puzzle4x4-01.txt
  * puzzle4x4-02.txt
  * puzzle4x4-03.txt
  * puzzle4x4-04.txt
  * puzzle4x4-05.txt
  * puzzle4x4-06.txt
  * puzzle4x4-07.txt
  * puzzle4x4-08.txt
  * puzzle4x4-09.txt
  * puzzle4x4-10.txt
  * puzzle4x4-11.txt
  * puzzle4x4-12.txt
  * puzzle4x4-13.txt
  * puzzle4x4-14.txt
  * puzzle4x4-15.txt
  * puzzle4x4-16.txt
  * puzzle4x4-17.txt
  * puzzle4x4-18.txt
  * puzzle4x4-19.txt
  * puzzle4x4-20.txt
  * puzzle4x4-21.txt
  * puzzle4x4-22.txt
  * puzzle4x4-23.txt
  * puzzle4x4-24.txt
  * puzzle4x4-25.txt
  * puzzle4x4-26.txt
  * puzzle4x4-27.txt
  * puzzle4x4-28.txt
  * puzzle4x4-29.txt
  * puzzle4x4-30.txt
==> passed

Test 14b: check solution() with 4-by-4 file inputs
  * puzzle4x4-00.txt
  * puzzle4x4-01.txt
  * puzzle4x4-02.txt
  * puzzle4x4-03.txt
  * puzzle4x4-04.txt
  * puzzle4x4-05.txt
  * puzzle4x4-06.txt
  * puzzle4x4-07.txt
  * puzzle4x4-08.txt
  * puzzle4x4-09.txt
  * puzzle4x4-10.txt
  * puzzle4x4-11.txt
  * puzzle4x4-12.txt
  * puzzle4x4-13.txt
  * puzzle4x4-14.txt
  * puzzle4x4-15.txt
  * puzzle4x4-16.txt
  * puzzle4x4-17.txt
  * puzzle4x4-18.txt
  * puzzle4x4-19.txt
  * puzzle4x4-20.txt
  * puzzle4x4-21.txt
  * puzzle4x4-22.txt
  * puzzle4x4-23.txt
  * puzzle4x4-24.txt
  * puzzle4x4-25.txt
  * puzzle4x4-26.txt
  * puzzle4x4-27.txt
  * puzzle4x4-28.txt
  * puzzle4x4-29.txt
  * puzzle4x4-30.txt
==> passed

Test 15a: check moves() with random solvable n-by-n boards
  * 100 random 2-by-2 boards that are <= 6 moves from goal
  * 200 random 3-by-3 boards that are <= 20 moves from goal
  * 200 random 4-by-4 boards that are <= 20 moves from goal
  * 200 random 5-by-5 boards that are <= 20 moves from goal
==> passed

Test 15b: check solution() with random solvable n-by-n boards
  * 100 random 2-by-2 boards that are <= 6 moves from goal
  * 200 random 3-by-3 boards that are <= 20 moves from goal
  * 200 random 4-by-4 boards that are <= 20 moves from goal
  * 200 random 5-by-5 boards that are <= 20 moves from goal
==> passed


Total: 26/26 tests passed!


================================================================
********************************************************************************
*  MEMORY (substituting reference Board)
********************************************************************************

Analyzing memory of Solver
*-----------------------------------------------------------
Running 12 total tests.

Maximum allowed time per puzzle is 5.0 seconds.
Maximum allowed memory per puzzle = 200000000 bytes.

Test 1: Measure memory of Solver.

               filename   moves   memory
---------------------------------------------
=> passed  puzzle10.txt      10     4640         
=> passed  puzzle15.txt      15     5568         
=> passed  puzzle20.txt      20     2752         
=> passed  puzzle25.txt      25     3392         
=> passed  puzzle30.txt      30     4032         
=> passed  puzzle35.txt      35     5536         
==> 6/6 tests passed



Test 2: Measure memory of MinPQ.

                              deep              max           ending
               filename     memory             size             size
--------------------------------------------------------------------
=> passed  puzzle10.txt      28544               34               32         
=> passed  puzzle15.txt      35896               52               50         
=> passed  puzzle20.txt     218832              587              585         
=> passed  puzzle25.txt    1555264             4214             4212         
=> passed  puzzle30.txt    6472176            17038            17036         
=> passed  puzzle35.txt   92933984           271122           271120         
==> 6/6 tests passed


Total: 12/12 tests passed!


================================================================



********************************************************************************
*  TIMING (substituting reference Board)
********************************************************************************

Timing Solver
*-----------------------------------------------------------
Running 125 total tests.

Maximum allowed time per puzzle is 5.0 seconds.

Test 1: Measure CPU time and check correctness

               filename   moves    n  seconds
---------------------------------------------
=> passed  puzzle20.txt      20    3     0.01 
=> passed  puzzle22.txt      22    3     0.00 
=> passed  puzzle21.txt      21    3     0.00 
=> passed  puzzle23.txt      23    3     0.01 
=> passed  puzzle24.txt      24    3     0.01 
=> passed  puzzle25.txt      25    3     0.01 
=> passed  puzzle27.txt      27    3     0.01 
=> passed  puzzle29.txt      29    3     0.01 
=> passed  puzzle26.txt      26    3     0.01 
=> passed  puzzle28.txt      28    3     0.01 
=> passed  puzzle30.txt      30    3     0.02 
=> passed  puzzle31.txt      31    3     0.02 
=> passed  puzzle39.txt      39    4     0.04 
=> passed  puzzle41.txt      41    5     0.07 
=> passed  puzzle34.txt      34    4     0.08 
=> passed  puzzle37.txt      37    4     0.08 
=> passed  puzzle44.txt      44    5     0.16 
=> passed  puzzle32.txt      32    4     0.28 
=> passed  puzzle35.txt      35    4     0.29 
=> passed  puzzle33.txt      33    4     0.34 
=> passed  puzzle43.txt      43    4     0.56 
=> passed  puzzle46.txt      46    4     0.54 
=> passed  puzzle40.txt      40    4     0.60 
=> passed  puzzle36.txt      36    4     1.18 
=> passed  puzzle45.txt      45    4     1.31 
==> 25/25 tests passed



Test 2: Count MinPQ operations

               filename   insert()         delMin()
---------------------------------------------------
=> passed  puzzle20.txt       1439              854         
=> passed  puzzle22.txt       3481             2072         
=> passed  puzzle21.txt       3541             2082         
=> passed  puzzle23.txt       5299             3150         
=> passed  puzzle24.txt       5427             3260         
=> passed  puzzle25.txt      10316             6104         
=> passed  puzzle27.txt      11209             6742         
=> passed  puzzle29.txt      11637             7078         
=> passed  puzzle26.txt      11894             7100         
=> passed  puzzle28.txt      26974            16232         
=> passed  puzzle30.txt      43094            26058         
=> passed  puzzle31.txt      46007            27806         
=> passed  puzzle39.txt      71417            35046         
=> passed  puzzle41.txt     116491            50010         
=> passed  puzzle34.txt     151673            73160         
=> passed  puzzle37.txt     166811            80086         
=> passed  puzzle44.txt     275661           123166         
=> passed  puzzle32.txt     521596           249496         
=> passed  puzzle35.txt     528418           257298         
=> passed  puzzle33.txt     622352           298884         
=> passed  puzzle43.txt    1056805           508834         
=> passed  puzzle46.txt    1032320           516742         
=> passed  puzzle40.txt    1108443           541468         
=> passed  puzzle36.txt    2086331          1011486         
=> passed  puzzle45.txt    2418079          1189754         
==> 25/25 tests passed



Test 3: Count Board operations (that should not get called)

               filename    hamming()   toString()
-------------------------------------------------
=> passed  puzzle20.txt            0            0         
=> passed  puzzle22.txt            0            0         
=> passed  puzzle21.txt            0            0         
=> passed  puzzle23.txt            0            0         
=> passed  puzzle24.txt            0            0         
=> passed  puzzle25.txt            0            0         
=> passed  puzzle27.txt            0            0         
=> passed  puzzle29.txt            0            0         
=> passed  puzzle26.txt            0            0         
=> passed  puzzle28.txt            0            0         
=> passed  puzzle30.txt            0            0         
=> passed  puzzle31.txt            0            0         
=> passed  puzzle39.txt            0            0         
=> passed  puzzle41.txt            0            0         
=> passed  puzzle34.txt            0            0         
=> passed  puzzle37.txt            0            0         
=> passed  puzzle44.txt            0            0         
=> passed  puzzle32.txt            0            0         
=> passed  puzzle35.txt            0            0         
=> passed  puzzle33.txt            0            0         
=> passed  puzzle43.txt            0            0         
=> passed  puzzle46.txt            0            0         
=> passed  puzzle40.txt            0            0         
=> passed  puzzle36.txt            0            0         
=> passed  puzzle45.txt            0            0         
==> 25/25 tests passed



Test 4a: Count Board operations (that should get called)

               filename    Board()            equals()         manhattan()
--------------------------------------------------------------------------
=> passed  puzzle20.txt       2289                2279               19593         
=> passed  puzzle22.txt       5549                5543               55223         
=> passed  puzzle21.txt       5619                5611               56779         
=> passed  puzzle23.txt       8445                8437               84891         
=> passed  puzzle24.txt       8683                8673               90319         
=> passed  puzzle25.txt      16416               16408              178407         
=> passed  puzzle27.txt      17947               17939              196755         
=> passed  puzzle29.txt      18711               18703              215665         
=> passed  puzzle26.txt      18990               18984              216419         
=> passed  puzzle28.txt      43202               43192              556059         
=> passed  puzzle30.txt      69148               69142              918633         
=> passed  puzzle31.txt      73809               73801              973639         
=> passed  puzzle39.txt     106459              106451             1330491         
=> passed  puzzle41.txt     166497              166487             2267133         
=> passed  puzzle34.txt     224829              224823             3230903         
=> passed  puzzle37.txt     246893              246885             3510733         
=> passed  puzzle44.txt     398823              398813             5790137         
=> passed  puzzle32.txt     771088              771078            12703027         
=> passed  puzzle35.txt     785712              785702            12448947         
=> passed  puzzle33.txt     921232              921224            15272641         
=> passed  puzzle43.txt    1565635             1565627            25775637         
=> passed  puzzle46.txt    1549058             1549050            25679235         
=> passed  puzzle40.txt    1649907             1649901            27742359         
=> passed  puzzle36.txt    3097813             3097803            56218043         
=> passed  puzzle45.txt    3607829             3607821            63336317         
==> 25/25 tests passed



Test 4b: count Board operations (that should get called),
         rejecting if doesn't adhere to stricter caching limits

               filename    Board()            equals()         manhattan()
--------------------------------------------------------------------------
=> FAILED  puzzle20.txt       2289                2279               19593   (4.9x)
=> FAILED  puzzle22.txt       5549                5543               55223   (5.7x)
=> FAILED  puzzle21.txt       5619                5611               56779   (5.8x)
=> FAILED  puzzle23.txt       8445                8437               84891   (5.7x)
=> FAILED  puzzle24.txt       8683                8673               90319   (5.9x)
=> FAILED  puzzle25.txt      16416               16408              178407   (6.2x)
=> FAILED  puzzle27.txt      17947               17939              196755   (6.3x)
=> FAILED  puzzle29.txt      18711               18703              215665   (6.6x)
=> FAILED  puzzle26.txt      18990               18984              216419   (6.5x)
=> FAILED  puzzle28.txt      43202               43192              556059   (7.4x)
=> FAILED  puzzle30.txt      69148               69142              918633   (7.6x)
=> FAILED  puzzle31.txt      73809               73801              973639   (7.5x)
=> FAILED  puzzle39.txt     106459              106451             1330491   (7.1x)
=> FAILED  puzzle41.txt     166497              166487             2267133   (7.8x)
=> FAILED  puzzle34.txt     224829              224823             3230903   (8.2x)
=> FAILED  puzzle37.txt     246893              246885             3510733   (8.1x)
=> FAILED  puzzle44.txt     398823              398813             5790137   (8.3x)
=> FAILED  puzzle32.txt     771088              771078            12703027   (9.4x)
=> FAILED  puzzle35.txt     785712              785702            12448947   (9.1x)
=> FAILED  puzzle33.txt     921232              921224            15272641   (9.5x)
=> FAILED  puzzle43.txt    1565635             1565627            25775637   (9.4x)
=> FAILED  puzzle46.txt    1549058             1549050            25679235   (9.5x)
=> FAILED  puzzle40.txt    1649907             1649901            27742359   (9.6x)
=> FAILED  puzzle36.txt    3097813             3097803            56218043  (10.4x)
=> FAILED  puzzle45.txt    3607829             3607821            63336317  (10.0x)
==> 0/25 tests passed


Total: 100/125 tests passed!


================================================================
