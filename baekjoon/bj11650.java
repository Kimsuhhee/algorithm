import java.io.*;
import java.util.*;

public class bj11650 {
    static int N;
    static int[][] points;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        points = new int[N][2];

        for(int i=0;i<N;i++) {
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s);
            points[i][0] = Integer.parseInt(st.nextToken());
            points[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else
                    return o1[0]-o2[0];
            }
        });

        for(int i=0;i<N;i++){
            for(int j=0;j<2;j++){
                System.out.print(points[i][j]+" ");
            }
            System.out.println();
        }
    }
}
