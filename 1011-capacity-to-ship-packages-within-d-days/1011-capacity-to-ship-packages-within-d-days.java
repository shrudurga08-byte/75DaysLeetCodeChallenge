public class Solution {
        public int shipWithinDays(int[] weights, int days) {

            int low = 0;
            int high = 0;

            for (int w : weights) {
                low = Math.max(low, w);
                high += w;
            }

            while (low < high) {

                int mid = (low + high) / 2;

                int sum = 0;
                int count = 1;

                for (int w : weights)
                {

                    if (sum + w > mid)
                    {
                        count++;
                        sum = 0;
                    }

                    sum += w;
                }

                if (count <= days) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            return low;
        }
}