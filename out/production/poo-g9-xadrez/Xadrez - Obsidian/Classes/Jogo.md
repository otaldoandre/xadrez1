Controla a partida, sabe a situação, de quem é a vez, controla jogadas possíveis e mantém registro de tudo. Controla a interface e mostra todas as ações conforme acontecem. (Talvez a parte gráfica seja delegada a outra classe futuramente).

Deve conter:
`boolean jogadaValida(linhaO, colunaO, linhaD, colunaD);`
`void realizaJogada(linhaO, colunaO, linhaO, colunaD);`
`string registroJogo(); // retorna a saída que vai pro arquivo de salvamento`
