import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16986 {
    static int N,K,jw,kh,mh,answer;
    static int[][] wlMap;
    static int[] player1, player2, order, score;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        wlMap = new int[N][N];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                wlMap[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        player1 = new int[20];
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<20;i++){
            player1[i] = Integer.parseInt(stk.nextToken());
        }

        player2 = new int[20];
        stk = new StringTokenizer(br.readLine());
        for(int i=0;i<20;i++){
            player2[i] = Integer.parseInt(stk.nextToken());
        }

        order = new int[N];
        visited = new boolean[N];
        permutation(0);
        System.out.println(answer);
    }

    private static void permutation(int depth) {
        //지우가 먼저 K승을 달성한경우 더이상 진행X
        if(answer == 1)return;

        if(depth == N){
            score = new int[3];
            jw = 0; kh = 0; mh = 0;
            play(0,1);
            return;
        }
        for(int i=0;i<N;i++){
            if(!visited[i]){
                visited[i] = true;
                order[depth] = i;
                permutation(depth+1);
                visited[i] = false;
            }
        }
    }

    private static void play(int p1, int p2) {
        //지우가 K승을 먼저 달성한경우 답 체크 하고 종료
        if(score[0] == K){
            answer = 1;
            return;
        }
        //지우가 가능한 모든 손동작을 냈거나
        //경희 또는 민호가 지우보다 먼저 K승을 달성한 경우
        if(jw == N || score[1] == K || score[2] == K)return;

        int next = 0;

        //지우 vs 경희
        if(p1 == 0 && p2 == 1){
            if(wlMap[order[jw]][player1[kh]-1] == 1){
                score[p2]++;
                next = p2;
            }else if(wlMap[order[jw]][player1[kh]-1] == 2){
                score[p1]++;
                next = p1;
            }else {
                score[p2]++;
                next = p2;
            }
            jw++; kh++;
            play(next , 2);
        }else if(p1 == 1 && p2 == 2){ //경희 vs 민호
            if(wlMap[player1[kh]-1][player2[mh]-1] == 1){
                score[p2]++;
                next = p2;
            }else if(wlMap[player1[kh]-1][player2[mh]-1] == 2){
                score[p1]++;
                next = p1;
            }else {
                score[p2]++;
                next = p2;
            }
            kh++; mh++;
            play(0,next);
        }else{ //지우 vs 민호
            if(wlMap[order[jw]][player2[mh]-1] == 1){
                score[p2]++;
                next = p2;
            }else if(wlMap[order[jw]][player2[mh]-1] == 2){
                score[p1]++;
                next = p1;
            }else {
                score[p2]++;
                next = p2;
            }
            jw++; mh++;
            if(next > 1) play(1,next);
            else play(next,1);
        }
    }
}
