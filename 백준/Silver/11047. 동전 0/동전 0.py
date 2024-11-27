n,k=map(int,input().split())
arr=[int(input()) for _ in range(n)]
result=0

for i in arr[::-1]:
    result+=(k//i)
    k%=i

print(result)    