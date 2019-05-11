package dice;

class Dice
{
	private int value;
	
	public void Roll()
	{
		int tmp = (int)(Math.random() * 6) + 1;
		this.value = tmp;
	}
	
	public int GetValue()
	{
		return this.value;
	}
	
	public void SetValue()
	{
		this.Roll();
	}
	
}

public class DiceTest 
{
	public static void main(String args[])
	{
		Dice d1 = new Dice();
		Dice d2 = new Dice();
		
		int val1, val2;
		int cnt = 0;
		
		do {
			d1.SetValue();
			d2.SetValue();
			val1 = d1.GetValue();
			val2 = d2.GetValue();
			System.out.printf("주사위 1: %d, 주사위 2: %d\n", val1, val2);
			cnt++;
		} while(val1 + val2 != 2);
		System.out.printf("(1, 1)이 나오는 데 걸리는 횟수 = %d\n", cnt);
	}

}
