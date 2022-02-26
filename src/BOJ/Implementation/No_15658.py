# 연산자 끼워넣기 (2)

n = int(input())
arr = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())
max_result = -1000000000
min_result = 1000000000


def dfs(idx, i, add, sub, mul, div):
    global max_result, min_result
    if idx == n:
        max_result = max(max_result, i)
        min_result = min(min_result, i)
        return

    if add > 0:
        dfs(idx + 1, i + arr[idx], add - 1, sub, mul, div)
    if sub > 0:
        dfs(idx + 1, i - arr[idx], add, sub - 1, mul, div)
    if mul > 0:
        dfs(idx + 1, i * arr[idx], add, sub, mul - 1, div)
    if div > 0:
        dfs(idx + 1, int(i / arr[idx]), add, sub, mul, div - 1)


dfs(1, arr[0], add, sub, mul, div)
print(max_result)
print(min_result)
