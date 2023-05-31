package daily;

import java.util.Arrays;

public class d6 { 
	public String letterCapitalize(String str) {
    // TODO:
		StringBuilder sb = new StringBuilder();
		boolean valid = false;
		for (int i=0; i<str.length(); i++){
			if (i==0 || (valid && str.charAt(i)!= ' ')){
				sb.append(Character.toUpperCase(str.charAt(i)));
			}
            else if (str.charAt(i)==' '){
                valid = true;
            }
			else {
                valid = false;
				sb.append(str.charAt(i));
			}
		}
		if (sb.toString().trim().isEmpty()){
			return "";
		}
		return sb.toString();
	} 
    public static String letterCapitalize2(String str) {
        // TODO:
        if (str.isEmpty()) return "";
        String[] strArr = str.split(" ");
        System.out.println(Arrays.toString(strArr));
        for (int i=0; i<strArr.length; i++){
            if (!strArr[i].isEmpty()){
                strArr[i] = Character.toUpperCase(strArr[i].charAt(0))+strArr[i].substring(1);
            }
        }
        return String.join(" ", strArr);
    } 
    public static void main(String[] args) {
        letterCapitalize2("what a wonderful life");
        letterCapitalize2("never give  up");
    }
}