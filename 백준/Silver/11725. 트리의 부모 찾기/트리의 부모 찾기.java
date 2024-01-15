import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static boolean[] visited;
    static int[] p;
    static Queue<Integer> q=new LinkedList<>();
    static ArrayList<Integer>[] a;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        int N=Integer.parseInt(br.readLine());
        visited=new boolean[N+1];
        a=new ArrayList[N+1];
        p=new int[N+1];

        for(int i=0;i<=N;i++){
            a[i]=new ArrayList<>();
        }


        for(int i=0;i<N-1;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            a[x].add(y);
            a[y].add(x);

        }

        bfs();

        for(int i=2;i<=N;i++){
            System.out.println(p[i]);
        }

    }
    public static void bfs(){
        q.offer(1);
        visited[1]=true;

        while(!q.isEmpty()){

            int r=q.poll();
            for(int i:a[r]){
                if(!visited[i]){
                    q.offer(i);
                    visited[i]=true;
                    p[i]=r;
                }
            }

        }

    }

}