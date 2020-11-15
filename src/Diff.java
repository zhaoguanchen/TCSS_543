import java.util.Arrays;

public class Diff {
 private  int i;

    private int A[];
    private int B[];
    private int M;
    private int N;
    private int editdis;

    public Diff(int a[], int b[]) {
        this.i = 0;
        this.A = a;
        this.B = b;
        this.M = a.length;
        this.N = b.length;
        this.editdis = 0;
        if (this.M > this.N) {
            int tmp[] = this.A;
            this.A = this.B;
            this.B = tmp;
        }
    }

    public int getEditdis() {
        return this.editdis;
    }

    public void compose() {
        int p = -1;
        int size = this.M + this.N + 3;
        int delta = this.N - this.M;
        int offset = M + 1;
        int fp[] = new int[size];
        Arrays.fill(fp, -1);

//        int i = 0;
        do {
            ++p;
            for (int k = -p; k <= delta - 1; ++k) {
                fp[k + offset] = this.snake(k, fp[k - 1 + offset] + 1, fp[k + 1 + offset]);
            }
            for (int k = delta + p; k >= delta + 1; --k) {
                fp[k + offset] = this.snake(k, fp[k - 1 + offset] + 1, fp[k + 1 + offset]);
            }
            fp[delta + offset] = this.snake(delta, fp[delta - 1 + offset] + 1, fp[delta + 1 + offset]);

        } while (fp[delta + offset] < this.N);
        this.editdis = delta + 2 * p;
        System.out.println(i);
    }

    private int snake(int k, int p, int pp) {
        i++;
        int y = Math.max(p, pp);
        int x = y - k;
        while (x < M && y < N && this.A[x] == this.B[y]) {
            ++x;
            ++y;
        }
        return y;
    }
}
