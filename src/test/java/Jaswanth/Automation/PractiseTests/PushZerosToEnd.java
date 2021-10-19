package Jaswanth.Automation.PractiseTests;

public class PushZerosToEnd 
{
	// Function which pushes all zeros to end of an array.

    static void pushZerosToEnd(int arr[], int n)

    {

        int count = 0; 

        for (int i = 0; i < n; i++)

            if (arr[i] != 0)

                arr[count++] = arr[i]; 

        while (count < n)

            arr[count++] = 0;

    }

    public static void main (String[] args)

    {

        int arr[] = {1,0,2,3};

        int n = arr.length;

        pushZerosToEnd(arr, n);

        System.out.println("Array after pushing zeros to the back: ");

        for (int i=0; i<n; i++)

            System.out.print(arr[i]+" ");

    }

}
