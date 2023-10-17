import pygame as pg
import math
import random

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


color_white = (255, 255, 255)
color_black = (0, 0, 0)
font = pg.font.SysFont('malgungothic', 35)

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
stone_generate_time = 1
stone_init_height = 280
stone_pos_list = [[500, stone_init_height]]
stone_sprite_list = [create_sprite(stone_image) for _ in stone_pos_list]
element_speed = 300


# 친구
friend_before_image = create_image('img/friend_before.png', (100, 100))
friend_after_image = create_image('img/friend_after.png', (100, 100))
friend_sprite = create_sprite(friend_before_image)
friend_save_status = False
friend_init_pos = 900
friend_pos = [friend_init_pos, garry_height]

portal_image = create_image('img/portal.png', (100, 100))
portal_sprite = create_sprite(portal_image)
portal_init_pos = 900
portal_pos = [portal_init_pos, garry_height]


replay_button_image = create_image('img/replay.png', (170, 170))

clock = pg.time.Clock()
score = 0


game_status = True

while run:
    if game_status:
            

        window.blit(background_image, (0, 0))
        
        # 게임 시간 계산
        after_time = clock.tick(60) / 1000

        garry_sprite.rect.x, garry_sprite.rect.y = garry_pos[0], garry_pos[1]
        window.blit(garry_sprite.image, garry_sprite.rect)

        # 친구, 포탈 그리기, 친구 구출하기
        friend_sprite.rect.x, friend_sprite.rect.y = friend_pos[0], friend_pos[1]
        window.blit(friend_sprite.image, friend_sprite.rect)

        portal_sprite.rect.x, portal_sprite.rect.y = portal_pos[0], portal_pos[1]
        window.blit(portal_sprite.image, portal_sprite.rect)

        if not friend_save_status:
            friend_sprite.image = friend_before_image
            if pg.sprite.collide_mask(garry_sprite, friend_sprite):
                friend_save_status = True
                friend_pos[0] = 15
                friend_pos[1] = garry_pos[1]
            friend_pos[0] -= element_speed * after_time
            if friend_pos[0] < -50:
                friend_pos[0] = friend_init_pos
        else:
            # 구출된 상태
            friend_sprite.image = friend_after_image
            if pg.sprite.collide_mask(friend_sprite, portal_sprite):
                friend_pos[0] = friend_init_pos
                friend_pos[1] = garry_height
                score += 1
                portal_pos[0] = portal_init_pos
                friend_save_status = False
                print(f"score = {score}")
            portal_pos[0] -= element_speed * after_time
            if portal_pos[0] < -50:
                portal_pos[0] = portal_init_pos

        if jump_status:
            garry_sprite.image = jump_speed > 0 and garry_jump_image or garry_land_image
            garry_pos[1] -= jump_speed * after_time * 1000
            jump_speed -= jump_init_speed * after_time * 2
            if friend_save_status:
                friend_pos[1] = garry_pos[1]
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



        for stone_pos, stone_sprite in zip(stone_pos_list, stone_sprite_list):
            stone_sprite.rect.x, stone_sprite.rect.y = stone_pos[0], stone_pos[1] 
            window.blit(stone_sprite.image, stone_sprite.rect)

            if pg.sprite.collide_mask(garry_sprite, stone_sprite) != None:
                game_status = False
            
            if not pg.sprite.collide_mask(stone_sprite, friend_sprite) or not pg.sprite.collide_mask(stone_sprite, portal_sprite):
                stone_pos[0] -= element_speed * after_time
            else:
                print('position duplicate')
            if stone_pos[0] < -100:
                stone_sprite_list.remove(stone_sprite)
                stone_pos_list.remove(stone_pos)

        stone_generate_time -= after_time
        if stone_generate_time <= 0:
            stone_generate_time = random.random() * 3 + 0.7 # 1초 ~ 3초
            stone_sprite_list.append(create_sprite(stone_image))
            stone_pos_list.append([900, stone_init_height])
    else:
        pass

    for event in pg.event.get():
        if event.type == pg.QUIT:
            run = False
        elif event.type == pg.KEYDOWN:
            if game_status and event.key == pg.K_SPACE and not jump_status:
                jump_status = True
    pg.display.update()
pg.display.quit()