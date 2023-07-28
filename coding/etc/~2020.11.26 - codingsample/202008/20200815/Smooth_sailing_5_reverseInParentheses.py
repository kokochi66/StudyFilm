def reverseInParentheses(inputString):
    for i in range(len(inputString)):
        if inputString[i] == '(':
            left=i
        elif inputString[i] == ')':
            return reverseInParentheses(inputString[:left]+inputString[left+1:i][::-1]+inputString[i+1:])
    return inputString