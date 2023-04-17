import java.util.Random;

public class Lab7 {

	public static void main(String[] args) {
		PrintArrayInt(RandomMatrix(10,1,10));
		System.out.println();
		
		//double mst[][] = MST.PrimsMST(RandomArray(100));
		//PrintArray(mst);
	}
	public static int[][] PrintArrayInt(int[][] a){
		for(int j = 0; j < a.length; j++) {
			for(int i = 0; i<a[j].length;i++) {
				 System.out.print(a[j][i]+" ");
				 System.out.print(",");
			}
			System.out.println();
		}
		return a;
	}
	public static double[][] PrintArray(double[][] a){
		for(int j = 0; j < a.length; j++) {
			for(int i = 0; i<a[j].length;i++) {
				 System.out.print(a[j][i]+" ");
				 System.out.print(",");
			}
			System.out.println();
		}
		return a;
	}
	public static double[][] RandomArray(int n){
		double [][] array = new double[n][n];
		Random rand = new Random();
		double r = Math.abs(rand.nextInt() % 101);
		for(int j = 0; j < n; j++) {
			for(int i = 0; i < n;i++) {
				array[j][i] = r;
				r = Math.abs(rand.nextInt() % 101);
				
			}
		}
		return array;
	}
	public static int[][] RandomMatrix(int n, int lower, int upper){
		if(n <= 0 || lower > upper ) {
			return null;
		}
		lower = (int) Math.ceil(lower);
		upper = (int) Math.floor(upper);
		int [][] array = new int[n][n];
		Random rand = new Random();
		int r = (int) Math.abs(Math.floor(rand.nextInt(upper - lower + 1)+lower));
		for(int j = 0; j < n; j++) {
			for(int i = 0; i < n;i++) {
				if(j==i) {
					array[j][i]=lower;
				}else if(j != i){
					array[j][i] = r;
					array[i][j] = r;
				r = (int) Math.abs(Math.floor(rand.nextInt(upper - lower + 1)+lower));
				}
			}
		}
		return array;
	}
}
