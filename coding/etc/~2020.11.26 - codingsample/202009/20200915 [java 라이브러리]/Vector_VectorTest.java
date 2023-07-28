import java.util.Iterator;
import java.util.Vector;

public class Vector_VectorTest {
    public static void main(String[] args){
        Vector<Integer> v = new Vector<Integer>();
        v.add(5);       //벡터 끝자리에 값 넣기
        v.add(null);    //벡터에 null값 추가 가능
        v.add(1,10);    //벡터 특정위치에 값 넣기
        v.add(1);
        v.add(2);
        v.add(3);
        v.add(4);
        System.out.println("벡터값 하나 가져오기 = " + v.get(0));
        v.remove(0);    //벡터 값 삭제
        System.out.println("삭제 후 가져오기 = " + v.get(0));
        System.out.println("벡터의 물리적 크기 = " + v.capacity());
        //물리적 크기는 커지면 동기화되며 벡터의 사이즈에 따라 커짐.
        System.out.println("벡터의 사이즈 = " + v.size());
        Iterator iter = v.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
    
}
