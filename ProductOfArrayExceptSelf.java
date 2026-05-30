import java.util.*;
public class ProductOfArrayExceptSelf{
    public int[] productExceptSelf(int[] nums)
    {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans,1);
        int pre = 1;
        int post = 1;
        for(int i=0;i<n;i++)
        {
            ans[i] = pre;
            pre = pre*nums[i];
        }
        for(int i = n-1;i>=0;i--)
        {
            ans[i] = ans[i] * post;
            post = post*nums[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        ProductOfArrayExceptSelf p = new ProductOfArrayExceptSelf();
        int[] nums = {1,2,3,4};
        int[] ans  = p.productExceptSelf(nums);
        System.out.println(Arrays.toString(ans));
    }
}
// the time complexity of this code is O(n) and the space complexity is O(1) as we are not using any extra space except for the output array which is not counted as extra space.