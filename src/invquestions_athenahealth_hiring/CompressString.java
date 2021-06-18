package invquestions_athenahealth_hiring;

public class CompressString {

	
	public static void main(String args[]) {
		
		compressStr("3A4B7D");
		
	}
	
	private static void compressStr(String  s) {
		StringBuffer sb = new StringBuffer();
//		3A4B7D
		for(int i=0;i<s.length()-1;i++){
			Character number = s.charAt(i);
			int j = i+1;
			Character next = s.charAt(j);
			if(isNumber(number.toString())) {
				sb.append(repeatString(next.toString(),Character.getNumericValue(number)));
			}
		}
		
		System.out.println("return: "+sb.toString());
	}
	
	private static StringBuffer repeatString(String s, int n) {
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<n;i++) {
			sb  =  sb.append(s);
		}
		return sb;
	}
	
	private static boolean isNumber(String c) {
       String number = "0123456789";
       if(number.contains(c)) {
    	   return true;
       }else return false;
		
	}
}
