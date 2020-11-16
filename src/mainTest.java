/**
 * @author Guanchen Zhao
 * @Description
 * The main function in class mainTest contains parameter assignments(M,N and D), method calls, and result printing(edit distance and number of comparisons).
 * @Date 2020/11/16 11:20
 **/
public class mainTest {

    public static void main(String[] args) {
        int deleteNum = 1000;// D
        int M = 4000, N = 5000;// M,N
        int insertNumber = N - M + deleteNum;// 𝑁 − 𝑀 + 𝐷 insertions
        int[] a = generateUtil.generateA(M);
        int[] b = generateUtil.generateB(N, a, deleteNum, insertNumber);

        Myers.execute(a, b);
        System.out.println("The edit distance of Myers is: " + Myers.getEditDistance());
        System.out.println("The number of comparisons of Myers is: " + Myers.getCompareNumber());
        WuManberMyersMiller.execute(a, b);
        System.out.println("The edit distance of Wu-Manber-Myers-Miller is: " + WuManberMyersMiller.getEditDistance());
        System.out.println("The number of comparisons of Wu-Manber-Myers-Miller is: " + WuManberMyersMiller.getCompareNumber());
    }
}
