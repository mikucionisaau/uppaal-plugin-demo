#!/usr/bin/env bash
set -e

if [ -z "$UPPAAL_HOME" ] ; then
    echo "Please set UPPAAL_HOME environment variable to the UPPAAL installation path"
    echo "For example:"
    echo "export UPPAAL_HOME=$HOME/uppaal64-4.1.26"
    exit 1
fi

if [ -z "$(command -v javac)" ] ; then
    echo "Please install Java Development Kit (JDK) at least version 11."
    echo "You can find it in your distribution or Internet, e.g. https://adoptium.net/"
fi

mkdir -p build

echo "Compiling sources into build"
CP="$PWD/src:$UPPAAL_HOME/uppaal.jar:$UPPAAL_HOME/lib/model.jar"
javac -cp "$CP" -d build -source 11 src/com/uppaal/PluginDemo.java

echo "Packaging into plugindemo.jar"
jar --create --file build/plugindemo.jar --manifest=src/manifest -C build com

echo "Creating $UPPAAL_HOME/plugins"
mkdir -p "$UPPAAL_HOME/plugins"

echo "Copying build/plugindemo.jar to $UPPAAL_HOME/plugins/"
cp build/plugindemo.jar "$UPPAAL_HOME/plugins/"

echo "Starting $UPPAAL_HOME/uppaal"
exec "$UPPAAL_HOME/uppaal"
