def variableName(name):
    return name.isidentifier()

def variableName2(name):
    if name[0].isdigit() :return False
    for i in range(len(name)):
        if (name[i].isalnum() or name[i] == '_')==False: 
            return False
    return True

a = "vqqsd_5fq"
print(variableName2(a))
