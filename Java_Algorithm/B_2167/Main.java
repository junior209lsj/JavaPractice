import java.io.*;
import java.util.*;

class Solver
{
    int m;
    int n;
    public int k;
    int[][] map;
    int[][] sum_map;
    int[][] location;

    BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    Scanner rd = new Scanner(System.in);
    String input_str;
    String[] tokens;

    public int[] ans;

    void GetArgs() throws IOException
    {
        this.n = rd.nextInt();
        this.m = rd.nextInt();
        this.map = new int[this.n][this.m];
        this.sum_map = new int[this.n][this.m];
        for(int i = 0; i < this.n; i++) {
            this.input_str = bf.readLine();
            this.tokens = this.input_str.split(" ", this.m);
            for(int j = 0; j < this.m; j++) {
                this.map[i][j] = Integer.parseInt(this.tokens[j]);
            }
        }
        this.k = rd.nextInt();
        this.ans = new int[this.k];
        this.location = new int[this.k][4];
        for(int i = 0 ; i < this.k; i++) {
            this.input_str = bf.readLine();
            this.tokens = this.input_str.split(" ", 4);
            this.location[i][0] = Integer.parseInt(this.tokens[0]) - 1;
            this.location[i][1] = Integer.parseInt(this.tokens[1]) - 1;
            this.location[i][2] = Integer.parseInt(this.tokens[2]) - 1;
            this.location[i][3] = Integer.parseInt(this.tokens[3]) - 1;
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
        	this.ans[i] += this.sum_map[this.location[i][2]][this.location[i][3]];
        	if(this.location[i][0] > 0 && this.location[i][1] > 0) {
        		this.ans[i] -= this.sum_map[this.location[i][0]-1][this.location[i][3]] +
        				this.sum_map[this.location[i][2]][this.location[i][1]-1] -
        				this.sum_map[this.location[i][0]][this.location[i][1]];
        	}
        	if(this.location[i][0] == 0 && this.location[i][1] > 0) {
        		this.ans[i] -= 
        				this.sum_map[this.location[i][2]][this.location[i][1]-1] -
        				this.sum_map[this.location[i][0]][this.location[i][1]];
        	}
        	if(this.location[i][0] > 0 && this.location[i][1] == 0) {
        		this.ans[i] -= this.sum_map[this.location[i][0]-1][this.location[i][3]] -
        				this.sum_map[this.location[i][0]][this.location[i][1]];
        	}
        	
        }
    }
}

public class Main
{
    public static void main(String args[])
    {
        Solver a = new Solver();
        try {
            a.GetArgs();
        } catch (IOException e) {
            System.out.println("a");
        }
    	a.Compute();
    	for(int i = 0; i < a.k; i++) {
    		System.out.println(a.ans[i]);
    	}

    }
}