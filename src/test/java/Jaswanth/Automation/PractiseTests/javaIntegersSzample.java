package Jaswanth.Automation.PractiseTests;

public class javaIntegersSzample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 191;
		
		int X=4;
		String temp = Integer.toString(N);
		int[] d = new int[temp.length()];
		for(int i = 0; i< temp.length();i++)
		{int k=-1;
			for(int j=0;j<=X;j++) {
				k=k+1;
				d[i] = Character.getNumericValue(temp.charAt(i)); 
				d[i]+=j;				
				if(d[i]==9) 
					break;				
				}
			X=X-k;
			System.out.print(d[i]);
			
				
				}
			
			
		}

	}


