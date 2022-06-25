package JH.hellospring.repository;

import JH.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {  // 얘는 굳이 public 으로 한 해도 됨

    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach  // Test 들이 끝나고 자동적으로 호출됨
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);
        Member result = repository.findById(member.getId()).get();

        // System.out.println("result = " + (result == member)); // 계속 프린트된걸 볼 순 없다
        // Assertions.assertEquals(member, result);         // junit

        assertThat(member).isEqualTo(result);    // assertj
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();  // member1 위 세줄 복사 후
        member2.setName("spring2");     //   shift + F6
        repository.save(member2);

        // Optional<Member> result = repository.findByName("spring1");
        Member result = repository.findByName("spring2").get(); // 위 문장을 이렇게 get()으로 꺼낼 수 있다

        assertThat(result).isEqualTo(member2);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}

/*
    Test 별로 돌려볼 수 있고 전체 다 하고싶으면
    class 단위에서도 돌릴 수 있다
        But 순서는 랜덤
        -> 순서에 의존적으로 설계하면 안됨
        Test 별로 겹치는 변수가 있으면 안된다.
            겹치는 경우가 있을 수 있으므로 test가 끝나면 data를 clear 해야한다.

    Test 주도 개발 (TDD) : Test를 먼저 만들어 보고 class를 만들어서 돌려보는 것
 */