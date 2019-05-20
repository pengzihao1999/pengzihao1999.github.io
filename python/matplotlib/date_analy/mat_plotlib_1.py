from matplotlib import pyplot as plt
# 设置图片大小
fig = plt.figure(figsize=(20, 8), dpi=80)
x = range(2, 26, 2)
y = [15, 13, 14.5, 17, 20, 25, 26, 26, 27, 22, 18, 15]
# 绘图
plt.plot(x, y)
# 自定义x轴的密度
x_labels = [j/2 for j in range(4, 49)]
print(x_labels)
# 绘制x轴的刻度
plt.xticks(x_labels)
plt.yticks(range(min(y), max(y)+1))
# 保存
# plt.savefig("./t1.png")
# 展示图形
plt.show()
