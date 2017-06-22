package backtracking;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

/**
 * Created by arpit on 6/21/2017.
 */
public class MultisetSubSet {

    public static void main(String[] args) {
        String[] res = multiSet_subset("apple,apple,banana");
        for(String s: res){
            System.out.println(s);
        }
    }

    public static String[] multiSet_subset(String multiset){
        List<String> nums = Arrays.asList(multiset.split(","));
        List<List<String>> allSubsets = new ArrayList<>();
        Collections.sort(nums);
        backtrack(allSubsets,nums,new ArrayList<>(),0);
        Set<List<String>> hs = new HashSet<>();
        hs.addAll(allSubsets);
        allSubsets.clear();
        allSubsets.addAll(hs);
        String[] res = new String[allSubsets.size()];
        for(int i=0;i<allSubsets.size();i++){
            List<String> temp = allSubsets.get(i);
            StringBuilder sb = new StringBuilder();
            String prefix = "";
            for(String s: temp){
                sb.append(prefix);
                prefix = ",";
                sb.append(s);
            }
            res[i] = sb.toString();
        }
        return res;

    }


    public static void backtrack(List<List<String>> allSubsets, List<String> nums, List<String> templist, int start){
        allSubsets.add(new ArrayList<String>(templist));
        for(int i=start;i<nums.size();i++){
            templist.add(nums.get(i));
            backtrack(allSubsets,nums,templist,i+1);
            templist.remove(templist.size()-1);
        }
    }

}
