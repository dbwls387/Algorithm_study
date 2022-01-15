# 2579 계단 오르기

n = int(input())
arr = []
for i in range(n):
    arr.append(int(input()))
dp = []
dp.append(arr[0])  # dp[0]
if n > 1:
    dp.append(arr[0] + arr[1])  # dp[1]
    if n > 2:
        dp.append(arr[2] + max(arr[0], arr[1]))  # dp[2]

        for i in range(3, n):
            dp.append(max(dp[i - 2] + arr[i], dp[i - 3] + arr[i] + arr[i - 1]))

print(dp[n - 1])
