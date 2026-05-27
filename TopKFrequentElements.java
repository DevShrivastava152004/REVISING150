import java.util.*;
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> frequencyMap = new HashMap<>();
        for(int num : nums)

        {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0)+1);
        }
        List<Integer>[] bucket = new ArrayList[nums.length + 1];

        for(int key : frequencyMap.keySet())
        {
            int frequency = frequencyMap.get(key);

            if(bucket[frequency] == null)
            {
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }
        int[] result = new int[k];
        int index = 0;

        for(int i = bucket.length - 1; i>= 0 && index < k;i--)
        {
            if( bucket[i] != null)
            {
                for(int num : bucket[i])
                {
                    result[index] = num;
                    index++;

                    if(index == k)
                    {
                        break;
                    }
                }
            }
        }
        return result;
        
    }
    public static void main(String[] args) {
        TopKFrequentElements solution = new TopKFrequentElements();
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        int[] topK = solution.topKFrequent(nums, k);
        for(int num : topK)
        {
            System.out.print(num + " ");
        }
    }
}
