import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj15686 {
    static int N,M;
    static int ans = Integer.MAX_VALUE;
    static int[] combination;
    static boolean[] visited;
    static int[][] map;
    static ArrayList<Point>house = new ArrayList<>();
    static ArrayList<Point>chickens = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        map = new int[N][N];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
                if(map[i][j]==2)chickens.add(new Point(i,j));
                if(map[i][j]==1)house.add(new Point(i,j));
            }
        }

        combination = new int[M];
        visited = new boolean[chickens.size()];
        permutation(0,0);
        System.out.println(ans);
    }

    private static void permutation(int start, int n) {
        if(n==M){
            /**
            System.out.println("===========");
            for(int i: combination) System.out.print(i+" ");
            System.out.println();
             **/
            //house위치를 담은 list를 돌면서
            //M개의 조합된 배열의 각 인덱스의 치킨집위치와의 거리를 구한다.

            int min,sum=0;
            for(int i=0;i<house.size();i++){
                min = Integer.MAX_VALUE;
                for(int j=0;j<combination.length;j++){
                    min = Math.min(min,cal(house.get(i),chickens.get(combination[j])));
                }
                sum += min;
            }
            ans = Math.min(ans,sum);
            return;
        }

        for(int i=start;i<chickens.size();i++){
            if(!visited[i]){
                visited[i] = true;
                combination[n] = i;
                permutation(i+1,n+1);
                visited[i] = false;
            }
        }
    }

    private static int cal(Point house, Point chicken) {
        return Math.abs(house.x-chicken.x)+Math.abs(house.y-chicken.y);
    }

    private static class Point {
        int x,y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
