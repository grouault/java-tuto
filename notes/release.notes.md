# Notes

## Principe
L'idée est de tester l'AOP dans une application Java.
Le plugin AspectJWeaver fonctionne avec IntelliJ ultimate
Il faut passer par maven pour l'utiliser avec la version classique

### Dans le code:
- on trouve 3 Aspects:
- LoggingAspect : pour tester les logs
  - génère les logs dans le fichier log.xml
- PatchRetraitAspect:
  - permet de vérifier que le solde est positif
- SecurityAspect
  - l'application nécessite une authenfication
  
### Mode opératoire.

#### Compilation
L'application doit être compilé avec l'activation des aspects.
Effectivement, les aspects sont contenus dans le bytecode
Le plugin permet de tisser les aspects
- utilisation de : aspectj-maven-plugin.
- https://www.mojohaus.org/aspectj-maven-plugin/usage.html

#### packaging
- pour le packaging et les tests, il faut packager en mettant en dépendance les jars :
  - aspectrt.jar
Pour cela on utilise, le plugin one-jar.
Cela génère un jar qui contient les jars nécessaires au fonctionnement des aspects

#### exécution
soit en ligne de commande :
1- mvn package
2- java -jar tuto-aop-1.0-SNAPSHOT.one-jar.jar

soit avec la commande maven :
3- mvn exec:java
==> utilisation du plugin: exec-maven-plugin
https://www.mojohaus.org/exec-maven-plugin/usage.html