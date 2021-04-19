import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1267 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //통화의 개수
        String time = br.readLine();
        String[] times = time.split(" ");
        int[][] payment = new int[2][N]; //0:Y, 1:M

        for(int i=0;i<N;i++){
            int tmp = Integer.parseInt(times[i]);

            int y = tmp /30+1;

            payment[0][i] += y*10;

            int m = tmp/60+1;

            payment[1][i] += m*15;

        }
        int ysum=0,msum=0;
        for(int i=0;i<N;i++){
            ysum+=payment[0][i];
            msum+=payment[1][i];
        }

        if(ysum>msum) System.out.println("M "+msum);
        else if(ysum<msum) System.out.println("Y "+ysum);
        else System.out.println("Y M "+msum);

    }
}
