package coplit.queue;
import java.util.*;

public class q5 {
  public static void main(String[] args) {
    System.out.println(queuePrinter(2, 10, new int[]{7, 4, 5, 6}));
  }
  public static int queuePrinter(int bufferSize, int capacities, int[] documents) {
      // TODO:
    Queue<Integer> docQueue = new LinkedList<>();
    for (int d:documents){
      docQueue.add(d);
    }
    Queue<Integer> prtQueue = new LinkedList<>();
    for (int i=0; i<bufferSize;i++){
      prtQueue.add(0);
    }
    int currentCapa = 0;
    int t = 0;

    while(prtQueue.size() > 0){
      currentCapa -= prtQueue.poll();
      if (docQueue.size() > 0){
        if (docQueue.peek()+currentCapa <= capacities){
          int target = docQueue.poll();
          currentCapa += target;
          prtQueue.add(target);
          t++;
        } else {
          prtQueue.add(0);
          t++;
        }
      } else{
        t++;
      }
    }         
    return t;
  }  
}
