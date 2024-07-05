###### Projeto em Arquitetura Hexagonal

Projeto com API de Pedidos (/pedidos) que permite a criação do pedido bem como a consulta de Status.

Os pedidos são persistidos em uma base de dados MongoDB

Após a criação do pedido é enviado a uma fila Kafka da Transportadora que a consome e altera o status de AGUARDANDO_ENVIO para ENVIADO_TRANSPORTADORA.

Abaixo o payload para criação do pedido:

{
    "cliente": "Universidade FAAP",
    "produtos": [1,2,5,7]
}
