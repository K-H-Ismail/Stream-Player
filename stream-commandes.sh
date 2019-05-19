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


# to record all of that with webcam overlay in bottom

ffmpeg -f alsa -i pulse -f x11grab -s `xdpyinfo | grep 'dimensions:'|awk '{print $2}'`  -r 30 -i :0.0+0,0 -vf "movie=/dev/video0:f=video4linux2, scale=240:-1, fps, setpts=PTS-STARTPTS [movie]; [in][movie] overlay=main_w-overlay_w-2:main_h-overlay_h-2 [out]" -vcodec libx264 -crf 20 -preset veryfast -minrate 150k -maxrate 500k -s 960x540 -acodec aac -ar 44100 -ab 96000 -threads 0 -f flv - | tee name.flv | ffmpeg -i - -codec copy -f flv -metadata streamName=livestream "rtmp://localhost:1935/live"
