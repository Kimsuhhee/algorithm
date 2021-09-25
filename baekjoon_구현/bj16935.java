import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj16935 {
    static int N,M,R;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stk.nextToken());
        M = Integer.parseInt(stk.nextToken());
        R = Integer.parseInt(stk.nextToken());
        arr = new int[N][M];
        for(int i=0;i<N;i++){
            stk = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(stk.nextToken());
            }
        }

        stk = new StringTokenizer(br.readLine());
        while(R-- > 0){
            int command = Integer.parseInt(stk.nextToken());
            switch (command){
                case 1: reverseUpAndDown(); break;
                case 2: reverseLeftAndDown();break;
                case 3: rotateRight();break;
                case 4: rotateLeft();break;
                case 5: moveRight();break;
                case 6: moveLeft();break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                sb.append(arr[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }

    private static void copyArr(int[][] temp) {
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++){
                temp[i][j] = arr[i][j];
            }
        }
    }

    private static void reverseUpAndDown() {
        int[][] temp = new int[N][M];
        copyArr(temp);

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j] = temp[N-i-1][j];
            }
        }
    }

    private static void reverseLeftAndDown() {
        int[][] temp = new int[N][M];
        copyArr(temp);

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                arr[i][j] = temp[i][M-1-j];
            }
        }
    }

    private static void rotateRight() {
        int[][] temp = new int[N][M];
        copyArr(temp);

        arr = new int[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                arr[i][j] = temp[N-1-j][i];
            }
        }
        int t = M;
        M = N;
        N = t;

    }

    private static void rotateLeft() {
        int[][] temp = new int[N][M];
        copyArr(temp);

        arr = new int[M][N];
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                arr[i][j] = temp[j][M-i-1];
            }
        }
        int t = M;
        M = N;
        N = t;
    }

    private static void moveRight() {
        int[][] temp = new int[N][M];
        copyArr(temp);

        for(int x = 0;x<N/2;x++){
            for(int y = 0;y<M/2;y++){
                arr[x][y] = temp[x+N/2][y];
            }
        }

        for(int x = 0;x<N/2;x++){
            for(int y =M/2;y<M;y++){
                arr[x][y] = temp[x][y-M/2];
            }
        }

        for(int x = N/2;x<N;x++){
            for(int y = M/2;y<M;y++){
                arr[x][y] = temp[x-N/2][y];
            }
        }

        for(int x=N/2;x<N;x++){
            for(int y=0;y<M/2;y++){
                arr[x][y] = temp[x][y+M/2];
            }
        }

    }

    private static void moveLeft() {
        int[][] temp = new int[N][M];
        copyArr(temp);

        for(int x=0;x<N/2;x++){
            for(int y=0;y<M/2;y++){
                arr[x][y] = temp[x][y+M/2];
            }
        }

        for(int x=0;x<N/2;x++){
            for(int y=M/2;y<M;y++){
                arr[x][y] = temp[x+N/2][y];
            }
        }

        for(int x=N/2;x<N;x++){
            for(int y=M/2;y<M;y++){
                arr[x][y] = temp[x][y-M/2];
            }
        }

        for(int x=N/2;x<N;x++){
            for(int y=0;y<M/2;y++){
                arr[x][y] = temp[x-N/2][y];
            }
        }
    }


}
