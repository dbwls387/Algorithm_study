# 1003 피보나치 함수

t = int(input())
n = []
for i in range(t):
    n.append(int(input()))
arr = [[1, 0], [0, 1]]

for i in range(2, 41):  # n=0, 1일 경우는 위에서 넣었기 때문에 i=2부터 시작
    arr.append([arr[i - 2][0] + arr[i - 1][0], arr[i - 2][1] + arr[i - 1][1]])

for i in range(t):
    print(arr[n[i]][0], arr[n[i]][1])
