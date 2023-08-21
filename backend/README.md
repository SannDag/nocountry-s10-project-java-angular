<h2 align="center">
  Cashnow ☕Backend
</h2>
<h3 align="center">
  S10-14-FT-Java-Angular
</h3>

Virtual Marchine en Azure Cloud

1 - Update the apt package index and install packages to allow apt to use a repository over HTTPS:
#sudo apt-get update

2 - Add Docker’s official GPG key:
#sudo install -m 0755 -d /etc/apt/keyrings
#curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
#sudo chmod a+r /etc/apt/keyrings/docker.gpg

3 - Use the following command to set up the repository:
#echo \
  "deb [arch="$(dpkg --print-architecture)" signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu \
  "$(. /etc/os-release && echo "$VERSION_CODENAME")" stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

4 - To install the latest version, run:
#sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
#sudo apt-get install apt-transport-https ca-certificates curl software-properties-common
#curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
#sudo add-apt-repository "deb [arch = amd64] https://download.docker.com/linux/ubuntu $ (lsb_release -cs) estable"

5 - Update the apt package
#sudo apt-get update

6 - Install Docker
#sudo apt-get install docker

7 - Install Docker Compose
#sudo apt install docker-compose

8 - Install Databases in Docker
#sudo docker-compose -f compose-database-gcp.yml up

9 - Install Services in Docker
#sudo docker compose -f compose-service-gcp.yml up


