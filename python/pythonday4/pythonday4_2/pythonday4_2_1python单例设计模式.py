"""
python的单例模式
首先定义一个类属性为空
在使用类名()进行初始化时，首先会调用_new_()方法
new方法保证返回只返回一个对象的引用

每次对象调用new方法后会自动调用_init_方法
如果要保证init方法只初始化一次 就可以加一个类属性判断标记
如果初始化设为真 下次进行初始化时如果标记为真 就直接return
"""


class SingleInstance(object):
    Instance = None

    init_flag = False

    def __new__(cls, *args, **kwargs):
        if cls.Instance is None:
            cls.Instance = super().__new__(cls)

        return cls.Instance

    def __init__(self):
        if SingleInstance.init_flag:
            return
        print("初始化完成")
        SingleInstance.init_flag = True


single1 = SingleInstance()
single2 = SingleInstance()
print(single1)
print(single2)
