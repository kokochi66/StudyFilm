# 함수
# 클래스 -> 함수

def 한수구하기(a):
    if len(a) <= 2: 
        return True  
    # 예외처리
    min = int(a[0]) - int(a[1])
    # 첫번째 애랑 두번째 애의 차이

    for i in range(0,len(a)-1):
        if int(a[i]) - int(a[i+1]) != min: 
            return False
    return True
# # 함수는 책임을 갖고있다.

    
cnt = 0
a = input()
pa = int(a)
for i in range(1, pa+1): # 1 ~ a
    if 한수구하기(str(i)): 
        cnt += 1


print(cnt)


z = 3
if z < 3:
    print('a') # 실행범위
elif z == 3:
    print('b')