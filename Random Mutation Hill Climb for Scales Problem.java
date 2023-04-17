import java.util.ArrayList;

public class Lab9 {

	public static void main(String[] args) {
		ArrayList<Double> test = new ArrayList<Double>();
		test.add((double) 1);
		test.add((double) 2);
		test.add((double) 3);
		test.add((double) 4);
		test.add((double) 10);
		//System.out.println(CS2004.ReadNumberFile("/Users/KavishLeckraz 1/Downloads/1000Primes.txt"));
		RMHC(CS2004.ReadNumberFile("/Users/KavishLeckraz 1/Downloads/TSP_48.txt"),10000);
		//RMHC(test,25);
	}
	public static ScalesSolution RMHC(ArrayList<Double> weights,int iter) {
		int n = weights.size();
		ScalesSolution sol = new ScalesSolution(n);
		for(int i = 0; i < iter; i++) {
			System.out.println("Iteration: " + i);
			double currentFit = sol.ScalesFitness(weights);
			ScalesSolution oldsol = new ScalesSolution(sol.GetSol());
			sol.SmallChange();
			double newFit = sol.ScalesFitness(weights);
			if(newFit > currentFit) {
				sol = new ScalesSolution(oldsol.GetSol());
			}
			System.out.println(currentFit);
		}
		return(sol);
	}
}
