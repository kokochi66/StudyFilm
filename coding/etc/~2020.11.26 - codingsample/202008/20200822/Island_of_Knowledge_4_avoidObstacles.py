def avoidObstacles(inputArray):
    for i in range(1,1002):
        for j in range(len(inputArray)):
            if inputArray[j]%i==0: break
            elif inputArray[j]%i!=0 and j==len(inputArray)-1: return i
    return 1