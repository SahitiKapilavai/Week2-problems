import java.util.Scanner;

class SegmentTree  
{ 
    int st[]; 
    SegmentTree(int arr[], int n) 
    { 
        int x = (int) (Math.ceil(Math.log(n) / Math.log(2))); 
        int max_size = 2 * (int) Math.pow(2, x) - 1; //2*2^[log(n)base2]-1
        st = new int[max_size];
        build(arr, 0, n - 1, 0); //Creates Segment Tree Array
    } 
    
    int getMid(int s, int e) { 
        return (s + e)/ 2; 
    } 
    
    int build(int arr[], int ss, int se, int si) //parameters:input array, segment start & end,current index of segment
    { //If segment size is 1 i.e leaf node
        if (ss == se) { 
            st[si] = arr[ss]; 
            return arr[ss]; 
        } 
        //Updates ST array by finding sum of left and right segments
        int mid = getMid(ss, se); 
        st[si] = build(arr, ss, mid, si * 2 + 1) + build(arr, mid + 1, se, si * 2 + 2); 
        return st[si]; 
    } 
    
    int getSum(int ss, int se, int qs, int qe, int si) //parameters:segment start&end,query start&end,current index of segment
    { 
        if (qs <= ss && qe >= se) //complete overlap
            return st[si]; 
        if (se < qs || ss > qe) //no overlap
            return 0; 
        //partial overlap of query over segment
        int mid = getMid(ss, se); 
        return getSum(ss, mid, qs, qe, 2 * si + 1) + getSum(mid + 1, se, qs, qe, 2 * si + 2); 
    } 
    
    void updateAST(int arr[], int n, int i, int new_val) 
    { 
        int diff = new_val - arr[i]; 
        arr[i] = new_val; //Update Input Array
        updateST(0, n - 1, i, diff, 0); //Update Segment Tree
    } 
    
    void updateST(int ss, int se, int i, int diff, int si) ////parameters:segment start&end,position, difference,current index of segment
    { 
        if (i < ss || i > se) //position lies outside segment
            return; 
        st[si] = st[si] + diff; //Else Update segment
        if (se != ss) { 
            int mid = getMid(ss, se); 
            updateST(ss, mid, i, diff, 2 * si + 1); //Update left segment if position within range
            updateST(mid + 1, se, i, diff, 2 * si + 2); //Update right segment if position within range
        } 
    } 
    
    public static void main(String args[]) 
    { 
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array elements:");
        String ar[]=sc.nextLine().split(" ");
        int n = ar.length,i=0; 
        int arr[] = new int[n];
        for(String s:ar)
        	arr[i++]=Integer.parseInt(s);
        SegmentTree  tree = new SegmentTree(arr, n); //Allocates memory to SegmentTree & calls build()
        System.out.println("Enter query range:");
        int qs=sc.nextInt();
        int qe=sc.nextInt();
        System.out.println("Sum of values in given range = " + tree.getSum(0, n - 1, qs, qe, 0)); 
        System.out.println("Enter position and value to update:");
        int p=sc.nextInt();
        int v=sc.nextInt();
        tree.updateAST(arr, n, p, v); //Updates given array and segment tree
        System.out.println("Updated sum of values in given range = " + tree.getSum(0, n - 1, qs, qe, 0)); 
        sc.close();
    } 
} 