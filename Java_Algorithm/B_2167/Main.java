import java.util.*;

class Solver
{
    int m;
    int n;
    public int k;
    int[][] map;
    int[][] sum_map;
    int[][] loc;
    int[] I;
    int[] J;
    int[] X;
    int[] Y;

    Scanner rd = new Scanner(System.in);

    public int[] ans;

    void GetArgs() 
    {
        this.n = rd.nextInt();
        this.m = rd.nextInt();
        this.map = new int[this.n][this.m];
        this.sum_map = new int[this.n][this.m];
        for(int i = 0; i < this.n; i++) {
            for(int j = 0; j < this.m; j++) {
                this.map[i][j] = rd.nextInt();
            }
        }
        this.k = rd.nextInt();
        this.ans = new int[this.k];
        this.I = new int[this.k];
        this.J = new int[this.k];
        this.X = new int[this.k];
        this.Y = new int[this.k];
        for(int i = 0 ; i < this.k; i++) {
        	this.I[i] = rd.nextInt() - 1;
        	this.J[i] = rd.nextInt() - 1;
        	this.X[i] = rd.nextInt() - 1;
        	this.Y[i] = rd.nextInt() - 1;
        }
    }

    void Compute()
    {
        for(int i = 0; i < this.n; i++) {
            for(int j = 0; j < this.m; j++) {
            	this.sum_map[i][j] = this.map[i][j];
            	if(i > 0 && j > 0) {
            		this.sum_map[i][j] += this.sum_map[i-1][j] +
            				this.sum_map[i][j-1] -
            				this.sum_map[i-1][j-1];
            	}
            	else if(i == 0 && j > 0) {
            		this.sum_map[i][j] += this.sum_map[i][j-1];
            	}
            	else if(i > 0 && j == 0) {
            		this.sum_map[i][j] += this.sum_map[i-1][j];
            	}
            }
        }
        
        for(int i = 0; i < this.k; i++) {
        	this.ans[i] += this.sum_map[this.X[i]][this.Y[i]];
        	if(this.I[i] > 0 && this.J[i] > 0) {
        		this.ans[i] -= this.sum_map[this.I[i]-1][this.Y[i]] +
        				this.sum_map[this.X[i]][this.J[i]-1] -
        				this.sum_map[this.I[i]-1][this.J[i]-1];
        	}
        	if(this.I[i] == 0 && this.J[i] > 0) {
        		this.ans[i] -= this.sum_map[this.X[i]][this.J[i]-1]; 
        	}
        	if(this.I[i] > 0 && this.J[i] == 0) {
        		this.ans[i] -= this.sum_map[this.I[i]-1][this.Y[i]];
        	}
        	
        }
    }
}

public class Main
{
    public static void main(String args[])
    {
    	Solver a = new Solver();
    	a.GetArgs();
    	a.Compute();
    	for(int i = 0; i < a.k; i++) {
    		System.out.println(a.ans[i]);
    	}

    }
}
