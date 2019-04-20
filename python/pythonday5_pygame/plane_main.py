import pygame
from plane_sprites import *


class PlaneGame(object):

    def __init__(self):
        print("游戏初始化")
        # 1 创建游戏的窗口
        # 2 创建游戏的时钟
        # 3 调用私有方法，精灵和精灵组的创建
        self.screen = pygame.display.set_mode(SCREEN_RECT.size)
        self.clock = pygame.time.Clock()
        self.__creat_sprites()
        # 4 设置定时器时间
        pygame.time.set_timer(CREATE_ENEMY_EVENT, 1000)
        pygame.time.set_timer(HERO_FIRE_EVENT, 500)

    def __creat_sprites(self):
        bg1 = Background(False)
        bg2 = Background(True)

        self.back_group = pygame.sprite.Group(bg1, bg2)

        self.enemy_group = pygame.sprite.Group()

        self.hero = Hero()
        self.hero_group = pygame.sprite.Group(self.hero)

    def start_game(self):
        print("游戏开始了")

        while True:

            # 1设置刷新帧率
            self.clock.tick(FRAME_FLUSH)
            # 2事件监听
            self.__even_handler()
            # 3碰撞检测
            self.__check_collide()
            # 4更新/绘制精灵组
            self.__update_sprites()
            # 5更新显示
            pygame.display.update()

    def __update_sprites(self):
        self.back_group.update()
        self.back_group.draw(self.screen)
        self.enemy_group.update()
        self.enemy_group.draw(self.screen)
        self.hero_group.update()
        self.hero_group.draw(self.screen)
        self.hero.bullets.update()
        self.hero.bullets.draw(self.screen)

    def __even_handler(self):

        for event in pygame.event.get():

            if event.type == pygame.QUIT:
                PlaneGame.__game_over()
            elif event.type == CREATE_ENEMY_EVENT:
                print("敌机出场")
                # 创建敌机精灵
                enemy = Enemy()
                enemy2 = Enemy()
                # 将敌机 精灵添加到敌机精灵组
                self.enemy_group.add(enemy, enemy2)
            elif event.type == HERO_FIRE_EVENT:
                self.hero.fire()
        #  使用键盘提供的方法获取键盘按键 — 按键元组
        keys_pressed = pygame.key.get_pressed()
        if keys_pressed[pygame.K_RIGHT]:
            self.hero.speed = 3
        elif keys_pressed[pygame.K_LEFT]:
            self.hero.speed = -3
        else:
            self.hero.speed = 0

    def __check_collide(self):
        pygame.sprite.groupcollide(self.hero.bullets, self.enemy_group, True, True)
        game_flag = pygame.sprite.spritecollide(self.hero, self.enemy_group, True)
        if len(game_flag) > 0:
            print("游戏结束")
            self.hero.kill()
            PlaneGame.__game_over()

    @staticmethod
    def __game_over():
        pygame.quit()
        exit()


if __name__ == '__main__':

        game = PlaneGame()
        game.start_game()

