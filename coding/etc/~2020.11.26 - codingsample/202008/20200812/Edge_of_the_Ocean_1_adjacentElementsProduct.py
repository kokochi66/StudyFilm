def adjacentElementsProduct(inputArray):
    return max([inputArray[i] * inputArray[i+1] for i in range(len(inputArray)-1)])

def adjacentElementsProduct2(inputArray):
    return max(a * b for a, b in zip(inputArray[:-1], inputArray[1:]))

print(adjacentElementsProduct([2,5,6]))