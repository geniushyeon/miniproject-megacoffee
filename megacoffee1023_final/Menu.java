import java.util.*;

class Coffee { //커피 메뉴, 가격 
	String menu;
	int price;

	public Coffee(String menu, int price) {
		this.menu = menu;
		this.price = price;
	}

	public String toString() {
		return menu +":\t" + price + "원 ";
	}

}//class Coffee
class Smoothie {//스무디 메뉴, 가격 

	String menu;
	int price;

	public Smoothie(String menu, int price) {
		this.menu = menu;
		this.price = price;
	}

	public String toString() {
		return menu +":\t" + price + "원 ";
	}

}//class Smoothie

class Cake {//케이크 메뉴, 가격 
	String menu;
	int price;

	public Cake(String menu, int price) {
		this.menu = menu;
		this.price = price;

	}

	public String toString() {
		return menu +":\t" + price + "원 ";
	}

}//class Cake

public class Menu { //메뉴 추가, 출력
	Scanner scan = new Scanner(System.in);
	Coffee[] coffee = new Coffee[4]; //커피 메뉴 담을 배열
	Smoothie[] smoothie = new Smoothie[2];//스무디 메뉴 담을 배열
	Cake[] cake = new Cake[2];//케이크 메뉴 담을 배열
	ArrayList list = new ArrayList();//주문서 

	int sum = 0; //총 주문금액
	int stamp = 0; //스탬프
	int shotplus = 500; //샷추가
	int choicecount;
	
	public void orderCoffee() {
		coffeemenu();
		getcoffee();
		ordercoffee();
		ordershot();
	}
	
	public void orderSmoothie() {
		smoothiemenu();
		getsmoothie();
		ordersmoothie();
	}
	
	public void orderCake() {
		cakemenu();
		getcake();
		ordercake();
	}
	
	public void coffeemenu() {//커피 배열에 메뉴 저장
		coffee[0] = new Coffee("핫 아메리카노" , 1500);
		coffee[1] = new Coffee("아이스아메리카노", 2000);
		coffee[2] = new Coffee("카페  모카", 2500);
		coffee[3] = new Coffee("카라멜 마끼아또", 3000);
	}
	
	public void getcoffee(){//커피 메뉴 출력 
		System.out.println("커피 메뉴입니다. ");
		for(int i=0; i<coffee.length; i++) {
			System.out.println((i+1) + ". " + coffee[i].toString());
		} 
	}

	public void smoothiemenu() {//스무디 배열에 메뉴 저장
		smoothie[0] = new Smoothie("요거트 스무디", 3500);
		smoothie[1] = new Smoothie("딸기 스무디", 4000);
	}

	public void getsmoothie() {//스무디 메뉴 출력
		System.out.println("스무디 메뉴입니다. ");
		for(int i=0; i<smoothie.length; i++) {
			System.out.println((i+1) + ". " + smoothie[i].toString());
		} //스무디 메뉴 출력 
	}

	public void cakemenu() {//사이드 배열에 메뉴 저장

		cake[0] = new Cake("치즈 케이크", 5000);
		cake[1] = new Cake("초코 케이크", 5000);
	}

	public void getcake() {//사이드 메뉴 출력
		System.out.println("사이드 메뉴입니다. ");
		for(int i=0; i<cake.length; i++) {
			System.out.println((i+1) + ". " + cake[i].toString());
		} //사이드 메뉴 출력 
	}

	public void ordercoffee() {//커피 주문
		int choiceCoffee = scan.nextInt();		
		ordercount();
		for(int i=0; i<choicecount; i++) {
			list.add(coffee[choiceCoffee-1].toString());
			sum += coffee[(choiceCoffee-1)].price;//합계에 누적하기 
			stamp++;//스탬프 추가 
		}
		System.out.println(coffee[choiceCoffee-1].menu + "를 " + choicecount + "잔 주문하셨습니다.");

	}//커피 주문완료

	public void ordershot() {//샷추가 ?
		System.out.println("샷을 추가하시겠습니까(500원)?");
		System.out.println("1. 예 2. 아니오 ");
		int choiceShot = scan.nextInt();
		if (choiceShot == 1) {//샷추가 
			ordercount();
			for(int i=0; i<choicecount; i++) {
				list.add("- 샷 추가:\t" + shotplus + "원 ");
				sum += shotplus;
			}
			System.out.println("샷을 " + choicecount+ "개 추가했습니다. ");

		}
	}

	public void ordersmoothie() { //스무디 주문
		int choiceSmoothie = scan.nextInt();		
		ordercount();
		for(int i=0; i<choicecount; i++) {
			list.add(smoothie[choiceSmoothie-1].toString());
			sum += smoothie[(choiceSmoothie-1)].price;//합계에 누적하기 
		}
		System.out.println(smoothie[choiceSmoothie-1].menu + "를 " + choicecount + "잔 주문하셨습니다.");

	}//스무디 주문완료

	public void ordercake() {//사이드 주문
		int choiceCake = scan.nextInt();
		ordercount();
		for(int i=0; i<choicecount; i++) {
			list.add(cake[choiceCake-1].toString());
			sum += cake[(choiceCake-1)].price;//합계에 누적하기 
		}
		System.out.println(cake[choiceCake-1].menu + "를 " + choicecount + "개 주문하셨습니다.");

	}//사이드 주문완료

	public void ordercount() {
		System.out.println("수량을 입력하세요.");
		choicecount = scan.nextInt();
	}

	public int getSum() {
		return sum;//주문금액 받아옴
	}
	public int getStamp() {
		return stamp;//적립된 도장 받아옴
	}

	public void receipt() {
		System.out.println("\n주문 내역 ");
		for (int i=0; i<list.size(); i++) {
			System.out.println((i+1) + ". " + list.get(i));
		} //주문서 출력 
		System.out.println("총 결제 금액:\t" + getSum() + "원 ");
	}

}
