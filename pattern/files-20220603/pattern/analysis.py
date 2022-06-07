import pandas as pd
import numpy
from sklearn import linear_model
numpy.set_printoptions(threshold=numpy.inf)


df = pd.read_csv('./trainData.csv', header = None)
arr = df.values
X_train = arr[:,:-1]
y_train = arr[:,-1]
clf = linear_model.LinearRegression()
clf.fit(X_train, y_train)


print("coef_ = ",clf.coef_)
print("intercept_ =  ",clf.intercept_)
