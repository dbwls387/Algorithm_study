# 1904 01타일

n = int(input())
d = [1, 2]
for i in range(2, n):
    d.append((d[i - 2] + d[i - 1]) % 15746)

print(d[n - 1])
