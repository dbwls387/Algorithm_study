# 14625 냉동식품

h1, m1 = map(int, input().split())
h2, m2 = map(int, input().split())
n = int(input())
cnt = 0
h_current = h1
m_current = m1
while True:
    # if str(n) in str(h_current) or str(n) in str(m_current):
    if h_current % 10 == n or h_current // 10 == n or m_current % 10 == n or m_current // 10 == n:
        cnt += 1
    if h2 == h_current and m2 == m_current:
        break
    m_current += 1
    if m_current == 60:
        h_current += 1
        m_current = 0

print(cnt)
