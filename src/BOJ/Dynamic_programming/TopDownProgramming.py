# 동빈나 이코테 2021
# 피보나치 수열: 탑다운 다이나믹 프로그래밍 소스코드

def fibo(x):
    if x == 1 or x == 2:
        return 1
    if d[x] != 0:
        return d[x]
    d[x] = fibo(x - 1) + fibo(x - 2)
    return d[x]


d = [0] * 100
print(fibo(10))
