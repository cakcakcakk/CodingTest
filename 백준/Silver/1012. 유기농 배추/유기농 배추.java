import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    static int cnt,M,N;
    static int a[][];
    static Queue<int[]>q=new LinkedList<>();
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int T=Integer.parseInt(br.readLine());
        for(int t=0;t<T;t++){

            StringTokenizer st=new StringTokenizer(br.readLine()," ");
            M=Integer.parseInt(st.nextToken());
            N=Integer.parseInt(st.nextToken());
            int K=Integer.parseInt(st.nextToken());

            a=new int[M][N];
            cnt=0;

            for(int i=0;i<K;i++){
                st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());

                a[x][y]=1;

            }

            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    if(a[i][j]==1){
                        bfs(i,j);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);

        }

    }

    static void bfs(int x,int y){
        a[x][y]=0;
        q.add(new int[]{x,y});

        while(!q.isEmpty()){
            int[] now=q.poll();

            for(int i=0;i<4;i++){
                int nx=now[0]+dx[i];
                int ny=now[1]+dy[i];

                if(nx<0||nx>=M||ny<0||ny>=N) continue;
                if(a[nx][ny]==1){
                    a[nx][ny]=0;
                    q.add(new int[]{nx,ny});
                }
            }
        }

    }

}