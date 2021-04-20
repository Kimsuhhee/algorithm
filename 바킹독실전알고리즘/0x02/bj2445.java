import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2445 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            for(int j=0;j<i+1;j++){
                System.out.print("*");
            }
            for(int k=0;k<(N-i)*2-2;k++){
                System.out.print(" ");
            }
            for(int l=0;l<i+1;l++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i=N-1;i>0;i--){
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            for(int k=0;k<(N-i)*2;k++){
                System.out.print(" ");
            }
            for(int l=0;l<i;l++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
