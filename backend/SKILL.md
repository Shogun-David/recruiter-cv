---
name: recruiter-ai
description: Generate enterprise AI-powered recruitment applications using Java 25, Quarkus 3.x, Hibernate ORM with Panache, PostgreSQL + pgvector, Angular 20 (Signals), LangChain4j, Apache PDFBox, and OpenAI/Ollama. Use this skill whenever the user wants to build, scaffold, extend, or refactor an AI recruitment platform that analyzes CVs, extracts structured candidate information, stores embeddings, and performs semantic candidate matching through Retrieval-Augmented Generation (RAG).
---

# AI Recruitment Platform

## Mission

Act as a Principal Software Architect specialized in Enterprise Java, Quarkus, PostgreSQL, Artificial Intelligence, Retrieval-Augmented Generation (RAG), Document Processing, and Angular.

Generate production-ready enterprise applications that follow:

- Clean Architecture
- SOLID Principles
- Domain Driven Design (DDD)
- Hexagonal Architecture when applicable
- REST API Best Practices
- Java 25 best practices
- AI-first architecture
- Non-reactive programming unless explicitly requested

The primary business domain is:

> Intelligent Recruitment Platform capable of extracting information from candidate CVs, storing structured knowledge and embeddings, and matching candidates to job profiles using LLMs.

---

# Technology Stack

Backend

- Java 25
- Quarkus 3.37
- RESTEasy Reactive
- Hibernate ORM with Panache
- Hibernate Validator
- PostgreSQL
- pgvector
- Flyway
- Maven
- Lombok
- SmallRye OpenAPI
- Jackson

Artificial Intelligence

- LangChain4j
- OpenAI
- Ollama
- Embedding Models
- RAG

Document Processing

- Apache PDFBox

Frontend

- Angular 20+
- Standalone Components
- Signals
- Angular Material
- Reactive Forms

Testing

- JUnit 5
- Mockito
- RestAssured

Infrastructure

- Docker
- Docker Compose

---

# Business Domain

The generated applications revolve around these core concepts:

- Candidate
- CV
- Job Profile
- Skill
- Experience
- Education
- Language
- Certification
- Embedding
- Matching
- Ranking
- AI Analysis

Whenever the user provides another business domain, adapt accordingly while preserving architecture.

---


## Example Interpretation Rules
- Treat any item marked as example/examples as illustrative only.
- Do not generate literal class names from examples unless the domain requires that exact name.
- Derive concrete class names from the requested domain model, table names, or entities.

# Core Functionalities

Always assume the platform supports:

1. Candidate Management
2. CV Upload
3. PDF Processing
4. AI Information Extraction
5. Embedding Generation
6. Semantic Search
7. Candidate Ranking
8. Job Profile Management
9. Prompt-based Candidate Search
10. Explainable AI Results

---

# Recommended Project Modules

When creating a new project generate modules/packages similar to:

```
controller

service

service/impl

repository

entity

dto

mapper

commons

exception

config

ai

rag

embedding

document

storage

scheduler

prompt

matching

ranking

vector

util
```

---

# AI Processing Flow

Always model document processing as:

```
Upload PDF

↓

Apache PDFBox

↓

Extract Text

↓

LLM

↓

Extract Structured Information

↓

Persist PostgreSQL

↓

Generate Embedding

↓

Store pgvector
```

Never query PDFs directly during candidate search.

---

# Candidate Search Flow

Always assume search works as:

```
Prompt

↓

LLM interprets requirements

↓

Generate embedding

↓

Semantic Search

↓

Structured SQL Filters

↓

Ranking Engine

↓

LLM Explanation

↓

Final Response
```

---

# Architecture Rules

Separate responsibilities into independent services.

Example:

```
CandidateService

CVService

PdfExtractionService

EmbeddingService

PromptService

MatchingService

RankingService

LLMService

JobProfileService
```

Avoid God Services.

---

# AI Rules

Never send raw PDFs directly to the LLM.

Always:

PDF

↓

Extract Text

↓

Clean Text

↓

Prompt

↓

LLM

↓

JSON

The LLM should produce structured JSON whenever possible.

Example:

```json
{
  "skills": [],
  "experience": [],
  "education": [],
  "languages": [],
  "certifications": []
}
```

---

# Database Rules

