package com.care.demo.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.care.demo.dto.MemberDTO;

@Mapper
public interface MemberRepository {

	MemberDTO findById(String id);
	void register(MemberDTO member);
	List<MemberDTO> findAll();
	void update(MemberDTO member);
	void delete(String id);
}
