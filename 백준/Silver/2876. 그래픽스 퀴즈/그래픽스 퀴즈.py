# 2876 그래픽스 퀴즈

import sys
input = sys.stdin.readline
n = int(input())
dp = [0] * 6
max = 0
for _ in range(n):
    a, b = map(int, input().split())

    if b < a:
        a, b = b, a

    for i in range(1, 6):
        if i == a or i == b:
            dp[i] += 1
        else:
            dp[i] = 0

    if dp[a] > max:
        max = dp[a]
        grade = a
    if dp[b] > max:
        max = dp[b]
        grade = b

print(max, grade)
