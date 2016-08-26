#!/bin/bash
# This script will build the project.

if [ "$TRAVIS_PULL_REQUEST" != "false" ]; then
  echo -e "Build Pull Request #$TRAVIS_PULL_REQUEST => Branch [$TRAVIS_BRANCH]"
  ./gradlew build
elif [ "$TRAVIS_PULL_REQUEST" == "false" ] && [ "$TRAVIS_TAG" != "" ]; then
  echo -e 'Build Branch for Release => Branch ['$TRAVIS_BRANCH']  Tag ['$TRAVIS_TAG']'
  case "$TRAVIS_TAG" in
  *-rc\.*)
    ./gradlew -Prelease.useLastTag=true -PbintrayUser="${bintrayUser}" -PbintrayKey="${bintrayKey}" -PsonatypeUsername="${sonatypeUsername}" -PsonatypePassword="${sonatypePassword}" -PgpgPassphrase="${gpgPassphrase}" candidate
    ;;
  *)
    ./gradlew -Prelease.useLastTag=true -PbintrayUser="${bintrayUser}" -PbintrayKey="${bintrayKey}" -PsonatypeUsername="${sonatypeUsername}" -PsonatypePassword="${sonatypePassword}" -PgpgPassphrase="${gpgPassphrase}" final
    ;;
  esac
else
  echo -e 'Build Branch ['$TRAVIS_BRANCH']'
  ./gradlew build
fi