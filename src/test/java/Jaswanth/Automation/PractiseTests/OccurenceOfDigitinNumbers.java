package Jaswanth.Automation.PractiseTests;

import java.util.Scanner;

public class OccurenceOfDigitinNumbers
{
	
	static int count_3s(int n)
	{
		int count = 0;
		while (n > 0)
			{
				if (n % 10 == 7)
					{
						count++;
					}
		n = n / 10;
			}
		return count;
	}

	static int count_in_range(int n)
	{
	int count = 0 ;
	for (int i = 2; i <= n; i++)
		{
			count += count_3s(i);
		}
	return count;
	}

	public static void main(String[] args)
		{
		int number;
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number : ");
		number = sc.nextInt();
		System.out.print(count_in_range(number));
		}

}
