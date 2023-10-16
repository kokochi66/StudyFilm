import pygame as pg
import math
import random

pg.init()


# 게임 기본 설정
run = True
width, height = 952, 913
window = pg.display.set_mode([width, height])
pg.display.set_caption('광석채굴!')

# 색깔 설정
color_white = (255, 255, 255)
color_black = (0, 0, 0)

# 글꼴 설정
font = pg.font.SysFont('malgungothic', 50)
font_little = pg.font.SysFont('malgungothic', 25)
# print(pg.font.get_fonts())

# 게임 요소 초기화
ore_max_status = 5
ore_gen_time = 8
ore_gen_time_remain = 0

coin = 0
play_time = 0

# 이미지 초기화
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

background_image = create_image('img/background.png', (width, height))
time_bar_image = create_image('img/time_bar.png', (337, 89))
coin_bar_image = create_image('img/coin_bar.png', (337, 89))

# 소울곰 초기화
game_element_size = (152, 152)
soul_bear_dictionary = {"move": [], "move_mirror": [], "dig": []}
soul_bear_dictionary["stop"] = create_image(f'img/soul_bear_stop.png', game_element_size)

for index in range(4):
    soul_bear_run_image = create_image(f'img/soul_bear_run_{index + 1}.png', game_element_size)
    soul_bear_dictionary["move"].append(soul_bear_run_image)

    soul_bear_run_mirror_image = create_image(f'img/soul_bear_run_mirror_{index + 1}.png', game_element_size)
    soul_bear_dictionary["move_mirror"].append(soul_bear_run_mirror_image)

for index in range(3):
    soul_bear_dig_image = create_image(f'img/soul_bear_dig_{index + 1}.png', game_element_size)
    soul_bear_dictionary["dig"].append(soul_bear_dig_image)

