package com.care.javaMvc;

import java.util.Scanner;
// 각 메서드는 입력
public class Quiz4 {
	private static MemberService service = new MemberService();
	private static Scanner in = new Scanner(System.in);
	
	public static void main(String[] args) {
		while (true) {
			System.out.println("1. 회원 등록");
			System.out.println("2. 회원 검색");
			System.out.println("3. 회원 삭제");
			System.out.println("4. 회원 모두 보기");
			System.out.println("5. 회원 수정");
			System.out.println("6. 프로그램 종료");
			System.out.print("선택 > ");
			int select;
			try {
				select = Integer.parseInt(in.next());
			} catch (Exception e) {
				continue;
			}
			switch (select) {
			case 1:	insert(); break;
			case 2:	selectEmail(); break;
			case 3:	delete();break;
			case 4:	selectAll();break;
			case 5:	update();break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("메뉴 확인 후 다시 입력하세요.");
			}
			
			System.out.println();
		}
	}

	private static void delete() {
		System.out.println("=== 회원 삭제 ===");
		System.out.print("이메일 : ");
		String email = in.next();
		service.delete(email);
	}

	private static void update() {
		System.out.println("=== 회원 수정 ===");
		System.out.print("이메일 : ");
		String email = in.next();
		System.out.print("이름 : ");
		String name = in.next();
		System.out.print("전화번호 : ");
		String mobile = in.next();
		service.update(email, name, mobile);
	}
	
	private static void selectAll() {
		service.selectAll();
	}
	
	private static void selectEmail() {
		System.out.println("=== 회원 검색 ===");
		System.out.print("이메일 : ");
		service.selectEmail(in.next());
	}
	
	private static void insert() {
		System.out.println("=== 회원 등록 ===");

		MemberDTO member = new MemberDTO();
		
		System.out.print("이메일 : ");
		member.setEmail(in.next());
		System.out.print("이름 : ");
		member.setName(in.next());
		System.out.print("전화번호 : ");
		member.setMobile(in.next());
		
		service.insert(member);
	}
}



















