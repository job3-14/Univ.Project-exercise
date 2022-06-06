from sklearn import svm
from sklearn.datasets import load_iris

iris = load_iris()

# 学習させる
clf = svm.SVC(gamma="scale")
clf.fit(iris.data, iris.target)
print (iris.data.shape)
print (iris.target_names)

# ランダムに見つけた値で分類できるかどうか確認する
# case versicolor
#test_data = [[6.0,2.2,5.0,1.5]]
#print(clf.predict(test_data))
