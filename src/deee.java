import java.util.ArrayList;
import java.util.List;

public class deee {

    public static void main(String[] args) {

        int[] a = new int[4000];
        int[] b = new int[5000];
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
        }
        for (int i = 0; i < 10; i++) {
            a[i] = i + 10000;
        }
        for (int i = 0; i < b.length; i++) {
            b[i] = i;
        }

        int max = a.length + b.length;
        int[] v = new int[max * 2];
        List<Snake> snakes = new ArrayList<>();
        int i = 0;
        for (int d = 0; d <= a.length + b.length; d++) {
            System.out.println("D:" + d);
            for (int k = -d; k <= d; k += 2) {
                System.out.print("k:" + k);
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
                int snake = 0;
                while (xEnd < a.length && yEnd < b.length && a[xEnd] == b[yEnd]) {
                    xEnd++;
                    yEnd++;
                    snake++;
                }
                // save end point
                v[k + max] = xEnd;
                // record a snake
                snakes.add(0, new Snake(xStart, yStart, xEnd, yEnd));
//                System.out.print(", start:(" + xStart + "," + yStart + "), mid:(" + xMid + "," + yMid + "), end:(" + xEnd + "," + yEnd + ")\n");
                // check for solution
                if (xEnd >= a.length && yEnd >= b.length) {
                    /* solution has been found */
                    System.out.println("found");
                    System.out.println("found" + d);
                    System.out.print("i:" + i);
                    /* print the snakes */
//                    Snake current = snakes.get(0);
//                    System.out.println(String.format("(%2d, %2d)<-(%2d, %2d)", current.getxEnd(), current.getyEnd(), current.getxStart(), current.getyStart()));
//                    for (int i = 1; i < snakes.size(); i++) {
//                        Snake tmp = snakes.get(i);
//                        if (tmp.getxEnd() == current.getxStart()
//                                && tmp.getyEnd() == current.getyStart()) {
//                            current = tmp;
//                            System.out.println(String.format("(%2d, %2d)<-(%2d, %2d)", current.getxEnd(), current.getyEnd(), current.getxStart(), current.getyStart()));
//                            if (current.getxStart() == 0 && current.getyStart() == 0) {
//                                break;
//                            }
//                        }
//                    }
                    return;
                }
            }
        }
    }

    public static class Snake {
        private int xStart;
        private int yStart;
        private int xEnd;
        private int yEnd;

        public Snake(int xStart, int yStart, int xEnd, int yEnd) {
            this.xStart = xStart;
            this.yStart = yStart;
            this.xEnd = xEnd;
            this.yEnd = yEnd;
        }

        public int getxStart() {
            return xStart;
        }

        public void setxStart(int xStart) {
            this.xStart = xStart;
        }

        public int getyStart() {
            return yStart;
        }

        public void setyStart(int yStart) {
            this.yStart = yStart;
        }

        public int getxEnd() {
            return xEnd;
        }

        public void setxEnd(int xEnd) {
            this.xEnd = xEnd;
        }

        public int getyEnd() {
            return yEnd;
        }

        public void setyEnd(int yEnd) {
            this.yEnd = yEnd;
        }
    }
}
