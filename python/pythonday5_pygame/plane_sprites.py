import random
import pygame

# 屏幕大小的常量
SCREEN_RECT = pygame.Rect(0, 0, 480, 700)
# 刷新的帧率
FRAME_FLUSH = 60
# 创建飞机的定时器常量
CREATE_ENEMY_EVENT = pygame.USEREVENT
# 英雄发射子弹的事件
HERO_FIRE_EVENT = pygame.USEREVENT + 1


class GameSprite(pygame.sprite.Sprite):

    def __init__(self, image_name, speed=1):
        super().__init__()
        #  加载图像
        self.image = pygame.image.load(image_name)
        self.rect = self.image.get_rect()

        self.speed = speed

    def update(self):
        #  在屏幕的垂直方向上移动
        self.rect.y += self.speed


class Background(GameSprite):
    """游戏背景精灵"""
    def __init__(self, is_alt=False):
        super().__init__("./images/background.png")

        if is_alt:
            self.rect.y = -self.rect.height

    def update(self):
        super().update()
        if self.rect.y >= SCREEN_RECT.height:
            self.rect.y = -self.rect.height


class Enemy(GameSprite):
    """敌机精灵"""
    def __init__(self):
        # 调用父类方法，创建敌机精灵，指定敌机图片
        super().__init__("./images/enemy1.png")
        # 随机设置敌机的速度
        self.speed = random.randint(3, 8)
        # 设置敌机的初始位置
        self.rect.bottom = 0
        self.rect.x = random.randint(0, SCREEN_RECT.width-self.rect.width)

    def update(self):
        super().update()
        if self.rect.y >= SCREEN_RECT.height:

            # 从精灵组中删除飞出屏幕的敌机
            self.kill()

    def __del__(self):
        pass


class Hero(GameSprite):
    def __init__(self):
        super().__init__("./images/me1.png", 0)

        self.rect.centerx = SCREEN_RECT.centerx
        self.rect.bottom = SCREEN_RECT.bottom - 120
        self.bullets = pygame.sprite.Group()

    def update(self):
        self.rect.x += self.speed
        if self.rect.x < 0:
            self.rect.x = 0
        if self.rect.right > SCREEN_RECT.right:
            self.rect.right = SCREEN_RECT.right

    def fire(self):
        print("发射子弹")
        for i in (0, 1, 2):
            bullet = Bullet()
            bullet.rect.bottom = self.rect.y - 20 * i
            bullet.rect.centerx = self.rect.centerx
            self.bullets.add(bullet)


class Bullet(GameSprite):
    """子弹精灵"""

    def __init__(self):
        super().__init__("./images/bullet1.png", -5)

    def update(self):
        super().update()
        if self.rect.bottom < 0:
            self.kill()

    def __del__(self):
        print("子弹被销毁...")
