import java.util.*;
import java.io.*;

public class Main {
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int N=Integer.parseInt(br.readLine());
        a=new int[N];

        StringTokenizer st=new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            a[i]=Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);

        int M=Integer.parseInt(br.readLine());

        st=new StringTokenizer(br.readLine());
        for(int i=0;i<M;i++){
            int k=Integer.parseInt(st.nextToken());
            sb.append(upper(a,k)-lower(a,k)).append(' ');

        }
        System.out.println(sb);
    }

    public static int upper(int[] a,int k){
        int low=0;
        int high=a.length;

        while(low<high){
            int mid=(low+high)/2;
            if(a[mid]>k){
                high=mid;
            }
            else {
                low=mid+1;
            }

        }
        return low;

    }

    public static int lower(int[] a, int k){
        int low=0;
        int high=a.length;

        while(low<high){
            int mid=(low+high)/2;

            if(a[mid]<k){
                low=mid+1;
            }
            else {
                high=mid;
            }
        }
        return low;
    }
}
