class A:

    def test(self):
        print("test方法")


class B:

    def demo(self):
        print("demo方法")


#  进行多继承 C类既可以使用A,B类中的属性和方法

#  尽量避免使用多继承，子类对象在调用方法时，如果有重名的方法不知道调用哪一个
#  python中的MRO 从左到右进行搜索如果找到了 就不会往下找了
class C(A, B):
    pass


c = C()
c.demo()
c.test()
