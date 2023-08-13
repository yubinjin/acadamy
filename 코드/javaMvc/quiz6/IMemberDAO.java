package com.care.javaMvc.quiz6;

import java.util.ArrayList;

public interface IMemberDAO {
	public void insert(MemberDTO member);

	public MemberDTO selectId(String id);

	public void delete(String id);

	public ArrayList<MemberDTO> selectAll();

	public void update(MemberDTO updateMember);
}
