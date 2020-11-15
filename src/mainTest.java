/**
 * @Author Guanchen Zhao
 * @Description 进行计算测试的主要流程
 * @Date 11:30 2020/11/15
 **/

写在PDF
        为了main函数可以调用，方法都用了static 声明。
        整个流程分为4部分，测试，Myers，wu，和generate。
        我们可以在mainTest指定M，N和D的大小
通过四个print函数println 我们可以得到 edit distance 和number of comparisons。


public class mainTest {

    public static void main(String[] args) {
        int deleteNum = 10;// D
        int M = 4000, N = 5000;// M,N
        int insertNumber = N - M + deleteNum;// 𝑁 − 𝑀 + 𝐷 insertions
        int[] a = generateUtil.generateA(M);

        int[] b = generateUtil.generateB(N, a, deleteNum, insertNumber);

        Myers.execute(a, b);
        System.out.println("The edit distance of Myers is: " + Myers.getEditDistance());
        System.out.println("The number of comparisons of Myers is: " + Myers.getCompareNumber());
        WuManberMyersMiller.execute(a, b);
        System.out.println("The edit distance of WuManberMyersMiller is: " + WuManberMyersMiller.getEditDistance());
        System.out.println("The number of comparisons of WuManberMyersMiller is: " + WuManberMyersMiller.getCompareNumber());

    }
}
