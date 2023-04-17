import java.util.ArrayList;
import java.util.Random;

public class CS2004_Scales_B {
	public static ArrayList<Short> RunScales(int iteration,ArrayList<Double> weights) {
		if(null == weights ) {
			return null;
		}else if(weights.isEmpty()==true) {
			ArrayList<Short> empty = new ArrayList<Short>();
			return empty;
		}else if(iteration<0) {
			return null;
		}
		int n = weights.size();
		CS2004_Scales_B sol = new CS2004_Scales_B(n);
		for(int i = 0; i < iteration; i++) {
			double currentFit = sol.ScalesFitness(weights);
			CS2004_Scales_B oldsol = new CS2004_Scales_B(sol.GetSol());
			sol.SmallChange();
			double newFit = sol.ScalesFitness(weights);
			if(newFit > currentFit) {
				sol = new CS2004_Scales_B(oldsol.GetSol());
			}
		}
		ArrayList<Short> answer = new ArrayList<Short>();
		for(int i=0; i<n; i++) {
			if(sol.charAt(i)=='0') {
				answer.add((short) 0);
			}else {
				answer.add((short) 1);
			}
		}
		return(answer);
	}
	private char charAt(int i) {
		return scasol.charAt(i);
	}
	private String scasol;
	public CS2004_Scales_B(int n) 
	{
		scasol = RandomBinaryString(n);	
	}
	public CS2004_Scales_B(String s)
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
			s += UI(1,10) % 2;
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
	public void SmallChange() {
		int p, n;
		n = scasol.length(); p = UI(0,n-1);
		String x = "";
		for(int i = 0; i < p; i++) {
			x += scasol.charAt(i);
		}
		if(scasol.charAt(p) == '0') {
			x += '1';
		}else if(scasol.charAt(p) == '1'){
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
