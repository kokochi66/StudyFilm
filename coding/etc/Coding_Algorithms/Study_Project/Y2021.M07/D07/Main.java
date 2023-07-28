package D07;
import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer tok;
	public static void main(String[] args) throws Exception {
		solution(new String[] {
				"2016-09-15 20:59:57.421 0.351s",
				"2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s",
				"2016-09-15 20:59:58.688 1.041s",
				"2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s",
				"2016-09-15 21:00:00.741 1.581s",
				"2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s",
				"2016-09-15 21:00:02.066 2.62s",
		});
	}
    public static int solution(String[] lines) {
        int n = lines.length;
        Time[][] arr = new Time[n][2];
        for(int i=0;i<n;i++) {
        	arr[i][1] = new Time();
        	StringTokenizer tok = new StringTokenizer(lines[i]);
        	StringTokenizer toks = new StringTokenizer(tok.nextToken(),"-");
        	arr[i][1].setYear(Integer.parseInt(toks.nextToken()));
        	arr[i][1].setMon(Integer.parseInt(toks.nextToken()));
        	arr[i][1].setDay(Integer.parseInt(toks.nextToken()));
        	
        	toks = new StringTokenizer(tok.nextToken(),":");
        	arr[i][1].setHour(Integer.parseInt(toks.nextToken()));
        	arr[i][1].setMin(Integer.parseInt(toks.nextToken()));
        	arr[i][1].setSec(Double.parseDouble(toks.nextToken()));
        	
        	arr[i][0] = new Time(arr[i][1].year, arr[i][1].mon, arr[i][1].day, arr[i][1].hour, arr[i][1].min, arr[i][1].sec);
        	StringBuffer toSec = new StringBuffer(tok.nextToken());
        	toSec.deleteCharAt(toSec.length()-1);
        	arr[i][0].minusTime(Double.parseDouble(toSec.toString()) - 0.001);
//        	System.out.println(arr[i][0].toString() +"  ~~  "+arr[i][1].toString());
        }
        
        int maxCnt = 0;
        
        for(int i=0;i<n;i++) {
        	int leftCnt = 0, rightCnt = 0;
        	Time[] left = new Time[2];
        	left[0] = new Time(arr[i][0].year, arr[i][0].mon, arr[i][0].day, arr[i][0].hour, arr[i][0].min, arr[i][0].sec);
        	left[0].minusTime(0.999);
        	left[1] = new Time(arr[i][0].year, arr[i][0].mon, arr[i][0].day, arr[i][0].hour, arr[i][0].min, arr[i][0].sec);
        	
        	Time[] right = new Time[2];
        	right[0] = new Time(arr[i][1].year, arr[i][1].mon, arr[i][1].day, arr[i][1].hour, arr[i][1].min, arr[i][1].sec);
        	right[1] = new Time(arr[i][1].year, arr[i][1].mon, arr[i][1].day, arr[i][1].hour, arr[i][1].min, arr[i][1].sec);
        	right[1].setSec(right[1].getSec()+1);
        	right[1].minusTime(0.001);
        	
        	
        	for(int j=0;j<n;j++) {
        		if(arr[j][1].isBigTime(left[0]) && left[1].isBigTime(arr[j][0])) {
        			leftCnt++; 
        		
        		}
        		if(arr[j][1].isBigTime(right[0]) && right[1].isBigTime(arr[j][0])) {
        			rightCnt++; 
        		}
        	}
//        	System.out.println(i +" "+ leftCnt +" "+rightCnt);
//        	System.out.println("left = "+left[0].toString()+" ~~ "+left[1].toString());
//        	System.out.println("right = "+right[0].toString()+" ~~ "+right[1].toString());
        	
        	if(maxCnt < leftCnt) maxCnt = leftCnt;
        	if(maxCnt < rightCnt) maxCnt = rightCnt;
        	
        }
        
        
        
        return maxCnt;
    }
 
    
    static class Time {
    	int year;
    	int mon;
    	int day;
    	int hour;
    	int min;
    	double sec;
    	
    	public Time() {
    		
    	}
    	
		public Time(int year, int mon, int day, int hour, int min, double sec) {
			this.year = year;
			this.mon = mon;
			this.day = day;
			this.hour = hour;
			this.min = min;
			this.sec = sec;
		}
		
		public void minusTime(double toSec) {
			this.sec -= toSec;
			if(this.sec < 0) {
				this.sec = 60 + this.sec;
				this.min -= 1;
			}
			
			if(this.min < 0) {
				this.min = 60 + this.min;
				this.hour -= 1;
			}
			if(this.hour < 0) {
				this.hour = 24 + this.hour;
				this.day -= 1;
			}
		}
		
		public boolean isBigTime(Time next) {
	    	if(this.year > next.year) return true;
	    	else if(this.year == next.year) {
	    		if(this.mon > next.year) return true;
	    		else if (this.mon == next.mon) {
	    			if(this.day > next.day) return true;
	    			else if(this.day == next.day) {
	    				if(this.hour > next.hour) return true;
	    				else if(this.hour == next.hour) {
	    					if(this.min > next.min) return true;
	    					else if(this.min == next.min) {
	    						if(this.sec >= next.sec) return true;
	    					}
	    				}
	    			}
	    		}
	    	}
	    	return false;
		}
		
		public int getYear() {
			return year;
		}
		public void setYear(int year) {
			this.year = year;
		}
		public int getMon() {
			return mon;
		}
		public void setMon(int mon) {
			this.mon = mon;
		}
		public int getDay() {
			return day;
		}
		public void setDay(int day) {
			this.day = day;
		}
		public int getHour() {
			return hour;
		}
		public void setHour(int hour) {
			this.hour = hour;
		}
		public int getMin() {
			return min;
		}
		public void setMin(int min) {
			this.min = min;
		}
		public double getSec() {
			return sec;
		}
		public void setSec(double sec) {
			this.sec = sec;
			if(this.sec >= 60) {
				this.sec -= 60;
				this.min += 1;
			}
		}

		@Override
		public String toString() {
			return "Time [year=" + year + ", mon=" + mon + ", day=" + day + ", hour=" + hour + ", min=" + min + ", sec="
					+ sec + "]";
		}
		
    }
}