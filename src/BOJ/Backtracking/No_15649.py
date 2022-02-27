# N과 M (1)

n, m = map(int, input().split())
solve = []

def dfs(depth):
    if depth == m:
        for i in solve:
            print(i, end=' ')
        print()
        return

    for i in range(1, n + 1):
        if i not in solve:
            solve.append(i)
            dfs(depth + 1)
            solve.pop()

dfs(0)