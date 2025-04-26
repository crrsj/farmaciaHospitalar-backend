# 🏥 Farmácia Hospitalar

> Sistema completo com **frontend moderno** e **API em Java com Spring Boot** para gerenciamento de comandas hospitalares, com medicamentos e materiais, otimizando a rotina de hospitais e clínicas.

---

## 🌐 Visão Geral

O sistema **Farmácia Hospitalar** foi desenvolvido com foco em **eficiência, rastreabilidade e facilidade de uso** no processo de requisições internas de materiais e medicamentos hospitalares.

Ele é composto por:

- 💻 **Frontend interativo e responsivo** (HTML, CSS, JS, Bootstrap)
- 🧠 **Backend robusto em Java com Spring Boot**

> ⚠️ A API ainda está em desenvolvimento e passará por **ajustes e melhorias** nas próximas versões, incluindo validações mais avançadas, controle de permissões e otimizações de performance,
>  documentação,etc.

---

## 🚀 Tecnologias Utilizadas

### 🎯 Backend (API REST)

- ☕ **Java 21+**
- 🌱 **Spring Boot**  
- 🔄 **Spring Web** (para criação da API REST)
- 🧩 **Spring Data JPA** (para persistência de dados)
- 🐘 **PostgreSQL** (ou qualquer banco relacional via JPA)- 
- 📄 **Documentação com Swagger/OpenAPI**
- 🧾 **Validações com Bean Validation (javax.validation)**
- 🔐 **Tratamento de exceções e retornos adequados com ResponseEntity**

### 🎨 Frontend

- 🌐 **HTML5**
- 🎨 **CSS3 + Bootstrap 5**
- 🧠 **JavaScript Vanilla**
- 📅 **Flatpickr** (input de datas)
- 🔁 Integração com API por meio de `fetch`

---

## 🔧 Funcionalidades

✅ Cadastro de comandas médicas:  
- Setor de origem e destino  
- Médico, especialidade, paciente  
- Observações clínicas

✅ Adição de:
- 💊 Medicamentos
- 🧰 Materiais

✅ Integração com API:
- 📬 Envio de comandas via POST
- 📋 Listagem de todas as comandas
- 🔍 Busca por código da comanda

✅ Estrutura RESTful:
- Endpoints organizados por recursos
- Separação em camadas: Controller, Service, Repository, DTO

---

## 📦 Estrutura da API

📦 farmácia-api ├── 📁 controller ├── 📁 service ├── 📁 repository ├── 📁 dto ├── 📁 model ├── 📄 application.properties

yaml
Copiar
Editar

---

## 🛠️ Em Desenvolvimento

- [x] Integração inicial da API com frontend  
- [ ] Adição de autenticação/autorização  
- [ ] Melhorias nas validações e nos retornos de erro  
- [ ] Documentação detalhada da API (Swagger)  
- [ ] Paginação e filtros nas listagens  

---

## ✍️ Autor

**Carlos Roberto Ribeiro Santos Junior**  
💼 Desenvolvedor Java Backend & Fullstack  
📍 Aracaju - SE  

---

> “Tecnologia a serviço da saúde, com agilidade, organização e segurança.”
>
> 
