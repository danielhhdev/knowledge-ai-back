# Knowledge AI

> Un proyecto de aprendizaje práctico para dominar RAG, Spring AI y desarrollo asistido por IA

## 🎯 ¿Qué es este proyecto?

Knowledge AI es un sistema completo de **Retrieval-Augmented Generation** construido con tecnologías modernas. Más que un proyecto funcional, es un **laboratorio de aprendizaje** donde dominar:

- **Arquitectura RAG de principio a fin**: desde la ingesta de documentos hasta la generación de respuestas contextualizadas
- **Spring AI**: framework nativo para integrar LLMs en aplicaciones Spring Boot
- **Ollama**: ejecución de modelos de lenguaje de forma local y gratuita
- **PgVector**: almacenamiento y búsqueda semántica con embeddings vectoriales
- **Spec-Driven Development (SDD)**: metodología estructurada donde la IA actúa como copiloto del desarrollo

### 🧠 La diferencia clave

Este proyecto será **construido junto con IA**, aplicando SDD en cada fase para que la IA actúe como **coproductora del código, la arquitectura y la documentación**. No es solo código: es aprender a trabajar con IA como herramienta profesional de desarrollo.

---

## 🏗️ Arquitectura del Sistema

```
+-------------------------------------------------------------+
¦                    API REST Layer                           ¦
¦/api/v1/documents/ingest  /api/v1/query ¦
+-------------------------------------------------------------+
                        ¦
        +-------------------------------+
        ¦                               ¦
        ?                               ?
+--------------------+              +--------------------+
¦ Ingestion          ¦              ¦ RAG Query          ¦
¦ Pipeline           ¦              ¦ Engine             ¦
¦                    ¦              ¦                    ¦
¦ • Parser           ¦              ¦ • Retrieval        ¦
¦ • Chunker          ¦              ¦ • Ranking          ¦
¦ • Embedder         ¦              ¦ • Generation       ¦
+--------------------+              +--------------------+
             ¦                               ¦
             ¦    +--------------------+     ¦
             +---?¦   Spring AI        ¦?----+
                  ¦   LLM Client       ¦
                  +--------------------+
                            ¦
          +-------------------------------------+
          ¦                      ¦               ¦
          ?                      ?               ?
    +------------+        +---------------+  +-------------+
    ¦  Ollama    ¦        ¦ PostgreSQL    ¦  ¦  PgVector   ¦
    ¦  Models    ¦        ¦               ¦  ¦             ¦
    ¦ llama3.2   ¦        ¦  Embeddings   ¦  ¦  Vector DB  ¦
    ¦ phi3.5     ¦        ¦   Storage     ¦  ¦             ¦
    ¦ mistral    ¦        +---------------+  +-------------+
    +------------+
```

---

## 🛠️ Stack Tecnológico

| Componente | Tecnología | Propósito |
|------------|-----------|-----------|
| **Backend** | Spring Boot 3.4 + Java 21 | Framework principal |
| **IA Client** | Spring AI | Integración con LLMs |
| **LLM Local** | Ollama | Modelos de lenguaje locales |
| **Base de Datos** | PostgreSQL 16 | Persistencia |
| **Vector Store** | PgVector | Búsqueda semántica |
| **Contenedores** | Docker Compose | Orquestación de servicios |
| **Metodología** | Spec-Driven Development | Desarrollo asistido por IA |

---

## 🚀 Inicio Rápido

### Requisitos Previos

