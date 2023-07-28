# list = [] # list = []

# # 1
# # 29
# # 38
# # 1024
# # 11
# # 2
# # 999
# # 8
# # 89

# for i in range(0,9): # i = 2
#     list.append(int(input())) # list = [3, 3, 38]

# # 값 꺼내는거랑, 값 넣는거랑, 지우는게
# a = 1
# print(a)


# max = list[0]                    
# 맥스인덱스 = 0
# for h in range(0,len(list)):    # h = 3
#     if list[h] > max:           # false
#         max = list[h]           # max = 38  2
#         맥스인덱스 = h           # 맥 = 8

# print(max)
# print(맥스인덱스+1)

n = int(input())
for i in range(0,n): # i = 0
    for j in range(0,2*n):
        # print("["+str(i)+","+str(j)+"] ",end="")
        if j <= i or j >= (2*n) - (i+1) :
            print('*',end="")
        else:
            print(' ',end="")
    print()