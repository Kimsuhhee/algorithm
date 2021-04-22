import java.io.*;

public class bj2562 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] numbers = new int[9];
        int idx = 0;
        int max = Integer.MIN_VALUE;

        for(int i=0;i<9;i++){
            numbers[i] = Integer.parseInt(br.readLine());
            if(max<numbers[i]){
                max = numbers[i];
                idx = i+1;
            }
        }
        bw.write(max+"\n");
        bw.write(idx+"\n");
        bw.flush();
        br.close();
        bw.close();
    }

}
