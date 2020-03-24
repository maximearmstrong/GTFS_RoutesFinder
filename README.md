# GTFS_RoutesFinder

Ce projet permet de trouver les lignes de métros `route_short_name` passant par une station `stop_name` dans un lot de données GTFS.

Ce projet contient les éléments suivants :
  * GTFS_MTA_NYC_Transit_Subway : Répertoire du [lot de données GTFS du réseau de métro de NYC](http://web.mta.info/developers/developer-data-terms.html).
  * gtfs_routesfinder : Le projet contenant les fichiers sources Java et les fichier Gradle.
  * Result.txt : Un fichier texte contenant le résultat attendu (lignes de métro) lors de l'exécution du projet pour la station Grand Central - 42 St du métro de NYC.


# Prérequis

* JDK 11
* Gradle
* IntelliJ IDEA


# Utilisation

Pour utiliser le projet, vous aurez besoin d'un lot de données GTFS d'un réseau de métro (static data feeds) et du nom exact de la station `stop_name` pour laquelle vous cherches les lignes de métro.

Pour exécuter le projet, vous devez passer l'emplacement du répertoire du lot de données GTFS en premier argument (args[0]) et le nom de la station en deuxième argument (args[1]).


# Compilation et éxécution avec Gradle

## Lignes de commandes

Débuter les commandes après vous être positionnés à la racine du projet.

Premièrement, pour compiler et créer l'archive Jar exécutable :
```
cd gtfs_routefinder
gradle build
```

Ensuite, revenez à la racine du projet et exécuter le projet pour la station Grand Central - 42 St du métro de NYC : 
```
cd ..
java -jar ./gtfs_routesfinder/build/libs/gtfs_routesfinder.jar "./GTFS_MTA_NYC_Transit_Subway" "Grand Central - 42 St"
```


# États du projet

Projet fonctionnel.

## Améliorations à prévoir

* Optimisation de la recherche des éléments, particulièrement pour la recherche concernant le `trip_id`, afin d'obtenir un meilleur temps d'exécution. 


# Auteur

Maxime Armstrong

