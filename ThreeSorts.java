import java.util.*;
public class ThreeSorts 
{
	public static void main(String[]args) {
		
	}
	private static ArrayList<Integer> CopyArray(ArrayList<Integer> a)
	{
		ArrayList<Integer> resa = new ArrayList<Integer>(a.size());
		for(int i=0;i<a.size();++i) resa.add(a.get(i));
		return(resa);
	}
	public static ArrayList<Integer> BubbleSort(ArrayList<Integer> a) /* high to low*/
	{
		/*Each of those n times we're iterating through the whole array (for-loop in the code), 
		 meaning the worst case time complexity would be O(n^2)*/
		ArrayList<Integer> array = CopyArray(a);
		int n = a.size(),i;
		boolean noswaps = false;
		
		while (noswaps == false)
		{
			noswaps = true;
			for(i=0;i<n-1;++i)
			{
				if (array.get(i) < array.get(i+1))
				{
					Integer temp = array.get(i);
					array.set(i,array.get(i+1));
					array.set(i+1,temp);
					noswaps = false;
				}
			}
		}
		return(array);
	}
	public static ArrayList<Integer> RadixSort(ArrayList<Integer> a)
	{
		/*O(nb) very very fast*/
		ArrayList<Integer> array = CopyArray(a);
		Integer[] zero = new Integer[a.size()];
		Integer[] one = new Integer[a.size()];
		int i,b;
		Integer x,p;
		//Change from 8 to 32 for whole integers - will run 4 times slower
		for(b=0;b<8;++b)
		{
			int zc = 0;
			int oc = 0;
			for(i=0;i<array.size();++i)
			{
				x = array.get(i);
				p = 1 << b;
				if ((x & p) == 0)
				{
					zero[zc++] = array.get(i);
				}
				else
				{
					one[oc++] = array.get(i);
				}
			}
			for(i=0;i<oc;++i) array.set(i,one[i]);
			for(i=0;i<zc;++i) array.set(i+oc,zero[i]);
		}
		return(array);
	}
	public static ArrayList<Integer> PivotListSortC(ArrayList<Integer> a)
	{
		ArrayList<Integer> array = CopyArray(a);
		PivotListSort(array,0,array.size()-1);
		return(array);
	}
	public static void PivotListSort(ArrayList<Integer> array,int first,int last)
	{
		/*Quicksort is another Divide and Conquer algorithm. It picks one element of an array 
		 as the pivot and sorts all of the other elements around it, for example smaller elements
		 to the left, and larger to the right.
		 O(n^2)*/
		if (first < last)
		{
		   int pivot = PivotList(array,first,last);
		   PivotListSort(array,first,pivot-1);
		   PivotListSort(array,pivot+1,last);
		}	
	}
	private static void Swap(ArrayList<Integer> array,int a,int b)
	{
		Integer temp = array.get(a);
		array.set(a,array.get(b));
		array.set(b,temp);
	}
	private static int PivotList(ArrayList<Integer> array,int first,int last)
	{
		Integer PivotValue = array.get(first);
		int PivotPoint = first;
		for(int index=first+1;index<=last;++index)
		{
			if (array.get(index) > PivotValue)
			{
				PivotPoint = PivotPoint+1;
				Swap(array,PivotPoint,index);
			}
		}
		Swap(array,first,PivotPoint);
		return(PivotPoint);
	}
	public static ArrayList<Integer> RandomArray(Integer n){
		Random rand = new Random();
		rand.setSeed(System.currentTimeMillis());
		Integer r = Math.abs(rand.nextInt() % 256);
		ArrayList<Integer> res = new ArrayList<Integer>(n);
		for(int i = 0; i < n; i++) {
			res.add(i, r);
			r = Math.abs(rand.nextInt() % 256);
		}
		return res;
	}
	public static ArrayList<Integer> ShowArray(ArrayList<Integer> a){
		for(int j = 0; j < a.size(); j++) {
			System.out.print(a.get(j));
			System.out.print(',');
		}
		return a;
	}
	public static void RunAlgorithm()
	{
		long StartTime, EndTime, ElapsedTime;
			
		System.out.println("Testing algorithm …");
	
		// Save the time before the algorithm run
		StartTime=System.nanoTime();
	
		// Run the algorithm
		RadixSort(RandomArray(25000));
	
		// Save the time after the run
		EndTime=System.nanoTime();
	
		// Calculate the difference
		ElapsedTime= EndTime- StartTime;
	
		// Print it out
		System.out.println("The algorithm took " + ElapsedTime + " nano-seconds to run.");
	}
	public static ArrayList<Short> RandomArray(int n, short maxVal, short minVal){
		if(n <= 0) {
			return null;
		}else if(minVal > maxVal) {
			ArrayList<Short> Null = new ArrayList<Short>(n);
			return Null;
		}
		ArrayList<Short> res = new ArrayList<Short>(n);
		Random rand = new Random();
		short r = (short) (rand.nextInt((maxVal-minVal)+1)+minVal);
		for(int i = 0; i < n; i++) {
			res.add(i, r);
			r = (short) (rand.nextInt((maxVal-minVal)+1)+minVal);
		}
		for(int j = 0; j<n; j++) {
			System.out.print(res.get(j));
			System.out.print(',');
		}
		return res;
	}
}