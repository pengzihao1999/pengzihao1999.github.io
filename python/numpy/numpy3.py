import numpy as np
x = np.arange(24).reshape(4,6)
print(x)
# 1.1.取行和列对应的值
# print(x[1,3])
# 1.2.取多行多列
# print(x[1:,3])
# print(x[1,3:])
# 1.3取带步长的多行多列
# print(x[0:3:2,3:])
# 2.1numpy的数值修改 布尔索引
# x[x<10] = 0
# print(x)
# 3.numpy中的where方法
# 意思就是把x数组中等于0的替换成1，不等与零的替换为2
# k = np.where(x<10,1,2)
# np.where()
# print(k)
# 4 numpy中的clip 小于10的都为10，大于20的都为20
# x= np.clip(x,10,20)
# print(x)
# 5 数组的拼接 水平拼接和垂直拼接
x1 = np.arange(23,47).reshape(4,6)
# print(x1)
# print(np.vstack((x,x1)))
# print(np.hstack((x,x1)))
# 6 数组的行列互换
# 6.1行互换
# x[[1,2],:] = x[[2,1],:]
# print(x)
# # 6.2列互换
# x[:,[2,3]] = x[:,[3,2]]
# print(x[:,[2,5]])
