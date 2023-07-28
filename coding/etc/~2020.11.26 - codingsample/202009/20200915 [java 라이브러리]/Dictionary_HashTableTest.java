import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public class Dictionary_HashTableTest {
    public static void main(String[] args){
        Map<Integer, String> m = new Hashtable<Integer, String>();

        m.put(1, "가");
        m.put(2, "나");
        m.put(3, "다");
        m.put(4, "라");
        m.put(1, "마");

        System.out.println("get : " + m.get("1"));
        System.out.println("keyset : " + m.keySet());
        System.out.println("values : " + m.values());
        System.out.println("containsKey : " + m.containsKey("1"));
        System.out.println("containsValue : " + m.containsValue("가"));
        System.out.println("toString : " + m.toString());
        System.out.println();

        // keySet() 메서드 이용한 데이터 출력. 
        // 리턴타입이 Set 인터페이스라서 Set인터페이스에 집어넣음. 
        Set<Integer> keys=m.keySet();
        //신형 for문 : keys값을 모두 String key변수에 반복하여 넣는다.
        for(Integer key : keys){ 	
        System.out.println("Set을 이용한 반복 : " + key + "=" + m.get(key));
        }
    }
    
}
