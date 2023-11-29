import java.util.*;
import java.io.*;

public class Main{
    static int[][] a=new int[2][41];

    public static void main(String[] args) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();

        int T=Integer.parseInt(br.readLine());
        for(int i=0;i<T;i++){
            int k=Integer.parseInt(br.readLine());
            fibo();
            sb.append(a[0][k]+" "+a[1][k]+"\n");
        }
        System.out.print(sb);
    }
    static private void fibo() {
        a[0][0]=1; a[1][0]=0;
        a[0][1]=0; a[1][1]=1;

        for(int i=2;i<=40;i++){
            a[0][i]=a[0][i-1]+a[0][i-2];
            a[1][i]=a[1][i-1]+a[1][i-2];
        }
    }
}