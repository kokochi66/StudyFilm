package jpabook.jpashop.service;

import jpabook.jpashop.repository.SpringDataMemberRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RepositoryTest {

    @Autowired
    private SpringDataMemberRepository memberRepository;

    @Test
    public void test() {
    }
}
