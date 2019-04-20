"""
实例方法——方法内部需要访问实例属性
类方法——方法内部只需要访问类属性
静态方法——方法内部不需要访问实例属性和类属性
如果方法内部既需要访问实例属性，又需要访问
类属性，应该定义成实例方法 因为在实例方法中
可以通过类名.属性名访问类方法
"""

class Game(object):

    # 历史最高分
    top_score = 0

    def __init__(self, player_name):
        self.player_name = player_name

    @staticmethod
    def show_help():
        print("这就是帮助信息")

    @classmethod
    def show_top_score(cls):
        print("历史记录%d" % cls.top_score)

    def start_game(self):
        print("%s 游戏开始了" % self.player_name)


#  输出帮助信息
Game.show_help()
#  查看历史最高峰吗
Game.top_score
#  开始游戏
game1 = Game("player1")
game1.start_game()