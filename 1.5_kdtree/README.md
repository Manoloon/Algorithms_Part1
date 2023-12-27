# KD-Tree

*Write a data type to represent a set of points in the unit square (all points have x- and y-coordinates between 0 and 1) using a 2d-tree to support efficient range search (find all of the points contained in a query rectangle) and nearest-neighbor search (find a closest point to a query point). 2d-trees have numerous applications, ranging from classifying astronomical objects to computer animation to speeding up neural networks to mining data to image retrieval. 



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

Correctness:  26/35 tests passed
Memory:       16/16 tests passed
Timing:       42/42 tests passed

Aggregate score: 84.57%
[ Compilation: 5%, API: 5%, Style: 0%, Correctness: 60%, Timing: 10%, Memory: 20% ]



ASSESSMENT DETAILS


The following files were submitted:
----------------------------------
5.7K Dec 27 07:20 KdTree.java
2.3K Dec 27 07:20 PointSET.java


********************************************************************************
*  COMPILING                                                                    
********************************************************************************


% javac PointSET.java
*-----------------------------------------------------------

% javac KdTree.java
*-----------------------------------------------------------


================================================================


Checking the APIs of your programs.
*-----------------------------------------------------------
PointSET:

KdTree:

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

% custom checkstyle checks for PointSET.java
*-----------------------------------------------------------

% custom checkstyle checks for KdTree.java
*-----------------------------------------------------------


================================================================


********************************************************************************
*  TESTING CORRECTNESS
********************************************************************************

Testing correctness of PointSET
*-----------------------------------------------------------
Running 8 total tests.

A point in an m-by-m grid means that it is of the form (i/m, j/m),
where i and j are integers between 0 and m

Test 1: insert n random points; check size() and isEmpty() after each insertion
        (size may be less than n because of duplicates)
  * 5 random points in a 1-by-1 grid
  * 50 random points in a 8-by-8 grid
  * 100 random points in a 16-by-16 grid
  * 1000 random points in a 128-by-128 grid
  * 5000 random points in a 1024-by-1024 grid
  * 50000 random points in a 65536-by-65536 grid
==> passed

Test 2: insert n random points; check contains() with random query points
  * 1 random points in a 1-by-1 grid
  * 10 random points in a 4-by-4 grid
  * 20 random points in a 8-by-8 grid
  * 10000 random points in a 128-by-128 grid
  * 100000 random points in a 1024-by-1024 grid
  * 100000 random points in a 65536-by-65536 grid
==> passed

Test 3: insert random points; check nearest() with random query points
  * 10 random points in a 4-by-4 grid
  * 15 random points in a 8-by-8 grid
  * 20 random points in a 16-by-16 grid
  * 100 random points in a 32-by-32 grid
  * 10000 random points in a 65536-by-65536 grid
==> passed

Test 4: insert random points; check range() with random query rectangles
  * 2 random points and random rectangles in a 2-by-2 grid
  * 10 random points and random rectangles in a 4-by-4 grid
  * 20 random points and random rectangles in a 8-by-8 grid
  * 100 random points and random rectangles in a 16-by-16 grid
  * 1000 random points and random rectangles in a 64-by-64 grid
  * 10000 random points and random rectangles in a 128-by-128 grid
==> passed

Test 5: call methods before inserting any points
 * size() and isEmpty()
 * contains()
 * nearest()
 * range()
==> passed

Test 6: call methods with null argument
  * insert()
  * contains()
  * range()
  * nearest()
==> passed

Test 7: check intermixed sequence of calls to insert(), isEmpty(),
        size(), contains(), range(), and nearest() with
        probabilities (p1, p2, p3, p4, p5, p6, p7), respectively
  * 10000 calls with random points in a 1-by-1 grid
    and probabilities (0.3, 0.1, 0.1, 0.1, 0.2, 0.2)
  * 10000 calls with random points in a 16-by-16 grid
    and probabilities (0.3, 0.1, 0.1, 0.1, 0.2, 0.2)
  * 10000 calls with random points in a 128-by-128 grid
    and probabilities (0.3, 0.1, 0.1, 0.1, 0.2, 0.2)
  * 10000 calls with random points in a 1024-by-1024 grid
    and probabilities (0.3, 0.1, 0.1, 0.1, 0.2, 0.2)
  * 10000 calls with random points in a 8192-by-8192 grid
    and probabilities (0.3, 0.1, 0.1, 0.1, 0.2, 0.2)
  * 10000 calls with random points in a 65536-by-65536 grid
    and probabilities (0.3, 0.1, 0.1, 0.1, 0.2, 0.2)
==> passed

Test 8: check that two PointSET objects can be created at the same time
==> passed


Total: 8/8 tests passed!


================================================================
Testing correctness of KdTree
*-----------------------------------------------------------
Running 27 total tests.

In the tests below, we consider three classes of points and rectangles.

  * Non-degenerate points: no two points (or rectangles) share either an
                           x-coordinate or a y-coordinate

  * Distinct points:       no two points (or rectangles) share both an
                           x-coordinate and a y-coordinate

  * General points:        no restrictions on the x-coordinates or y-coordinates
                           of the points (or rectangles)

A point in an m-by-m grid means that it is of the form (i/m, j/m),
where i and j are integers between 0 and m (inclusive).

Test 1a: insert points from file; check size() and isEmpty() after each insertion
  * input0.txt
  * input1.txt
  * input5.txt
  * input10.txt
  * input25.txt
  * input50.txt
==> passed

Test 1b: insert non-degenerate points; check size() and isEmpty() after each insertion
  * 1 random non-degenerate points in a 1-by-1 grid
  * 5 random non-degenerate points in a 8-by-8 grid
  * 10 random non-degenerate points in a 16-by-16 grid
  * 50 random non-degenerate points in a 128-by-128 grid
  * 500 random non-degenerate points in a 1024-by-1024 grid
  * 50000 random non-degenerate points in a 65536-by-65536 grid
