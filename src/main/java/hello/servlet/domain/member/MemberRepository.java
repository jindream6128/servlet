package hello.servlet.domain.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberRepository {
    private static Map<Long,Member> store = new HashMap<>(); //싱글톤 이라서 static 이 필요없지만 일단 static 으로 선언
    private static long sequence = 0L;

    private static final MemberRepository instance = new MemberRepository();

    public static MemberRepository getInstance() {
        return instance;
    }

    public MemberRepository() {
    }

    //save
    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    //id로 찾기 -> store 에서 id 값으로 member를 얻는다
    public Member findById(Long id){
        return store.get(id);
    }

    //전체다 찾기
    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    //전체비우기
    public void clearStore(){
        store.clear();
    }
}
