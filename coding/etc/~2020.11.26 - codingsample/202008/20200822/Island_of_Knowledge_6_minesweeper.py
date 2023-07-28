def minesweeper(matrix):
    output = [[0]*len(matrix[0]) for i in range(len(matrix))]
    for i in range(len(matrix)):
        for j in range(len(matrix[0])):
            if matrix[i][j]:
                for k in range(i-1,i+2):
                    for l in range(j-1,j+2):
                        if k>=0 and k<=len(output)-1 and l>=0 and l<=len(output[0])-1:
                            if k==i and l==j: output[k][l]+=0
                            else: output[k][l]+=1
    return output
