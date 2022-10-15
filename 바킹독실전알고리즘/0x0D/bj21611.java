import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj21611{
    static int N,M,d,s,answer;
    static int[][] board2D;
    static int[] board1D;
    static int[] dx = {0,-1,1,0,0};
    static int[] dy = {0,0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stk;
        stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());

        board2D = new int[N][N];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board2D[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        board1D = new int[N * N];

        //블리자드 마법 수행
        for(int i=0;i<M;i++){
            stk = new StringTokenizer(br.readLine());
            d = Integer.parseInt(stk.nextToken());
            s = Integer.parseInt(stk.nextToken());

            //d방향의 s거리만큼의 칸을 제거
            blizzard();

            //일차원 배열로 바꿈
            make2DTo1D();

            //왼쪽으로 밀기
            shift();

            //4개이상 인접한 구슬 폭발
            while(explode() != 0){
                shift();
            }

            //구슬 그룹화
            change();

            make1DTo2D();

//            System.out.println("===============");
//            for(int j=0;j<N;j++){
//                for(int k=0;k<N;k++){
//                    System.out.print(board2D[j][k]+" ");
//                }
//                System.out.println();
//            }

        }
        System.out.println(answer);

    }

    private static void change() {
        ArrayList<Integer>changeBoard = new ArrayList<>();
        int marble = -1;
        int count = 0;
        for(int i=0;i<N*N;i++){
            if(marble == -1){
                marble = board1D[i];
                count = 1;
            }else if(marble != board1D[i]){
                changeBoard.add(count);
                changeBoard.add(marble);
                marble = board1D[i];
                count = 1;
            }else if(marble == board1D[i]){
                count++;
            }

            if(marble == 0)break;
        }

        board1D = new int[N*N];
        int size = changeBoard.size() > N*N ? N*N : changeBoard.size();
        for(int i=0;i<size;i++){
            board1D[i] = changeBoard.get(i);
        }
    }

    private static void shift() {
        ArrayList<Integer>shiftBoard = new ArrayList<>();
        for(int i=0;i<N*N;i++){
            if(board1D[i] == 0)break;
            if(board1D[i] > 0){
                shiftBoard.add(board1D[i]);
            }
        }

        board1D = new int[N*N];
        for(int i=0;i<shiftBoard.size();i++){
            board1D[i] = shiftBoard.get(i);
        }
    }

    private static void blizzard() {
        int sx = N/2, sy = N/2;

        for(int i=0;i<s;i++) {
            sx += dx[d];
            sy += dy[d];
            board2D[sx][sy] = -1;
        }

    }

    private static int explode() {
        int point = 0, count = 1, pre = -1, i = 0;
        for(;i<N*N;i++){
            if(board1D[i] == 0)break;
            if(pre != board1D[i]){
                if(count >= 4){
                    for(int j=1;j<=count;j++){
                        point += board1D[i-j];
                        board1D[i-j] = -1;
                    }
                }
                pre = board1D[i];
                count = 1;
            }else{
                count++;
            }
        }

        if(count >= 4){
            for(int j=1;j<=count;j++){
                point += board1D[i-j];
                board1D[i-j] = -1;
            }
        }

        answer += point;
        return point;
    }

    private static void make1DTo2D() {
        board2D = new int[N][N];
        int[] ddx = {0,1,0,-1};
        int[] ddy = {-1,0,1,0};
        int x = N/2, y = N/2;
        int dir = 0, move = 2, idx = 0;
        for(int dist = 1; dist < N ; dist++){
            if(dist == N-1){
                move = 3;
            }
            for(int i = 0; i < move ; i++){
                for(int j = 0; j < dist ; j++){
                    x += ddx[dir];
                    y += ddy[dir];
                    if(board1D[idx] != 0){
                        board2D[x][y] = board1D[idx++];
                    }
                }
                dir = (dir + 1) % 4;
            }
        }
    }

    private static void make2DTo1D() {
        board1D = new int[N*N];
        int[] ddx = {0,1,0,-1};
        int[] ddy = {-1,0,1,0};
        int x = N/2, y = N/2;
        int dir = 0, move = 2, idx = 0;
        for(int dist = 1; dist < N ; dist++){
            if(dist == N-1){
                move = 3;
            }
            for(int i = 0; i < move ; i++){
                for(int j = 0; j < dist ; j++){
                    x += ddx[dir];
                    y += ddy[dir];
                    if(board2D[x][y] != 0){
                        board1D[idx++] = board2D[x][y];
                    }
                }
                dir = (dir + 1) % 4;
            }
        }
    }

}
