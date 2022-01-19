# 1546 평균

n = int(input())
arr = list(map(int, input().split()))
m = max(arr)
for i in range(n):
    arr[i] = arr[i] / m * 100
plus = 0
for i in range(n):
    plus += arr[i]
print(plus / n)
