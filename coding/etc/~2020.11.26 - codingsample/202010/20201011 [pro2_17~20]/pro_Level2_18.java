public class pro_Level2_18 {
    public static int Fact(int n){
        int sum = 1;
        while(n>1) sum *= n--;
        return sum;
    }
    public static int Comb(int n, int r){
        return Fact(n)/(Fact(n-r)*Fact(r));
    }
    public static int solution(String[][] clothes) {
        LinkedList<String> cloth = new LinkedList<String>();
        ArrayList<Integer> HaveNum = new ArrayList<Integer>();
        for(int i=0;i<clothes.length;i++){
            if(cloth.contains(clothes[i][1])) {
                int j = 0;
                while(!cloth.get(j).equals(clothes[i][1])) j++;
                HaveNum.set(j, HaveNum.get(j)+1);
            }
            else {
                cloth.add(clothes[i][1]);
                HaveNum.add(1);
            }
        }
        int sum = 0, tempProduct = 1;
        for(int i=0;i<HaveNum.size();i++){
            tempProduct *= (HaveNum.get(i)+1);
        }
        return tempProduct-1;
    }
}
