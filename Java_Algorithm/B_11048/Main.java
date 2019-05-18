import java.util.*;

class Solver
{
	int n;
	int m;
	int[][] maze;
	int[][] max_score;
	
	int Max(int a, int b, int c)
	{
		if(a > b) {
			if(c > a)
				return c;
			else
				return a;
		}
		else {
			if(c > b)
				return c;
			else
				return b;
		}
	}
	
	int Max(int a, int b)
	{
		if(a > b)
			return a;
		else
			return b;
	}
	
	public int ans;
	
	Scanner rd = new Scanner(System.in);
	
	void GetArgs()
	{
		this.n = rd.nextInt();
		this.m = rd.nextInt();
		this.maze = new int[this.n][this.m];
		this.max_score = new int[this.n][this.m];
		for(int i = 0; i < this.n; i++) {
			for(int j = 0; j < this.m; j++) {
				this.maze[i][j] = rd.nextInt();
			}
		}
	}
	
	void Compute()
	{
		for(int i = 0; i < this.n; i++) {
			for(int j = 0; j < this.m; j++) {
				if(i > 0 && j > 0) {
					this.max_score[i][j] = this.maze[i][j];
					this.max_score[i][j] += this.Max(this.max_score[i-1][j-1],
							this.max_score[i-1][j], this.max_score[i][j-1]);
				}
				else if(i == 0 && j > 0) {
					this.max_score[i][j] = this.maze[i][j];
					this.max_score[i][j] += this.max_score[i][j-1];
					
				}
				else if(i > 0 && j == 0) {
					this.max_score[i][j] = this.maze[i][j];
					this.max_score[i][j] += this.max_score[i-1][j];
				}
				else {
					this.max_score[i][j] = this.maze[i][j];
				}
			}
		}
		this.ans = this.max_score[this.n-1][this.m-1];
	}
	
}

public class Main
{
	public static void main(String args[])
	{
		Solver a = new Solver();
		a.GetArgs();
		a.Compute();
		System.out.println(a.ans);
		
	}
}