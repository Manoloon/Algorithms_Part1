/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.Queue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {
    private final int[] board;
    private final int width;

    // create a board from an n-by-n array of tiles,
    // where tiles[row][col] = tile at (row, col)
    public Board(int[][] tiles) {
        if (tiles == null) throw new java.lang.IllegalArgumentException();
        if (tiles.length != tiles[0].length) throw new java.lang.IllegalArgumentException();
        if (tiles.length < 2 || tiles.length > 128) throw new IllegalArgumentException();
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
        str.append(width + "\n");

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
            if (board[i] != i + 1 && board[i] != 0) {
                result++;
            }
        }
        return result;
    }

    // sum of Manhattan distances between tiles and goal
    public int manhattan() {
        int result = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i] != i + 1 && board[i] != 0) {
                int x1 = xyFrom1D(i)[0];
                int y1 = xyFrom1D(i)[1];
                int value = board[i] - 1;
                int x2 = xyFrom1D(value)[0];
                int y2 = xyFrom1D(value)[1];
                result += (Math.abs(x1 - x2) + Math.abs(y1 - y2));
            }
        }
        return result;
    }

    // is this board the goal board?
    public boolean isGoal() {
        for (int i = 0; i < width * width - 1; i++) {
            if (board[i] > board[i + 1]) return false;
        }
        return true;
    }

    // does this board equal y?
    public boolean equals(Object y) {
        if (y == this) return true;
        if (y == null) return false;
        if (y.getClass() != this.getClass()) return false;
        Board other = (Board) y;
        if (other.dimension() != this.dimension()) return false;
        if (!Arrays.equals(this.board, other.board)) return false;
        return true;
    }

    // all neighboring boards
    public Iterable<Board> neighbors() {
        Queue<Board> neighbors = new Queue<Board>();
        int emptyIndex;
        int emptyRow;
        int emptyCol;
        ArrayList<Integer> tiles = new ArrayList<Integer>();
        //
        for (emptyIndex = 0; emptyIndex < board.length; emptyIndex++) {
            if (board[emptyIndex] == 0) {
                emptyCol = xyFrom1D(emptyIndex)[0];
                emptyRow = xyFrom1D(emptyIndex)[1];

                // Calculate neighboring tiles
                // up
                if (checkBounds(emptyRow - 1, emptyCol)) tiles.add(xyTo1D(emptyRow - 1, emptyCol));
                // right
                if (checkBounds(emptyRow, emptyCol + 1)) tiles.add(xyTo1D(emptyRow, emptyCol + 1));
                // down
                if (checkBounds(emptyRow + 1, emptyCol)) tiles.add(xyTo1D(emptyRow + 1, emptyCol));
                // left
                if (checkBounds(emptyRow, emptyCol - 1)) tiles.add(xyTo1D(emptyRow, emptyCol - 1));
                break;
            }
        }
        // generate neighboring boards
        for (int i = 0; i < tiles.size(); i++) {
            int targetIndex = tiles.get(i);
            int[] temp1D = copy1DTo1D(board);
            swap1D(temp1D, emptyIndex, targetIndex);
            int[][] temp2D = copy1DTo2D(temp1D, this.width);
            Board tempBoard = new Board(temp2D);
            neighbors.enqueue(tempBoard);
        }
        return neighbors;
    }

    // a board that is obtained by exchanging any pair of tiles
    public Board twin() {
        int[] twin1D = Arrays.copyOf(board, board.length);
        List<Integer> nonEmptyIndexes = new ArrayList<>();
        for (int i = 0; i < twin1D.length; i++) {
            if (twin1D[i] != 0) nonEmptyIndexes.add(i);
        }
        if (nonEmptyIndexes.size() < 2) {
            return new Board(copy1DTo2D(twin1D, width));
        }

        for (int i = 0; i < nonEmptyIndexes.size(); i++) {
            int current = nonEmptyIndexes.get(i);
            int next = nonEmptyIndexes.get(i + 1);

            if (areAdjacent(current, next)) {
                swap1D(twin1D, current, next);
                return new Board(copy1DTo2D(twin1D, this.width));
            }
        }
        return new Board(copy1DTo2D(twin1D, this.width));
    }

    private boolean areAdjacent(int tile1, int tile2) {
        int[] coords1 = xyFrom1D(tile1);
        int[] coords2 = xyFrom1D(tile2);

        int col1 = coords1[0];
        int row1 = coords1[1];

        int col2 = coords2[0];
        int row2 = coords2[1];
        return (Math.abs(col1 - col2) + Math.abs(row1 - row2)) == 1;
    }

    private int xyTo1D(int row, int col) {
        return (width * row) + col;
    }

    private int[] xyFrom1D(int i) {
        int[] xy = new int[2];
        xy[0] = i % width;
        xy[1] = i / width;
        return xy;
    }

    private boolean checkBounds(int row, int col) {
        return row >= 0 && row < width && col >= 0 && col < width;
    }

    private int[] copy1DTo1D(int[] a) {
        int[] temp1D = new int[a.length];
        for (int i = 0; i < temp1D.length; i++) {
            temp1D[i] = a[i];
        }
        return temp1D;
    }

    private int[][] copy1DTo2D(int[] a, int size) {
        int[][] temp2d = new int[width][width];
        for (int i = 0; i < size; i++) {
            int row = xyFrom1D(i)[0];
            int col = xyFrom1D(i)[1];
            temp2d[col][row] = a[i];
        }
        return temp2d;
    }

    private void swap1D(int[] array, int a, int b) {
        // if (array == null || a < 0 || b < 0 || a >= array.length || b >= array.length || a == b) {
        //    return;
        //}
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static int[][] createBoard(int[] data, int size) {
        int[][] result = new int[size][size];
        int index = 0;

        if (data.length != size * size) {
            throw new IllegalArgumentException(
                    "Insufficient data elements for the specified board size.");
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (index >= data.length) {
                    throw new IllegalArgumentException("Data elements exceeded the expected size.");
                }
                result[i][j] = data[index++];
            }
        }
        return result;
    }

    // unit testing (not graded)
    public static void main(String[] args) {
        int[] data = {
                8, 4, 7, 1, 5, 6, 3, 2, 0
        };
        int[] goal = {
                1, 2, 3, 4, 5, 6, 7, 8, 0
        };
        int[][] testb = createBoard(data, 3);
        int[][] goalb = createBoard(goal, 3);

        Board board = new Board(testb);
        Board goalBoard = new Board(goalb);
        System.out.println(board);
        System.out.println(goalBoard);
        System.out.println("Is it goal board? " + goalBoard.isGoal());
        System.out.println("Manhattan: " + board.manhattan());
        System.out.println("Hamming: " + board.hamming());
        System.out.println();

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

        Board boardClone = new Board(testb);
        // System.out.println("Is board equal to twin? " + board.equals(twin));
        System.out.println("Is board equal to board? " + board.equals(goalBoard));
        System.out.println("Is board equal to boardClone? " + board.equals(boardClone));
    }
}
