import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj5582 {
    static int answer;
    static String s1,s2;
    static int[][] d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s1 = br.readLine(); s2 = br.readLine();
        d = new int[s1.length()+1][s2.length()+1];
        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    d[i][j] = d[i-1][j-1] + 1;
                    answer = Math.max(answer,d[i][j]);
                }
            }
        }
        System.out.println(answer);

    }
}
