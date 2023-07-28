package Y2021.M03.D01;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution();
	}
	public static void solution() throws Exception {
		ArrayList<ArrayList<Integer>> Gears = new ArrayList<>();
		for(int i=0;i<4;i++) {
			Gears.add(new ArrayList<Integer>());
			String str = rd.readLine();
			for(int j=0;j<8;j++) Gears.get(i).add(str.charAt(j)- '0');
		}
		
		int n = Integer.parseInt(rd.readLine());
		int res = 0;
		for(int i=0;i<n;i++) {
			tok = new StringTokenizer(rd.readLine());
			int gearNum = Integer.parseInt(tok.nextToken());
			int rot = Integer.parseInt(tok.nextToken());
			checkGear(false, gearNum-2, Gears, rot == 1 ? false : true);
			checkGear(true, gearNum, Gears, rot == 1 ? false : true);
			if(rot == 1) {
				Gears.get(gearNum-1).add(0,Gears.get(gearNum-1).get(7));
				Gears.get(gearNum-1).remove(8);
			}
			else {
				Gears.get(gearNum-1).add(Gears.get(gearNum-1).get(0));
				Gears.get(gearNum-1).remove(0);
			}
//			for(int q=0;q<4;q++) {
//				for(int w=0;w<Gears.get(q).size();w++) System.out.print(Gears.get(q).get(w) +" ");
//				System.out.println();
//			}
//			System.out.println();
		}
		for(int j=0;j<4;j++) if(Gears.get(j).get(0) == 1) {
			res += Math.pow(2, j);
		}
		System.out.println(res);
	}
	public static void checkGear(boolean dirc, int my, ArrayList<ArrayList<Integer>> Gear, boolean rot) {
		if(my<0 || my>=4) return;
		boolean gotoRot = false;
		if(dirc && Gear.get(my-1).get(2) != Gear.get(my).get(6)) {
			checkGear(dirc,my+1,Gear, !rot);
			gotoRot= true;
		}
		else if(!dirc && Gear.get(my+1).get(6) != Gear.get(my).get(2)) {
			checkGear(dirc,my-1,Gear, !rot);
			gotoRot = true;
		}
		if(gotoRot && rot) {
			Gear.get(my).add(0,Gear.get(my).get(7));
			Gear.get(my).remove(Gear.get(my).size()-1);
		}
		else if(gotoRot && !rot) {
			Gear.get(my).add(Gear.get(my).get(0));
			Gear.get(my).remove(0);
		}
	}
}