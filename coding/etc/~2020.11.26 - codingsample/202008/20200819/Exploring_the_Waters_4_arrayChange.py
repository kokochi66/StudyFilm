def arrayChange(inputArray):
    num=0
    for i in range(1,len(inputArray)):
        if inputArray[i]<=inputArray[i-1]:
            num+=inputArray[i-1]-inputArray[i]+1
            inputArray[i]=inputArray[i-1]+1
    return sum(inputArray[i-1]-inputArray[i]+1 for i in range(1,len(inputArray)))