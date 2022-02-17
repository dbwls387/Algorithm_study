# 2630 색종이 만들기

def division(start_row, start_col, size):
    global white_cnt
    global blue_cnt

    flag = 1
    color = arr[start_row][start_col]

    for row in range(start_row, start_row + size):
        for col in range(start_col, start_col + size):
            if color != arr[row][col]:
                flag = 0
                break

        if not flag:
            break

    if flag:
        if color == 0:
            white_cnt += 1

        else:
            blue_cnt += 1
    else:
        size //= 2
        division(start_row, start_col, size)
        division(start_row + size, start_col, size)
        division(start_row, start_col + size, size)
        division(start_row + size, start_col + size, size)


n = int(input())
arr = [list(map(int, input().split())) for _ in range(n)]

white_cnt = 0
blue_cnt = 0

division(0, 0, n)

print(white_cnt)
print(blue_cnt)
