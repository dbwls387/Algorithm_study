# 8958 OX퀴즈

t = int(input())
for a in range(t):
    text = str(input())
    cnt = 0
    score = 0
    for i in list(text):
        if i == "O":
            cnt += 1
            score += cnt
        else:
            cnt = 0
    print(score)
