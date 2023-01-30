package Study.datajpa.repository;

import Study.datajpa.entity.Member;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepositoryCustom {
    // 커스텀한 리파지토리를 따로 사용하고 싶을 때 사용하는 방법
    List<Member> findMemberCustom();
}
