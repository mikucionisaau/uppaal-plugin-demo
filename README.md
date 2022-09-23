# Uppaal Plugin Demo

The project demonstrates a simple plugin to be loaded into UPPAAL GUI as an extra tab(s).

## Demo Instructions

Download and unpack UPPAAL from [uppaal.org](https://uppaal.org).

Set the environment variable `UPPAAL_HOME` to point to your UPPAAL installation, for example:
```sh
export UPPAAL_HOME=$HOME/uppaal64-4.1.26
```

Run the `build.sh` script to compile, install and run UPPAAL with the plugin:
```sh
./build.sh
```

Observe UPPAAL being launched and a new tab "Plugin Demo" on the right.

To cleanup, delete the `build` directory:
```sh
rm -Rf build
```
