package daily;

import java.util.*;
// import java.util.stream.Collectors;
import java.util.stream.Collectors;

public class d24 { 
	public boolean isSubsetOf(int[] base, int[] sample) {
    // TODO:
		HashSet<Integer> hashSet = new HashSet<>(Arrays.stream(base).boxed().collect(Collectors.toSet()));

		// boolean[] baseArr = new boolean[base[base.length-1]+1];

		// for (int i:base){
		// 	baseArr[i] = true;
		// }
		for(int i:sample){
			// if(i>=baseArr.length || !baseArr[i]) return false;
			if(!hashSet.contains(i)) return false;
		}
		return true;
	} 
}