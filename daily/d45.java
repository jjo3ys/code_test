package daily;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class d45 {
    static int M, N;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static boolean[][] visited;
    static int[][] dp;

    public static void main(String[] args) {
        int[][] room = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0},
                {0, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 0},
        };
        int[] src = new int[]{4, 2};
        int sDir = 1;
        int[] dst = new int[]{2, 2};
        int dDir = 3;
        int output = robotPath1(room, src, sDir, dst, dDir);
        System.out.println(output); // --> 11
    }
    public static int robotPath1(int[][] room, int[] src, int sDir, int[] dst, int dDir) {
        // TODO:
        M = room.length;
        N = room[0].length;
        dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        dp[src[0]][src[1]] = 0;

        Queue<D> queue = new LinkedList<>();
        queue.add(new D(src[0], src[1], sDir));
        int lastD = 0;
        while (!queue.isEmpty()) {
            D cd = queue.poll();
            int x = cd.x;
            int y = cd.y;
            int dir = cd.d;
            for (int i = 0; i < 4; i++) {
                int ndir = (dir + i) % 4;
                int nx = x + dx[ndir];
                int ny = y + dy[ndir];
                ndir++;
                if (nx >= 0 && nx < M && ny >= 0 && ny < N && room[nx][ny] == 0) {
                    int tmp = Math.abs(dir - ndir);
                    tmp = tmp == 3 ? 1 : tmp;
                    tmp = tmp == 0 ? 0 : tmp+1;
                    tmp += dp[x][y];

                    if (tmp < dp[nx][ny]) {
                        dp[nx][ny] = tmp;
                        queue.add(new D(nx, ny, ndir));
                        if (nx == dst[0] && ny == dst[1]) lastD = ndir;
                    }
                }
            }

        }
        int tmp = Math.abs(lastD - dDir);
        tmp = tmp == 3 ? 1 : tmp;
        for (int i=0; i<M; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[dst[0]][dst[1]] + tmp;
    }
    public static int robotPath2(int[][] room, int[] src, int sDir, int[] dst, int dDir) {
        // TODO:
        M = room.length;
        N = room[0].length;
        visited = new boolean[M][N];
        dp = new int[M][N];
        visited[src[0]][src[1]] = true;
        dfs(new D(src[0], src[1], sDir), dst, dDir, room);
        for (int i=0; i<M; i++){
            System.out.println(Arrays.toString(dp[i]));
        }
        return dp[dst[0]][dst[1]];
    }
    public static void dfs(D d, int[] dst, int dDir, int[][] room){
        if (d.x==dst[0] && d.y==dst[1]){
            int tmp = Math.abs(d.d-dDir);
            tmp = tmp==3 ? 1:tmp;
            dp[d.x][d.y] += tmp;
            return;
        }
        int x = d.x;
        int y = d.y;
        int dir = d.d;
        for (int i=0; i<4; i++){
            int ni = ((dir+i)%4);
            int nx = x+dx[ni];
            int ny = y+dy[ni];
            ni++;
            if (nx>=0 && nx<M && ny>=0 && ny<N && room[nx][ny]==0 && !visited[nx][ny]){
                visited[nx][ny] = true;
                int tmp = Math.abs(dir-ni);
                tmp = tmp==3 ? 1:tmp;
                tmp = tmp==0 ? 0: tmp+1;
                dp[nx][ny] = dp[x][y]+tmp;
                System.out.printf("x: %d y: %d  d: %d nx: %d ny: %d nd: %d tmp: %d\n", x,y,dir,nx,ny,ni,tmp);
                dfs(new D(nx, ny, ni), dst, dDir, room);
            }
        }
    }
}

class D {
    int x, y, d;
    public D(int x, int y, int d){
        this.x = x;
        this.y = y;
        this.d = d;
    }
}