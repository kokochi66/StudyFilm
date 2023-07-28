import java.util.*;

public class KNU_week6_3 {
    public static void main(String[] args){
        PriorityQueue<Per> person = new PriorityQueue<Per>();
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for(int i=0;i<Case;i++){
            String name = sc.next();
            int age = sc.nextInt();
            person.offer(new Per(name,age,i));
        }
        while(!person.isEmpty()){
            System.out.println(person.poll().getS());
        }
    }

    static class Per implements Comparable<Per> {
        private String name; 
        private int age;
        private int order;

        Per(String s,int n, int o){
            this.name = s;
            this.age = n;
            this.order = o;
        }
        public String getS(){
            return name;
        }

        @Override
        public int compareTo(Per p) {
            return this.age < p.age ? 1 : this.age == p.age ? (this.order>p.order ? 1 : -1) : -1;
        }
        
    }
}
