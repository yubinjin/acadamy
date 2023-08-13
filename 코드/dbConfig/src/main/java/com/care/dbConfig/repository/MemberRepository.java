package com.care.dbConfig.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.care.dbConfig.dto.MemberDTO;

@Repository
public interface MemberRepository {

	MemberDTO login(String id);

	void register(MemberDTO member);

	ArrayList<MemberDTO> list();
	
	void update(MemberDTO member);

	void delete(String id);
}
