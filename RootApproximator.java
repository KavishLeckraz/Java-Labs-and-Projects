package lab1;

public class RootApproximator {
	
	public static void main(String[] args) {
		RootApproximator ra1 = new RootApproximator(25);
		System.out.println(ra1.getRoot());
	}
	/**
	Constructs a root approximator for a given number
	aNumber the number from which to extract the square root
	(Precondition: aNumber >= 0)
	 */
	public RootApproximator(double aNumber)
	{
		a = aNumber;
		xold = 1;
		xnew = a;
	}
	/**
	Compute a better guess from the current guess.
	returns the next guess
	 */
	public double nextGuess()
	{
		xold = xnew;
		if (xold != 0)
		{
			xnew = (xold + a / xold) / 2;
		}
		return xnew;
	}
	/**
	Compute the root by repeatedly improving the current
	guess until two successive guesses are approximately equal.
	@return the computed value for the square root
	 */
	public double getRoot()
	{
		while (!Numeric.approxEqual(xnew, xold))
		{
			nextGuess();
		}
		return xnew;
	}
	private double a; // the number whose square root is computed
	private double xnew; // the current guess
	private double xold; // the old guess

}
