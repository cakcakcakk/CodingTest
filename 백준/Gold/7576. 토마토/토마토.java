import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int N,M;
    static boolean zero;
    static int[][] a;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,1,-1};
    static Queue<int[]>q=new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        M=Integer.parseInt(st.nextToken());
        N=Integer.parseInt(st.nextToken());

        a=new int[N+1][M+1];

        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                a[i][j]=Integer.parseInt(st.nextToken());
                if(a[i][j]==0) zero=true;
                else if (a[i][j]==1) {q.add(new int[]{i,j});}

            }
        }

        if(!zero) {
            System.out.println(0);
            return;
        }

        bfs();

    }

    static void bfs(){


        while(!q.isEmpty()){
            int[] now=q.poll();

            for(int i=0;i<4;i++){
                int nx=now[0]+dx[i];
                int ny=now[1]+dy[i];

                if(nx<1||nx>N||ny<1||ny>M) continue;
                if(a[nx][ny]==0) {
                    q.add(new int[]{nx,ny});
                    a[nx][ny]=a[now[0]][now[1]]+1;
                }

            }
        }

        int max=0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(a[i][j]==0){
                    System.out.println(-1);
                    return;
                }
                max=Math.max(max,a[i][j]);
            }
        }

        System.out.println(max-1);

    }
}