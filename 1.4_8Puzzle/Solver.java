/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class Solver {
    private TargetNode lastNode;
    private boolean isSolvable;
    private int minMoves;

    // find a solution to the initial board (using the A* algorithm)
    public Solver(Board initial) {
        if (initial == null) throw new IllegalArgumentException();
        int moves = 0;
        int twinMoves = 0;

        Queue<Board> neighBoards = new Queue<Board>();
        Queue<Board> twinNeighBoards = new Queue<Board>();

        MinPQ<TargetNode> searchNodes = new MinPQ<TargetNode>();
        MinPQ<TargetNode> twinNodes = new MinPQ<TargetNode>();

        TargetNode searchNode = new TargetNode(initial, moves, null);
        TargetNode twinSearchNode = new TargetNode(initial.twin(), twinMoves, null);

        searchNodes.insert(searchNode);
        twinNodes.insert(twinSearchNode);

        boolean solved = false;
        boolean twinSolved = false;
        TargetNode currentNode;

        while (!solved && !twinSolved) {
            currentNode = searchNodes.delMin();
            TargetNode previous = currentNode.getPrevious();
            Board tempBoard = currentNode.getBoard();
            solved = tempBoard.isGoal();

            TargetNode currentTwin = twinNodes.delMin();
            TargetNode previousTwin = currentTwin.getPrevious();
            Board tempTwin = currentTwin.getBoard();
            twinSolved = tempTwin.isGoal();

            for (Board b : tempBoard.neighbors())
                neighBoards.enqueue(b);
            for (Board b : tempTwin.neighbors())
                twinNeighBoards.enqueue(b);

            while (neighBoards.size() > 0) {
                Board board = neighBoards.dequeue();
                int move = currentNode.getMoves();
                move++;
                if (previous != null && previous.getBoard().equals(board))
                    continue;

                TargetNode neighborNode = new TargetNode(board, move, currentNode);
                searchNodes.insert(neighborNode);
            }

            while (twinNeighBoards.size() > 0) {
                Board board = twinNeighBoards.dequeue();
                int twinMove = currentTwin.getMoves();
                twinMove++;
                if (previousTwin != null && previousTwin.getBoard().equals(board)) {
                    continue;
                }
                TargetNode neighborNode = new TargetNode(board, twinMove, currentTwin);
                twinNodes.insert(neighborNode);
            }
            moves = currentNode.getMoves() + 1;
            // twinMoves = currentTwin.getMoves() + 1;
            lastNode = currentNode;
        }
        isSolvable = !twinSolved;
        minMoves = moves - 1;
    }

    // is the initial board solvable? (see below)
    public boolean isSolvable() {
        return isSolvable;
    }

    // min number of moves to solve initial board; -1 if unsolvable
    public int moves() {
        if (!isSolvable()) {
            return -1;
        }
        return minMoves;
    }

    // sequence of boards in a shortest solution; null if unsolvable
    public Iterable<Board> solution() {
        Stack<Board> boards = new Stack<Board>();
        TargetNode lNode = this.lastNode;
        if (this.isSolvable()) {
            while (lNode.getPrevious() != null) {
                boards.push(lNode.getBoard());
                lNode = lNode.getPrevious();
            }
            boards.push(lNode.getBoard());
            return boards;
        }
        return null;
    }

    private class TargetNode implements Comparable<TargetNode> {
        private TargetNode previous;
        private Board currentBoard;
        private int moves;
        private int priority;

        // constructor
        public TargetNode(Board first, int m, TargetNode prev) {
            previous = prev;
            moves = m;
            currentBoard = first;

            priority = m + first.manhattan();
        }

        public int getPriority() {
            return priority;
        }

        public Board getBoard() {
            return currentBoard;
        }

        public int getMoves() {
            return moves;
        }

        public TargetNode getPrevious() {
            return previous;
        }

        public int compareTo(TargetNode other) {
            return (this.getPriority() - other.getPriority());
        }
    }

    public static void main(String[] args) {
        // create initial board from file
        In in = new In(args[0]);
        int n = in.readInt();
        int[][] tiles = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                tiles[i][j] = in.readInt();
        Board initial = new Board(tiles);

        // solve the puzzle
        Solver solver = new Solver(initial);

        // print solution to standard output
        if (!solver.isSolvable()) StdOut.println("No solution possible");
        else {
            StdOut.println("Minimum number of moves = " + solver.moves());
            for (Board board : solver.solution())
                StdOut.println(board);
        }
    }
}
