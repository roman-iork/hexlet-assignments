setup:
	./gradlew wrapper --gradle-version 8.3
	./gradlew build

app:
	./gradlew bootRun --args='--spring.profiles.active=development'

prod:
	./gradlew bootRun --args='--spring.profiles.active=stage'

clean:
	./gradlew clean

build:
	./gradlew clean build

dev: app

reload-classes:
	./gradlew -t classes

install:
	./gradlew installDist

test:
	./gradlew test

check-java-deps:
	./gradlew dependencyUpdates -Drevision=release

.PHONY: build
