import java.io.*;
import java.util.*;
class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        
        for(int i=0;i<=d;i+=k){
            int j=(int)(Math.sqrt((long)d*d-(long)i*i));
            answer+=(j/k)+1;  // ans=ans+ (j/k) + 1
            // i가 x라 할때 j 는 가능한 좌표최대값(y). y안에 있는 bk만 해당가능. 그 bk의 개수
            // bk개수 구하려면 j/k 해야함
        }

        return answer;
    }
}