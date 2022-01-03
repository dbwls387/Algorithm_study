# 5063 TGN

n = int(input())
result = []

for i in range(n):
    r, e, c = map(int, input().split())
    if r + c < e:
        result.append("advertise")
    elif r + c > e:
        result.append("do not advertise")
    else:
        result.append("does not matter")

for i in range(n):
    print(result[i])
