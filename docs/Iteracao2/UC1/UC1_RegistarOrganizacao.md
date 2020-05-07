# UC1 - Registar Organização

## 1. Engenharia de Requisitos

### Formato Breve

O utilizador não registado inicia o registo de uma organização. O sistema solicita os dados necessários sobre a organização (i.e. nome da organização, o NIF, o endereço postal, um contacto telefónico, o endereço web, email) e sobre o colaborador (i.e. gestor) que está a proceder ao registo (i.e. nome, função, contacto telefónico e email). O utilizador não registado introduz os dados solicitados. O sistema valida e apresenta os dados, pedindo que os confirme. O utilizador não registado confirma. O sistema regista os dados da organização e  do seu colaborador/gestor, tornando este último um utilizador registado, **remetendo-lhe a sua palavra-passe (gerada pelo sistema) por email** e informa o utilizador não registado do sucesso da operação.

### SSD
![UC1_SSD.svg](UC1_SSD.svg)


### Formato Completo

#### Ator principal

Utilizador Não Registado

#### Partes interessadas e seus interesses
* **Utilizador Não Registado:** pretende regista a organização a que pertence para que possa usufruir das funcionalidade disponibilizadas pela plataforma.
* **T4J:** pretende que a organização em causa se registe de modo usar a plataforma.


#### Pré-condições
n/a

#### Pós-condições
* A informação da organização é guardada no sistema.
* A informaçao do gestor é guardada no sistema.
* É criado um utilizador na plataforma para o Gestor.
* É enviado um email ao Gestor com a informação de acesso à plataforma.

#### Cenário de sucesso principal (ou fluxo básico)

1. O utilizador não registado inicia o registo de uma organização. 
2. O sistema solicita os dados necessários sobre a organização (i.e. nome da organização, o NIF, o endereço postal, um contacto telefónico, o endereço web, email) e sobre o colaborador (i.e. gestor) que está a proceder ao registo (i.e. nome, função, contacto telefónico, email e pwd). 
3. O utilizador não registado introduz os dados solicitados. 
4. O sistema valida e apresenta os dados, pedindo que os confirme. 
5. O utilizador não registado confirma. 
6. O sistema regista os dados da organização e  do seu colaborador/gestor, tornando este último um utilizador registado, **remetendo-lhe a sua palavra-passe (gerada pelo sistema) por email** e informa o utilizador não registado do sucesso da operação.

#### Extensões (ou fluxos alternativos)

*a. O utilizador não registado solicita o cancelamento da registo.

> O caso de uso termina.

4a. Dados de Endereço Postal incompletos.
>	1. O sistema informa quais os dados em falta.
>	2. O sistema permite a introdução dos dados em falta (passo 3)
>
	>	2a. O utilizador não registado não altera os dados. O caso de uso termina.
	
4b. Dados mínimos obrigatórios em falta.
>	1. O sistema informa quais os dados em falta.
>	2. O sistema permite a introdução dos dados em falta (passo 3)
>
	>	2a. O utilizador não registado não altera os dados. O caso de uso termina.

4c. O sistema deteta que o **NIF ou email** introduzidos devem ser únicos e que já existem no sistema.
>	1. O sistema alerta o utilizador não registado para o facto.
>	2. O sistema permite a sua alteração (passo 3)
>
	>	2a. O utilizador não registado não altera os dados. O caso de uso termina.


#### Requisitos especiais
\- A palavra-passe do gestor é gerada por um algoritmo externo.

#### Lista de Variações de Tecnologias e Dados
\-

#### Frequência de Ocorrência
\-

#### Questões em aberto

* Existem outros dados obrigatórios para além dos já conhecidos?
* ~~Quais os dados que em conjunto permitem detetar a duplicação de organizações (e de gestores)?~~
* É necessário existir algum mecanismo de segurança adicional para confirmar que a organização existe e é representada pela pessoa que a registou?
* ~~Quais são as regras de segurança aplicaveis à palavra-passe?~~
* Qual a frequência de ocorrência deste caso de uso?


## 2. Análise OO

### Excerto do Modelo de Domínio Relevante para o UC

![UC1_MD.svg](UC1_MD.svg)


## 3. Design - Realização do Caso de Uso

### Racional

| Fluxo Principal | Questão: Que Classe... | Resposta  | Justificação  |
|:--------------  |:---------------------- |:----------|:---------------------------- |
|1. O utilizador não registado inicia o registo de uma organização.|... interage com o utilizador?| RegistarOrganizacaoUI |Pure Fabrication|
| |... coordena o UC?| RegistarOrganizacaoController |Controller|
| |... cria instâncias de Organizacao?|RegistoOrganizacoes|Pela aplicação do Creator (R1) seria a “Plataforma".Mas, por aplicação de HC+LC à “Plataforma", esta delega essa responsabilidade na “RegistoOrganizacoes".|
|2. O sistema solicita os dados necessários sobre a organização (i.e. nome da organização, o NIF, o endereço postal, um contacto telefónico, o endereço web, email) e sobre o colaborador (i.e. gestor) que está a proceder ao registo (i.e. nome, função, contacto telefónico, email e pwd).||||
|3. O utilizador não registado introduz os dados solicitados. |... guarda os dados introduzidos?|Organizacao, EnderecoPostal, Colaborador|IE: instância criada no passo 1|
| |... cria instâncias de EnderecoPostal?|Organizacao|creator(regra1)|
| |... cria instâncias de Colaborador?|Organizacao|creator(regra1)|
|4. O sistema valida e apresenta os dados, pedindo que os confirme. |... valida os dados da Organizacao (validação local)|Organizacao|IE: possui os seus próprios dados|
| |... valida os dados da Endereço Postal (validação local)|EnderecoPostal|IE: possui os seus próprios dados|
| |... valida os dados do Colaborador (validação local)|Colaborador|IE: possui os seus próprios dados|
| |... valida os dados da Organizacao (validação global)|RegistoOrganizacoes|IE: O RegistoOrganizacoes tem registadas Organizacao|
|5. O utilizador não registado confirma. ||||
|6. O sistema regista os dados da organização e  do seu colaborador/gestor, tornando este último um utilizador registado, **remetendo-lhe a sua palavra-passe (gerada pelo sistema) por email** e informa o utilizador não registado do sucesso da operação.|... guarda a Organizacao criada?| RegistoOrganizacoes |IE: Por aplicação de HC+LC à Plataforma|
| |...gera a palavra-passe|AlgoritmoGeradorPasswords|Protected Variation|
| |... regista/guarda o Utilizador referente ao Colaborador da Organizacao?|AutorizacaoFacade|IE. A gestão de utilizadores é responsabilidade do componente externo respetivo cujo ponto de interação é através da classe "AutorizacaoFacade"|
| |...envia o email do gestor|RegistoOrganizacoes|IE: detem a informação necessária.|
             

### Sistematização ##

 Do racional resulta que as classes conceptuais promovidas a classes de software são:

 * Plataforma
 * Organizacao
 * Colaborador
 * EnderecoPostal
 * AlgoritmoGeradorPasswords


Outras classes de software (i.e. Pure Fabrication) identificadas:  

 * RegistarOrganizacaoUI  
 * RegistarOrganizacaoController
 * AutorizacaoFacade (do componente de gestão de utilizadores)
 * RegistoOrganizacoes



###	Diagrama de Sequência

![UC1_SD.svg](UC1_SD.svg)

![UC1_SD_User.svg](UC1_SD_User.svg)

###	Diagrama de Classes

![UC1_CD.svg](UC1_CD.svg)

---

![UC1_CD_GerarPwd.svg](UC1_CD_GerarPwd.svg)

