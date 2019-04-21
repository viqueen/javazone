#! /usr/bin/env bash

_with_arguments() {
    count=${1}
    shift
    if [[ "$#" -lt ${count} ]]; then
        echo "missing arguments, expected at least ${count} but received $#"
        exit 1
    fi
}

_image() {
    _with_arguments 1 $@
    version=${1}
    echo "viqueen/javazone:${version}"
}

function build() {
    docker build -t $(_image $@) ./src/docker/
}

function push() {
    docker push $(_image $@)
}

function run() {
    docker run -it --entrypoint=/bin/bash $(_image $@)
}

eval $@