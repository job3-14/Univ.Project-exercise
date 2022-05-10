import java.util.Random;
public class Solver {

	public static void answer() {
		int zigen = MasterMind.getzigen(); //正解文字列の長さ
		//		System.out.println(zigen);
		char[] deck = new char[zigen]; //正解リスト
		int[] lowDeck = new int[zigen]; //正解リスト(文字番号)
		int limit = MasterMind.getlimit(); //上限回数
		//		System.out.println(limit);
		int[] hint = new int[2];
		int firstString; //1文字目の文字番号
		char[] strings = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};


		lowDeck = initList(zigen, strings);
		deck = findString(zigen,strings, lowDeck);

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


	//文字列を検索する関数
	public static char[] findString(int zigen, char[] strings, int[] lowDeck){
		char[] deck = new char[zigen]; //正解リスト
		int[] hint = {0,0};
		int wordCount = 0;
		while(true){
			for(int i=0; i<26; i++){
				lowDeck[wordCount] = i;
				deck = convertDeck(zigen, strings, lowDeck);
				hint = MasterMind.evaluate(deck);
				if(hint[0] > wordCount){wordCount++;}
				if(wordCount == zigen){break;};
			}
			if(hint[0]==zigen){break;};
		}
		return deck;
	}


	//文字番号の正解リストを文字列の正解リストに変換する
	public static char[] convertDeck(int zigen, char[] strings, int[] lowDeck){
		char[] deck = new char[zigen];
		int tmpNumber;
		for(int i=0;i<zigen; i++){
			tmpNumber = lowDeck[i];
			deck[i] = strings[tmpNumber];
		}
		return deck;
	}



}
