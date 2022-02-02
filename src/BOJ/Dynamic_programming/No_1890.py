# 1890 점프

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
dp = [[0] * n for _ in range(n)]
dp[0][0] = 1

for i in range(n):
    for j in range(n):
        if i == n - 1 and j == n - 1:
            break
        step = arr[i][j]
        if i + step < n:  # 아래
            dp[i + step][j] += dp[i][j]

        if j + step < n:  # 오른쪽
            dp[i][j + step] += dp[i][j]

print(dp[n - 1][n - 1])
