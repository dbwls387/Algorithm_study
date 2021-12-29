# 20362 유니대전 퀴즈쇼

n, s = input().split()
n = int(n)
arr = []
cnt = 0
for i in range(n):
    arr.append(list(input().split()))
    if arr[i][0] == s:  # 정답 찾기
        answer = arr[i][1]

i = 0
while arr[i][0] != s:
    if arr[i][1] == answer:
        cnt += 1
    i += 1

print(cnt)
