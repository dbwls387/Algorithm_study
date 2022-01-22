# 1931 회의실 배정

import sys  # 시간 오래 걸리는 거 수정
input = sys.stdin.readline

n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]
arr.sort(key=lambda x: (x[1], x[0]))
cnt = 1
finish = arr[0][1]
for i in range(1, n):
    if arr[i][0] >= finish and arr[i][1] >= finish:
        cnt += 1
        finish = arr[i][1]

print(cnt)
