FROM openjdk:11-jre-slim

WORKDIR /app

COPY . .


EXPOSE 8081
EXPOSE 25577

CMD [ "cd Eaglercraft; ./run.sh" ] 