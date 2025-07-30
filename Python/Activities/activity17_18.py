import pandas as pd

data = {
  "Usernames": ["admin", "Charles", "Deku"],
  "Passwords": ["password", "Charl13", "AllMight"]
}
# convert the data into a DataFrame
df = pd.DataFrame(data)
# write the data to csv file (Activity 17)
df.to_csv("./user_data.csv", index=False)


#reading data from CSV file (Activity 18)
input_data = pd.read_csv("./user_data.csv")
print("===================username====================")
# Display the DataFrame sorted by Usernames and print data
print(input_data["Usernames"])
print("===================username and password of the second row====================")
#print the username and password of the second row and print data
print(input_data["Usernames"][1], input_data["Passwords"][1])
print("===================sorted data using username by ascending====================")
#sorted data using username column by asceding and print data
print(input_data.sort_values(by="Usernames"))
print("===================sorted data using password by descending====================")
#sorted data using password by descending and print data
print(input_data.sort_values(by="Passwords", ascending=False))