==> passed

Test 1c: insert distinct points; check size() and isEmpty() after each insertion
  * 1 random distinct points in a 1-by-1 grid
  * 10 random distinct points in a 8-by-8 grid
  * 20 random distinct points in a 16-by-16 grid
  * 10000 random distinct points in a 128-by-128 grid
  * 100000 random distinct points in a 1024-by-1024 grid
  * 100000 random distinct points in a 65536-by-65536 grid
==> passed

Test 1d: insert general points; check size() and isEmpty() after each insertion
  * 5 random general points in a 1-by-1 grid
  * 10 random general points in a 4-by-4 grid
  * 50 random general points in a 8-by-8 grid
  * 100000 random general points in a 16-by-16 grid
  * 100000 random general points in a 128-by-128 grid
  * 100000 random general points in a 1024-by-1024 grid
==> passed

Test 2a: insert points from file; check contains() with random query points
  * input0.txt
  * input1.txt
  * input5.txt
  * input10.txt
==> passed

Test 2b: insert non-degenerate points; check contains() with random query points
  * 1 random non-degenerate points in a 1-by-1 grid
  * 5 random non-degenerate points in a 8-by-8 grid
  * 10 random non-degenerate points in a 16-by-16 grid
  * 20 random non-degenerate points in a 32-by-32 grid
  * 500 random non-degenerate points in a 1024-by-1024 grid
  * 10000 random non-degenerate points in a 65536-by-65536 grid
==> passed

Test 2c: insert distinct points; check contains() with random query points
  * 1 random distinct points in a 1-by-1 grid
  * 10 random distinct points in a 4-by-4 grid
  * 20 random distinct points in a 8-by-8 grid
  * 10000 random distinct points in a 128-by-128 grid
  * 100000 random distinct points in a 1024-by-1024 grid
  * 100000 random distinct points in a 65536-by-65536 grid
==> passed

Test 2d: insert general points; check contains() with random query points
  * 10000 random general points in a 1-by-1 grid
  * 10000 random general points in a 16-by-16 grid
  * 10000 random general points in a 128-by-128 grid
  * 10000 random general points in a 1024-by-1024 grid
==> passed

Test 3a: insert points from file; check range() with random query rectangles
  * input0.txt
  * input1.txt
  * input5.txt
  * input10.txt
==> passed

Test 3b: insert non-degenerate points; check range() with random query rectangles
  * 1 random non-degenerate points and random rectangles in a 2-by-2 grid
  * 5 random non-degenerate points and random rectangles in a 8-by-8 grid
  * 10 random non-degenerate points and random rectangles in a 16-by-16 grid
  * 20 random non-degenerate points and random rectangles in a 32-by-32 grid
  * 500 random non-degenerate points and random rectangles in a 1024-by-1024 grid
  * 10000 random non-degenerate points and random rectangles in a 65536-by-65536 grid
==> passed

Test 3c: insert distinct points; check range() with random query rectangles
  * 2 random distinct points and random rectangles in a 2-by-2 grid
  * 10 random distinct points and random rectangles in a 4-by-4 grid
  * 20 random distinct points and random rectangles in a 8-by-8 grid
  * 100 random distinct points and random rectangles in a 16-by-16 grid
  * 1000 random distinct points and random rectangles in a 64-by-64 grid
  * 10000 random distinct points and random rectangles in a 128-by-128 grid
==> passed

Test 3d: insert general points; check range() with random query rectangles
  * 5000 random general points and random rectangles in a 2-by-2 grid
  * 5000 random general points and random rectangles in a 16-by-16 grid
  * 5000 random general points and random rectangles in a 128-by-128 grid
  * 5000 random general points and random rectangles in a 1024-by-1024 grid
==> passed

Test 3e: insert random points; check range() with tiny rectangles
         enclosing each point
  * 5 tiny rectangles and 5 general points in a 2-by-2 grid
  * 10 tiny rectangles and 10 general points in a 4-by-4 grid
  * 20 tiny rectangles and 20 general points in a 8-by-8 grid
  * 5000 tiny rectangles and 5000 general points in a 128-by-128 grid
  * 5000 tiny rectangles and 5000 general points in a 1024-by-1024 grid
  * 5000 tiny rectangles and 5000 general points in a 65536-by-65536 grid
==> passed

Test 4a: insert points from file; check range() with random query rectangles
         and check traversal of k-d tree
  * input5.txt
  * input10.txt
==> passed

Test 4b: insert non-degenerate points; check range() with random query rectangles
         and check traversal of k-d tree
  * 3 random non-degenerate points and 1000 random rectangles in a 4-by-4 grid
  * 6 random non-degenerate points and 1000 random rectangles in a 8-by-8 grid
  * 10 random non-degenerate points and 1000 random rectangles in a 16-by-16 grid
  * 20 random non-degenerate points and 1000 random rectangles in a 32-by-32 grid
  * 30 random non-degenerate points and 1000 random rectangles in a 64-by-64 grid
==> passed

