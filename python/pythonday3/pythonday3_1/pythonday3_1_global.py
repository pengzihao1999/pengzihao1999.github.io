num = 20  # 定义全局变量
#  函数调用的全局变量必须先定义
#  在开发时应该把所有模块中的全局变量应该
#  定义在所有的函数上方


def demo1():
    """利用global变量进行声明
    要操作的变量是全局变量
    :return:
    """
    global num
    num = 50
    print("%d" % num)


def demo2():
    print("%d" % num)


demo1()
demo2()
