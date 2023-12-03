"# GestionPG" 
# Gestion de Produits avec Spring Boot

Un projet Spring Boot pour la gestion de produits et catalogue avec l'utilisation de Thymeleaf, MySQL, sécurité de connexion, et une architecture DAO en trois couches.

## Table des matières
- [Prérequis](#prérequis)
- [Installation](#installation)
- [Configuration](#configuration)
- [Utilisation](#utilisation)
- [Architecture](#architecture)
- [Contributions](#contributions)
- [Licence](#licence)

## Prérequis

Assurez-vous d'avoir les éléments suivants installés avant de commencer :

- Java 8+
- Maven
- MySQL
- ...

## Installation

1. Clonez le repository :

    ```bash
    git clone https://github.com/adama007/GestionPG.git
    ```

2. Créez une base de données MySQL avec le nom `gestion_produits` (ou configurez le nom de la base de données dans le fichier `application.properties`).

3. Allez dans le répertoire du projet :

    ```bash
    cd GestionPG
    ```

4. Exécutez l'application avec Maven :

    ```bash
    mvn spring-boot:run
    ```

## Configuration

### Base de données

La configuration de la base de données se trouve dans le fichier `src/main/resources/application.properties`. Assurez-vous de configurer les paramètres appropriés, tels que le nom de la base de données, le nom d'utilisateur et le mot de passe.

### Sécurité

La configuration de la sécurité se trouve dans les classes sous le package `com.poly.gestioncatalogue5gr1.security`. Vous pouvez personnaliser les règles de sécurité selon vos besoins.

## Utilisation

Une fois l'application lancée, ouvrez un navigateur et accédez à [http://localhost:8080](http://localhost:8080) pour utiliser l'interface utilisateur de gestion des produits.

## Architecture

Le projet suit une architecture DAO en trois couches :

1. **Controller Layer:** Les contrôleurs gèrent les requêtes HTTP et interagissent avec la couche de service.
2. **Service Layer:** Les services contiennent la logique métier et font appel aux méthodes de la couche DAO.
3. **DAO Layer:** La couche d'accès aux données (DAO) interagit directement avec la base de données.

## Contributions

Toute contribution est la bienvenue ! Si vous souhaitez contribuer, suivez ces étapes :

1. Fork du projet
2. Créez une nouvelle branche (`git checkout -b feature/nouvelle-fonctionnalité`)
3. Committez vos changements (`git commit -am 'Ajout d'une nouvelle fonctionnalité'`)
4. Pushez la branche (`git push origin feature/nouvelle-fonctionnalité`)
5. Créez une Pull Request

## Licence

Ce projet est sous licence [Licence XYZ](LICENSE).

