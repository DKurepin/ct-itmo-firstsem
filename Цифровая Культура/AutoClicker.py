import mouse
import keyboard as key
from time import sleep

startK = 'o'
stopK = 'k'

while True:
    if key.is_pressed(startK):
        while True:
            sleep(0.04)
            mouse.double_click(button = 'left')
            if key.is_pressed(stopK):
                break
