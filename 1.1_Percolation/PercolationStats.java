import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private static final double CONF = 1.96;
    private int expeCount = 0;
    private final double[] fractions;

    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0)
            throw new IllegalArgumentException("n or trials are <=0");
        expeCount = trials;
        fractions = new double[expeCount];
        for (int expNum = 0; expNum < expeCount; expNum++) {
            Percolation pr = new Percolation(n);
            int openedSites = 0;
            while (!pr.percolates()) {
                int i = StdRandom.uniformInt(1, n + 1);
                int j = StdRandom.uniformInt(1, n + 1);
                if (!pr.isOpen(i, j)) {
                    pr.open(i, j);
                    openedSites++;
                }
            }
            double fraction = (double) openedSites / (n * n);
            fractions[expNum] = fraction;
        }
    }

    // percolation threshold
    public double mean() {
        return StdStats.mean(fractions);
    }

    // standard deviation
    public double stddev() {
        return StdStats.stddev(fractions);
    }

    // lower bound of the 95% confidence interval
    public double confidenceLo() {
        return mean() - (CONF * stddev()) / Math.sqrt(expeCount);
    }

    public double confidenceHi() {
        return mean() + (CONF * stddev()) / Math.sqrt(expeCount);
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        PercolationStats ps = new PercolationStats(n, t);
        String confidence = ps.confidenceLo() + ", " + ps.confidenceHi();
        StdOut.println("mean                        =" + ps.mean());
        StdOut.println("stddev                      =" + ps.stddev());
        StdOut.println("95% confidence interval     =" + confidence);
    }
}
