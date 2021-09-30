import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj2670 {
    static int N;
    static double[] arr,d;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new double[N];
        for(int i=0;i<N;i++){
            arr[i] = Double.parseDouble(br.readLine());
        }
        d = new double[N];
        d[0] = arr[0];
        double max = d[0];
        for(int i=1;i<N;i++){
            d[i] = Math.max(d[i-1]*arr[i],arr[i]);
            max = Math.max(d[i],max);
        }
        System.out.println(String.format("%.3f",max));
    }
}
