class Dog:

    def __init__(self, name):
        self.name = name

    def game(self):
        print("%s在地上玩耍" % self.name)


class XiaoTianDog(Dog):

    def game(self):
        print("%s在天上玩耍" % self.name)


class Person:
    def __init__(self, name):
        self.name = name

    def play_with_dog(self, dog):
        print("%s和%s在玩耍" % (self.name, dog.name))
        dog.game()



wangcai = Dog("wangcai")
xiaotian = XiaoTianDog("神犬")
xiaowang = Person("xiaowang")
xiaowang.play_with_dog(xiaotian)


