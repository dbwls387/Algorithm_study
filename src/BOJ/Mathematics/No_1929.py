# 1929 소수 구하기

m, n = map(int, input().split())

for j in range(m, n):
    ch = 0
    for i in range(2, j):
        if j % i == 0:
            ch = 1
    if ch == 0:
        print(j)
