package array;

import java.util.*;

/**
 * Created by arpit on 6/23/2017.
 */
/*
Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 */
public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums ={1,1,1,3,3,3,2,2,2,5,5,4,4,4,7,7,7,7};
        System.out.println(topKFrequent(nums,2));

        System.out.println(topKFrequentAlt(nums,2));
    }

    // Solution using TreeMap --  Poll the last elememnt from TreeMap using pollLastEntry function
    public static List<Integer> topKFrequent(int[] nums, int k) {

        HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
        for(int n : nums){
            hmap.put(n, hmap.getOrDefault(n,0) +1);
        }

        TreeMap<Integer, List<Integer>> tmap = new TreeMap<Integer, List<Integer>>();

        for(int key : hmap.keySet()){
            int freq = hmap.get(key);
            if(!tmap.containsKey(freq)){
                tmap.put(freq,new ArrayList<Integer>());
            }
            tmap.get(freq).add(key);
        }

        List<Integer> res = new ArrayList<Integer>();
        while(res.size()<k){
            Map.Entry<Integer,List<Integer>> entry = tmap.pollLastEntry();
            res.addAll(entry.getValue());
        }
        return res.subList(0,k);
    }

    // Solution using Bucket sort
    public static List<Integer> topKFrequentAlt(int[] nums, int k) {

        HashMap<Integer, Integer> hmap = new HashMap<>();
        List<Integer>[] buckets = new List[nums.length +1];

        for(int n : nums){
            hmap.put(n, hmap.getOrDefault(n,0)+1);
        }

        for(int key: hmap.keySet()){
            int freq = hmap.get(key);
            if(buckets[freq] == null){
                buckets[freq] = new ArrayList<>();
            }
            buckets[freq].add(key);
        }

        List<Integer> res = new ArrayList<>();
        for(int i= buckets.length-1;i>=0 && res.size()<k;i--){
            if(buckets[i] != null){
                res.addAll(buckets[i]);
            }
        }
        return res.subList(0,k);

    }

}
