public class Solver {

	static int num = Map.p.length;

	public static void answer() {
		int[] x = new int[num];
		for(int i=0; i<num; i++){
			x[i] = i;
		}
		TSP2D.submit(x);
	}

}
