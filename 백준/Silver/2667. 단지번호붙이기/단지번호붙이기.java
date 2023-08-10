import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static ArrayList<Integer> eachCount=new ArrayList<>();
    static Queue<int[]> q=new LinkedList<>();
    static int count,N;
    static int a[][];
    static int[] dx={0,0,-1,1};
    static int[] dy={-1,1,0,0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        a=new int[N][N];
        int cnt=0;

        for(int i=0;i<N;i++){
            String str=br.readLine();
            for(int j=0;j<N;j++){
                a[i][j]=str.charAt(j)-'0';
            }
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(a[i][j]==1){
                    bfs(i,j);
                    cnt++;
                    eachCount.add(count);
                }
            }
        }

        Collections.sort(eachCount);
        System.out.println(cnt);
        for(int i:eachCount){
            System.out.println(i);
        }
    }

    static void bfs(int x,int y){
        q.offer(new int[]{x,y});
        count=1;
        a[x][y]=0;

        while(!q.isEmpty()){
            int[] now=q.poll();
            for(int i=0;i<4;i++){
                int nx=now[0]+dx[i];
                int ny=now[1]+dy[i];

                if(nx<0||nx>=N|| ny<0||ny>=N) continue;
                if(a[nx][ny]==1){
                    a[nx][ny]=0;
                    q.offer(new int[]{nx,ny});
                    count++;
                }
            }
        }

    }

}