Test 5a: insert points from file; check nearest() with random query points
  * input0.txt
  * input1.txt
  * input5.txt
    - failed on trial 28 of 10000
    - sequence of points inserted: 
      A  0.7 0.2
      B  0.5 0.4
      C  0.2 0.3
      D  0.4 0.7
      E  0.9 0.6
    - query point                   = (0.509, 0.999)
    - student   nearest()           = (0.9, 0.6)
    - reference nearest()           = (0.4, 0.7)
    - student   distanceSquaredTo() = 0.312082
    - reference distanceSquaredTo() = 0.101282

  * input10.txt
    - failed on trial 2 of 10000
    - sequence of points inserted: 
      A  0.372 0.497
      B  0.564 0.413
      C  0.226 0.577
      D  0.144 0.179
      E  0.083 0.51
      F  0.32 0.708
      G  0.417 0.362
      H  0.862 0.825
      I  0.785 0.725
      J  0.499 0.208
    - query point                   = (0.452, 0.06)
    - student   nearest()           = (0.144, 0.179)
    - reference nearest()           = (0.499, 0.208)
    - student   distanceSquaredTo() = 0.109025
    - reference distanceSquaredTo() = 0.024113

==> FAILED

Test 5b: insert non-degenerate points; check nearest() with random query points
  * 5 random non-degenerate points in a 8-by-8 grid
    - failed on trial 2 of 10000
    - sequence of points inserted: 
      A  0.125 0.5
      B  1.0 0.0
      C  0.25 0.25
      D  0.375 0.625
      E  0.5 0.125
    - query point                   = (0.625, 0.875)
    - student   nearest()           = (0.125, 0.5)
    - reference nearest()           = (0.375, 0.625)
    - student   distanceSquaredTo() = 0.390625
    - reference distanceSquaredTo() = 0.125

  * 10 random non-degenerate points in a 16-by-16 grid
    - failed on trial 8 of 10000
    - sequence of points inserted: 
      A  0.6875 0.5
      B  0.5 0.9375
      C  0.5625 0.375
      D  0.625 0.0625
      E  0.0 1.0
      F  0.8125 0.4375
      G  1.0 0.5625
      H  0.25 0.1875
      I  0.125 0.3125
      J  0.875 0.25
    - query point                   = (0.1875, 0.125)
    - student   nearest()           = (0.6875, 0.5)
    - reference nearest()           = (0.25, 0.1875)
    - student   distanceSquaredTo() = 0.390625
    - reference distanceSquaredTo() = 0.0078125

  * 20 random non-degenerate points in a 32-by-32 grid
    - failed on trial 1 of 10000
    - sequence of points inserted: 
      A  0.3125 0.6875
      B  0.875 0.15625
      C  0.09375 0.125
      D  0.75 1.0
      E  0.0625 0.625
      F  0.65625 0.28125
      G  0.5 0.65625
      H  0.03125 0.59375
      I  0.8125 0.40625
      J  1.0 0.0
      K  0.84375 0.84375
      L  0.0 0.46875
      M  0.625 0.8125
      N  0.71875 0.875
      O  0.46875 0.09375
      P  0.4375 0.1875
      Q  0.34375 0.3125
      R  0.78125 0.78125
      S  0.28125 0.03125
      T  0.59375 0.90625
    - query point                   = (0.1875, 0.375)
    - student   nearest()           = (0.09375, 0.125)
    - reference nearest()           = (0.34375, 0.3125)
    - student   distanceSquaredTo() = 0.0712890625
    - reference distanceSquaredTo() = 0.0283203125

  * 30 random non-degenerate points in a 64-by-64 grid
    - failed on trial 1 of 10000
    - query point                   = (0.640625, 0.234375)
    - student   nearest()           = (0.359375, 0.5625)
    - reference nearest()           = (0.65625, 0.296875)
    - student   distanceSquaredTo() = 0.186767578125
    - reference distanceSquaredTo() = 0.004150390625

  * 10000 random non-degenerate points in a 65536-by-65536 grid
    - failed on trial 1 of 10000
    - query point                   = (0.205230712890625, 0.8558807373046875)
    - student   nearest()           = (0.270965576171875, 0.99176025390625)
    - reference nearest()           = (0.2051544189453125, 0.8592376708984375)
    - student   distanceSquaredTo() = 0.022784315282479
    - reference distanceSquaredTo() = 0.000011274823919

==> FAILED

Test 5c: insert distinct points; check nearest() with random query points
  * 10 random distinct points in a 4-by-4 grid
    - failed on trial 1 of 10000
    - sequence of points inserted: 
      A  0.25 0.0
      B  0.0 1.0
      C  0.75 0.5
      D  0.25 0.75
      E  0.5 0.75
      F  0.5 1.0
      G  0.25 1.0
      H  0.0 0.75
      I  0.0 0.5
      J  0.5 0.0
    - query point                   = (0.0, 0.25)
    - student   nearest()           = (0.25, 0.0)
    - reference nearest()           = (0.0, 0.5)
    - student   distanceSquaredTo() = 0.125
    - reference distanceSquaredTo() = 0.0625

  * 15 random distinct points in a 8-by-8 grid
    - failed on trial 5 of 10000
    - sequence of points inserted: 
      A  0.75 0.25
      B  0.25 0.25
      C  1.0 1.0
      D  0.0 0.375
      E  0.5 0.875
      F  0.625 0.0
      G  0.625 0.375
      H  0.5 1.0
      I  0.5 0.0
      J  0.125 1.0
      K  0.875 0.625
      L  0.0 0.0
      M  0.75 1.0
      N  0.25 0.625
      O  0.125 0.75
    - query point                   = (0.375, 0.5)
    - student   nearest()           = (0.25, 0.25)
    - reference nearest()           = (0.25, 0.625)
    - student   distanceSquaredTo() = 0.078125
    - reference distanceSquaredTo() = 0.03125

  * 20 random distinct points in a 16-by-16 grid
    - failed on trial 4 of 10000
    - sequence of points inserted: 
      A  0.875 0.625
      B  0.25 0.375
      C  0.375 0.875
      D  0.3125 0.75
      E  0.3125 0.875
      F  1.0 0.3125
      G  0.25 1.0
      H  0.5 0.3125
      I  0.4375 0.8125
      J  0.5 0.5625
      K  0.75 0.625
      L  0.1875 0.6875
      M  0.0625 0.5
      N  0.5 0.6875
      O  0.5 0.375
      P  0.9375 0.125
      Q  1.0 0.0625
      R  0.5 0.0625
      S  1.0 0.875
      T  0.4375 0.3125
    - query point                   = (0.0, 0.375)
    - student   nearest()           = (0.25, 0.375)
    - reference nearest()           = (0.0625, 0.5)
    - student   distanceSquaredTo() = 0.0625
    - reference distanceSquaredTo() = 0.01953125

  * 100 random distinct points in a 32-by-32 grid
    - failed on trial 1 of 10000
    - query point                   = (0.40625, 0.875)
    - student   nearest()           = (0.09375, 0.8125)
    - reference nearest()           = (0.40625, 0.84375)
    - student   distanceSquaredTo() = 0.1015625
    - reference distanceSquaredTo() = 0.0009765625

  * 10000 random distinct points in a 65536-by-65536 grid
    - failed on trial 1 of 10000
    - query point                   = (0.747528076171875, 0.5792236328125)
    - student   nearest()           = (0.4565277099609375, 0.6158905029296875)
    - reference nearest()           = (0.74835205078125, 0.5811767578125)
    - student   distanceSquaredTo() = 0.08602567249909
    - reference distanceSquaredTo() = 0.000004493631423

