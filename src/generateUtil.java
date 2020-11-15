/**
 * @Author Guanchen Zhao
 * @Description to generate sequence A and B
 * @Date 11:18 2020/11/14
 **/
public class generateUtil {

    /**
     * @Author Guanchen Zhao
     * @Description get random sequences A
     * @Params: size: the size of A
     * @Date 11:20 2020/11/14
     **/
    public static int[] generateA(int size) {
        int[] a = new int[size];

        for (int i = 0; i < a.length; i++) {
            int random = (int) (Math.random() * 1000);
            a[i] = random;
        }
        return a;
    }

    /**
     * @Author Guanchen Zhao
     * @Description get random sequences B
     * @Params: size: the size of B
     * a: sequences 𝐴 we generated before
     * deleteNum: the number of deletions
     * insertNumber: the number of insertions
     * @Date 11:20 2020/11/14
     **/
    public static int[] generateB(int size, int[] a, int deleteNum, int insertNumber) {
        int[] b = new int[size];
        // an array which store the indexes of deletion
        int[] deleteIndexArray = new int[deleteNum];
        // an array which store the indexes of insertion
        int[] insertIndexArray = new int[insertNumber];
        for (int i = 0; i < deleteIndexArray.length; i++) {
            int random = (int) (Math.random() * (b.length - 1));
            deleteIndexArray[i] = random;
        }

        for (int i = 0; i < insertIndexArray.length; i++) {
            int random = (int) (Math.random() * (b.length - 1));
            insertIndexArray[i] = random;
        }
        // -1 is a sign of an index of deletion
        for (int index : deleteIndexArray) {
            b[index] = -1;
        }
        // -2 is a sign of an index of insertion
        for (int index : insertIndexArray) {
            b[index] = -2;
        }

        int j = 0;
        for (int i = 0; i < b.length; i++) {
            if (j == a.length) {
                b[i] = (int) (Math.random() * 20000);
                continue;
            }
            // when do deletion, drop a[j]
            if (b[i] == -1) {
                j++;
            }
            // when do insertion, select a new random number
            if (b[i] == -2) {
                int random = (int) (Math.random() * 20000);
                b[i] = random;
                continue;
            }
            b[i] = a[j];
            j++;
        }

        return b;
    }
}
