package Study.datajpa.repository;

import Study.datajpa.entity.Member;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import java.util.List;

@RequiredArgsConstructor
public class MemberRepositoryCustomImpl implements MemberRepositoryCustom {
    // Impl 네이밍 규칙을 지켜줘야 사용이 가능하다.
    // 아니면 @EnableJpaRepositories 를 사용해야하나, 억지로 바꾸면 유지보수가 어려워진다.
    // Query용으로 커스텀한 리파지토리를 만들려면 그냥 같은걸 쓰지말고, 새로운 리파지토리로 분리해서 쓰는게 훨씬 유리할 수 있다. (너무 코드가 많아지면 복잡해지기 때문)
    private final EntityManager em;

    @Override
    public List<Member> findMemberCustom() {
        return em.createQuery("select m from Member m", Member.class).getResultList();
    }
}
