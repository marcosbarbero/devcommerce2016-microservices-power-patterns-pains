[DEVCOMMERCE 2016](http://devcommerce2016.imasters.com.br) Microservices - Poderes, padrões e dificuldades
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
  - Fault Tolerance (Circuit Breakers)
  - Monitoração
  - Distributed Tracing
  - Security and Single Sign-On

O que *NÃO* são micro-serviços?
---
Quebrar uma aplicação em vários serviços menores não significa que você esteja em uma arquitetura de micro-serviços. Esse é apenas o primeiro passo.

Welcome to the jungle Pattern
---
![Pattern 01](https://github.com/marcosbarbero/devcommerce2016-microservices-power-patterns-pains/wiki/jungle-pattern-01.png)
  - Segundo cenário
![Pattern 02](https://github.com/marcosbarbero/devcommerce2016-microservices-power-patterns-pains/wiki/jungle-pattern-02.png)

Configurações
---
Uma das boas praticas fornecidas pelo manifesto [12factor](http://12factor.net/) é a externalização de configurações do build, assim o mesmo build poderá ser promovido qualquer ambiente: Dev, QA, Prod.  
  
Tools:
  - Spring Cloud Config
  - Netflix Archaius
  - Apache Zookeeper
  - HashiCorp Consul
 
![Cloud Bus Flow](https://github.com/marcosbarbero/devcommerce2016-microservices-power-patterns-pains/wiki/cloud-bus-flow.png)  

Service Discovery & Registration
---
Novas aplicações (e instâncias) podem iniciar ou parar e o local dela pode mudar, é importante desacoplar do *client* o endereço do serviço. Pense no *Service Discovery & Registration* como um catálogo onde os endereços das instâncias são encontrados à partir do nome lógico.
  
Tools:
  - Netflix Eureka
  - Apache Zookeeper
  - HarshiCorp Consul

![Service Discovery & Registration](https://github.com/marcosbarbero/devcommerce2016-microservices-power-patterns-pains/wiki/service-discovery-flow.png)

Roteamento e Balanceamento (Client Side)
---
Um dos benefícios de usar um *Service Discovery* é o balanceamento do lado do client. Esse balanceamento permite a aplicação escolher uma instância mesmo que exista 10 ou 1000 instancias rodando.

![Client side load balancing](https://github.com/marcosbarbero/devcommerce2016-microservices-power-patterns-pains/wiki/client-side-load-balancing-flow.png)

API Gateway Pattern
---
![API Gateway](https://github.com/marcosbarbero/devcommerce2016-microservices-power-patterns-pains/wiki/api-gateway-pattern-01.png)

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
    "prerequisites": "http://martinfowler.com/bliki/MicroservicePrerequisites.html"
    "12factor": "http://12factor.net"
  },
 "reference": "https://dzone.com/articles/the-power-patterns-and-pains-of-microservices"
 "email": "marcos.hgb@gmail.com"
 "linkedin": "http://linkedin.com/in/marcosbarbero"
} 
``` 
