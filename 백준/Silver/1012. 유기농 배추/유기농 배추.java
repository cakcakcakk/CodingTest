import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int cnt,M,N;
    static int[][]a;
    static int[] dx={1,-1,0,0};
    static int[] dy={0,0,-1,1};
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));


        int T=Integer.parseInt(br.readLine());

        for(int t=0;t<T;t++){

            StringTokenizer st=new StringTokenizer(br.readLine());
            M=Integer.parseInt(st.nextToken());
            N=Integer.parseInt(st.nextToken());
            int K=Integer.parseInt(st.nextToken());

            cnt=0;
            a=new int[M][N];
            visited=new boolean[M][N];

            for(int i=0;i<K;i++){
                st=new StringTokenizer(br.readLine());
                int x=Integer.parseInt(st.nextToken());
                int y=Integer.parseInt(st.nextToken());
                a[x][y]=1;

            }

            for(int i=0;i<M;i++){
                for(int j=0;j<N;j++){
                    if (!visited[i][j] && a[i][j]==1){
                        dfs(i,j);
                        cnt++;
                    }


                }
            }

            System.out.println(cnt);








        }











    }

    static void dfs(int x, int y){
        visited[x][y]=true;

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if (nx<0 || nx>=M || ny<0 || ny>=N) continue;
            if (visited[nx][ny]) continue;
            if(!visited[nx][ny]&& a[nx][ny]==1) {

                dfs(nx,ny);

            }


        }




    }





}