import tensorflow as tf
from keras.models import load_model

model = load_model("model.h5")

converter = tf.lite.TFLiteConverter.from_keras_model(model)

converter.optimizations = [tf.lite.Optimize.DEFAULT]

final_model = converter.convert()

with open("model2.tflite", "wb") as f:
    f.write(final_model)

# code by ProgrammingHut on YouTube
# link : https://www.youtube.com/watch?v=gVJC1j2n9tE