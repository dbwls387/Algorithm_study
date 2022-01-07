# 8949 대충 더해

input_a, input_b = input().split()

a = list(map(int, input_a))
b = list(map(int, input_b))
result = []
a.reverse()
b.reverse()

if len(a) > len(b):
    for i in range(len(b)):
        result.append(a[i] + b[i])
    while i != len(a) - 1:
        i += 1
        result.append(a[i])

else:
    for i in range(len(a)):
        result.append(a[i] + b[i])
    while i != len(b) - 1:
        i += 1
        result.append(b[i])

result.reverse()
print(''.join(map(str, result)))
