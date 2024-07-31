//https://leetcode.com/problems/generate-parentheses/


//Solution using Backtracking

class Solution {
    List<String> ans;
    int n;
    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        this.n = n;
        if(n == 0) return ans;
        helper("", 0, 0);
        return ans;
    }

    private void helper(String cur, int open, int close)
    {
        if(cur.length() == n*2) 
        {
            ans.add(cur);
            return;
        }

        if(open < n)
        {
            helper(cur+'(', open+1, close);
        }

        if(close < open)
        {
            helper(cur+')', open, close+1);
        }
    }
}
