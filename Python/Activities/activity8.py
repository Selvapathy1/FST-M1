numlist = [10, 30, 50, 40, 13]
print("first and last elements are the same")
if numlist [0] == numlist[-1]:
    print ("True")
else:
    print ("false")

#user input to find the first and last elements
numlist = input("enter a list of numbers separated by commas: ").split(',')
# Convert input strings to integers
numlist = [int(num) for num in numlist]
print("first and last elements are the same")
if numlist[0] == numlist[-1]:
    print("True")
else:
    print("false")