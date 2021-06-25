FROM node:12-alpine

WORKDIR /
COPY . .

RUN apk add --update nodejs npm
RUN npm install

EXPOSE 80

CMD node server.js