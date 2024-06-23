package study.data_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import study.data_jpa.dto.MemberDTO;
import study.data_jpa.entity.Member;

import java.util.Collection;
import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    //new 패키지.클래스 생성자를 통해서 객체를 생성하여 DTO 매핑이 가능하다.
    @Query("select new study.data_jpa.dto.MemberDTO( m.id, m.username, t.name) from Member m join m.team t")
    List<MemberDTO> findMemberDTO();

    //파라미터 바인딩을 List로 넘겨서 in 조건을 사용할 수 있다.
    @Query("select m from Member m where m.username in :names")
    List<Member> findByNames(@Param("names") Collection<String> names);
}
