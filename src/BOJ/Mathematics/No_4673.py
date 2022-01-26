# 4673 셀프 넘버

def d(n):
    n += sum(map(int, str(n)))
    return n


notSelfNum = set()

for i in range(1, 10001):
    notSelfNum.add(d(i))

for i in range(1, 10001):
    if i not in notSelfNum:
        print(i)
