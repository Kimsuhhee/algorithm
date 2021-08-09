import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj14891 {
    static int K,num,dir,temp;
    static int[][] gear;
    static int[] turn;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        gear = new int[4][8];

        for(int i=0;i<4;i++){
            String temp = br.readLine();
            for(int j=0;j<temp.length();j++){
                gear[i][j] = temp.charAt(j)-'0';
            }
        }
        K = Integer.parseInt(br.readLine());

        while(K-- > 0){
            StringTokenizer stk = new StringTokenizer(br.readLine()," ");
            //0:회전하지않음, 1:시계방향회전, -1 :반시계방향 회전
            turn = new int[4];
            num = Integer.parseInt(stk.nextToken());
            dir = Integer.parseInt(stk.nextToken()); //1:시계, -1:반시계
            isPossible(num-1,dir);

            for(int i=0;i<4;i++){
                if(turn[i]!=0) rotate(i,turn[i]);
            }

            /**
            System.out.println("=======================");
            for(int i=0;i<4;i++){
                for(int j=0;j<8;j++){
                    System.out.print(gear[i][j]+" ");
                }
                System.out.println();
            }
            **/
        }

            int sum = 0;
            if(gear[0][0]==1)sum+=1;
            if(gear[1][0]==1)sum+=2;
            if(gear[2][0]==1)sum+=4;
            if(gear[3][0]==1)sum+=8;

        System.out.println(sum);
    }

    private static void rotate(int idx,int dir) {
        if(dir==1){
            temp = gear[idx][7];
            for(int i=7;i>0;i--){
                gear[idx][i] = gear[idx][i-1];
            }
            gear[idx][0] = temp;
        }else{
            temp = gear[idx][0];
            for(int i=1;i<8;i++){
                gear[idx][i-1] = gear[idx][i];
            }
            gear[idx][7] = temp;
        }
    }

    private static void isPossible(int num, int dir) {
        int cur = num;
        if(cur>4||cur<0)return;
        if(turn[cur]!=0)return;
        turn[cur] = dir;

        if(cur-1>=0 && gear[cur-1][2] != gear[cur][6]){
            isPossible(cur-1,-dir);
        }
        if(cur+1<4 && gear[cur][2] != gear[cur+1][6]){
            isPossible(cur+1,-dir);
        }
    }

}
