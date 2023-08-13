package com.care.javaMvc;

import java.util.ArrayList;

//Data Access Object
public class MemberDAO implements IMemberDAO{
	private ArrayList<MemberDTO> members;
	
	public MemberDAO() {
		members = new ArrayList<MemberDTO>();
	}

	@Override
	public void insert(MemberDTO member) {
		members.add(member);
	}

	@Override
	public MemberDTO selectEmail(int index) {
		return members.get(index);
	}

	@Override
	public ArrayList<MemberDTO> selectAll() {
		return members;
	}

	@Override
	public void update(int index, MemberDTO member) {
		members.set(index, member);
	}

	@Override
	public void delete(int index) {
		members.remove(index);
	}
	
	public int indexOf(String email) {
		for(MemberDTO check : members) {
			if(check.getEmail().equals(email) == true)
				return members.indexOf(check);
		}
		return -1;
	}
	
}













