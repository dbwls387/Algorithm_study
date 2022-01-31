# 11727 2*n 타일링 2

# dp[1] = 1
# dp[2] = 3
# dp[3] = 5, 11, 21, 43, 85, 171 . . . 순으로 됨

n = int(input())
dp = [1, 3]

for i in range(2, n):
    dp.append((dp[i - 2] * 2 + dp[i - 1]) % 10007)

print(dp[n - 1])