==> FAILED

Test 5d: insert general points; check nearest() with random query points
  * 10000 random general points in a 16-by-16 grid
    - failed on trial 1 of 10000
    - query point                   = (0.1875, 0.8125)
    - student   nearest()           = (0.5625, 0.8125)
    - reference nearest()           = (0.1875, 0.8125)
    - student   distanceSquaredTo() = 0.140625
    - reference distanceSquaredTo() = 0

  * 10000 random general points in a 128-by-128 grid
    - failed on trial 1 of 10000
    - query point                   = (1.0, 0.046875)
    - student   nearest()           = (0.609375, 0.0546875)
    - reference nearest()           = (1.0, 0.0390625)
    - student   distanceSquaredTo() = 0.15264892578125
    - reference distanceSquaredTo() = 0.00006103515625

  * 10000 random general points in a 1024-by-1024 grid
    - failed on trial 1 of 10000
    - query point                   = (0.9619140625, 0.525390625)
    - student   nearest()           = (0.9453125, 0.4462890625)
    - reference nearest()           = (0.95703125, 0.53125)
    - student   distanceSquaredTo() = 0.006532669067383
    - reference distanceSquaredTo() = 0.000058174133301

==> FAILED

Test 6a: insert points from file; check nearest() with random query points
         and check traversal of k-d tree
  * input5.txt
    - student   nearest() = (0.9, 0.6)
    - reference nearest() = (0.9, 0.6)
    - performs incorrect traversal of k-d tree during call to nearest()
    - query point = (0.72, 0.68)
    - sequence of points inserted: 
      A  0.7 0.2
      B  0.5 0.4
      C  0.2 0.3
      D  0.4 0.7
      E  0.9 0.6
    - student sequence of k-d tree nodes involved in calls to Point2D methods:
      A B C D E 
    - reference sequence of k-d tree nodes involved in calls to Point2D methods:
      A E B D 
    - failed on trial 1 of 1000

  * input10.txt
    - student   nearest() = (0.564, 0.413)
    - reference nearest() = (0.499, 0.208)
    - student   distanceSquaredTo() = 0.174205
    - reference distanceSquaredTo() = 0.098405
    - performs incorrect traversal of k-d tree during call to nearest()
    - query point = (0.77, 0.05)
    - sequence of points inserted: 
      A  0.372 0.497
      B  0.564 0.413
      C  0.226 0.577
      D  0.144 0.179
      E  0.083 0.51
      F  0.32 0.708
      G  0.417 0.362
      H  0.862 0.825
      I  0.785 0.725
      J  0.499 0.208
    - student sequence of k-d tree nodes involved in calls to Point2D methods:
      A C F D B H I G 
    - reference sequence of k-d tree nodes involved in calls to Point2D methods:
      A B G J 
    - failed on trial 1 of 1000

==> FAILED

