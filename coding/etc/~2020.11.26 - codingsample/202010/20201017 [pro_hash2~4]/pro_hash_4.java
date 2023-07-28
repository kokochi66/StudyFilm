import java.util.*;

public class pro_hash_4 {
    // https://programmers.co.kr/learn/courses/30/lessons/42579
    // 배열에서 장르별로의 그루핑과, 우선순위 정렬이 필요함.
    // 해결책 1)
    // 배열을 돌면서,(n) 각 장르별로 1위와 2위 노래를 찾는다.
    // 각 장르의 순위를 비교하여 찾는다.
    // 이하 우선순위 큐를 통해서 정렬된 값을 배열로 뱉는다.
    // 총 개수에 대한 카운터 int 변수가 필요할듯.

    public static int[] solution(String[] genres, int[] plays) {
        // 1) Map으로 장르를 키로 설정, 
        PriorityQueue<solu> pick = new PriorityQueue<solu>();
        HashMap<String, solu> SaveMap = new HashMap<>();
        for(int i=0;i<genres.length;i++){
            if(!SaveMap.containsKey(genres[i])) {
                SaveMap.put(genres[i], new solu(genres[i],plays[i],i));
            }
            else {
                SaveMap.get(genres[i]).addsol(plays[i], i);
            }
        }
        Iterator<String> iter = SaveMap.keySet().iterator();
        int counter = 0;
        while(iter.hasNext()){
            solu temp = SaveMap.get(iter.next());
            if(temp.getSize()>=2) counter +=2;
            else counter +=1;
            temp.playSort();
            pick.add(temp);
        }
        int[] output = new int[counter];
        int outputNum = 0;
        while(!pick.isEmpty()){
            solu a = pick.poll();
            if(a.getSize()>=2) {
                output[outputNum++] = a.getSwit(a.getSize()-1);
                output[outputNum++] = a.getSwit(a.getSize()-2);
            }
            else output[outputNum++] = a.getSwit(a.getSize()-1);
        }
        return output;
    }

    static class solu implements Comparable<solu> {
        // solu 클래스는 각 장르 내부의 데이터를 갖고있는 클래스
        // key는 장르의 이름이며, play 리스트에는 각 노래의 위치값과 노래의 재생수를 저장하고 있다.
        // 비교연산의 편의를 위해서 playSum을 별도로 저장한다.
        private String key;
        private ArrayList<Integer[]> play = new ArrayList<Integer[]>();
        private int playSum;

        public solu(String k, int p, int s){
            this.key = k;
            this.play.add(new Integer[]{s,p});
            this.playSum = p;
        }
        public void addsol(int p, int s){
            // 같은 장르의 곡 추가시, Sum값을 늘리며 리스트에 값을 추가해준다.
            this.play.add(new Integer[]{s,p});
            this.playSum += p;
        }
        public void playSort(){
            // playSort 호출 시, 리스트를 입력된 Integer배열의 두번째 값을 중심으로 정렬시킨다.
            this.play.sort(new Comparator<Integer[]>(){
                @Override
                public int compare(Integer[] o1, Integer[] o2) {
                    if(o1[1] - o2[1] == 0){
                        return o1[0] > o2[0] ? -1 : 1;
                    }
                    return o1[1] - o2[1];
                }
                
            });
        }
        public int getSwit(int n){
            // 정렬된 상태로 끝 값의 swit 값을 뽑을 수 있게 한다.
            return this.play.get(n)[0];
        }
        public int getSize(){
            // 장르의 노래가 1개밖에 없는 경우를 산정하여 Size 함수를 정의한다.
            return this.play.size();
        }

		@Override
		public int compareTo(solu s) {
            // 각 장르별 정렬시에는, Sum값이 높은 값이 먼저 나오도록 한다.
			return this.playSum > s.playSum ? -1 : 1;
		}
    }
    public static void main(String[] args){
        String[] a = {"classic","classic"};
        int[] b = {500,500};
        System.out.println(Arrays.toString(solution(a, b)));
    }
}
