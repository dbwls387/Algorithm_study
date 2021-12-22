# 20540 연길이의 이상형

mbti = input()
mbti_list = list(mbti)

if mbti_list[0] == 'I':
    mbti_list[0] = 'E'
else:
    mbti_list[0] = 'I'

if mbti_list[1] == 'N':
    mbti_list[1] = 'S'
else:
    mbti_list[1] = 'N'

if mbti_list[2] == 'F':
    mbti_list[2] = 'T'
else:
    mbti_list[2] = 'F'

if mbti_list[3] == 'P':
    mbti_list[3] = 'J'
else:
    mbti_list[3] = 'P'

mbti=''.join(mbti_list)
print(mbti)