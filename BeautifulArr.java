//https://leetcode.com/problems/beautiful-arrangement/

class Solution {
    public int countArrangement(int n) {
        //Tc: O(k) Sc: O(n) 
        boolean[] seen = new boolean[n + 1];
        return backtrack(1, n, seen);
    }

    private int backtrack(int pos, int n, boolean[] seen) {
        if (pos > n) return 1;
        int ans = 0;
        for (int num = 1; num <= n; num++) {
            if (!seen[num] && (num % pos == 0 || pos % num == 0)) {
                seen[num] = true;
                ans += backtrack(pos + 1, n, seen);
                seen[num] = false; 
            }
        }
        return ans;
    }
}

