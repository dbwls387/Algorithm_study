# 9095 1, 2, 3 더하기

t = int(input())
d = [1, 2, 4]
n = []
for i in range(t):
    n.append(int(input()))

for i in range(3, max(n)):
    d.append(d[i - 3] + d[i - 2] + d[i - 1])

for i in n:
    print(d[i-1])