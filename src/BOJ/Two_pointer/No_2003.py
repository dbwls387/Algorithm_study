# 수들의 합 2

import sys

input = sys.stdin.readline

n, m = map(int, input().split())
arr = list(map(int, input().split()))
cnt, start, end, sum_result = 0, 0, 0, 0

while end <= n:
    sum_result = sum(arr[start:end])
    if sum_result == m:
        cnt += 1
        end += 1
    elif sum_result < m:
        end += 1
    else:
        start += 1

print(cnt)
