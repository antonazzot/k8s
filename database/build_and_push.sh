docker build . -t epamantontsyrkunou/userdb
docker push epamantontsyrkunou/userdb
docker run -i -ti --rm --name userdb epamantontsyrkunou/userdb

