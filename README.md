# Stream-Player

# Authors
Galizzi Victor,  
Khalfaoui Hassani Ismail,  
Puig Martin,  
Sun Christophe.  

## Download & unpack latest nginx-rtmp 
mkdir ~/build && cd build/
git clone git://github.com/arut/nginx-rtmp-module.git  

## Download nginx

wget https://nginx.org/download/nginx-1.15.12.tar.gz  
tar -xzvf nginx-1.15.12.tar.gz  
rm nginx-1.15.12.tar.gz  

## Download openssl
wget https://www.openssl.org/source/openssl-1.1.1b.tar.gz  
tar -xzvf openssl-1.1.1b.tar.gz   
rm openssl-1.1.1b.tar.gz  

## Build nginx with nginx-rtmp

mkdir ~/nginx  
cd nginx-1.15.12   
./configure --prefix=$HOME/nginx --with-openssl=../openssl-1.1.1b --with-http_ssl_module --add-module=../nginx-rtmp-module     
make (takes few minutes)  
make install  (takes few minutes)  

## Configure your server
change conf/nginx.conf by the conf present in the repo -> mv git/nginx.conf ~/nginx/conf  
create a dir in /tmp called hls and under it hls/live -> mkdir -p "/tmp/hls/live"  

## Start/stop/reload nginx Server

~/nginx/sbin/nginx  
~/nginx/sbin/nginx -s stop  
~/nginx/sbin/nginx -s reload  

## Run the app  
deploy war file on EAP/standalone/deployments and run EAP/bin/standalone on localhost:8080  
run nginx -> ~/nginx/sbin/nginx  (as in the conf it will be ran in localhost:8081)  
firefox http://localhost:8081/stream-player  

## Delete build file  
rm -rf ~/build  


