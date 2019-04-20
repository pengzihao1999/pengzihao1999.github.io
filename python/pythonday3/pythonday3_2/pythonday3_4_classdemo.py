class Person:
    def __init__(self, name, weight):

        self.name = name
        self.weight = weight


    def __str__(self):

        return "我的名字叫 %s 体重是 %.2f 公斤" \
               "" % (self.name, self.weight)

    def run(self):
        print("%s 爱跑步，跑步锻炼身体" % self.name)
        self.weight -= 0.5

    def eat(self):
        print("%s 爱吃，吃多西长胖" % self.name)
        self.weight += 1


xiaoming = Person("小明", 75.0)
xiaoming.eat()
xiaoming.run()

print(xiaoming)
