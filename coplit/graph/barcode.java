package coplit.graph;

public class barcode {
    public static String ba(int len) {
        // TODO:
        String str = "1";
        str = dfs(str, len);
        return str;
        } 
    public static boolean valid(String s){
        for (int i=0; i<s.length();i++){
          for (int j=0; j<i; j++){
            if (i+j>=s.length()) break;
            if (s.substring(i-j-1, i).equals(s.substring(i, i+j+1))) {
                return false;
            }
          }
        }
        return true;
      }
    public static String dfs(String str, int len){
        if (str.length()==len) return str;
        for (int i=1; i<4; i++){
            String currentStr = str + i;
            if (valid(currentStr)) {
              String f = dfs(currentStr, len);
              if (f !=null) return f;
            }
        }
        return null;
    }
    public static void main(String[] args) {
        System.out.println(ba(8));
    }

    // public static boolean dfs(String "11"){
    //     for (int i=0; i<2;i++){
    //       for (int j=1; j<i; j++){
    //         if (i+j>2) break;
    //         if ("11".substring(i-j, i).equals("11".substring(i, i+j))) return false;
    //       }
    //     }
    //     return true;
    //   }
}
