package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository{

    // 저장소
    private static Map<Long,Member> store = new HashMap<>(); // 동시성 문제 해결 하려면 ConCurrentHashMap

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        Member data = store.get(memberId);
        return data;
    }
}
