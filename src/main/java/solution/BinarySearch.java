package main.java.solution;

/**
 * Created by dujinyuan on 17/1/3.
 */
public class BinarySearch {

    //while循环实现
    public static int binarySearch(int[] arr, int searchKey) {
        int startFix = 0;
        int endFix = arr.length - 1;
        while (startFix <= endFix) {
            int midFix = (startFix + endFix) / 2;
            if (searchKey == arr[midFix]) {
                return midFix;
            } else if (searchKey < arr[midFix]) {
                endFix = midFix - 1;
            } else if (searchKey > arr[midFix]) {
                startFix = midFix + 1;
            }
        }
        return -1;
    }


    // 二分查找递归实现
    private static int binSearch(int[] srcArray, int start, int end, int key) {
        int mid = (start + end) / 2;
        if (key == srcArray[mid]) {
            return mid;
        }
        if (start >= end) {
            return -1;
        } else if (key > srcArray[mid]) {
            return binSearch(srcArray, mid + 1, end, key);
        } else if (key < srcArray[mid]) {
            return binSearch(srcArray, start, mid - 1, key);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] srcArray = {3, 5, 11, 17, 21, 23, 28, 30, 32, 50, 64, 78, 81, 95, 101};
        System.out.println("递归实现：" + binSearch(srcArray, 0, srcArray.length - 1, 95));
        System.out.println("while循环实现：" + binarySearch(srcArray, 95));
    }
}
