public class InsertionSort {


    // 插入排序 升序
    public static void insertionSort(int[] a) {
        if (a == null || a.length <= 1) {
            return;
        }
        long length = a.length;
        //从下标1开始，默认下标0的值最小
        for (int i = 1; i < length; i++) {
            //先保存需要被比较的值
            int value = a[i];
            //被比较值的前一个值的下标
            int j = i - 1;
            for (; j >= 0; j--) {
                //如果大于被比较值，则往后移动
                if (a[j] > value) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            //保存被覆盖的值
            a[j + 1] = value;
        }
    }

    public static void main(String[] args) {

        int[] a = new int[]{4, 2, 8, 78, 70, 9, 20, 10};
        insertionSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
