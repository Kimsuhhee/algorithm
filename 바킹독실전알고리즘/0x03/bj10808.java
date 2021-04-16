import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10808 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String command = br.readLine();

        int[] cnt = new int[26]; //알파벳 개수 배열

        for(int i=0;i<command.length();i++){
            cnt[(int)(command.charAt(i))-97]++;
        }

        for(int i:cnt) System.out.print(i+" ");

    }
}
