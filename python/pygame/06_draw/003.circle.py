import pygame as pg


# circle (surface, color, center, radius, width)
# 

pg.init()

width = 600
height = 800

window = pg.display.set_mode((width, height))

pg.draw.circle(window, (255, 255, 255), (100, 100), 10)
pg.draw.circle(window, (255, 255, 255), (200, 100), 30)
pg.draw.circle(window, (255, 255, 255), (300, 100), 50)

pg.display.update()

while True:
    for event in pg.event.get():
        if event.type == pg.QUIT:
            quit()