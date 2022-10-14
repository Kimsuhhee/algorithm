import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj23291 {
    static int N,K,max,min;
    static int[][] bowl;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        bowl = new int [N][N];

        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            bowl[N-1][i] = Integer.parseInt(stk.nextToken());
        }

        int times = 0;
        while(true){
            //물고기 수가 가장 적은 어항에 +1
            plus1MinimumBowl();

            //공중부양
            levitate();

            //물고기 수 조절
            regulate();
            
           //한줄로 펴기
            flatten();

            //공중부양
            levitate2();

            //물고기 수 조절절
            regulate();

            //한줄로 펴기
            flatten();

            times++;

            if(calDiff() <= K)break;

        }

        System.out.println(times);
    }

    private static void regulate() {
        int[][] regArr = new int[N][N];
        Queue<Node>q = new LinkedList<>();
        for(int i=N-1;i>=0;i--){
            for(int j=0;j<N;j++) {
                if(bowl[i][j]!=0){
                    q.add(new Node(i,j));
                }
            }
        }

        boolean[][] checked = new boolean[N][N];
        //q에서 값을 꺼낸후 인접한 노드차이값 계산하고 regArr갱신
        while(!q.isEmpty()){
            Node cur = q.poll();
            checked[cur.x][cur.y] = true;
            for(int i=0;i<4;i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N)continue;
                if(bowl[nx][ny] == 0)continue;
                if(checked[nx][ny])continue;
                int diff = Math.abs(bowl[cur.x][cur.y] - bowl[nx][ny]);
                if((diff / 5) > 0){
                    if(bowl[nx][ny] > bowl[cur.x][cur.y]){
                        regArr[nx][ny] -= diff/5;
                        regArr[cur.x][cur.y] += diff/5;
                    }else if(bowl[nx][ny] < bowl[cur.x][cur.y]){
                        regArr[nx][ny] += diff/5;
                        regArr[cur.x][cur.y] -= diff/5;
                    }
                }
            }
        }

        //계산 결과 bowl배열에 합치기
        for(int i=N-1;i>=0;i--){
            for(int j=0;j<N;j++){
                bowl[i][j] += regArr[i][j];
            }
        }

    }

    private static void flatten() {
//        System.out.println("한줄로피기전");
//        for(int i=0;i<N;i++){
//            for(int j=0;j<N;j++){
//                System.out.print(bowl[i][j]+" ");
//            }
//            System.out.println();
//        }

        ArrayList<Integer>bowl1D = new ArrayList<>();
        for(int j=0;j<N;j++){
            for(int i=N-1;i>=0;i--){
                if(bowl[i][j] == 0)continue;
                bowl1D.add(bowl[i][j]);
            }
        }

//        System.out.println(bowl1D);

        bowl = new int[N][N];
        for(int i=0;i<N;i++){
            bowl[N-1][i] = bowl1D.get(i);
        }
    }

    private static void levitate() {
        //첫번째 어항 정리
        //돌돌 말아줌
        int sx = 0, w = 1, h = 1;
        while(sx + w + h <= N){
            for(int y = sx; y< sx + w ; y++){
                for(int x = N-1; x > N - h-1 ; x--){
                    int nx = N-1-w + (y-sx);
                    int ny = sx+w + (N-1-x);
                    bowl[nx][ny] = bowl[x][y];
                    bowl[x][y] = 0;
                }
            }
            sx += w;
            if(w == h) h++;
            else w++;
        }
    }

    private static void levitate2() {
//        System.out.println("두번접기전");
//        for(int i=0;i<N;i++){
//            for(int j=0;j<N;j++){
//                System.out.print(bowl[i][j]+" ");
//            }
//            System.out.println();
//        }

        //절반씩 접어서 어항 정리
        //2번수행
        int sx = 0, w = N/2, h = 1;
        for(int i=0;i<2;i++){
            for(int x=0;x<h;x++){
                for(int y=0;y<w;y++){
                    int nx = (N - 1) - (2 * h - x -1);
                    int ny = 2 * w + sx - y - 1;
                    bowl[nx][ny] = bowl[N - x - 1][y + sx];
                    bowl[N - x - 1][y + sx] = 0;
                }
            }
            sx += w;
            w /= 2;
            h *= 2;
        }

//        System.out.println("두번접은후");
//        for(int i=0;i<N;i++){
//            for(int j=0;j<N;j++){
//                System.out.print(bowl[i][j]+" ");
//            }
//            System.out.println();
//        }

    }

    private static void plus1MinimumBowl() {
        int min = 10001;
        ArrayList<Integer>indexList = new ArrayList<>();
        for(int i=0;i<N;i++){
            if(min > bowl[N-1][i]){
                indexList.clear();
                indexList.add(i);
                min = bowl[N-1][i];
            }else if(min == bowl[N-1][i]){
                indexList.add(i);
            }
        }

        for(int index:indexList){
            bowl[N-1][index] += 1;
        }
    }

    private static int calDiff() {
        max = 0; min = 10001;
        for(int i=0;i<N;i++){
            max = Math.max(max , bowl[N-1][i]);
            min = Math.min(min , bowl[N-1][i]);
        }
        return max - min;
    }

    private static class Node {
        int x,y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
