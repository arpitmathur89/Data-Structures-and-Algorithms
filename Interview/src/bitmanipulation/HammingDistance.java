package bitmanipulation;
/*
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

Given two integers x and y, calculate the Hamming distance.
 * 
 * Input: x = 1, y = 4

Output: 2

Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑

The above arrows point to positions where the corresponding bits are different.
 */
public class HammingDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(HammingWeight(1,4));
	}
	
	public static int HammingWeight(int x, int y){
		int count = 0;
		int c = x^y;
		while(c>0){
			if((c&1)== 1)
				count++;
			c = c >> 1;
		}
		return count;
	}
	
}
