import pygame as pg
import math

pg.init()

def create_sprite(image):
    sprite = pg.sprite.Sprite()
    sprite.image = image
    sprite.rect = sprite.image.get_rect()
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
garry_run_image_list = [create_image(f'img/garry_run_{index}.png', (100, 100)) for index in range(1, 5)]
garry_jump_image = create_image(f'img/garry_jump.png', (100, 100))
garry_land_image = create_image(f'img/garry_land.png', (100, 100))
garry_sprite = create_sprite(garry_run_image_list[0])

garry_run_status = 0
garry_run_flow = 1
garry_animation_time = 0
jump_init_speed = 0.1
jump_speed = jump_init_speed
jump_status = False
garry_height = 255
garry_pos = [70, garry_height]

# 오브젝트
stone_image = create_image('img/stone.png', (100, 100))


clock = pg.time.Clock()

while run:
    window.blit(background_image, (0, 0))
    
    # 게임 시간 계산
    after_time = clock.tick(60) / 1000

    garry_sprite.rect.x, garry_sprite.rect.y = garry_pos[0], garry_pos[1]
    window.blit(garry_sprite.image, garry_sprite.rect)

    if jump_status:
        garry_sprite.image = jump_speed > 0 and garry_jump_image or garry_land_image
        garry_pos[1] -= jump_speed * after_time * 1000
        jump_speed -= jump_init_speed * after_time * 2
        if garry_pos[1] >= garry_height:
            garry_pos[1] = garry_height
            jump_status = False
            jump_speed = jump_init_speed
    else:
        garry_animation_time += after_time
        if garry_animation_time > 0.2:
            garry_animation_time = 0
            garry_sprite.image = garry_run_image_list[garry_run_status]
            garry_run_status += garry_run_flow
            if garry_run_status == len(garry_run_image_list) - 1 or garry_run_status == 0:
                garry_run_flow *= -1
    # window.blit(garry_run_image_list[garry_image_index], (70, 255))
    # garry_image_index = (garry_image_index + 1) % len(garry_run_image_list)

    window.blit(stone_image, (500, 280))

    for event in pg.event.get():
        if event.type == pg.QUIT:
            run = False
        elif event.type == pg.KEYDOWN:
            if event.key == pg.K_SPACE and not jump_status:
                jump_status = True
    pg.display.update()
pg.display.quit()