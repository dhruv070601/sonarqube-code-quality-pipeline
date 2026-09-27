# SonarQube Code Quality & Security Pipeline

A DevOps portfolio project demonstrating SonarQube integration into a Jenkins CI/CD pipeline and enforcement of a Quality Gate before delivery.

## What this demonstrates

- Jenkins Declarative Pipeline
- Maven build and unit testing
- SonarQube static analysis
- Quality Gate enforcement
- Dockerized SonarQube setup
- GitHub Actions validation
- JUnit result publishing
- Release blocking when configured quality criteria fail

## Architecture

Developer -> Git -> Jenkins -> Build/Test -> SonarQube -> Quality Gate -> Deployment Decision

See docs/architecture.md and docs/architecture.svg.

## Run locally

Start SonarQube with `docker compose up -d`, then configure the project key from `sonar-project.properties`.

Run tests with `mvn -B clean test`.

Run analysis from a configured SonarQube environment with `mvn -B sonar:sonar`.

## Jenkins integration

The Jenkinsfile performs checkout, build/test, SonarQube analysis, Quality Gate validation and JUnit publication. Configure a Jenkins SonarQube installation named `sonarqube` and the SonarQube webhook required by the Jenkins SonarQube plugin.

## Quality Gate concept

The important DevOps control is not simply generating a SonarQube report. Jenkins consumes the Quality Gate result and prevents downstream delivery when configured quality criteria fail. Typical criteria include coverage, bugs, vulnerabilities, code smells and duplication.

## Production hardening

Store SonarQube tokens in Jenkins Credentials, use HTTPS, enable branch/PR analysis, define organization-wide Quality Gates, use webhooks for gate callbacks and establish vulnerability triage.

## Interview talking points

- Static analysis versus runtime testing
- Why Quality Gates belong in CI/CD
- How Jenkins receives SonarQube results
- Handling failed gates
- SonarQube versus Nexus

## Skills

Jenkins, SonarQube, Maven, Java, Docker, GitHub Actions, CI/CD, static analysis, quality gates, DevSecOps.