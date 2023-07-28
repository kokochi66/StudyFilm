# 예약명단 = ['홍용택', '김재원', '김희대', '정의환', '홍용택', '아무개', '홍용택', '김재원' , '홍용택'] # 예약정보
# 손님 = input() # String 문자열 - 기본자료형

# 홍용택개수 = 0
# check = 0
# for i in range(0, len(예약명단)):   # i = 1
#     # print('반복중입니다 ' + str(i))
#     if 예약명단[i] == 손님:         # 아무개 = 간디
#         # print(손님+'손님은 '+str(i+1)+'번째 순서입니다.')
#         check = 1
#         break # check 1
#     if 예약명단[i] == '홍용택':
#         홍용택개수 += 1
#         if 홍용택개수 == 2:
#             print('두번째 홍용택은 :: ' + str(i) +"번째 입니다.")


# if check == 1:
#     print('예약되지 않은 손님입니다.')


# list = [10,9,8,7,6,5,4,3,2,1] # 최적화 문제
# max = list[0] # 초기값 설정
# for i in range(1,len(list)):
#     if list[i] > max:       
#         max = list[i]       
#         print(str(max)+'는 현재 최댓값입니다 :: ' + str(i))
# print(max)
# # 최댓값은 몇번째냐


# class 홍용택:
#     나이 = 26
#     class 대학교:
#         학과 = '일본학과'
# # 객체 - 클래스

# # list - 클래스

# print(홍용택.대학교.학과)

T = int(input())
list = []
for i in range(0,T):
    list = input().split()
    print(int(list[0])+int(list[1]))