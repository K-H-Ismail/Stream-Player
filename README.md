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
rm nginx-1.15.12.tar.gz  

## Download openssl
wget https://www.openssl.org/source/openssl-1.1.1b.tar.gz  
tar -xzvf openssl-1.1.1b.tar.gz   
rm openssl-1.1.1b.tar.gz  

## Build nginx with nginx-rtmp

mkdir ~/nginx  
cd nginx-1.15.12  
./configure --prefix=/home/ikhalfao/nginx --with-openssl=../openssl-1.1.1b --with-http_ssl_module --add-module=../nginx-rtmp-module      
make  
make install  

## Configure your server
change conf/nginx.conf by the conf present in the repo -> mv git/nginx.conf ~/nginx/conf  
create a dir in /tmp called hls and under it hls/live -> mkdir -p "/tmp/hls/live"  

## Add html sources 
to add under ~/nginx/html/  

## Start/stop/reload nginx Server

~/nginx/sbin/nginx  
~/nginx/sbin/nginx -s stop  
~/nginx/sbin/nginx -s reload  

