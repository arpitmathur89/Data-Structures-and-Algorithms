package recursion;
import java.util.*;

/*
 * Given a dictionary, write a function to flatten it. Consider the following input/output
 * scenario for better understanding:
 * 
 * Sample Input :
  {
  'Key1': '1',
  'Key2': {
    'a' : '2',
    'b' : '3',
    'c' : {
      'd' : '3',
      'e' : '1'
      }
    }
}

Output :
{
  'Key1': '1',
  'Key2.a': '2',
  'Key2.b' : '3',
  'Key2.c.d' : '3',
  'Key2.c.e' : '1'
}
*
*
*
* */

public class FlattenDictionary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Object,Object> hmap = new HashMap<>();
		hmap.put("key1", '1');
		HashMap<String,Object> hmap1 = new HashMap<>();
		hmap1.put("a", '2');
		hmap1.put("b", '3');
		HashMap<String,Object> hmap2 = new HashMap<>();
		hmap2.put("d", '5');
		hmap2.put("e", '6');
		hmap1.put("c", hmap2);
		hmap.put("key2", hmap1);
		System.out.println(FlatDictionary(hmap));

	}

	public static HashMap<String,String> FlatDictionary(HashMap<Object,Object> dict){
		HashMap<String, String> result = new HashMap<>();
		dfs("",dict,result);
		return result;
	}
	
	public static void dfs(String initialkey,HashMap<?,?> dict,HashMap<String, String> result){
		for(Object key : dict.keySet()){
			if(!(dict.get(key) instanceof HashMap)){
				if(initialkey == null || initialkey == "")
					result.put(key.toString(), dict.get(key).toString());
				else
					result.put(initialkey + "." + key, dict.get(key).toString());
			}
			else{
				HashMap<?,?> temp = (HashMap<?, ?>) dict.get(key);
				 if (initialkey == null || initialkey == "")
				        dfs(key.toString(), temp, result);
			     else
				        dfs(initialkey + "." + key, temp, result);
			}
		}
	}
}
