# 19563 개구리 1

a, b, c = map(int, input().split())
sum = abs(a) + abs(b)

if sum <= c:
    if (c - (sum)) % 2 == 0:
        print("YES")
    else:
        print("NO")
else:
    print("NO")
