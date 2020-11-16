/**
 * @author Guanchen Zhao
 * @Description Wu-Manber-Myers-Miller 𝑂(𝑁𝑃) algorithm
 * class WuManberMyersMiller is the Implementation of Wu-Manber-Myers-Miller 𝑂(𝑁𝑃) algorithm
 * @Date 2020/11/15 11:22
 **/

public class WuManberMyersMiller {

    /**
     * the number of comparisons
     */
    public static int compareNumber = 0;

    /**
     * edit distance
     */
    public static int editDistance = 0;

    /**
     * get value
     */
    public static int getCompareNumber() {
        return compareNumber;
    }

    /**
     * get value
     */
    public static int getEditDistance() {
        return editDistance;
    }

    public static void execute(int[] a, int[] b) {
        int max = a.length + b.length;
        int[] v = new int[max * 2];
        // the count of compareNumber
        int i = 0;
        for (int d = 0; d <= a.length + b.length; d++) {
            for (int k = -d; k <= d; k += 2) {
                i++;
                // down or right?
                boolean down = (k == -d || (k != d && v[k - 1 + max] < v[k + 1 + max]));
                int kPrev = down ? k + 1 : k - 1;
                // start point
                int xStart = v[kPrev + max];
                int yStart = xStart - kPrev;
                // mid point
                int xMid = down ? xStart : xStart + 1;
                int yMid = xMid - k;
                // end point
                int xEnd = xMid;
                int yEnd = yMid;
                // follow diagonal
                while (xEnd < a.length && yEnd < b.length && a[xEnd] == b[yEnd]) {
                    xEnd++;
                    yEnd++;
                }
                // save end point
                v[k + max] = xEnd;
                // end
                if (xEnd >= a.length && yEnd >= b.length) {
                    // finish
                    editDistance = d;
                    compareNumber = i;
                    return;
                }
            }
        }
    }


}
