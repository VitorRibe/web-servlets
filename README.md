# Jakarta Enterprise Edition: Servlets
Trabalho realizado para a disciplina de Desenvolvimento WEB do 5º período em Ciência da Computação



---

## Como compilar e rodar
1. Abra o NetBeans e importe/abra o projeto Maven.  
2. Configure WildFly em **Tools → Servers** (apontar para a pasta do WildFly).  
3. Build/Run pelo NetBeans: `Run` → deploy no WildFly.  
4. Acesse `http://localhost:8080/<context>` (o context é o nome do projeto — ver output do deploy).

---

## Aplicações — funcionamento detalhado

### 1) Calculadora (GET)

<p align="center">
  <img src="dimages/calcHome.png" alt="Exemplo da aplicação 1" width="400"/>
</p>

- **Página:** `aplicacao1.html`  
- **Form:** `method="get"`, campos `num1` e `num2`  
- **Servlet:** `CalculadoraServlet`  
- **Classe de negócio:** `Calculadora.java`

**Fluxo**
1. Usuário envia dois números via GET.  
2. Servlet lê e converte os parâmetros (`num1`, `num2`).  
3. Chama `Calculadora.java` que retorna soma, subtração, multiplicação e divisão.  
4. Resposta exibida em HTML.


---

### 2) Distância entre pontos (POST)
- **Página:** `aplicacao2.html`  
- **Form:** `method="post"`, campos `x1`, `y1`, `x2`, `y2`  
- **Servlet:** `DistanciaServlet`  
- **Classe de negócio:** `Ponto.java`

**Fluxo**
1. Form envia POST para `/distancia`.  
2. Servlet cria objetos `Ponto` e calcula a distância com `p1.distancia(p2)`.  
3. Resultado exibido em HTML com botão de voltar.

**Exemplo:**  
Entrada: (0,0) e (3,4) → Saída: `5.0`

---

### 3) Calculadora de IMC (POST)
- **Página:** `aplicacao3.html`  
- **Form:** `method="post"`, campos `peso` (kg), `altura` (m)  
- **Servlet:** `IMCServlet`  
- **Classe de negócio:** `IMC.java` com `ResultadoIMC`

**Fluxo**
1. Servlet recebe peso e altura.  
2. Chama `IMC.calcular(peso, altura)` → retorna valor do IMC e classificação.  
3. HTML exibe:
   - Texto com resultado.  
   - Barra colorida (`div.imc-scale`) proporcional ao IMC.  
   - Legenda com faixas (`<18.5`, `18.5–24.9`, `25–29.9`, `>=30`).  
   - Botão de voltar estilizado.

---

## CSS
- Estilos definidos em `style.css`, aplicado a todas as páginas.  
- Barra de IMC centralizada e limitada em largura:
```css
.imc-scale {
  width: 400px;
  max-width: 90%;
  margin: 20px auto;
  height: 20px;
  background: #ddd;
  border-radius: 8px;
}
