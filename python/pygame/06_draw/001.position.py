import pygame as pg

pg.init()

width = 600
height = 800

window = pg.display.set_mode((width, height))
rect = pg.Rect(300, 300, 100, 50) # x pos, y pos, width, height

rect.left = 400
print(f'사각형의 left : {rect.left}, right : {rect.right}, top : {rect.top}, bottom : {rect.bottom}')

pg.draw.rect(window, (0, 0, 255), rect, 5)

pg.display.update()

while True:
    for event in pg.event.get():
        if event.type == pg.QUIT:
            quit()