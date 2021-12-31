# 16204 카드 뽑기

n, m, k = map(int, input().split())

if m < k:
    m, k = k, m

result = abs(n - m + k)
print(result)
