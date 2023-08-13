package com.care.javaMvc.quiz6;

public interface IMemberService {
	public void insert(String id, String pw, String name);
	
	public void selectId(String id);

	public void delete(String id);
	
	public void selectAll();

	public void update(String id, String currentPw, String changePw);
}
