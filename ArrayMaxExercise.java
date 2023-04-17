
public class ArrayMaxExercise {

	public static void main(String[] args) {
		double [][] a = new double[3][3];
		a [0][0] = 1;
		a [0][1] = 2;
		a [0][2] = -2;
		a [1][0] = 0;
		a [1][1] = 9;
		a [1][2] = 0;
		a [2][0] = 0;
		a [2][1] = 0;
		a [2][2] = -1;
		
		System.out.println(ArrayMax(a));
		System.out.println(ArrayMin(a));
		System.out.println(LinearSum(100));
		System.out.println(LinearSumWhile(100));
		System.out.println(GeoSum(3,2));
		System.out.println(GeoSumLoop(3,3));
		RunAlgorithm();
	}
	public static double ArrayMax(double a[][]) {
		
		double CurrentMax = a[0][0];
		for (int i = 0; i < a.length; i++) {
			for (int m = 0; m < a[0].length; m++) {
				if (a[i][m] > CurrentMax) {
					CurrentMax = a[i][m];
				}
			}
		}
		
		return CurrentMax;
	}
	public static double ArrayMin(double a[][]) {
		
		double CurrentMin = a[0][0];
		for (int i = 0; i < a.length; i++) {
			for (int m = 0; m < a[0].length; m++) {
				if (a[i][m] < CurrentMin) {
					CurrentMin = a[i][m];
				}
			}
		}
		
		return CurrentMin;
	}
	public static double LinearSum(double b) {
		
		double sum = 0;
		
		for(int i = 1; i <= b; ++i) {
			sum = sum + i;
		}
		
		return sum;
	}
	public static double LinearSumWhile(double b) {
		
		double sum = 0, i = 1;
		
		while(i <= b) {
			sum = sum + i;
			i++;
		}
		
		return sum;
	}
	public static double SumFormula(double b) {
		
		double sum = (b * (b+1))/2;
		
		return sum;
	}
	public static double GeoSum(double a, double N) {
		
		// The code below represents Sn = 1-a^(N+1)/1-a //
		
		double sum = ((1-(Math.pow(a, N+1)))/(1-a));
		
		return sum;
	}
	public static double GeoSumLoop(double a, double N) {
		
		double sum = 0;
		
		for(int i = 0; i <= N; i++) {
			sum = sum + (Math.pow(a, N-i));
		}
		
		return sum;
	}

	public static void RunAlgorithm()
	{
		long StartTime, EndTime, ElapsedTime;
			
		System.out.println("Testing algorithm …");
	
		// Save the time before the algorithm run
		StartTime=System.nanoTime();
	
		// Run the algorithm
		GeoSum(10,1000000000);
	
		// Save the time after the run
		EndTime=System.nanoTime();
	
		// Calculate the difference
		ElapsedTime= EndTime- StartTime;
	
		// Print it out
		System.out.println("The algorithm took " + ElapsedTime + " nano-seconds to run.");
	}

}
