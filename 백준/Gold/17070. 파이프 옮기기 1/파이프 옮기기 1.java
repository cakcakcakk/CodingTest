import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[][] a;
    static int cnt,N;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N=Integer.parseInt(br.readLine());

        a=new int[N+1][N+1];

        for(int i=1;i<=N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=1;j<=N;j++){
                a[i][j]=Integer.parseInt(st.nextToken());
            }
        }
        dfs(1,2,0);

        System.out.println(cnt);

    }

    static void dfs(int x,int y,int dir){
        if(x==N&&y==N){
            cnt++;
            return;
        }

        if(dir==0){
            if(y+1<=N && a[x][y+1]==0){
                dfs(x,y+1,0);
            }
            if (diagonal(x,y)){
                dfs(x+1,y+1,2);
            }
        }
        else if (dir==1){
            if(x+1<=N && a[x+1][y]==0){
                dfs(x+1,y,1);
            }
            if (diagonal(x,y)){
                dfs(x+1,y+1,2);
            }
        }
        else {
            if(y+1<=N&&a[x][y+1]==0){
                dfs(x,y+1,0);
            }

            if(x+1<=N&&a[x+1][y]==0){
                dfs(x+1,y,1);
            }

            if(diagonal(x,y)){
                dfs(x+1,y+1,2);
            }
        }
    }

    static boolean diagonal(int x,int y){
        if((x+1<=N)&&(y+1<=N)&&a[x][y+1]==0&&a[x+1][y]==0&&a[x+1][y+1]==0){
            return true;
        }
        else return false;

    }
}