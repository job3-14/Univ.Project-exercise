public class Test {
	public static void main(String args[]) {
		int numgames = 50;
		double sum;
		double[] score = new double[numgames];

		int[] cards1 = {
			2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 1
		};
		Z.Deck.cards = cards1;

		score = Battle.evaluate();
		for (int i=0; i<numgames; i++){
			System.out.print(score[i] + " ");
		}
		System.out.print("\n\n");

		int[] cards2 = {
			3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 1, 2
		};
		Z.Deck.cards = cards2;

		score = Battle.evaluate();
		for (int i=0; i<numgames; i++){
			System.out.print(score[i] + " ");
		}
		System.out.print("\n\n");
	}
}
