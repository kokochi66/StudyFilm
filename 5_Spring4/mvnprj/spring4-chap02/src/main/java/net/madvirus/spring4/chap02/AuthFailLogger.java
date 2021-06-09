package net.madvirus.spring4.chap02;

public class AuthFailLogger {
	
	private int threshold;
	private int failCounts;
	
	public void insertBadPw(String userId, String inputPw) {
		System.out.printf("AuthFail [type=badpw, userid=%s, pw=%s]\n", userId, inputPw);
		failCounts++;
		if(threshold > 0 && failCounts > threshold) {
			notifyToomanyFail();
			failCounts = 0;
		}
	}

	private void notifyToomanyFail() {
		System.out.println("너무 많은 로그인 시도 실패");	
	}
	
	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

}
