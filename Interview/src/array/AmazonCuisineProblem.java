package array;
import java.util.*;

public class AmazonCuisineProblem {

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
	
	

}
