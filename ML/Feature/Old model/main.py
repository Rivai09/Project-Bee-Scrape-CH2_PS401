import tensorflow as tf
import  numpy as np
TFLITE_FILE_PATH = './model.tflite'
interpreter = tf.lite.Interpreter(TFLITE_FILE_PATH)
input_details = interpreter.get_input_details()
output_details = interpreter.get_output_details()
interpreter.allocate_tensors()
features =[12]
np_features = np.array(features, dtype=np.float32)
np_features = np.expand_dims(np_features, axis=0)
interpreter.set_tensor(input_details[0]['index'], np_features)
interpreter.invoke()
output_data = interpreter.get_tensor(output_details[0]['index'])
bulat = output_data[0][0]
hasil_prediksi = int(bulat * 100)
print('hasil prediksi :' ,hasil_prediksi)

