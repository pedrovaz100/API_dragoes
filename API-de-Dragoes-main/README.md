# 🐉 API de Dragões

API REST desenvolvida com **Java e Spring Boot** para controlar uma coleção de dragões do reino.  
Permite **criar, listar, atualizar e remover dragões** através de endpoints REST.

Este projeto foi desenvolvido para prática de **construção de APIs e integração com frontend**.

---

# ⚙️ Tecnologias Utilizadas

- Java 17
- Spring Boot 3
- Maven
- Lombok
- REST API

---


# 🌐 Endpoints da API

| Método | Endpoint | Descrição |
|------|------|------|
| GET | `/dragons` | Lista todos os dragões |
| GET | `/dragons/{id}` | Busca um dragão pelo ID |
| POST | `/dragons` | Cria um novo dragão |
| PUT | `/dragons/{id}` | Atualiza um dragão |
| DELETE | `/dragons/{id}` | Remove um dragão |

---

# 📦 Exemplo de JSON

```json
{
  "id": 1,
  "nome": "Ignis",
  "cor": "Vermelho",
  "poderDeFogo": 950,
  "peso": 3500.5,
  "altura": 18.7,
  "possuiMontador": true
}