import java.util.*;

public class ScalesSolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ScalesSolution s = new ScalesSolution("01010x");
		s.println();

		ArrayList<Double> test = new ArrayList<Double>(5);
		test.add((double)1);
		test.add((double)2);
		test.add((double)3);
		test.add((double)4);
		test.add((double)10);
		System.out.println(s.ScalesFitness(test));
		System.out.println(s.ScalesFitness(CS2004.ReadNumberFile("/Users/KavishLeckraz 1/Downloads/1000Primes.txt")));
		/*ScalesSolution s = new ScalesSolution("11111");
		s.println();
		s.SmallChange();
		s.println();
		ScalesSolution s1 = new ScalesSolution(10);
		s1.println();
		ScalesSolution s2 = new ScalesSolution(s1.GetSol());
		s2.println();*/

	}
	private String scasol;
	//Creates a new scales solution based on a string parameter
	//The string parameter is checked to see if it contains all zeros and ones
	//Otherwise the random binary string generator is used (n = length of parameter)
	public ScalesSolution(String s)
	{
		boolean ok = true;
		int n = s.length();
		for(int i=0;i<n;++i)
		{
			char si = s.charAt(i);
			if (si != '0' && si != '1') ok = false;
		}
		if (ok)
		{
			scasol = s;
		}
		else
		{
			scasol = RandomBinaryString(n);
		}
	}
	private static String RandomBinaryString(int n)
	{
		String s = new String();
		//Code goes here
		//Create a random binary string of just ones and zeros of length n
		for(int i = 0; i < n; i++) {
			int a = CS2004.UI(0,1);
			if(a == 0) {
				s += '0';
			}else {
				s += '1';
			}
		}
	return(s);
	}
	static public int UI(int aa,int bb)
	{
		Random rand = new Random();
		int a = Math.min(aa,bb);
		int b = Math.max(aa,bb);
		int d = b - a + 1;
		int x = rand.nextInt(d) + a;
		return(x);
	}
	public ScalesSolution(int n) 
	{
		scasol = RandomBinaryString(n);	
	}
	//This is the fitness function for the Scales problem
	//This function returns -1 if the number of weights is less than
	//the size of the current solution
	public double ScalesFitness(ArrayList<Double> weights)
	{
		if (scasol.length() > weights.size()) return(-1);
		double lhs = 0.0,rhs = 0.0;
		int n = scasol.length();
		
		//Code goes here
		//Check each element of scasol for a 0 (lhs) and 1 (rhs) add the weight wi
		//to variables lhs and rhs as appropriate
		
	for(int i = 0; i < n; i++) {
		if(scasol.charAt(i) == '0') {
			lhs += weights.get(i);
		}else {
			rhs += weights.get(i);
		}
	}
		return(Math.abs(lhs-rhs));
	}
	//Display the string without a new line
	public void print()
	{
		System.out.print(scasol);
	}
	//Display the string with a new line
	public void println()
	{
		print();
		System.out.println();
	}
	public void SmallChange() {
		int p, n;
		n = scasol.length(); p = CS2004.UI(0,n-1);
		String x = "";
		for(int i = 0; i < p; i++) {
			x += scasol.charAt(i);
		}
		if(scasol.charAt(p) == '0') {
			x += '1';
		}else {
			x += '0';
		}
		for(int i = p+1; i < n; i++) {
			x += scasol.charAt(i);
		}
		scasol = x;
	}
	public String GetSol()
	{
		return(scasol);
	}
}
