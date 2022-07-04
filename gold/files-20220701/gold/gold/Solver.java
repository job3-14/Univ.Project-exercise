import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Solver {

	public static void answer() {

		int EvalLimit = Gold.getEvalLimit();
		int randLimit = EvalLimit / 3 * 2;

		//for(int i=0; i<EvalLimit; i++)

		double[] p = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		double y = Gold.evaluate(p);
		Gold.submit(p);
	}

	public static double[] makeRandCoordinate(){
		double[] p = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		int randCoordinate = 0, randCode;
		Random rand = new Random();

		for(int i=0; i<10; i++){
			randCoordinate = rand.nextInt(1000000);
			randCode = rand.nextInt(2);
			if(randCode == 0){
				randCoordinate = randCoordinate * -1;
			}
			p[i] = randCoordinate;
		}
		return p;
	}

}
