helm repo add nginx-stable https://helm.nginx.com/stable
helm repo update

helm install controller nginx-stable/ingress-nginx --set prometheus.create=true --set prometheus.port=9113
