# 자료형 : int(정수), float(실수), str(문자열), boolean(0(false),1(true))
# 형변환 : int(), float(), str()
# 사칙연산 : + - * / :: int
# if문 
# char => 'a', 'ㄱ' 'ㄴ', 'b'
# str => (char)(char)(char)(char)(char)


# int a => -2^31 ~ +2^31 2^31 * 2 => 2^32
# int 4byte

# a = int(input())
# 숫자로 제한을 두고
# a는 1~10까지의 어떤 수가 들어온다
# 1~3 A
# 4~6 B
# 7~10 C

# 대입연산자 = 
# a = 5
# b = 2

# 메모장
# ==, !=, >, <, >=, <= 비교연산자   :: boolean
# and(&&) or(||) not(!) 논리연산자  :: boolean
# 'a' + 'b'

# a == 5 a랑 5가 같냐?
# a != 5 a랑 5가 다르냐?
# a > 5 a가 5보다 크냐?
# a < 5 a가 5보다 작냐?

# a == 5 and(그리고) b != 3 :: (a랑 5가 같냐? 그리고 b랑 3이랑 다르냐?)
# a != 5    a랑 5가 다르냐?     :: false
# !(a == 5) a랑 5가 같지 않냐?  :: false
# !(a < 5 and b > 1 or c = 3)  무조건 반대가 됨
a = int(input())

if (a >= 1 and a <= 3): {  # a가 1보다 크거나 같고, 3보다 작거나 같다
    print('A')
}
else: {
    # false면 여기를 실행한다.
    print('C')
}

# 자료형
# 타입변경
# 조건문, 반복문 
# 자료형 -> 배열[]
# 함수
# 라이브러리
# => 언어의 기초

# 리스트
# 큐 스택
# 힙