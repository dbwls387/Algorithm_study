# 2491 수열

n = int(input())
arr = list(map(int, input().split()))
dp = [1] * n
cnt = 0
for i in range(n - 1):  # 오름차순일 경우
    if arr[i] <= arr[i + 1]:
        cnt += 1
    else:
        dp[arr[i + 1]] = max(cnt + 1, dp[arr[i + 1]])
        cnt = 0
if cnt > 0:  # 만약 1 1 1 1 1 처럼 같은 숫자만이 입력될 경우 else문을 들어가지 않고 빠져나오게 됨
    dp[arr[i + 1]] = max(cnt + 1, dp[arr[i + 1]])
    cnt = 0

for i in range(n - 1):  # 내림차순일 경우
    if arr[i] >= arr[i + 1]:
        cnt += 1
    else:
        dp[arr[i]] = max(cnt + 1, dp[arr[i]])
        cnt = 0
if cnt > 0:
    dp[arr[i]] = max(cnt + 1, dp[arr[i]])

print(max(dp))
