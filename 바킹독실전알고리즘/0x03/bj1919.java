import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        int[] cnt = new int[26]; //알파벳 개수 배열
        int answer = 0;

        for(int i=0;i<s1.length();i++){
            cnt[(int)(s1.charAt(i))-97]++;
        }
        for(int i=0;i<s2.length();i++){
            cnt[(int)(s2.charAt(i))-97]--;
        }

        for(int i:cnt){
            if(i!=0)answer+=Math.abs(i);
        }
        System.out.println(answer);
    }
}
