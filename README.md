# DesafioDB
Instalar extensão Chrome driver.
Baixar Selenium WebDriver e colocar em C:

Configurando tecnologia:
1. Instalar Eclipse EE JAVA.
2. Criar um novo JavaProject no Eclipse (File > New > JavaProject).
4. Em Project name, informar o nome e clicar em Finish.
5. Clicar com o botão direito no projeto e ir até Build path, clicar em Configura Build Path.
6. Na aba Libraries, clicar em "Add External JARs...", selecionar o local do Selenium WebDriver (C:), abrir os dois arquivos .jar
7. Clicar em "Add External JARs..." e selecionar todos os arquivos da pasta "libs" do Selenium WebDriver.
8. Clicar em "Add Library...", selecionar "JUnit" e clicar em "Next >", em JUnit library version, selecionar a opção JUnit 4 e clicar em Finish.
9. Na janela de propriedades do projeto (Java Build Path), clicar em Apply and Close.

Criar uma classe de teste:
1. Clicar com o botão direito na pasta scr e selecione "New" e "JUnit Test Case".
2. Selecionar a opção New JUnit 4 teste.
3. Em Source folder, informar o nome da classe. 
4. Clicar em Finish

Execução do script
1. Após importar o projeto na tecnolgia, clicar em Run, automaticamente executará a classe Elementos.java, na qual encontram-se todos os métodos.
