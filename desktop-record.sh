ffmpeg -f x11grab -s 1366x768 -r 30 -i :0.0 -f alsa -i pulse -vcodec libx264 ~/test.mp4

