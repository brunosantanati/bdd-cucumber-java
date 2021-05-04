# language: pt

Funcionalidade: Propondo lances ao leilão

Cenário: Propondo um único lance válido
 Dado um lance válido
 Quando propõe ao leilao
 Então o lance é aceito
 
Cenário: Propondo vários lances válidos
 Dado um lance de 10.0 reais do usuário fulano
 E um lance de 15.0 reais do usuário beltrano
 Quando propõe vários lances ao leilao
 Então os lances são aceitos