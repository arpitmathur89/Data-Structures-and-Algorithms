package Math;
/*
 * Multiply two integers without using multiplication, division and bitwise operators,
 *  and no loops
 * */
public class MultiplyNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(multiply(11,8));
	}
	
	//Russian Peasant (Bitwise Approach)
	/*
	 * Let the two given numbers be 'a' and 'b'
		1) Initialize result 'res' as 0.
		2) Do following while 'b' is greater than 0
		   a) If 'b' is odd, add 'a' to 'res'
		   b) Double 'a' and halve 'b'
		3) Return 'res'.
	 * 
	 * */
	
	public static int multiply(int a, int b){
		int res = 0;
		while(b > 0){
			if(b%2 == 1){
				res = res + a;
			}
			a<<=1;
			b>>=1;
		}
		return res;
	}
	
}
