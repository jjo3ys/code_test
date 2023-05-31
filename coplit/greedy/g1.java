package coplit.greedy;
import java.util.Comparator;
import java.util.ArrayList;
public class g1 {
    public static void main(String[] args) {
        System.out.println(movingStuff(new int[]{70, 50, 80, 50}, 100));
    }
    public static int movingStuff(int[] stuff, int limit) {
        // TODO:
            // 내림차순으로 정렬
            ArrayList<Integer> arrStuff = new ArrayList<>();
            for (int s: stuff){
                arrStuff.add(s);
            }
            arrStuff.sort(Comparator.reverseOrder());
            // 박스 무게, 개수 설정
            // 내림차순으로 돌면서 가능한 무게 조합 중 무게의 합이 큰거
            // 
            int count=0;
            int j = arrStuff.size()-1;
            while (!arrStuff.isEmpty()){
                int weight = arrStuff.get(0);
                if (arrStuff.get(j) + weight <= limit){
                    arrStuff.remove(j);
                    arrStuff.remove(0);
                    j = arrStuff.size()-1;
                    count ++;
                }
                else j--;
                if (j<=0){
                    arrStuff.remove(0);
                    j = arrStuff.size()-1;
                    count ++;
                }
                // while(weight<=limit && j < arrStuff.size()){
                // 	if (arrStuff.get(j)+weight <= limit){
                // 		weight += arrStuff.get(j);
                // 		arrStuff.remove(j);
                // 		count ++;
                // 		break;
                // 	}
                // 	else {
                // 		j++;
                // 	}
                // }
                // if (weight == arrStuff.get(0)) count ++;
                // arrStuff.remove(0);
            }
        return count;
        } 
}
