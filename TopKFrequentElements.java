import java.util.*;
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        if(k == nums.length)
        {
            return nums;
        }
        Map<Integer ,Integer> count = new HashMap<>();
        for(int n:nums)
        {
            count.put(n, count.getOrDefault(n,0) + 1);
        }
        Queue<Integer> heap = new PriorityQueue<>((a,b) -> count.get(a) - count.get(b));

        for(int  n:count.keySet())
        {
            heap.add(n);
            if(heap.size() > k)
            {
                heap.poll();

            }
        }
        int[] ans = new int[k];
        for(int  i=0;i<k;i++)
        {
            ans[i] = heap.poll();

        }
        return ans;

    }
    public static void main(String[] args)
    {
        TopKFrequentElements t = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        int k  =2;
        int[] ans = t.topKFrequent(nums, k);
        System.out.println(Arrays.toString(ans));
    }
}