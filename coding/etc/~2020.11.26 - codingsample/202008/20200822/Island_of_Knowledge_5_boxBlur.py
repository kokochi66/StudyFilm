def boxBlur(image):
    output = [[0]*(len(image[0])-2) for i in range(len(image)-2)]
    for i in range(len(output)):
        for j in range(len(output[0])):
            output[i][j] = int(sum(image[i][q1]+image[i+1][q1]+image[i+2][q1] for q1 in range(j,j+3))/9)
    return output