[DEVCOMMERCE 2016](http://devcommerce2016.imasters.com.br)  
Microservices - Poderes, padrões e dificuldades
---
por [Marcos Barbero](http://linkedin.com/in/marcosbarbero)

O que são micro-serviços?
---
>In short, the microservice architectural style is an approach to developing a single application as a suite of small services, each running in its own process and communicating with lightweight mechanisms, often an HTTP resource API. These services are built around business capabilities and independently deployable by fully automated deployment machinery. There is a bare minimum of centralized management of these services, which may be written in different programming languages and use different data storage technologies.
>
>-- James Lewis and Martin Fowler

Pre-requisitos / Desafios
---
  - Configurações centralizadas
  - Service Discovery & Registration
  - Edge Services: Micro Proxies e API Gateways
    - Roteamento e balanceamento
  - Tolerância à falhas (Circuit Breakers)
  - Security and Single Sign-On
  - Complexidade Operacional
    - Monitoração
    - Distributed Tracing
  - Cultura DevOps

O que *NÃO* são micro-serviços?
---
Quebrar uma aplicação em vários serviços menores não significa que você esteja em uma arquitetura de micro-serviços. Esse é apenas o primeiro passo.

Welcome to the Jungle Pattern
---
![Pattern 01](https://github.com/marcosbarbero/devcommerce2016-microservices-power-patterns-pains/wiki/jungle-pattern-01.png)
  - Segundo cenário
![Pattern 02](https://github.com/marcosbarbero/devcommerce2016-microservices-power-patterns-pains/wiki/jungle-pattern-02.png)

Configurações
---
Uma das boas praticas fornecidas pelo manifesto [12factor](http://12factor.net/) é a externalização de configurações do build, assim o mesmo build poderá ser promovido qualquer ambiente: Dev, QA, Prod.  
  
Ferramentas:
  - Spring Cloud Config
  - Netflix Archaius
  - Apache Zookeeper
  - HashiCorp Consul
 
![Cloud Bus Flow](https://github.com/marcosbarbero/devcommerce2016-microservices-power-patterns-pains/wiki/cloud-bus-flow.png)  

Service Discovery & Registration
---
Novas aplicações (e instâncias) podem iniciar ou parar e o local dela pode mudar, é importante desacoplar do *client* o endereço do serviço. Pense no *Service Discovery & Registration* como um catálogo onde os endereços das instâncias são encontrados à partir do nome lógico.
  
Ferramentas:
  - Netflix Eureka
  - Apache Zookeeper
  - HarshiCorp Consul

![Service Discovery & Registration](https://github.com/marcosbarbero/devcommerce2016-microservices-power-patterns-pains/wiki/service-discovery-flow.png)

Roteamento e Balanceamento (Client Side)
---
Um dos benefícios de usar um *Service Discovery* é o balanceamento do lado do client. Esse balanceamento permite a aplicação escolher uma instância mesmo que exista 10 ou 1000 instancias rodando.
  
Ferramentas
  - Netflix Ribbon
  - Netflix Feign

![Client side load balancing](https://github.com/marcosbarbero/devcommerce2016-microservices-power-patterns-pains/wiki/client-side-load-balancing-flow.png)

API Gateway Pattern
---
Balanceamento do lado do client é usado somente entre comunicações entre serviços. Serviços que vivem na *borda* do datacenter, expostos para o tráfego público, são expostos por um DNS.

Responsabilidades:
  - Roteamento
  - CORS
  - Segurança
  - Etc

![API Gateway](https://github.com/marcosbarbero/devcommerce2016-microservices-power-patterns-pains/wiki/api-gateway-pattern-01.png)

Tolerância à falhas
---
Na arquitetura de micro-serviços é crítico que os serviços sejam escritos para serem tolerantes à falhas. Se alguma coisa acontecer o serviço deverá se degradar sem causar maiores impactos. Em sistemas distribuídos se o serviço não for desenhado para tolerar falhas isso poderá ocasionar um efeito dominó através de outros serviços.

Ferramentas
  - Play Framework
  - Netflix Hystrix

![Circuit Breaker](https://github.com/marcosbarbero/devcommerce2016-microservices-power-patterns-pains/wiki/circuit-breaker-flow-01.png)
![Circuit Breaker](https://github.com/marcosbarbero/devcommerce2016-microservices-power-patterns-pains/wiki/circuit-breaker-flow-02.png)

Segurança & Single Sign-On
---
Segurança é difícil, e em sistemas distribuídos é crítico verificar a procedência e autenticidade de um request através de multiplos serviços. Nesse modelo arquitetural todas as requisições devem chegar através de um ponto único de entrada (API Gateway), centralizando em um único ponto as chances de ataque de um invasor. Existem muitas estratégias de segurança para APIs e tudo depende do modelo de negócio e estratégia de segurança que deverá ser adotada. OAuth2 é um padrão bem popular na segurança de APIs.

Ferramentas
  - Spring Security OAuth

Complexidade Operacional
---
Uma das vantagens de se trabalhar com micro-serviços são os deploys independentes e serviços mais simples, por outro lado, sistemas distribuídos trazem algumas dificuldades em níveis operacionais.

Monitoração
---
Monitoração é uma parte importante para qualquer aplicação em qualquer modelo arquitetural, e se torna uma tarefa difícil se não forem tomados os devidos cuidados durante o desenvolvimento. Todo serviço deve nascer com pelo menos um monitoramento básico.

Ferramentas
  - Spring Boot Actuator
  - Dropwizard
  - ELK
  - Graylog
  - Statsd
  - Graphite
  
Distributed Tracing
---
Outra tarefa difícil para micro-serviços é fazer a correlação dos requests através de multiplos serviços e entender onde alguma coisa possa estar falhando.

Ferramentas
  - Spring Cloud Sleuth
  - Apache HTrace
  - Twitter Zipkin

Cultura DevOps
---

A sobrevivência não é obrigatória
---
>It is not necessary to change. Survival is not mandatory. -W. Edwards Deming

Links
---
```
{
 "microservices": {
    "definition": "http://martinfowler.com/microservices",
    "trade-offs": "http://martinfowler.com/articles/microservice-trade-offs.html",
    "prerequisites": "http://martinfowler.com/bliki/MicroservicePrerequisites.html",
    "12factor": "http://12factor.net",
    "security": "http://presos.dsyer.com/decks/oauth-rest.html",
    "inspiration": "https://dzone.com/articles/the-power-patterns-and-pains-of-microservices"
  },
 "email": "marcos.hgb@gmail.com"
 "linkedin": "http://linkedin.com/in/marcosbarbero"
} 
``` 
