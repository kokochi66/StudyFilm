def commonCharacterCount(s1, s2):
    return sum(min(s1.count(x), s2.count(x)) for x in set(s1))

def commonCharacterCount2(s1, s2):
    count = 0
    commons = set(s1) & set(s2)
    for i in commons:
        count += min(s1.count(i), s2.count(i))
    return count

# 집합을 이용한 중복값의 제거
# 일반적 답안인 2번은 count변수를 이용하고,
# commons에서 교집합을 이용한다.
# 교집합에 count 함수를 이용하여, s1에서 해당 교집합의 원소값, s2에서 해당 교집합의 원소값을 세며
# min을 통해 두 원소값에서 최솟값을 뽑아냄(같은 원소의 경우 최소값이 총 개수에 해당하기 때문)
# 그리고 해당 교집합을 반복하여, count에 추가하여 반환하면 됨.

# 천재의 답안인 1번은 
# 해당 최솟값에 sum함수를 추가하여 변수의 존재가 필요없게됨