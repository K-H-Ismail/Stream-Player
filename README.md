# Stream-Player

# Authors
Galizzi Victor,  
Khalfaoui Hassani Ismail,  
Puig Martin,  
Sun Christophe.  

## Download & unpack latest nginx-rtmp 
git clone git://github.com/arut/nginx-rtmp-module.git  

## Download nginx

wget https://nginx.org/download/nginx-1.15.12.tar.gz  
tar -xzvf nginx-1.15.12.tar.gz  
cd nginx-1.15.12  
## Build nginx with nginx-rtmp

sudo ./configure --with-http_ssl_module --add-module=../nginx-rtmp-module  
sudo make  
sudo make install  

## Configure your server
change /usr/local/nginx/conf/nginx.conf by the conf present  
in the repo (create a dir in /tmp called hls and under it hls/live)  

## Add html sources 
under /usr/local/nginx/html/  

## Start/stop/reload nginx Server

sudo /usr/local/nginx/sbin/nginx  
sudo /usr/local/nginx/sbin/nginx -s stop  
sudo /usr/local/nginx/sbin/nginx -s reload  

