# 2577 숫자의 개수

a = int(input())
b = int(input())
c = int(input())

n = a * b * c
result_arr = list(map(int, str(n)))
arr = [0] * 10
for i in range(len(result_arr)):
    arr[result_arr[i]] += 1

for i in range(10):
    print(arr[i])
