import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CS2004_TSP_B {
	public static ArrayList<Integer> RunTSP(int iterations, float[][] distances) {
		if(null == distances ) {
			ArrayList<Integer> empty = new ArrayList<Integer>();
			return empty;
		}else if(distances.length==0) {
			return null;
		}else if(iterations<0) {
			return null;
		}
		int n = distances.length;
		CS2004_TSP_B sol = new CS2004_TSP_B(n);
		for(int i=0; i<iterations; ++i) {
			float currentFit = sol.TourFitness(distances);
			CS2004_TSP_B oldsol = new CS2004_TSP_B(sol.GetSol());
			sol.SmallChange();
			float newfit = sol.TourFitness(distances);
			if(newfit > currentFit) {
			sol = new CS2004_TSP_B(oldsol.GetSol());
			}
		}
		ArrayList<Integer> answer = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			answer.add(sol.get(i));
			System.out.print(answer.get(i));
		}
		return answer;
	}
	private Integer get(int i) {
		return tourSol.get(i);
	}
	private ArrayList<Integer> tourSol = new ArrayList<Integer>();
	public float TourFitness(float[][] D)
	{
		float s=0;
		int n = D.length;
		for(int i=0; i < n-1; i++) {
			int a = tourSol.get(i);
			int b = tourSol.get(i+1);
			s += D[a][b];
		}
		int end = tourSol.get(n-1);
		int start = tourSol.get(0);
		s += D[end][start];
		return s;
	}
	public static ArrayList<Integer> RandomTSPSolution(int n)
	{
		ArrayList<Integer> p = new ArrayList<Integer>(n);
		for(int i=0; i<n; i++) {
			p.add(i);
		}
		ArrayList<Integer> t = new ArrayList<Integer>(n);
		while(p.size() > 0) {
			int j = UI(0, p.size()-1);
			t.add(p.get(j));
			p.remove(p.get(j));
		}
		return t;
	}
	public void SmallChange() {
		int i=0, j=0;
		while(i==j){
			i = UI(1, tourSol.size());
			j = UI(1, tourSol.size());
		}
		Collections.swap(tourSol, i-1, j-1);
	}
	public CS2004_TSP_B(int n) 
	{
		tourSol = RandomTSPSolution(n);	
	}
	public ArrayList<Integer> GetSol()
	{
		return(tourSol);
	}
	public CS2004_TSP_B(ArrayList<Integer> c)
	{
		tourSol.addAll(c);
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
}
