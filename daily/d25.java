package daily;

class d25{
    public static void main(String[] args) {
        int base = 2;
        int answer = 1;
        int ex = 10;
        while(ex-->0){
            answer *=base;
            if (answer>=94_906_249) answer %= 94_906_249;
        }
        System.out.println(answer);
    }
}