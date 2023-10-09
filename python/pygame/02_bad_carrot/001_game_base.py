import pygame as pg

pg.init()

width, height = (980, 940)
window = pg.display.set_mode([width, height])
pg.display.set_caption('상한 당근을 싱싱한 당근으로! By 인피니티 스톤')

# 글꼴설정
# print(pg.font.get_fonts())      # 사용 가능한 폰트를 불러오기
font = pg.font.SysFont('malgungothic', 30)

# 이미지 초기화
background_image = pg.image.load('img/carrot_background.png')
background_image = pg.transform.scale(background_image, (width, height))
window.blit(background_image, (0,0))

time_bar = pg.image.load('img/time_bar.png')
time_bar = pg.transform.scale(time_bar, (400, 100))
window.blit(time_bar, (520,20))

carrot = pg.image.load('img/carrot.png')
carrot = pg.transform.scale(carrot, (130, 220))
window.blit(carrot, (200,200))

bad_carrot = pg.image.load('img/bad_carrot.png')
bad_carrot = pg.transform.scale(bad_carrot, (130, 220))
window.blit(bad_carrot, (300,300))

pg.display.update()

play_time = 0
clock = pg.time.Clock()
current_chapter = 1
last_chapterr = 10

while True:
    # 전체 화면을 계속 새로 그려줌
    window.blit(background_image, (0, 0))
    window.blit(time_bar, (520,20))

    after_time = clock.tick(60) / 1000
    play_time += after_time

    # 1분이 넘기 전까지는 소수점 첫째짜리까지만 띄우다가 1분이 넘어가면 분과 초를 모두 띄우는 방식으로 렌더링한다.
    if play_time <= 60:
        time_str = f'{round(play_time, 1)} 초'
    else:
        time_str = f'{int(play_time // 60)}분 {int(play_time % 60)} 초'
    
    time = font.render(time_str, True, (0, 0, 0))
    window.blit(time, (700, 50))

    chapter_str = font.render(f'챕터 : {current_chapter} / {last_chapterr}', True, (255, 255, 255))
    window.blit(chapter_str, (80, 20))

    carrot_str = font.render(f'남은 당근 개수 : 5개', True, (255, 255, 255))
    window.blit(carrot_str, (80, 90))

    pg.display.update()

    for event in pg.event.get():
        if event.type == pg.QUIT:
            pg.display.quit()