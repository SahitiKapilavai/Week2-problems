import java.util.*;
class Frequency
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the array");
		String ar[]=sc.nextLine().split(" ");
        int n = ar.length,i=0; 
        int arr[] = new int[n];
        System.out.println("Enter k value");
        int k=sc.nextInt();
        for(String s:ar)
        	arr[i++]=Integer.parseInt(s);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int j=0;j<arr.length;j++)
        {if(!map.containsKey(arr[j]))
        	map.put(arr[j], 1);	
        else
        {
        	map.put(arr[j], map.get(arr[j])+1);
        }
        }
        System.out.println(map.get(k));
        sc.close();
	}
}