- **Java 21** o superior
- **Docker Desktop** instalado y en ejecución
- **Ollama** instalado localmente ([guía de instalación](https://ollama.ai))
- **16 GB RAM** recomendados

### Instalación

1. **Clona el repositorio**
   ```bash
   git clone https://github.com/danielhhdev/knowledge-ai-back.git
   cd knowledge-ai-back
   ```

2. **Levanta la infraestructura**
   ```bash
   docker-compose up -d
   ```

3. **Si ya tienes PostgreSQL local, detén el servicio para evitar conflicto de puertos**
   ```bash
   net stop postgresql-x64-16
   ```

4. **Descarga el modelo de Ollama**
   ```bash
   ollama pull llama3.2
   ollama rm llama3:8b
   ```

5. **Ejecuta la aplicación**
   ```bash
   ./mvnw spring-boot:run
   ```

6. **Prueba el sistema**
   ```bash
   curl -X POST http://localhost:8080/api/v1/query/answer \
     -H "Content-Type: application/json" \
     -d '{"query": "¿Qué información tienes almacenada?"}'
   ```

---

## 🧠 Metodología: Spec-Driven Development

Este proyecto sigue el enfoque **SDD**, donde cada funcionalidad nace de una especificación clara y se desarrolla mediante pasos estructurados:

```
SPEC → Define el "qué" y el "por qué"
  ?
PLAN → Diseño técnico y decisiones de arquitectura
  ?
TASKS → Desglose en tareas atómicas y ejecutables
  ?
GENERATION → Desarrollo asistido por IA mediante prompts
  ?
REVIEW → Validación, testing y refinamiento
```

### Estructura del Proyecto

```
knowledgeAI/
+-- sdd/
¦   +-- specs/              # Especificaciones funcionales
¦   +-- plans/              # Planes técnicos y arquitectura
¦   +-- tasks/              # Tareas desglosadas por fase
¦   +-- prompts/            # Plantillas de prompts para IA
+-- src/
¦   +-- main/
¦   ¦   +-- java/
¦   ¦   +-- resources/
¦   +-- test/
+-- docker-compose.yml
+-- README.md
```

---

## ✅ Estado actual (enero 2026)

- **Implementado**: ingesta de documentos (`/api/v1/documents/ingest`) con parsing, chunking y embeddings; búsqueda semántica (`/api/v1/query`); generación RAG (`/api/v1/query/answer`) y streaming SSE (`/api/v1/query/answer/stream`); 
- **Pendiente**: gestión de documentos (`/api/v1/documents`) y endpoints asociados; mejoras de recuperación híbrida y re-ranking en roadmap.

---

## 🗺️ Roadmap del Proyecto

### ✅ Fase 0: Configuración del Entorno
- Proyecto Spring Boot 3.4 con Java 21
- Integración con Spring AI
- PostgreSQL + PgVector en Docker
- Ollama configurado con modelos locales
- Estructura SDD implementada

### 🔄 Fase 1: Pipeline de Ingesta
- Lectura de documentos (TXT, Markdown, PDF)
- Procesamiento y limpieza de texto
- Chunking configurable (tamaño y overlap)
- Generación de embeddings
- Persistencia en PgVector

### 📋 Fase 2: Motor de Recuperación
- Búsqueda vectorial con similitud coseno
- Ranking y re-ranking de resultados
- Recuperación híbrida (semántica + keyword)
- Optimización de consultas

### 🤖 Fase 3: Motor Generativo RAG
- Construcción dinámica de prompts
- Inyección de contexto recuperado
- Generación de respuestas con LLM
- Streaming de respuestas
- Manejo de errores y fallbacks

### 🌐 Fase 4: Exposición y contrato (API + OpenAPI)
- `POST /api/v1/documents/ingest` - Carga de documentos
- `POST /api/v1/query` - Consultas RAG
- `POST /api/v1/query/answer` - Respuestas RAG
- `POST /api/v1/query/answer/stream` - Respuestas RAG (streaming)
- Documentación OpenAPI/Swagger

---

## 🧪 Tecnologías en Detalle

### Spring AI
Framework oficial de Spring para integrar IA en aplicaciones empresariales.

### Ollama
Ejecuta modelos de lenguaje de última generación localmente, sin dependencias cloud.

**Modelos recomendados:**
- `llama3.2` - Generación de propósito general
- `phi3.5` - Modelo ligero y eficiente
- `mistral` - Alto rendimiento en español

### PgVector
Extensión de PostgreSQL para almacenamiento y búsqueda de vectores.

---

## 🤖 IA como Copiloto

Este proyecto aprovecha la IA como **herramienta activa de desarrollo**:

- **Generación de código** mediante prompts estructurados
- **Diseño de arquitectura** con análisis asistido
- **Documentación automática** de especificaciones
- **Revisión de código** y sugerencias de mejora
- **Creación de tests** basados en casos de uso

---

## 📚 Recursos de Aprendizaje

- [Spring AI Documentation](https://docs.spring.io/spring-ai/reference/)
- [Ollama Models](https://ollama.ai/library)
- [PgVector Guide](https://github.com/pgvector/pgvector)
- [RAG Patterns](https://blog.llamaindex.ai/rag-patterns)

---

## 🤝 Contribuciones

Este es un proyecto de aprendizaje personal, pero las sugerencias y feedback son bienvenidos. Si encuentras algo interesante o tienes ideas para mejorar:

1. Abre un **Issue** para discutir cambios
2. Haz un **Fork** y experimenta
3. Comparte tu experiencia en **Discussions**

---

## 📄 Licencia

MIT License - Siente libre de usar este proyecto para aprender y experimentar.

---

**¿Listo para construir un RAG de nivel profesional mientras aprendes con IA?** 🌟



