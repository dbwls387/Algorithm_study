# 1992 쿼드트리

def division(start_row, start_col, size):
    if size == 1:   # 가장 작은 단위일 때
        print(arr[start_row][start_col], end="")
        return
    num = arr[start_row][start_col]

    for row in range(start_row, start_row + size):
        for col in range(start_col, start_col + size):
            if num != arr[row][col]:
                print("(", end="")
                size //= 2
                division(start_row, start_col, size)
                division(start_row, start_col + size, size)
                division(start_row + size, start_col, size)
                division(start_row + size, start_col + size, size)
                print(")", end="")
                return

    print(arr[start_row][start_col], end="")
    return


n = int(input())
arr = []
for _ in range(n):
    arr.append(list(map(int, list(input().rstrip()))))

division(0, 0, n)
