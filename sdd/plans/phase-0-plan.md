# PLAN Fase 0 / Setup de entorno y esqueleto

## 1. Resumen del Objetivo

## 2. Arquitectura Afectada
- Configuracion: `application.yml` y `application-dev.yml` con datasource, perfiles y propiedades de Ollama apuntando a host local; `OpenAPIConfig` si aplica el esqueleto; `SpringAIConfig`/`OllamaConfig` placeholders.
- Infra: `docker-compose.yml` para PostgreSQL 16 con PgVector y red local; scripts/env de arranque (sin Ollama en contenedor).

## 3. Checklist de Implementacion (orden recomendado)
1. Inicializar estructura de paquetes segun `AGENTS.md` (controladores, servicios, DTOs, mappers, domain, repository, config) con interfaces e implementaciones stub donde aplique.
2. Anadir dependencias Maven base: Spring Web, Spring Data JPA, PostgreSQL driver, PgVector, Spring AI, Lombok, validation, testing; verificar `mvnw` operativo.
3. Configurar `application.yml` y `application-dev.yml` con perfil activo `dev`, datasource a PostgreSQL, propiedades de PgVector, y base URL de Ollama apuntando a `http://localhost:11434`.
4. Crear `docker-compose.yml` con servicio PostgreSQL+PgVector, credenciales `dev/dev`, puerto 5432, volumen de datos, y redes (sin servicio Ollama).
6. Anadir configuracion basica de OpenAPI (si se expone), y beans minimos de Spring AI/Ollama placeholder.
8. Validar arranque local con perfil `dev` (`./mvnw spring-boot:run`) y ajustar logging (INFO) para perfil activo.

## 4. Secuencia de Commits
- chore: scaffold project structure and dependencies
- chore: add docker compose with postgres pgvector
- feat: add dev profile configuration

## 5. Dependencias
- Java 21 y Maven Wrapper disponible.
- Docker Desktop activo para PostgreSQL/PgVector.
- Ollama instalado de forma local en el host.
- Sin servicios previos; solo documentos `AGENTS.md`, `constitution.md` y `phase-0-spec`.

## 6. Validacion Final
- Arranque con `./mvnw spring-boot:run` en perfil `dev` sin errores de dependencias ni configuracion.
- `docker-compose up -d` levanta PostgreSQL con extension PgVector sin errores de logs.
