def palindromeRearranging(inputString):
    return sum(inputString.count(i)%2 for i in set(inputString)) <=1

def palindromeRearranging(inputString):
    alfa = [0]*127
    booltrue = False
    for i in inputString:
        alfa[ord(i)]+=1
    for i in alfa:
        if i%2==1:
            if booltrue: return False
            booltrue = True
    return True
# ASCII를 이용한 풀이.

a = "aabbbggg"
print(palindromeRearranging(a))