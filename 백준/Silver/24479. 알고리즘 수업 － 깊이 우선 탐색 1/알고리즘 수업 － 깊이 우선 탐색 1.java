import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static int visited[];

    static ArrayList<Integer>[] a;
    static int cnt=1;

    public static void main(String[] args) throws IOException {

        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int R=Integer.parseInt(st.nextToken());

        a=new ArrayList[N+1];
        visited=new int[N+1];

        for(int i=0;i<=N;i++){
            a[i]=new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st=new StringTokenizer(br.readLine());
            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            a[x].add(y);
            a[y].add(x);
        }
        
        for(int i=1;i<=N;i++){
            Collections.sort(a[i]);
        }

        dfs(R);

        for(int i=1;i<=N;i++){
            System.out.println(visited[i]);
        }



    }
    static void dfs(int r){
        visited[r]=cnt++;

        for(int i=0;i<a[r].size();i++){
            int v=a[r].get(i);
            if(visited[v]==0){
                dfs(v);
            }
        }

    }


}