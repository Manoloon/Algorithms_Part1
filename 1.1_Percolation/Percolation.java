import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    private static final int TOP = 0;
    private int length;
    private int openSites;
    private int bottom;
    private boolean[][] sites;
    private WeightedQuickUnionUF uf;

    public Percolation(int n) {
        if (n <= 0) throw new IllegalArgumentException("N is <= 0");

        this.length = n;
        this.sites = new boolean[length][length];
        bottom = length * length + 1;
        this.uf = new WeightedQuickUnionUF(length * length + 2);
        openSites = 0;
    }

    public void open(int row, int col) {
        if (!checkIndex(row, col)) throw new IllegalArgumentException();

        sites[row - 1][col - 1] = true;
        ++openSites;

        if (row == 1) uf.union(getSiteIndex(row, col), TOP);
        if (row == length) uf.union(getSiteIndex(row, col), bottom);

        if (row > 1 && isOpen(row - 1, col))
            uf.union(getSiteIndex(row, col), getSiteIndex(row - 1, col));
        if (row < length && isOpen(row + 1, col))
            uf.union(getSiteIndex(row, col), getSiteIndex(row + 1, col));
        if (col > 1 && isOpen(row, col - 1))
            uf.union(getSiteIndex(row, col), getSiteIndex(row, col - 1));
        if (col < length && isOpen(row, col + 1))
            uf.union(getSiteIndex(row, col), getSiteIndex(row, col + 1));
    }

    public boolean isOpen(int row, int col) {
        if (!checkIndex(row, col)) throw new IllegalArgumentException();
        return sites[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {
        if (!checkIndex(row, col)) throw new IllegalArgumentException();
        return uf.find(TOP) == uf.find(getSiteIndex(row, col));
    }

    public int numberOfOpenSites() {
        return openSites;
    }

    public boolean percolates() {
        return uf.find(TOP) == uf.find(bottom);
    }


    public static void main(String[] args) {

    }

    // Helpers
    private boolean checkIndex(int row, int col) {
        return (row > 0 || row <= length || col > 0 || col <= length);
    }

    private int getSiteIndex(int row, int col) {
        return length * (row - 1) + col;
    }
}
