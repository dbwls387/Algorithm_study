# 4344 평균은 넘겠지

t = int(input())
for a in range(t):
    arr = list(map(int, input().split()))
    mean = 0
    for i in range(1, arr[0] + 1):
        mean += arr[i]
    mean /= arr[0]
    cnt = 0
    for i in range(1, arr[0] + 1):
        if arr[i] > mean:
            cnt += 1
    print("{:.3f}%".format(cnt / arr[0] * 100))
