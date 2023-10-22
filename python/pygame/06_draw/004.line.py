import pygame as pg


# circle (surface, color, center, radius, width)
# 

pg.init()

width = 600
height = 800

window = pg.display.set_mode((width, height))

pg.draw.line(window, (255, 0, 0), (100, 50), (100, 200))
pg.draw.line(window, (0, 255, 0), (200, 50), (200, 200), 1)
pg.draw.line(window, (255, 255, 255), (300, 50), (300, 200), 5)


for i in range(10) :
    pg.draw.line(window, (255, 255, 255), (50, 300 + 10 * i), (200, 300 + 10 * i), 3)
    pg.draw.line(window, (255, 255, 255), (50 + 30 * i, 300), (50 + 30 * i, 500), 3)

pg.display.update()

while True:
    for event in pg.event.get():
        if event.type == pg.QUIT:
            quit()