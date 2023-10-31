package com.brutech.secure_rest_api.dao;

import com.brutech.secure_rest_api.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface MemberDao extends JpaRepository<Member, Long>{
    @Query("SELECT m FROM Member m WHERE m.email = :email")
    Optional<Member> findUserByEmail(String email);
}
