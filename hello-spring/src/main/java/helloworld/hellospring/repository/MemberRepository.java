package helloworld.hellospring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import helloworld.hellospring.domain.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
}
