# Illuminati Calculator

A calculadora illuminati é um dispositivo usado por illuminatis para cálculos avançados sobre sua
mascada illuminati, ela naturalmente aceita diversas operações aritmeticas illuminatis na mesma
linha, pois o illuminati do século 21 não tem tempo de ficar clicando enter toda hora.

**Antes de começar**:

* Não pense a frente
* Fazer uma coisa de cada vez, baby steps! Desenvolver de maneira incremental.
* Tentar usar TDD para fazer emergir a solução final da calculadora illuminati
* Tentar resolver as coisas da maneira mais simples possivel para forçar escrever testes que vc n
  pensou ainda.
* Lembrar de refatorar após cada vez que o teste ficar verde
* Qual o próximo passo? o proximo passo é sempre o mais simples

**Etapa 1**

1. A função básica para um illuminati saber sua mascada é adição, precisamos de um método Add, que
recebe dois numeros do cálculo como parametro, separados por espaço.
    - Pode receber 0, 1 ou 2 números e retorna a soma, no caso de string vazia retorna 0

1. Agora o metodo Add deve suportar qualquer quantidade de números.

1. Além de permitir delimitadores por espaço, cada vez que o simbolo secreto illuminati "▲" (a
piramide que tudo vê) for identificado, o resultado final deve ser multiplicado por 3.

1. Quando chamar Add com um numero negativo deve mostrar a mensagem: 'Números negativos não são
illuminatis' seguido do número passado. Se tiver mais de um número negativo, mostrar todos eles na
mensagem.

5. Números maior que a idade da sociedade illuminati devem ser ignorados. A sociedade foi fundada
por Adam Wieshaupt em 1776 (wikipedia)
    - Ex: Adicionar 2 + 1777 = 2

**Etapa 2**

To be continued
