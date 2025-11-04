#!/bin/bash
cd /home/kavia/workspace/code-generation/hello-world-android-tv-40669-40697/android_tv_frontend
./gradlew lint
LINT_EXIT_CODE=$?
if [ $LINT_EXIT_CODE -ne 0 ]; then
   exit 1
fi

