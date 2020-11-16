/**
 * @author Guanchen Zhao
 * @Description Since function 𝑓(𝑗) is discrete, it can be specified by an array 𝐹[1 … 𝑛] that holds its values in that
 * interval. Design a 𝑂(log 𝑛)-time algorithm that takes array 𝐹 as input and finds the unique value
 * of 𝑗, designated 𝑗min, at which 𝑓(𝑗) is minimum.
 * @Date 2020/11/5 14:11
 **/
public class minimum {

    public static void main(String[] args) {
        int size = 10000;
        int appointedIndex = 1;
        int[] arr = generateArray(size, appointedIndex);
        int index = getTargetIndex(arr);
        System.out.println("Jmin is: " + index);
    }

    /**
     * @author Guanchen Zhao
     * @Description
     * This algorithm is similar to binary search,
     * the condition of the result is F[target] < F[target-1] and F[target] < F[target+1].
     * @Date 2020/11/15 10:13
     **/
    private static int getTargetIndex(int[] F) {
        int low = 0, high = F.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            // F[mid] is the minimum value
            if (F[mid] < F[mid - 1] && F[mid] < F[mid + 1]) {
                return mid;
            }
            // The minimum value is on the right
            if (F[mid] > F[mid + 1]) {
                low = mid + 1;
            } else {// The minimum value is on the left
                high = mid;
            }
        }
        return low;
    }


    private static int[] generateArray(int size, int appointedIndex) {
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
}
