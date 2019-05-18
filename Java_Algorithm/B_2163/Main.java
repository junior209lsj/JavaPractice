import java.util.*;

class Chocolate
{
    int m;
    int n;
    public int ans;
    Scanner rd = new Scanner(System.in);

    void InputArgs()
    {
        this.m = rd.nextInt();
        this.n = rd.nextInt();
    }

    void Compute()
    {
        this.ans = this.m * this.n - 1;
    }

}

public class Main
{
    public static void main(String args[])
    {
        Chocolate a = new Chocolate();
        a.InputArgs();
        a.Compute();
        System.out.println(a.ans);
    }
}