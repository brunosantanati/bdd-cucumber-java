# language: pt

Funcionalidade: Propondo lances ao leilão

Cenário: Propondo um único lance válido
 Dado um lance válido
 Quando propõe ao leilao
 Então o lance é aceito
 
Cenário: Propondo vários lances válidos
 Dado vários lances válidos
 Quando propõe vários lances ao leilao
 Então os lances são aceitos