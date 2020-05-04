package algorithms;

public class ZigZagConversion {
	 public String convert(String s, int numRows) {
	     // edge case
		 if(s== null || s.length()==0||numRows <=1) return s;
		 StringBuilder[] sbs =  new StringBuilder[numRows];
	     // 初始化 数组
		 for(int i =0; i<numRows; i++) {
	    	 sbs[i] = new StringBuilder();
	     }
		 int index =0;
		 int direction = 1;
		 for(char c:s.toCharArray()) {
			 sbs[index].append(c);
			 index+=direction;// 改变方向
			 if(index == 0|| index == numRows-1) direction=-direction;
		 }
		 String res="";
		 for(StringBuilder sb:sbs) {
			 res+=sb.toString();
		 }
	     return res;
		 
	    }
	 public static void main(String[] args) {
		ZigZagConversion zzConversion= new ZigZagConversion();
		System.out.println(zzConversion.convert("LEETCODEISHIRING", 3));
	}
}
