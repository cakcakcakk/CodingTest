import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static int max=Integer.MIN_VALUE;
    static int N,M;
    static int[][]a;
    static int[][]b;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        a=new int[N+1][M+1];

        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++){
                a[i][j]=Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(max);

    }

    static void dfs(int w){
        if(w==3){
            bfs();
            return;
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(a[i][j]==0){
                    a[i][j]=1;
                    dfs(w+1);
                    a[i][j]=0;
                }
            }
        }
    }

    static void bfs(){
        Queue<int[]>q=new LinkedList<>();
        b=new int[N+1][M+1];

        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                b[i][j]=a[i][j];
                if(b[i][j]==2) {
                    q.add(new int[]{i,j});
                }
            }
        }

        while(!q.isEmpty()){
            int[] now=q.poll();

            for(int i=0;i<4;i++){
                int nx=now[0]+dx[i];
                int ny=now[1]+dy[i];

                if(nx<1 ||nx>N||ny<1||ny>M) continue;
                if (b[nx][ny]==0){
                    b[nx][ny]=2;
                    q.add(new int[]{nx,ny});
                }
            }
        }

        int cnt=0;
        for(int i=1;i<=N;i++){
            for(int j=1;j<=M;j++){
                if(b[i][j]==0){
                    cnt++;
                }
            }
        }
        max=Math.max(cnt,max);
    }
}