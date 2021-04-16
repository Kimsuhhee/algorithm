import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();
        String[] tmp = command.split(" ");
        int N = Integer.parseInt(tmp[0]); //학생수
        int K = Integer.parseInt(tmp[1]); //한방최대인원수
        int roomCnt = 0;
        int[] girls = new int[7];
        int[] boys = new int[7];

        for(int i=0;i<N;i++){
            String sy = br.readLine();
            tmp = sy.split(" ");
            int S = Integer.parseInt(tmp[0]); //0-여자, 1-남자
            int Y = Integer.parseInt(tmp[1]);

            if(S==0){
                girls[Y]++;
            }else{
                boys[Y]++;
            }
        }

        for(int i=1;i<=6;i++){
            roomCnt += girls[i]/K;
            if(girls[i] % K != 0)roomCnt++;
        }
        for(int i=1;i<=6;i++){
            roomCnt += boys[i]/K;
            if(boys[i] % K != 0)roomCnt++;
        }

        System.out.println(roomCnt);
    }
}
