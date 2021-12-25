# 12845 모두의 마블

n = int(input())

card = list(map(int, input().split()))
card.sort(reverse=True)  # 내림차순 정렬

gold = card[0] * (n - 1)  # 가장 큰 레벨의 카드는 n-1개 더해짐

for i in range(1, n):  # 가장 큰 레벨의 카드는 빼고 1~n-1까지
    gold += card[i]

print(gold)