import pandas as pd
import numpy
from sklearn.model_selection import train_test_split
from sklearn.neural_network import MLPClassifier
from sklearn import svm
numpy.set_printoptions(threshold=numpy.inf)


df = pd.read_csv('./train.csv', header = None)
arr = df.values
X = arr[:,:-1]
y = arr[:,-1]
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.05)
clf = svm.SVC(kernel='rbf', gamma=0.1, C=84, random_state=1)
clf.fit(X_train, y_train)


#test_data = [[ 1.262118452,0.845173737,-0.441595749,0.590068415,0.479399128,0.125659357]]
#print(clf.predict(test_data))

print('推測した結果の正解率',clf.score(X_test, y_test))

#print(clf.support_vectors_.shape)
print(clf.dual_coef_.shape)
print(clf.intercept_.shape)

#print(clf.intercept_)
