class Tool(object):
    # 类属性 使用
    count = 0

    @classmethod
    def show_tool_count(cls):  # 类方法
        print("工具对象的数量%d" % cls.count)

    def __init__(self, name):
        self.name = name

        Tool.count += 1


tool1 = Tool("斧头")
tool2 = Tool("斧头1")
tool3 = Tool("斧头2")
Tool.show_tool_count()

"""
python的属性获取机制
可以通过变量名和类名进行访问类属性
1.首先在对象内部查找对象属性
2.如果对象内部没有该属性，没有就会在向上在类中查找
注意:如果通过对象名.类属性不会对类属性进行修改 
而是会对实例新增一个属性并赋给一个初值
"""