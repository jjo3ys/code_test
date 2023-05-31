public class d9 {
    public static void main(String[] args) {
        System.out.println(ABCheck("lane Borrowed"));
    }
    public static boolean ABCheck(String str) {
        // TODO:
        String[] strArr = str.split("");
        for (int i=0; i<strArr.length-5; i++){
            if ((strArr[i].toUpperCase().equals("A") && strArr[i+4].toUpperCase().equals("B")) ||
                (strArr[i].toUpperCase().equals("B") && strArr[i+4].toUpperCase().equals("A"))) return true;
        }
        return false;
    }
}
