import pygame as pg

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
window.blit(fish1, (100, 400))

fish2 = pg.image.load("img/fish2.png")
fish2 = pg.transform.scale(fish2, (64, 64))
window.blit(fish2, (200, 300))

score_bar = pg.image.load("img/score_bar.png")
score_bar = pg.transform.scale(score_bar, (250, 74))


time_bar = pg.image.load("img/time_bar.png")
time_bar = pg.transform.scale(time_bar, (200, 55))


# 이미지를 넣어주었으면, display를 업데이트 해주어야 한다.
pg.display.update()

font = pg.font.SysFont('D2Coding', 22, True)
start_time = pg.time.get_ticks()        # init() 을 실행한 후 부터 지난 시간을 millisecond로 저장
print(start_time)
get_fish = 0


# 마우스를 누르거나, 키보드를 누르는 각 이벤트가 특정 동작 queue에 쌓이며, 해당 이벤트를 while에서 처리하도록 한다.
while True:
    after_time = round(pg.time.get_ticks() - start_time / 1000, 1) # 소수점 1번째 자리까지
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