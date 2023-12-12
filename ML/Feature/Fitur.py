import numpy as np
import csv
import math

filename = 'Dataset.csv'
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

totalasus    = 0
totalacer    = 0
totalhp      = 0
totallenovo  = 0
totalmacbook = 0
totaladvan   = 0
TotalSell    = {'Asus':0,
                'Acer':0,
                'HP':0,
                'Lenovo':0,
                'Macbook':0,
                'Advan':0}

for NAME,PRICE,SOLD,RATING in zip(name,price,sold,rating):
    if NAME =='asus':
        intsoldasus = int(SOLD)
        totalasus += intsoldasus
        TotalSell['Asus']= totalasus
    if NAME =='acer':
        intsoldacer = int(SOLD)
        totalacer += intsoldacer
        TotalSell['Acer']= totalacer
    if NAME =='hp' :
        intsoldhp = int(SOLD)
        totalhp += intsoldhp
        TotalSell['HP']= totalhp
    if NAME == 'lenovo':
        intsoldlenovo = int(SOLD)
        totallenovo += intsoldlenovo
        TotalSell['Lenovo']= totallenovo
    if NAME =='macbook':
        intsoldmacbook = int(SOLD)
        totalmacbook += intsoldmacbook
        TotalSell['Macbook']= totalmacbook
    if NAME == 'advan':
        intsoldadvan = int(SOLD)
        totaladvan += intsoldadvan
        TotalSell['Advan']= totaladvan

sellable = max(zip(TotalSell.values(), TotalSell.keys()))[1]
sellablevalues = max(zip(TotalSell.values(), TotalSell.keys()))[0]

print('Total Penjualan Keseluruhan Laptop Asus       :',TotalSell['Asus'])
print('Total Penjualan Keseluruhan Laptop Acer       :',TotalSell['Acer'])
print('Total Penjualan Keseluruhan Laptop HP         :',TotalSell['HP'])
print('Total Penjualan Keseluruhan Laptop Lenovo     :',TotalSell['Lenovo'])
print('Total Penjualan Keseluruhan Laptop Macbook    :',TotalSell['Macbook'])
print('Total Penjualan Keseluruhan Laptop Advan      :',TotalSell['Advan'])
print('Rekomendasi Produk Dengan Penjualan Terbanyak :',sellable,'Dengan jumlah terjual :',sellablevalues)







