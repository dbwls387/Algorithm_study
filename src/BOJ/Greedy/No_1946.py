# 1946 신입 사원

import sys

t = int(input())
for _ in range(t):
    n = int(input())
    arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
    arr.sort(key=lambda x: (x[0]))
    cnt = 1
    max = arr[0][1]
    for i in range(1, n):
        if arr[i][1] < max:
            max = arr[i][1]
            cnt += 1

    print(cnt)
