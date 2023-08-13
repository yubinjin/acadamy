package com.care.javaMvc;

import java.util.ArrayList;

public interface IMemberDAO {
	public void insert(MemberDTO member) ;
	public MemberDTO selectEmail(int index) ;
	public ArrayList<MemberDTO> selectAll() ;
	public void update(int index, MemberDTO member) ;
	public void delete(int index) ;
}
