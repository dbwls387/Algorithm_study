# 1929 소수 구하기

# m, n = map(int, input().split())
# for i in range(m, n + 1):
#     ch = 0
#     if i == 1:
#         ch = 1
#
#     else:
#         for j in range(2, int(i ** 0.5) + 1):
#             if i % j == 0:
#                 ch = 1
#     if ch == 0:
#         print(i)

# 위에 코드는 시간 초과 떠서 함수로 바꿨더니 성공 . . .
def isPrime(n):
    if n <= 1:
        return False
    for j in range(2, int(n ** 0.5) + 1):
        if n % j == 0:
            return False
    return True


m, n = map(int, input().split())
for i in range(m, n + 1):
    if isPrime(i):
        print(i)
