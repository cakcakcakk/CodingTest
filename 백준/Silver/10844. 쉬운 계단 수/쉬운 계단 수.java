import java.io.*;
import java.util.*;

public class Main {
    static int[][] a;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());

        a=new int[n+1][10];
        
        for(int j=1;j<10;j++) {
            a[1][j]=1;
        }

        for(int i=2;i<=n;i++) {

            a[i][0]=(a[i-1][1])%1000000000;
            for(int j=1;j<=8;j++) {
                a[i][j]=(a[i-1][j-1]+a[i-1][j+1])%1000000000;
            }
            a[i][9]=(a[i-1][8])%1000000000;
            
        }

        for(int k:a[n]) {
            result=(result+k)%1000000000;
        }
        
        System.out.println(result);
    }

}
