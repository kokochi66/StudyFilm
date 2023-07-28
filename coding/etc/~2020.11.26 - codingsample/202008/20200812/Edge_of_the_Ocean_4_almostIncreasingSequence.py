def almostIncreasingSequence(s):
    return 3> sum((i >= j) + (i >= k) for i, j, k in zip(s, s[1:], s[2:] + [10**6]))
#sum함수 내부에서 for문을 돌리는 형식의 경우, bool값으로 true는 1, false는 0임을 이용하여 3미만일 경우 True, 3이상일 경우 false를 반환하게 하는 형태
# 추가적으로 해석하자면, 배열의 첫번째, 두번째, 세번째+ 10의6제곱씩 배열을 돌리면서
# 배열의 앞부분이 뒷부분보다 크거나 같을시, 에러 +1, 또한 앞부분의 원소가 뒤뒤의 원소+10의 6제곱보다 크거나 같을 시 에러가 발생하는 형태인데, 
# for를 zip으로 배열을 돌리면 123->234 형태로 배열을 반복하는데 저런 형태를 취해주면,
# k에서 배열이 끝나도, 한번 더 돈다. 마지막에 +10**6이 더해진 형태로. 다만 이런 형태는 특정 조건에서 에러를 발생시킬 수 있을듯
# 아무튼 천재가 만든듯
def almostIncreasingSequence2(sequence):
    droppped = False
    last = prev = min(sequence) - 1
    for elm in sequence:
        if elm <= last:
            if droppped:
                return False
            else:
                droppped = True
            if elm <= prev:
                prev = last
            elif elm >= prev:
                prev = last = elm
        else:
            prev, last = last, elm
    return True
#일반적인 형태로, 특정 조건 만족시 True, 불만족시 False를 반환하는 형태

a = [3,6,5,8,10,20,15]
print(almostIncreasingSequence(a))