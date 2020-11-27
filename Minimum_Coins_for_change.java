import java.util.*;
/**
 * Write a description of class Coins here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Minimum_Coins_for_change
{
    static Scanner sc=new Scanner(System.in);
    public static void main(String args[])
    {
        // put your code here
        System.out.println("Enter number of coins");
        int noc=sc.nextInt();
        int coins[]=new int[noc];
        for(int i=0;i<noc;i++)
        {
            coins[i]=sc.nextInt();
        }
        System.out.println("Enter value of n");
        int n=sc.nextInt();
        int ar[]=new int[n+1];
        ar[0]=0;
        for(int i=1;i<=n;i++)
        ar[i]=-1;
        for(int i=1;i<=n;i++)
        {
            for(int j=0;j<noc;j++)
            {
                int prepos=i-coins[j];
                if(prepos>=0 && (ar[i]>ar[prepos]+1 || ar[i]==-1))
                {
                    ar[i]=ar[prepos]+1;
                    // System.out.println(i+" - "+ar[i]);
                }
            }
        }
        
        //for(int i=0;i<=n;i++)
        //System.out.println(i+" = "+ar[i]);
        System.out.println(ar[n]);
    }
}
