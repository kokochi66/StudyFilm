
# list = [1,2,3,4,5,6,7,8,9,10]
# max = list[0]    # 최댓값을 기록할 새로운 변수 할당
# min = list[1]    # 최솟값을 기록할 새로운 변수 할당
# for i in range(0, len(list)): # 6까지
#     if list[i] ? min: # i 0부터 예약명단의 길이까지 반복하는 숫자 => 0 ~ 5
#         min = ?
#     if list[i] ? max:
#         max = ?
# print(max+" "+min)


n = int(input())
list = input().split()
max = int(list[0])    # 최댓값을 기록할 새로운 변수 할당
min = int(list[0])    # 최솟값을 기록할 새로운 변수 할당
for i in range(0, len(list)): # 6까지
    if int(list[i]) < min: # i 0부터 예약명단의 길이까지 반복하는 숫자 => 0 ~ 5
        min = int(list[i])
    if int(list[i]) > max:
        max = int(list[i])
print(str(min)+" "+str(max
))