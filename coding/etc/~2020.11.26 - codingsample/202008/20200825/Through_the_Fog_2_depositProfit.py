import math
def depositProfit(deposit, rate, threshold):
    return math.ceil(math.log(threshold/deposit)/math.log(1+(rate*0.01)))

print(depositProfit(100,20,170))