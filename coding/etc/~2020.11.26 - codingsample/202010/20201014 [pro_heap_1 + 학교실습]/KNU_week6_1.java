import java.util.*;
import java.util.stream.IntStream;
public class KNU_week6_1 {
    public static void main(String[] args){
        PriorityQueue<Game> Ranking = new PriorityQueue<Game>();
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        String[] TeamName = new String[Case];


        for(int i=0;i<Case;i++) TeamName[i] = sc.next();
        int var1 = 1, var2 = 1, var3;
        for(int i=2;i<=Case;i++){
            var1 *= i;
            if(i<=Case-2) var2 *= i;
        }
        int round = var1/(var2*2);
        int[] winR = new int[Case];
        int[] winS = new int[Case];
        int[] defS = new int[Case];
        String[][] winList = new String[Case][Case-1];
        ArrayList<Integer> winListSwit = new ArrayList<Integer>();
        for(int i=0;i<Case;i++) {
            Arrays.fill(winList[i],"");
            winListSwit.add(0);
        }

        for(int i=0;i<round;i++){
            String team1 = sc.next();
            String score = sc.next();
            String[] ScoreToken = score.split(":");
            String team2 = sc.next();
            int teamSwit1 = 0, teamSwit2 = 0;
            for(int teamNum=0;teamNum<Case;teamNum++){
                if(TeamName[teamNum].equals(team1)) teamSwit1 = teamNum;
                else if(TeamName[teamNum].equals(team2)) teamSwit2 = teamNum;
            }
            int team1Score = Integer.parseInt(ScoreToken[0]);
            int team2Score = Integer.parseInt(ScoreToken[1]);

            if(team1Score>team2Score) {
                winR[teamSwit1]++;
                winList[teamSwit1][winListSwit.get(teamSwit1)] = team2;
                winListSwit.set(teamSwit1,winListSwit.get(teamSwit1)+1);
            }
            else {
                winR[teamSwit2]++;
                winList[teamSwit2][winListSwit.get(teamSwit2)] = team1;
                winListSwit.set(teamSwit2,winListSwit.get(teamSwit2)+1);
            }
            winS[teamSwit1] += team1Score;
            defS[teamSwit1] += team2Score;

            winS[teamSwit2] += team2Score;
            defS[teamSwit2] += team1Score;
        }
        for(int i=0;i<Case;i++){
            Ranking.offer(new Game(TeamName[i], winR[i], (Case-1)-winR[i], winS[i], defS[i], winList[i]));
        }
        int rank = 1;
        while(!Ranking.isEmpty()){
            System.out.println(rank+") "+Ranking.poll().getS());
            rank++;
        }

    }
    static class Game implements Comparable<Game> {
        private String name; 
        private int Win;
        private int Def;
        private int Wset;
        private int Dset;
        private String[] winList;

        Game(String n,int w, int d, int ws, int ds, String[] li){
            this.name = n;
            this.Win = w;
            this.Def = d;
            this.Wset = ws;
            this.Dset = ds;
            this.winList = li;
        }
        public String getS(){
            return this.name+" "+this.Win+" "+this.Def+" "+this.Wset+"-"+this.Dset+" "+(this.Wset-this.Dset);
        }

        @Override
        public int compareTo(Game I) {
            if(this.Win == I.Win ) {
                if((this.Wset - this.Dset) == (I.Wset - I.Dset)) {
                    for(int i=0;i<this.winList.length;i++){
                        if(this.winList[i].equals(I.name)) return -1;
                    }
                    return 1;
                }
                else return (this.Wset - this.Dset) > (I.Wset - I.Dset) ? -1 : 1;
            }
            else return this.Win > I.Win ? -1 : 1;
        }
        
    }
}
