#user input model to generate multiplication table
number = int(input("Input a number: "))

# use for loop to iterate 10 times
for i in range(1,16):
   print(number, ' x ', i, ' = ', number*i)