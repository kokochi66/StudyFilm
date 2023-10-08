import pygame as pg

pg.init()

width = 600
height = 800

window = pg.display.set_mode((width, height))

# 마우스를 누르거나, 키보드를 누르는 각 이벤트가 특정 동작 queue에 쌓이며, 해당 이벤트를 while에서 처리하도록 한다.
while True:
    for event in pg.event.get():
        if event.type == pg.QUIT:
            quit()