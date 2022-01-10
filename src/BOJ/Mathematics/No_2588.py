# 2588 곱셈

a = int(input())
input_b = input()

b = list(map(int, input_b))
b.reverse()
result = 0
for i in range(len(b)):
    result += a * b[i] * (10 ** i)
    print(a * b[i])

print(result)
