import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int[][][] arr=new int[21][21][21];
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        StringTokenizer st;
        int result=0;

        for(int i=0;i<21;i++){
            for(int j=0;j<21;j++){
                for(int k=0;k<21;k++){
                    if(i==0 || j==0 ||k==0) arr[i][j][k]=1;
                    else if(i<j &&j<k) arr[i][j][k]=arr[i][j][k-1]+arr[i][j-1][k-1]-arr[i][j-1][k];
                    else arr[i][j][k]=arr[i-1][j][k]+arr[i-1][j-1][k]+arr[i-1][j][k-1]-arr[i-1][j-1][k-1];
                }
            }
        }

        while(true){
            st=new StringTokenizer(br.readLine());
            int a=Integer.parseInt(st.nextToken());
            int b=Integer.parseInt(st.nextToken());
            int c=Integer.parseInt(st.nextToken());

            if(a==-1&&b==-1&&c==-1) break;
            if (a<=0 || b<=0 || c<=0) result=1;
            else if(a>20 || b>20 ||c>20) result=arr[20][20][20];
            else result=arr[a][b][c];

            sb.append("w("+a+", "+b+", "+c+") = " ).append(result+"\n");
        }
        System.out.print(sb);
    }
}