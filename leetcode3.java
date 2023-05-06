import java.util.HashSet;
import java.util.Set;

public class leetcode3{
    public static boolean hasDuplicateChar(String s)
    {
        Set<Character> set = new HashSet<>();
        for(int i = 0;i<s.length();i++){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
            }else{
                return true;
            }
        }
        return false;
    }
    public static int longestNonRepeatingSubString(String s)
    {
        char[] str = s.toCharArray();
        int resLength = 1;
        for(int i = 0;i<s.length();i++){
            for(int j = i+1;j<s.length();j++){
                String substr = s.substring(i,j+1);
                if(!hasDuplicateChar(substr)){
                    if(substr.length() > resLength){
                        resLength = substr.length();
                    }
                }
            }
        }

        return resLength;
    }
    public static void main(String[] args)
    {
        System.out.println("Hello");
        String s = "pwwkew";
        System.out.println(longestNonRepeatingSubString(s));
    }
}