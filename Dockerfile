FROM openjdk:17-jdk-slim
LABEL authors="farajzada"

ENTRYPOINT ["top", "-b"]