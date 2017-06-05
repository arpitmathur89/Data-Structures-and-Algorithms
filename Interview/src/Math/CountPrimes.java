package Math;

public class CountPrimes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(countPrimes(15));
		System.out.println(alternate(15));
	}
	
	public static int countPrimes(int n) {
        // Sieve of Eratosthenes
		boolean[] isPrime = new boolean[n];
		int count = 0;
		for(int i=0;i<n;i++){
			isPrime[i] = true;
		}
		
		for(int i=2;i*i<n;i++){
			if(!isPrime[i])
				continue;
			for(int j = i*i;j<n;j+=i){
				isPrime[j] = false;
			}
		}
		
		for(int i=2;i<n;i++){
			if(isPrime[i])
				count++;
		}
		return count;
	}
	
	// Alternate Method for Sieve of Eratosthenes
	
	public static int alternate(int n){
		boolean[] notPrime = new boolean[n];
		int count = 0;
		for(int i=2;i<n;i++){
			if(notPrime[i] == false){
				count++;
				if(i*i<n){
					for(int j=2;i*j<n;j++){
						notPrime[i*j] = true;
					}
				}
			}
		}
		return count;
	}
}
