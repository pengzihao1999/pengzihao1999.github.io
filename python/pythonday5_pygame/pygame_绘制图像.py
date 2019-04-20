import pygame
from plane_sprites import *

# 游戏的初始化
pygame.init()

screen = pygame.display.set_mode((480, 700))
# 1加载图像数据
bg = pygame.image.load("./images/background.png")
# 2绘制图像 将图像绘制到指定位置
screen.blit(bg, (0, 0))
# 绘制英雄的飞机
hero = pygame.image.load("./images/me1.png")
screen.blit(hero, (150, 300))
# update更新屏幕显示
pygame.display.update()

# 创建时钟对象
clock = pygame.time.Clock()
# 在外面记录飞机的原始位置
hero_rect = pygame.Rect(150, 300, 102, 126)

# 创建敌机的精灵
enemy = GameSprite("./images/enemy1.png")
enemy1 = GameSprite("./images/enemy1.png",2)
# 创建敌机的精灵组
enemy_group = pygame.sprite.Group(enemy, enemy1)

# 游戏循环
while True:
    for event in pygame.event.get():
        if event.type == pygame.QUIT:
            print("退出游戏")
            pygame.quit()
            exit()
    clock.tick(60)
    hero_rect.y -= 1
    if hero_rect.y <= 0:
        hero_rect.y = 700
    # 修改飞机的位置 重新添加到屏幕
    screen.blit(bg, (0, 0))
    screen.blit(hero, hero_rect)

    enemy_group.update()

    enemy_group.draw(screen)

    pygame.display.update()

    pass

pygame.quit()
