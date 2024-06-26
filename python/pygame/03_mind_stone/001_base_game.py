import pygame as pg

def create_sprite(image, pos):
    sprite = pg.sprite.Sprite()
    sprite.image = image
    sprite.rect = sprite.image.get_rect()
    sprite.rect.x , sprite.rect.y = pos[0], pos[1]
    return sprite

def create_image(image, size):
    result = pg.image.load(image)
    result = pg.transform.scale(result, size)
    return result

def display(image, pos):
    window.blit(image, pos)

pg.init()

run = True
width, height= 874, 987
window = pg.display.set_mode([width, height])
pg.display.set_caption('부족들의 마음을 요리로 사로잡아라!')


# 색 지정
color_white = (255, 255, 255)
color_black = (0, 0, 0)

font = pg.font.SysFont('malgungothic', 25)

# 게임 요소 초기화
play_time = 0
game_score = 0
clock = pg.time.Clock()

current_chapter = 1
last_chapter = 10

food_init_pos = [424, 248]
food_pos = [food_init_pos[0] - 53, food_init_pos[1] - 30]

person_row, person_col = 4, 2

food_status_list = ['before', 'after', 'after_catch']
food_list = ['feed', 'bone', 'water']
person_status_list = ['bad', 'good', 'think']

javadoc = {
    'status': 'default',
    'index': 0,
    'flow': 1,
    'current_food': 'feed',
    'current_food_status': 'before',
}
javadoc_status_list = ['default', 'bone', 'feed', 'water']


# 이미지 생성

image_size_dictionary = {
    'background': (width, height),
    'chapter_bar': (358, 61),
    'javadoc': (238, 238),
    'kitchen_table': (668, 173),
    'feed': (106, 61),
    'bone': (106, 61),
    'water': (106, 61),
    'person': (196, 314)
}
image_dictionary = {
    'kitchen_table': {},
}
sprite_dictionary = {
}

image_dictionary['background'] = create_image('img/background_image.png', image_size_dictionary['background'])
image_dictionary['chapter_bar'] = create_image('img/chapter_bar.png', image_size_dictionary['chapter_bar'])

image_dictionary['kitchen_table']['1'] = create_image('img/kitchen_table_1.png', image_size_dictionary['kitchen_table'])

for food_status in food_status_list:
    image_dictionary[food_status] = {}
    for food in food_list:
        image_dictionary[food_status][food] = create_image(f'img/{food}_{food_status}.png',image_size_dictionary[food])

sprite_dictionary['food'] = create_sprite(image_dictionary['before'][javadoc['current_food']], food_pos)

image_dictionary['person'] = {}
for person_status in person_status_list:
    image_dictionary['person'][person_status] = create_image(f'img/person_{person_status}.png', image_size_dictionary['person'])

sprite_dictionary['person'] = [create_sprite(image_dictionary['person']['think'], (50 + image_size_dictionary['person'][0] * j,
    350 + image_size_dictionary['person'][1] * i)) for i in range(person_col) for j in range(person_row)]

image_dictionary['javadoc'] = {}
image_dictionary['javadoc']['default'] = create_image('img/javadoc_default.png', image_size_dictionary['javadoc'])
for food in food_list:
    for i in range(3):
        image_dictionary['javadoc'][food] = [create_image(f'img/javadoc_{food}_cooking_{i + 1}.png', image_size_dictionary['javadoc']) for i in range(3)]
sprite_dictionary['javadoc'] = [create_sprite]



cooking_animation = {
    'animation_max_time': 0.2,
    'animation_time': 0,
    'animation_max_count': 3,
    'animation_count': 0
}

while run:

    if current_chapter <= last_chapter:

        after_time = clock.tick(60) / 1000
        play_time += after_time

        play_time_str = '%02d:%02d' % (after_time / 60, after_time / 60)
        play_time_font = font.render(play_time_str, True, color_black)

        chapter_str = f'{current_chapter}챕터'
        chapter_font = font.render(chapter_str, True, color_white)

        score_str = f'{game_score}점'
        score_font = font.render(score_str, True, color_black)
        

        display(image_dictionary['background'], (0, 0))
        display(image_dictionary['chapter_bar'], ((width - image_dictionary['chapter_bar'].get_size()[0]) // 2, 7))

        if javadoc['status'] == 'default':
            display(image_dictionary['javadoc'][javadoc['status']], (321, 85))
        else:
            display(image_dictionary['javadoc'][javadoc['status']][javadoc['index']], (321, 85))


        display(image_dictionary['kitchen_table']['1'], (100, 192))

        display(play_time_font, (20, 20))
        display(chapter_font, ((width - 14 * len(chapter_str)) // 2 - 10, 20))
        display(score_font, ((width - 14 * len(score_str)) - 30, 20))

        for person_sprite in sprite_dictionary['person']:
            display(person_sprite.image, person_sprite.rect)

        for index, food in enumerate(food_list):
            display(image_dictionary['after'][food], (460 + 90 * index, 280 - image_size_dictionary[food][1]))

        sprite_dictionary['food'].image = image_dictionary[javadoc['current_food_status']][javadoc['current_food']]
        sprite_dictionary['food'].rect.x, sprite_dictionary['food'].rect.y = food_pos[0], food_pos[1]
        display(sprite_dictionary['food'].image, sprite_dictionary['food'].rect)
    else:
        window.fill(color_white)


    pg.display.update()

    for event in pg.event.get():
        if event.type == pg.QUIT:
            run = False

    # 입력되는 키가 어떤것인지를 파악하기
    keys = pg.key.get_pressed()
    # print(keys)
    if keys[pg.K_SPACE]:
        if javadoc['status'] == 'default':
            javadoc['status'] = javadoc['current_food']
        else:
            cooking_animation['animation_time'] += after_time
            if cooking_animation['animation_time'] > cooking_animation['animation_max_time']:
                cooking_animation['animation_time'] = 0
                javadoc['index'] += javadoc['flow']
                if javadoc['index'] == 0 or javadoc['index'] == len(image_dictionary['javadoc'][javadoc['current_food']]) - 1:
                    javadoc['flow'] *= -1
                    cooking_animation['animation_count'] += 1
                    if cooking_animation['animation_count'] > cooking_animation['animation_max_count']:
                        javadoc['current_food_status'] = 'after'
    else:
        cooking_animation['animation_time'] = 0
        javadoc['status'] = 'default'
        javadoc['index'] = 0
        javadoc['flow'] = 1
        cooking_animation['animation_count'] = 0

pg.display.quit()