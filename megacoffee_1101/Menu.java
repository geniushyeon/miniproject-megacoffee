import java.util.*;

class Coffee { //Ŀ�� �޴�, ���� 
	String menu;
	int price;

	public Coffee(String menu, int price) {
		this.menu = menu;
		this.price = price;
	}

	public String toString() {
		return menu +":\t" + price + "�� ";
	}

}//class Coffee
class Smoothie {//������ �޴�, ���� 
	String menu;
	int price;

	public Smoothie(String menu, int price) {
		this.menu = menu;
		this.price = price;
	}

	public String toString() {
		return menu +":\t" + price + "�� ";
	}

}//class Smoothie

class Cake {//����ũ �޴�, ���� 
	String menu;
	int price;

	public Cake(String menu, int price) {
		this.menu = menu;
		this.price = price;

	}

	public String toString() {
		return menu +":\t" + price + "�� ";
	}

}//class Cake

public class Menu { //�޴� �߰�, ���
	Scanner scan = new Scanner(System.in);
	Coffee[] coffee = new Coffee[4]; //Ŀ�� �޴� ���� �迭
	Smoothie[] smoothie = new Smoothie[2];//������ �޴� ���� �迭
	Cake[] cake = new Cake[2];//����ũ �޴� ���� �迭
	ArrayList<String> list = new ArrayList<>();//�ֹ��� 

	int sum = 0; //�� �ֹ��ݾ�
	int stamp = 0; //������
	int shotplus = 500; //���߰�
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

	public void coffeemenu() {//Ŀ�� �迭�� �޴� ����
		coffee[0] = new Coffee("�� �Ƹ޸�ī��" , 1500);
		coffee[1] = new Coffee("���̽��Ƹ޸�ī��", 2000);
		coffee[2] = new Coffee("ī��  ��ī", 2500);
		coffee[3] = new Coffee("ī��� �����ƶ�", 3000);
	}

	public void getcoffee(){//Ŀ�� �޴� ��� 
		System.out.println("Ŀ�� �޴��Դϴ�. ");
		for(int i=0; i<coffee.length; i++) {
			System.out.println((i+1) + ". " + coffee[i].toString());
		} 
	}

	public void smoothiemenu() {//������ �迭�� �޴� ����
		smoothie[0] = new Smoothie("���Ʈ ������", 3500);
		smoothie[1] = new Smoothie("���� ������", 4000);
	}

	public void getsmoothie() {//������ �޴� ���
		System.out.println("������ �޴��Դϴ�. ");
		for(int i=0; i<smoothie.length; i++) {
			System.out.println((i+1) + ". " + smoothie[i].toString());
		} //������ �޴� ��� 
	}

	public void cakemenu() {//���̵� �迭�� �޴� ����
		cake[0] = new Cake("ġ�� ����ũ", 5000);
		cake[1] = new Cake("���� ����ũ", 5000);
	}

	public void getcake() {//���̵� �޴� ���
		System.out.println("���̵� �޴��Դϴ�. ");
		for(int i=0; i<cake.length; i++) {
			System.out.println((i+1) + ". " + cake[i].toString());
		} //���̵� �޴� ��� 
	}

	public void ordercoffee() {//Ŀ�� �ֹ�
		int choiceCoffee = scan.nextInt();
		ordercount();
		for(int i=0; i<choicecount; i++) {
			list.add(coffee[choiceCoffee-1].toString());
			sum += coffee[(choiceCoffee-1)].price;//�հ迡 �����ϱ� 
			stamp++;//������ �߰� 
		}
		System.out.println(coffee[choiceCoffee-1].menu + "�� " + choicecount + "�� �ֹ��ϼ̽��ϴ�.");
	}//Ŀ�� �ֹ��Ϸ�

	public void ordershot() {//���߰� ?
		System.out.println("���� �߰��Ͻðڽ��ϱ�(500��)?");
		System.out.println("1. �� 2. �ƴϿ� ");
		int choiceShot = scan.nextInt();
		if (choiceShot == 1) {//���߰� 
			ordercount();
			for(int i=0; i<choicecount; i++) {
				list.add("- �� �߰�:\t" + shotplus + "�� ");
				sum += shotplus;
			}
			System.out.println("���� " + choicecount+ "�� �߰��߽��ϴ�. ");

		}
	}

	public void ordersmoothie() { //������ �ֹ�
		int choiceSmoothie = scan.nextInt();
		ordercount();
		for(int i=0; i<choicecount; i++) {
			list.add(smoothie[choiceSmoothie-1].toString());
			sum += smoothie[(choiceSmoothie-1)].price;//�հ迡 �����ϱ� 
		}
		System.out.println(smoothie[choiceSmoothie-1].menu + "�� " + choicecount + "�� �ֹ��ϼ̽��ϴ�.");

	}//������ �ֹ��Ϸ�

	public void ordercake() {//���̵� �ֹ�
		int choiceCake = scan.nextInt();
		ordercount();
		for(int i=0; i<choicecount; i++) {
			list.add(cake[choiceCake-1].toString());
			sum += cake[(choiceCake-1)].price;//�հ迡 �����ϱ� 
		}
		System.out.println(cake[choiceCake-1].menu + "�� " + choicecount + "�� �ֹ��ϼ̽��ϴ�.");

	}//���̵� �ֹ��Ϸ�

	public void ordercount() {
		System.out.println("������ �Է��ϼ���.");
		choicecount = scan.nextInt();
	}

	public int getStamp() {
		return stamp;//������ ���� �޾ƿ�
	}

}