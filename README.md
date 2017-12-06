# Java_DS_lab3_MatrixMultiplication
Lab 3 Matrix Multiplication
Assignment 3 - Timing Matrix Multiplication
Parts A is required.  Part B is optional and is worth four points extra credit (but must be submitted in addition to, and along with, Part A).  Make sure you have read and understood

both modules A and B this week, and
module 2R - Lab Homework Requirements
before submitting this assignment. Hand in only one program, please. 

Part A (required) - A Simple Array Implementation for Large Matrices
We already know how to allocate and work with 2-D arrays (matrices) from our CS 1B (CIS 27B) class.  For example, here we allocate two double matrices:

      // non-sparse matrices
      double[][] mat, matAns;

      mat = new double[MAT_SIZE][MAT_SIZE];
      matAns = new double[MAT_SIZE][MAT_SIZE];
Look up matrix multiplication on the web or in a math book.  It is a very simple and short formula, but it's good for you to find on your own.  Create a static method in your main class that takes two input matrices, and the third a return (reference) product matrix:

   public static void matMult( double[][] matA,  double[][] matB, 
         double[][] matC)
To keep things simple, we'll assume all matrices are square, but we should check that the first rows of each matrix are the same size.  If they are, we'll assume all is well (and let Java throw exceptions if the client passed bad matrices).  After reading the definition of matrix multiplication, but before implementing it, determine, using the tools you have learned, the time complexity of this operation relative to M.  You should be able to get both a tight O() upper bound as well as a Θ() estimate for multiplying two MxM matrices together.  Put this into writing to be handed in, along with your reasoning at the bottom of your assignment.  Next, write the function for matMult().  Also, for comparison, write a display method for these dynamic matrices like you did for sparse matrices last week:  one that shows a square sub-matrix of size = size anchored at position (start, start):

   public static void matShow(double[][] matA, int start, int size
This week we're making it a static function, so it must take the matrix as a parameter. 

Now that we have our tools, we can time matrix multiplication (and examine small portions of the answers).  Our game will be to generate a semi-sparse matrix (between 1% and 25% of the size of the matrix, non-zero) and then "square" the matrix (multiply it by itself) using matrix multiplication.  We'll show a small 10x10 square sub-portion of the matrix, and then that same portion of the squared matrix.