Test 6b: insert non-degenerate points; check nearest() with random query points
         and check traversal of k-d tree
  * 5 random non-degenerate points in a 8-by-8 grid
    - student   nearest() = (1.0, 0.5)
    - reference nearest() = (0.375, 0.25)
    - student   distanceSquaredTo() = 0.3125
    - reference distanceSquaredTo() = 0.203125
    - performs incorrect traversal of k-d tree during call to nearest()
    - query point = (0.75, 0.0)
    - sequence of points inserted: 
      A  1.0 0.5
      B  0.125 0.125
      C  0.375 0.25
      D  0.625 0.875
      E  0.5 1.0
    - student sequence of k-d tree nodes involved in calls to Point2D methods:
      A B 
    - reference sequence of k-d tree nodes involved in calls to Point2D methods:
      A B C D 
    - failed on trial 1 of 1000

  * 10 random non-degenerate points in a 16-by-16 grid
    - student   nearest() = (0.3125, 0.25)
    - reference nearest() = (0.3125, 0.25)
    - performs incorrect traversal of k-d tree during call to nearest()
    - query point = (0.5, 0.3125)
    - sequence of points inserted: 
      A  0.1875 0.125
      B  0.3125 0.25
      C  0.5625 0.75
      D  0.8125 0.375
      E  0.0625 0.0625
      F  0.625 0.6875
      G  0.0 0.4375
      H  0.375 0.9375
      I  1.0 0.5
      J  0.25 0.1875
    - student sequence of k-d tree nodes involved in calls to Point2D methods:
      A E G B J C 
    - reference sequence of k-d tree nodes involved in calls to Point2D methods:
      A B C H D F I J 
    - failed on trial 1 of 1000

  * 20 random non-degenerate points in a 32-by-32 grid
    - student   nearest() = (0.71875, 0.59375)
    - reference nearest() = (0.3125, 0.53125)
    - student   distanceSquaredTo() = 0.2265625
    - reference distanceSquaredTo() = 0.0166015625
    - performs incorrect traversal of k-d tree during call to nearest()
    - query point = (0.28125, 0.40625)
    - sequence of points inserted: 
      A  0.71875 0.59375
      B  0.59375 0.03125
      C  0.5 0.96875
      D  0.90625 0.84375
      E  0.9375 0.375
      F  0.3125 0.53125
      G  0.0625 0.65625
      H  0.1875 0.3125
      I  0.375 0.8125
      J  0.03125 0.34375
      K  0.875 0.4375
      L  0.84375 0.0625
      M  0.8125 0.5
      N  0.53125 0.09375
      O  0.09375 0.625
      P  0.625 0.28125
      Q  0.75 1.0
      R  0.34375 0.1875
      S  0.65625 0.9375
      T  0.6875 0.125
    - student sequence of k-d tree nodes involved in calls to Point2D methods:
      A D Q E B 
    - reference sequence of k-d tree nodes involved in calls to Point2D methods:
      A B C F H R J G I O 
    - failed on trial 1 of 1000

  * 30 random non-degenerate points in a 64-by-64 grid
    - student   nearest() = (0.578125, 0.625)
    - reference nearest() = (0.578125, 0.625)
    - performs incorrect traversal of k-d tree during call to nearest()
    - number of student   entries = 11
    - number of reference entries = 12
    - entry 1 of the two sequences are not equal
    - student   entry 1 = (0.703125, 0.71875)
    - reference entry 1 = (0.421875, 0.140625)

    - failed on trial 1 of 1000

  * 50 random non-degenerate points in a 128-by-128 grid
    - student   nearest() = (0.1328125, 0.25)
    - reference nearest() = (0.0234375, 0.5234375)
    - student   distanceSquaredTo() = 0.0338134765625
    - reference distanceSquaredTo() = 0.01373291015625
    - performs incorrect traversal of k-d tree during call to nearest()
    - number of student   entries = 14
    - number of reference entries = 10
    - entry 1 of the two sequences are not equal
    - student   entry 1 = (0.609375, 0.6328125)
    - reference entry 1 = (0.1796875, 0.2578125)

    - failed on trial 1 of 1000

  * 1000 random non-degenerate points in a 2048-by-2048 grid
    - student   nearest() = (0.890625, 0.11279296875)
    - reference nearest() = (0.60400390625, 0.1455078125)
    - student   distanceSquaredTo() = 0.080390930175781
    - reference distanceSquaredTo() = 0.000313282012939
    - performs incorrect traversal of k-d tree during call to nearest()
    - number of student   entries = 6
    - number of reference entries = 17
    - entry 1 of the two sequences are not equal
    - student   entry 1 = (0.90087890625, 0.5712890625)
    - reference entry 1 = (0.41162109375, 0.95166015625)

    - failed on trial 1 of 1000

==> FAILED

Test 7: check with no points
  * size() and isEmpty()
  * contains()
  * nearest()
  * range()
==> passed

Test 8: check that the specified exception is thrown with null arguments
  * argument to insert() is null
  * argument to contains() is null
  * argument to range() is null
  * argument to nearest() is null
==> passed

Test 9a: check intermixed sequence of calls to insert(), isEmpty(),
         size(), contains(), range(), and nearest() with probabilities
         (p1, p2, p3, p4, p5, p6), respectively
  * 20000 calls with non-degenerate points in a 1-by-1 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with non-degenerate points in a 16-by-16 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with non-degenerate points in a 128-by-128 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 34 of 20000
    - student   nearest()  = (0.171875, 0.515625)
    - reference nearest()  = (0.390625, 0.5546875)
    - student   distanceSquaredTo() = 0.08184814453125
    - reference distanceSquaredTo() = 0.04150390625

  * 20000 calls with non-degenerate points in a 1024-by-1024 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 14 of 20000
    - student   nearest()  = (0.8974609375, 0.49609375)
    - reference nearest()  = (0.1279296875, 0.6611328125)
    - student   distanceSquaredTo() = 0.381122589111328
    - reference distanceSquaredTo() = 0.188157081604004
    - sequence of operations was:
           st.insert(0.646484375, 0.21484375)
           st.contains((0.7529296875, 0.931640625))  ==>  false
           st.insert(0.982421875, 0.26953125)
           st.nearest((0.7861328125, 0.982421875))   ==>  (0.982421875, 0.26953125)
           st.insert(0.2744140625, 0.11328125)
           st.range([0.826171875, 0.9736328125] x [0.287109375, 0.462890625])  ==>  empty
           st.nearest((0.3056640625, 0.2841796875))   ==>  (0.2744140625, 0.11328125)
           st.contains((0.74609375, 0.623046875))  ==>  false
           st.insert(0.3466796875, 0.0)
           st.insert(0.1279296875, 0.6611328125)
           st.insert(0.8974609375, 0.49609375)
           st.contains((0.8466796875, 0.091796875))  ==>  false
           st.insert(0.197265625, 0.5400390625)
           st.nearest((0.4638671875, 0.935546875))   ==>  (0.8974609375, 0.49609375)

  * 20000 calls with non-degenerate points in a 8192-by-8192 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 13 of 20000
    - student   nearest()  = (0.1741943359375, 0.413330078125)
    - reference nearest()  = (0.5775146484375, 0.538818359375)
    - student   distanceSquaredTo() = 0.065888464450836
    - reference distanceSquaredTo() = 0.027805864810944
    - sequence of operations was:
           st.size()  ==>  0
           st.size()  ==>  0
           st.isEmpty()  ==>  true
           st.insert(0.1741943359375, 0.413330078125)
           st.insert(0.867431640625, 0.7784423828125)
           st.range([0.1092529296875, 0.82861328125] x [0.3050537109375, 0.9678955078125])  ==>  S 
           st.contains((0.810302734375, 0.85986328125))  ==>  false
           st.nearest((0.9747314453125, 0.375))   ==>  (0.867431640625, 0.7784423828125)
           st.nearest((0.052001953125, 0.4093017578125))   ==>  (0.1741943359375, 0.413330078125)
           st.insert(0.5775146484375, 0.538818359375)
           st.range([0.2662353515625, 0.8582763671875] x [0.6273193359375, 0.628173828125])  ==>  empty
           st.contains((0.54296875, 0.2344970703125))  ==>  false
           st.nearest((0.4232177734375, 0.4755859375))   ==>  (0.1741943359375, 0.413330078125)

  * 20000 calls with non-degenerate points in a 65536-by-65536 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 51 of 20000
    - student   nearest()  = (0.5821075439453125, 0.0062408447265625)
    - reference nearest()  = (0.006561279296875, 0.2963409423828125)
    - student   distanceSquaredTo() = 0.150904577691108
    - reference distanceSquaredTo() = 0.091621225932613

