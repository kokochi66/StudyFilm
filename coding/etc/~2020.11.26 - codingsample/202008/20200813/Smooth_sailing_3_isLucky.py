def isLucky(n):
    a = str(n)
    return sum(int(i) for i in a)/2 == sum(int(j) for j in a[0:int(len(a)/2)])


a = 1230
print(isLucky(a))