public class SolutionArray {


    // 插入排序，a表示数组，n表示数组大小
    public static void insertionSort(int[] a) {
        if (a == null || a.length <= 1){
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
                    a[j+1] = a[j];
                }else{
                    break;
                }
            }
            //保存被覆盖的值
            a[j+1] = value;
        }
    }


    public static void main(String[] args) {

        insertionSort(new int[]{4,2,8,7,2,3,89});
    }

}
