import java.util.*;
public class ContainsDuplicate
{
    public boolean containsduplicate(int[] arr)
    {
        HashSet<Integer> set = new HashSet<>();
        for(int num : arr)
        {
            if(set.contains(num))
            {
                return true;
            }
                set.add(num);
            }
            return false;
    }
    public static void main(String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] arr = {1,2,3,4,5,1};
        boolean result = cd.containsduplicate(arr);
        System.out.println(result);
    }
}
// Time Complexity - O(n) and Space Complexity - O(n)