import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj11328 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            String alphabet = br.readLine();
            String alphabets[] = alphabet.split(" ");
            int[] cnt = new int[26]; //개수 세는 배열
            boolean flag =true;
            for(int j=0;j<alphabets[0].length();j++){
                cnt[(int)alphabets[0].charAt(j)-97]++;
            }
            for(int k=0;k<alphabets[1].length();k++){
                cnt[(int)alphabets[1].charAt(k)-97]--;
            }
            for(int num:cnt){
                if(num!=0){
                    flag = false;
                    break;
                }
            }
            if(flag)
                sb.append("Possible").append("\n");
            else
                sb.append("Impossible").append("\n");

            Arrays.fill(cnt,0);
        }
        System.out.println(sb);
    }
}
