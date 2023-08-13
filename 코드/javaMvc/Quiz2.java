package com.care.javaMvc;

import java.util.ArrayList;
import java.util.Scanner;

public class Quiz2 {
	private static ArrayList<MemberDTO> members = new ArrayList<MemberDTO>();

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String email = "", name = "", mobile = "";
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
			case 1:
				System.out.println("=== 회원 등록 ===");
				System.out.print("이메일 : ");
				email = in.next();
				System.out.print("이름 : ");
				name = in.next();
				System.out.print("전화번호 : ");
				mobile = in.next();
				insert(email, name, mobile);
				break;
			case 2:
				System.out.println("=== 회원 검색 ===");
				System.out.print("이메일 : ");
				email = in.next();
				selectEmail(email);
				break;
			case 3:
				System.out.println("=== 회원 삭제 ===");
				System.out.print("이메일 : ");
				email = in.next();
				delete(email);
				break;
			case 4:
				selectAll();
				break;
			case 5:
				System.out.println("=== 회원 수정 ===");
				System.out.print("이메일 : ");
				email = in.next();
				System.out.print("이름 : ");
				name = in.next();
				System.out.print("전화번호 : ");
				mobile = in.next();
				update(email, name, mobile);
			
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
			default:
				System.out.println("메뉴 확인 후 다시 입력하세요.");
			}
			
			System.out.println();
		}
	}

	private static void delete(String email) {
		for(MemberDTO member : members) {
			if(member.getEmail().equals(email) == true) {
				members.remove(member);
				System.out.println(email + "님 정보가 삭제되었습니다.");
				return;
			}
		}

		System.out.println("등록된 데이터가 없습니다.");
	}

	private static void update(String email, String name, String mobile) {
		
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

	private static void selectEmail(String email) {
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

	private static void selectAll() {
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
	private static void insert(String email, String name, String mobile) {
		for(MemberDTO member : members) {
			if(member.getEmail().equals(email) == true) {
				System.out.println("이미 가입된 정보입니다.");
				return;
			}
		}
		
		MemberDTO member = new MemberDTO();
		member.setEmail(email);
		member.setName(name);
		member.setMobile(mobile);
		
		members.add(member);
		System.out.println("가입이 완료되었습니다.");
		
	}
}



















