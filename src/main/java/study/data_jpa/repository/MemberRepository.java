package study.data_jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import study.data_jpa.dto.MemberDTO;
import study.data_jpa.entity.Member;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    //new 패키지.클래스 생성자를 통해서 객체를 생성하여 DTO 매핑이 가능하다.
    @Query("select new study.data_jpa.dto.MemberDTO( m.id, m.username, t.name) from Member m join m.team t")
    List<MemberDTO> findMemberDTO();
}
