
class Solution {
    public int pivotIndex(int[] nums) {

        int totalSum = 0;
        int leftSum = 0;

        // Step 1: Calculate total sum
        for (int i = 0; i < nums.length; i++) {
            totalSum = totalSum + nums[i];
        }

        // Step 2: Find pivot index
        for (int i = 0; i < nums.length; i++) {

            int rightSum = totalSum - leftSum - nums[i];

            // Step 3: Compare left and right sum
            if (leftSum == rightSum) {
                return i;
            }

            // Step 4: Update left sum
            leftSum = leftSum + nums[i];
        }

        // Step 5: No pivot index found
        return -1;
    }
}
