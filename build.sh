#!/usr/bin/env bash
set -e

if [ -z "$UPPAAL_HOME" ]; then
    echo "Please set UPPAAL_HOME environment variable to the UPPAAL installation path"
    echo "For example:"
    echo "export UPPAAL_HOME=$HOME/uppaal64-4.1.26"
    exit 1
fi

mkdir -p build

CLASS_PATH="$UPPAAL_HOME/uppaal.jar:$UPPAAL_HOME/lib/model.jar"
echo "Compiling sources into build"
javac -cp "$CLASS_PATH" -d build -source 11 src/com/uppaal/PluginDemo.java
echo "Packaging into plugindemo.jar"
jar --create --file build/plugindemo.jar --manifest=manifest -C build com

echo "Creating $UPPAAL_HOME/plugins"
mkdir -p "$UPPAAL_HOME/plugins"

echo "Copying build/plugindemo.jar to $UPPAAL_HOME/plugins/"
cp build/plugindemo.jar "$UPPAAL_HOME/plugins/"

echo "Starting $UPPAAL_HOME/uppaal"
exec "$UPPAAL_HOME/uppaal"