==> FAILED

Test 9b: check intermixed sequence of calls to insert(), isEmpty(),
         size(), contains(), range(), and nearest() with probabilities
         (p1, p2, p3, p4, p5, p6), respectively
  * 20000 calls with distinct points in a 1-by-1 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
  * 20000 calls with distinct points in a 16-by-16 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 31 of 20000
    - student   nearest()  = (0.5625, 0.3125)
    - reference nearest()  = (0.625, 0.5625)
    - student   distanceSquaredTo() = 0.125
    - reference distanceSquaredTo() = 0.09765625

  * 20000 calls with distinct points in a 128-by-128 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 29 of 20000
    - student   nearest()  = (0.0625, 0.8828125)
    - reference nearest()  = (0.3984375, 0.7578125)
    - student   distanceSquaredTo() = 0.21636962890625
    - reference distanceSquaredTo() = 0.01953125

  * 20000 calls with distinct points in a 1024-by-1024 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 29 of 20000
    - student   nearest()  = (0.5830078125, 0.6689453125)
    - reference nearest()  = (0.7060546875, 0.6962890625)
    - student   distanceSquaredTo() = 0.098331451416016
    - reference distanceSquaredTo() = 0.046607971191406

  * 20000 calls with distinct points in a 8192-by-8192 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 15 of 20000
    - student   nearest()  = (0.1436767578125, 0.84375)
    - reference nearest()  = (0.73193359375, 0.7987060546875)
    - student   distanceSquaredTo() = 0.501623302698135
    - reference distanceSquaredTo() = 0.014804661273956
    - sequence of operations was:
           st.insert(0.1436767578125, 0.84375)
           st.insert(0.17919921875, 0.228759765625)
           st.insert(0.73193359375, 0.7987060546875)
           st.contains((0.8577880859375, 0.927490234375))  ==>  false
           st.isEmpty()  ==>  false
           st.insert(0.0078125, 0.619140625)
           st.size()  ==>  4
           st.insert(0.3519287109375, 0.524658203125)
           st.contains((0.879638671875, 0.0562744140625))  ==>  false
           st.insert(0.50732421875, 0.1826171875)
           st.contains((0.4808349609375, 0.9700927734375))  ==>  false
           st.isEmpty()  ==>  false
           st.contains((0.1400146484375, 0.9189453125))  ==>  false
           st.insert(0.989501953125, 0.629150390625)
           st.nearest((0.8515625, 0.8209228515625))   ==>  (0.1436767578125, 0.84375)

  * 20000 calls with distinct points in a 65536-by-65536 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 15 of 20000
    - student   nearest()  = (0.97943115234375, 0.2326507568359375)
    - reference nearest()  = (0.8639984130859375, 0.3039703369140625)
    - student   distanceSquaredTo() = 0.110006735194474
    - reference distanceSquaredTo() = 0.091374476673082
    - sequence of operations was:
           st.insert(0.97943115234375, 0.2326507568359375)
           st.contains((0.103057861328125, 0.3806915283203125))  ==>  false
           st.insert(0.1558074951171875, 0.61883544921875)
           st.insert(0.853729248046875, 0.9870147705078125)
           st.contains((0.4185638427734375, 0.5080413818359375))  ==>  false
           st.insert(0.3521575927734375, 0.8995819091796875)
           st.contains((0.8423919677734375, 0.382843017578125))  ==>  false
           st.contains((0.594451904296875, 0.7233123779296875))  ==>  false
           st.insert(0.8639984130859375, 0.3039703369140625)
           st.contains((0.0864105224609375, 0.6759033203125))  ==>  false
           st.contains((0.9606170654296875, 0.0964508056640625))  ==>  false
           st.isEmpty()  ==>  false
           st.range([0.1161041259765625, 0.4664764404296875] x [0.08251953125, 0.5524444580078125])  ==>  empty
           st.insert(0.4716033935546875, 0.342132568359375)
           st.nearest((0.7044219970703125, 0.0472412109375))   ==>  (0.97943115234375, 0.2326507568359375)

==> FAILED

