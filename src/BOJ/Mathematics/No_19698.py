# 19698 헛간 청약

n, w, h, l = map(int, input().split())

width = w // l
height = h // l

if width * height < n:
    print(width * height)
else:
    print(n)
