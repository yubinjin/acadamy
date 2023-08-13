package com.care.javaMvc.quiz5;

import java.util.ArrayList;

public interface IMemberDAO {
	public void insert(MemberDTO member);

	public MemberDTO selectId(String id);

	public void delete(MemberDTO deleteMember);

	public ArrayList<MemberDTO> selectAll();

	public void update(int index, MemberDTO updateMember);
}
