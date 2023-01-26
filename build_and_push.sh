mvn clean package
docker build . -t epamantontsyrkunou/userservice-1.0.2
docker push epamantontsyrkunou/userservice-1.0.2
#docker run -i -ti --rm -p 7777:7777 \
#--env-file ./kustom.env \
#--name userervice epamantontsyrkunou/userservice-1.0.0

