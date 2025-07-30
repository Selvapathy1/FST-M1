import pandas as pd
from pandas import ExcelWriter
data = {
	'FirstName':["Satvik", "Avinash", "Lahri"],
	'LastName':["Shah", "Kati", "Rath"],
	'Email':["satshah@example.com", "avinashK@example.com", "lahri.rath@example.com"],
	'PhoneNumber':["4537829158", "4892184058", "4528727830"]
}

#convert the data into a DataFrame
df = pd.DataFrame(data)

#print dataframe
print(df)

#write to excel create exceloject
writer = ExcelWriter('./new_user_data.xlsx')
#write the data to excel file
df.to_excel(writer,sheet_name='Sheet1', index=False)
#save the excel file
writer.close()

#read the data from excel file(Activity 20)
input_data = pd.read_excel('./new_user_data.xlsx')
print("===================number of rows and columns====================")
# Display the number of rows and columns in the DataFrame
print(input_data.shape)
# print data of email column only
print("===================Email column====================")
print(input_data["Email"])
#sorted data using First Name column by asceding and print data
print(input_data.sort_values(by="FirstName"))
