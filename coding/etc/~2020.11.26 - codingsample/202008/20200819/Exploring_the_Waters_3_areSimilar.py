def areSimilar(a, b):
    errpoint = -1
    if len(a)!=len(b): return False
    for i in range(len(a)):
        if a[i]!=b[i]:
            if errpoint != -1:
                if errpoint == -2: return False
                else:
                    if a[errpoint]!=b[i] or a[i]!=b[errpoint]: return False
                    else: errpoint=-2
            else: errpoint = i
    if errpoint>-1: return False
    return True
# 나의 답안

from collections import Counter as C
def areSimilar2(A, B):
    return C(A) == C(B) and sum(a != b for a, b in zip(A, B)) < 3
# 모범 답안1
# => 카운터 as C에서 카운터 C는 해당 배열의 원소의 개수를 세주는 함수인듯.
# 두 배열이 비슷하기 위해서는 먼저 배열의 원소의 개수가 서로 일치해야하고, 각 원소에서 서로 다른값을 지니는 경우가 2가지가 넘어가지 않아야함.

def areSimilar3(A, B):
    return sorted(A)==sorted(B) and sum([a!=b for a,b in zip(A,B)])<=2
# 모범 답안2
# 간단한 모범답안. 두 배열을 정렬한 값이 일치해야하며, 서로 다른 값을 지니는 경우가 2가지가 넘어가지 않아야함.

def areSimilar4(A, B):
    r = []
    for i in range(len(A)):
        if A[i] != B[i]:
            r.append([A[i],B[i]])
    if len(r) == 0 or len(r) == 2 and r[0]==r[1][::-1]:
        return True
    return False
# 모범 답안3
# 배열 자체를 생성해서, 서로 일치하지 않는 값들을 배열에 담고, 배열에 값이 없거나, 배열 값이 딱 2개이며 해당값들이 서로 뒤집어져 일치하면 True 아니면 False가됨.

a = [1,2,3]
b = [3,2,3]
# print(areSimilar2(a,b))
