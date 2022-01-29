# 9657 돌 게임 3

# 상근이가 [i-1], [i-3], [i-4]이 모두 이기면 i번찌에는 창영이가 이김

n = int(input())
dp = [1, 0, 1, 1, 1]  # 상근이가 이기는 게 1

for i in range(5, n):
    if dp[i - 1] == 1 and dp[i - 3] == 1 and dp[i - 4] == 1:
        dp.append(0)
    else:
        dp.append(1)

if dp[n - 1] == 1:
    print("SK")
else:
    print("CY")

