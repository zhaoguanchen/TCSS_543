/**
 * @Author Guanchen Zhao
 * @Description  Wu-Manber-Myers-Miller 𝑂(𝑁𝑃) algorithm
 * @Date 5:32 下午 2020/11/15
 **/
public class Mayes {
    public static void main(String[] args) {

        int[] a = new int[4000];
        int[] b = new int[5000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = 0; i < 600; i++) {
            a[i+400] = i + 10000;
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = i;
        }

        Diff diff = new Diff(a, b);
        diff.compose();
        System.out.println("The edit distance is: " + diff.getEditdis());
    }

}
