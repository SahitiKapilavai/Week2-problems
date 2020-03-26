import java.util.*;
class Minimize
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		//Input Array A
		System.out.println("Enter arrayA");
		String ar[]=sc.nextLine().split(" ");
        int A_Size = ar.length,i=0; 
        int arrayA[] = new int[A_Size];
        for(String s:ar)
        	arrayA[i++]=Integer.parseInt(s);
        //Input Array B
        System.out.println("Enter arrayB");
		ar=sc.nextLine().split(" ");
        int B_Size = ar.length;
        i=0; 
        int arrayB[] = new int[B_Size];
        for(String s:ar)
        	arrayB[i++]=Integer.parseInt(s);
        //Input Array C
        System.out.println("Enter arrayC");
		ar=sc.nextLine().split(" ");
        int C_Size = ar.length;
        i=0; 
        int arrayC[] = new int[C_Size];
        for(String s:ar)
        	arrayC[i++]=Integer.parseInt(s);
        //Traverse from largest to smallest
        int a,b,c;
        a=A_Size-1;
        b=B_Size-1;
        c=C_Size-1;
        int minDiff, diff, maxVal; 
        //Find minimum difference
            minDiff = Math.abs(Math.max(arrayA[a], Math.max(arrayB[b], arrayC[c])) - Math.min(arrayA[a], Math.min(arrayB[b], arrayC[c]))); 
            while (a!= -1 && b!= -1 && c != -1)  
            { //Recalculate minimum difference with updated value
                diff = Math.abs(Math.max(arrayA[a], Math.max(arrayB[b], arrayC[c])) - Math.min(arrayA[a], Math.min(arrayB[b], arrayC[c]))); 
                if (diff < minDiff) 
                    minDiff = diff; 
                //Reduce the maximum value by traversing to left of that array 
                maxVal = Math.max(arrayA[a], Math.max(arrayB[b], arrayC[c]));  
                if (arrayA[a] == maxVal) 
                    a -= 1; 
                else if (arrayB[b] == maxVal) 
                    b -= 1; 
                else
                    c -= 1; 
            } 
            System.out.println(minDiff);
        sc.close();
	}
}