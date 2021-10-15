import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14499 {
    static int N,M,x,y,K;
    static int[][] map;
    static int[] dice;
    static int command;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        x = Integer.parseInt(stk.nextToken());
        y = Integer.parseInt(stk.nextToken());
        K = Integer.parseInt(stk.nextToken());

        map = new int[N][M];
        dice = new int[6];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine()," ");
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        stk = new StringTokenizer(br.readLine()," ");

        for(int i=0;i<K;i++){
            command = Integer.parseInt(stk.nextToken());
            int[] temp = dice.clone();
            switch(command){
                case 1:
                    y++;
                    if(!possible()){
                        y--;
                        continue;
                    }
                        dice[0] = temp[3];
                        dice[2] = temp[0];
                        dice[3] = temp[5];
                        dice[5] = temp[2];
                        if(map[x][y]==0){
                            map[x][y] = dice[5];
                        }else{
                            dice[5] = map[x][y];
                            map[x][y] = 0;
                        }
                        System.out.println(dice[0]);
                    break;
                case 2:
                    y--;
                    if(!possible()){
                        y++;
                        continue;
                    }
                        dice[0] = temp[2];
                        dice[2] = temp[5];
                        dice[3] = temp[0];
                        dice[5] = temp[3];
                        if(map[x][y]==0){
                            map[x][y] = dice[5];
                        }else{
                            dice[5] = map[x][y];
                            map[x][y] = 0;
                        }
                        System.out.println(dice[0]);
                    break;
                case 3:
                    x--;
                    if(!possible()){
                        x++;
                        continue;
                    }
                        dice[1] = temp[0];
                        dice[0] = temp[4];
                        dice[4] = temp[5];
                        dice[5] = temp[1];
                        if(map[x][y]==0){
                            map[x][y] = dice[5];
                        }else{
                            dice[5] = map[x][y];
                            map[x][y] = 0;
                        }
                        System.out.println(dice[0]);
                    break;
                case 4:
                    x++;
                    if(!possible()){
                        x--;
                        continue;
                    }
                        dice[0] = temp[1];
                        dice[1] = temp[5];
                        dice[4] = temp[0];
                        dice[5] = temp[4];
                        if(map[x][y]==0){
                            map[x][y] = dice[5];
                        }else{
                            dice[5] = map[x][y];
                            map[x][y] = 0;
                        }
                        System.out.println(dice[0]);

                    break;
            }
        }
    }

    private static boolean possible() {
        if (x >= 0 && y >= 0 && x < N && y < M) return true;
        else return false;
    }

}
