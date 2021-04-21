import java.io.*;

public class bj15552 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            String tmp = br.readLine();
            String[] ab = tmp.split(" ");
            int A = Integer.parseInt(ab[0]);
            int B = Integer.parseInt(ab[1]);
            bw.write(A+B+"\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
