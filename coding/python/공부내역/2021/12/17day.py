# list = input().split()
# list.append("abc")
# print(type(list))

# 배열
# 고정된 크기만 가진다 (확장성 딸림)
# 속도가 빠르다 index라고 하는데 번지수만 입력하면 바로 가져올수있다.

# 리스트
# 자유자재로 element(요소)를 늘렸다, 줄였다 할 수 있다. 무한대로 늘렸다 줄였다
# 공간 더 많이 먹음 배열보다 add, get

# 백준문제 14681번 사분면 고르기
# 1 2 3 4
# x y
# x ? y ? = 1
# x ? y ? = 2
# x ? y ? = 3
# x ? y ? = 4
# list = ["1","2","3","4","5"]

# String [Long Integer] Character Boolean [Double Float] 기본 자료형
# List ? 클래스 => 원래 이딴건 없다. 편의성을 위해서 만든거다. 객체

# x = int(input())
# y = int(input())

# x = int
# x > 0 = boolean
# y > 0 = boolean
# x > 0 and y > 0 = boolean > true false 
# int(x > 0 and y > 0) ? ?

# if x > 0 and y > 0: 
#     print(1)
# elif x > 0 and y < 0:
#     print(4)
# elif x < 0 and y > 0: 
#     print(2)
# elif x < 0 and y < 0: 
#     print(3)

# 10 10
# a b
# b - 45 < 0
# a - 1 + (24)
# b - 45 + 60
# a = 0?

a = "472"
b = "385"

# 문자열? String
# char 문자
# char[] 문자배열
# 문자배열 문자열
# char[] = String

res1 = int(a) * int(b[2])
res2 = int(a) * int(b[1])
res3 = int(a) * int(b[0])
res4 = int(a) * int(b)

print(res1)
print(res2)
print(res3)
print(res4)

# commit - push
# pull
# fetch - pull - commit - push