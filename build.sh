#!/usr/bin/env bash

ROOT=$(pwd)
resources=${ROOT}/backend/src/main/resources

BE=${ROOT}/backend
FE=${ROOT}/frontend
PUBLIC=${resources}/public
TEMPLATES=${resources}/templates
echo "Templates dir: ${TEMPLATES}"
echo "Public dir   : ${PUBLIC}"
echo "Backend dir  : ${BE}"



echo ">>> removing old bundle"
rm -rf ${PUBLIC}
mkdir ${PUBLIC}
rm -rf ${TEMPLATES}
mkdir ${TEMPLATES}



echo ">>> webclient building & installing"
cd ${FE}

npm run build



echo ">>> copying new bundle"
cp -R build/. ${PUBLIC}
cp build/index.html ${TEMPLATES}/index.html



echo ">>> building backend"
cd ${ROOT}
./gradlew clean build
mv ${BE}/build/libs/backend-1.0.jar ${ROOT}/app.jar

