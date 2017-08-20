import pandas as pd
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeRegressor
from sklearn.preprocessing import Normalizer
from sklearn.decomposition import PCA
import numpy as np	


def fn(x1,x2,x3,x4,x5,x6,x7,x8):
	df = pd.read_excel('dataset.xlsx')
	numpyMatrix = df.as_matrix()
	HL = numpyMatrix[:,8]
	CL = numpyMatrix[:,9] 
	data = np.delete(numpyMatrix, 9, 1)
	data = np.delete(data, 8, 1)
	X_train,X_test,y_train,y_test=train_test_split(data,HL,test_size=0.2,random_state=42)
	data_reduced = pca.fit_transform(X_train_norm)
	regr2 = DecisionTreeRegressor(random_state=0)
	regr2.fit(data_reduced, y_train)
	Hlp = reg2.predict([x1,x2,x3,x4,x5,x6,x7,x8])
	X_train,X_test,y_train,y_test=train_test_split(data,HL,test_size=0.2,random_state=42)
	data_reduced = pca.fit_transform(X_train_norm)
	regr2 = DecisionTreeRegressor(random_state=0)
	regr2.fit(data_reduced, y_train)
	Clp = reg2.predict([x1,x2,x3,x4,x5,x6,x7,x8])
	return Hlp,Clp
