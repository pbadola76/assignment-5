import java.util.*;
import java.io.*;


public class MegaSort
{
    //Used merge sort
    public static void sort(int [] arr)
    {
        sort(arr, 0, arr.length-1);
    }

    public static void sort(int [] arr, int left, int right)
    {
        int mid=arr.length/2;
        if(arr.length<2)
        {
            return;
        }
    int [] Left = new int [mid];
    int [] Right = new int [arr.length-mid];


    for (int n = 0; n < mid; n++)
    {
        Left[n] = arr[n];
    }
    for (int m = mid; m <arr.length; m++)
    {
        Right[m-mid]=arr[m];
    }
    sort(Left);
    sort(Right);
    merge(arr, Left, Right);
    }
    public static void merge(int [] arr, int[] left, int[] right)
    {
        int n1 = left.length;
        int n2 = right.length;
        int i=0;
        int j=0;
        int index=0;
    //merge
        while(i < n1 && j < n2)
        {
            if(left[i] <= right[j])
            {
                arr[index] = left[i];
                i++;

            }
            else
            {
                arr[index] = right[j];
                j++;
            }
            index++;
        }

        while(i < n1)
        {
            arr[index]= left[i];
            index++;
            i++;
        }
        while(j < n2)
        {
            arr[index]= right[j];
            index++;
            j++;
        }
    }
    public static void main(String[] args) throws FileNotFoundException 
    {
        int [] arr = new int[1000000];

        File file = new File("1m-ints.txt");
        Scanner scan = new Scanner(file);

        int k = 0;
        while(scan.hasNextLine())
        {
            String milnum = scan.nextLine();
            int sorted = Integer.parseInt(milnum);
            arr[k++] = sorted;

        }
        sort(arr);
        for(int n = 0; n < arr.length; n++)
        {
            System.out.println(arr[n]);
        }
    }
}
