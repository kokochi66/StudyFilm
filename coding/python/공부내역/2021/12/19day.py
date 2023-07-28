# 실리적인것처럼 보이는? 무언가를 만드는
# 줄 서서 기다리는 대기표를 출력해주는 
# 기본자료형, if(조건문), for(반복문) // 배열(Array) - 파이썬에서는 없음
# List(클래스)

# input() = D
# 예약서비스
# list = ['A', 'B', 'C', 'D']
# 'D손님은 4번째 순서입니다.'
# 예약하지 않은 손님이 오면, '예약되지 않은 손님입니다.'

# 0번째 1번째손님

# 예약명단 = ['홍용택', '김재원', '김희대', '정의환', '윤민혁', '아무개'] # 예약정보
# 손님 = input() # String 문자열 - 기본자료형

# print(예약명단)
# print('손님 = ' + 손님) # 단위 테스트

# 1. '예약명단'에 있는 값을 하나씩 꺼내서 '손님' 이라는 값과 일치하는지 확인합니다.
# 2-1. 일치하면 해당 손님이 몇번째 순서인지를 출력합니다.
# 2-2. 일치하지 않으면 '예약되지 않은 손님입니다' 를 출력합니다.


# 'D손님은 4번째 순서입니다.'

check = False    # 예약명단에 들어있는지 아닌지가 적혀있는 변수 값 FLAG값
for i in range(0, len(예약명단)): # 6까지
    print('반복중입니다 ' + str(i))
    if 예약명단[i] == 손님: # i 0부터 예약명단의 길이까지 반복하는 숫자 => 0 ~ 5
        print(손님+'손님은 '+str(i+1)+'번째 순서입니다.')
        check = True
        break # 내가 반복하고있는 부분을 찾아서 나가게합니다.
    # elif i == len(예약명단)-1:
    #     print('예약되지 않은 손님입니다.')


# 리스트 100만개라면
if not check:
    print('예약되지 않은 손님입니다.')


# check = False
# if 예약명단[0] == 손님:
#     print(손님+'손님은 '+str(1)+'번째 순서입니다.')
#     check = True
# if 예약명단[1] == 손님:
#     print(손님+'손님은 '+str(2)+'번째 순서입니다.')
#     check = True
# if 예약명단[2] == 손님:
#     print(손님+'손님은 '+str(3)+'번째 순서입니다.')
#     check = True
# if 예약명단[3] == 손님:
#     print(손님+'손님은 '+str(4)+'번째 순서입니다.')
#     check = True
# if 예약명단[4] == 손님:
#     print(손님+'손님은 '+str(5)+'번째 순서입니다.')
#     check = True

# if not check:
#     print('예약되지 않은 손님입니다.')
# 유지보수가 안된다


# list = [8,7,56,1,3,25] # 1 3 7 8 25 56
# list.sort()
# print(list)

# list[i] = 56
# list[j] = 7

# temp = 56
# 

# print(list)
# for i in range(0,len(list)):
#     for j in range(0, len(list)):
#         if(list[i] < list[j]):
#             temp = list[i]
#             list[i] = list[j]
#             list[j] = temp
# # # 정렬 알고리즘
# # # 버블 정렬
# # print(list)

# n = int(input()) # 5


# 5
# 1 1
# 12 34
# 5 500
# 40 60
# 1000 1000
# list = [] # type int append() list
# print(type(list))
# for i in range(0,n):
#     list.append(input())
#     # print(i)
# print(list)

# import sys
# t= int(sys.stdin.readline()) 
# for i in range(0,t):
#     list=input().split()
#     a = int(list[0])
#     b = int(list[1])
#     print(a+b)

# 월-화-수 지금까지 배운거 복습 차원 
# 목요일 ~
# Object 구현을 통해서 위에껄 복잡하게 더 들어가 구현해보자
