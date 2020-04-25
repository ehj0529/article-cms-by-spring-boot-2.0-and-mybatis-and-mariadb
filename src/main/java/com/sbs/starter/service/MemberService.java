package com.sbs.starter.service;

import java.util.Map;

import com.sbs.starter.dto.Member;

public interface MemberService {

	Map<String, Object> checkLoginIdDup(String loginId);

	Member getOne(long loginedMemberId);

	Map<String, Object> join(Map<String, Object> param);

}
