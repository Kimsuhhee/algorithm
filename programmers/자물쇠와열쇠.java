public class 자물쇠와열쇠 {
    public static void main(String[] args) {
        int[][] key = {{0,0,0},{1,0,0},{0,1,1}};
        int[][] lock = {{1,1,1},{1,1,0},{1,0,1}};
        System.out.println(solution(key,lock));
    }
    public static boolean solution(int[][] key, int[][] lock) {
        int m = key.length; int n = lock.length;

        int rot =4;
        while(rot-- > 0) {
            rotate(key);
            for (int i = 0; i <= (n + (m - 1) * 2)-m; i++) {
                for (int j = 0; j <= (n + (m - 1) * 2)-m; j++) {
                    int[][] temp = new int[n + (m - 1) * 2][n + (m - 1) * 2];
                    init(temp,lock,m,n);

                        for (int x = 0; x < m; x++) {
                            for (int y = 0; y < m; y++) {
                                temp[i + x][j + y] += key[x][y];
                            }
                        }

                    if (possible(temp, m, n)) return true;
                    }
                }
            }

        return false;
    }

    private static void init(int[][] temp, int[][] lock, int m, int n) {
        for (int i = (m - 1); i < (m - 1) + n; i++) {
            for (int j = (m - 1); j < (m - 1) + n; j++) {
                temp[i][j] = lock[i - (m - 1)][j - (m - 1)];
            }
        }
    }

    private static boolean possible(int[][] temp, int m, int n) {
        for (int i = (m - 1); i < (m - 1) + n; i++) {
            for (int j = (m - 1); j < (m - 1) + n; j++) {
                if(temp[i][j] == 2||temp[i][j] == 0) return false;
            }
        }
        return  true;
    }


    private static void rotate(int[][] key) {
        int len = key.length;
        int[][] r = new int[len][len];
        for(int i = 0;i < len;i++){
            for(int j = 0;j < len;j++){
                r[i][j] = key[j][len - 1 - i];
            }
        }
        for(int i = 0;i < len;i++){
            for(int j = 0;j < len;j++){
                key[i][j] = r[i][j];
            }
        }

    }
}
