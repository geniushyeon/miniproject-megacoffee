import java.util.*;

public class Launcher { //주문, 결제 메소드 모음
	Scanner scan = new Scanner(System.in);
	Menu menu1 = new Menu();
	ArrayList list = new ArrayList();//주문서 

	public Launcher() {//launcher 생성자 하나로 실행
		menu();
	}

	public void menu() {
		System.out.println("메가커피에 오신 것을 환영합니다. ");
		for(;;) {
			System.out.println("1. 주문 2. 결제 ");
			int choice = scan.nextInt();
			if (choice == 1) { //주문
				order();
			}
			if (choice == 2) { //결제(결제 메소드 부르기) 
				payment();
				break; //결제 끝나면 for(;;) 탈출(프로그램 종료) 
			}
		}//for(;;)
	}//public void menu()

	public void order() {
		System.out.println("메뉴를 선택하세요. ");
		System.out.println("1. 커피 2. 스무디 3. 디저트 ");
		int choiceMenu = scan.nextInt();
		if (choiceMenu == 1) 
			menu1.orderCoffee();//커피 주문 완료 
		if (choiceMenu == 2) 
			menu1.orderSmoothie();//스무디 주문 완료 
		if (choiceMenu == 3) 
			menu1.orderCake(); //사이드 메뉴 주문 완료 
	}

	public void payment() { //결제 
		System.out.println("적립하시겠습니까? 1. 예 2. 아니오 ");
		int choiceStamp = scan.nextInt();
		if (choiceStamp == 1) {
			point();//포인트 적립 메소드
		}
		menu1.receipt();//영수증 출력
	}//public void payment()(결제 끝)

	public void point() {
		Member member = new Member();
		member.setId("hanna");
		member.setPw(1234);
		
		for(;;) {
			System.out.print("아이디를 입력하세요: ");
			String checkID = scan.next();
			if (checkID.equals(member.getId())) {
				System.out.print("비밀번호를 입력하세요: ");
				int checkPW = scan.nextInt();
				if (checkPW == member.getPw()) {
					System.out.println("\n" + member.getId() + " 회원님의 적립 현황입니다. ");
					System.out.println("적립된 스탬프는 " + menu1.getStamp() + "개입니다. ");
					if (menu1.getStamp()>=3) {//쿠폰 있을 때 
						System.out.println("쿠폰이 " + (menu1.getStamp()/3) + "개 생성되었습니다. ");
					} else { //쿠폰 없을 때 
						System.out.println("생성된 쿠폰이 없습니다. ");
					}
					break;
				}//패스워드까지 일치 
				else
					System.out.println("잘못된 패스워드입니다. 아이디부터 다시 입력하세요. ");
			}//아이디만 일치 
			if (!checkID.equals(member.getId())) {
				System.out.println("잘못된 아이디입니다. 다시 입력하세요. ");
			}//아이디 불일치 
		}//for(;;) - 회원 확인

	}

}
