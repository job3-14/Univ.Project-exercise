import java.util.ArrayList;
import java.util.Arrays;

public class Solver {

	static int num = Map.p.length;

	public static void answer() {
		int[] x = new int[num];
		x = order();
		TSP2D.submit(x);
	}

	public static int[] order() {
		int[] x = new int[num];
		int count = 1;
		Integer minDistance, minNext, distance;
		ArrayList<Integer> remainingVisits= new ArrayList<>();
		Integer yakusokuNum = Map.yakusoku.length;
		for(int i=0; i<num; i++){ remainingVisits.add(i); } // まだ訪問していない番号リストの初期化(作成)
		for(int i=0; i<num; i++){ x[i] = -1; } // 訪問先の初期化
		for(int i=0; i<yakusokuNum; i++){ //yakusokuの追加
			x[Map.yakusoku[i][1]] = Map.yakusoku[i][0];
			remainingVisits.remove(Map.yakusoku[i][0]);
		}
		x[0] = 0; //会社の追加
		while(remainingVisits.size() > 0){
			if(x[count] == -1){
				minDistance = 9999;
				minNext = -1;
				for(int i=0; i<remainingVisits.size(); i++){
					distance = TSP2D.distance(count-1,remainingVisits.get(i));
					if(minDistance > distance){
						minDistance = distance;
						minNext = remainingVisits.get(i);
					}
				}
				x[count] = minNext;
				remainingVisits.remove(minNext);
			}
			count++;
		}

		return x;
	}

}
