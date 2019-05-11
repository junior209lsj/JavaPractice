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
		System.out.println("번호를 선택하세요(예약: 1, 조회: 2, 취소: 3, 끝내기: 4)");
	}
	
	public void PrintWelcomePage()
	{
		System.out.println(this.theater_name + ": 극장 좌석 예약 시스템입니다.");
	}
	
	public void PrintEndPage()
	{
		System.out.println("극장 예약 시스템을 종료합니다");
		System.out.println("지금까지 " + this.theater_name +
				"를 이용해주셔서 감사합니다");
		
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
				System.out.println("유효하지 않은 명령어입니다. 다시 입력해 주세요");
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
		System.out.println("좌석 예약 현황입니다(빈좌석 0, 예약좌석 1)");
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
		System.out.println("좌석 예약을 진행합니다");
		System.out.println("좌석 등급을 선택하세요(A:1, B:2)");
		int seat_class = rd.nextInt();
		if(seat_class == 1) {
			if(IsFullA()) {
				System.out.println("A석은 매진입니다");
				return;
			}
			System.out.println("좌석 번호를 선택하세요(1~10)");
			int seat_num = rd.nextInt();
			if(seat_num < 1 || seat_num > 10) {
				System.out.println("잘못된 숫자를 입력하셨습니다, 다시 시도하세요");
				return;
			}
			else if(this.seat_a[seat_num-1] == 1) {
				System.out.println("그 좌석은 이미 예약 중입니다, 다시 시도하세요");
				return;
			}
			else {
				seat_a[seat_num-1] = 1;
				this.PrintCurrentState();
				System.out.println("예약되었습니다");
			}
		}
		else if(seat_class == 2) {
			if(IsFullB()) {
				System.out.println("B석은 매진입니다");
				return;
			}
			System.out.println("좌석 번호를 선택하세요(1~10)");
			int seat_num = rd.nextInt();
			if(seat_num < 1 || seat_num > 10) {
				System.out.println("잘못된 숫자를 입력하셨습니다, 다시 시도하세요");
				return;
			}
			else if(this.seat_b[seat_num-1] == 1) {
				System.out.println("그 좌석은 이미 예약 중입니다, 다시 시도하세요");
				return;
			}
			else {
				seat_b[seat_num-1] = 1;
				this.PrintCurrentState();
				System.out.println("예약되었습니다");
			}
		}
		else {
			System.out.println("잘못된 명령어 입력, 예약을 종료합니다");
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
		System.out.println("좌석 취소를 진행합니다");
		System.out.println("좌석 등급을 선택하세요(A:1, B:2)");
		int seat_class = rd.nextInt();
		if(seat_class == 1) {
			System.out.println("좌석 번호를 선택하세요(1~10)");
			int seat_num = rd.nextInt();
			if(seat_num < 1 || seat_num > 10) {
				System.out.println("잘못된 숫자를 입력하셨습니다, 다시 시도하세요");
				return;
			}
			else if(this.seat_a[seat_num-1] == 0) {
				System.out.println("그 좌석은 비어 있습니다, 다시 시도하세요");
				return;
			}
			else {
				seat_a[seat_num-1] = 0;
				this.PrintCurrentState();
				System.out.println("취소되었습니다");
			}
		}
		else if(seat_class == 2) {
			System.out.println("좌석 번호를 선택하세요(1~10)");
			int seat_num = rd.nextInt();
			if(seat_num < 1 || seat_num > 10) {
				System.out.println("잘못된 숫자를 입력하셨습니다, 다시 시도하세요");
				return;
			}
			else if(this.seat_b[seat_num-1] == 0) {
				System.out.println("그 좌석은 비어 있습니다, 다시 시도하세요");
				return;
			}
			else {
				seat_b[seat_num-1] = 0;
				this.PrintCurrentState();
				System.out.println("취소되었습니다");
			}
		}
		else {
			System.out.println("잘못된 명령어 입력, 예약을 종료합니다");
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
