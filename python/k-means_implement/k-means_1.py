from numpy import *
import pandas as pd

def writer(clusterAssment,filename = "D:\学习资料\大数据竞赛数据集\DOGMEANS.txt"):
    df = pd.DataFrame(clusterAssment,index=[i for i in range(clusterAssment.shape[0])],columns=['聚类中心','距离'])
    df.to_csv(filename)
def loadDataSet(fileName):
    dataSet = []
    f = open(fileName)
    for line in f.readlines():
        curLine = line.strip().split(' ')  # 这里","表示以文件中数据之间的分隔符","分割字符串
        row = []
        for item in curLine:
            row.append(float(item))
        dataSet.append(row)

    return mat(dataSet)


# 求向量距离
def distEclud(vecA, vecB):
    return sqrt(sum(power(vecA - vecB, 2)))
# 随机生成k个点作为初始质心
# 若选择随机生成的点作为初始质心，则有可能导致后面更新质心时出现有的质心为 NaN(非数) 的情况
def initCent(dataSet, k):
    n = shape(dataSet)[1]  # n是列数
    centroids = mat(zeros((k, n)))
    for j in range(n):
        minJ = min(dataSet[:, j])  # 找到第j列最小值
        rangeJ = max(dataSet[:, j]) - minJ  # 求第j列最大值与最小值的差
        centroids[:, j] = minJ + random.rand(k, 1) * rangeJ  # 生成k行1列的在(0, 1)之间的随机数矩阵
    return centroids


# K均值聚类算法实现
def KMeans(dataSet, k, distMeas=distEclud):
    m = shape(dataSet)[0]  # 数据集的行
    clusterAssment = mat(zeros((m, 2)))
    centroids = initCent(dataSet, k)
    print(centroids)
    clusterChanged = True
    while clusterChanged:
        count = 0
        clusterChanged = False
        for i in range(m):  # 遍历数据集中的每一行数据
            minDist = inf
            minIndex = -1
            for j in range(k):  # 寻找最近质心
                distJI = distMeas(centroids[j, :], dataSet[i, :])
                if distJI < minDist:  # 更新最小距离和质心下标
                    minDist = distJI
                    minIndex = j
            if clusterAssment[i, 0] != minIndex:
                clusterChanged = True
            clusterAssment[i, :] = minIndex, minDist ** 2  # 记录最小距离质心下标，最小距离的平方
        print("这是第"+str(count)+"轮样本的聚类中心和距聚类中心的距离的矩阵")
        count = count +1
        print("*"*100)
        print(clusterAssment)
        print("-"*100)
        for cent in range(k):  # 更新质心位置
            ptsInClust = dataSet[nonzero(clusterAssment[:, 0].A == cent)[0]]  # 获得距离同一个质心最近的所有点的下标，即同一簇的坐标
            # ptsInClust 可能为0的情况：这一轮中，所有点的都离这个点最远
            if(len(ptsInClust!=0)):
                centroids[cent, :] = mean(ptsInClust, axis=0)  # 求同一簇的坐标平均值，axis=0表示按列求均值

    return centroids,clusterAssment


if __name__ == "__main__":
    cluster_Num = 5
    data = loadDataSet("D:\学习资料\大数据竞赛数据集\DogData.txt")
    print(data)
    centroids, clusterAssment = KMeans(data, cluster_Num)
    print(centroids)
    print(clusterAssment)
    writer(clusterAssment)






