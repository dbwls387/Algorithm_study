# 2839 설탕 배달

input_n = int(input())
n = input_n
arr = [5, 3]
cnt = 0
for i in arr:   # 일반적인 경우 (예를 들어 18 = (5*3) + (3*1) )
    cnt += (n // i)
    n %= i

if n == 0:
    print(cnt)
else:
    n = input_n
    cnt = 0
    while True:
        if n - 3 >= 0:
            cnt += 1
        n -= 3
        if n <= 0:
            break
        if n % 5 == 0:
            cnt += (n // 5)
            n %= 5
            break

    if n == 0:
        print(cnt)
    else:
        print(-1)
