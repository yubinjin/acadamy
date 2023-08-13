package com.care.javaMvc.quiz5;

import java.util.ArrayList;

public class MemberDaoImpl implements IMemberDAO{
	private ArrayList<MemberDTO> members;
	
	public MemberDaoImpl() {
		members = new ArrayList<MemberDTO>();
	}
	
	@Override
	public void insert(MemberDTO member) {
		members.add(member);
	}

	@Override
	public MemberDTO selectId(String id) {
		for(MemberDTO member : members) {
			if(member.getId().equals(id) == true) {
				return member;
			}
		}
		return null;
		//return members.get(indexOf(id));
	}
	
	public int indexOf(MemberDTO member) {
		return members.indexOf(member);
	}
//	public int indexOf(String id) {
//		for(MemberDTO member : members) {
//			if(member.getId().equals(id) == true) {
//				return members.indexOf(member);
//			}
//		}
//		return -1;
//	}
	@Override
	public void delete(MemberDTO deleteMember) {
		members.remove(deleteMember);
	}

	@Override
	public ArrayList<MemberDTO> selectAll() {
		return members;
	}

	@Override
	public void update(int index, MemberDTO updateMember) {
		members.set(index, updateMember);
	}

}
