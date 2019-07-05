import pandas as pd
from sklearn.neighbors import KNeighborsClassifier
from sklearn.preprocessing import StandardScaler
from sklearn.model_selection import train_test_split
from sklearn.tree import DecisionTreeClassifier
from sklearn.datasets import load_iris
def KNN1():
    # 一.加载测试文件
    data = pd.read_csv("D:\DataSet\\facebook_v\\train.csv")
    #打印前十个 属性值 row_id x y accuracy time place_id
    print(data.head(10))
    # 二.进行数据处理
    """  
         取一定范围的值 测试 （数据量太大） data.query()
         1.时间戳类型转变成时间类型 年—月—日 —周-..... pd.todatetime()
         2.定位精度低于10的样本删除
         3.把place_id出现少的删掉（原因：place_id的值较多，影响准确性）
    """
    data = data.query("x>5.1&x<6.1&y>5.1&y<6.1")
    time = pd.to_datetime(data['time'],unit='s')
    # 把日期格式转化为字典形势
    Dictdata = pd.DatetimeIndex(time)
    # 提取出字典的某一周的第几天 小时 添加到特征中
    data['dayofweek'] = Dictdata.dayofweek
    data['hour'] = Dictdata.hour
    data['day'] = Dictdata.day
    # 删除原来的时间戳类型 按列删除
    data = data.drop(['time'],axis=1)
    # 统计出居住的place_id小于三次的 并删除
    group = data.groupby('place_id').count()
    tf = group[group.row_id>3].reset_index()#里面的place_id都是大于三了
    data = data[data['place_id'].isin(tf['place_id'])]
    # 删除精度小于百分之十的
    data = data[data.accuracy>10]
    #三 划分训练集 测试集
      #取出目标值特征值
    y = data['place_id']
    x = data.drop(['place_id'],axis=1).drop(['row_id'],axis=1)
    print(y.head(10))
    print(x.head(10))
    x_train,x_test,y_train,y_test = train_test_split(x,y,test_size=0.25)
    # 四
    #
    # 标准化
    ssTools = StandardScaler()
    x_train = ssTools.fit_transform(x_train)
    x_test = ssTools.fit_transform(x_test)
    print(y.head(10))
    print(x.head(10))
    # 五.调用模型来得到预测精度值
    # 使用knn
    # Class = KNeighborsClassifier(n_neighbors=5)
    # Class.fit(x_train,y_train)
    # # predict = Class.predict(x_test)
    # print(Class.score(x_test,y_test))
    # 使用决策树
    dtTools = DecisionTreeClassifier(criterion='gini')
    dtTools.fit(x_train,y_train)
    print(dtTools.score(x_test,y_test))

def KNN2():
        li=load_iris()
        data = li.data
        target = li.target
        x_train,x_test,y_train,y_test = train_test_split(data,target,test_size=0.25)
        KNNtools = KNeighborsClassifier(n_neighbors=5)
        KNNtools.fit(x_train,y_train)
        print(KNNtools.score(x_test,y_test))

if __name__ == '__main__':
    KNN1()



