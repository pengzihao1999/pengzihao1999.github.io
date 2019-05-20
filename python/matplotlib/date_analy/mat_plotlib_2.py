# coding=utf-8
from matplotlib import pyplot as plt
import random
from matplotlib import font_manager
import matplotlib
matplotlib.use('TKAgg')
# 在widows linux max设置字体的方式
# fname 传当前系统字体的路径
my_font = font_manager.FontProperties(fname="C:\Windows\Fonts\simkai.ttf")

x = range(0, 120)
y = [random.randint(20, 35) for i in range(120)]

plt.figure(figsize=(20, 35), dpi=80)

plt.plot(x, y)

_xtick_labels = ["10点{}分".format(i) for i in range(60)]
_xtick_labels += ["11点{}分".format(i) for i in range(60)]
# rotation使x轴旋转90度
plt.xticks(list(x)[::30], _xtick_labels[::30], rotation=90, fontproperties=my_font)
# 发现输出不能现实中文字体 运用matplotlib.rc方法
plt.xlabel("时间", fontproperties=my_font)
plt.ylabel("温度 单位(℃）", fontproperties=my_font)
plt.title("10点到12点每分钟的气温变化情况", fontproperties=my_font)
plt.show()

