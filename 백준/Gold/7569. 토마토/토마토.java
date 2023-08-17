import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static boolean zero;
    static int M,N,H;
    static int[][][]a;
    static int[] dx={-1,1,0,0,0,0};
    static int[] dy={0,0,1,-1,0,0};
    static int[] dz={0,0,0,0,-1,1};
    static Queue<Point>q=new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

         M=Integer.parseInt(st.nextToken());
         N=Integer.parseInt(st.nextToken());
         H=Integer.parseInt(st.nextToken());

        a=new int[H+1][N+1][M+1];

        for(int i=1;i<=H;i++){
            for(int j=1;j<=N;j++){
                st=new StringTokenizer(br.readLine());
                for(int k=1;k<=M;k++){
                    a[i][j][k]=Integer.parseInt(st.nextToken());
                    if(a[i][j][k]==1) {q.offer(new Point(i,j,k));}
                    else if(a[i][j][k]==0){zero=true;}

                }
            }
        }

        if(!zero){
            System.out.println(0);
            return;
        }

        bfs();
        
    }

    static void bfs(){

        while(!q.isEmpty()){
            Point now=q.poll();

            for(int i=0;i<6;i++){
                int nx=now.x+dx[i];
                int ny=now.y+dy[i];
                int nz=now.z+dz[i];

                if(nx>=1&&nx<=M&&ny>=1&&ny<=N&&nz>=1&&nz<=H && a[nz][ny][nx]==0){
                    q.add(new Point(nz,ny,nx));
                    a[nz][ny][nx]=a[now.z][now.y][now.x]+1;
                }
            }
        }

        int max=0;
        for(int i=1;i<=H;i++){
            for(int j=1;j<=N;j++){
                for(int k=1;k<=M;k++){
                    if(a[i][j][k]==0) {
                        System.out.println(-1);
                        return;
                    }
                    max=Math.max(max,a[i][j][k]);
                }
            }
        }

        System.out.println(max-1);
        
    }

}

class Point{
    int x,y,z;
    public Point(int z,int y,int x){
        this.z=z;
        this.y=y;
        this.x=x;
    }
}