import java.util.*;

public class Launcher { //주문, 결제 메소드 모음
	Scanner scan = new Scanner(System.in);
	Menu menu1;
	int takeout;
	
	public Launcher() {//launcher 생성자 하나로 실행
		menu1 = new Menu();
		where();
	}

	public void where() {
		System.out.println("메가커피에 오신 것을 환영합니다. ");
		System.out.println("1. 포장하기(10% 할인) 2. 먹고가기");
		takeout = scan.nextInt();
		menu();
	}
	
	public void menu() {
		for(;;) {
			System.out.println("1. 주문 2. 결제 ");
			int choice = scan.nextInt();
			if (choice == 1) {
				order();
			}
			else if (choice == 2) {
				payment();
				break;
			}
			else
				System.out.println("잘못 입력하였습니다. ");
		}//for(;;)
	}//public void menu()
	
	public void order() {
		System.out.println("메뉴를 선택하세요. ");
		System.out.println("1. 커피 2. 스무디 3. 디저트 ");
		int choiceMenu = scan.nextInt();
		if (choiceMenu == 1)
			menu1.orderCoffee();
		else if (choiceMenu == 2)
			menu1.orderSmoothie();
		else if (choiceMenu == 3)
			menu1.orderCake();
	}

	public void payment() { //결제 
		System.out.println("적립하시겠습니까?");
		System.out.println("1. 예 2. 아니오 ");
		int choiceStamp = scan.nextInt();
		if (choiceStamp == 1) {
			point();//포인트 적립 메소드
		}
		receipt();//영수증 출력
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
		
	}//point();

	public void receipt() {
		System.out.println("\n주문 내역 ");
		for (int i=0; i<menu1.list.size(); i++) {
			System.out.println((i+1) + ". " + menu1.list.get(i));
		} //주문서 출력 
		if (takeout == 1) {
			getTakeoutSum();
		}
		if (takeout == 2) {
			getSum();
		}
	}//receipt();

	public void getTakeoutSum() { //포장할인
		System.out.println("주문 금액:\t\t" + menu1.sum + "원");
		System.out.println("\n포장할인 10%가 적용되었습니다.");
		System.out.println("할인된 결제 금액:\t" + (int)(menu1.sum*0.9) + "원");	
	}
	
	public void getSum() { //먹고가기
		System.out.println("\n총 결제 금액:\t" + menu1.sum + "원");
	}
	
}