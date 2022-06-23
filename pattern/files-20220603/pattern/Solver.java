public class Solver {

	public static String[] answer() {
		String[] kaitou = new String[Data.numdata];

		for(int i=0; i<Data.numdata; i++){
			kaitou[i]=analysis(Data.zokusei[i]);
		}
		return kaitou;
	}

	public static String analysis(Double[] zokusei) {
		String kaitou;
		Double answer;
		answer = 0.70276928*zokusei[0] -1.39167064*zokusei[1] +0.88047586*zokusei[2] +0.27116754*zokusei[3] -1.16277677*zokusei[4] +1.32846341*zokusei[5] +2.9421883871431826;
		kaitou = "C" + String.valueOf(Math.round(answer));

		return kaitou;
	}

}
