import java.util.ArrayList;

public class PrefixAverages {
	
	public static void main(String[] args) {
		
		double [] a = new double[10];
		a [0] = 7;
		a [1] = 3;
		a [2] = -1;
		a [3] = 2;
		a [4] = 9;
		a [5] = 0;
		a [6] = 0.8;
		a [7] = 52;
		a [8] = 2.2;
		a [9] = 900;
		
		ArrayList<Float> A = new ArrayList<Float>(10);
		ArrayList<Float> b = new ArrayList<Float>(10);
		b.add(Float.valueOf(7));
		b.add(Float.valueOf(3));
		b.add(Float.valueOf(-1));
		b.add(Float.valueOf(2));
		b.add(Float.valueOf(9));
		b.add(Float.valueOf(0));
		b.add(Float.valueOf((float) 0.8));
		b.add(Float.valueOf(52));
		b.add(Float.valueOf((float) 2.2));
		b.add(Float.valueOf(900));
		
		System.out.println(PrefixAverages1(a));
		System.out.println();
		System.out.println(PrefixAverages2(a));
		System.out.println();
		System.out.println(PrefixAverage(b));
		System.out.println();
		System.out.println(PrefixAverage(A));
	}
	public static double[] PrefixAverages1(double [] a) {
		
		double [] A = new double [a.length];
		
		for(int i = 0; i < a.length; i++) {
			double s = a[0];
			for(int j = 1; j < a.length - 1; j++) {
				if(j <= i) {
					s = s + a[j];
				}
			}
			A[i] = s / (i + 1);
		}
		
		for(int j = 0; j < a.length; j++) {
			System.out.print(A[j]);
		}
		
		return A;
	}
	public static double[] PrefixAverages2(double [] a) {
		
		double [] A = new double [a.length];
		double s = 0;
		
		for(int i = 0; i < a.length; i++) {
			s = s + a[i];
			A[i] = s / (i+1);
		}
		
		for(int j = 0; j < a.length; j++) {
			System.out.print(A[j]);
		}
		return A;
	}
	public static ArrayList<Float> PrefixAverage(ArrayList<Float> X){
		if(null == X || X.isEmpty() == true || X.size() == 0) {
			return null;
		}
		ArrayList<Float> A = new ArrayList<Float>(X.size());
		Float s = (float)0;
		for(int i = 0; i < X.size() ; i++) {
			s = s + X.get(i);
			A.add((s / (i+1)));
		}
		return A;
	}
}
