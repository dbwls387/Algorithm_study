# 1919 애너그램 만들기

a = sorted(input())
b = sorted(input())
i = 0
while i != len(b):
    if b[i] in a:
        a.remove(a[a.index(b[i])])
        b.remove(b[i])
        i -= 1
    i += 1

print(len(a) + len(b))
