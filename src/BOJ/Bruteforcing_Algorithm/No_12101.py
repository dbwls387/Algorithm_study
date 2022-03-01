# 1, 2, 3 더하기 2

import sys
input = sys.stdin.readline

def DFS(sum_num, answer):
    global cnt

    if sum_num > n:
        return

    if n == sum_num:
        cnt += 1
        if cnt == k:
            print(answer[:-1])
            exit()

    for i in (1, 2, 3):
        DFS(sum_num + i, answer+str(i)+'+')

n, k = map(int, input().split())
cnt = 0
DFS(0, '')
print(-1)