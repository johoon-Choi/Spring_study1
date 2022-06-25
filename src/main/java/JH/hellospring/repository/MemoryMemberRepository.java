package JH.hellospring.repository;
import JH.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(long id) {
        return Optional.ofNullable(store.get(id));  // NULL이 return될 수 있는 경우 NULL을 감싸준다.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); // 끝까지 찾아본 후 없으면 Optional에 의해 NULL 반환
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    } // interface를 implement

    public void clearStore() {
        store.clear();
    }
}
