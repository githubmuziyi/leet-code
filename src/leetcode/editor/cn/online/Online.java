package leetcode.editor.cn.online;

public class Online {

    public static int index(int[] arr) {
        int index = -1;
        if (arr.length <= 0) {
            return index;
        }
        if (arr.length == 1) {
            return 0;
        }
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (arr[mid] > arr[start]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;
    }

}
