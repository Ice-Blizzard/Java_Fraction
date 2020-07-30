package rs418393;

public class Main {

	public static void main(String[] args) {
		Ulamek u1 = new Ulamek(4, 3);
		Ulamek u2 = new Ulamek(5, 4);
		Ulamek u3 = new Ulamek(2, 3);
		Ulamek u4 = new Ulamek(1, 1);
		Ulamek u5 = new Ulamek(1, 4);
		Ulamek u6 = new Ulamek(566, 3);
		Ulamek u7 = new Ulamek((-1), 3);
		

		Ulamek.show(u1);
		Ulamek.show(u2);
        Ulamek.show(Ulamek.plus(u3, u4));
        Ulamek.show(u6);
        Ulamek.show(Ulamek.multiplication(u6, u6));
        Ulamek.show(Ulamek.divide(u7, u5));
		

	}

}
