package com.brutech.secure_rest_api.service;

import com.brutech.secure_rest_api.dao.MemberDao;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
    private MemberDao memberDao;
}
