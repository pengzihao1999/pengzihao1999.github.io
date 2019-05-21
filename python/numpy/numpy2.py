import numpy as np
t1 = np.arange(1,25).reshape(4,6)
t2 = np.arange(101,125).reshape(4,6)
# 对矩阵进行加减乘除
# 1对常数 发现矩阵的所有成员都进行了操作(广播机制)
print(t1*2)
print(t1/2)
print(t1+2)
print(t1-2)
# 对一维矩阵 如果有跟行和列同一纬度的数组，会对数组的每一行或每一列进行运算
print("对一维矩阵")
t3 = np.arange(1,5).reshape(4,1)
print(t3)
print(t1-t3)
print(t1+t3)
t4 = np.arange(1,7)
print(t4)
print(t1+t4)
print(t1-t4)
# 数组和数组计算 对应位置进行加减乘除
# 不同维度数组进行计算会报错的 只有在行和列分维度不同的数组才可以进行计算