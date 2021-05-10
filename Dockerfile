FROM amazoncorretto:11
COPY /backend/build/install/backend /backend
COPY /frontend/dist /frontend
ENTRYPOINT /backend/bin/backend
