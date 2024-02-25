import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] data = new int[n];
		String[] str = br.readLine().split(" ");
		int[] dp = new int[n];
		
		for (int i=0; i<n; i++) {
			data[i] = Integer.parseInt(str[i]);
			dp[i] = 1;
		}
		
		int result = 0;
		for (int i=0; i<n; i++) {
			for (int j=0; j<i; j++) {
				if (data[j] > data[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(result);
	}
}