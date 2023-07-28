def evenDigitsOnly(n):
    while(n!=0):
        temp = int(n % 10)
        if temp % 2 != 0 : return False
        n = int(n/10)
    return True

def evenDigitsOnly2(n):
    temp = str(n)
    for i in temp:
        if int(i) % 2 != 0: return False
    return True
    
def evenDigitsOnly(n):
    return all([int(i)%2==0 for i in str(n)])

a = 248622
b = 642386
print(evenDigitsOnly2(a))
print(evenDigitsOnly2(b))