Test 9c: check intermixed sequence of calls to insert(), isEmpty(),
         size(), contains(), range(), and nearest() with probabilities
         (p1, p2, p3, p4, p5, p6), respectively
  * 20000 calls with general points in a 1-by-1 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 30 of 20000
    - student   nearest()  = (0.0, 0.0)
    - reference nearest()  = (0.0, 1.0)
    - student   distanceSquaredTo() = 1
    - reference distanceSquaredTo() = 0

  * 20000 calls with general points in a 16-by-16 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 46 of 20000
    - student   nearest()  = (0.5, 0.5625)
    - reference nearest()  = (0.875, 0.75)
    - student   distanceSquaredTo() = 0.1953125
    - reference distanceSquaredTo() = 0.01953125

  * 20000 calls with general points in a 128-by-128 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 19 of 20000
    - student   nearest()  = (0.875, 0.2265625)
    - reference nearest()  = (0.53125, 0.8671875)
    - student   distanceSquaredTo() = 0.396728515625
    - reference distanceSquaredTo() = 0.07080078125
    - sequence of operations was:
           st.size()  ==>  0
           st.insert(0.875, 0.2265625)
           st.insert(0.1875, 0.453125)
           st.isEmpty()  ==>  false
           st.contains((0.1015625, 0.7578125))  ==>  false
           st.nearest((0.75, 0.1875))   ==>  (0.875, 0.2265625)
           st.isEmpty()  ==>  false
           st.insert(0.2578125, 0.2109375)
           st.insert(0.109375, 0.75)
           st.contains((0.0234375, 0.7578125))  ==>  false
           st.contains((0.6875, 0.4140625))  ==>  false
           st.nearest((0.75, 0.328125))   ==>  (0.875, 0.2265625)
           st.contains((0.09375, 0.3046875))  ==>  false
           st.insert(0.484375, 0.125)
           st.range([0.3203125, 0.8203125] x [0.109375, 0.125])  ==>  R 
           st.range([0.1171875, 0.5625] x [0.3203125, 0.9453125])  ==>  Q 
           st.contains((0.0625, 0.5390625))  ==>  false
           st.insert(0.53125, 0.8671875)
           st.nearest((0.796875, 0.8515625))   ==>  (0.875, 0.2265625)

  * 20000 calls with general points in a 1024-by-1024 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 34 of 20000
    - student   nearest()  = (0.12109375, 0.2412109375)
    - reference nearest()  = (0.396484375, 0.1123046875)
    - student   distanceSquaredTo() = 0.133564949035645
    - reference distanceSquaredTo() = 0.004315376281738

  * 20000 calls with general points in a 8192-by-8192 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 20 of 20000
    - student   nearest()  = (0.79248046875, 0.45361328125)
    - reference nearest()  = (0.318603515625, 0.043212890625)
    - student   distanceSquaredTo() = 0.264838173985481
    - reference distanceSquaredTo() = 0.014146938920021
    - sequence of operations was:
           st.insert(0.79248046875, 0.45361328125)
           st.range([0.1539306640625, 0.166748046875] x [0.055908203125, 0.3187255859375])  ==>  empty
           st.nearest((0.401123046875, 0.1595458984375))   ==>  (0.79248046875, 0.45361328125)
           st.nearest((0.1405029296875, 0.16357421875))   ==>  (0.79248046875, 0.45361328125)
           st.insert(0.2818603515625, 0.77880859375)
           st.size()  ==>  2
           st.range([0.7066650390625, 0.7396240234375] x [3.662109375E-4, 0.694580078125])  ==>  empty
           st.contains((0.8292236328125, 0.7349853515625))  ==>  false
           st.insert(0.318603515625, 0.043212890625)
           st.range([0.3692626953125, 0.5223388671875] x [0.1737060546875, 0.58935546875])  ==>  empty
           st.insert(0.3536376953125, 0.897705078125)
           st.insert(0.6612548828125, 0.8773193359375)
           st.insert(0.328369140625, 0.993896484375)
           st.contains((0.939208984375, 0.776123046875))  ==>  false
           st.nearest((0.04296875, 0.27197265625))   ==>  (0.318603515625, 0.043212890625)
           st.contains((0.071533203125, 0.6201171875))  ==>  false
           st.range([0.5035400390625, 0.515380859375] x [0.67333984375, 0.7591552734375])  ==>  empty
           st.insert(0.9307861328125, 0.146484375)
           st.insert(0.24462890625, 0.62841796875)
           st.nearest((0.381103515625, 0.1444091796875))   ==>  (0.79248046875, 0.45361328125)

  * 20000 calls with general points in a 65536-by-65536 grid
    and probabilities (0.3, 0.05, 0.05, 0.2, 0.2, 0.2)
    - failed on trial 34 of 20000
    - student   nearest()  = (0.1590728759765625, 0.22088623046875)
    - reference nearest()  = (0.4942626953125, 0.2619476318359375)
    - student   distanceSquaredTo() = 0.091283822897822
    - reference distanceSquaredTo() = 0.005149682052433

==> FAILED

Test 10: insert n random points into two different KdTree objects;
        check that repeated calls to size(), contains(), range(),
        and nearest() with the same arguments yield same results
  * 10 random general points in a 4-by-4 grid
  * 20 random general points in a 8-by-8 grid
  * 100 random general points in a 128-by-128 grid
  * 1000 random general points in a 65536-by-65536 grid
==> passed


Total: 18/27 tests passed!


================================================================
********************************************************************************
*  MEMORY
********************************************************************************

Analyzing memory of Point2D
*-----------------------------------------------------------
Memory of Point2D object = 32 bytes

================================================================



Analyzing memory of RectHV
*-----------------------------------------------------------
Memory of RectHV object = 48 bytes

================================================================



Analyzing memory of PointSET
*-----------------------------------------------------------
Running 8 total tests.

Memory usage of a PointSET with n points (including Point2D and RectHV objects).
Maximum allowed memory is 96n + 200 bytes.

                 n       student (bytes)    reference (bytes)
