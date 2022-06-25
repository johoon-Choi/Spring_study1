package JH.hellospring.repository;
import JH.hellospring.domain.Member;
import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(long id);
    Optional<Member> findByName(String name); // 못 찾은 경우 NULL을 return이 아닌 무언가를 return
    List<Member> findAll();

}
