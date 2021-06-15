package net.madvirus.spring4.chap06;

import net.madvirus.spring4.chap06.board.NewArticleRequest;
import net.madvirus.spring4.chap06.board.ReadArticleService;
import net.madvirus.spring4.chap06.board.WriteArticleService;
import net.madvirus.spring4.chap06.member.MemberRegRequest;
import net.madvirus.spring4.chap06.member.MemberService;
import net.madvirus.spring4.chap06.member.UpdateInfo;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainQuickStart2 {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:acQuickStart2.xml");

		WriteArticleService writeArticleService =
				ctx.getBean("writeArticleService", WriteArticleService.class);
		writeArticleService.write(new NewArticleRequest("writer", "title", "content"));
		// WriteArticleService 는 board 내부의 클래스로 Aspect의 Pointcut안에 들어가있으므로, AroundAdivce가 적용된다.

		ReadArticleService readArticleService = ctx.getBean(ReadArticleService.class);
		readArticleService.read(1);
		readArticleService.read(1);
		// ReadArticleService 도 마찬가지로 적용된다.

		MemberService memberService = ctx.getBean(MemberService.class);
		MemberRegRequest memberRegReq =
				new MemberRegRequest("id", "name", "pw");
		memberService.regist(memberRegReq);

		UpdateInfo updateInfo = new UpdateInfo();
		updateInfo.setNewName("새이름");
		memberService.update("madvirus", updateInfo);
		// member의 regist와 update 함수는 Pointcut안에 들어가있지 않으므로, AroundAdvice가 실행되지 않는다.

		ctx.close();
	}
}
