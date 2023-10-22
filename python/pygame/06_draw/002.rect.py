import pygame as pg

# color (int, int, int, int)
# left top width height 순으로 작성되며, (left, top), (width, height) 로 묶어줄 수도 있음

pg.init()

width = 600
height = 800

window = pg.display.set_mode((width, height))

pg.draw.rect(window, (255, 255, 255), (100, 100, 50, 50))
pg.draw.rect(window, (255, 255, 255), (200, 100, 50, 50), 1)
pg.draw.rect(window, (255, 255, 255), (300, 100, 50, 50), 5)

pg.display.update()

while True:
    for event in pg.event.get():
        if event.type == pg.QUIT:
            quit()