# Tâche 1 : Questions
## Quels sont les principaux domaines métiers de l'application Order flow ?
Gestion des produits (Product Registry)
    Enregistrement de nouveaux produits.
    Modification et retrait des produits.
    Historique des produits et traçabilité des événements.

Gestion des commandes (Order Flow)
    Création de commandes pour les produits disponibles.
    Validation et traitement des commandes.
    Suivi du statut des commandes.

Présentation et interaction front-end (Store Front / BFF)
    Interface utilisateur pour gérer produits et commandes.
    Composition et transformation des données pour l’affichage.

Gestion des événements et lecture optimisée
    Projection des événements métiers vers des vues matérialisées pour la lecture rapide.
    Asynchronisme pour découpler l’écriture et la lecture.

## Comment les services sont-ils conçus pour implémenter les domaines métiers ?
 
## Quelles sont les responsabilités des modules :
- `apps/store-back`
- `apps/store-front`
- `libs/kernel`
- `apps/product-registry-domain-service`
- `apps/product-registry-read-service`
- `libs/bom-platform`
- `libs/cqrs-support`
- `libs/sql`
 
# Tâche 2 : Identifier les concepts principaux

# Tâche 2 : Questions
## Quels sont les concepts principaux utilisés dans l'application Order flow ?

## Comment les concepts principaux sont-ils implémentés dans les différents modules ?

## Que fait la bibliothèque libs/cqrs-support ? Comment est-elle utilisée dans les autres modules (relation entre métier et structure du code) ?

## Que fait la bibliothèque libs/bom-platform ?

## Comment l'implémentation actuelle du CQRS et du Kernel assure-t-elle la fiabilité des états internes de l'application ?


# Tâche 3 : Identifier les problèmes de qualité






