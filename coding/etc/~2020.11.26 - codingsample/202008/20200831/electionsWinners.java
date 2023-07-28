package javaSpeedcoding;

public class electionsWinners {
	int maxNum(int[] votes){
	    int max = votes[0];
	    for(int i=1;i<votes.length;i++) if(max<votes[i]) max = votes[i];
	    return max;
	}

	int electionsWinners(int[] votes, int k) {
	    int max = maxNum(votes), maxpeo = 0;
	    int count = 0;
	    for(int i=0;i<votes.length;i++) {
	        if(votes[i]+k>max) count++;
	        if(votes[i] == max) maxpeo++;
	    }
	    if(k==0 && maxpeo>1) count = 0;
	    else if(k==0 && maxpeo==1) count = 1;
	    return count;
	}


}