soul_bear_pos = [width // 2, height //2]
soul_bear_speed = 180
upgrade_dictionary = {
    'power': {
        'max' : 10,
        'count' : 1
    },
    'speed': {
        'max' : 10,
        'count' : 1
    },
    'regen': {
        'max' : 10,
        'count' : 1
    },
}
soul_bear_power = 1
soul_bear_status = "stop"
soul_bear_image_index = 0
soul_bear_image_flow = 1
soul_bear_sprite = create_sprite(soul_bear_dictionary[soul_bear_status], soul_bear_pos)

# 광석 초기화
ore_image_list = []
for index in range(5):
    ore_image = create_image(f'img/ore_{5 - index}.png', game_element_size)
    ore_image_list.append(ore_image)
ore_sprite_list = []
ore_sprite_list.append(create_sprite(ore_image_list[-1], (200, 200), ore_max_status))

# 능력치 이미지
status_image = create_image('img/status.png', (545, 190))

clock = pg.time.Clock()

# 캐릭터의 애니메이션 속도 
image_move_max_time = 0.2
image_move_time = 0

while run:
    window.blit(background_image, (0, 0))

    # 시간 표시
    after_time = clock.tick(60) / 1000
    play_time += after_time
    time_str = '%02d:%05.2f' % (play_time / 60, play_time % 60)
    game_time_str = font.render(time_str, True, color_black)
    window.blit(time_bar_image, (30, 10))
    window.blit(game_time_str, (time_bar_image.get_width() - 26 * len(time_str), 20))

    # 코인 표시
    coin_str = str(coin)
    game_coin_str = font.render(coin_str, True, color_black)
    window.blit(coin_bar_image, (width - 30 - coin_bar_image.get_width(), 10))
    window.blit(game_coin_str, (width - 70 - 40 * len(coin_str), 20))

    # 광석 표시
    for ore_sprite in ore_sprite_list:
        window.blit(ore_sprite.image, ore_sprite.rect)

    # 소울 곰 표시
    soul_bear_sprite.rect.x, soul_bear_sprite.rect.y = soul_bear_pos[0], soul_bear_pos[1]
    window.blit(soul_bear_sprite.image, soul_bear_sprite.rect)

    # 스탯 창
    window.blit(status_image, (width - status_image.get_width(), height - status_image.get_height()))
    power_string = font_little.render(str(upgrade_dictionary['power']['count']), True, color_black)
    window.blit(power_string, (500, height - status_image.get_height() + 50))
    speed_string = font_little.render(str(upgrade_dictionary['speed']['count']), True, color_black)
    window.blit(speed_string, (610, height - status_image.get_height() + 50))
    regen_string = font_little.render(str(upgrade_dictionary['regen']['count']), True, color_black)
    window.blit(regen_string, (720, height - status_image.get_height() + 50))

    #광석 자동생성
    ore_gen_time_remain -= after_time
    if ore_gen_time_remain <= 0:
        ore_gen_time_remain = ore_gen_time
        gen_pos = [random.random() * (width - game_element_size[0]),
                   random.random() * (height - time_bar_image.get_height() - status_image.get_height() - game_element_size[1]) + time_bar_image.get_height()]
        ore_sprite_list.append(create_sprite(ore_image_list[-1], gen_pos, ore_max_status))

    
    keys = pg.key.get_pressed()          

    
    if keys[pg.K_LEFT] or keys[pg.K_RIGHT] or keys[pg.K_UP] or keys[pg.K_DOWN]:
        # 캐릭터 움직이기
        image_move_time -= after_time
        if keys[pg.K_LEFT] or keys[pg.K_RIGHT]:
            if keys[pg.K_LEFT]:
                if soul_bear_status != 'move':
                    soul_bear_status = 'move'
                    image_move_time = 0
                if soul_bear_pos[0] >= 0:
                    soul_bear_pos[0] -= soul_bear_speed * after_time
            if keys[pg.K_RIGHT]:
                if soul_bear_status != 'move_mirror':
                    soul_bear_status = 'move_mirror'
                    image_move_time = 0
                if soul_bear_pos[0] < width - game_element_size[0] + 20:
                    soul_bear_pos[0] += soul_bear_speed * after_time
        if keys[pg.K_UP] or keys[pg.K_DOWN]:
            if soul_bear_status != 'move' and soul_bear_status != 'move_mirror':
                soul_bear_status = 'move'
            if keys[pg.K_UP] and soul_bear_pos[1] >= time_bar_image.get_height():
                soul_bear_pos[1] -= soul_bear_speed * after_time
            elif keys[pg.K_DOWN] and soul_bear_pos[1] < height - status_image.get_height() - game_element_size[1]:
                soul_bear_pos[1] += soul_bear_speed * after_time
        if image_move_time <= 0:
            image_move_time = image_move_max_time
            soul_bear_image_index += soul_bear_image_flow
            soul_bear_sprite.image = soul_bear_dictionary[soul_bear_status][soul_bear_image_index]
            if soul_bear_image_index == 0 or soul_bear_image_index == len(soul_bear_dictionary[soul_bear_status]) - 1:
                soul_bear_image_flow *= -1
    elif keys[pg.K_SPACE]:
        # 광석 캐기
        if soul_bear_status == 'dig':
            image_move_time -= after_time
            if image_move_time <= 0:
                    image_move_time = image_move_max_time
                    soul_bear_image_index += soul_bear_image_flow
                    soul_bear_sprite.image = soul_bear_dictionary[soul_bear_status][soul_bear_image_index]
                    if soul_bear_image_index == 0 or soul_bear_image_index == len(soul_bear_dictionary[soul_bear_status]) - 1:
                        soul_bear_image_flow *= -1
                        if soul_bear_image_index == len(soul_bear_dictionary[soul_bear_status]) - 1:
                            # 광석 캐는 애니메이션이 되었을 때 광석을 캐도록 함
                            for ore_sprite in ore_sprite_list:
                                if pg.sprite.collide_mask(soul_bear_sprite, ore_sprite):
                                    ore_sprite.status -= soul_bear_power
                                    if ore_sprite.status <= 0:
                                        coin += 1
                                        ore_sprite_list.remove(ore_sprite)
                                    else:
                                            ore_sprite.image = ore_image_list[math.ceil(ore_sprite.status) - 1]
                                    break
        else:
            image_move_time = image_move_max_time
            soul_bear_status = 'dig'
            soul_bear_image_index = 0
            soul_bear_image_flow = 1
            soul_bear_sprite.image = soul_bear_dictionary[soul_bear_status][soul_bear_image_index]    
    else:
        image_move_time = 0
        soul_bear_status = 'stop'
        soul_bear_image_flow = 1
        soul_bear_image_index = 0
        soul_bear_sprite.image = soul_bear_dictionary[soul_bear_status]

    pg.display.update()
    for event in pg.event.get():
        if event.type == pg.QUIT:
            run = False
        elif event.type == pg.KEYDOWN:
            # 그냥 위에서 keys 로 인식하는거랑 event로 처리하는건 무슨 차이가 있는지?
            if event.key == pg.K_z:
                if upgrade_dictionary['power']['count'] < upgrade_dictionary['power']['max'] and coin >= upgrade_dictionary['power']['count'] ** 2:
                    coin -= upgrade_dictionary['power']['count'] ** 2
                    upgrade_dictionary['power']['count'] += 1
                    soul_bear_power += 0.4
            elif event.key == pg.K_x:
                if upgrade_dictionary['speed']['count'] < upgrade_dictionary['speed']['max'] and coin >= upgrade_dictionary['speed']['count'] ** 2:
                    coin -= upgrade_dictionary['speed']['count'] ** 2
                    upgrade_dictionary['speed']['count'] += 1
                    soul_bear_speed += 40
            elif event.key == pg.K_c:
                if upgrade_dictionary['regen']['count'] < upgrade_dictionary['regen']['max'] and coin >= upgrade_dictionary['regen']['count'] ** 2:
                    coin -= upgrade_dictionary['regen']['count'] ** 2
                    upgrade_dictionary['regen']['count'] += 1
                    ore_gen_time -= 1

pg.display.quit()