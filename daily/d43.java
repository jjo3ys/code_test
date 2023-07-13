package daily;

public class d43 {
    static int M;
    static int N;

    static char[] ans;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) {
        Character[][] matrix = new Character[][]{
                {'T', 'y', 'r', 'i'},
                {'i', 's', 't', 'o'},
                {'n', 'r', 'e', 'n'},
                {'n', 'a', 'L', ' '},
        };
        String output = spiralTraversal(matrix);
        System.out.println(output);
    }

    public static String spiralTraversal(Character[][] matrix) {
        // TODO:
        M = matrix.length;
        N = matrix[0].length;
        ans = new char[M*N];
        visited = new boolean[M][N];
        dfs(matrix, 0, 0, 0, 0);
        return new String(ans);
    }
    public static void dfs(Character[][] matrix, int d, int x, int y, int i){
        if (i>=ans.length) return;
        visited[x][y] = true;
        ans[i] = matrix[x][y];
        int nx = x+dx[d];
        int ny = y+dy[d];
        System.out.println("nx: "+nx+" ny: "+ny);
        if (nx<0 || nx>=M || ny<0 || ny>=N || visited[nx][ny]) {
            d = (d+1)%4;
            nx = x+dx[d%4];
            ny = y+dy[d%4];
        }
        dfs(matrix, d%4, nx, ny, i+1);
    }
}
