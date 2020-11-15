import java.util.Arrays;

/**
 * @Author Guanchen Zhao
 * @Description Wu-Manber-Myers-Miller 𝑂(𝑁𝑃) algorithm
 * @Date 5:32 下午 2020/11/15
 **/
public class Myers {

    private static int compareNumber = 0;
    private static int a[];
    private static int b[];
    private static int M;
    private static int N;
    private static int editDistance = 0;

    public static void execute(int[] source, int[] target) {
        a = source;
        b = target;
        M = a.length;
        N = b.length;
        compose();
    }

    public static void compose() {
        int p = -1;
        int size = M + N + 3;
        int delta = N - M;
        int offset = M + 1;
        int fp[] = new int[size];
        Arrays.fill(fp, -1);

        do {
            ++p;
            for (int k = -p; k <= delta - 1; ++k) {
                fp[k + offset] = snake(k, fp[k - 1 + offset] + 1, fp[k + 1 + offset]);
            }
            for (int k = delta + p; k >= delta + 1; --k) {
                fp[k + offset] = snake(k, fp[k - 1 + offset] + 1, fp[k + 1 + offset]);
            }
            fp[delta + offset] = snake(delta, fp[delta - 1 + offset] + 1, fp[delta + 1 + offset]);

        } while (fp[delta + offset] < N);
        editDistance = delta + 2 * p;
    }

    private static int snake(int k, int p, int pp) {
        compareNumber++;
        int y = Math.max(p, pp);
        int x = y - k;
        while (x < M && y < N && a[x] == b[y]) {
            ++x;
            ++y;
        }
        return y;
    }


    public static int getCompareNumber() {
        return compareNumber;
    }

    public static int getEditDistance() {
        return editDistance;
    }
}
