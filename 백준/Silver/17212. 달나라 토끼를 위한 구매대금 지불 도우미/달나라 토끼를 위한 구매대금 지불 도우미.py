n = int(input())
dp = [0, 1, 1, 2, 2, 1, 2, 1, 2, 2, 2]

for i in range(11, n + 1):
    dp.append(dp[i - 7] + 1)

print(dp[n])
