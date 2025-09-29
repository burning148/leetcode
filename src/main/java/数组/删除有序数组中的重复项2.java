package 数组;


/**
 * 思路：
 * <p>
 * 使用两个指针：slow 和 fast。slow 指针表示处理后的数组的当前位置，fast 指针遍历原数组。
 * <p>
 * 由于每个元素最多可以出现两次，所以我们需要检查当前元素是否已经出现了两次。
 * <p>
 * 具体来说，如果 nums[slow-2]（注意边界）与 nums[fast] 相同，说明当前元素已经出现了两次（因为数组是有序的），那么我们应该跳过这个元素（即不将其放入处理后的数组）。
 * <p>
 * 否则，将 nums[fast] 的值复制到 nums[slow]，然后移动 slow 指针。
 * <p>
 * 这样，slow 就是新数组的长度。
 * <p>
 * 为什么是 slow-2？
 * 因为我们要确保相同的元素最多出现两次。当 nums[fast] 与 nums[slow-2] 相同时，说明如果我们将 nums[fast] 放入 slow 位置，那么相同的元素将连续出现三次（因为 slow-2 和 slow-1 可能已经是相同的两个元素）。所以我们需要跳过。
 */
public class 删除有序数组中的重复项2 {

    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2;
        for (int fast = 2; fast < n; fast++) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                slow++;
            } else {
                continue;
            }
        }
        // Z
        return slow;
    }
}
