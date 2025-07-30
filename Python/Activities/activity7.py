#numlist =[5, 50, 28, 12, 45, 60, 19]  # default input
#user input
numlist = list(input("Enter numebr separated by comma: ",).split(','))
#calculate the sum of all numbers in the list
#Method 1
#total = sum(numlist)
#print("the sum of list is :" , total)

#Method 2 to calculate the sum
sum=0 # intizialise the sum equal to 0
for num in numlist: # use for loop assign temp variable num to iterate in numlist
    sum += int(num) # convert each element to int and add to sum
print("the sum of the list ", sum)
