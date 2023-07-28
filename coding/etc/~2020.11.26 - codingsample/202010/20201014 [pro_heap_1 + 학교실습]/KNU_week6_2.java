import java.util.*;
public class KNU_week6_2 {
    
    public static void main(String[] args){

        PriorityQueue<Item> item = new PriorityQueue<Item>();
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        for(int i=0;i<Case;i++){
            String name = sc.next();
            int price = sc.nextInt();
            String day = sc.next();
            StringBuilder temp = new StringBuilder(day);
            int a = Integer.parseInt(temp.substring(0, temp.indexOf("/")));
            temp.delete(0 , temp.indexOf("/")+1);
            int b = Integer.parseInt(temp.substring(0, temp.indexOf("/")));
            temp.delete(0 , temp.indexOf("/")+1);
            int c = Integer.parseInt(temp.substring(0, temp.length()));
            if(a> 2018 || (a==2018 && b> 10) || (a==2018 && b ==10 && c >= 24)) {
                item.offer(new Item(name,price,day));
            }
        }
        while(!item.isEmpty()){
            System.out.println(item.poll().getS());
        }

    }
    static class Item implements Comparable<Item> {
        private String name; 
        private int price;
        private String day;

        Item(String n,int p, String d){
            this.name = n;
            this.price = p;
            this.day = d;
        }
        public String getS(){
            StringBuilder temp = new StringBuilder(this.day);
            int a = Integer.parseInt(temp.substring(0, temp.indexOf("/")));
            temp.delete(0 , temp.indexOf("/")+1);
            int b = Integer.parseInt(temp.substring(0, temp.indexOf("/")));
            temp.delete(0 , temp.indexOf("/")+1);
            int c = Integer.parseInt(temp.substring(0, temp.length()));
            return name+" "+price+" "+a+"/"+b+"/"+c;
        }

        @Override
        public int compareTo(Item I) {
            if(this.name.equals(I.name)){
                if(this.price == I.price) {
                    StringBuilder tempT = new StringBuilder(this.day);
                    int Ta = Integer.parseInt(tempT.substring(0, tempT.indexOf("/")));
                    tempT.delete(0 , tempT.indexOf("/")+1);
                    int Tb = Integer.parseInt(tempT.substring(0, tempT.indexOf("/")));
                    tempT.delete(0 , tempT.indexOf("/")+1);
                    int Tc = Integer.parseInt(tempT.substring(0, tempT.length()));

                    StringBuilder tempI = new StringBuilder(I.day);
                    int Ia = Integer.parseInt(tempI.substring(0, tempI.indexOf("/")));
                    tempI.delete(0 , tempI.indexOf("/")+1);
                    int Ib = Integer.parseInt(tempI.substring(0, tempI.indexOf("/")));
                    tempI.delete(0 , tempI.indexOf("/")+1);
                    int Ic = Integer.parseInt(tempI.substring(0, tempI.length()));

                    Calendar TC = Calendar.getInstance();
                    Calendar IC = Calendar.getInstance();
                    TC.set(Calendar.YEAR, Ta);
                    TC.set(Calendar.MONTH, Tb);
                    TC.set(Calendar.DATE, Tc);
                    IC.set(Calendar.YEAR, Ia);
                    IC.set(Calendar.MONTH, Ib);
                    IC.set(Calendar.DATE, Ic);
                    return TC.compareTo(IC);


                }
                else return this.price > I.price ? -1 : 1;
            }
            else return this.name.compareTo(I.name);
        }
        
    }
}
