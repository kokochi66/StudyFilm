# int str boolean

# 1~3 이면 A
# 4~6 이면 B
# 7~10 아면 C

# if (a>=1 and a<=3):
#     print('A')
#     # // a가 1보다크고 3보다 작으면 A를 실행한다.
# else: # 아니면
#     if a>=4 and a<=6:
#         print('B')
#         # // a가 4보다크고 6보다 작으면 B를 실행한다.
#     else:
#         if a>=7 and a<=10:
#             print('C')
#         # // a가 4보다크고 6보다 작으면 B를 실행한다.
#         # // 아니면 C를 실행한다.
#     # 여기까지 실행한다.

# 1 <= a <= 3 :: A
# 4 <= a <= 6 :: B
# 7 <= a <= 10 :: C
# b >= 5 F
# b == 1 G
# a와는 관계없이, b>=5 F / b== 1 G
# b == 3이고, c <= 2, a >= 1 Z

# a = 11
# b = 4

# if (b>=5):
#     print('F')
# elif (b==1): # 위의 조건이 모두 아니면
#     print('G')
# elif (a>=1 and a<=3):
#     print('A')
#     # // a가 1보다크고 3보다 작으면 A를 실행한다.
# elif (a>= 4 and a<=6): # a가 4보다 크고, 6보다 작으면
#     print('B')
# elif (a>=7 and a<=10):
#     print('C')
#     # 여기까지 실행한다.
# else:
#     print('해당하지않음')


# if (b>=5):
#     print('F')
# elif (b==1): # 위의 조건이 모두 아니면
#     print('G')
#     elif (b==3 and c<=2 and a>=1):
#     print('Z')
# elif (a>=1 and a<=3):
#     print('A')
#     # // a가 1보다크고 3보다 작으면 A를 실행한다.
# elif (a>= 4 and a<=6): # a가 4보다 크고, 6보다 작으면
#     print('B')
# elif (a>=7 and a<=10):
#     print('C')
#     # 여기까지 실행한다.
# else:
#     print('해당하지않음')


# a=3
# b=3
# c=2
# if (b>=5):
#     print('F')
# elif (b==1): # 위의 조건이 모두 아니면
#     print('G')
# elif (b==3 and c<=2 and a>=1):
#     print('Z')
# elif (a>=1 and a<=3):
#     print('A')
#     # // a가 1보다크고 3보다 작으면 A를 실행한다.
# elif (a>= 4 and a<=6): # a가 4보다 크고, 6보다 작으면
#     print('B')
# elif (a>=7 and a<=10):
#     print('C')
#     # 여기까지 실행한다.
# else:
#     print('해당하지않음')
#     # b == 3이고, c <= 2, a >= 1 Z

# arr = list(map(int,input().split()))
# # int str boolean
# # int 100개 arr[0] arr[1] arr[2] arr[3]
# # input() => 리턴값(반환값) str 배열
# a = arr[0]
# b = arr[1]

# if a > b:
#     print('>')
# elif a < b:
#     print('<')
# elif a == b:
#     print('==')


# if만 메인, elif, else는 쓰고싶은대로

arr = list(map(int,input().split()))
# 3 3 6
a = arr[0] # 3
b = arr[1] # 3
c = arr[2] # 6

# a == b and b == c
sum = 0
if a == b and b == c:
    sum = 10000 + a * 1000
elif a == b:
    sum = 1000 + a * 100
elif a == c:
    sum = 1000 + a * 100
elif b == c:
    sum = 1000 + b * 100
else:
    # a, b, c
    if a > b and a > c:
        sum = a * 100
        # a
    elif b > c:
        sum = b * 100
    else:
        sum = c * 100
print(sum)

