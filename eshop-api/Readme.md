# Gerar a imagem docker
docker build -t cleytonscherer/eshop-api .

# Executar a imagem docker cleytonscherer/eshop-api
docker run cleytonscherer/eshop-api

# Criando uma rede local do tipo bridge
docker network create --driver bridge rede_local