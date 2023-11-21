/* *****************************************************************************
 *  Name:              Ada Lovelace
 *  Coursera User ID:  123456
 *  Last modified:     October 16, 1842
 **************************************************************************** */


public class BitonicArray {
    public static boolean findInteger(int[] nums, int search) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] == search || nums[right] == search) {
                return true;
            }
            left++;
            right--;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 4, 5, 19, 39, 10, 5, 7, 9, 11 };
        if (findInteger(nums, 8)) {
            System.out.printf("found it");
        }
        else {
            System.out.printf("NOT FOund it");
        }
    }
}
