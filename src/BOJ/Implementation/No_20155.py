# 20155 우리 집 밑에 편의점이 있는데
# 최빈값 구하기

n, m = map(int, input().split())
arr = list(map(int, input().split()))
cnt = []

for i in range(0, max(arr) + 1):  # 가장 큰 수까지
    cnt.append(arr.count(i))  # 각 편의점의 개수 세기

print(max(cnt))  # 편의점 개수 중 가장 큰 수 출력
