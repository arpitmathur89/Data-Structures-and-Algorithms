package array;
import java.util.*;

public class AmazonRecommendation {
	
	public static class Pair<F,S> {
		
		public Pair(F first, S second){
			this.first = first;
			this.second = second;
		}
		
		private F first;
		private S second;
		
		public F getFirst() {
			return first;
		}
		public void setFirst(F first) {
			this.first = first;
		}
		public S getSecond() {
			return second;
		}
		public void setSecond(S second) {
			this.second = second;
		}
		
		@Override
		public String toString(){
			return "first: " + this.first.toString() + "second :" + this.second.toString(); 
		}
		
		
	}
	
	private static ArrayList<String> solve(ArrayList<Pair<String,String>> itemAssociation){
		
		ArrayList<String> itemGroups = new ArrayList<>();
		
		//My Code
		
		HashMap<String,String> hmap =  new HashMap<String,String>();
		for(int i=0;i<itemAssociation.size();i++){			
			hmap.put(itemAssociation.get(i).getFirst(), itemAssociation.get(i).getSecond());	
		}
		
		
		for(Map.Entry<String,String> entry: hmap.entrySet()){
			ArrayList<String> tempGroups = new ArrayList<>();
			String k = entry.getKey();
			String v = entry.getValue();
			tempGroups.add(k);
			tempGroups.add(v);
			while(hmap.containsKey(v)){
				String newval = hmap.get(v);
				tempGroups.add(newval);
				v = newval;
			}
			if(tempGroups.size() > itemGroups.size()){
				itemGroups = tempGroups;
			}else if(tempGroups.size() == itemGroups.size()){
				
				if( tempGroups.get(0).compareTo(itemGroups.get(0)) < 0){
					itemGroups = tempGroups;
				}				
			}
		}
		
		return itemGroups;
		
	}
	
	public static void main(String[] args) {
		ArrayList<Pair<String,String>> itemAssociation = new ArrayList<>();
		Scanner in = new Scanner(System.in);
		int numAssociation = in.nextInt();
		while(numAssociation-- > 0){
			itemAssociation.add(new Pair<String,String>(in.next(),in.next()));
		}
		
		ArrayList<String> res = solve(itemAssociation);
		System.out.println(res);
		
		in.close();
	}

}
