package com.care.javaMvc.quiz6;
/*
SQL> conn spring0115/oracle
연결되었습니다.

SQL> CREATE TABLE java_basic(
  2  id varchar2(10),
  3  password varchar2(10),
  4  name varchar2(20),
  5  PRIMARY KEY(id)
  6  );

SQL> COMMIT;

 */
public class MemberDTO {
	private String id;
	private String password;
	private String name;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
