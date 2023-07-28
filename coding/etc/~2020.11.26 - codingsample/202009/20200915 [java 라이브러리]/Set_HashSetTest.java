import java.util.HashSet;
import java.util.Iterator;

public class Set_HashSetTest {
    public static void main(String[] args){
        HashSet<Integer> s = new HashSet<Integer>();

        s.add(1);
        s.add(2);
        s.add(3);
        s.add(4);
        s.add(5);
        System.out.println("3을 포함 = " + s.contains(3));
        s.remove(3);
        System.out.println("3 제거 후 포함 =" + s.contains(3));
        System.out.println("사이즈 = " + s.size());

        Iterator iter = s.iterator();
        while(iter.hasNext()) System.out.println("Iterator를 이용한 값꺼내기 = " + iter.next() + " ");

        s.clear();
        System.out.println("비었는지체크 = " + s.isEmpty());
    }
    
}
