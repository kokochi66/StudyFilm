import pygame as pg

def create_sprite(image, pos):
    sprite = pg.sprite.Sprite()
    sprite.image = image
    sprite.rect = sprite.image.get_rect()
    sprite.rect.x, sprite.rect.y = pos[0], pos[1]


pg.init()

run = True
width, height = 500, 500
window = pg.display.set_mode([width, height])
pg.display.set_caption('부족들의 마음을 요리로 사로잡아라!')

javadoc_image_size = (238, 238)
javadoc_image = pg.image.load('img/javadoc_default.png')
javadoc_image = pg.transform.scale(javadoc_image, javadoc_image_size)

javadoc_sprite = create_sprite(javadoc_image, (150, 150))
window.blit(javadoc_sprite.image, (javadoc_sprite.rect.x, javadoc_sprite.rect.y))

while run:

    pg.display.update()

    for event in pg.event.get():
        if event.type == pg.QUIT:
            run = False