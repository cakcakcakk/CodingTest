import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static int result,N;
    static ArrayList<Integer> eachCount;
    static int[][] a;
    static boolean[][] visited;
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);

        int cnt=0;
        N=Integer.parseInt(br.readLine());
        eachCount=new ArrayList<>();
        a=new int[N][N];
        visited=new boolean[N][N];

        for(int i=0;i<N;i++){
            String str=br.readLine();
            for(int j=0;j<N;j++){
                a[i][j]=str.charAt(j)-'0';
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visited[i][j]&&a[i][j]==1){
                    result=1;
                    cnt++;
                    dfs(i,j);
                    eachCount.add(result);
                }
            }
        }
        Collections.sort(eachCount);

        System.out.println(cnt);
        for(int i:eachCount){
            System.out.println(i);
        }
        }
    static void dfs(int x,int y){

        visited[x][y]=true;

        for(int i=0;i<4;i++){
            int nx=x+dx[i];
            int ny=y+dy[i];

            if(nx<0 || nx>=N||ny<0||ny>=N){
                continue;
                }
            if(!visited[nx][ny]&&a[nx][ny]==1){
                result++;
                dfs(nx,ny);
            }
        }

    }

}