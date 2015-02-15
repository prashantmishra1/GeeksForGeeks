package geeks.array;

import java.util.HashMap;
import java.util.Stack;

public class Anagrams {
	HashMap<Character, Integer> charToPrime;
	HashMap<String, Integer> hashValue;
	HashMap<Integer, Stack<String>> anagrams;
	
	public Anagrams(){
		charToPrime = new HashMap<Character, Integer>();
		hashValue = new HashMap<String, Integer>();
		anagrams = new HashMap<Integer, Stack<String>>();
	}
	
	public void matchPrimeToChars(){
		int  k = 2;
		char ch = 'a';
		while(ch <= 'z'){
			if(isPrime(k)){
				charToPrime.put(ch, k);
				ch++;
			}
			k++;
		}
		
		printPrimeToChars();
	}
	
	public boolean isPrime(int n){
		for(int x = 2; x <= n/2; x++){
			if(n%x == 0)
				return false;
		}
		return true;
	}
	
	public void preProcessing(String ar[]){
		matchPrimeToChars();
		for (String s : ar) {
			s = s.toLowerCase();
			int score = findHashScore(s);
			hashValue.put(s, score);
			if(anagrams.containsKey(score)){
				anagrams.get(score).push(s);
			}else{
				Stack<String> st = new Stack<String>();
				st.push(s);
				anagrams.put(score, st);
			}
		}
	}
	
	public int findHashScore(String s){
		int score = 1;
		for(int x = 0; x < s.length(); x++){
			score = score * (charToPrime.get(s.charAt(x)));
		}
		
		return score;
	}
	
	public void printPrimeToChars(){
		char ch = 'a';
		while(ch <= 'z')
			System.out.println(ch + ":" + charToPrime.get(ch++));
	}
	
	public void printAnagrams(){
		for(int score : anagrams.keySet()){
			System.out.println(anagrams.get(score).toString());
		}
	}
	
	public static void main(String args[]){
		Anagrams obj = new Anagrams();
		String ar[] = {"car", "mat", "race", "rac", "arc", "rca", "reca", "tam", "aab", "ccb"};
		obj.preProcessing(ar);
		obj.printAnagrams();
	}

}

