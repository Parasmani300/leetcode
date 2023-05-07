import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/

public class leetcode3{

    public static int longestNonRepeatingSubString(String s)
    {
        class Solution {
            public int lengthOfLongestSubstring(String s) {
                Map<Character,Integer> map = new HashMap<>();
                int l = 0;
                int r = 0;
                int n = s.length();
                int len = 0;
                while(r < n){
                    if(map.containsKey(s.charAt(r))){
                        l = Math.max(map.get(s.charAt(r)) +1,l);
                    }

                    map.put(s.charAt(r),r);
                    len = Math.max(len,r - l + 1);
                    r++;
                }

                return len;
            }
        }


    }
    public static void main(String[] args)
    {
        System.out.println("Hello");
        String s = "pwwkew";
        System.out.println(longestNonRepeatingSubString(s));
    }
}