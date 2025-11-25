# Tâche 1 : Questions
## Quels sont les principaux domaines métiers de l'application Order flow ?
Gestion des produits (Product Registry)
    Enregistrement de nouveaux produits.
    Modification et retrait des produits.
    Historique des produits et traçabilité des événements.

Présentation et interaction front-end (Store Front / BFF)
    Interface utilisateur pour gérer produits.
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
 
| **Module**                               | **Responsabilité**                                                                                                 |
| ---------------------------------------- | ------------------------------------------------------------------------------------------------------------------ |
| **apps/store-back**                      | Backend pour la gestion interne du magasin, traitement de certaines logiques front/back spécifiques. |
| **apps/store-front**                     | Interface utilisateur web pour gérer produits. Communication via le BFF.                              |
| **libs/kernel**                          | Fournit les bases partagées (utilitaires, configuration, sécurité, logging).                                       |
| **apps/product-registry-domain-service** | Service principal pour gérer le registre de produits (création, modification, retrait).                            |
| **apps/product-registry-read-service**   | Service de lecture optimisée : expose une vue matérialisée des produits pour le front.                             |
| **libs/bom-platform**                    | Gestion des dépendances et versions partagées dans le projet (BOM = Bill of Materials).                            |
| **libs/cqrs-support**                    | Fournit les outils et infrastructure pour implémenter le pattern CQRS (Command/Query).                             |
| **libs/sql**                             | Scripts SQL, migrations de base de données via Liquibase, tables et schémas nécessaires à l’application.           |


# Tâche 2 : Identifier les concepts principaux

# Tâche 2 : Questions
## Quels sont les concepts principaux utilisés dans l'application Order flow ?
- Stockage des données
- Événements métiers
- Gestion des erreurs (métier et technique)
- Échanges entre services (formats et protocoles)

## Comment les concepts principaux sont-ils implémentés dans les différents modules ?
```
┌─────────────────────────┐
│  Store Front (UI/Web)   │
└───────────────▲─────────┘
                │ HTTP API
┌───────────────┴─────────┐
│   Store Back Service    │
│  (Domaine magasin)      │
└───────┬─────────────────┘
        │ appelle
┌───────┴─────────────────┐
│   Product Registry      │
│  (Domaine produit)      │
└───────┬─────────────────┘
        │ via ports
        ▼
PostgreSQL + Liquibase
```

## Que fait la bibliothèque libs/cqrs-support ? Comment est-elle utilisée dans les autres modules (relation entre métier et structure du code) ?
Bibliothèque libs/cqrs-support

## Que fait la bibliothèque libs/bom-platform ?
Fournit les outils et l'infrastructure nécessaires pour implémenter le pattern CQRS (Command Query Responsibility Segregation) dans l'application Order flow. Elle facilite la séparation des responsabilités entre les opérations de commande (écriture) et les opérations de requête (lecture).

## Comment l'implémentation actuelle du CQRS et du Kernel assure-t-elle la fiabilité des états internes de l'application ?



### Fiabilité CQRS & Kernel 

* Événements immuables : `EventLogEntity` stocke chaque événement avec séquence et version.
* Validation Kernel : transitions contrôlées, exceptions levées si invalides (`ConstraintViolationException` / `IllegalStateException`).
* Projections sûres : `Projector<S,E>` ignore doublons et événements hors séquence, stoppe à la première erreur :

```java
if (ev.sequence() <= acc.lastSequence())
    return acc;  // Ignore événements dupliqués ou en désordre
```

* Immutabilité & traçabilité : agrégats, événements et enveloppes sont immuables.
* Ordonnancement garanti : séquence auto-incrémentée + recalcul des vues depuis l’historique.

### Flux résumé :

```
Commande (Kernel)
    ↓
Validation stricte + levée d'exceptions
    ↓
Événement immuable → EventLog
    ↓
Projection
    ↓
Vérification cohérence + détection anomalies + no-op
    ↓
ProductView mise à jour
``` 

# Tâche 3 : Identifier les problèmes de qualité






