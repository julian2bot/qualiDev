

pour lancer le projet on lance un docker compose dans .devcontainer:

```bash
ubuntu@vps-b0e6239b:~/iut/qualiDev/.devcontainer$ docker compose up -d
```
qui va lancer tout les dockers.

puis on lance dans le conteneur liquibase, et on essaye de faire un update:
```bash

ubuntu@vps-b0e6239b:~/iut/qualiDev/.devcontainer$ docker exec -it qualidev_devcontainer-liquibase-1 bash
# une fois dans le conteneur:
liquibase@7d87206e26b2:~$ liquibase --changeLogFile=master.xml --search-path=/liquibase/changelog update

```




dans le workflow avec plusieurs terminal on lance les services un par un:
```bash

gradle :apps:product-registry-domain-service:quarkusDev

gradle :apps:product-registry-read-service:quarkusDev
gradle :apps:store-back:quarkusDev
pnpm run --filter apps-store-front start
```
et on obtient:
```bash
Watch mode enabled. Watching for file changes...
NOTE: Raw file sizes do not reflect development server per-request transformations.
  ➜  Local:   http://127.0.0.1:4200/
  ➜  press h + enter to show help
```

et on peut aller sur l'url et voir l'application.






































