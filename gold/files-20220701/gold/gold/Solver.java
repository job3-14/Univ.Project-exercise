import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class Solver {

	public static void answer() {

		int EvalLimit = Gold.getEvalLimit();

		double[] p = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		double y = Gold.evaluate(p);
		Gold.submit(p);
	}

}
