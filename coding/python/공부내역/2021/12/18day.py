# 반복문
# 리스트

# 공간을 왜 할당할까요?
# list = [1,2,3]
# insert append
# append 끝에 추가한다
# insert는 원하는 위치에 추가한다
# list.insert(0, 0)
# list = [0 1 2 3]    6
# print(list[2]) # 2
# list.remove(2)  # parameter, argument, 인자
# print(list[2]) # 3
# list[2] = 6
# 추가(append, insert), 수정(), 삭제(remove)

# int 2^32,      char,               float(소수 1.2)    boolean     초창기 자료형
# long 2^64,     String(char[]),     Double(큰소수)                 확장형 자료형

# if, for, while, switch 프로그래밍을 쉽게 하기 위해 만든 문법 값X 행동을 지칭
# +, - , /, *, %, =
# 조건문, 반복문

# int[], Long[], char[], String[], float[], Double[] Array      클래스
# int(list), Long(list)                                         클래스



# 반복문 1 2 3 4 5 6 7 8 9 10 ...
# list = [6,4,25,11,12]
# for i in list:
#     # i라는 변수를 만든다
#     # i를 range 왼쪽 수 부터 range 오른쪽 수 이전까지 반복한다.
#     print(a-5)
# 0 1 2 3 4 idx
# 1 2 3 4 5


# = list =>
# a = 1 (a == 1)
# list = type(for i ~~)

# print(list)
# i == 1
# list.insert(1,1)

# a = int(input())
# for i in range(1,a+1):
#     print(i*'*')


# boolean = True, False
# (2 < 1) = boolean

# if 1 < 2:
#     if False:
#         print(1)

# a = 1
# if not (False):
#     # boolean 
#     print(1)

# 대전제, 소전제

# a = int(input())

list = [
    [1,2,3],
    [4,5,6],
    [7,8,9]
]
for i in range(0,len(list)):
    # i는 1부터 a+1이 되기 전까지 반복한다.
    for j in range(0,len(list)):
        # j는 1부터 a+1이 되기 전까지 반복한다.
        if j >= len(list) - i -1:
            print(list[i][j])


# i = 1 j = 1
# i = 1 j = 2
# i = 1 j = 3
# i = 1 j = 4
# i = 1 j = 5

# i = 2 j = 1
# i = 2 j = 2
# i = 2 j = 3
# i = 2 j = 4
# i = 2 j = 5

# i = 3 j = 1
# i = 5 j = 5

# 기본자료형, 클래스, 포인터, if, for, while, switch 일주일