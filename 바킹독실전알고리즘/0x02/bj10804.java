import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj10804 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] cards = new int[21];
        for(int i=1;i<21;i++){
            cards[i]=i;
        }

        int A,B;
        for(int i=0;i<10;i++){
            String ab = br.readLine();
            StringTokenizer stk = new StringTokenizer(ab," ");

            A = Integer.parseInt(stk.nextToken());
            B = Integer.parseInt(stk.nextToken());

            int[] temp = new int[B-A+1];
            int index = 0;
            for(int j=A;j<=B;j++){
                temp[index++] = cards[j];
            }
            for(int j=index-1;j>=0;j--){
                cards[A++] = temp[j];
            }
        }
        for(int i=1;i<21;i++){
            sb.append(cards[i]).append(" ");
        }
        System.out.println(sb);
    }
}
