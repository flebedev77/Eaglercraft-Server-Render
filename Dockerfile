FROM ubuntu:20.04

WORKDIR /app

COPY . .

RUN apt update
RUN apt install default-jre -y

EXPOSE 8081
EXPOSE 25577

CMD [ "cd Eaglercraft; ./run.sh" ] 