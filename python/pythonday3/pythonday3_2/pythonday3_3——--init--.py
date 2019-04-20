class Cat:

    def __init__(self, new_name):
        print("init>>>")
        self.name = new_name

    def eat(self):
        print("%s哎吃鱼" % self.name)

    def drink(self):
        print("%s爱喝水" % self.name)

    def __str__(self):

        return "我是小猫[%s]" % self.name

OT = Cat("TOM")
OT.eat()
OT.drink()
print(OT)
