# 4030 포켓볼

import sys


# def triangle(num):  # 삼각수 (1 ~ num 까지의 합)
#    if num == 1:
#        return 1
#    return num + triangle(num - 1)


def binary(i):
    start = 0
    end = i
    while start <= end:
        mid = (start + end) // 2
        # tri_num = triangle(mid)
        tri_num = (mid * (mid + 1)) / 2
        if i == tri_num:
            return True

        if i < tri_num:
            end = mid - 1
        else:
            start = mid + 1
    return False


n = 1
while True:
    a, b = map(int, sys.stdin.readline().split())
    if a == 0 and b == 0:
        break
    cnt = 0

    for i in range(a + 1, b):
        sqrt = i ** (1 / 2)
        if sqrt % 1 == 0:  # 어떤 수의 제곱이 되는지 확인
            if binary(i - 1):  # 삼각수인지 이분탐색으로 확인
                cnt += 1
    print("Case %d: %d" % (n, cnt))
    n += 1
