def sortByHeight(a):
    b = [0]*len(a)
    bNum=0
    for i in range(len(a)):
        if a[i]!=-1:
            b[bNum]=a[i]
            bNum+=1
    b.sort()
    print(b)
    bNum=len(b)-bNum
    for i in range(len(a)):
        if a[i]!=-1:
            a[i]=b[bNum]
            bNum+=1
    return a
# 나의 답안

def sortByHeight2(a):

    l = sorted([i for i in a if i > 0])
    for n,i in enumerate(a):
        if i == -1:
            l.insert(n,i)
    return l
# 모범답안
# 1) sorted함수에 조건을 넣음으로 내가 했던 별도의 -1만 제외한 리스트를 만든다는 발상을 다르게 구현
# 2) enumerate는 튜블, 리스트 등에서 인덱스값과 객체를 열거한다.
# 3) 해당 a에서의 -1위치에 -1을 그대로insert해주는것으로 답안제출

a = [-1, 150, 190, 170, -1, -1, 160, 180]
sortByHeight2(a)
print(a)