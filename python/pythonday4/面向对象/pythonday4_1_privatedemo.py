#  私有属性在外界不能被直接访问
#  通过在属性或方法之前加两个下划线设为私有属性
#  python中没有真正意义上的私有
#  只是在想要私有的属性或方法前面加上 _类名__属性或方法


class Women:

    def __init__(self, name):
        self.name = name
        self.__age = 18

    def __secret(self):
        print("%s的年龄是 %d" %(self.name, self.age))



xiaofang = Women("xiaofang")

xiaofang.secret()
