import numpy as np
import random
t1 = np.array([1,2,3,])
print(t1)
print(type(t1))

t2 = np.array(range(10))
print(t2)
print(type(t1))

t3 = np.arange(-4,10,2)
print(t3)
print(type(t1))

print(t3.dtype)

# 指定和输出t4中的类型
t4 = np.array(range(2,5),dtype=float)
print(t4)
print(t4.dtype)

# numpy中的boolean类型
t5 = np.array([1,1,0,1,0,0],dtype=bool)
print(t5)
print(t5.dtype)

#调整数据类型
t6 = t5.astype("int8")
print(t6)
print(t6.dtype)

# 生成10个小数 并保留两位有效数字
t7 = np.array([round(random.random(),2) for i in range(10)])
print(t7)