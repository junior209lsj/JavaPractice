package string_game;

import java.util.*;

class StringGame
{
	private String[] words = {"ubuntu", "fedora", "centos",
			"opensuse", "debian"};
	private int index;
	private String solution;
	int flag[];
	Scanner rd = new Scanner(System.in);
	
	public void Initialize()
	{
		int size = this.words.length;
		int tmp = (int)(Math.random()*size);
		this.index = tmp;
		this.solution = words[this.index];
		int tmp_flag[] = new int[this.solution.length()];
		flag = tmp_flag;
	}
	
	public void PrintCurrentState()
	{
		System.out.printf("현재의 상태: ");
		for(int i = 0; i < flag.length; i++) {
			if(flag[i] == 0) {
				System.out.printf("_ ");
			}
			else {
				System.out.printf("%c ", solution.charAt(i));
			}
		}
		System.out.printf("\n");
	}
	
	public void Game()
	{
		System.out.println("리눅스 배포판 이름을 맞춰보아요!");
		char guess;
		boolean cont = true;
		int cnt = 0;
		this.Initialize();
		do {
			cnt = 0;
			this.PrintCurrentState();
			System.out.printf("글자를 추측하시오: ");
			guess = rd.next().charAt(0);
			for(int i = 0; i < solution.length(); i++) {
				if(guess == solution.charAt(i))
					flag[i] = 1;
			}
			for(int i = 0; i < flag.length; i++) {
				cnt += flag[i];
			}
			if(cnt == flag.length) cont = false;
		} while(cont);
		this.PrintCurrentState();
		System.out.println("정답!");
	}
	
	
}

public class StringGameTest 
{
	
	public static void main(String args[])
	{
		StringGame a = new StringGame();
		a.Game();
	}

}
