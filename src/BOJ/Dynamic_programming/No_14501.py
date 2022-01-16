# 퇴사

n = int(input())
t = []
p = []
for i in range(n):
    a, b = map(int, input().split())
    t.append(a)
    p.append(b)
dp = [0] * n
for i in range(n):
    if i + t[i] - 1 < n:
        # (현재까지의 dp중 최대값 + 현재 p)와 현재의 dp 중 더 큰 값을 dp에 넣어주기
        dp[i + t[i] - 1] = max(max(dp[:i] or [0]) + p[i], dp[i + t[i] - 1])
        # dp[:i]가 빈 리스트일 경우를 위해 or [0]과 함께 비교해주기
print(max(dp))
