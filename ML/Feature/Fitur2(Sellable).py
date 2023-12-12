import numpy as np
import csv
import math

filename = 'Dummy.csv'
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

TotalSellAsus    = 0
TotalSellAcer    = 0
TotalSellHp      = 0
TotalSellLenovo  = 0
TotalSellMacbook = 0
TotalSellAdvan   = 0
ListSell = []
for NAME,PRICE,SOLD,RATING in zip(name,price,sold,rating):
    if NAME =='asus':
        intsoldasus = int(SOLD)
        TotalSellAsus += intsoldasus
    if NAME =='acer':
        intsoldacer = int(SOLD)
        TotalSellAcer += intsoldacer
    if NAME =='hp' :
        intsoldhp = int(SOLD)
        TotalSellHp += intsoldhp
    if NAME == 'lenovo':
        intsoldlenovo = int(SOLD)
        TotalSellLenovo += intsoldlenovo
    if NAME =='macbook':
        intsoldmacbook = int(SOLD)
        TotalSellMacbook += intsoldmacbook
    if NAME == 'advan':
        intsoldadvan = int(SOLD)
        TotalSellAdvan += intsoldadvan
SellableProduct = max(TotalSellAsus, TotalSellAcer, TotalSellHp, TotalSellLenovo, TotalSellMacbook, TotalSellAdvan)

print('Total Penjualan Keseluruhan Laptop Asus       :',TotalSellAsus)
print('Total Penjualan Keseluruhan Laptop Acer       :',TotalSellAcer)
print('Total Penjualan Keseluruhan Laptop HP         :',TotalSellHp)
print('Total Penjualan Keseluruhan Laptop Lenovo     :',TotalSellLenovo)
print('Total Penjualan Keseluruhan Laptop Macbook    :',TotalSellMacbook)
print('Total Penjualan Keseluruhan Laptop Advan      :',TotalSellAdvan)
print('Rekomendasi Produk Dengan Penjualan Terbanyak :', SellableProduct)







