import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10836 {
    static int M,N;
    static int[][]beehive;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        M = Integer.parseInt(stk.nextToken());
        N = Integer.parseInt(stk.nextToken());

        //첫날 아침의 애벌레 크기는 모두 1
        beehive = new int[M][M];
        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                beehive[i][j] = 1;
            }
        }

        //주어진 값으로 먼저 성장 시킴
        int[][] temp = new int[M][M];

        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            int zeroCnt = Integer.parseInt(stk.nextToken());
            int oneCnt = Integer.parseInt(stk.nextToken());
            int twoCnt = Integer.parseInt(stk.nextToken());

            //제일 왼쪽 열과 제일 위쪽 행의 애벌레 성장
            int idx = 0;
            for(int x=M-1;x>=0;x--){
                if(zeroCnt!=0){
                    zeroCnt--;
                }else if(oneCnt!=0){
                    oneCnt--;
                    temp[x][idx]+=1;
                }else if(twoCnt!=0){
                    twoCnt--;
                    temp[x][idx]+=2;
                }
            }

            for(int y=1;y<M;y++){
                if(zeroCnt!=0){
                    zeroCnt--;
                }else if(oneCnt!=0){
                    oneCnt--;
                    temp[idx][y]+=1;
                }else if(twoCnt!=0){
                    twoCnt--;
                    temp[idx][y]+=2;
                }
            }
        }

        //temp배열값을 기반으로 다른 애벌레 성장
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            for(int j=0;j<M;j++){
                if(i==0||j==0) {
                    sb.append(beehive[i][j] + temp[i][j]+" ");
                }else {
                    temp[i][j] = Math.max(Math.max(temp[i-1][j],temp[i][j-1]),temp[i-1][j-1]);
                    sb.append(beehive[i][j] + temp[i][j]+" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
