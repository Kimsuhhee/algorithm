import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2752 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numbers = br.readLine();
        String[] number = numbers.split(" ");
        int[] intArr= new int[3];
        for(int i=0;i<3;i++){
            intArr[i] = Integer.parseInt(number[i]);
        }
        Arrays.sort(intArr);
        for(int i:intArr) System.out.print(i+" ");

    }
}
