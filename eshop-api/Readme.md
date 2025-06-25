# Gerar a imagem docker
docker build -t cleytonscherer/eshop-api .

# Executar a imagem docker cleytonscherer/eshop-api
docker run --name eshop-api --network host cleytonscherer/eshop-api

# Criando uma rede local do tipo bridge
docker network create --driver bridge rede_local

# Disponibiliza a api na porta 8080 local
docker run -p 8080:8080 cleytonscherer/eshop-api