# 2839 설탕 배달

n = int(input())
cnt = 0

while n >= 0:
    if n % 5 == 0:  # 5의 배수이면
        cnt += (n // 5)  # 그만큼의 개수를 더한 후 반복문 종료
        print(cnt)
        break
    n -= 3  # 5의 배수가 될 때까지 반복
    cnt += 1
else:
    print(-1)

# input_n = int(input())
# n = input_n
# arr = [5, 3]
# cnt = 0
# for i in arr:   # 일반적인 경우 (예를 들어 18 = (5*3) + (3*1) )
#     cnt += (n // i)
#     n %= i
#
# if n == 0:
#     print(cnt)
# else:
#     n = input_n
#     cnt = 0
#     while True:
#         if n - 3 >= 0:
#             cnt += 1
#         n -= 3
#         if n <= 0:
#             break
#         if n % 5 == 0:
#             cnt += (n // 5)
#             n %= 5
#             break
#
#     if n == 0:
#         print(cnt)
#     else:
#         print(-1)
