import java.util.Random;
public class Solver {

	public static void answer() {
		int zigen = MasterMind.getzigen(); //正解文字列の長さ
		//		System.out.println(zigen);
		char[] deck = new char[zigen]; //正解リスト
		int limit = MasterMind.getlimit(); //上限回数
		//		System.out.println(limit);
		int[] hint = new int[2];
		int firstString; //1文字目の文字番号
		char[] strings = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

		//firstString = first(zigen, strings);
		initList(zigen,strings);



		//hint = MasterMind.evaluate(deck);
		//hint[0] 場所一致
		//hint[1] 文字列一致
		//		System.out.println(hint[0] + "\t" + hint[1]);

		MasterMind.submit(deck);
	}


	//hint[0]=0の文字列を作成し、文字番号で返す関数
	public static int[] initList(int zigen, char[] strings){
		int[] hint = new int[2];
		char[] deck = new char[zigen]; //正解リスト
		int[] initList = new int[zigen]; //正解リスト(文字番号)
		Random random = new Random();
		int randomValue;

		while(true){
			for(int i=0; i<zigen; i++){
				randomValue = random.nextInt(26);
				initList[i] = randomValue;
				deck[i] = strings[randomValue];
			}
			hint = MasterMind.evaluate(deck);
			if(hint[0] == 0){
				//テスト文////////////////////////////////////
				//System.out.println(testCount);
				//for(int testi=0; testi<zigen; testi++){
				//	System.out.printf("%s",deck[testi]);
				//}
				//System.out.println(" "+hint[0] + " " + hint[1]);
				//////////////////////////////////////////////
				break;
			}
		}
		return initList;
	}





}
