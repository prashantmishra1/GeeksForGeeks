package geeks.dynamic;

public class LongestPalindromicSubsequence {
	static int x, y;
	
	public int max(int x, int y){return (x>y)?x:y;}
	
	public int findLongestPalindromicSubsequence(String s, int i, int j){
		if(s.isEmpty() || i>j)
			return 0;
		else if(j-i == 0)
			return 1;
		else if((j-i+1 == 2 || j-i+1 == 3) && s.charAt(i) == s.charAt(j))
			return j-i+1;
		else if(s.charAt(i) == s.charAt(j)){
			return findLongestPalindromicSubsequence(s, i+1, j-1)+2;
		}
		else{
			return max(findLongestPalindromicSubsequence(s, i, j-1),
					   findLongestPalindromicSubsequence(s, i+1, j));
		}
	}
	
	public static void main(String args[]){
		String s = "GEEKS FOR GEEKS";
		LongestPalindromicSubsequence obj = new LongestPalindromicSubsequence();
		System.out.println(obj.findLongestPalindromicSubsequence(s.toLowerCase(), 0, s.length()-1));
	}

}

