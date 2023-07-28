def allLongestStrings(inputArray):
    p = max(len(s) for s in inputArray)
    arr = [r for r in inputArray if len(r)==p]
    return arr
# 나의 답안

def allLongestStrings2(inputArray):
    return [i for i in inputArray if len(i) == len(max(inputArray, key=len))]
# 모범답안
# 체크해야할 부분
# max(inputArray, key=len) 문은 문자열 배열에서 가장 길이가 긴 값을 찾을 수 있음.
# 이를 이용하여 반복문을 돌아서 max값을 찾기보다 한번에 유도하면 더욱 쉽게 유도가 가능

