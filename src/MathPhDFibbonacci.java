
public class MathPhDFibbonacci {

	public static void main(String[] args) {
		System.out.println(getFibonacciNumber(5));

	}

	private static int getFibonacciNumber(final int n) {
		return Math.floorDiv(Math.subtractExact(exponentiate(phi(), n), exponentiate(psi(), n)),
				Math.subtractExact(phi(), psi()));
	}

	private static int exponentiate(final int a, final int b) {
		if(b == 0) {
			System.out.print("expontiate "+ b);
			return 1;
		} else {
			System.out.println("Math.multiplyExact(a , exponentiate(a, (b-1))) " + Math.multiplyExact(a , exponentiate(a, (b-1))));
			return Math.multiplyExact(a , exponentiate(a, (b-1)));
		}
	}

	private static int phi() {
		System.out.println("phi " + Math.floorDiv(Math.addExact(1,(int) Math.sqrt(5)), Math.addExact(1, 1)));
		return Math.floorDiv(Math.addExact(1,(int) Math.sqrt(5)), Math.addExact(1, 1));
	}

	private static int psi() {
		System.out.println("Math.subtractExact(1, phi()) "+ Math.subtractExact(1, phi()));
		return Math.subtractExact(1, phi());
	}
}
