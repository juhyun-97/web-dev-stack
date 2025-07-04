package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.BookController;
import controller.MemberController;
import controller.RentController;
import vo.Book;
import vo.Member;
import vo.Rent;

public class BookRentApp {

	private Scanner sc = new Scanner(System.in);

	// 로그인 했을 시 사용자 정보 담을 객체!
	private Member client = new Member();

	private BookController bc = new BookController();
	private MemberController mc = new MemberController();
	private RentController rc = new RentController();

	public static void main(String[] args) {
		BookRentApp app = new BookRentApp();
		app.menu();
	}

	public void menu() {
		// 1. 전체 책 조회 - 로그인 X
		// 2. 회원가입 - 로그인 X
		// 3. 로그인 - 로그인 X

		// 1. 책 등록 - 로그인 O (관리자 : admin, 1234)
		// 2. 책 삭제 - 로그인 O (관리자 : admin, 1234)
		// 3. 로그아웃 - 로그인 O

		// 1. 회원탈퇴 - 로그인 O (관리자 X)
		// 2. 로그아웃 - 로그인 O
		// 3. 책 대여 - 로그인 O
		// 4. 내가 대여한 책 조회 - 로그인 O
		// 5. 대여 취소 - 로그인 O
		while (true) {
			System.out.println("1. 전체 책 조회");
			System.out.println("2. 회원가입");
			System.out.println("3. 로그인");
			System.out.print("메뉴선택 > ");
			switch (Integer.parseInt(sc.nextLine())) {
			case 1:
				printBookAll();
				break;
			case 2:
				register();
				break;
			case 3:
				login();
				break;

			}
			// 관리자로 로그인 했을 때
			while (true) {
				System.out.println("1. 책 등록");
				System.out.println("2. 책 삭제");
				System.out.println("3. 로그아웃");
				System.out.print("메뉴선택 > ");
				switch (Integer.parseInt(sc.nextLine())) {
				case 1:
					registerBook();
					break;
				case 2:
					sellBook();
					break;
				case 3:
					break;
				}
				// 일반회원이 들어왔을 때
				while (true) {
					System.out.println("1. 회원탈퇴");
					System.out.println("2. 로그아웃");
					System.out.println("3. 책 대여");
					System.out.println("4. 내가 대여한 책 조회");
					System.out.println("5. 대여 취소");
					System.out.print("메뉴선택 > ");
					switch (Integer.parseInt(sc.nextLine())) {
					case 1:
						delete();
						break;
					case 2:
						sellBook();
						break;
					case 3:
						rentBook();
						break;
					case 4:
						printRentBook();
						break;
					case 5:
						deleteRent();
						break;
					}
				}
			}
		}
	}

	public void printBookAll() {

	}

	public void register() {
		Member member = new Member();
		System.out.print("아이디 > ");
		member.setId(sc.nextLine());
		System.out.print("이름 > ");
		member.setName(sc.nextLine());
		System.out.print("비밀번호 > ");
		member.setPwd(sc.nextLine());
		System.out.print("나이 > ");
		member.setAge(Integer.parseInt(sc.nextLine()));
		// return cc.register();

		mc.register(member);
	}
	
	public void login() {
		Member member = new Member();
		System.out.print("아이디 > ");
		String id = sc.nextLine();
		System.out.print("비밀번호 > ");
		String pwd = sc.nextLine();
		
		mc.login(id, pwd);
	}
	
	public void delete() {

	}
	
	public void rentBook() {

	}
	
	public void printRentBook() {

	}
	

	public void deleteRent() {

	}
	
	public void registerBook() {

	}

	public void sellBook() {

	}

	

	

	

}
