import pygame as pg


# polygon (surface, color, points, width)
# (x1, y1), (x2, y2), (x3, y3)

pg.init()

width = 600
height = 800

window = pg.display.set_mode((width, height))

list = [(300, 300), (100, 500), (500, 500)]

pg.draw.polygon(window, (255, 255, 255), list, 3)
pg.display.update()

while True:
    for event in pg.event.get():
        if event.type == pg.QUIT:
            quit()