Prefer PostgreSQL.

Always configure:

- Flyway
- pgvector
- UUID identifiers when appropriate
- created_at
- updated_at

Never store only PDFs.

Store:

Candidate

CV

Skills

Experiences

Education

Languages

Certifications

Embeddings

---

# Embedding Rules

Every processed CV should generate:

- extracted_text
- embedding_vector
- metadata

Store vectors using pgvector.

Never regenerate embeddings unless the document changes.

---

# LangChain4j Rules

Prefer LangChain4j abstractions over direct HTTP calls.

When AI is required:

- ChatLanguageModel
- EmbeddingModel
- EmbeddingStore
- AiServices

Avoid manual REST calls unless explicitly requested.

---

# Entity Rules

Generate one entity per table.

Naming:

CandidateEntity

SkillEntity

ExperienceEntity

JobProfileEntity

CVEntity

EmbeddingEntity

Use:

- PanacheEntityBase or PanacheRepository
- Jakarta Persistence
- Builder
- Lombok

Include:

id

createdAt

updatedAt

Lifecycle:

@PrePersist

@PreUpdate

---

# DTO Rules

Generate:

Request DTO

Response DTO

Prefer Java Records.

---

# Mapper Rules

Generate manual mappers.

Never use MapStruct unless requested.

---

# Repository Rules

Use:

PanacheRepository<Entity>

Avoid boilerplate CRUD.

---

# Service Rules

Business logic belongs in Services.

AI logic belongs in dedicated AI services.

Never place AI code inside Controllers.

---

# Controller Rules

Controllers only orchestrate.

Typical endpoints:

POST /candidates

POST /candidates/{id}/cv

GET /candidates

GET /matching

POST /job-profiles

POST /matching/search

POST /matching/prompt

---

# Matching Rules

Matching should combine:

Structured SQL filtering

+

Vector similarity

+

LLM reasoning

Return:

Candidate

Score

Strengths

Weaknesses

Explanation

Never return only a list.

---

# Prompt Engineering Rules

Whenever prompts are generated:

Separate:

System Prompt

Developer Prompt

User Prompt

Keep prompts reusable.

Avoid hardcoded business rules.

---

# Output Contract

Whenever generating code always produce:

1. Architecture overview

2. Project tree

3. Complete implementation grouped by layer

4. Build instructions

5. Run instructions

6. Assumptions

7. Future improvements

---

# Coding Standards

Always use:

- Constructor Injection
- Java 25 features
- Records
- Pattern Matching
- Switch Expressions
- Virtual Threads when appropriate
- Clean Code
- SOLID
- DDD naming
- One class per file

Avoid:

- Field Injection
- Static business logic
- Utility classes containing business rules

---

# Non Functional Requirements

Prioritize:

Scalability

Maintainability

Explainability of AI responses

Performance

Low token consumption

Reusable prompts

Clear separation between AI orchestration and business logic

Enterprise-ready code

## Database Connection Rules

When generating PostgreSQL configuration:

1. Always configure datasource in:

```
application.properties
```

unless the user explicitly requests `application.yaml`.

2. Default configuration:

```properties
quarkus.datasource.db-kind=postgresql
quarkus.datasource.username=admin
quarkus.datasource.password=admin
quarkus.datasource.jdbc.url=jdbc:postgresql://localhost:5432/<database_name>
```

3. Enable Hibernate ORM.

```properties
quarkus.hibernate-orm.database.generation=update
```

For production prefer:

```
validate
```

combined with Flyway migrations.

## AI Persistence Rules

1. Never use the LLM as the primary data source.

2. Every AI response that represents business knowledge must be persisted.

3. Store separately:

- Original PDF
- Extracted Text
- Structured JSON
- Embedding Vector

4. Never regenerate embeddings unless the source document changes.

5. Every AI analysis must include:

- model
- prompt_version
- processed_at
- confidence_score

6. Keep prompt templates versioned.

7. AI results must be reproducible whenever possible.

8. Semantic search must always combine:

- SQL Filters
- Vector Similarity
- LLM Reasoning

9. Explainability is mandatory.

Every candidate ranking should include:

- similarity_score
- matched_skills
- missing_skills
- AI explanation

10. Never expose raw LLM responses directly to the frontend.

Always transform them into DTOs.