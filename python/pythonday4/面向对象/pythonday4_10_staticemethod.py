"""
静态方法不需要创建对象
1.当方法不需要访问实例属性和调用实例方法
2.当方法不需要访问类属性和调用类方法时
可以考虑用静态方法
"""
class Dog(object):

    @staticmethod
    def run():
        print("hahahaha。。")


Dog.run()