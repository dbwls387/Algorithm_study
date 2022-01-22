# 11256 사탕

t = int(input())
for a in range(t):
    arr = []
    j, n = map(int, input().split())
    for i in range(n):
        r, c = map(int, input().split())
        arr.append(r * c)
    arr.sort(reverse=True)
    cnt = 0
    for i in range(n):
        j -= arr[i]
        cnt += 1
        if j <= 0:
            break
    print(cnt)
