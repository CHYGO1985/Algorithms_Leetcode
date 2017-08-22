/**
 * 
 * 375. Guess Number Higher or Lower II
 * 
 * round 1: unsolved, 
 * 
 * ref: https://discuss.leetcode.com/topic/51353/simple-dp-solution-with-explanation/2
 * 
 * Idea: I was trying to find regulations to form a dp formula, but did not success. And I stick on it. However it turns
 * out that it is a dp solution that save the intermediate status, not a traditional dp that goes iterately and then reach
 * to an answer. 
 * 
 * @author jingjiejiang
 * @history 
 * 1. Aug 22, 2017
 */
public class GuessNumHigherOrLowerII {

	public int getMoneyAmount(int n) {
        
        int[][] records = new int[n + 1][n + 1];
        
        return findGuarantee(records, 1, n);
    }
    
    private int findGuarantee(int[][] records, int start, int end) {
        
        if (start >= end) return 0;
        if (records[start][end] != 0) return records[start][end];
        int res = Integer.MAX_VALUE;
        
        for (int i = start; i <= end; i ++) {
            int temp = i + Math.max(findGuarantee(records, start, i - 1), findGuarantee(records, i + 1, end));
            res = Math.min(res, temp);
        }
        
        records[start][end] = res;
        return res;
    }
}
