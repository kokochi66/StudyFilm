package net.madvirus.spring4.chap03;


public class ConnPool3 {
// 커스텀 init메소드와 커스텀 destroy 메소드를 사용한 초기화/소멸 과정 처리
	public void init() {
		System.out.println("ConnPool3.init()");
	}

	public void destroy() {
		System.out.println("ConnPool3.destroy()");
	}
}
