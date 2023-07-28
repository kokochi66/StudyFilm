def avoidObstacles(inputArray):
    for i in range(1,1002):
        for j in range(len(inputArray)):
            if inputArray[j]%i==0: break
            elif inputArray[j]%i!=0 and j==len(inputArray)-1: return i
    return 1
# 나의 답안

def avoidObstacles2(inputArray):
    c = 2
    while True:
        if sorted([i%c for i in inputArray])[0]>0:
            return c
        c += 1
# 모범 답안1
# 배열의 각 값을 mod c 했을때, 해당 배열의 최솟값이 0보다 크다면
# mod c == 0 인값이 없으므로 해당값은 c가 됨.
# 다만 sorted자체가 배열이 커지면 연산을 크게잡아먹어서 효율적인지는 의문.

def avoidObstacles3(inputArray):
    i=2
    while True:
        if all(x%i!=0 for x in inputArray):
            return i
        i=i+1
# 모범 답안2
# 내 답안과 사실 다를게 크게 없지만 all을 넣음으로 간결하게 한건데
# break가 안들어가서 모든 i값에 배열을 다 돌아야되서 역시나 더 효율적인지는 의문


a = [5,3,6,7,9]
print(sorted([i%4 for i in a]))
