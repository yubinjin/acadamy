package com.care.javaMvc.quiz5;

import java.util.ArrayList;

public class MemberServiceImpl implements IMemberService {
	private MemberDaoImpl memberDao;
	
	public MemberServiceImpl() {
		memberDao = new MemberDaoImpl();
	}
	
	@Override
	public void insert(String id, String pw, String name) {
		MemberDTO check = memberDao.selectId(id);
		if(check == null) {
			check = new MemberDTO();
			check.setId(id);
			check.setPassword(pw);
			check.setName(name);
			memberDao.insert(check);
			System.out.println("회원 가입 완료");
		}else {
			System.out.println("이미 등록된 정보입니다.");
		}
	}

	@Override
	public void selectId(String id) {
		MemberDTO member = memberDao.selectId(id);
		if(member != null) {
			System.out.println("아이디\t비밀번호\t이름");
			System.out.println(member.getId()+"\t"+member.getPassword()+"\t"+member.getName());
		}else {
			System.out.println("등록되지 않은 데이터 입니다.");
		}
	}

	@Override
	public void delete(String id) {
		MemberDTO member = memberDao.selectId(id);
		if(member != null) {
			memberDao.delete(member);
			System.out.println("회원 정보 삭제");
		}else {
			System.out.println("등록되지 않은 데이터 입니다.");
		}
	}

	@Override
	public void selectAll() {
		ArrayList<MemberDTO> members = memberDao.selectAll();
		if(members.isEmpty() == false) {
			System.out.println("아이디\t비밀번호\t이름");
			for(MemberDTO member : members) {
				System.out.println(member.getId()+"\t"+member.getPassword()+"\t"+member.getName());
			}
		}else {
			System.out.println("등록된 정보가 없습니다.");
		}
	}

	@Override
	public void update(String id, String currentPw, String changePw) {
		MemberDTO member = memberDao.selectId(id);
		if(member != null) {
			if(member.getPassword().equals(currentPw) == true) {
				int index = memberDao.indexOf(member);
				member.setPassword(changePw);
				memberDao.update(index, member);
				System.out.println("비밀번호가 수정되었습니다.");
			}else {
				System.out.println("아이디/비밀번호가 틀렸습니다.");
			}
		}else {
			System.out.println("등록된 정보가 없습니다.");
		}

	}

}













