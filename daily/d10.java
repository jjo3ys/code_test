public class d10 {
    public String insertDash(String str) {
        // TODO:
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<str.length()-2; i++){
            int n = str.charAt(i) - '0';
            int next_n = str.charAt(i+1) - '0';
            sb.append(n);
            if (n%2==1 && next_n%2==1){
                sb.append("-");
            }
        }
        sb.append(str.charAt(str.length()-1));
        return sb.toString();
    } 
}
