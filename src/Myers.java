import java.util.Arrays;

/**
 * @Author Guanchen Zhao
 * @Description Wu-Manber-Myers-Miller 𝑂(𝑁𝑃) algorithm
 * @Date 5:32 下午 2020/11/15
 **/
public class Myers {

    private static int i = 0;
    private static int a[];
    private static int b[];
    private static int M;
    private static int N;
    private static int editdis = 0;


    public static void main(String[] args) {

        a = new int[4000];
        b = new int[5000];
        M = a.length;
        N = b.length;
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = 0; i < 600; i++) {
            a[i + 400] = i + 10000;
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = i;
        }
        compose();
        System.out.println("The edit distance is: " + editdis);
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
        editdis = delta + 2 * p;
        System.out.println(i);
    }

    private static int snake(int k, int p, int pp) {
        i++;
        int y = Math.max(p, pp);
        int x = y - k;
        while (x < M && y < N && a[x] == b[y]) {
            ++x;
            ++y;
        }
        return y;
    }

}
