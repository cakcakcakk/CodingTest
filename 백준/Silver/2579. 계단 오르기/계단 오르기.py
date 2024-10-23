import sys
input=sys.stdin.readline

N=int(input())
a=[int(input()) for _ in range(N)]
dp=[0 for _ in range(N)]

if N<=2: 
    print(sum(a))
    exit()
    
else:
    dp[0]=a[0]
    dp[1]=a[0]+a[1]
    dp[2]=max(a[0],a[1])+a[2]

    for i in range(3,N):
        dp[i]=max(dp[i-2]+a[i],dp[i-3]+a[i-1]+a[i])
    
    print(dp[N-1])