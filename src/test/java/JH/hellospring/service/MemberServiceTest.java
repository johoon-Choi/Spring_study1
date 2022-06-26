package JH.hellospring.service;

import JH.hellospring.domain.Member;
import JH.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    // MemberService memberService = new MemberService();   MemberService랑 다른 레포 테스트 되고 있는 문제 수정하려고 주석처리

    // MemoryMemberRepository memberRepository = new MemoryMemberRepository(); // MemberService랑 다른 레포가 테스트 되고 있는 것.
    MemberService memberService;
    MemoryMemberRepository memberRepository;    // 위 문제 해결 위해서 이렇게 한 뒤 아래 beforeEach 에서 따로 정의 : Dependency Ejection

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }


    @Test
    void 회원가입() {   // 한글로도 가능
        // Test는 이렇게 given when then으로 거의 잘린다.
        // given
        Member member = new Member();
        member.setName("hello");

        // when
        Long saveId = memberService.join(member);

        // then
        // Optional<Member> one = memberService.findOne(saveId);
        Member findMember = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            // 여기로 오면 예외가 터져서 정상적으로 온것
//            // Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다. 123"); // 에러뜸 123 때문에
//        }

        
        // then
    }

    @Test
    void join() {
    }

    @Test
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    @Test
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}