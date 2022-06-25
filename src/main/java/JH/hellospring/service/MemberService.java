package JH.hellospring.service;

import JH.hellospring.domain.Member;
import JH.hellospring.repository.MemberRepository;
import JH.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

public class MemberService {

    // private final MemberRepository memberRepository = new MemoryMemberRepository();  // MemberServiceTest랑 달라서 주석처리 하고 아래처럼 해본것

    private final MemberRepository memberRepository;

    /**
     * Constructor
     * @param memberRepository
     */
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    /**
     * 회원 가입
     */
    public Long join(Member member) {
        // 같은 이름이 있는 중복 회원은 X
        validateDuplicateMember(member);    // 중복 회원 검증

        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName());
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");  // 이런게 잘 작동하는지 확인하는 가장 좋은 방법?
        });                                                             // 구현한 Test case 활용하는 것

        /*
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }); // 이렇게도 가능
*/
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
