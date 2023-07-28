def isIPv4Address(inputString):
    l = inputString.split(".")
    if len(l)!=4: return False
    for i in l:
        if i.isdigit()==False:
            return False 
        else:
            temp = int(i)
            if temp>255:
                return False
            elif i != str(temp):
                return False
    return True

def isIPv4Address2(s):
    p = s.split('.')

    return len(p) == 4 and all(n.isdigit() and 0 <= int(n) < 256 for n in p)
# all을 통해서 두 경우의 수 모두에 해당하는 값을 찾을 수 있음.

import ipaddress
def isIPv4Address3(inputString):
    try:
        ipaddress.ip_address(inputString)        
    except:
        return False
    return True
# 위와같은 방법으로 ipaddress자체적으로 검증이 가능함.