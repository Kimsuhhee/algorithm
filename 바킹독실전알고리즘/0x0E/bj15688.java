import java.io.*;

public class bj15688 {
    static int N;
    static int arr[] = new int[2000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i=0;i<N;i++) {
            int x = Integer.parseInt(br.readLine());
            arr[1000000+x]++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<2000001;i++){
            while(arr[i]-- > 0){
                sb.append(i-1000000).append("\n");
            }
        }

        System.out.println(sb);
    }
}
