public class QuickSort {

    // 快速排序递  降序
    private static void quickSortInternally(int[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int position = partition(a, p, r);
        quickSortInternally(a, p, position - 1);
        quickSortInternally(a, position + 1, r);
    }

    private static int partition(int[] a, int low, int high) {
        int i = low, j = high;
        int temp = a[high];

        while (i < j) {

            while (i < j && a[i] >= temp) {
                i++;
            }
            a[j] = a[i];
            while (i < j && a[j] <= temp) {
                j--;
            }
            a[i] = a[j];
        }

        a[i] = temp;
        return i;
    }


    //找出第N大的元素
    public static int findMaxN(int[] a, int n) {
        int position = partition(a, 0, a.length - 1);

        while (position + 1 != n) {

            if (position + 1 > n) {
                position = partition(a, 0, position - 1);
            } else {
                position = partition(a, position + 1, a.length - 1);
            }
        }

        return a[position];
    }


    public static void main(String[] args) {
        int[] a = new int[]{4, 2, 8, 78, 70, 9, 20, 10};
        quickSortInternally(a, 0, 7);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
        System.out.println(findMaxN(a, 3));
    }
}
