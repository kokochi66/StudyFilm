import pygame as pg

def game_end():
    # window.blit(backgroun_image, (0, 0))
    # result = font.render(f'총 {get_fish}마리를 잡았습니다!', True, (0, 0, 0))
    # game_end = font.render(f'게임 종료!', True, (0, 0, 0))
    # window.blit(result, (170, 550))
    # window.blit(game_end, (230, 400))
    pg.display.update()
    pg.time.delay(5000)
    quit()