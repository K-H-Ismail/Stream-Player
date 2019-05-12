# to record a video(any format) film use:
ffmpeg -i ~/film.mp4  -c:v h264 -c:a aac  -strict -2 -f flv "rtmp://localhost:1935/live/" 


# to record pc screen use:
ffmpeg -f x11grab -s `xdpyinfo | grep 'dimensions:'|awk '{print $2}'`  -r 30 -i :0.0 -codec:v libx264 -pix_fmt yuv420p -f flv "rtmp://localhost:1935/live"


# to find out the resolution of the client
`xdpyinfo | grep 'dimensions:'|awk '{print $2}'` 


# webcam 

ffmpeg -f video4linux2 -i /dev/video0 -codec:v libx264 -pix_fmt yuv420p -f flv "rtmp://localhost:1935/live"

# webcam + sound
ffmpeg -f v4l2 -i /dev/video0 -f alsa -i pulse -profile:v high -pix_fmt yuvj420p -level:v 4.1 -preset ultrafast -tune zerolatency -vcodec libx264 -r 10 -b:v 512k -acodec aac -strict -2 -ac 2 -ab 32k -ar 44100 -f mpegts -flush_packets 0 -f flv "rtmp://localhost:1935/live"

