FROM amazoncorretto:11
COPY /backend/build/install/backend /backend
ENTRYPOINT /backend/bin/backend
