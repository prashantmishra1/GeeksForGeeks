package geeksforgeeks.dynamic;

public class LongestCommonSubsequence {
	
	public int max(int x, int y){ return (x>y)?x:y;}
	
	public int findLongestCommonSubsequence(String s1, String s2, int m, int n){
		if(s1.length() == 0 || s2.length() == 0)
			return 0;
		if(m < 0 || n < 0) return 0;
		if(s1.charAt(m) == s2.charAt(n)){
			return (findLongestCommonSubsequence(s1, s2, m-1, n-1) + 1);
		} else{
			return max(findLongestCommonSubsequence(s1, s2, m, n-1),
					findLongestCommonSubsequence(s1, s2, m-1, n));
		}
	}
	
	public static void main(String args[]){
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		LongestCommonSubsequence obj = new LongestCommonSubsequence();
		System.out.println("Longest common subsequence for '" + s1 + "' and '" + s2 + "' is:");
		System.out.println(obj.findLongestCommonSubsequence(s1, s2, s1.length()-1, s2.length()-1));
	}
	

}

