package net.madvirus.spring4.chap06.aop;

import net.madvirus.spring4.chap06.member.UpdateInfo;

public class UpdateMemberInfoTraceAdvice {

	public void traceReturn(String memberId, UpdateInfo info) {
		// Advice를 적용하는 XML에 args(memberId, info) 인자를 넣어서, 타입에 따라 적용여부가 결정된다.
		// 이렇게하면 메서드 호출 시 사용된 인자를 파라미터로 전달받을 수 있다.
		System.out.printf("[TA] 정보 수정: 대상회원=%s, 수정정보=%s\n",
				memberId, info);
	}

}
