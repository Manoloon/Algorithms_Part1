/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        if (k == 0) return;
        int count = 0;
        RandomizedQueue<String> strs = new RandomizedQueue<>();
        while (!StdIn.isEmpty()) {
            count++;
            String inString = StdIn.readString();
            if (count <= k) {
                strs.enqueue(inString);
            }
            if (count > k && StdRandom.uniformInt(count) < k) {
                strs.dequeue();
                strs.enqueue(inString);
            }
        }

        for (int i = 0; i < k; i++) {
            StdOut.println(strs.dequeue());
        }
    }
}
