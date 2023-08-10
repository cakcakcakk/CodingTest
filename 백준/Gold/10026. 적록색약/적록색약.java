import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt,N;
    static char a[][];
    static boolean visited[][];
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};


    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        a=new char[N][N];
        visited=new boolean[N][N];

        for(int i=0;i<N;i++){
            String str=br.readLine();
            for(int j=0;j<N;j++){
                a[i][j]=str.charAt(j);
            }

        }


        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){

                if(!visited[i][j]){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        System.out.print(cnt+" ");

        visited=new boolean[N][N];
        cnt=0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(a[i][j]=='G'){
                    a[i][j]='R';
                }
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]){
                    dfs(i,j);
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        }
    
        static void dfs(int x,int y){
            visited[x][y]=true;

            for(int i=0;i<4;i++){
                int nx=x+dx[i];
                int ny=y+dy[i];

                if(nx<0 ||nx>=N || ny<0 ||ny>=N) continue;
                if(a[x][y]==a[nx][ny] && !visited[nx][ny]){
                    dfs(nx,ny);
                }
            }
        }

}