class A:
    def __init__(self):
        self.num1 = 100
        self.__num2 = 200

    def __test(self):
        print("私有方法" % (self.num1, self.__num2))


class B(A):
    """
   ① 在子类对象中只能访问父类的公有属性和公有方法
    不能访问父类的私有属性和私有方法
   ②子类对象可以通过访问父类的公有方法间接访问到父类的私有属性和私有方法
    """
    def demo(self):
        pass



b = B()
#  print(b.__num2)
#   b.__test()在外界不能访问私有属性和私有方法
b.demo()
