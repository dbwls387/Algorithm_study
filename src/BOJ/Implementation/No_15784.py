# 15784 질투진서

n, a, b = map(int, input().split())
seat = [list(map(int, input().split())) for _ in range(n)]
a-=1
b-=1
jinseo = seat[a][b]
angry = 0
for i in range(n):
    if seat[i][b] > jinseo:
        angry = 1

if angry == 0:
    for i in range(n):
        if seat[a][i] > jinseo:
            angry = 1

if angry == 1:
    print("ANGRY")
else:
    print("HAPPY")
