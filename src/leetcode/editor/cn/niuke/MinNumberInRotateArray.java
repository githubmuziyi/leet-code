package leetcode.editor.cn.niuke;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray {

    public static void main(String[] args) {
        int[] s = new int[] {3,4,5,1,2};
        System.out.println(minNumberInRotateArray(s));
    }

    public static int minNumberInRotateArray(int [] array) {
        if (array.length <= 0) {
            return 0;
        }
        return minNumberInRotateArray(array, 0 , array.length - 1);
    }

    public static int minNumberInRotateArray(int [] array, int start, int end) {
        if (start == end) {
            return array[start];
        }
        if (start + 1 == end) {
            return Math.min(array[start], array[end]);
        }
        int mid = (start + end) / 2;
        int leftMin = minNumberInRotateArray(array, start, mid - 1);
        int rightMin = minNumberInRotateArray(array, mid, end);

        return leftMin < rightMin ? leftMin : rightMin;
    }
}
