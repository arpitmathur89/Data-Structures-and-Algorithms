package string;

public class StringToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(myAtoi("-78sa89"));
	}
	
	public static int myAtoi(String str) {
		if(str == null || str.length() == 0)
			return 0;
		int res = 0;
		str.trim();  // Remove leading and trailing spaces
		boolean sign = false;
		for(int i=0;i<str.length();i++){
			if(i == 0){
				if(str.charAt(i) == '-'){
					sign = true;
					continue;
				}
				else if(str.charAt(i) == '+'){
					continue;
				}
			}
		
			int rem = str.charAt(i) - '0';
			if(rem < 0 || rem > 9){    // If the input chars are not digits, break
				break;
			}
			
			// If the String is greater then Integer.MAX_VALUE, return MAX_VALUE or
			//Min value depending upon sign
			if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE && rem > 7)){
				if(sign)
					return Integer.MIN_VALUE;
				else
					return Integer.MAX_VALUE;
			}
			
			res = res*10 + rem;
		}
		
		return res = (sign == true ? res*-1 : res);
	}

}
