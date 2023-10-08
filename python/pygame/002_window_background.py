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

# 이미지를 넣어주었으면, display를 업데이트 해주어야 한다.
pg.display.update()


# 마우스를 누르거나, 키보드를 누르는 각 이벤트가 특정 동작 queue에 쌓이며, 해당 이벤트를 while에서 처리하도록 한다.
while True:
    for event in pg.event.get():
        if event.type == pg.QUIT:
            quit()