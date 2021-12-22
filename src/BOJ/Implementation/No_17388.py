# 17388 와글와글 숭고한

s, k, h = map(int, input().split())

if s + k + h >= 100:
    print("OK")
else:
    min = min(s, k, h)
    if min == s:
        print("Soongsil")
    elif min == k:
        print("Korea")
    else:
        print("Hanyang")
