# 多次绘制条形图
# 目的：进行比较三个月的电影票房数量
from matplotlib import pyplot as plt
from matplotlib import font_manager
import matplotlib
my_font = font_manager.FontProperties(fname="C:\Windows\Fonts\simkai.ttf")
matplotlib.use('TKAgg')

a = ["猩球崛起3：终极之战","敦刻尔克","蜘蛛侠：英雄归来","战狼2"]
b_16 = [15746,312,4497,319]
b_15 = [12357,156,2045,168]
b_14 = [2358,399,2358,362]

width = 0.2
x_14 = list(range(len(a)))
x_15 = [i+width for i in x_14]
x_16 = [i+2*width for i in x_14]

# 找出y的值在X的对应位置
plt.bar(x_14,b_14,width=0.1)
plt.bar(x_15,b_15,width=0.1)
plt.bar(x_16,b_16,width=0.1)
plt.xticks(x_15,a,fontproperties = my_font)
plt.show()
