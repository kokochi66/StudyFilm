#include <bits/stdc++.h>
using namespace std;
static int n,m;
static int darr[100][2];
static bool used[100];
static int oper[100];
static bool finish = false;

int abs(int a){
	if(a>0) return a;
	else return -a;
}

void dfs(int pi, int k) {
	int i;
	if(k==n){
		for(i=0;i<n;i++){
			char curr = '+';
			if(oper[i]<0) curr = '-';
			cout << abs(oper[i]) << " " << curr << "\n";
		}
		finish = true;
	} else {
		for(i=0;i<n;i++){
			if(darr[i][0] == pi && used[i]==0 ){
				used[i] = 1;
				oper[k] = (i+1);
				dfs(darr[i][1],k+1);
				if(finish) return;
				used[i] = false;
			} else if(darr[i][1] == pi && used[i]==0){
				used[i] = 1;
				oper[k] = -(i+1);
				dfs(darr[i][0],k+1);
				if(finish) return;
				used[i] = false;
			}
		}
	}
}

int main() {
	ios::sync_with_stdio(0);
    cin >> n;
    int i;
    for(i=0;i<n;i++){
    	cin >> darr[i][0] >> darr[i][1];
	}
	for(i=0;i<n;i++){
		used[i] = true;
		oper[0] = (i+1);
		dfs(darr[i][1],1);
		if(finish) break;
		oper[0] = -(i+1);
		dfs(darr[i][0],1);
		used[i] = false;
	}
	
	if(finish==0) cout << "No solution";
}
