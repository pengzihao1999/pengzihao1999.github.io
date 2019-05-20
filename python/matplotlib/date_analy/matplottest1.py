from matplotlib import pyplot as plt
import matplotlib
matplotlib.use('TKAgg')
y2 = [1, 0, 3, 1, 2, 2, 3, 3, 2, 1, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1]
y = [1, 2, 1, 1, 2, 4, 3, 2, 3, 4, 4, 5, 6, 5, 4, 3, 3, 1, 1, 1]
x = [i for i in range(11, 31, 1)]
print(x[::2])
plt.plot(x, y, label="自己")
plt.plot(x, y2, label="同桌")
x_lables = [i for i in range(11, 31, 1)]
y_lables = [i for i in range(0, 8, 1)]
plt.xlabel("age")
plt.ylabel("number of the freinds")
# 对x轴的稀疏程度进行修改
plt.xticks(x_lables[::3])
plt.yticks(y_lables)
# 绘制网格
plt.grid()
# 添加图例  告诉别人每条线代表什么
plt.legend()

plt.show()
