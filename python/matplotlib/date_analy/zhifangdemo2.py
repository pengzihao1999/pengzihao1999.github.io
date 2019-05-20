# 因为数据都是统计好的
# 而绘制直方图是经过电脑进行统计
# 只能绘制条形图调整间距转为直方图
from matplotlib import pyplot as plt
from matplotlib import font_manager
import matplotlib
my_font = font_manager.FontProperties(fname="C:\Windows\Fonts\simkai.ttf")
matplotlib.use('TKAgg')

plt.figure(figsize=(20,8),dpi=80)
interval = [0,5,10,15,20,25,30,35,40,45,60,90]
width = [5,5,5,5,5,5,5,5,5,15,30,60]
quantity = [836,2737,3723,3926,3596,1438,3273,642,824,613,215,47]

plt.bar(range(len(quantity)),quantity,width=1)
_x = [i-0.5 for i in range(len(quantity)+1)]
_x_tickes = interval+[150]
plt.xticks(_x, _x_tickes)
plt.xticks()
plt.grid()
plt.show()
