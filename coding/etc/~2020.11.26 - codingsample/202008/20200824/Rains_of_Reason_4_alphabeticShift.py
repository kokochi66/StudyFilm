def alphabeticShift(inputString):
    temp = list(inputString)
    for i in range(len(temp)):
        if temp[i] == 'z': temp[i]='a'
        else: temp[i] = chr(ord(temp[i])+1)
    inputString = "".join(temp)
    return inputString

inputs = "crazy"
print(alphabeticShift(inputs))