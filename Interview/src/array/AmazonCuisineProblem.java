package array;
import java.util.*;


public class AmazonCuisineProblem {
	
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
			return  this.first.toString() + ":" + this.second.toString(); 
		}
		
		
	}

	public static void main(String[] args) {
		
		ArrayList<Pair<String, String>> lunchMenuPairs = new ArrayList<Pair<String, String>>();
		Pair<String, String> inner1 = new Pair<String, String>("Chole","Indian");
		lunchMenuPairs.add(inner1);
		Pair<String, String> inner2 = new Pair<String, String>("Chat","Indian");
		lunchMenuPairs.add(inner2);
		Pair<String, String> inner3 = new Pair<String, String>("Pasta","Italian");
		lunchMenuPairs.add(inner3);
		Pair<String, String> inner4 = new Pair<String, String>("Noodles","Chinese");
		lunchMenuPairs.add(inner4);
		Pair<String, String> inner5 = new Pair<String, String>("Manchurian","Chinese");
		lunchMenuPairs.add(inner5);

	
		ArrayList<Pair<String, String>> teamCuisinePreference = new ArrayList<Pair<String, String>>();
		
		Pair<String, String> sublst1 = new Pair<String, String>("Arpit","Indian");
		teamCuisinePreference.add(sublst1);
		
		Pair<String, String> sublst2 = new Pair<String, String>("Arpit","Chinese");
		teamCuisinePreference.add(sublst2);
		
		Pair<String, String> sublst3 = new Pair<String, String>("Vimarsh","Italian");
		teamCuisinePreference.add(sublst3);
		
		Pair<String, String> sublst4 = new Pair<String, String>("Mishra","*");
		teamCuisinePreference.add(sublst4);
		
		Pair<String, String> sublst5 = new Pair<String, String>("Harish","Thai");
		teamCuisinePreference.add(sublst5);
		
		System.out.println(generatePairs(lunchMenuPairs,teamCuisinePreference));
		
	}
	
	public static ArrayList<Pair<String,String>> generatePairs(ArrayList<Pair<String, String>> lunchMenuPairs, ArrayList<Pair<String, String>> teamCuisinePreference){
		
		ArrayList<Pair<String, String>> finalList = new ArrayList<Pair<String, String>>();
		
		List<String> allLunch = new ArrayList<String>();
		
		HashMap<String, List<String>> hmap = new HashMap<>();
		
		for(Pair<String,String> lunchPair : lunchMenuPairs){
			allLunch.add(lunchPair.getFirst());
			if(hmap.containsKey(lunchPair.getSecond())){
				List<String> temp = hmap.get(lunchPair.getSecond());
				temp.add(lunchPair.getFirst());
				hmap.put(lunchPair.getSecond(), temp);
			}
			else{
				List<String> temp = new ArrayList<String>();
				temp.add(lunchPair.getFirst());
				hmap.put(lunchPair.getSecond(), temp);
			}
		}
		
		hmap.put("*", allLunch);
		
		for(Pair<String,String> TeamPair : teamCuisinePreference){
				if(hmap.containsKey(TeamPair.getSecond())){
					List<String> lunches = hmap.get(TeamPair.getSecond());
					for(String lunch: lunches){
						Pair<String,String> teamlunch = new Pair<String, String>(TeamPair.getFirst(),lunch);
						finalList.add(teamlunch);					
					}
				}
			}
				
		return finalList;
	}

/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<String>> lunchMenuPairs = new ArrayList<ArrayList<String>>();
		ArrayList<String> inner1 = new ArrayList<String>();
		inner1.add("Pizza");
		inner1.add("Italian");
		lunchMenuPairs.add(inner1);
		ArrayList<String> inner2 = new ArrayList<String>();
		inner2.add("Curry");
		inner2.add("Indian");
		lunchMenuPairs.add(inner2);
		ArrayList<String> inner3 = new ArrayList<String>();
		inner3.add("Masala");
		inner3.add("Indian");
		lunchMenuPairs.add(inner3);
		
		ArrayList<ArrayList<String>> teamCuisinePreference = new ArrayList<ArrayList<String>>();
		ArrayList<String> sublst1 = new ArrayList<String>();
		sublst1.add("Jose");
		sublst1.add("Italian");
		teamCuisinePreference.add(sublst1);
		ArrayList<String> sublst2 = new ArrayList<String>();
		sublst2.add("John");
		sublst2.add("Indian");
		teamCuisinePreference.add(sublst2);
		ArrayList<String> sublst3 = new ArrayList<String>();
		sublst3.add("Jenny");
		sublst3.add("Thai");
		teamCuisinePreference.add(sublst3);
		ArrayList<String> sublst4 = new ArrayList<String>();
		sublst4.add("Arpit");
		sublst4.add("*");
		teamCuisinePreference.add(sublst4);
		
		System.out.println(generatePairs(lunchMenuPairs,teamCuisinePreference));
		
	}
	
	public static ArrayList<ArrayList<String>> generatePairs(ArrayList<ArrayList<String>> lunchMenuPairs, ArrayList<ArrayList<String>> teamCuisinePreference){
		ArrayList<ArrayList<String>> finalList = new ArrayList<ArrayList<String>>();
		ArrayList<String> AllLunch = new ArrayList<String>();
		HashMap<String,ArrayList<String>> hmap = new HashMap<>();
		
		for(ArrayList<String> lunchPair : lunchMenuPairs){
			AllLunch.add(lunchPair.get(0));
			if(hmap.containsKey(lunchPair.get(1))){
				ArrayList<String> temp = hmap.get(lunchPair.get(1));
				temp.add(lunchPair.get(0));
				hmap.put(lunchPair.get(1), temp);
			}
			else{
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(lunchPair.get(0));
				hmap.put(lunchPair.get(1), temp);
			}
		}
		
		for(ArrayList<String> TeamPair : teamCuisinePreference){
			if(TeamPair.get(1).equals("*")){
				for(String lunch : AllLunch){
					ArrayList<String> teamlunch = new ArrayList<>();
					teamlunch.add(TeamPair.get(0));
					teamlunch.add(lunch);
					finalList.add(teamlunch);
				}
			}else{
				if(hmap.containsKey(TeamPair.get(1))){
					ArrayList<String> lunches = hmap.get(TeamPair.get(1));
					for(String lunch: lunches){
						ArrayList<String> teamlunch = new ArrayList<>();
						teamlunch.add(TeamPair.get(0));
						teamlunch.add(lunch);
						finalList.add(teamlunch);					
					}
				}
			}
		}
		
		
		
		return finalList;
	}
	*/	

}
