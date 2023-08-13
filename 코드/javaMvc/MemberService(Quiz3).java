package com.care.javaMvc;

import java.util.ArrayList;

// 검증 및 출력

public class MemberService {
	private ArrayList<MemberDTO> members;
	
	public MemberService() {
		members = new ArrayList<MemberDTO>();
	}
	
	public void insert(MemberDTO member) {
		for(MemberDTO check : members) {
			if(check.getEmail().equals(member.getEmail()) == true) {
				System.out.println("이미 가입된 정보입니다.");
				return;
			}
		}
		
		members.add(member);
		System.out.println("가입이 완료되었습니다.");
	}
	public void selectEmail(String email) {
		for(MemberDTO member : members) {
			if(member.getEmail().equals(email) == true) {
				System.out.println("이메일\t: " + member.getEmail());
				System.out.println("이름\t: " + member.getName());
				System.out.println("전화번호\t: " + member.getMobile());
				System.out.println();
				return;
			}
		}
		
		System.out.println("등록된 데이터가 없습니다.");
		
	}
	public void selectAll() {
		if(members.isEmpty() == true) {
			System.out.println("등록된 데이터가 없습니다.");
		}else {
			System.out.println("=== 회원 목록 === ");
			for(int index = 0; index < members.size(); index++) {
				MemberDTO member = members.get(index);
				System.out.println("이메일\t: " + member.getEmail());
				System.out.println("이름\t: " + member.getName());
				System.out.println("전화번호\t: " + member.getMobile());
				System.out.println();
			}
		}
	}
	public void update(String email, String name, String mobile) {
		for(MemberDTO member : members) {
			if(member.getEmail().equals(email) == true) {
				int index = members.indexOf(member);
				
				member.setName(name);
				member.setMobile(mobile);
				members.set(index, member);
				System.out.println(email + "님 정보가 수정되었습니다.");
				return;
			}
		}

		System.out.println("등록된 데이터가 없습니다.");
		
	}
	
	public void delete(String email) {
		for(MemberDTO member : members) {
			if(member.getEmail().equals(email) == true) {
				members.remove(member);
				System.out.println(email + "님 정보가 삭제되었습니다.");
				return;
			}
		}
		System.out.println("등록된 데이터가 없습니다.");
	}
}