--------------------------------------------------------------
=> passed        1          264                264
=> passed        2          360                360
=> passed        5          648                648
=> passed       10         1128               1128
=> passed       25         2568               2568
=> passed      100         9768               9768
=> passed      400        38568              38568
=> passed      800        76968              76968
==> 8/8 tests passed

Total: 8/8 tests passed!

Estimated student   memory (bytes) = 96.00 n + 168.00  (R^2 = 1.000)
Estimated reference memory (bytes) = 96.00 n + 168.00  (R^2 = 1.000)

================================================================



Analyzing memory of KdTree
*-----------------------------------------------------------
Running 8 total tests.

Memory usage of a KdTree with n points (including Point2D and RectHV objects).
Maximum allowed memory is 312n + 192 bytes.

                 n       student (bytes)    reference (bytes)
--------------------------------------------------------------
=> passed        1          112                160
=> passed        2          192                288
=> passed        5          432                672
=> passed       10          832               1312
=> passed       25         2032               3232
=> passed      100         8032              12832
=> passed      400        32032              51232
=> passed      800        64032             102432
==> 8/8 tests passed

Total: 8/8 tests passed!

Estimated student   memory (bytes) = 80.00 n + 32.00  (R^2 = 1.000)
Estimated reference memory (bytes) = 128.00 n + 32.00  (R^2 = 1.000)

================================================================



********************************************************************************
*  TIMING
********************************************************************************

Timing PointSET
*-----------------------------------------------------------
Running 14 total tests.


Inserting n points into a PointSET

               n      ops per second
----------------------------------------
=> passed   160000    1817424         
=> passed   320000    1777773         
=> passed   640000    1474660         
=> passed  1280000    1095558         
==> 4/4 tests passed

Performing contains() queries after inserting n points into a PointSET

               n      ops per second
----------------------------------------
=> passed   160000     687503         
=> passed   320000     610509         
=> passed   640000     595337         
=> passed  1280000     473745         
==> 4/4 tests passed

Performing range() queries after inserting n points into a PointSET

               n      ops per second
----------------------------------------
=> passed    10000       4497         
=> passed    20000       1663         
=> passed    40000        741         
==> 3/3 tests passed

Performing nearest() queries after inserting n points into a PointSET

               n      ops per second
----------------------------------------
=> passed    10000       7089         
=> passed    20000       2110         
=> passed    40000        889         
==> 3/3 tests passed

Total: 14/14 tests passed!


================================================================



Timing KdTree
*-----------------------------------------------------------
Running 28 total tests.


Test 1a-d: Insert n points into a 2d tree. The table gives the average number of calls
           to methods in RectHV and Point per call to insert().

                                                                                                Point2D
               n      ops per second       RectHV()           x()               y()             equals()
----------------------------------------------------------------------------------------------------------------
=> passed   160000    1632829               0.0              43.3              43.3              21.6         
=> passed   320000    1542468               0.0              44.1              44.1              22.0         
=> passed   640000    1184379               0.0              47.1              47.1              23.5         
=> passed  1280000     933620               0.0              51.3              51.3              25.6         
==> 4/4 tests passed


Test 2a-h: Perform contains() queries after inserting n points into a 2d tree. The table gives
           the average number of calls to methods in RectHV and Point per call to contains().

                                                                               Point2D
               n      ops per second       x()               y()               equals()
-----------------------------------------------------------------------------------------------
=> passed    10000     886360              18.5              17.5              18.0         
=> passed    20000     896702              19.7              18.7              19.2         
=> passed    40000     832046              21.8              20.8              21.3         
=> passed    80000     765004              22.0              21.0              21.5         
=> passed   160000     666076              23.2              22.2              22.7         
=> passed   320000     610184              25.0              24.0              24.5         
=> passed   640000     489616              25.7              24.7              25.2         
=> passed  1280000     442613              27.2              26.2              26.7         
==> 8/8 tests passed


Test 3a-h: Perform range() queries after inserting n points into a 2d tree. The table gives
           the average number of calls to methods in RectHV and Point per call to range().

               n      ops per second       intersects()      contains()        x()               y()
---------------------------------------------------------------------------------------------------------------
=> passed    10000     484150               0.0              31.1              81.9              42.5         
=> passed    20000     513500               0.0              32.6              85.9              48.8         
=> passed    40000     420144               0.0              39.3             103.2              52.7         
=> passed    80000     383232               0.0              40.7             106.5              55.0         
=> passed   160000     334161               0.0              42.5             113.1              63.2         
=> passed   320000     323011               0.0              40.2             105.7              55.7         
=> passed   640000     214595               0.0              43.3             113.8              62.6         
=> passed  1280000     184351               0.0              47.0             123.0              60.1         
==> 8/8 tests passed


Test 4a-h: Perform nearest() queries after inserting n points into a 2d tree. The table gives
           the average number of calls to methods in RectHV and Point per call to nearest().

                                         Point2D                 RectHV
               n      ops per second     distanceSquaredTo()     distanceSquaredTo()        x()               y()
------------------------------------------------------------------------------------------------------------------------
=> passed    10000   701098                 106.7                    0.0                    27.6              26.7         
=> passed    20000   782241                  97.3                    0.0                    25.4              24.4         
=> passed    40000   783702                  99.1                    0.0                    25.6              24.7         
=> passed    80000   836510                  83.9                    0.0                    21.8              21.3         
=> passed   160000   784140                  98.0                    0.0                    24.9              24.9         
=> passed   320000   711271                 124.5                    0.0                    31.2              31.0         
=> passed   640000   678137                 147.4                    0.0                    37.4              36.1         
=> passed  1280000   722136                 124.2                    0.0                    31.2              30.8         
==> 8/8 tests passed



Total: 28/28 tests passed!


================================================================