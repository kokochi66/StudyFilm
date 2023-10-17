import pygame as pg
import math

pg.init()

def create_sprite(image, pos, status=None, time=None):
    sprite = pg.sprite.Sprite()
    sprite.image = image
    sprite.rect = sprite.image.get_rect()
    sprite.rect.x , sprite.rect.y = pos[0], pos[1]
    if status != None:
        sprite.status = status
    if time != None:
        sprite.time = time
    return sprite

def create_image(image, size):
    result = pg.image.load(image)
    result = pg.transform.scale(result, size)
    return result

# 게임 기본 설정
run = True
width, height = 800, 450
window = pg.display.set_mode([width, height])
pg.display.set_caption('동족을 노역장에서 구출하라!')

background_image = create_image('img/background.png', (width, height))


# 개리
garry_run_flow = 0.2
garry_run_index = 0
garry_run_image_list = []
for index in range(4):
    garry_run_image = create_image(f'img/garry_run_{index + 1}.png', (100, 100))
    garry_run_image_list.append(garry_run_image)


# 오브젝트
stone_image = create_image('img/stone.png', (100, 100))



while run:
    window.blit(background_image, (0, 0))
    
    window.blit(garry_run_image_list[garry_run_index], (70, 255))
    garry_run_index = (garry_run_index + 1) % len(garry_run_image_list)

    window.blit(stone_image, (500, 280))

    for event in pg.event.get():
        if event.type == pg.QUIT:
            run = False

    pg.display.update()
pg.display.quit()