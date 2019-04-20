#  override 覆盖 在子类定义一个和父类同名的方法
#  对父类方法的拓展


class Animal:

    def eat(self):
        print("吃东西")


class Dog(Animal):
    def bark(self):
        print("汪汪汪")

    def eat(self):
        super().eat()
        #  Dog.eat(self)
        print("吃的多")


dog = Dog()
dog.eat()
dog.bark()
