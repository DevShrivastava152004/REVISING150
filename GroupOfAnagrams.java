import java.util.*;

public class GroupOfAnagrams
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        // Edge case
        if(strs.length == 0)
        {
            return new ArrayList<>();
        }

        // HashMap:
        // key -> frequency pattern
        // value -> list of anagrams
        HashMap<String, List<String>> ansMap = new HashMap<>();

        // Frequency array
        int[] count = new int[26];

        // Traverse every string
        for(String s : strs)
        {
            // Reset count array
            Arrays.fill(count, 0);

            // Count character frequency
            for(char ch : s.toCharArray())
            {
                count[ch - 'a']++;
            }

            // Build unique key
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < 26; i++)
            {
                sb.append('#');
                sb.append(count[i]);
            }

            // Convert StringBuilder -> String
            String key = sb.toString();

            // Create list if key absent
            if(!ansMap.containsKey(key))
            {
                ansMap.put(key, new ArrayList<>());
            }

            // Add current string
            ansMap.get(key).add(s);
        }

        // Return grouped anagrams
        return new ArrayList<>(ansMap.values());
    }

    public static void main(String[] args)
    {
        GroupOfAnagrams ga = new GroupOfAnagrams();

        String[] strs = {"eat","tea","tan","ate","nat","bat"};

        List<List<String>> result = ga.groupAnagrams(strs);

        System.out.println(result);
    }
}