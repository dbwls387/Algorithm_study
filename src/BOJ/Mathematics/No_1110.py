# 1110 더하기 사이클

input_n = int(input())
n = input_n
cnt = 0
while True:
    a = n // 10
    b = n % 10
    n = b * 10 + ((a + b) % 10)
    cnt += 1
    if n == input_n:
        break
print(cnt)