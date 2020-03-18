import java.util.*;
class Paranthesis
{
	void printparan(char[] s,int n,int nopen,int nclose,int i) //paranthesis string, max opens/closes, open count, close count,next index
	{
		if(nclose==n) //Print string if close count has reached max close
		{
			for(char a:s)
			{
				System.out.print(a);
			}
			System.out.println();
			return;
		}
		else
		{
			if(nopen<n)//Add open bracket if open count less than max opens
			{
				s[i]='(';
				printparan(s,n,nopen+1,nclose,i+1);
			}
			if(nclose<nopen)//Add close bracket if close count is less than open count
			{s[i]=')';
				printparan(s,n,nopen,nclose+1,i+1);
			}
		}
	}
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of brackets:");
		int n=sc.nextInt();
		if(n<0) //Can't enter negative
			System.out.println("Invalid");
		else if(n%2==1) //As we can't form balanced string with odd bracket count
			System.out.println("Can't balance!");
		else
		{char[] s=new char[n];
		Paranthesis p=new Paranthesis();
		p.printparan(s,n/2,0,0,0);
		}
		sc.close();
		}	
}

/*
Test Cases:
1. 2
()

2. 6
((()))
(()())
(())()
()(())
()()()

3. 3
Can't balance!

4. 0

5. -1
Invalid!

 */ 
