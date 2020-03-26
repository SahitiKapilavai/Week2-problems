import java.util.*;
class Frequency
{
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		//Scan input array
		System.out.println("Enter the array");
		String arr[]=sc.nextLine().split(" ");
        int arrayLength = arr.length,i=0; 
        int array[] = new int[arrayLength];
        for(String s:arr)
        	array[i++]=Integer.parseInt(s);
        //Scan k value
        System.out.println("Enter k value");
        int k=sc.nextInt();
        HashMap<Integer, Integer> Hashmap = new HashMap<>();
        //Create hashmap to store each element and it's frequency
        for(int j=0;j<array.length;j++)
        {//if element does not exist insert into hashmap and initialize frequency
        	if(!Hashmap.containsKey(array[j]))
        	Hashmap.put(array[j], 1);	
        //if the element exists increment frequency
        else
        {
        	Hashmap.put(array[j], Hashmap.get(array[j])+1);
        }
        }
        //Print the frequency for given k
        System.out.println(Hashmap.get(k));
        sc.close();
	}
}