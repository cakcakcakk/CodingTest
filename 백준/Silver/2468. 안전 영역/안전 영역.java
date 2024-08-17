import java.io.*;
import java.util.*;

public class Main
{
    static int[][] arr;
    static int cnt,result,n;  //0으로 초기화될 것임
    static int min=100;
    static int max=1;
    static int[] dx={-1,1,0,0};
    static int[] dy={0,0,-1,1};
    static boolean[][] visited;
    static StringBuilder sb=new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n=Integer.parseInt(br.readLine());

        arr=new int[n][n];

        for(int i=0;i<n;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                min=Math.min(min,arr[i][j]);
                max=Math.max(max,arr[i][j]);
            }
        }

        if(min==max) {
            System.out.println(1);
            return;
        }

        for(int h=min;h<=max;h++) {
            cnt=0;
            visited=new boolean[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++) {

                    if(!visited[i][j]&&arr[i][j]>h) {

                        visited[i][j]=true;
                        dfs(i,j,h);
                        cnt++;

                    }
                }
            }
            result=Math.max(cnt,result);
        }

        System.out.println(result);
    }

    private static void dfs(int x, int y, int height) {

        for(int i=0;i<4;i++) {
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0 || nx>=n || ny<0 || ny>=n) continue;
            if(!visited[nx][ny] && arr[nx][ny]>height) {

                visited[nx][ny]=true;
                dfs(nx,ny,height);
            }
        }
    }
}