import java.util.Arrays;

public class pro_Heap_1 {
    // https://programmers.co.kr/learn/courses/30/lessons/42626
    // 배열의 크기가 100만이므로, 배열 내부적으로 연산을 적용하는 최소힙문제로 풀이할 수 있음.
    // 최소값과 그다음 최소값의 합이 반드시 최소로 이어질 보장이 없음 => 새 값이 추가될 때마다 새로운 정렬이 필요할 수 있음.
    // 힙의 자체적인 추가와 삭제는 최악 Log n만큼의 연산이 필요함.
    // Log 1000000 = 약 20이며, 길이가 100만인 배열이 모두 최악의 연산이 이루어진다면 2천만연산이 이루어질것임
    // 때문에 자체적으로 배열 정렬 후에 K이상의 값을 하나만 남겨놓을 필요가 있음 (연산 최소화를 위함)
    public static int solution(int[] scoville, int K) {
        // 힙 구현을 scoville 배열 내부적으로 진행함. 최초 루트를 0으로 잡기때문에, +1 후에 *2, /2 연산 후 다시 -1을 해주는 방식으로 적용하는것이 필요.
        // 그러나 이번에는 계산의 편의를 위해서, ArrayCopy를 사용하겠음.
        
        
        Arrays.sort(scoville);
        // 배열자체적으로 정렬하여 정렬된 힙 상태로 만듦
        int[] copy = new int[scoville.length+1];
        System.arraycopy(scoville, 0, copy, 1, scoville.length);
        int count = 0;
        // scoville보다 1 크기가 더 큰 배열을 만들어, 해당 값에 배열을 붙여줌 이를 통해 +1, -1 연산을 재차적으로 안해줘도됨.
        // 배열의 크기가 더 클 필요가 없는게, 어차피 2값이 삭제되고 1개값이 추가되는 형식이기 때문에, 배열의 크기가 늘어날 일이 없음.


        boolean check = false;
        // check 불리언 변수는 K보다 큰 값이 힙 내부에 딱 한개만 남아있으면 충분하므로 (두개 이상은 이미 K가 넘어가기 때문에 의미가 없음) 이상값이 생겼는지를 체크하는 함수임.


        int size = copy.length-1;
        // 리스트가 아닌 배열에 힙을 구현하고 있기 때문에, 현재 힙의 최대치가 어느 위치인지를 확인할 필요가 있음.


        while(copy[1] < K && size>=1){
            // 반복문은 최소힙의 루트값이 K보다 크거나 같으며, 힙의 크기가 2이상인 동안 진행한다.
            if(size==1) {
                if(check) return count+1;
                else return -1;
            }
            // 힙의 크기가 1이면 합칠 두 값이 없기 때문에, 해당 값이 K보다 작으면 -1을 리턴해야한다.
            // 여기서 check가 true라면 K보다 큰값 최소 한개 이상이 이미 배열로 들어가있는 형태이므로, count를 리턴하면 된다.
            count++;
            long temp = del(copy, size--);
            temp += (del(copy, size--)*2);
            System.out.println(Arrays.toString(copy) +"   "+ size +"  "+ temp);
            if(temp < K) add(copy, temp, size++);
            else if(!check) check = true;
        }


        return count;
    }
    public static long del(int[] s, int size) {
        // deletion구현
        int saveAs = s[1];
        s[1] = s[size];
        size--;

        int CurrV = s[1];
        int CurrS = 1;
        while(CurrS*2 <= size){
            int posS = CurrS*2;
            int posV = s[posS];
            if(posS+1 <= size && posV > s[posS+1]) {
                posS++;
                posV = s[posS];
            }
            if(posV > CurrV) return saveAs;
            s[posS] = CurrV;
            s[CurrS] = posV;
            CurrS = posS;
        }
        return saveAs;
    }
    public static void add(int[] s, long n, int size){
        //addition 구현
        size++;
        s[size] = (int)n;
        int CurrS = size;
        int CurrV = s[size];
        while(CurrS > 1 && CurrV < s[CurrS/2]){
            s[CurrS] = s[CurrS/2];
            s[CurrS/2] = CurrV;
            CurrS /=2;
        }
    }

    public static void main(String[] args){
        int[] a = {999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999,999999999};
        System.out.println(solution(a,1000000000));
    }
}
