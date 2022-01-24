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

### 처음 짠 코드 -> 시간초과 떠서 실패
# import sys
# t = int(input())
# for a in range(t):
#     n = int(input())
#     arr = [list(map(int, sys.stdin.readline().split())) for _ in range(n)]
#     arr.sort(reverse=True, key=lambda x: (x[0]))
#
#     i = 0
#     cnt = 0
#     while i != len(arr):
#         i = 0
#         for j in range(1, len(arr)):
#             if arr[i][1] > arr[j][1]:
#                 arr.pop(i)
#                 break
#         else:
#             cnt += 1
#             arr.pop(i)
#
#     print(cnt)