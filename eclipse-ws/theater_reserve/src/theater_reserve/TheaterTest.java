package theater_reserve;

import java.util.*;

class Theater
{
	//private members
	private Scanner rd = new Scanner(System.in);
	private String theater_name;
	private int[] seat_a = new int[10];
	private int[] seat_b = new int[10];
	
	//public methods
	public Theater()
	{
		this.theater_name = "Theater";
		for(int i = 0; i < this.seat_a.length; i++) {
			this.seat_a[i] = 0;
			this.seat_b[i] = 0;
		}
	}

	public Theater(String name)
	{
		this.theater_name = name;
		for(int i = 0; i < this.seat_a.length; i++) {
			this.seat_a[i] = 0;
			this.seat_b[i] = 0;
		}
	}
	
	public void PrintMenuPage()
	{
		System.out.println("��ȣ�� �����ϼ���(����: 1, ��ȸ: 2, ���: 3, ������: 4)");
	}
	
	public void PrintWelcomePage()
	{
		System.out.println(this.theater_name + ": ���� �¼� ���� �ý����Դϴ�.");
	}
	
	public void PrintEndPage()
	{
		System.out.println("���� ���� �ý����� �����մϴ�");
		System.out.println("���ݱ��� " + this.theater_name +
				"�� �̿����ּż� �����մϴ�");
		
	}
	
	public void StartProgram()
	{
		this.PrintWelcomePage();
		boolean cont = true;
		do {
			this.PrintMenuPage();
			int action = rd.nextInt();
			switch(action) {
			case 1:
				this.ReserveSeat();
				break;
			case 2:
				this.Lookup();
				break;
			case 3:
				this.Cancel();
				break;
			case 4:
				cont = false;
				break;
			default:
				System.out.println("��ȿ���� ���� ��ɾ��Դϴ�. �ٽ� �Է��� �ּ���");
				break;
			}
		} while(cont);
		this.PrintEndPage();
	}
	
	public boolean IsFullA()
	{
		int cnt = 0;
		for(int i = 0; i < this.seat_a.length; i++) 
			cnt += this.seat_a[i];
		if(cnt == 10) 
			return true;
		else
			return false;
	}

	public boolean IsFullB()
	{
		int cnt = 0;
		for(int i = 0; i < this.seat_b.length; i++) 
			cnt += this.seat_b[i];
		if(cnt == 10) 
			return true;
		else
			return false;
	}

	public void PrintCurrentState()
	{
		System.out.println("�¼� ���� ��Ȳ�Դϴ�(���¼� 0, �����¼� 1)");
		System.out.println("------------------------------");
		System.out.printf("%12s %d %d %d %d %d %d %d %d %d %d\n",
				"Seat number", 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		System.out.println("------------------------------");
		System.out.printf("%12s %d %d %d %d %d %d %d %d %d %d\n",
				"A seat", this.seat_a[0], this.seat_a[1], this.seat_a[2],
				this.seat_a[3], this.seat_a[4], this.seat_a[5],
				this.seat_a[6], this.seat_a[7], this.seat_a[8], this.seat_a[9]);
		System.out.println("------------------------------");
		System.out.printf("%12s %d %d %d %d %d %d %d %d %d %d\n",
				"B seat", this.seat_b[0], this.seat_b[1], this.seat_b[2],
				this.seat_b[3], this.seat_b[4], this.seat_b[5],
				this.seat_b[6], this.seat_b[7], this.seat_b[8], this.seat_b[9]);
	}
	
	public void ReserveSeat()
	{
		this.PrintCurrentState();
		System.out.println("�¼� ������ �����մϴ�");
		System.out.println("�¼� ����� �����ϼ���(A:1, B:2)");
		int seat_class = rd.nextInt();
		if(seat_class == 1) {
			if(IsFullA()) {
				System.out.println("A���� �����Դϴ�");
				return;
			}
			System.out.println("�¼� ��ȣ�� �����ϼ���(1~10)");
			int seat_num = rd.nextInt();
			if(seat_num < 1 || seat_num > 10) {
				System.out.println("�߸��� ���ڸ� �Է��ϼ̽��ϴ�, �ٽ� �õ��ϼ���");
				return;
			}
			else if(this.seat_a[seat_num-1] == 1) {
				System.out.println("�� �¼��� �̹� ���� ���Դϴ�, �ٽ� �õ��ϼ���");
				return;
			}
			else {
				seat_a[seat_num-1] = 1;
				this.PrintCurrentState();
				System.out.println("����Ǿ����ϴ�");
			}
		}
		else if(seat_class == 2) {
			if(IsFullB()) {
				System.out.println("B���� �����Դϴ�");
				return;
			}
			System.out.println("�¼� ��ȣ�� �����ϼ���(1~10)");
			int seat_num = rd.nextInt();
			if(seat_num < 1 || seat_num > 10) {
				System.out.println("�߸��� ���ڸ� �Է��ϼ̽��ϴ�, �ٽ� �õ��ϼ���");
				return;
			}
			else if(this.seat_b[seat_num-1] == 1) {
				System.out.println("�� �¼��� �̹� ���� ���Դϴ�, �ٽ� �õ��ϼ���");
				return;
			}
			else {
				seat_b[seat_num-1] = 1;
				this.PrintCurrentState();
				System.out.println("����Ǿ����ϴ�");
			}
		}
		else {
			System.out.println("�߸��� ��ɾ� �Է�, ������ �����մϴ�");
			return;
		}
	}
	
	public void Lookup()
	{
		this.PrintCurrentState();
	}
	
	public void Cancel()
	{
		this.PrintCurrentState();
		System.out.println("�¼� ��Ҹ� �����մϴ�");
		System.out.println("�¼� ����� �����ϼ���(A:1, B:2)");
		int seat_class = rd.nextInt();
		if(seat_class == 1) {
			System.out.println("�¼� ��ȣ�� �����ϼ���(1~10)");
			int seat_num = rd.nextInt();
			if(seat_num < 1 || seat_num > 10) {
				System.out.println("�߸��� ���ڸ� �Է��ϼ̽��ϴ�, �ٽ� �õ��ϼ���");
				return;
			}
			else if(this.seat_a[seat_num-1] == 0) {
				System.out.println("�� �¼��� ��� �ֽ��ϴ�, �ٽ� �õ��ϼ���");
				return;
			}
			else {
				seat_a[seat_num-1] = 0;
				this.PrintCurrentState();
				System.out.println("��ҵǾ����ϴ�");
			}
		}
		else if(seat_class == 2) {
			System.out.println("�¼� ��ȣ�� �����ϼ���(1~10)");
			int seat_num = rd.nextInt();
			if(seat_num < 1 || seat_num > 10) {
				System.out.println("�߸��� ���ڸ� �Է��ϼ̽��ϴ�, �ٽ� �õ��ϼ���");
				return;
			}
			else if(this.seat_b[seat_num-1] == 0) {
				System.out.println("�� �¼��� ��� �ֽ��ϴ�, �ٽ� �õ��ϼ���");
				return;
			}
			else {
				seat_b[seat_num-1] = 0;
				this.PrintCurrentState();
				System.out.println("��ҵǾ����ϴ�");
			}
		}
		else {
			System.out.println("�߸��� ��ɾ� �Է�, ������ �����մϴ�");
			return;
		}

	}
}

public class TheaterTest {
	public static void main(String args[]) {
		Theater a = new Theater();
		a.StartProgram();
	}
}
