# 10431 줄세우기

p = int(input())  # 테스트 케이스 수
arr = [list(map(int, input().split())) for _ in range(p)]   #입력받을 리스트
height = [[] for _ in range(p)]     #키 순으로 정렬될 리스트
result = [[] for _ in range(p)]     #출력될 리스트 (테스트 케이스 번호 + 걸음 수)
cnt = 0  #걸음수

for i in range(p):
    cnt=0   #테스트 케이스마다 걸음 수 초기화
    height[i].append(arr[i][0]) #입력 받은 리스트의 테스트 케이스 번호 -> height에 저장하기
    height[i].append(arr[i][1]) #입력 받은 리스트의 첫 학생의 키 -> height에 저장하기
    for j in range(2, 21):  #arr의 for문/테스트 케이스 번호, 첫 학생은 비교 안해도 되므로 2부터 시작 ~ 20까지
        for k in range(1, len(height[i])):  #height의 for문/테스트 케이스 번호 제외, 1부터 ~ height리스트의 끝까지
            # 현재 넣으려는 학생을(arr) 정렬되어 있는 학생들(height)과 한명씩 비교하기
            if (arr[i][j] < height[i][k]): #본인보다 큰 학생을 발견하면
                height[i].insert(k, arr[i][j]) #그 자리에 세우기
                # height 전체 길이에서 현재 인덱스, 테스트 케이스를 빼주면 학생들이 움직인 걸음 수
                cnt += len(height[i]) - 1 - k
                break
            if k == len(height[i]) - 1: #만약 height 끝까지 돌았는데 자기보다 큰 학생이 없으면
                height[i].append(arr[i][j]) #height 리스트의 맨 뒤에 세우기
    result[i].append(arr[i][0]) #출력할 result에 테스트 케이스 번호 저장
    result[i].append(cnt)   #출력할 result에 걸음 수 저장

for i in range(p):
    print(result[i][0], result[i][1])
