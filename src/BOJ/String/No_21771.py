# 21771 가희야 거기서 자는 거 아니야

room_r, room_c = map(int, input().split())
gahee_r, gahee_c, pillow_r, pillow_c = map(int, input().split())
room = []

for i in range(room_r):
    room.append(input())

cnt = 0
for i in range(room_r):
    if 'P' in str(room[i]):
        for j in room[i]:
            if j == 'P':
                cnt += 1

if cnt != (pillow_c * pillow_r):
    print(1)
else:
    print(0)
