import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Map_TreeMapTest {
    public static void main(String[] args){
        TreeMap<Integer, String> tmap = new TreeMap<Integer, String>();

        //TreeMap에 키값과 스트링값을 설정
        tmap.put(1, "Data1");
        tmap.put(23, "Data2");
        tmap.put(70, "Data3");
        tmap.put(4, "Data4");
        tmap.put(2, "Data5");

        Set set = tmap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry mentry = (Map.Entry)iterator.next();
            System.out.print("키값은 " + mentry.getKey() + " 해당 값은 ");
            System.out.println(mentry.getValue());
        }
        //키값이 순서대로 정렬되어 갖고오게된다.
    }
    
}
