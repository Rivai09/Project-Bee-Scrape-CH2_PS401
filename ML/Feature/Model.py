import numpy as np
from tensorflow import keras
from keras import Sequential
from keras.layers import Dense
import  csv

#Preprocessing Data
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

#Split Data
train_ratio = 0.8
Y_TRAIN_SIZE =int(len(SOLD) * train_ratio)
X_TRAIN_SIZE =int(len(PRICE) * train_ratio)
xtrain_data = PRICE[:X_TRAIN_SIZE]
xtest_data = PRICE[X_TRAIN_SIZE:]
ytrain_data =SOLD[:Y_TRAIN_SIZE]
ytest_data =SOLD[Y_TRAIN_SIZE:]
X_train = [item for item in xtrain_data]
X_test = [item for item in xtest_data]
y_train = [item for item in ytrain_data]
y_test = [item for item in ytest_data]



#Train Data to make a prediction about total sold based on price
def predictionmodel(X,Y,XTest,YTest):
    X_train = X
    Y_train = Y
    ytest = YTest
    xtest = XTest

    # build model
    model = Sequential([Dense(10,input_shape=[1],input_dim=1),
                        Dense(10),
                        Dense(1)])

    # compile the model
    model.compile(optimizer=keras.optimizers.SGD(learning_rate=1e-4), loss='mean_squared_error')

    # train the model
    model.fit(X_train, Y_train, epochs=100,validation_data=(xtest,ytest))
    return model



model = predictionmodel(X_train,y_train,X_test,y_test)
inpt = int(input('Masukkan Harga Untuk Prediksi jumlah yang akan terjual(jt) : '))
new_x = inpt
prediction = model.predict([new_x])[0][0]
print('Prediksi Jumlah Rata-Rata yang akan Terjual :',int(prediction * 100),'unit' )
