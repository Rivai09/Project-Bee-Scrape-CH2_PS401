import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from tensorflow import keras
from keras import Sequential
from keras.layers import Dense
import  csv

filename = 'Dataset.csv'
reader = csv.reader(open(filename, "rt"), delimiter=",")
header = next(reader)
sold = []
price = []
for row in reader:
    price.append(row[1])
    sold.append(row[2])
price = np.array(price, dtype=float)
sold = np.array(sold, dtype=float)
PRICE = price / 1000000
SOLD = sold / 100
print(PRICE)

def predictionmodel(X,Y):
    X_train = X
    Y_train = Y

    # Membangun model
    model = Sequential([Dense(units=8,input_shape=[1]),
                        Dense(4),
                        Dense(2),
                        # keras.layers.Dropout(0.2),
                        Dense(1)])

    # Kompilasi model
    model.compile(optimizer=keras.optimizers.SGD(learning_rate=1e-4), loss='mean_squared_error')

    # Melatih model
    model.fit(X_train, Y_train, epochs=1000)
    return model

model = predictionmodel(PRICE,SOLD)
inputan = int(input('Masukkan Harga(Juta) : '))
new_x = inputan
prediction = model.predict([new_x])[0][0]
print('Prediksi Jumlah Terjual :',prediction)
