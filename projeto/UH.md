
**Cadastro e Acesso ao Sistema**

História: Como um usuário (cliente ou agente), desejo realizar um cadastro no sistema para ter acesso às funcionalidades de gestão de pedidos e contratos.

Critérios de aceitação:

 - O sistema deve permitir o cadastro de clientes e agentes.
 - Os dados devem incluir informações de identificação, como RG, CPF,
   nome, endereço, profissão, entidades empregadoras e rendimentos
   (máximo de 3). 
 - Após o cadastro, o usuário só poderá acessar o sistema    mediante
   login.

**Gestão de Pedidos de Assinatura (Clientes)**

História: Como um cliente, desejo introduzir um pedido de assinatura de automóvel para que possa alugar um veículo por um período de 12, 24, 36 ou 48 meses.

Critérios de Aceitação:

 - O sistema deve permitir ao cliente selecionar o período de assinatura
   e os detalhes do veículo (marca, modelo, ano, placa).
 - O cliente pode optar por adicionar a opção de compra do veículo ao
   final do contrato.

Como um cliente, desejo modificar, consultar ou cancelar meu pedido de assinatura para poder ajustar ou visualizar os detalhes antes da análise.

Critérios de Aceitação:

 - O sistema deve permitir a modificação de pedidos antes da avaliação
   financeira.
 - O cliente deve poder consultar o status atual do pedido e cancelar
   antes da avaliação final.

**Avaliação de Pedidos (Agentes)**

Como um agente (empresa ou banco), desejo avaliar os pedidos de assinatura de clientes para realizar a análise financeira e determinar se o contrato pode ser aprovado.

Critérios de Aceitação:

 - O sistema deve permitir que o agente revise as informações
   financeiras do cliente, incluindo rendimentos e empregadores.
 - O agente pode aprovar ou rejeitar o pedido baseado na análise
   financeira, e o cliente deve ser notificado sobre a decisão.
   
**Execução e Propriedade do Veículo**

Como um agente, desejo registrar que o contrato foi executado para garantir que o veículo foi entregue ao cliente e que os termos do contrato estão em vigor.

Critérios de Aceitação:

 - O sistema deve registrar a execução do contrato após a aprovação.
 - Se a opção de compra for selecionada, o sistema deve emitir a
   documentação de propriedade em nome do contratante.
