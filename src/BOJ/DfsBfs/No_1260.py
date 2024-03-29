# 1260 DFS와 BFS

from collections import deque
import sys

input = sys.stdin.readline


def dfs(v):
    visited_dfs[v] = 1  # 현재 노드를 방문 처리
    print(v, end=' ')
    for i in range(1, n + 1):
        if visited_dfs[i] == 0 and graph[v][i] == 1:
            dfs(i)


def bfs(v):
    q = deque()
    q.append(v)
    visited_bfs[v] = 1
    while q:
        v = q.popleft()
        print(v, end=' ')
        for i in range(1, n + 1):
            if visited_bfs[i] == 0 and graph[v][i] == 1:
                q.append(i)
                visited_bfs[i] = 1


n, m, v = map(int, input().split())

graph = [[0] * (n + 1) for _ in range(n + 1)]
visited_dfs = [0] * (n + 1)
visited_bfs = [0] * (n + 1)

for i in range(m):
    a, b = map(int, input().split())
    graph[a][b] = graph[b][a] = 1

dfs(v)
print()
bfs(v)
