// https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/description/

import java.util.Arrays;

/*
#leetcode 1498
Intution:
The problem states that provided an arr A and a target T. We need to find all possible subsequence in A such 
that
A[i] + A[j] <= target  where i <= j and A[i] and A[j] are the min and max element of the subsequence respectivly;

The prolem is very much similar to Two sum problem using two pointer where we traverse
forward and backward and in the end we get the solution.
But here we have small twist.
Let us understand with the help of example:

3,3,6,8 and target = 10
possible subsequence are:
[3],[3],[3,3],[3,3,6],[3,6],[3,6]

Mathematically:
2*2 + 2 = 6 combinations

3 --> (3,6)  --> 2*2
3 --> (6)   --> 2

Had 6 + 6 < 10 then 6 could also have been into the list but it's not the case . So excluded.
Rest of thing clear in solution.
*/
class Solution {
    public int numSubseq(int[] nums, int target) {
        int result = 0;
        Arrays.sort(nums);
        int n = nums.length;
        int[] pow = new int[n];
        int mod = (int)Math.pow(10,9) + 7;

        pow[0] = 1;
        for(int i = 1;i<n;i++)
        {
          pow[i] = (pow[i-1]*2)%mod;
        }

        int l = 0;
        int r = n-1;

        while(l <= r){
          if(nums[l] + nums[r] > target){
            r--;
          }else{
            result = (result + pow[r - l++])%mod;
          }
        }
        return result;
    }
}