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
	
    private static ArrayList<String> solve(ArrayList<Pair<String, String>> itemAssociation) {
        
        
        ArrayList<String> itemGroups = new ArrayList<>();
        
        HashMap<String,List<String>> hmap = new HashMap<String,List<String>>();
        for(int i=0;i<itemAssociation.size();i++){
            String first = itemAssociation.get(i).getFirst();
            String second = itemAssociation.get(i).getSecond();
            
            if(hmap.containsKey(first)){
                hmap.get(first).add(second);
            }
            else{
                List<String> temp_list = new ArrayList<>();
                temp_list.add(second);
                hmap.put(first, temp_list);
            }
        }
        
        for(Map.Entry<String,List<String>> entry : hmap.entrySet()){
            String k = entry.getKey();
            List<String> v = entry.getValue();
            
            for(int i=0; i<v.size(); i++){
                String s = v.get(i);
                if(hmap.containsKey(s)){
                    List<String> to_add_list = hmap.get(k);
                    to_add_list.addAll(hmap.get(s));
                    v = to_add_list;
                }    
            }
            
            List<Set<String>> result_list = new ArrayList<>();
            for(Map.Entry<String,List<String>> entry1 : hmap.entrySet()){
                String k1 = entry1.getKey();
                List<String> v1 = entry1.getValue();
                Set<String> temp_set = new HashSet<>();
                for(String s: v1){
                    temp_set.add(s);
                }
                temp_set.add(k1);
                result_list.add(temp_set);
            }
            int max = Integer.MIN_VALUE;
            for(Set<String> s: result_list){
                if(s.size() > max){
                    itemGroups = new ArrayList<>(s);
                    max = s.size();
                }
                else if(s.size() == max){
                    Collections.sort(itemGroups);
                    List<String> second_list = new ArrayList<>(s);
                    Collections.sort(second_list);
                    
                    for(int i=0; i<second_list.size(); i++){
                        if(itemGroups.get(i).compareTo(second_list.get(i))>0){
                            itemGroups = new ArrayList<>(second_list);
                            break;
                        }
                    }
                }
            }
        
    }
    
    return itemGroups;
    }
    
  //Possibly wrong solution (Not handling duplicates)
	
	private static ArrayList<String> solve2(ArrayList<Pair<String,String>> itemAssociation){
		
		ArrayList<String> itemGroups = new ArrayList<>();
		
		
		
		
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
		ArrayList<String> res2 = solve2(itemAssociation);
		System.out.println(res2);
		in.close();
	}

}
