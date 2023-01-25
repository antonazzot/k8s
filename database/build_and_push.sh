docker build . -t epamantontsyrkunou/userdb
docker push epamantontsyrkunou/userdb
docker run -i -ti --rm -p 5433:5432 --name userdb epamantontsyrkunou/userdb

