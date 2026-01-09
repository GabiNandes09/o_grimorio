# 🧙‍♂️ O Grimório

![Kotlin](https://img.shields.io/badge/Kotlin-2.3.0-purple?style=for-the-badge&logo=kotlin)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android)
![Compose](https://img.shields.io/badge/Jetpack%20Compose-4285F4?style=for-the-badge&logo=android)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=for-the-badge)

> *“Todo grande mestre precisa de segredos bem guardados. O Grimório é o seu auxiliar digital para narrar o caos e a glória de cada combate.”*

## 📜 Sobre o Projeto

**O Grimório** é um aplicativo Android nativo desenvolvido para auxiliar Mestres e Jogadores de RPG de mesa (TTRPG).  
O objetivo é eliminar a pausa de consultar tabelas físicas, oferecendo de forma rápida e intuitiva descrições de **Acertos Críticos** e **Falhas Críticas**.

Os efeitos são curados manualmente com temática medieval e mágica, priorizando imersão visual e simplicidade de uso.

## ⚔️ Funcionalidades

- Seleção entre **Sucesso Crítico** e **Falha Crítica**
- Categorias de dano:
  - Cortante
  - Perfurante
  - Concussão
  - Ataque à Distância
  - Mágico
- Banco de dados local (Room), totalmente offline
- Interface imersiva com Jetpack Compose
- Sorteio ponderado baseado na quantidade de efeitos por categoria
- Onboarding interativo na primeira execução

## 📱 Screenshots

| Tela Inicial | Seleção de Categoria | Efeito Gerado |
|-------------|---------------------|---------------|
| ![Home](assets/print_tela_inicial.jpg) | ![Seleção](assets/print_3.jpg) | ![Resultado](assets/print_critico.jpg) |

## 🛠 Tech Stack & Arquitetura

- **Linguagem:** Kotlin [Kotlin](https://kotlinlang.org/)
- **UI:** Jetpack Compose [Jetpack Compose](https://developer.android.com/jetpack/compose) (UI Declarativa)
- **Arquitetura:** MVVM
- **DI:** Koin [Koin](https://insert-koin.io/)
- **Persistência:** Room Database [Room Database](https://developer.android.com/training/data-storage/room)
- **Navegação:** Navigation Compose
- **Assincronismo:** Coroutines e Flow
- **Min SDK:** API 29 (Android 10)

## 🚀 Como Rodar o Projeto

### Pré-requisitos

- Android Studio atualizado
- JDK 17+
- Dispositivo ou emulador com Android 10 ou superior

### Instalação

```bash
git clone https://github.com/SEU-USUARIO/o-grimorio.git
```

Abra o projeto no Android Studio, aguarde a sincronização do Gradle e execute o aplicativo.

> Na primeira execução, o banco de dados é populado automaticamente.

## 🗺️ Roadmap e Próximos Passos

O Grimório foi concebido para escalar. O planejamento futuro visa transformar o app de uma ferramenta *offline* para uma plataforma de conteúdo comunitário e analítico.

### Curto Prazo (UX e Personalização)
* [ ] **Feedback Sonoro:** Implementação de efeitos de áudio (SFX) para interações de UI e momento do sorteio ("Roll").
* [ ] **Personalização de Temas:** Permitir que o usuário altere o background da aplicação (presets iniciais e upload de imagem customizada).
* [ ] **Histórico de Combate:** Log local das últimas rolagens efetuadas para consulta rápida.

### Médio Prazo (Gerenciamento de Dados & Analytics)
* [ ] **Editor de Conteúdo (CRUD):** Interface para o usuário Adicionar, Editar e Remover seus próprios efeitos e categorias localmente.
* [ ] **Dashboard de Estatísticas:** Visualização de métricas de uso, incluindo contagem total de Acertos vs. Falhas, frequência de uso por categorias e ranking dos efeitos mais sorteados.
* [ ] **Compartilhamento:** Funcionalidade para exportar o resultado do crítico como imagem ou texto para outros apps (Discord/WhatsApp).

### Longo Prazo (Cloud & Comunidade)
* [ ] **Autenticação de Usuário:** Sistema de Login e Criação de Conta.
* [ ] **API & Cloud Sync:** Migração para arquitetura híbrida, permitindo salvar customizações na nuvem.
* [ ] **Sistema de Contribuição:** Usuários poderão enviar seus efeitos criados para uma fila de auditoria. Após aprovação, esses efeitos tornam-se "Registros Padrão" para toda a base de usuários.

## 📝 Licença

Projeto proprietário para fins de portfólio e uso pessoal.  
Todos os direitos reservados.

Desenvolvido com Kotlin.
