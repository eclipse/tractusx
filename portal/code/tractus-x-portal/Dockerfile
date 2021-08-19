# Step 1
FROM node:10-alpine as build-step

RUN mkdir /app

WORKDIR /app

COPY ["package.json", "package-lock.json", "./"]

RUN npm install 
# should be --production

COPY . .

EXPOSE 3000

CMD ["npm", "start"]