# Catena-X Portal (Derived from Create React App)

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.\
You will also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can’t go back!**

If you aren’t satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you’re on your own.

You don’t have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn’t feel obligated to use this feature. However we understand that this tool wouldn’t be useful if you couldn’t customize it when you are ready for it.

### Dockerize the Catena-X Portal

There are two Dockerfiles available:
- [Dockerfile](Dockerfile) is the standard build using a "production" npm build which is then injected statically into an nginx server.
- [Dockerfile.develop](Dockerfile.develop) uses a "develop" npm build and server possibly providing more console output.

Both Dockerfiles expose the portal on port 80.

To build the image, use the following command (where $PROXY should be set to your corporate proxy, if any, $REGISTRY points to the deployment environment's docker/container registry and $VERSION hints to the respective deployment version, typically `latest`).

```
docker build -f Dockerfile.develop --build-arg HTTP_PROXY=$PROXY --build-arg HTTPS_PROXY=$PROXY -t $REGISTRY/portal:$VERSION .
```

To push the image to the container registry, use the following command (you need to be logged in using `docker login` or `az acr login`), use the following command

```
docker push $REGISTRY/portal:$VERSION
```

### Deploy the Catena-X Portal

If the portal is not yet registered in k8, the following steps should be taken.

#### Register a second ingress router (public->intern)

$PORTAL_DOMAIN is the domain name of the public-exposed portal service.
$PORTAL_IP is the IP address thats been assigned to the public-exposed portal service

```
helm repo add ingress-nginx https://kubernetes.github.io/ingress-nginx
helm repo update
kubectl create namespace ingress-portal
helm install nginx-ingress ingress-nginx/ingress-nginx \
  --namespace ingress-portal \
  --set controller.replicaCount=1 \
  --set controller.service.loadBalancerIP=$PORTAL_IP \
  --set controller.service.annotations."service\.beta\.kubernetes\.io/azure-dns-label-name"=$PORTAL_DOMAIN \
  --set controller.ingressClass=nginx-portal
```

#### Create the portal service and register in ingress

```
kubectl create namespace portal
kubectl apply -f ../manifests/portal.yaml -n portal
kubectl apply -f ../manifests/portal-ingress.yaml -n portal
```

#### Perform a rollout

If the k8 deployment of the portal in the preceding steps has already been made, rolling out the freshly pushed container is as easy as

`kubectl rollout restart deployment portal -n portal`

## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).
