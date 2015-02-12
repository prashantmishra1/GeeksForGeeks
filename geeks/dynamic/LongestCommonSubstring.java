package geeksforgeeks.dynamic;

public class LongestCommonSubstring {
	
	public int max(int x, int y){return (x>y)?x:y;}
	
	public int findLongestCommonSubstring(String s1, String s2){
		int m = s1.length();
		int n = s2.length();
		
		int maxLen = 0;
		
		int arr[][] = new int[m+1][n+1];
		
		for(int i=0; i<=m; i++){
			for(int j=0; j<=n; j++){
				if(i == 0 || j == 0)
					arr[i][j] = 0;
				else if(s1.charAt(i-1) == s2.charAt(j-1)){
					arr[i][j] = arr[i-1][j-1] + 1;
					maxLen = max(maxLen, arr[i][j]);
				} else{
					arr[i][j] = 0;
				}
			}
		}
		
		return maxLen;
	}
	
	public static void main(String args[]){
		String s1 = "GeeksForGeeksLuckyGeeks";
		String s2 = "ForGeeksLuckyGeek";
		LongestCommonSubstring obj =  new LongestCommonSubstring();
		System.out.println("Longest common substring in '" + s1 + "' and '" + s2 + "' is:");
		System.out.println(obj.findLongestCommonSubstring(s1.toLowerCase(), s2.toLowerCase()));
	}

}

