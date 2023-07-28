def arrayReplace(inputArray, elemToReplace, substitutionElem):
    for i in range(len(inputArray)):
        if inputArray[i]==elemToReplace: inputArray[i] = substitutionElem
    return inputArray

def arrayReplace2(inputArray, elemToReplace, substitutionElem):
    return [i if i!=elemToReplace else substitutionElem for i in inputArray]

a = [1,2,1]
a = arrayReplace2(a,1,3)
print(a)