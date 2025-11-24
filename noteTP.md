c'est juste un fichier avec tout mes commandes et resultats de celle ci; voir ![noteTp]{noteTP.md} pour le contenu complet, commandes a faire pour correctement lancer tout les sercives etc

dans .devcontainer:
    docker compose up -d

```bash
ubuntu@vps-b0e6239b:~/iut/qualiDev/.devcontainer$ docker compose up -d
[+] Building 0.2s (27/27) FINISHED                                                                                    
 => [internal] load local bake definitions                                                                       0.0s
 => => reading from stdin 529B                                                                                   0.0s
 => [internal] load build definition from Dockerfile                                                             0.0s
 => => transferring dockerfile: 1.74kB                                                                           0.0s
 => [internal] load metadata for docker.io/library/debian:trixie-slim                                            0.0s
 => [internal] load .dockerignore                                                                                0.0s
 => => transferring context: 2B                                                                                  0.0s
 => [ 1/21] FROM docker.io/library/debian:trixie-slim                                                            0.0s
 => CACHED [ 2/21] RUN apt update                                                                                0.0s
 => CACHED [ 3/21] RUN apt install -y git curl wget unzip zip                                                    0.0s
 => CACHED [ 4/21] RUN curl -s "https://get.sdkman.io" | bash                                                    0.0s
 => CACHED [ 5/21] RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install java 21.0.8-tem"          0.0s
 => CACHED [ 6/21] RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install gradle 8.14.3"            0.0s
 => CACHED [ 7/21] RUN bash -c "source $HOME/.sdkman/bin/sdkman-init.sh && sdk install quarkus 3.26.1"           0.0s
 => CACHED [ 8/21] RUN apt install -y gcc zlib1g-dev                                                             0.0s
 => CACHED [ 9/21] RUN curl -fsSL https://deb.nodesource.com/setup_24.x -o nodesource_setup.sh                   0.0s
 => CACHED [10/21] RUN bash nodesource_setup.sh                                                                  0.0s
 => CACHED [11/21] RUN apt install -y nodejs                                                                     0.0s
 => CACHED [12/21] RUN corepack enable pnpm                                                                      0.0s
 => CACHED [13/21] RUN corepack use pnpm@10.11.0                                                                 0.0s
 => CACHED [14/21] RUN apt install -y ca-certificates                                                            0.0s
 => CACHED [15/21] RUN install -m 0755 -d /etc/apt/keyrings                                                      0.0s
 => CACHED [16/21] RUN curl -fsSL https://download.docker.com/linux/debian/gpg -o /etc/apt/keyrings/docker.asc   0.0s
 => CACHED [17/21] RUN chmod a+r /etc/apt/keyrings/docker.asc                                                    0.0s
 => CACHED [18/21] RUN echo   "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] h  0.0s
 => CACHED [19/21] RUN apt update                                                                                0.0s
 => CACHED [20/21] RUN apt install -y docker-ce-cli                                                              0.0s
 => CACHED [21/21] RUN apt install -y libxtst6 graphviz libxi6                                                   0.0s
 => exporting to image                                                                                           0.0s
 => => exporting layers                                                                                          0.0s
 => => writing image sha256:ff16b8cb981bbd83fe6f88858aa9337d754813cf104aba3bf44bd66416f97f46                     0.0s
 => => naming to docker.io/library/devcontainer-dev                                                              0.0s
 => resolving provenance for metadata file                                                                       0.0s
[+] Running 7/7
 ✔ devcontainer-dev                     Built                                                                    0.0s 
 ✔ Network devcontainer_dev             Created                                                                  0.1s 
 ✔ Volume devcontainer_postgres-data    Created                                                                  0.0s 
 ✔ Volume devcontainer_gradle-deps      Created                                                                  0.0s 
 ✔ Container devcontainer-dev-1         Started                                                                  0.3s 
 ✔ Container devcontainer-liquibase-1   Started                                                                  0.3s 
 ✔ Container devcontainer-postgresql-1  Started                                                                  0.3s 
```

