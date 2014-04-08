package interview.leetcode;

public class Pow {

	/**
	 * Implement pow(x, n).
	 */
	public double pow(double x, int n) {
		if (n == 0)
			return 1;
		if (x == 0)
			return 0;
		if (n < 0) {
			n = -n;
			x = 1. / x;
		}
		double temp = pow(x, n / 2);
		return n % 2 == 0 ? temp * temp : temp * temp * x;
	}

	public double pow2(double x, int n) {
		if (n == 0)
			return 0;
		if (n > 0) {
			int r = 1;
			for (int i = 0; i < n; i++) {
				r *= x;
			}
			return r;
		} else {
			if (x == 0)
				return 0; // wrong here
			int r = 1;
			for (int i = 0; i < -n; i++) {
				r *= x;
			}
			return 1L / r;
		}
	}
}
