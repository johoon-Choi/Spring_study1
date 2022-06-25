package JH.hellospring.repository;

import JH.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {  // 얘는 굳이 public 으로 한 해도 됨

    MemberRepository repository = new MemoryMemberRepository();

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
}

/*
    Test 별로 돌려볼 수 있고 전체 다 하고싶으면
    class 단위에서도 돌릴 수 있다

 */