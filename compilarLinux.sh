#! /usr/bin/bash
echo "Este script compila el programa"
echo "Presione enter para continuar"
read
javac -cp .:jansi-2.1.0.jar -encoding UTF-8 Programa.java
