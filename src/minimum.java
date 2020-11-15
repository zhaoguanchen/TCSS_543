import sun.security.internal.spec.TlsKeyMaterialSpec;

/**
 * @author Guanchen Zhao
 * @Description Since function 𝑓(𝑗) is discrete, it can be specified by an array 𝐹[1 … 𝑛] that holds its values in that
 * interval. Design a 𝑂(log 𝑛)-time algorithm that takes array 𝐹 as input and finds the unique value
 * of 𝑗, designated 𝑗min, at which 𝑓(𝑗) is minimum.
 * @Date 2020/11/5 14:11
 **/
public class minimum {

    public static void main(String[] args) {
        int[] arr = getInitArray(10000, 77);
        int index = getIndex(arr);
        System.out.println(index);
    }

    private static int getIndex(int[] F) {
        int low = 0, high = F.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (F[mid] < F[mid - 1] && F[mid] < F[mid + 1]) {
                return mid;
            }
            if (F[mid] > F[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }


    private static int[] getInitArray(int size, int appointedIndex) {
        int[] arr = new int[size];
        int origin = 100;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = origin;
            if (i < appointedIndex) {
                origin -= 10;
            } else {
                origin += 10;
            }

        }
        return arr;
    }

//    public static void main(String[] args) {
//        DiffAlgorithm d =
//    }
}
