import pygame as pg
import random
import ex

def game_end():
    window.blit(backgroun_image, (0, 0))
    result = font.render(f'총 {get_fish}마리를 잡았습니다!', True, (0, 0, 0))
    game_end = font.render(f'게임 종료!', True, (0, 0, 0))
    window.blit(result, (170, 550))
    window.blit(game_end, (230, 400))
    pg.display.update()
    end_time = pg.time.get_ticks() + 5000  # 현재 시간 + 5초
    running = True
    while running:
        for event in pg.event.get():
            if event.type == pg.QUIT:  # X 버튼을 클릭하면
                running = False

        if pg.time.get_ticks() >= end_time:  # 5초가 지났으면
            running = False
    quit()

def draw_game_component():
    if len(fish_position) == 0:
        for row in range(70, 520, 90) :
            pg.draw.line(window, (255, 255, 255), (row, 370), (row, height - 30), 3)
            for col in range(370, height - 30, 80):
                pg.draw.line(window, (255, 255, 255), (70, col), (520, col), 3)
                fish_position.append((row + 10, col + 10))
        pg.draw.line(window, (255, 255, 255), (520, 370), (520, height - 30), 3)
        pg.draw.line(window, (255, 255, 255), (70, height - 30), (520, height - 30), 3)
    else:
        for row in range(70, 520, 90) :
            pg.draw.line(window, (255, 255, 255), (row, 370), (row, height - 30), 3)
            for col in range(370, height - 30, 80):
                pg.draw.line(window, (255, 255, 255), (70, col), (520, col), 3)
        pg.draw.line(window, (255, 255, 255), (520, 370), (520, height - 30), 3)
        pg.draw.line(window, (255, 255, 255), (70, height - 30), (520, height - 30), 3)

pg.init()

width = 600
height = 800

window = pg.display.set_mode((width, height))

pg.display.set_caption('fishing game')

backgroun_image = pg.image.load("img/background.png")
backgroun_image = pg.transform.scale(backgroun_image, (width, height))
# 좌표 기준으로 이미지를 (0, 0) 위치에 두어야 해당 위치 기준으로 이미지가 놓아지는 형태이다.
window.blit(backgroun_image, (0, 0))


fish1 = pg.image.load("img/fish1.png")
fish1 = pg.transform.scale(fish1, (64, 64))

fish2 = pg.image.load("img/fish2.png")
fish2 = pg.transform.scale(fish2, (64, 64))

score_bar = pg.image.load("img/score_bar.png")
score_bar = pg.transform.scale(score_bar, (250, 74))


time_bar = pg.image.load("img/time_bar.png")
time_bar = pg.transform.scale(time_bar, (200, 55))

fish_list = [fish1, fish2]
fish_position = []

draw_game_component()

print(fish_position)
selected_fish_position = random.sample(fish_position, 5)
fish_answer_position = []

for position in range(5) :
    random_fish = random.choice(fish_list)
    fish_coordinate = random_fish.get_rect(topleft=(selected_fish_position[position][0], selected_fish_position[position][1]))
    fish_answer_position.append(fish_coordinate)
    window.blit(random_fish, fish_coordinate)

# 이미지를 넣어주었으면, display를 업데이트 해주어야 한다.
pg.display.update()

font = pg.font.SysFont('D2Coding', 22, True)
start_time = pg.time.get_ticks()        # init() 을 실행한 후 부터 지난 시간을 millisecond로 저장
get_fish = 0
click_count = 10

# 마우스를 누르거나, 키보드를 누르는 각 이벤트가 특정 동작 queue에 쌓이며, 해당 이벤트를 while에서 처리하도록 한다.
while True:
    after_time = round((pg.time.get_ticks() - start_time) / 1000, 1) # 소수점 1번째 자리까지

    if after_time >= 10 or click_count == 0:
        game_end()

    window.blit(score_bar, (350, 2))
    window.blit(time_bar, (0, 10))

    time = font.render(f'{after_time} 초', True, (0, 0, 0)) # 색깔을 RGB 값으로 지정     
    window.blit(time, (40, 28))

    fish_score = font.render(f'{get_fish} 마리', True, (0, 0, 0))
    window.blit(fish_score, (450, 28))

    pg.display.update()

    for event in pg.event.get():
        if event.type == pg.QUIT:
            quit()
        elif event.type == pg.MOUSEBUTTONDOWN:
            click_count -= 1
            mouse = pg.mouse.get_pos()  # 마우스의 위치를 파악

            for point in fish_answer_position:
                if point.collidepoint(mouse):
                    # mouse 위치가 정답 위치 안에 있다면
                    fish_answer_position.remove(point)
                    get_fish += 1
                    window.blit(backgroun_image, (0, 0))

                    draw_game_component()

                    if len(fish_answer_position) == 0:
                        selected_fish_position = random.sample(fish_position, 5)

                        for position in range(5):
                            random_fish = random.choice(fish_list)
                            fish_coordinate = random_fish.get_rect(topleft=(selected_fish_position[position][0], selected_fish_position[position][1]))
                            window.blit(random_fish, fish_coordinate)
                            fish_answer_position.append(fish_coordinate)
                        click_count = 10
                        continue


                    selected_fish_position = random.sample(fish_position, len(fish_answer_position))
                    fish_answer_poision2 = []
                    for position in range(len(fish_answer_position)):
                        random_fish = random.choice(fish_list)
                        fish_coordinate = random_fish.get_rect(topleft=(selected_fish_position[position][0], selected_fish_position[position][1]))
                        window.blit(random_fish, fish_coordinate)
                        fish_answer_poision2.append(fish_coordinate)
                    fish_answer_position = []
                    fish_answer_position.extend(fish_answer_poision2)

                    # 광클하다가 아직 반영되지 않은 게임 데이터가 실제 게임에 적용되어서는 안되기 때문에, 더미 데이터에 넣고 처리가 끝난 후 복붙해준다.

                    