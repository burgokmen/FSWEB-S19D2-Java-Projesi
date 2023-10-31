package com.brutech.secure_rest_api.service;

import com.brutech.secure_rest_api.dao.MemberDao;
import com.brutech.secure_rest_api.dao.RoleDao;
import com.brutech.secure_rest_api.entity.Member;
import com.brutech.secure_rest_api.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthenticationService {
    private MemberDao memberDao;
    private RoleDao roleDao;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public AuthenticationService(MemberDao memberDao, RoleDao roleDao, PasswordEncoder passwordEncoder) {
        this.memberDao = memberDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }

    public Member register(String email, String password){
        Optional<Member> foundMember = memberDao.findUserByEmail(email);
        if(foundMember.isPresent()){
            throw new RuntimeException("Email already taken");
        }
        String encodedPassword = passwordEncoder.encode(password);
        if(roleDao.findByAuthority("USER").isEmpty()) throw new RuntimeException("USER role not found");
        Role UserRole = roleDao.findByAuthority("USER").get();
        List<Role> roleList = new ArrayList<>();
        roleList.add(UserRole);

        Member member = new Member();
        member.setEmail(email);
        member.setPassword(encodedPassword);
        member.setAuthorities(roleList);
        return memberDao.save(member);
    }



}
