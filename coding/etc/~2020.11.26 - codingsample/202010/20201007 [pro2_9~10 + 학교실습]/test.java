import java.util.ArrayList;

import java.util.*;
public class test {
    public static void main(String[] args){
        List<String> a = new ArrayList<String>();
        a.add("a");
        a.add("b");
        a.add("c");
        a.add(0,"g");
        String[] test = new String[a.size()];
        for(int i=0;i<a.size();i++) test[i] = a.get(i);
        System.out.println(Arrays.toString(test));
    }
    
}
