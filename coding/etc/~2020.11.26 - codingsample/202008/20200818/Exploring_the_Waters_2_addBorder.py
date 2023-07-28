def addBorder(picture):
    l=len(picture[0])+2
    return ["*"*l]+[x.center(l,"*") for x in picture]+["*"*l]

picture = [
    "abc",
    "def"
]
var = "abc"
print(var.center(6,"*"))
print(addBorder(picture))
# center함수 => int만큼 string을 양끝에 채워주는 함수인듯