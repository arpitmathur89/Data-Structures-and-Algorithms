package string;

import java.util.ArrayList;
import java.util.List;

public class GenerateCombinations {

    public static void main(String[] args) {

        List<String> a1 = new ArrayList<>();
        a1.add("a");
        a1.add("b");
        List<String> b1 = new ArrayList<>();
        b1.add("x");
        b1.add("z");
        List<String> c1 = new ArrayList<>();
        c1.add("m");
        c1.add("n");
        List<List<String>> input = new ArrayList<>();
        input.add(a1);
        input.add(b1);
        input.add(c1);

        List<List<String>> res = getCombinations(input);
        System.out.println(res);
    }

    public static List<List<String>> getCombinations(List<List<String>> input){

        List<List<String>> res = new ArrayList<>();
        res.add(new ArrayList<>());

        for(int i=0; i<input.size();i++){

            List<List<String>> tempstr = new ArrayList<>();

            List<String> str = input.get(i);

            for(int j=0;j<str.size();j++){
                for(int k=0;k<res.size();k++) {
                    List<String> s = new ArrayList<>(res.get(k));
                    s.add(str.get(j));
                    tempstr.add(tempstr.size(),s);
                }
            }

            res = tempstr;
        }

        return res;
    }
}
