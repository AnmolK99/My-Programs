/**
 * Write a description of class G here.
 *
 * @author (Launda 1)
 * @version (a version number or a date)
 */
import java.util.*;
public class GoldMine_Problem
{
    static Scanner sc=new Scanner(System.in);
    public static void main(String []args)
    {
        System.out.println("Enter row and column numbers");
        int n=sc.nextInt();
        int m=sc.nextInt();
        int mine[][]=new int[n][m];
        int ar[][]=new int[n][m];
        System.out.println("Enter gold values");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                ar[i][j]=1000000;
                mine[i][j]=sc.nextInt();
            }
        }
        
        for(int j=0;j<m;j++)
        {
            for(int i=0;i<n;i++)
            {
                if(j==0)
                {
                    ar[i][j]=mine[i][j];
                    continue;
                }
                if(i==0)
                {
                    int val=ar[i][j-1];
                    if(i<n-1 && ar[i+1][j-1]<val)
                    val=ar[i+1][j-1];
                    ar[i][j]=mine[i][j]+val;
                }
                if(i==(n-1))
                {
                    int val=ar[i][j-1];
                    if(i>0 && ar[i-1][j-1]<val)
                    val=ar[i-1][j-1];
                    ar[i][j]=mine[i][j]+val;
                }
                if(i>0 && i<n-1)
                {
                    int val=ar[i][j-1];
                    if(ar[i-1][j-1]<val)
                    val=ar[i-1][j-1];
                    if(ar[i+1][j-1]<val)
                    val=ar[i+1][j-1];
                    ar[i][j]=mine[i][j]+val;
                }
            }
        }
        System.out.println("Original array");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            System.out.print(mine[i][j]+" ");
            System.out.println();
        }
        System.out.println("minimum array");
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            System.out.print(ar[i][j]+" ");
            System.out.println();
        }
        
        int min=ar[0][m-1];
        for(int i=0;i<n;i++)
        {
            if(ar[i][m-1]<min)
            min=ar[i][m-1];
        }
        System.out.println(min);
    }
}
