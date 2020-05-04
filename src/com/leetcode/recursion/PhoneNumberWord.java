package com.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;


public class PhoneNumberWord {
	    String []alphabetas = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	    List<String>res = new ArrayList<String>();
	    public List<String> letterCombinations(String digits) {
	        // 每个 数字分开 
	        // 每个数字对应的三个字母存下来。
	    	
	    	if(digits== null || digits.length()==0) {
	    		return res;
	    	}
	    	iterString(digits,"",0);
	    	return res;

	    }
	    private void iterString(String digits,String letters,int index) {
	    	if(index == digits.length()) {
	    		res.add(letters);
	    	}
	    	
	    	char c =digits.charAt(index);
	    	int currDigit = c-'0';
	    	String alphaBeta=alphabetas[currDigit];
	    	for(int i =0; i<alphaBeta.length();i++) {
	    		//每个 letters 都是新的
	    		iterString(digits, letters+alphaBeta.charAt(i), index+1);
	    	}
	    }
	
}
