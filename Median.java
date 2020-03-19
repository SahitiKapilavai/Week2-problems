import java.util.*; 
class Median{ 
	
	static float findmedian(int[] array, int start, int end) //to find median of array within given range
    { 
        int array_size = end-start + 1; 
        if (array_size % 2 == 0)
            return (array[start+(array_size/2)]+array[start+(array_size/2-1)])/(float)2;
        else 
            return array[start+(array_size/2)]; 
    } 
  
    static float median( int[] array1, int[] array2, int array1_start,int array2_start, int array1_end, int array2_end) 
    { 
        if (array1_end- array1_start == 1)  //if subarray size is 1
            return (Math.max(array1[array1_start],array2[array2_start])+ Math.min(array1[array1_end], array2[array2_end]))/(float)2;
        
        float median1 = findmedian(array1, array1_start, array1_end); 
        float median2 = findmedian(array2, array2_start, array2_end); 
        if (median1 == median2) 
            return median1; 
        else if (median1 < median2) //if array1 median is lesser,consider it's right subarray and array2 left subarray
            return median( array1, array2, (array1_end + array1_start + 1)/2, array2_start, array1_end, (array2_end + array2_start + 1)/2); 
        else  //if array2 median is lesser,consider it's right subarray and array1 left subarray
            return median(array1, array2, array1_start,(array2_end + array2_start + 1)/2,(array1_end + array1_start + 1)/2, array2_end);           
    } 

    
    public static void main(String[] args) 
    { 
    	Scanner sc=new Scanner(System.in);
        System.out.println("Enter array1 elements:");
        String ar1[]=sc.nextLine().split(" ");
        int array1_length= ar1.length,i=0; 
        int array1[] = new int[array1_length];
        for(String s:ar1)
        	array1[i++]=Integer.parseInt(s);
        i=0;
        System.out.println("Enter array2 elements:");
        String ar2[]=sc.nextLine().split(" ");
        int array2_length= ar2.length; 
        int array2[] = new int[array2_length];
        for(String s:ar2)
        	array2[i++]=Integer.parseInt(s);
        if (array1_length!= array2_length)
            System.out.println("Unequal sized arrays!");
       
        else if (array1_length == 1) //if arrays are of size 1
            System.out.println((array1[0] + array2[0])/(float)2); 
    
        else  
            System.out.println("Median: "+ median( array1, array2, 0, 0, array1_length - 1, array2_length - 1)); 
         
        sc.close();
    } 
} 