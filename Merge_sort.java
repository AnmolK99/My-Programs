import java.util.*;
/**
 * Write a description of class sort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Merge_sort
{
    void printarray(int ar[],int i,int j) // To Print an array element between a bound
    {
        int n=j-i+1;
        for(int ii=i;ii<=j;ii++)
        System.out.print(ar[ii]+" ");
        System.out.println();
        return;
    }
    void printarray(int ar[]) // To Print whole array elements
    {
        int n=ar.length;
        for(int i=0;i<n;i++)
        System.out.print(ar[i]+" ");
        System.out.println();
        return;
    }
    public int[] sort(int ar[],int i,int j)
    {
        // System.out.println("-------------------------------");
        // System.out.println("i=="+i+"\nj=="+j+"\n");
        // printarray(ar);
        if(i==j)
        {
            int ar1[]=new int[1];
            ar1[0]=ar[i];
            // System.out.print("returning ");
            // printarray(ar1);
            return ar1;
        }
        if((j-i)==1)
        {
            int ar1[]=new int[2];
            if(ar[i]>ar[j])
            {
                ar1[0]=ar[j];
                ar1[1]=ar[i];
            }
            else
            {
                ar1[0]=ar[i];
                ar1[1]=ar[j];
            }
            // System.out.print("returning ");
            // printarray(ar1);
            return ar1;
        }
        else
        {
            int mid=(i+j)/2;
            int ar1[]=sort(ar,i,mid);
            int ar2[]=sort(ar,mid+1,j);
            // System.out.print("first array ");
            // printarray(ar1);
            // System.out.print("second array ");
            // printarray(ar2);
            int l1=ar1.length;
            int l2=ar2.length;
            int pos1=0,pos2=0,pos3=0;
            int ar3[]=new int[l1+l2];
            while(pos3<(l1+l2))
            {
                if(pos1==l1)
                {
                    ar3[pos3++]=ar2[pos2++];
                    continue;
                }
                if(pos2==l2)
                {
                    ar3[pos3++]=ar1[pos1++];
                    continue;
                }
                if(ar1[pos1]>ar2[pos2])
                {
                    ar3[pos3++]=ar2[pos2++];
                    continue;
                }
                if(ar1[pos1]<=ar2[pos2])
                {
                    ar3[pos3++]=ar1[pos1++];
                    continue;
                }
            }
            // System.out.print("returning ");
            // printarray(ar3);
            return ar3;
        }
    }
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ar[]=new int[n];
        
        for(int i=0;i<n;i++)
        ar[i]=sc.nextInt();
        
        Merge_sort ob=new Merge_sort();
        int arr[]=ob.sort(ar,0,n-1);
        
        for(int i=0;i<n;i++)
        System.out.print(arr[i]+" ");
    }
}
