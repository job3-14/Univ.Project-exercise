import java.util.List;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.HashMap;
import java.util.Map;


public class Solver {

	public static void answer() {

		int EvalLimit = Gold.getEvalLimit();
		int wideSearchLimit = EvalLimit / 2;
		double[][] scoreAdress = new double[wideSearchLimit][];
		wideAreaSearch(wideSearchLimit);


		double[] p = { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		double y = Gold.evaluate(p);
		Gold.submit(p);
	}

	public static double[][] wideAreaSearch(int limit){
		double[][] address = new double[limit][];
		double[] score = new double[limit];
		double[][] scoreAdress = new double[limit/50][];
		address = makeWideAreaSearchAddress(limit); // ランダム座標を生成
		score = wideAreaSearchScore(address); // 各座標のスコアを計算
		scoreAdress = wideAreaSearchMakeAddress(limit, score, address); // ランクの高い座標リストを作成
		return scoreAdress;
	}

	public static void localAreaSearch(double[][] wideAreaAddress){
		double[] tmpList = new double[10];
		double[] score= new double[wideAreaAddress.length*30];
		double[][] localAreaAddress =  new double[wideAreaAddress.length*30][];
		double minScore = Double.MAX_VALUE;
		Integer minAddress = 0;
		for(int i=0; i<wideAreaAddress.length; i++){
			for(int j=0; j<10; j++){
				tmpList = wideAreaAddress[i];
				for(int k=1; k<=3; k++){
					tmpList[j] += 100;
					score[i] = Gold.evaluate(tmpList);
					localAreaAddress[i] = tmpList;
				}
			}
		}
		for(int i=0;i<score.length; i++){
			if(minScore > score[i]){
				minScore = score[i];
				minAddress = i;
			}
		}
		Gold.submit(localAreaAddress[minAddress]);
	}





	public static double[] makeRandCoordinate(){ //ランダム座標を生成する
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


	public static double[][] makeWideAreaSearchAddress(int limit){
		double[][] address = new double[limit][];
		for(int i=0; i<limit; i++){
			address[i] = makeRandCoordinate();
		}
		return address;
	}

	public static double[] wideAreaSearchScore(double[][] address){
		double[] score= new double[address.length];
		for(int i=0; i<address.length; i++){
			score[i] = Gold.evaluate(address[i]);
		}
		return score;
	}

	public static double wideAreaSearchLimitScore(int limit, double[] score){
		Arrays.sort(score);
		return score[limit - 1];
	}

	public static double[][] wideAreaSearchMakeAddress(int limit, double[] score, double[][] address){
		double limitScore = wideAreaSearchLimitScore(limit/50, score);
		double[][] makedaddress = new double[limit/50][];
		for(int i=0; i<score.length; i++){
			if(limitScore > score[i]){
				makedaddress[i] = address[i];
			}
		}
		return address;
	}

}