```bash

ubuntu@vps-b0e6239b:~/iut/qualiDev/.devcontainer$ docker exec -it qualidev_devcontainer-liquibase-1 bash
liquibase@7d87206e26b2:~$ liquibase update
####################################################
##   _     _             _ _                      ##
##  | |   (_)           (_) |                     ##
##  | |    _  __ _ _   _ _| |__   __ _ ___  ___   ##
##  | |   | |/ _` | | | | | '_ \ / _` / __|/ _ \  ##
##  | |___| | (_| | |_| | | |_) | (_| \__ \  __/  ##
##  \_____/_|\__, |\__,_|_|_.__/ \__,_|___/\___|  ##
##              | |                               ##
##              |_|                               ##
##                                                ## 
##  Get documentation at docs.liquibase.com       ##
##  Get certified courses at learn.liquibase.com  ## 
##                                                ##
####################################################
Starting Liquibase at 08:24:37 using Java 21.0.8 (version 4.33.0 #8744 built at 2025-07-08 20:43+0000)
Liquibase Version: 4.33.0
Liquibase Open Source 4.33.0 by Liquibase
Error parsing command line: Invalid argument '--changelog-file': missing required argument. If you need to configure new liquibase project files and arguments, run the 'liquibase init project' command.

For detailed help, try 'liquibase --help' or 'liquibase <command-name> --help'
liquibase@7d87206e26b2:~$ exit
exit
ubuntu@vps-b0e6239b:~/iut/qualiDev/.devcontainer$ docker exec -it qualidev_devcontainer-dev-1 bash
root@9788a4e08872:/# ls
app    dev                gradlew      lib64         nodesource_setup.sh  proc  settings.gradle  usr
bin    etc                gradlew.bat  media         opt                  root  srv              var
boot   gradle             home         mnt           package.json         run   sys              vscode
build  gradle.properties  lib          node_modules  pnpm-lock.yaml       sbin  tmp              workspace
root@9788a4e08872:/# ls apps/product-registry-domain-service
ls: cannot access 'apps/product-registry-domain-service': No such file or directory
root@9788a4e08872:/# ls app/ 
build.gradle  src
root@9788a4e08872:/# cd /workspace

root@9788a4e08872:/workspace# ls
COPYRIGHT  apps          doc                gradlew      noteTP.md       pnpm-workspace.yaml
LICENSE    build.gradle  gradle             gradlew.bat  package.json    r5.08-quali-dev-td-tp-master.zip
README.md  ci            gradle.properties  libs         pnpm-lock.yaml  settings.gradle
root@9788a4e08872:/workspace# cd /workspace/apps/product-registry-domain-service
root@9788a4e08872:/workspace/apps/product-registry-domain-service# ../../gradlew :apps:product-registry-domain-service:quarkusDev

> Configure project :libs:cqrs-support
Jandex Gradle plugin 2.3.0. Consider becoming a patron at https://www.patreon.com/aalmiray
<-------------> 0% EXECUTING [5s]
> :libs:cqrs-support:compileJava

```

en parallele dans le terminal liquibase
```bash
ubuntu@vps-b0e6239b:~/iut/qualiDev$ docker exec -it qualidev_devcontainer-liquibase-1 bash
liquibase@7d87206e26b2:~$ 
liquibase@7d87206e26b2:~$ ls /liquibase/changelog
master.xml  platform  product-registry
liquibase@7d87206e26b2:~$ liquibase --changeLogFile=/liquibase/changelog/db.changelog-master.xml update
####################################################
##   _     _             _ _                      ##
##  | |   (_)           (_) |                     ##
##  | |    _  __ _ _   _ _| |__   __ _ ___  ___   ##
##  | |   | |/ _` | | | | | '_ \ / _` / __|/ _ \  ##
##  | |___| | (_| | |_| | | |_) | (_| \__ \  __/  ##
##  \_____/_|\__, |\__,_|_|_.__/ \__,_|___/\___|  ##
##              | |                               ##
##              |_|                               ##
##                                                ## 
##  Get documentation at docs.liquibase.com       ##
##  Get certified courses at learn.liquibase.com  ## 
##                                                ##
####################################################
Starting Liquibase at 08:29:19 using Java 21.0.8 (version 4.33.0 #8744 built at 2025-07-08 20:43+0000)
Liquibase Version: 4.33.0
Liquibase Open Source 4.33.0 by Liquibase
ERROR: Exception Details
ERROR: Exception Primary Class:  ChangeLogParseException
ERROR: Exception Primary Reason:  The file /liquibase/changelog/db.changelog-master.xml was not found in the configured search path:
    - /liquibase
    - /liquibase/internal/lib/liquibase-core.jar
    - /liquibase/lib
    - /liquibase/internal/lib/picocli.jar
    - /liquibase/internal/lib/snowflake-jdbc.jar
    - /liquibase/internal/lib/mssql-jdbc.jar
    - /liquibase/internal/lib/mariadb-java-client.jar
    - /liquibase/internal/lib/slf4j-api.jar
    - /liquibase/internal/lib/commons-lang3.jar
    - /liquibase/internal/lib/jaxb-api.jar
    - /liquibase/internal/lib/jaxb-runtime.jar
    - /liquibase/internal/lib/snakeyaml.jar
    - /liquibase/internal/lib/opencsv.jar
    - /liquibase/internal/lib/commons-collections4.jar
    - /liquibase/internal/lib/jaybird.jar
    - /liquibase/internal/lib/commons-io.jar
    - /liquibase/internal/lib/ojdbc8.jar
    - /liquibase/internal/lib/liquibase-commercial.jar
    - /liquibase/internal/lib/jcc.jar
    - /liquibase/internal/lib/commons-text.jar
    - /liquibase/internal/lib/postgresql.jar
    - /liquibase/internal/lib/jaxb-core.jar
    - /liquibase/internal/lib/hsqldb.jar
    - /liquibase/internal/lib/h2.jar
    - /liquibase/internal/lib/sqlite-jdbc.jar
    - /liquibase/internal/lib/slf4j-nop.jar
    - /liquibase/internal/lib
    - /liquibase/internal/extensions/liquibase-commercial-bigquery.jar
    - /liquibase/internal/extensions/liquibase-checks.jar
    - /liquibase/internal/extensions
More locations can be added with the 'searchPath' parameter.
ERROR: Exception Primary Source:  4.33.0

Unexpected error running Liquibase: The file /liquibase/changelog/db.changelog-master.xml was not found in the configured search path:
    - /liquibase
    - /liquibase/internal/lib/liquibase-core.jar
    - /liquibase/lib
    - /liquibase/internal/lib/picocli.jar
    - /liquibase/internal/lib/snowflake-jdbc.jar
    - /liquibase/internal/lib/mssql-jdbc.jar
    - /liquibase/internal/lib/mariadb-java-client.jar
    - /liquibase/internal/lib/slf4j-api.jar
    - /liquibase/internal/lib/commons-lang3.jar
    - /liquibase/internal/lib/jaxb-api.jar
    - /liquibase/internal/lib/jaxb-runtime.jar
    - /liquibase/internal/lib/snakeyaml.jar
    - /liquibase/internal/lib/opencsv.jar
    - /liquibase/internal/lib/commons-collections4.jar
    - /liquibase/internal/lib/jaybird.jar
    - /liquibase/internal/lib/commons-io.jar
    - /liquibase/internal/lib/ojdbc8.jar
    - /liquibase/internal/lib/liquibase-commercial.jar
    - /liquibase/internal/lib/jcc.jar
    - /liquibase/internal/lib/commons-text.jar
    - /liquibase/internal/lib/postgresql.jar
    - /liquibase/internal/lib/jaxb-core.jar
    - /liquibase/internal/lib/hsqldb.jar
    - /liquibase/internal/lib/h2.jar
    - /liquibase/internal/lib/sqlite-jdbc.jar
    - /liquibase/internal/lib/slf4j-nop.jar
    - /liquibase/internal/lib
    - /liquibase/internal/extensions/liquibase-commercial-bigquery.jar
    - /liquibase/internal/extensions/liquibase-checks.jar
    - /liquibase/internal/extensions
More locations can be added with the 'searchPath' parameter.

For more information, please use the --log-level flag
liquibase@7d87206e26b2:~$ 



liquibase@7d87206e26b2:~$ liquibase --changeLogFile=master.xml --search-path=/liquibase/changelog update
####################################################
##   _     _             _ _                      ##
##  | |   (_)           (_) |                     ##
##  | |    _  __ _ _   _ _| |__   __ _ ___  ___   ##
##  | |   | |/ _` | | | | | '_ \ / _` / __|/ _ \  ##
##  | |___| | (_| | |_| | | |_) | (_| \__ \  __/  ##
##  \_____/_|\__, |\__,_|_|_.__/ \__,_|___/\___|  ##
##              | |                               ##
##              |_|                               ##
##                                                ##
##  Get documentation at docs.liquibase.com       ##
##  Get certified courses at learn.liquibase.com  ##
##                                                ##
####################################################
Starting Liquibase at 13:40:37 using Java 21.0.8 (version 4.33.0 #8744 built at 2025-07-08 20:43+0000)
Liquibase Version: 4.33.0
Liquibase Open Source 4.33.0 by Liquibase
Running Changeset: platform/main-changelog.xml::platform-000-init::t.faurie
Running Changeset: platform/main-changelog.xml::platform-001-init-schemas::t.faurie
Running Changeset: platform/main-changelog.xml::platform-002-eventlog::t.faurie
Running Changeset: platform/main-changelog.xml::platform-003-outbox::t.faurie
Running Changeset: product-registry/domain-changelog.xml::prd-001-products::t.faurie
Running Changeset: product-registry/read-changelog.xml::prd-read-000-schema::t.faurie
Running Changeset: product-registry/read-changelog.xml::prd-read-001-tables::t.faurie
Running Changeset: product-registry/read-changelog.xml::prd-read-999-update-rights::t.faurie
Running Changeset: master.xml::platform-999-update-rights::t.faurie

UPDATE SUMMARY
Run:                          9
Previously run:               0
Filtered out:                 0
-------------------------------
Total change sets:            9

Liquibase: Update has been successful. Rows affected: 0
Liquibase command 'update' was executed successfully.
liquibase@7d87206e26b2:~$
```



dans le workflow:
```bash
root@8bfcdce7a06b:/workspace# gradle :apps:product-registry-domain-service:quarkusDev

Welcome to Gradle 8.14.3!

Here are the highlights of this release:
 - Java 24 support
 - GraalVM Native Image toolchain selection
 - Enhancements to test reporting
 - Build Authoring improvements

For more details see https://docs.gradle.org/8.14.3/release-notes.html


> Configure project :libs:cqrs-support
Jandex Gradle plugin 2.3.0. Consider becoming a patron at https://www.patreon.com/aalmiray

----------------------------
--- Help improve Quarkus ---
----------------------------
* Learn more: https://quarkus.io/usage/
* Do you agree to contribute anonymous build time data to the Quarkus community? (y/n and enter) 

> Task :apps:product-registry-domain-service:quarkusDev
[Quarkus build analytics] Didn't receive the user's answer after 10 seconds. The question will be asked again next time.

Listening for transport dt_socket at address: 5005
Press [e] to edit command line args (currently ''), [h] for more options>
Tests paused
Press [e] to edit command line args (currently ''), [r] to resume testing, [h] for more options>
Press [e] to edit command line args (currently ''), [r] to resume testing, [o] Toggle test output, [h] for more options>
__  ____  __  _____   ___  __ ____  ______ 
 --/ __ \/ / / / _ | / _ \/ //_/ / / / __/ 
 -/ /_/ / /_/ / __ |/ , _/ ,< / /_/ /\ \   
--\___\_\____/_/ |_/_/|_/_/|_|\____/___/   
2025-11-24 13:43:32,868 INFO  [io.quarkus] (Quarkus Main Thread) product-registry-domain-service 0.1.0-SNAPSHOT on JVM (powered by Quarkus 3.26.1) started in 7.522s. Listening on: http://localhost:8091
2025-11-24 13:43:32,874 INFO  [io.quarkus] (Quarkus Main Thread) Profile dev activated. Live Coding activated.
2025-11-24 13:43:32,874 INFO  [io.quarkus] (Quarkus Main Thread) Installed features: [agroal, cdi, config-yaml, hibernate-orm, hibernate-orm-panache, hibernate-validator, jdbc-postgresql, narayana-jta, rest, rest-jackson, smallrye-context-propagation, smallrye-openapi, swagger-ui, vertx]

<============-> 96% EXECUTING [28s]
> :apps:product-registry-domain-service:quarkusDev

```

dans des nouveaux terminaux;
La liste des composants à lancer est la suivante :

Service de registre de produits
Commande (écriture) : Product Registry Command Service
Process Java sur le port 8091
Query (lecture) : Product Registry Read Service
Process Java sur le port 8092
BFF (Backend For Frontend) : Order Flow BFF
Process Java sur le port 8080
Front de gestion de magasin : Store Front
Process Node sur le port 4200
donc 

```bash
gradle :apps:product-registry-read-service:quarkusDev
gradle :apps:store-back:quarkusDev
gradle :apps:store-front:quarkusDev
```

donc:



```bash

pnpm run --filter store-front
```


```bash
root@8bfcdce7a06b:/workspace# gradle :apps:product-registry-read-service:quarkusDev 
Starting a Gradle Daemon, 1 busy Daemon could not be reused, use --status for details

> Configure project :libs:cqrs-support
Jandex Gradle plugin 2.3.0. Consider becoming a patron at https://www.patreon.com/aalmiray

----------------------------
--- Help improve Quarkus ---
----------------------------
* Learn more: https://quarkus.io/usage/
* Do you agree to contribute anonymous build time data to the Quarkus community? (y/n and enter) 

> Task :apps:product-registry-read-service:quarkusDev
[Quarkus build analytics] Didn't receive the user's answer after 10 seconds. The question will be asked again next time.

Changed debug port to 45007 because of a port conflict
Listening for transport dt_socket at address: 45007
Press [e] to edit command line args (currently ''), [h] for more options>
Tests paused
Press [e] to edit command line args (currently ''), [r] to resume testing, [h] for more options>
Press [e] to edit command line args (currently ''), [r] to resume testing, [o] Toggle test output, [h] for more options>
__  ____  __  _____   ___  __ ____  ______ 
 --/ __ \/ / / / _ | / _ \/ //_/ / / / __/ 
 -/ /_/ / /_/ / __ |/ , _/ ,< / /_/ /\ \   
--\___\_\____/_/ |_/_/|_/_/|_|\____/___/   
2025-11-24 13:47:10,375 INFO  [org.orm.pri.tfa.ord.pro.rea.inf.out.OutboxPartitionedPoller] (Quarkus Main Thread) OutboxPartitionedPoller started with 6 partitions.
     2025-11-24 13:47:10,593 INFO  [io.quarkus] (Quarkus Main Thread) product-registry-read-service 0.1.0-SNAPSHOT on JVM (powered by Quarkus 3.26.1) started in 10.186s. Listening on: http://localhost:8092
2025-11-24 13:47:10,597 INFO  [io.quarkus] (Quarkus Main Thread) Profile dev activated. Live Coding activated.
2025-11-24 13:47:10,597 INFO  [io.quarkus] (Quarkus Main Thread) Installed features: [agroal, cdi, config-yaml, hibernate-orm, hibernate-orm-panache, hibernate-validator, jdbc-postgresql, narayana-jta, rest, rest-jackson, smallrye-context-propagation, smallrye-openapi, swagger-ui, vertx]

<============-> 96% EXECUTING [4m 57s]
> :apps:product-registry-read-service:quarkusDev

```

```bash
root@8bfcdce7a06b:/workspace# gradle :apps:store-back:quarkusDev
Starting a Gradle Daemon, 2 busy Daemons could not be reused, use --status for details

----------------------------
--- Help improve Quarkus ---
----------------------------
* Learn more: https://quarkus.io/usage/
* Do you agree to contribute anonymous build time data to the Quarkus community? (y/n and enter) 

> Task :apps:store-back:quarkusDev
[Quarkus build analytics] Didn't receive the user's answer after 10 seconds. The question will be asked again next time.

Changed debug port to 40347 because of a port conflict
Listening for transport dt_socket at address: 40347
Press [e] to edit command line args (currently ''), [h] for more options>
Tests paused
Press [e] to edit command line args (currently ''), [r] to resume testing, [h] for more options>
Press [e] to edit command line args (currently ''), [r] to resume testing, [o] Toggle test output, [h] for more options>
__  ____  __  _____   ___  __ ____  ______ 
 --/ __ \/ / / / _ | / _ \/ //_/ / / / __/ 
 -/ /_/ / /_/ / __ |/ , _/ ,< / /_/ /\ \   
--\___\_\____/_/ |_/_/|_/_/|_|\____/___/   
2025-11-24 13:47:39,241 INFO  [io.quarkus] (Quarkus Main Thread) store-back 0.1.0-SNAPSHOT on JVM (powered by Quarkus 3.26.1) started in 4.990s. Listening on: http://localhost:8080
2025-11-24 13:47:39,249 INFO  [io.quarkus] (Quarkus Main Thread) Profile dev activated. Live Coding activated.
2025-11-24 13:47:39,250 INFO  [io.quarkus] (Quarkus Main Thread) Installed features: [cdi, config-yaml, hibernate-validator, rest, rest-client, rest-client-jackson, rest-jackson, smallrye-context-propagation, smallrye-openapi, swagger-ui, vertx]

<============-> 94% EXECUTING [4m 36s]
> IDLE
> IDLE
> IDLE
> IDLE
> :apps:store-back:quarkusDev
> IDLE
```

```bash

root@8bfcdce7a06b:/workspace# pnpm run --filter apps-tore-front start
! Corepack is about to download https://registry.npmjs.org/pnpm/-/pnpm-10.18.2.tgz
? Do you want to continue? [Y/n] Y^C
root@8bfcdce7a06b:/workspace# ^C
root@8bfcdce7a06b:/workspace# ^C
root@8bfcdce7a06b:/workspace# pnpm run --filter apps-store-front start
$! Corepack is about to download https://registry.npmjs.org/pnpm/-/pnpm-10.18.2.tgz
? Do you want to continue? [Y/n] Y


> apps-store-front@0.0.0 start /workspace/apps/store-front
> ng serve --host 127.0.0.1

sh: 1: ng: not found
/workspace/apps/store-front:
 ERR_PNPM_RECURSIVE_RUN_FIRST_FAIL  apps-store-front@0.0.0 start: `ng serve --host 127.0.0.1`
spawn ENOENT
root@8bfcdce7a06b:/workspace# pnpm run --filter apps-store-front start

> apps-store-front@0.0.0 start /workspace/apps/store-front
> ng serve --host 127.0.0.1

sh: 1: ng: not found
/workspace/apps/store-front:
 ERR_PNPM_RECURSIVE_RUN_FIRST_FAIL  apps-store-front@0.0.0 start: `ng serve --host 127.0.0.1`
spawn ENOENT
 WARN   Local package.json exists, but node_modules missing, did you mean to install?
root@8bfcdce7a06b:/workspace# pnpm install
Scope: all 3 workspace projects
Lockfile is up to date, resolution step is skipped
Packages: +798
++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

   ╭───────────────────────────────────────────────╮
   │                                               │
   │     Update available! 10.18.2 → 10.23.0.      │
   │     Changelog: https://pnpm.io/v/10.23.0      │
   │   To update, run: corepack use pnpm@10.23.0   │
   │                                               │
   ╰───────────────────────────────────────────────╯

Downloading @rolldown/binding-linux-x64-musl@1.0.0-beta.32: 7.24 MB/7.24 MB, done
Downloading @rolldown/binding-linux-x64-gnu@1.0.0-beta.32: 7.26 MB/7.26 MB, done
Downloading mermaid@11.12.0: 14.37 MB/14.37 MB, done
Downloading cytoscape-fcose@2.2.0: 7.60 MB/7.60 MB, done
Progress: resolved 798, reused 0, downloaded 797, added 798, done
Downloading @mermaid-js/mermaid-mindmap@9.3.0: 6.22 MB/6.22 MB, done
node_modules/.pnpm/esbuild@0.25.9/node_modules/esbuild: Running postinstall script, done in 176ms
node_modules/.pnpm/esbuild@0.21.5/node_modules/esbuild: Running postinstall script, done in 178ms

devDependencies:
+ @angular/cli 20.3.2

╭ Warning ───────────────────────────────────────────────────────────────────────────────────╮
│                                                                                            │
│   Ignored build scripts: @parcel/watcher, @tailwindcss/oxide, lmdb, msgpackr-extract.      │
│   Run "pnpm approve-builds" to pick which dependencies should be allowed to run scripts.   │
│                                                                                            │
╰────────────────────────────────────────────────────────────────────────────────────────────╯

Done in 8.5s using pnpm v10.18.2
root@8bfcdce7a06b:/workspace# pnpm run --filter apps-store-front start

> apps-store-front@0.0.0 start /workspace/apps/store-front
> ng serve --host 127.0.0.1

[baseline-browser-mapping] The data in this module is over two months old.  To ensure accurate Baseline data, please update: `npm i baseline-browser-mapping@latest -D`
Initial chunk files | Names                      |  Raw size
main.js             | main                       |  13.76 kB | 
styles.css          | styles                     |  11.60 kB | 
chunk-NXCX5QZ4.js   | -                          |   1.50 kB | 
chunk-VUJOFXKG.js   | -                          | 938 bytes | 

                    | Initial total              |  27.79 kB

Lazy chunk files    | Names                      |  Raw size
chunk-2D5BLBYY.js   | product-component          |  27.27 kB | 
chunk-MCAXZY74.js   | register-product-component |  11.32 kB | 
chunk-ZBDHDKW7.js   | products-component         |   8.08 kB | 
chunk-CJT4X6C5.js   | about-component            |   3.29 kB | 
chunk-FPNWT74M.js   | -                          |   2.93 kB | 
chunk-P32TM24B.js   | registry-module            |   1.56 kB | 

Application bundle generation complete. [3.458 seconds] - 2025-11-24T13:49:03.204Z

Watch mode enabled. Watching for file changes...
NOTE: Raw file sizes do not reflect development server per-request transformations.
  ➜  Local:   http://127.0.0.1:4200/
  ➜  press h + enter to show help
[baseline-browser-mapping] The data in this module is over two months old.  To ensure accurate Baseline data, please update: `npm i baseline-browser-mapping@latest -D`
```




































