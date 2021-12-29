import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class bj2251 {
    static int[] water = new int[3];
    static ArrayList<Integer>answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        water[0] = Integer.parseInt(stk.nextToken());
        water[1] = Integer.parseInt(stk.nextToken());
        water[2] = Integer.parseInt(stk.nextToken());

        answer = new ArrayList<>();

        boolean[][][]visited = new boolean[201][201][201];
        Queue<Bucket>q = new LinkedList<>();

        Bucket bucket = new Bucket(0,0,water[2]);

        q.add(bucket);

        while(!q.isEmpty()){
            Bucket cur = q.poll();

            if(cur.A==0 && !answer.contains(cur.C)){
                answer.add(cur.C);
            }
            if(visited[cur.A][cur.B][cur.C])continue;
            visited[cur.A][cur.B][cur.C] = true;
            //A->B
            if(cur.A+cur.B>water[1]){
                if(!visited[cur.A+cur.B-water[1]][water[1]][cur.C])
                q.add(new Bucket(cur.A+cur.B-water[1],water[1],cur.C));
            }else{
                if(!visited[0][cur.B+cur.A][cur.C])
                q.add(new Bucket(0,cur.B+cur.A,cur.C));
            }
            //A->C
            if(cur.A+cur.C>water[2]){
                if(!visited[cur.A+cur.C-water[2]][cur.B][water[2]])
                q.add(new Bucket(cur.A+cur.C-water[2],cur.B,water[2]));
            }else{
                if(!visited[0][cur.B][cur.C+cur.A])
                q.add(new Bucket(0,cur.B,cur.C+cur.A));
            }
            //B->C
            if(cur.B+cur.C>water[2]){
                if(!visited[cur.A][cur.B+cur.C-water[2]][water[2]])
                q.add(new Bucket(cur.A,cur.B+cur.C-water[2],water[2]));
            }else{
                if(!visited[cur.A][0][cur.C+cur.B])
                q.add(new Bucket(cur.A,0,cur.C+cur.B));
            }
            //B->A
            if(cur.B+cur.A>water[0]){
                if(!visited[water[0]][cur.B+cur.A-water[0]][cur.C])
                q.add(new Bucket(water[0],cur.B+cur.A-water[0], cur.C));
            }else{
                if(!visited[cur.A+cur.B][0][cur.C])
                q.add(new Bucket(cur.A+cur.B,0,cur.C));
            }
            //C->A
            if(cur.C+cur.A>water[0]){
                if(!visited[water[0]][cur.B][cur.C+cur.A-water[0]])
                q.add(new Bucket(water[0],cur.B, cur.C+cur.A-water[0]));
            }else{
                if(!visited[cur.A+cur.C][cur.B][0])
                q.add(new Bucket(cur.A+cur.C,cur.B,0));
            }
            //C->B
            if(cur.C+cur.B>water[1]){
                if(!visited[cur.A][water[1]][cur.C+cur.B-water[1]])
                q.add(new Bucket(cur.A,water[1],cur.C+cur.B-water[1]));
            }else{
                if(!visited[cur.A][cur.C+cur.B][0])
                q.add(new Bucket(cur.A,cur.C+cur.B,0));
            }
        }
        Collections.sort(answer);
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<answer.size();i++){
            sb.append(answer.get(i)+" ");
        }
        System.out.println(sb);
    }

    private static class Bucket {
        int A,B,C;

        public Bucket(int A, int B, int C) {
            this.A = A;
            this.B = B;
            this.C = C;
        }
    }
}
