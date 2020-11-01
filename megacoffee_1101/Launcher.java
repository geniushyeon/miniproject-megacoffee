import java.util.*;

public class Launcher { //�ֹ�, ���� �޼ҵ� ����
	Scanner scan = new Scanner(System.in);
	Menu menu1;
	int takeout;
	
	public Launcher() {//launcher ������ �ϳ��� ����
		menu1 = new Menu();
		where();
	}

	public void where() {
		System.out.println("�ް�Ŀ�ǿ� ���� ���� ȯ���մϴ�. ");
		System.out.println("1. �����ϱ�(10% ����) 2. �԰���");
		takeout = scan.nextInt();
		menu();
	}
	
	public void menu() {
		for(;;) {
			System.out.println("1. �ֹ� 2. ���� ");
			int choice = scan.nextInt();
			if (choice == 1) {
				order();
			}
			else if (choice == 2) {
				payment();
				break;
			}
			else
				System.out.println("�߸� �Է��Ͽ����ϴ�. ");
		}//for(;;)
	}//public void menu()
	
	public void order() {
		System.out.println("�޴��� �����ϼ���. ");
		System.out.println("1. Ŀ�� 2. ������ 3. ����Ʈ ");
		int choiceMenu = scan.nextInt();
		if (choiceMenu == 1)
			menu1.orderCoffee();
		else if (choiceMenu == 2)
			menu1.orderSmoothie();
		else if (choiceMenu == 3)
			menu1.orderCake();
	}

	public void payment() { //���� 
		System.out.println("�����Ͻðڽ��ϱ�?");
		System.out.println("1. �� 2. �ƴϿ� ");
		int choiceStamp = scan.nextInt();
		if (choiceStamp == 1) {
			point();//����Ʈ ���� �޼ҵ�
		}
		receipt();//������ ���
	}//public void payment()(���� ��)

	public void point() {
		Member member = new Member();
		member.setId("hanna");
		member.setPw(1234);

		for(;;) {
			System.out.print("���̵� �Է��ϼ���: ");
			String checkID = scan.next();
			if (checkID.equals(member.getId())) {
				System.out.print("��й�ȣ�� �Է��ϼ���: ");
				int checkPW = scan.nextInt();
				if (checkPW == member.getPw()) {
					System.out.println("\n" + member.getId() + " ȸ������ ���� ��Ȳ�Դϴ�. ");
					System.out.println("������ �������� " + menu1.getStamp() + "���Դϴ�. ");
					if (menu1.getStamp()>=3) {//���� ���� �� 
						System.out.println("������ " + (menu1.getStamp()/3) + "�� �����Ǿ����ϴ�. ");
					} else { //���� ���� �� 
						System.out.println("������ ������ �����ϴ�. ");
					}
					break;
				}//�н�������� ��ġ 
				else
					System.out.println("�߸��� �н������Դϴ�. ���̵���� �ٽ� �Է��ϼ���. ");
			}//���̵� ��ġ 
			if (!checkID.equals(member.getId())) {
				System.out.println("�߸��� ���̵��Դϴ�. �ٽ� �Է��ϼ���. ");
			}//���̵� ����ġ 
		}//for(;;) - ȸ�� Ȯ��
		
	}//point();

	public void receipt() {
		System.out.println("\n�ֹ� ���� ");
		for (int i=0; i<menu1.list.size(); i++) {
			System.out.println((i+1) + ". " + menu1.list.get(i));
		} //�ֹ��� ��� 
		if (takeout == 1) {
			getTakeoutSum();
		}
		if (takeout == 2) {
			getSum();
		}
	}//receipt();

	public void getTakeoutSum() { //��������
		System.out.println("�ֹ� �ݾ�:\t\t" + menu1.sum + "��");
		System.out.println("\n�������� 10%�� ����Ǿ����ϴ�.");
		System.out.println("���ε� ���� �ݾ�:\t" + (int)(menu1.sum*0.9) + "��");	
	}
	
	public void getSum() { //�԰���
		System.out.println("\n�� ���� �ݾ�:\t" + menu1.sum + "��");
	}
	
}