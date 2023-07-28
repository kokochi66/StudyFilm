def makeArrayConsecutive2(statues):
    max = statues[0]
    min = statues[0]
    for i in statues:
        if max < i : max = i
        if min > i : min = i
    return max-min-len(statues)+1

a = [6,2,3,8]
print(makeArrayConsecutive2(a))