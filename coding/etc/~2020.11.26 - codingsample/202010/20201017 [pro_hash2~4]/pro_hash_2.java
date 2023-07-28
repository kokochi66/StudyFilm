import java.util.*;
public class pro_hash_2 {
    //https://programmers.co.kr/learn/courses/30/lessons/42577
    public static boolean solution(String[] phone_book) {
        // 배열의 길이가 100만임 => n^2연산을 사용할 수 없는 문제임.
        // String은 연산이 오래걸림 => StringBuilder를 이용해서 속도 높이기
        
        // 1) Stringbuilder를 저장할 HashSet을 만듦
        // 2) 각 문자열들의 길이를 저장할 리스트를 만듦
        // 값을 먼저 정렬해주고 루프를 돌아야 함(순서에 맞게)
        
        // - 배열 루프를 돈다
        // 1. 현재 문자열을 StringBuilder로 만들어준다
        // 2. 리스트 길이만큼 반복하며 스트링빌더의 부분문자열들이 집합에 포함되어있는지를 확인
        // 2-1. 포함된다면 false 반환
        // 2-2 포함되지 않으면 집합에 현재 문자열을 넣고 반복
        // 3. 끝까지 가도 포함값이 없으면 true 반환
        HashSet<String> set = new HashSet<String>();
        ArrayList<Integer> lenList = new ArrayList<Integer>();
        Arrays.sort(phone_book ,new Comparator<String>() {
            @Override
            public int compare(String s1, String s2){
                return s1.length() - s2.length();
            }
        });
        for(int i=0;i<phone_book.length;i++){
            StringBuilder temp = new StringBuilder(phone_book[i]);
            for(int j=0;j<lenList.size();j++){
                if(temp.length() >= lenList.get(j)) {
                    if(set.contains(temp.substring(0, lenList.get(j)))) return false;
                }
            }
            set.add(temp.toString());
            if(!lenList.contains(temp.length())) lenList.add(temp.length());
        }
        
        return true;
    }
}
