/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.Queue;

import java.util.ArrayList;

public class Board {
    private int[] board;
    private int width;
    private int offset = 1;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        if (tiles == null) throw new java.lang.IllegalArgumentException();

        if (tiles.length != tiles[0].length) throw new java.lang.IllegalArgumentException();

        width = tiles.length;
        board = new int[width * width];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < tiles[0].length; j++) {
                board[xyTo1D(i, j)] = tiles[i][j];
            }
        }
    }

    // string representation of this board
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(" " + width + "\n");

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                str.append(String.format("%2d ", board[xyTo1D(i, j)]));
            }
            str.append("\n");
        }
        return str.toString();
    }

    // board dimension n
    public int dimension() {
        return width;
    }

    // number of tiles out of place
    public int hamming() {
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i] != i + offset && board[i] != 0) {
                result++;
            }
        }
        return result;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int result = 0;
        for (int i = 0; i < width; i++) {
            if (board[i] != i + offset && board[i] != 0) {
                int x1 = xyFrom1D(i)[0];
                int y1 = xyFrom1D(i)[1];
                int x2 = xyFrom1D(board[i] - offset)[0];
                int y2 = xyFrom1D(board[i] - offset)[1];
                result += (Math.abs(x1 - x2) + Math.abs(y1 - y2));
            }
        }
        return result;
    }

    // is this board the goal board?
    public boolean isGoal() {
        for (int i = 0; i < width - offset; i++) {
            if (board[i] != i + 1) return false;
        }
        return true;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board other = (Board) y;
        if (other.dimension() != this.dimension()) return false;
        for (int i = 0; i < this.width; i++) {
            if (this.board[i] != other.board[i]) return false;
        }
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Queue<Board> neighbors = new Queue<Board>();
        int index = 0;
        int row, col = 0;
        ArrayList<Integer> tiles = new ArrayList<Integer>();
        for (index = 0; index < board.length; index++) {
            if (board[index] == 0) {
                col = xyFrom1D(index)[0];
                row = xyFrom1D(index)[1];
                // up
                if (checkBounds(row - 1, col)) tiles.add(xyTo1D(row - 1, col));
                // right
                if (checkBounds(row, col + 1)) tiles.add(xyTo1D(row, col + 1));
                // down
                if (checkBounds(row + 1, col)) tiles.add(xyTo1D(row + 1, col));
                // left
                if (checkBounds(row, col - 1)) tiles.add(xyTo1D(row, col - 1));
                break;
            }
        }
        for (int i = 0; i < tiles.size(); i++) {
            int[] temp1D = copy1DTo1D(board);
            swap1D(temp1D, index, tiles.get(i));
            int[][] temp2D = copy1DTo2D(temp1D, this.width);
            neighbors.enqueue(new Board(temp2D));
        }
        return neighbors;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int col, row, dir = 0;
        int[] twin1D = new int[width];
        // make copy board to 1D
        for (int i = 0; i < width; i++) {
            twin1D[i] = board[i];
        }
        for (int i = 0; i < twin1D.length; i++) {
            if (twin1D[i] != 0) {
                col = xyFrom1D(i)[0];
                row = xyFrom1D(i)[1];
                // up
                if (checkBounds(row - 1, col)) {
                    dir = xyTo1D(row - 1, col);
                    if (twin1D[dir] != 0) {
                        swap1D(twin1D, i, dir);
                        break;
                    }
                }
                // right
                if (checkBounds(row, col + 1)) {
                    dir = xyTo1D(row, col + 1);
                    if (twin1D[dir] != 0) {
                        swap1D(twin1D, i, dir);
                        break;
                    }
                }
                // down
                if (checkBounds(row + 1, col)) {
                    dir = xyTo1D(row + 1, col);
                    if (twin1D[dir] != 0) {
                        swap1D(twin1D, i, dir);
                        break;
                    }
                }
                // left
                if (checkBounds(row, col - 1)) {
                    dir = xyTo1D(row, col - 1);
                    if (twin1D[dir] != 0) {
                        swap1D(twin1D, i, dir);
                        break;
                    }
                }
            }
        }
        return new Board(copy1DTo2D(twin1D, this.width));
    }

    private int xyTo1D(int row, int col) {
        return (col % width) + (width * row);
    }

    private int[] xyFrom1D(int i) {
        int[] xy = new int[2];
        xy[0] = i % width;
        xy[1] = i / width;
        return xy;
    }

    private boolean checkBounds(int row, int col) {
        return (row > 0 || row <= width || col > 0 || col <= width);
    }

    private int[] copy1DTo1D(int[] a) {
        int[] b = new int[a.length];
        for (int i = 0; i < b.length; i++) {
            b[i] = a[i];
        }
        return b;
    }

    private int[][] copy1DTo2D(int[] a, int size) {
        int[][] b = new int[size][size];
        for (int i = 0; i < size; i++) {
            int x = xyFrom1D(i)[0];
            int y = xyFrom1D(i)[1];
            b[x][y] = a[i];
        }
        return b;
    }

    private void swap1D(int[] array, int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static int[][] createBoard(int[] data, int size) {
        int[][] result = new int[size][size];
        int index = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++)
                result[i][j] = data[index++];
        }
        return result;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        int[] data = { 4, 7, 3, 1, 5, 6, 2, 8, 0 };//{ 6, 1, 4, 3, 7, 2, 8, 0, 5 };
        int[] goal = { 1, 2, 3, 4, 5, 6, 7, 8, 0 };
        int[][] testb = createBoard(data, 3);
        int[][] goalb = createBoard(goal, 3);

        Board board = new Board(testb);
        Board goalBoard = new Board(goalb);
        System.out.println(board);

        System.out.println("Is it goal board? " + board.isGoal());
        System.out.println("Manhattan: " + board.manhattan());
        System.out.println("Hamming: " + board.hamming());
        System.out.println();
/*
        int n = 1;
        Iterable<Board> neighbors = board.neighbors();
        for (Board b : neighbors) {
            System.out.println("Neighbor " + n++);
            System.out.println(b);
        }

        Board twin;
        twin = board.twin();
        System.out.println("Twin");
        System.out.println(twin);
 */
        Board boardClone = new Board(testb);
        // System.out.println("Is board equal to twin? " + board.equals(twin));
        System.out.println("Is board equal to board? " + board.equals(goalBoard));
        System.out.println("Is board equal to null? " + board.equals(null));
        System.out.println("Is board equal to boardClone? " + board.equals(boardClone));
    }
}
