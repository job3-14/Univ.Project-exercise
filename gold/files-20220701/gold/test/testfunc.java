public class testfunc {
	
	public static double define (double[] p) {
		double f = 0.0;
		for(int i=0; i<10; i++){
			f += Math.pow(p[i], 2);
		}		
		return f;
	}

}
