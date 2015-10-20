# VSP

## Wie führe ich das Programm in Docker aus
Den Container erstellen per:
``docker build -t vsp1 .``

Die alte Docker-Maschine anhalten (falls vorhanden):
``docker stop vsp``

Die alte Docker-Maschine löschen (falls vorhanden):
``docker rm vsp``

Den neuen Container starten:
``docker run -p 8080 --name vsp -t vsp1``

Die IP-Addresse herausfinden:
``docker inspect vsp | grep IPAddress``


Aus dem letzten Step die IP-Addresse aufrufen per "http://<ip>:8080/"
