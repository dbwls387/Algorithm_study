# 3052 나머지

arr = [] * 10
for i in range(10):
    arr.append(int(input()))
mod = [0] * 42
for i in range(10):
    mod[arr[i] % 42] = 1
cnt = 0
for i in range(42):
    if mod[i] != 0:
        cnt += 1

print(cnt)
