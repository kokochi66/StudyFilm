def chessBoardCellColor(cell1, cell2):
        temp1 = list(cell1)
        temp2 = list(cell2)
        return (((ord(temp1[0])-ord('A')+1)%2)==(int(temp1[1])%2))==(((ord(temp2[0])-ord('A')+1)%2)==(int(temp2[1])%2))

print(chessBoardCellColor("A3","C1"))