def alternatingSums(a):
    return [sum(a[::2]),sum(a[1::2])]

a = [50, 60, 60, 45, 70]
print(alternatingSums(a))