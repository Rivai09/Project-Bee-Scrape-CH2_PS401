import numpy as np
import csv
import math
import pandas as pd
filename = 'Train_Tablet.csv'
reader = csv.reader(open(filename, "rt"), delimiter=",")
header = next(reader)
name =[]
price = []
sold = []
rating = []
for row in reader:
    name.append(row[0])
    price.append(row[1])
    sold.append(row[2])
    rating.append(row[3])

totalapple    = 0
totalsamsung    = 0
totaladvan     = 0
totalhuawei  = 0
TotalSell    = {'apple':0,
                'samsung':0,
                'advan':0,
                'huawei':0,}

for NAME,PRICE,SOLD,RATING in zip(name,price,sold,rating):
    if NAME =='apple':
        intsoldapple = int(SOLD)
        totalapple += intsoldapple
        TotalSell['apple']= totalapple
    if NAME =='samsung':
        intsoldsamsung = int(SOLD)
        totalsamsung += intsoldsamsung
        TotalSell['samsung']= totalsamsung
    if NAME == 'huawei':
        intsoldhuawei = int(SOLD)
        totalhuawei += intsoldhuawei
        TotalSell['huawei']= totalhuawei
    if NAME == 'advan':
        intsoldadvan = int(SOLD)
        totaladvan += intsoldadvan
        TotalSell['advan']= totaladvan


print(TotalSell)
newname = []
totalprice = []

for key, value in TotalSell.items() :
    print (key, value)
    newname.append(key)
    totalprice.append(value)
df = pd.DataFrame(newname,columns=["Nama"])
df["Total"] = totalprice
df.to_csv('Total handhone.csv',index=False)
print("data berhasil disimpan")





