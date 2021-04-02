--
-- Data for Name: institutions; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO institutions (id, description, name) VALUES (1, 'AV. AGUIA DE HAIA, 2983 - Cidade A. E. Carvalho
CEP 03694-000 - São Paulo/SP
Telefone: (11) 20492600 R:201/202/205/206
E-mail: f111dir@cps.sp.gov.br', 'Fatec Zona Leste');
INSERT INTO institutions (id, description, name) VALUES (2, 'Av. Tiradentes, 615 - Bom Retiro
CEP 01101-010 - São Paulo/SP
Telefone: (11) 3322-2200 / (11) 3322-2213
E-mail: secaluno@fatecsp.br
Site: www.fatecsp.br', 'Fatec São Paulo');


--
-- Data for Name: courses; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO courses (id, code, description, image_url, name, total_semesters, institution_id) VALUES (1, 'ADS', 'A matemática, em especial raciocínio lógico e cálculo, é necessária para que o aluno aprenda a otimizar computadores e a desenvolver softwares. O aluno recebe noções sobre Bancos de Dados, sistemas baseados em web (como serviços bancários pela internet) e programação distribuída, que conecta computadores em rede para que funcionem como se fossem um só computador. Administração, contabilidade, economia, estatística e inglês também fazem parte do currículo. Além disso, habilidades para leitura e interpretação de textos são fundamentais para o aprendizado durante o curso. Hoje, o mercado não aceita mais profissionais que se isolam na frente do computador. As empresas exigem pessoas versáteis, dinâmicas, que saibam trabalhar em equipe e possam ter contato com o usuário final do sistema.', 'http://www.fatecsp.br/img/ti.jpg', 'Análise e Desenvolvimento de Sistemas', 6, 1);
INSERT INTO courses (id, code, description, image_url, name, total_semesters, institution_id) VALUES (2, 'LOG', 'O estudante vai aprender a determinar custos, como fretes e tributos e a planejar rotas de transporte e entrega de mercadorias de maneira eficiente, com qualidade, dentro do prazo estabelecido e a preços competitivos. Por isso, são importantes as disciplinas de cálculo, estatística, matemática financeira, economia e finanças empresariais. O aluno também estuda meios de transporte, suas características e vantagens. Aprende ainda a fazer a gestão de um estoque, a criar embalagens de produtos que facilitem o armazenamento e o transporte e a utilizar softwares de simulação de cargas e roteiros. Gestão, comércio exterior, logística internacional, inglês e espanhol são as disciplinas que completam o currículo.', 'http://www.fateczl.edu.br/imagens/logistica.png', 'Logística', 6, 1);
INSERT INTO courses (id, code, description, image_url, name, total_semesters, institution_id) VALUES (3, 'COMEX', 'As disciplinas que oferecem base para o curso são administração, economia e comunicação. O aluno vai estudar matemática, estatística, gestão de custos e tributos, gestão financeira, logística, contabilidade, economia internacional e os idiomas inglês e espanhol. As matérias específicas de Comércio Exterior abrangem aspectos geográficos, históricos, políticos e econômicos. O estudante vai aprender sobre blocos econômicos, acordos comerciais firmados entre o Brasil e os demais países do mundo, os organismos internacionais que intervêm no setor, logística internacional, processos de exportação e importação, práticas cambiais, marketing internacional e direito internacional, entre outros temas.', 'http://www.fateczl.edu.br/imagens/comex.jpg', 'Comércio Exterior', 5, 1);
INSERT INTO courses (id, code, description, image_url, name, total_semesters, institution_id) VALUES (4, 'RH', 'Todos os assuntos são tratados com foco em pessoas, na sua relação com o trabalho. As disciplinas administração financeira, estatística, economia e legislação são os pilares para a aprendizagem de cálculos trabalhistas, análise de retorno de investimento em treinamento etc. Há ainda ênfase no estudo do comportamento do profissional no ambiente de trabalho. Como realizar recrutamento, seleção, treinamento de profissionais, definição de tarefas e funções de acordo com a habilidade de cada indivíduo e cuidados com a qualidade de vida no trabalho completam a formação.', 'http://www.fateczl.edu.br/imagens/gestao_rh.jpg', 'Gestão de Recursos Humanos', 5, 1);
INSERT INTO courses (id, code, description, image_url, name, total_semesters, institution_id) VALUES (5, 'GEM', 'Contabilidade, economia e administração são as bases de Gestão Empresarial. Direito tributário, logística, empreendedorismo, gestão ambiental, comportamento organizacional (postura do profissional no ambiente de trabalho) e utilização de ferramentas de marketing para motivar e orientar os funcionários também fazem parte da formação. O aluno também aprende a elaborar o planejamento estratégico, que define os objetivos de uma empresa a traçar as estratégias para alcançá-los, usando os recursos disponíveis de maneira eficiente.', 'http://www.fateczl.edu.br/imagens/gestaoempresarial.jpg', 'Gestão Empresarial', 5, 2);


--
-- Data for Name: disciplines; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO disciplines (id, code, description, name, objective, semester, course_id) VALUES (1, 'IAL-002', 'Projeto e representação de algoritmos. Estruturas de controle de fluxo de execução: sequencial, seleção e repetição. Tipos de dados básicos e estruturados (vetores e registros). Rotinas. Arquivos. Implementação de algoritmos usando uma linguagem de programação.', 'Algoritmos', 'Analisar problemas computacionais e projetar soluções por meio da construção de algorítmos.', 1, 1);
INSERT INTO disciplines (id, code, description, name, objective, semester, course_id) VALUES (2, 'ILP-010', 'Variáveis, constantes, operadores e expressões. Comando de desvio. Controle de malhas. Vetores e ponteiros. Funções de biblioteca. Estruturas, uniões e tipos definidos pelo usuário. Manipulação de arquivos.', 'Linguagem de Programação', 'Solucionar problemas utilizando a lógica de programação e a implementação de programas por meio de uma linguagem de programação.', 2, 1);
INSERT INTO disciplines (id, code, description, name, objective, semester, course_id) VALUES (3, 'IED-001', 'Pilhas, filas, alocação dinâmica, recursividade, listas encadeadas, tabelas de espalhamento e árvores.', 'Estrutura de Dados', 'Criar e manipular tipos abstratos de dados: listas, pilhas, filas e árvores', 3, 1);
INSERT INTO disciplines (id, code, description, name, objective, semester, course_id) VALUES (4, 'AGO-006', 'Definição de projeto segundo concepção difundida pelas melhores práticas de gestão de projetos. Histórico do desenvolvimento do conjunto de conhecimentos de gestão de projetos. Comparação entre o gerenciamento por projetos com o gerenciamento tradicional. O ciclo de vida de um projeto. Os fatores de sucesso e insucesso de projetos e sua mensuração. As nove de conhecimento para a gestão de projetos e seus processos: Integração, Escopo, Tempo, Custo, Qualidade, Recursos Humanos, Comunicações, Riscos e Aquisições.', 'Gestão de Projetos', 'Conhecer e aplicar técnicas, métodos e ferramentas para uma gestão eficaz de projetos.', 6, 1);
INSERT INTO disciplines (id, code, description, name, objective, semester, course_id) VALUES (5, 'IRC-100', 'Prática em laboratório de instalação física de redes e suas diversas topologias, instalação de equipamentos de conectividade, cabeamento estruturado, protocolos TCP/IP, algorítmos e protocolos de roteamento, análise de tráfego, protocolos de transporte TCP e UDP, protocolos de aplicação e instalação de servidores/serviços de redes.', 'Laboratório de Redes', 'Instalar redes.', 6, 1);
INSERT INTO disciplines (id, code, description, name, objective, semester, course_id) VALUES (6, 'CEE-002', 'Desenvolver plano de negócio para empreendimento em Tecnologia da Informação.', 'Empreendedorismo', 'Conceitos sobre empreendedorismo. Características e habilidades do empreendedor. O comportamento empreendedor: análise de oportunidades. O processo de geração de idéias e conceito de negócios. Meios para análise de oportunidades e idéias. Estratégia de negócios. Aspectos de planejamento, abertura, funcionamento e gerenciamento de um negócio. Instituições de apoio e financiamento. Desenvolvimento de planos de negócio.', 6, 4);
INSERT INTO disciplines (id, code, description, name, objective, semester, course_id) VALUES (7, 'IBD-002', 'Conceitos de Base de Dados. Modelos conceituais de informações. Modelos de Dados: Relacional, Redes e Hierárquicos. Modelagem de dados - conceitual, lógica e física. Teoria relacional: dependências funcionais e multivaloradas, formas normais. Restrições de integridade e de segurança em Banco de Dados Relacional. Sistemas Gerenciadores de Banco de Dados – objetivo e funções. Linguagens de declaração e de manipulação de dados.', 'Banco de Dados', 'Entender fundamentos, arquitetura e técnicas de projeto e implementação de banco de dados.', 4, 1);
INSERT INTO disciplines (id, code, description, name, objective, semester, course_id) VALUES (8, 'IBD-100', 'Tecnologias emergentes de mercado que serão aplicadas em laboratório.', 'Laboratório de Banco de Dados', 'Implementar soluções de Banco de Dados por meio de tecnologias emergentes.', 5, 1);
INSERT INTO disciplines (id, code, description, name, objective, semester, course_id) VALUES (9, 'IES-100', 'Objetivos, conceitos e evolução da Engenharia de Software. Paradigmas de desenvolvimento de software. Evolução das metodologias de sistemas e suas principais técnicas. Processo de desenvolvimento de software. Modelos de software. Ciclo de vida. Qualidade de software e seus modelos. Melhores práticas no desenvolvimento de software.', 'Engenharia de Software I', 'Aplicar os princípios e conceitos da Engenharia de Software na implementação do componente software, como parte dos Sistemas de Informação e iniciar a modelagem de software (requisitos).', 2, 1);
INSERT INTO disciplines (id, code, description, name, objective, semester, course_id) VALUES (10, 'IES-200', 'Contexto atual das empresas em relação aos projetos de tecnologia de informação. Modelagem de Negócio para o desenvolvimento de software. Conceitos, evolução e importância da Engenharia de Requisitos. Entendendo e analisando os problemas e as necessidades dos usuários, clientes e envolvidos no projeto. Técnicas de elicitação. Requisitos, seus tipos e matriz de rastreabilidade. Definição do sistema a partir dos requisitos. Gerenciamento de requisitos.', 'Engenharia de Software II', 'Aplicar um processo de desenvolvimento de software, ênfase na definição e elicitação dos requisitos.', 3, 1);
INSERT INTO disciplines (id, code, description, name, objective, semester, course_id) VALUES (11, 'IES-300', 'Conceitos, evolução e importância de arquitetura de software. Padrões de Arquitetura. Padrões de Distribuição. Camadas no desenvolvimento de software. Tipos de Arquitetura de Software. Visões na arquitetura de software. Modelo de Análise e Projetos. Formas de representação. O processo de desenvolvimento. Mapeamento para implementação. Integração do sistema. Testes: planejamento e tipos. Manutenção. Documentação.', 'Engenharia de Software III', 'Conhecer e aplicar padrões ao processo de software. Mapear modelos de representação.', 4, 1);
INSERT INTO disciplines (id, code, description, name, objective, semester, course_id) VALUES (12, 'ISG-003', 'Requisitos de segurança de aplicações, de base de dados e de comunicações. Segurança de dispositivos móveis. Políticas de segurança. Criptografia. Firewalls. Vulnerabilidades e principais tecnologias de segurança.', 'Segurança da Informação', 'Compreender e aplicar as melhores práticas de Segurança da Informação de acordo com normas e padrões conhecidos no mercado de TI.', 5, 1);


--
-- Data for Name: users; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO users (id, birth_date, creation_date, email, enabled, full_name, gender, password, course_id) VALUES (1, '2021-03-13', '2021-03-13 05:55:00.073', 'staff@fatecando.com', true, 'Staff Staff', 'MALE', '$2a$10$NjzYQyDU4sAsq1mZwbG6JupxuuF0DYHkPO5emwMEqb500.kF9RiS2', NULL);
INSERT INTO users (id, birth_date, creation_date, email, enabled, full_name, gender, password, course_id) VALUES (2, '2021-03-13', '2021-03-13 05:55:00.891', 'gustavo.almeida13@fatec.sp.gov.br', true, 'Gustavo Alves', 'MALE', '$2a$10$6hXmEBCXj/qYejdJGUZ/SuSZmJdo5GFhVnkjY8jksLYVPNZdwaZQe', 1);
INSERT INTO users (id, birth_date, creation_date, email, enabled, full_name, gender, password, course_id) VALUES (3, '2021-03-13', '2021-03-13 05:55:01.147', 'caique@gmail.com', true, 'Kayk Vida', 'MALE', '$2a$10$sSlUE7HxQrD9LO7izvds/.eI0X3vieD2ka9lt6jn/sBtPigXz91Q.', 1);
INSERT INTO users (id, birth_date, creation_date, email, enabled, full_name, gender, password, course_id) VALUES (4, '2021-03-13', '2021-03-13 05:55:01.454', 'kaizer@gmail.com', true, 'Kaizer Variola', 'MALE', '$2a$10$0d1LB1BGxZRZZEb6/sfFP.YHxzj6D9DuncKv2nmUvgWtc8.Pz50I6', 1);
INSERT INTO users (id, birth_date, creation_date, email, enabled, full_name, gender, password, course_id) VALUES (5, '2021-03-13', '2021-03-13 05:55:01.717', 'maria@hotmail.com', true, 'Maria Silva', 'FEMALE', '$2a$10$2UsFtP0eSTtgpxVaPcRq5uErs5WMH81jc4NDV/orqNxqrKkmCW5vm', 4);
INSERT INTO users (id, birth_date, creation_date, email, enabled, full_name, gender, password, course_id) VALUES (6, '2021-03-13', '2021-03-13 05:55:01.973', 'alice@hotmail.com', true, 'Alice Bianca', 'FEMALE', '$2a$10$G8cddnXZP1X.MJ4mZOuNwelJXyiSYBhLcFIx5pTIdxJDbElGFUlJ6', NULL);


--
-- Data for Name: topics; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO topics (id, creation_date, description, body_html, name, required, status, update_date, created_by_id, discipline_id) VALUES (7, '2021-03-13', 'Descrever os tipos de dispositvios e a função de cada um', '<p>Bla bla bla bla</p>', 'Dispositivos Finais e Dispositivos de WAN', false, 'APPROVED', '2021-03-13', 1, 4);
INSERT INTO topics (id, creation_date, description, body_html, name, required, status, update_date, created_by_id, discipline_id) VALUES (8, '2021-03-13', 'Description description description description', '<h3>Title</h3><br><p>F açsdkfj  aklsdfj çla <b>lçagj</b></p>', 'Cisco e ferramentas Cisco', false, 'APPROVED', '2021-03-13', 1, 4);
INSERT INTO topics (id, creation_date, description, body_html, name, required, status, update_date, created_by_id, discipline_id) VALUES (9, '2021-03-13', 'Demonstrar a configuração de um Roteador', '<h3>Title</h3><br><p>F afasd f açsdkfj  aklsdfj çla <b>lçagj</b></p>', 'Wan e Roteadores', true, 'APPROVED', '2021-03-13', 1, 4);
INSERT INTO topics (id, creation_date, description, body_html, name, required, status, update_date, created_by_id, discipline_id) VALUES (10, '2021-03-13', 'Configurar um grupo de roteadores e o roteamento estático', '<h3>Title</h3><br><p>F afasd fla lj açsdkfj  aklsdfj çla <b>lçagj</b></p>', 'Roteamento estático', true, 'APPROVED', '2021-03-13', 1, 4);
INSERT INTO topics (id, creation_date, description, body_html, name, required, status, update_date, created_by_id, discipline_id) VALUES (11, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Introdução a Java', true, 'APPROVED', '2021-03-13', 2, 1);
INSERT INTO topics (id, creation_date, description, body_html, name, required, status, update_date, created_by_id, discipline_id) VALUES (32, '2021-03-15', 'Neste tópico, você irá: Escrever aplicativos Java simples, usar declarações de entrada e saída e aprender os tipos primitivos em Java.', '<h2><strong>1. Introdução</strong></h2><p><br></p><h3>Este capítulo apresenta a programação de aplicativos Java. Começaremos com exemplos de programas que exibem (saída) mensagens na tela. Em seguida, demonstraremos um programa que obtém (aceita a entrada) dois números de um usuário, calcula a soma e exibe o resultado. Você aprenderá como instruir o computador a executar cálculos aritméticos e a salvar os resultados para uso posterior. O último exemplo demonstra como tomar decisões. O aplicativo compara dois números, então exibe mensagens que mostram os resultados da comparação. Você usará as ferramentas de linha de comando JDK ( Java Development Kit) para compilar e executar os programas deste capítulo. Se preferir usar um ambiente de desenvolvimento integrado (integrated development environment — IDE), também postamos vídeos Dive Into® no site dos autores (ver seção Antes de começar, nas páginas iniciais) deste livro para o Eclipse, NetBeans e IntelliJ IDEA.</h3><p><br></p><h2><strong>2 Nosso primeiro programa Java: imprimindo uma linha de texto</strong></h2><p><br></p><h3>Um <span style="color: rgb(161, 0, 0);">aplicativo </span>Java é um programa de computador que é executado quando você utiliza o comando java para carregar a Java Virtual Machine</h3><h3>(JVM). Mais adiante, nesta seção, discutiremos como compilar e executar um aplicativo Java. Primeiro consideramos um aplicativo simples que exibe uma linha de texto. A Figura 2.1 mostra o programa seguido por uma caixa que exibe sua saída. O programa inclui os números de linha. Adicionamos esses números para propósitos instrutivos — eles não fazem parte de um programa Java. Esse exemplo ilustra vários recursos Java importantes. Veremos que a linha 9 faz o trabalho — exibindo a frase <em>Welcome to Java Programming!</em> na tela.</h3><p><br></p><pre class="ql-syntax" spellcheck="false"><span class="hljs-comment">// Figura 2.1: Welcome1.java</span>
<span class="hljs-comment">// Programa de impressão de texto. </span>
﻿
<span class="hljs-keyword">public</span> <span class="hljs-class"><span class="hljs-keyword">class</span> <span class="hljs-title">Welcome1</span> </span>{

   <span class="hljs-comment">// método main inicia a execução do aplicativo Javapublic static void main(String[] args) {</span>
       System.out.println(<span class="hljs-string">"Welcome to Java Programming!"</span>);
    } <span class="hljs-comment">// fim do método main</span>
﻿
﻿} <span class="hljs-comment">// fim da classe Welcome1</span>
</pre><p><br></p><blockquote>Welcome to Java Programming!</blockquote><p><br></p><h3><strong style="color: rgb(161, 0, 0);"><em>Comentando programas</em></strong></h3><p><br></p><p>Inserimos <strong style="color: rgb(161, 0, 0);">comentários</strong> para <strong style="color: rgb(161, 0, 0);">documentar programas</strong> e aprimorar sua legibilidade. O compilador Java ignora os comentários, portanto, eles não fazem o computador realizar qualquer ação quando o programa é executado. Por convenção, iniciamos cada programa com um comentário indicando o número da figura e o nome do arquivo. O comentário</p><p>na linha 1</p><pre class="ql-syntax" spellcheck="false"><span class="hljs-comment">// Figura 2.1: Welcome1.java</span>
</pre><p>começa com <strong style="color: rgb(161, 0, 0);">//</strong>, indicando que é um <strong style="color: rgb(161, 0, 0);">comentário de fim de linha</strong>, e termina no fim da linha, onde os caracteres // aparecem. Um</p><p>comentário de fim de linha não precisa começar uma linha; ele também pode começar no meio de uma linha e continuar até o final</p><p>(como nas linhas 6, 10 e 11). A linha 2</p><pre class="ql-syntax" spellcheck="false"><span class="hljs-comment">// Programa de impressão de texto.</span>
</pre><p>de acordo com nossa convenção, é um comentário que descreve o propósito do programa.</p><p>O Java também tem comentários tradicionais, que podem ser distribuídos ao longo de várias linhas, como em</p><pre class="ql-syntax" spellcheck="false"><span class="hljs-comment">/* Esse é um comentário tradicional. Ele
pode ser dividido em várias linhas */</span>
</pre><p>Eles começam e terminam com delimitadores, <strong style="color: rgb(161, 0, 0);">/*</strong> e <strong style="color: rgb(161, 0, 0);">*/</strong>. O compilador ignora todo o texto entre os delimitadores. O Java incorporou</p><p>comentários tradicionais e comentários de fim de linha das linguagens de programação C e C++, respectivamente. Preferimos</p><p>usar comentários //.</p><p>O Java fornece comentários de um terceiro tipo: <strong style="color: rgb(161, 0, 0);">comentários Javadoc</strong>. Esses são delimitados por <strong style="color: rgb(161, 0, 0);">//**</strong> e<strong> </strong><strong style="color: rgb(161, 0, 0);">*/</strong>. O compilador</p><p>ignora todo o texto entre os delimitadores. Os comentários no estilo Javadoc permitem-lhe incorporar a documentação do programa</p><p>diretamente aos seus programas. Esses comentários são o formato de documentação Java preferido na indústria. O <strong style="color: rgb(161, 0, 0);">programa</strong></p><p><strong style="color: rgb(161, 0, 0);">utilitário javadoc</strong> (parte do JDK) lê comentários Javadoc e os usa para preparar a documentação do programa no formato HTML.</p><p>Demonstraremos comentários Javadoc e o utilitário javadoc no Apêndice G, na Sala Virtual (em inglês), “Criando documentação</p><p>com javadoc”.</p><p><br></p><p><br></p>', 'Introdução a aplicativos Java', true, 'WAITING_FOR_RESPONSE', '2021-03-15', 1, 2);
INSERT INTO topics (id, creation_date, description, body_html, name, required, status, update_date, created_by_id, discipline_id) VALUES (33, '2021-03-15', 'O principal objetivo deste capítulo é fazer com que você pensando nas coisas que podem acontecer quando a segurança não é implementada em um computador ou rede - para aumentar um pouco a sua paranoia - e para lhe dar uma base em alguns conceitos-chave de segurança.', '<h2><strong>1 - Importância da Segurança do Computador e da Rede</strong></h2><p><br></p><h3 class="ql-align-justify"> 	A segurança do computador envolve a implementação de medidas para proteger um único computador. Ao proteger um único computador, você se preocupa em proteger o recursos armazenados nesse computador e protegendo esse computador contra ameaças. A segurança de rede envolve proteger todos os recursos de uma rede de ameaças. Você deve considerar não apenas os computadores da rede, mas outros dispositivos de rede, mídia de transmissão de rede e os dados sendo transmitidos em toda a rede. Nesta seção, você aprenderá a apreciar a importância de segurança de computador e rede, examinando alguns exemplos de ataques que poderia ocorrer. Esses exemplos devem fazer você pensar sobre o que poderia acontecer se a segurança do computador e da rede não for implementada. Também definiremos a segurança como será usado no contexto deste livro.</h3><p><br></p><h2><strong>2 - Expondo segredos</strong></h2><p><br></p><h3 class="ql-align-justify">	Quanto mais conectada nossa sociedade se torna, mais nossos dados confidenciais estão sujeitos a ser descoberto por aqueles que irão usá-lo maliciosamente ou para seu próprio benefício. Por exemplo, na primavera de 2005, os hackers descobriram a senha para T-Mobile © Sidekick © de Paris Hilton e publicou seu catálogo de endereços e outros informações pessoais na Internet. Pense sobre a vulnerabilidade dos dados você armazena no seu celular ou no seu assistente digital pessoal (PDA). Faz você usa senhas difíceis de adivinhar para protegê-lo?</h3><h3 class="ql-align-justify">	Questões de confidencialidade semelhantes são levantadas pelo uso de cartões de crédito para fazer compras pela Internet. Os protocolos básicos da Internet não fornecem proteção de confidencialidade, então as partes localizado entre o cliente e o comerciante poderia capturar números de cartão de crédito e use-os posteriormente para compras fraudulentas. Secure Sockets Layer (SSL) foi desenvolvido pela Netscape ® para lidar com este problema. SSL define o Hypertext Trans- fer Protocolo sobre SSL (HTTPS), que fornece criptografia de dados enviados usando Protocolo de transferência de hipertexto (HTTP), o protocolo usado no mundo inteiro Rede. Transport Layer Security (TLS) oferece proteção mais forte do que SSL e está substituindo-o gradualmente. Embora SSL e TLS possam proteger os dados enquanto eles estão sendo enviados através do Inter net (ou outra rede não segura), seu uso não significa o número do seu cartão de crédito ber está seguro. Verificando o tráfego da Internet em busca de pacotes contendo números de cartão de crédito é uma estratégia de ataque com baixo rendimento. Servidores mal protegidos em um site comercial que mantêm um banco de dados de números de cartão de crédito do cliente são uma recompensa muito mais alvo ing. Há evidências documentadas de que tais ataques ocorreram, ou para obter números de cartão de crédito ou para chantagear o comerciante. Outro risco potencial é o roubo de identidade. Roubo de identidade, ou seja, usando algum a “identidade” do outro (nome, número do seguro social, número da conta bancária, etc.) para obter acesso a um recurso ou serviço, explora uma fraqueza inerente aos serviços que usam informações de identificação não secretas para autenticar solicitações.</h3><p class="ql-align-justify"><br></p><h2><strong>3 - Causando Falhas do Sistema</strong></h2><h3 class="ql-align-justify"><br></h3><h3 class="ql-align-justify">	Alguns invasores não estão atrás de dados confidenciais. Em vez disso, eles querem interromper os negócios ness. Esses invasores usam uma variedade de técnicas para causar danos. Vulnerabilidades em software que aceita entrada do usuário, como navegadores de Internet ou software de e-mail, pode permitir que terceiros assumam o controle de um dispositivo. Atacantes pode corromper os dados no próprio dispositivo ou usar o dispositivo como um trampolim para ataques contra terceiros. Worms e vírus fazem uso de recursos generosos ou vulnerabilidades para espalhar-se amplamente e sobrecarregar redes e sistemas finais com o tráfego que geram erate. O worm da Internet de novembro de 1988 é um dos primeiros exemplos bem documentados desta espécie. Ataques de negação de serviço contra alvos específicos começaram a ocorreram na última década. Um ataque de negação de serviço é aquele que impede um servidor de realizar seu trabalho normal. A resiliência contra ataques de negação de serviço tornou-se um novo critério na concepção de protocolos de segurança.</h3>', 'Princípios de Segurança de Rede', false, 'WAITING_FOR_RESPONSE', '2021-03-15', 1, 12);
INSERT INTO topics (id, creation_date, description, body_html, name, required, status, update_date, created_by_id, discipline_id) VALUES (34, '2021-03-16', 'Neste capítulo mais, você aprenderá como reduzir a superfície de ataque para servidores e criar um rede segmentada que protege seus principais recursos contra ataques. O capítulo começa com uma revisão das camadas da pilha de rede e do TCP / IP protocolo.', '<h2>1 - Revisão de protocolos de rede</h2><p><br></p><h3 class="ql-align-justify">Ser capaz de identificar e diminuir o risco de confidencialidade ou integridade de dados violação durante uma transferência de dados de rede, você deve primeiro entender como os dados são transmitido em uma rede. Também é essencial entender a função que os firewalls jogar em uma rede.</h3><p><br></p><h2>1.1 Protocolos de compreensão</h2><h3 class="ql-align-justify"><br></h3><h3 class="ql-align-justify">A palavra protocolo possui várias definições, com base no contexto de seu uso. Na área de comunicações por computador, um protocolo é um conjunto formal de regras que descrevem como os computadores transmitem dados e se comunicam em uma rede. O protocolo define o formato da mensagem e as regras para a troca do mensagens. Por causa da complexidade e múltiplas funções necessárias para iniciar, estabelecer realizar, conduzir e encerrar comunicações entre computadores em uma rede, essas funções são divididas em camadas individuais gerenciáveis. Esta decomposição é conhecida como arquitetura em camadas. Em uma arquitetura em camadas, os protocolos são organizados em uma pilha de camadas em quais dados são passados da camada mais alta para a camada mais baixa para enviar um transmissão. Essa pilha de camadas é chamada de pilha de rede. o protocolos e padrões suportados em cada uma das camadas desempenham funções específicas e anexar informações aos dados conforme eles passam por uma camada específica. Este processo é chamado de encapsulamento de dados. No computador receptor, o processo é revertido e as camadas sucessivas de informações são eliminadas conforme o pacote viaja através da pilha até o camada mais alta. Cada protocolo separa e examina apenas os dados que foram anexado por sua contraparte de protocolo no computador de transmissão. As camadas no modelo variam desde o fornecimento de processos orientados a aplicativos no nível mais alto para a geração de sinais elétricos ou ópticos que são injetado no meio de transmissão (como fios, fibra óptica ou ar), na camada inferior. As camadas intermediárias executam funções adicionais, incluindo configurar a sessão de comunicação, transferir dados e detectar erros.</h3><p><br></p><h2>1.2 O modelo de interconexão de sistemas abertos</h2><p><br></p><h3 class="ql-align-justify">O modelo Open Systems Interconnection (OSI) foi desenvolvido por volta de 1981 pela Organização Internacional de Normalização (ISO). A referência OSI modelo inclui sete camadas funcionais, que fornecem a base para a comunicação cação entre computadores em redes. É útil ter uma compreensão geral posição do modelo de referência OSI ao falar sobre diferentes programas de segurança e como eles funcionam. As sete camadas do modelo OSI, da mais alta à mais baixa, são: Aplicação, apresentação, sessão, transporte, rede, enlace de dados e física. Vocês pode facilmente lembrar deles, usando a frase mnemônica "Todas as pessoas parecem Necessita de processamento de dados.</h3><p class="ql-align-justify"><br></p><h2 class="ql-align-justify">1.3 Portas TCP / IP</h2><p><br></p><h3 class="ql-align-justify">Um protocolo TCP / IP, como HTTP, usa uma porta específica ao transmitir dados. Uma porta é um número incluído no cabeçalho de um pacote. O computador destinatário usa esse número para identificar o serviço que deve processar o pacote. o computador receptor escuta as solicitações em um conjunto de portas. As portas de 0 até 1024 são conhecidas como portas bem conhecidas porque estão associadas a um serviço específico. As portas entre 1025 e 65000 podem ser atribuídas a aplicativos personalizados. Vocês também pode configurar alguns serviços que normalmente usam uma porta conhecida para usar um porta diferente. Por exemplo, você pode configurar seu servidor web para ouvir porta 3295 para um aplicativo de intranet específico.</h3><h3><br></h3><h3>Tabela: Portas conhecidas</h3><h3><br></h3><h3>Número da porta 	Protocolo</h3><h3>20 e 21					FTP</h3><h3>22							SSH</h3><h3>23							Telnet</h3><h3>25							SMTP</h3><h3>53							DNS</h3><h3>80							HTTP</h3><h3>110							POP3</h3><h3>443							HTTPS</h3>', 'Segurança de Rede e do Servidor', false, 'WAITING_FOR_RESPONSE', '2021-03-16', 1, 12);
INSERT INTO topics (id, creation_date, description, body_html, name, required, status, update_date, created_by_id, discipline_id) VALUES (35, '2021-03-16', 'A criptografia é uma parte essencial do fornecimento confidencialidade, integridade e autenticação de dados. Um entendimento básico de algoritmos criptográficos (procedimentos passo a passo ou fórmulas matemáticas usados ​​para resolver problemas) e seu papel em fornecer confidencialidade, integridade e a autenticação pode ajudá-lo a tomar boas decisões sobre como usar várias tecnologias que se baseiam neles.', '<h2>1 - Visão geral da criptografia</h2><h3 class="ql-align-justify"><br></h3><h3 class="ql-align-justify">Nesta primeira seção, daremos uma breve olhada na história da criptografia e a vulnerabilidades de alguns algoritmos históricos. A seguir, veremos uma visão geral das quatro principais áreas de criptografia, conhecidas como primitivas criptográficas. De lá, nós brevemente visão geral de como o processo XOR é usado na criptografia. Finalmente, vamos apresentar o elenco de personagens comumente usados ao discutir criptografia.</h3><h2><br></h2><h2>1.1 Uma breve história da criptografia</h2><p><br></p><h3 class="ql-align-justify">A humanidade tem necessidade de criptografar dados muito antes de os computadores serem inventado. Os líderes precisavam entregar dados secretamente aos generais na batalha campo, e os amantes enviaram mensagens um para o outro em código. As primeiras formas de criptografia era fácil de decifrar pelos padrões atuais. No entanto, antes do advento de computadores, analisando e encontrando a fraqueza em um algoritmo criptográfico (a processo conhecido como criptoanálise ) pode levar horas, dias ou anos porque dependia unicamente da engenhosidade e do esforço humanos. O algoritmo criptográfico de hoje ritmos são quebrados por computadores, que podem tentar milhões de combinações cada segundo. À medida que os computadores se tornam mais poderosos, os algoritmos criptográficos devem ser fortalecido para manter os dados seguros. Mas antes de discutirmos os algoritmos usados hoje, vamos dar uma olhada em alguns dos os primeiros métodos de criptografia e analise por que eles são fáceis de quebrar. Cifras de substituição Já em Júlio César, a criptografia era usada para proteger mensagens. César criptografaria suas mensagens antes de entregá-las aos mensageiros, protegendo-os de ser lido durante o trânsito. César usou um método simples de criptografia chamado de cifra de substituição. Uma cifra de substituição mapeia cada letra do alfa- aposta para outra carta. Por exemplo, a letra a pode ser mapeada para f , b para g , e assim por diante ao longo do alfabeto. César costumava substituir cada letra do alfabeto com a letra três letras à direita dela, envolvendo no final do alfabeto. Este mapeamento é mostrado na Figura 3-1, onde as letras na linha superior estão em texto simples (dados em sua forma legível e não criptografada), e aqueles em linha inferior são as letras correspondentes no texto cifrado (dados criptografados, forma ilegível). Usando este esquema de criptografia, ou cifra, se você codificasse a palavra criptografia , você deve procurar a letra c na linha superior e encontrar a letra f correspondente a ele na linha inferior. Aplicando este processo a todas as cartas produz o seguinte: Texto simples: criptografia Texto cifrado : fubswrjudskb Um algoritmo de criptografia requer texto simples e uma chave (um pedaço de dados usado com criptografia e descriptografia) para criar texto cifrado. A chave neste algoritmo ritmo é a tabela mostrada na Figura 3-1. Esta tabela atua como a chave para o algoritmo, mapear letras de texto simples para letras de texto cifrado. Para determinar a mesa, você precisa para saber o deslocamento usado para calcular o texto cifrado. Este valor é conhecido como mudança. Sem a tabela, tentar decodificar fubswrjudskb em criptografia pode parece uma tarefa impossível. No entanto, alguns criptanalistas (pessoas que ana- lyze e crack algoritmos criptográficos) percebeu que quebrar tal cifra foi muito fácil; eles precisavam tentar no máximo 25 substituições ou rotações diferentes do alfabeto antes que o texto cifrado seja convertido em texto simples, mak- sentido das palavras. Outra desvantagem de uma cifra de substituição simples é que é propenso a fre- análise de freqüência. A análise de frequência usa o fato de que algumas letras no lish language aparecem com mais frequência do que outras letras. Por exemplo, considere a seguinte frase: O inimigo planeja esperar até que a tempestade termine para atacar.</h3>', 'CRIPTOGRAFIA', false, 'WAITING_FOR_RESPONSE', '2021-03-16', 1, 12);
INSERT INTO topics (id, creation_date, description, body_html, name, required, status, update_date, created_by_id, discipline_id) VALUES (36, '2021-03-16', '	Esta disciplina mostra como construir estruturas de dados dinâmicas que crescem e encolhem em tempo de execução. As listas
encadeadas são coleções de itens de dados “vinculados em uma cadeia” — as inserções e exclusões podem ser feitas em qualquer
lugar de uma lista encadeada. As pilhas são importantes em compiladores e sistemas operacionais; as inserções e as exclusões são
feitas somente no final de uma pilha — sua parte superior. As filas representam filas de espera; as inserções são feitas na parte de
trás (também referida como cauda) de uma fila e as exclusões são feitas na parte da frente da fila (também referida como cabeça).
As árvores binárias facilitam a pesquisa e classificação de dados em alta velocidade, a eliminação eficiente de itens de dados duplicados,
a representação de diretórios de sistema de arquivos, a compilação de expressões em linguagem de máquina e muitas outras
aplicações interessantes.', '<h2><strong>Introdução</strong></h2><p><br></p><h3>	Esta disciplina mostra como construir <strong style="color: rgb(161, 0, 0);">estruturas de dados dinâmicas</strong> que crescem e encolhem em tempo de execução. As <strong style="color: rgb(161, 0, 0);">listas</strong></h3><h3><strong style="color: rgb(161, 0, 0);">encadeadas</strong> são coleções de itens de dados “vinculados em uma cadeia” — as inserções e exclusões podem ser feitas em <em>qualquer</em></h3><h3><em>lugar</em> de uma lista encadeada. As <strong style="color: rgb(161, 0, 0);">pilhas</strong> são importantes em compiladores e sistemas operacionais; as inserções e as exclusões são</h3><h3>feitas somente no final de uma pilha — sua <strong style="color: rgb(161, 0, 0);">parte superior</strong>. As <strong style="color: rgb(161, 0, 0);">filas </strong>representam filas de espera; as inserções são feitas na parte de</h3><h3>trás (também referida como <strong style="color: rgb(161, 0, 0);">cauda</strong>) de uma fila e as exclusões são feitas na parte da frente da fila (também referida como <strong style="color: rgb(161, 0, 0);">cabeça</strong>).</h3><h3>As <strong style="color: rgb(161, 0, 0);">árvores binárias</strong> facilitam a pesquisa e classificação de dados em alta velocidade, a eliminação eficiente de itens de dados duplicados,</h3><h3>a representação de diretórios de sistema de arquivos, a compilação de expressões em linguagem de máquina e muitas outras</h3><h3>aplicações interessantes.</h3><h3>	Discutimos cada um desses principais tipos de estrutura de dados e implementamos programas que os criam e manipulam.</h3><h3>Usamos classes, herança e composição para criá-las por questão de reutilização e manutenção. Também explicamos como organizar</h3><h3>classes em seus próprios pacotes para promover a reutilização. Incluímos este capítulo para os alunos da ciência da computação e</h3><h3>engenharia da computação que precisam entender como construir estruturas de dados encadeadas.</h3><p><br></p><blockquote><strong style="color: rgb(178, 107, 0);">Observação de engenharia de software 21.1</strong></blockquote><blockquote><em>A grande maioria dos desenvolvedores de software deve usar as classes de coleção genéricas predefinidas que discutimos no Capítulo 16, em vez de desenvolver estruturas de dados personalizadas encadeadas.</em></blockquote>', 'Introdução', true, 'WAITING_FOR_RESPONSE', '2021-03-16', 1, 3);
INSERT INTO topics (id, creation_date, description, body_html, name, required, status, update_date, created_by_id, discipline_id) VALUES (37, '2021-03-16', 'Uma classe autorreferencial contém uma variável de instância que referencia outro objeto do mesmo tipo de classe.', '<h2><strong>1. Classes autorreferenciais</strong></h2><p><br></p><h3>Uma <strong style="color: rgb(161, 0, 0);">classe autorreferencial</strong> contém uma variável de instância que referencia outro objeto do mesmo tipo de classe. Por exemplo,</h3><h3>a declaração da classe genérica Node</h3><p><br></p><pre class="ql-syntax" spellcheck="false"><span class="hljs-class"><span class="hljs-keyword">class</span> <span class="hljs-title">Node</span>&lt;<span class="hljs-title">T</span>&gt; </span>{
  <span class="hljs-keyword">private</span> T data;
  <span class="hljs-keyword">private</span> Node&lt;T&gt; nextNode; <span class="hljs-comment">// referência ao próximo nó vinculado</span>
﻿
  <span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-title">Node</span><span class="hljs-params">(T data)</span> </span>{ <span class="hljs-comment">/* corpo do construtor */</span> }

  <span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">setData</span><span class="hljs-params">(T data)</span> </span>{ <span class="hljs-comment">/* corpo do método */</span> }

  <span class="hljs-function"><span class="hljs-keyword">public</span> T <span class="hljs-title">getData</span><span class="hljs-params">()</span> </span>{ <span class="hljs-comment">/* corpo do método */</span> }

  <span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">setNext</span><span class="hljs-params">(Node&lt;T&gt; next)</span> </span>{ <span class="hljs-comment">/* corpo do método */</span> }

  <span class="hljs-function"><span class="hljs-keyword">public</span> Node&lt;T&gt; <span class="hljs-title">getNext</span><span class="hljs-params">()</span> </span>{ <span class="hljs-comment">/* corpo do método */</span> }

}
</pre><h3><br></h3><h3>tem duas variáveis de instância <span class="ql-font-monospace">private</span> — a variável data (do tipo genérico T) e a variável nextNode Node&lt;T&gt;. A variável</h3><h3><span class="ql-font-monospace">nextNode</span> referencia um objeto Node&lt;T&gt;, um objeto da mesma classe que está sendo declarada aqui, daí o termo “classe autorreferencial”.</h3><h3>O campo <span class="ql-font-monospace">nextNode</span> é um <strong style="color: rgb(161, 0, 0);">link</strong> — ele “vincula” um objeto de tipo Node&lt;T&gt; a outro objeto do mesmo tipo. O tipo Node&lt;T&gt;</h3><h3>também tem cinco métodos: um construtor que recebe um valor para inicializar data, um método setData para configurar o valor</h3><h3>de <span class="ql-font-monospace">data</span>, um método <span class="ql-font-monospace">getData</span> para retornar o valor de <span class="ql-font-monospace">data</span>, um método <span class="ql-font-monospace">setNext</span> para configurar o valor de <span class="ql-font-monospace">nextNode</span> e um método</h3><h3><span class="ql-font-monospace">getNext</span> para retornar uma referência ao próximo nó.</h3><h3>Os programas podem vincular objetos autorreferenciais para formar estruturas de dados tão úteis quanto listas, filas, pilhas e</h3><h3>árvores. A Figura 21.1 ilustra dois objetos autorreferenciais vinculados entre si para formar uma lista. Uma barra invertida — representando</h3><h3>uma referência <span class="ql-font-monospace">null </span>— é colocada no membro de link do segundo objeto autorreferencial para indicar que o link <em>não</em></h3><h3>referencia outro objeto. A barra invertida é ilustrativa; ela não corresponde ao caractere barra invertida no Java. Por convenção, no</h3><h3>código usamos a referência <span class="ql-font-monospace">null </span>para indicar o fim de uma estrutura de dados.</h3><p><br></p><p class="ql-align-center"><img src="data:image/png;base64,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"></p><p class="ql-align-center"><strong style="color: rgb(161, 0, 0);">Figura 21.1</strong> | Objetos de classe autorreferencial vinculados entre si.</p><p class="ql-align-center"><br></p><p class="ql-align-center"><br></p><p class="ql-align-center"><br></p><h2><strong>2. Alocação dinâmica de memória</strong></h2><p><br></p><p>	Criar e manter estruturas de dados dinâmicas requer alocação dinâmica de memória — permissão para que um programa obtenha mais espaço de memória em tempo de execução para armazenar novos nós e liberar espaço não mais necessário. Lembre-se de que o Java não exige que você libere explicitamente a memória alocada dinamicamente. Em vez disso, o Java realiza coleta de lixo automática de objetos que não são mais referenciados em um programa. O limite para alocação dinâmica de memória pode ser tão grande quanto a quantidade de memória física disponível no computador ou a quantidade de espaço em disco disponível em um sistema de memória virtual. Frequentemente, os limites são muito menores, porque a memória disponível do computador deve ser compartilhada entre muitos aplicativos.</p><p class="ql-align-justify">A criação da declaração e expressão de instância de classe</p><p class="ql-align-justify"><br></p><pre class="ql-syntax" spellcheck="false"><span class="hljs-comment">// 10 são os dados de nodeToAdd</span>
Node&lt;Integer&gt; nodeToAdd = <span class="hljs-keyword">new</span> Node&lt;Integer&gt;(<span class="hljs-number">10</span>);
</pre><p class="ql-align-justify"><br></p><p>aloca um objeto Node&lt;Integer&gt; e retorna uma referência a ele, que é atribuída ao <span class="ql-font-monospace">nodeToAdd</span>. Se a <em>memória insuficiente</em> estiver</p><p>disponível, a expressão anterior lança um <span class="ql-font-monospace">OutOfMemoryError</span>. As seções a seguir discutem que listas, pilhas, filas e árvores — todas</p><p class="ql-align-justify">as quais utilizam alocação dinâmica de memória e classes autorreferenciais para criar estruturas de dados dinâmicas.</p>', 'Classes autorreferenciais', true, 'APPROVED', '2021-03-16', 1, 3);
INSERT INTO topics (id, creation_date, description, body_html, name, required, status, update_date, created_by_id, discipline_id) VALUES (17, '2021-03-13', 'Uma pilha é uma versão limitada de uma lista — novos nós podem ser inseridos e removidos de uma pilha apenas na parte
superior. Por essa razão, uma pilha é referida como uma estrutura de dados último a entrar, primeiro a sair (last-in, first-out —
LIFO). O elemento link no nó inferior é definido como null para indicar a parte inferior da pilha. Não é necessário implementar
uma pilha como uma lista encadeada — a pilha também pode ser implementada utilizando um array.', '<h2><strong>1. Pilhas</strong></h2><p><br></p><h3 class="ql-indent-1">Uma pilha é uma versão limitada de uma lista — novos nós podem ser inseridos e removidos de uma pilha apenas na parte</h3><h3>superior. Por essa razão, uma pilha é referida como uma estrutura de dados <strong style="color: rgb(161, 0, 0);">último a entrar, primeiro a sair (last-in, first-out —</strong></h3><h3><strong style="color: rgb(161, 0, 0);">LIFO)</strong>. O elemento link no nó inferior é definido como <span class="ql-font-monospace">null</span> para indicar a parte inferior da pilha. Não é necessário implementar</h3><h3>uma pilha como uma lista encadeada — a pilha também pode ser implementada utilizando um array.</h3><p><br></p><h3 class="ql-indent-1">Os métodos primários para manipular uma pilha são <strong style="color: rgb(161, 0, 0);">push</strong> e <strong style="color: rgb(161, 0, 0);">pop</strong>, que adicionam um novo nó ao topo da pilha e removem um</h3><h3>nó do topo da pilha, respectivamente. O método pop também retorna os dados do nó removido. As pilhas têm muitas aplicações interessantes. Por exemplo, quando um programa chama um método, o método chamado deve saber retornar ao seu chamador, assim o endereço de retorno do método chamador é inserido na pilha de execução do programa (discutido na Seção 6.6). Se uma série de chamadas de método ocorre, os sucessivos endereços de retorno são empilhados na ordem último a entrar, primeiro a sair, de modo que cada método possa retornar para seu chamador. As pilhas suportam as chamadas de método recursivo da mesma maneira que as chamadas de método não recursivo convencionais. </h3><h3><br></h3><h3 class="ql-indent-1">A pilha de execução de programa também contém a memória criada para variáveis locais a cada invocação de um método durante a execução de </h3><h3>um programa. Quando o método retorna para seu chamador, a memória para variáveis locais desse método é removida da pilha e essas variáveis não são mais conhecidas para o programa. Se a variável local é uma referência e o objeto que ela referencia não tem outras variáveis que o referenciam, o objeto pode passar por coleta de lixo. Os compiladores utilizam pilhas para avaliar expressões aritméticas e gerar o código de linguagem de máquina para processá-las. Os exercícios neste capítulo exploram várias aplicações de pilhas, incluindo seu uso para desenvolver um compilador completo. Além disso, o pacote java.util contém a classe Stack (ver Capítulo 16) para implementar e manipular pilhas que podem crescer e encolher durante a execução do programa. </h3><h3><br></h3><h3 class="ql-indent-1">Nesta seção, tiramos vantagem do relacionamento íntimo entre listas e pilhas para implementar uma classe de pilha reutilizando</h3><h3>a classe List&lt;T&gt; da Figura 21.3. Demonstramos duas formas diferentes de reutilização. Primeiro, implementaremos a classe de</h3><h3>pilha estendendo a classe List. Então, implementaremos uma classe de pilha que tem o mesmo desempenho por meio de composição,</h3><h3>incluindo uma referência a um objeto List como uma variável de instância private. As estruturas de dados de lista, pilha e</h3><h3>fila neste capítulo são implementadas para armazenar referências a objetos de qualquer tipo a fim de encorajar mais capacidade de</h3><h3>reutilização.</h3><p><br></p><h2><strong>2. Classe de pilha que herda de List&lt;T&gt;</strong></h2><p><br></p><h3 class="ql-indent-1">As figuras 21.10 e 21.11 criam e manipulam uma classe de pilha que estende a classe List&lt;T&gt; da Figura 21.3. Queremos que a pilhatenha os </h3><h3>métodos <span class="ql-font-monospace">push</span>, <span class="ql-font-monospace">pop</span>, <span class="ql-font-monospace">isEmpty</span> e <span class="ql-font-monospace">print</span>. Essencialmente, esses são os métodos List&lt;T&gt; <span class="ql-font-monospace">insertAtFront</span>, <span class="ql-font-monospace">removeFromFront</span>, <span class="ql-font-monospace">isEmpty</span> e <span class="ql-font-monospace">print</span>. Naturalmente, a classe List&lt;T&gt; contém outros métodos (como insertAtBack e removeFromBack) que não tornaríamos acessível pela interface public à classe de pilha. É importante lembrar que todos os métodos na interface de classe public da List&lt;T&gt; também são métodos public da subclasse StackInheritance&lt;T&gt; (Figura 21.10). Cada método de StackInheritance&lt;T&gt; chama o método List&lt;T&gt; apropriado, por exemplo, o método push chama insertAtFront e o método pop chama removeFromFront. Clientes de StackInheritance&lt;T&gt; podem chamar os métodos isEmpty e print porque são herdados de List&lt;T&gt;. A classe StackInheritance&lt;T&gt; é declarada no pacote com.deitel.datastructures (linha 3) para reutilização. StackInheritance&lt;T&gt; não importa List&lt;T&gt; — as classes estão no mesmo pacote. </h3><h3><br></h3><h3>		O método main da classe StackInheritanceTest (Figura 21.11) cria um objeto da classe StackInheritance&lt;T&gt; chamado stack (linha 10). O programa adiciona inteiros na pilha (linhas 13, 15, 17 e 19). O <em>autoboxing</em> é usado aqui para inserir objetos Integer na estrutura de dados. As linhas 27 a 32 removem os objetos da pilha em um loop while infinito. Se o método pop for invocado em uma pilha vazia, o método lança uma EmptyListException. Nesse caso, o programa exibe o rastreamento de pilha da exceção, que mostra os métodos na pilha de execução do programa no momento em que a exceção ocorreu. O programa utiliza o método print (herdado de List) para gerar a saída do conteúdo da pilha.</h3><p><br></p><pre class="ql-syntax" spellcheck="false"><span class="hljs-keyword">public</span> <span class="hljs-class"><span class="hljs-keyword">class</span> <span class="hljs-title">StackInheritance</span>&lt;<span class="hljs-title">T</span>&gt; <span class="hljs-keyword">extends</span> <span class="hljs-title">List</span>&lt;<span class="hljs-title">T</span>&gt; </span>{
&nbsp; &nbsp;<span class="hljs-comment">// constructor</span>
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-title">StackInheritance</span><span class="hljs-params">()</span> </span>{&nbsp;
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">super</span>(<span class="hljs-string">"stack"</span>);&nbsp;
&nbsp; &nbsp;}&nbsp;

&nbsp; &nbsp;<span class="hljs-comment">// add object to stack</span>
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">push</span><span class="hljs-params">(T object)</span> </span>{&nbsp;
&nbsp; &nbsp; &nbsp; insertAtFront(object);&nbsp;
&nbsp; &nbsp;}&nbsp;

&nbsp; &nbsp;<span class="hljs-comment">// remove object from stack</span>
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> T <span class="hljs-title">pop</span><span class="hljs-params">()</span> <span class="hljs-keyword">throws</span> EmptyListException </span>{&nbsp;
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">return</span> removeFromFront();&nbsp;
&nbsp; &nbsp;}&nbsp;
} <span class="hljs-comment">// end class StackInheritance</span>

</pre><p><strong style="color: rgb(92, 0, 0);">Figura 21.10</strong> | StackInheritance estende a classe List.</p><p><br></p><pre class="ql-syntax" spellcheck="false"><span class="hljs-keyword">public</span> <span class="hljs-class"><span class="hljs-keyword">class</span> <span class="hljs-title">StackInheritanceTest</span>&nbsp;</span>{

&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">static</span> <span class="hljs-keyword">void</span> <span class="hljs-title">main</span><span class="hljs-params">(String[] args)</span>&nbsp;</span>{
&nbsp; &nbsp; &nbsp; StackInheritance&lt;Integer&gt; stack = <span class="hljs-keyword">new</span> StackInheritance&lt;&gt;();&nbsp;&nbsp;

&nbsp; &nbsp; &nbsp; <span class="hljs-comment">// use push method</span>
&nbsp; &nbsp; &nbsp; stack.push(-<span class="hljs-number">1</span>);
&nbsp; &nbsp; &nbsp; stack.print();
&nbsp; &nbsp; &nbsp; stack.push(<span class="hljs-number">0</span>);
&nbsp; &nbsp; &nbsp; stack.print();
&nbsp; &nbsp; &nbsp; stack.push(<span class="hljs-number">1</span>);
&nbsp; &nbsp; &nbsp; stack.print();
&nbsp; &nbsp; &nbsp; stack.push(<span class="hljs-number">5</span>);
&nbsp; &nbsp; &nbsp; stack.print();

&nbsp; &nbsp; &nbsp; <span class="hljs-comment">// remove items from stack</span>
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">try</span>&nbsp;{
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="hljs-keyword">int</span> removedItem;

&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="hljs-keyword">while</span> (<span class="hljs-keyword">true</span>) {
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; removedItem = stack.pop(); <span class="hljs-comment">// use pop method</span>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; System.out.printf(<span class="hljs-string">"%n%d popped%n"</span>, removedItem);
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; stack.print();
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;}&nbsp;
&nbsp; &nbsp; &nbsp; }&nbsp;
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">catch</span> (EmptyListException emptyListException) {
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;emptyListException.printStackTrace();
&nbsp; &nbsp; &nbsp; }&nbsp;
&nbsp; &nbsp;}&nbsp;
} <span class="hljs-comment">// end class StackInheritanceTest</span>
</pre><blockquote>The stack is: -1</blockquote><blockquote>The stack is: 0 -1</blockquote><blockquote><br></blockquote><blockquote>The stack is: 1 0 -1</blockquote><blockquote>The stack is: 5 1 0 -1</blockquote><blockquote><br></blockquote><blockquote>5 popped</blockquote><blockquote>The stack is: 1 0 -1</blockquote><blockquote><br></blockquote><blockquote>1 popped</blockquote><blockquote>The stack is: 0 -1</blockquote><blockquote><br></blockquote><blockquote>0 popped</blockquote><blockquote>The stack is: -1</blockquote><blockquote><br></blockquote><blockquote>-1 popped</blockquote><blockquote>Empty stack</blockquote><blockquote>com.deitel.datastructures.EmptyListException: stack is empty</blockquote><blockquote>at com.deitel.datastructures.List.removeFromFront(List.java:81)</blockquote><blockquote>at com.deitel.datastructures.StackInheritance.pop(</blockquote><blockquote>StackInheritance.java:22)</blockquote><blockquote>at StackInheritanceTest.main(StackInheritanceTest.java:29)</blockquote><p><strong style="color: rgb(92, 0, 0);">Figura 21.11</strong> | Programa de manipulação de pilha.﻿</p><p><br></p><p><br></p>', 'Pilhas', true, 'APPROVED', '2021-03-16', 2, 3);
INSERT INTO topics (id, creation_date, description, body_html, name, required, status, update_date, created_by_id, discipline_id) VALUES (18, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h2><strong>Filas</strong></h2><p><br></p><h3 class="ql-indent-1">Outra estrutura de dados comumente utilizada é a fila. Uma fila é semelhante a uma fila de caixa de um supermercado — o caixa atende a pessoa </h3><h3>no início da fila primeiro. Outros clientes entram no final da fila e esperam ser atendidos. Os nós de fila são removidos apenas a partir da cabeça (ou no início) da fila e são inseridos apenas na cauda (ou no final). Por essa razão, uma fila é uma estrutura de dados primeiro a entrar, primeiro a sair (first-in, first-out — FIFO). As operações de inserção e remoção são conhecidas como enqueue e dequeue.</h3><p><br></p><h3 class="ql-indent-1">As filas têm muitas utilizações em sistemas de computador. Cada CPU em um computador pode atender um único aplicativo por vez. Todo aplicativo </h3><h3>que requer tempo de processador é colocado em uma fila. O aplicativo na frente da fila é o próximo a receber o serviço. Cada aplicativo avança gradualmente para a frente à medida que os aplicativos antes dele recebem o serviço.</h3><h3 class="ql-indent-1"><br></h3><h3 class="ql-indent-1">As filas também são utilizadas para suportar spooling de impressão. Por exemplo, uma única impressora talvez seja compartilhadapor todos os </h3><h3>usuários de uma rede. Muitos usuários podem enviar trabalhos de impressão à impressora, mesmo quando a impressora já estiver ocupada. Esses trabalhos de impressão são colocados em uma fila até a impressora ficar disponível. Um programa chamado spooler gerencia a fila para assegurar que, à medida que cada trabalho de impressão é concluído, o próximo seja enviado à impressora. </h3><h3 class="ql-indent-1"><br></h3><h3 class="ql-indent-1">Os pacotes de informações também esperam em filas em redes de computadores. Toda vez que um pacote chegar a um nó de</h3><h3>rede, ele deve ser roteado para o próximo nó ao longo do caminho para o destino final do pacote. O nó de roteamento roteia um</h3><h3>pacote por vez, então pacotes adicionais são enfileirados até o roteador conseguir roteá-los.</h3><h3>Um servidor de arquivos em uma rede de computadores trata as solicitações de acesso a arquivo de muitos clientes por toda a</h3><h3>rede. Os servidores têm uma capacidade limitada para servir solicitações de clientes. Quando essa capacidade é excedida, as solicitações</h3><h3>dos clientes esperam em filas.</h3><h3><br></h3><h3 class="ql-indent-1">A Figura 21.13 cria uma classe Queue&lt;T&gt; que contém um objeto List&lt;T&gt; (Figura 21.3) e fornece os métodos enqueue, dequeue, isEmpty e print. A </h3><h3>classe List&lt;T&gt; contém alguns métodos (por exemplo, insertAtFront e removeFromBack) e é preferível que ela não seja acessível por meio da interface public da Queue&lt;T&gt;. Usar composição permite ocultar outros métodos public da classe List&lt;T&gt; de clientes da classe Queue&lt;T&gt;. Cada método Queue&lt;T&gt; chama um método List&lt;T&gt; adequado — enqueue chama List&lt;T&gt; insertAtBack, dequeue chama List&lt;T&gt; removeFromFront, isEmpty chama List&lt;T&gt; isEmpty e print chama List&lt;T&gt; print. Para reutilização, a classe Queue&lt;T&gt; é declarada no pacote com.deitel.datastructures.</h3><p><br></p><pre class="ql-syntax" spellcheck="false"><span class="hljs-keyword">public</span> <span class="hljs-class"><span class="hljs-keyword">class</span> <span class="hljs-title">Queue</span>&lt;<span class="hljs-title">T</span>&gt; </span>{
&nbsp; &nbsp;<span class="hljs-keyword">private</span> List&lt;T&gt; queueList;

&nbsp; &nbsp;<span class="hljs-comment">// constructor</span>
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-title">Queue</span><span class="hljs-params">()</span> </span>{&nbsp;
&nbsp; &nbsp; &nbsp; queueList = <span class="hljs-keyword">new</span> List&lt;T&gt;(<span class="hljs-string">"queue"</span>);&nbsp;
&nbsp; &nbsp;}&nbsp;

&nbsp; &nbsp;<span class="hljs-comment">// add object to queue</span>
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">enqueue</span><span class="hljs-params">(T object)</span> </span>{&nbsp;
&nbsp; &nbsp; &nbsp; queueList.insertAtBack(object);&nbsp;
&nbsp; &nbsp;}

&nbsp; &nbsp;<span class="hljs-comment">// remove object from queue</span>
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> T <span class="hljs-title">dequeue</span><span class="hljs-params">()</span> <span class="hljs-keyword">throws</span> EmptyListException </span>{&nbsp;
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">return</span> queueList.removeFromFront();&nbsp;
&nbsp; &nbsp;}

&nbsp; &nbsp;<span class="hljs-comment">// determine if queue is empty</span>
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">boolean</span> <span class="hljs-title">isEmpty</span><span class="hljs-params">()</span> </span>{
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">return</span> queueList.isEmpty();
&nbsp; &nbsp;}

&nbsp; &nbsp;<span class="hljs-comment">// output queue contents</span>
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">print</span><span class="hljs-params">()</span> </span>{
&nbsp; &nbsp; &nbsp; queueList.print();
&nbsp; &nbsp;}
} <span class="hljs-comment">// end class Queue</span>
</pre><p><strong style="color: rgb(92, 0, 0);">Figura 21.13</strong> | Queue utiliza a classe List.﻿</p>', 'Fila', true, 'APPROVED', '2021-03-16', 2, 3);
INSERT INTO topics (id, creation_date, description, body_html, name, required, status, update_date, created_by_id, discipline_id) VALUES (15, '2021-03-13', 'Uma lista encadeada é uma coleção linear (isto é, uma sequência) de objetos de classe autorreferencial, chamados nós, conectados
por links de referência — daí o termo lista “encadeada”. Tipicamente, um programa acessa uma lista encadeada por meio de
uma referência ao primeiro nó. O programa acessa cada nó subsequente por uma referência de link armazenado no nó anterior. Por
convenção, a referência de link no último nó da lista é definida como null para indicar o “fim da lista”. Os dados são armazenados
e removidos das listas encadeadas dinamicamente — o programa cria e exclui os nós como necessário. As pilhas e filas são estruturas
de dados também lineares e, como veremos, são versões limitadas de listas encadeadas. As árvores são estruturas de dados não
lineares.', '<h2><strong>1. Listas encadeadas</strong></h2><p><br></p><h3 class="ql-indent-1">Uma lista encadeada é uma coleção linear (isto é, uma sequência) de objetos de classe autorreferencial, chamados nós, conectados</h3><h3>por <em>links</em> de referência — daí o termo lista “encadeada”. Tipicamente, um programa acessa uma lista encadeada por meio de</h3><h3>uma referência ao primeiro nó. O programa acessa cada nó subsequente por uma referência de link armazenado no nó anterior. Por</h3><h3>convenção, a referência de link no último nó da lista é definida como <span class="ql-font-monospace">null</span> para indicar o “fim da lista”. Os dados são armazenados</h3><h3>e removidos das listas encadeadas dinamicamente — o programa cria e exclui os nós como necessário. As pilhas e filas são estruturas</h3><h3>de dados também lineares e, como veremos, são versões limitadas de listas encadeadas. As árvores são estruturas de dados não</h3><h3>lineares.</h3><h3><br></h3><h3 class="ql-indent-1">As listas de dados podem ser armazenadas em arrays de Java convencionais, mas as listas encadeadas fornecem várias vantagens.</h3><h3>Uma lista encadeada é apropriada quando o número de elementos de dados a ser representado na estrutura de dados é <span class="ql-font-monospace">imprevisível</span>.</h3><h3>Listas encadeadas são dinâmicas, assim o comprimento de uma lista pode aumentar ou diminuir como necessário, enquanto o tamanho</h3><h3>de um array Java convencional não pode ser alterado — ele é fixo quando o programa cria o array. [Naturalmente, <span class="ql-font-monospace">ArrayLists</span></h3><h3><em>podem</em> crescer e encolher.] Os arrays convencionais podem tornar-se cheios. As listas encadeadas tornam-se cheias apenas quando</h3><h3>o sistema tem<em> memória insuficiente</em> para satisfazer solicitações de alocação de armazenamento dinâmico. O pacote java.util</h3><h3>contém a classe <span class="ql-font-monospace">LinkedList</span> (discutida no Capítulo 16) para implementar e manipular listas encadeadas que crescem e encolhem</h3><h3>durante a execução de programa.</h3><h3><br></h3><h3 class="ql-indent-1">As listas encadeadas podem ser mantidas em ordem de classificação simplesmente inserindo cada novo elemento no ponto</h3><h3>adequado na lista. (Naturalmente, leva tempo para <em>localizar</em> o ponto de inserção adequado.) <em>Os elementos existentes da lista não</em></h3><h3><em>precisam ser movidos.</em></h3><p><br></p><h2><strong>2. Listas encadeadas individualmente</strong></h2><p><br></p><h3 class="ql-indent-1">Nós de lista encadeada normalmente <em>não são armazenados contiguamente</em> na memória. Em vez disso, são logicamente contíguos. A Figura 21.2</h3><h3>ilustra uma lista encadeada com vários nós. Esse diagrama apresenta uma <strong style="color: rgb(161, 0, 0);">lista encadeada individualmente</strong> — cada nó contém uma referência ao próximo nó da lista. Em geral, as listas encadeadas são implementadas como listas duplamente encadeadas — cada nó contém uma referência ao próximo nó na lista e uma referência ao anterior.</h3><p><br></p><p class="ql-align-center"><img src="data:image/png;base64,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"></p><p class="ql-align-center"><strong style="color: rgb(92, 0, 0);">Figura 21.2</strong> | Representação gráfica de lista encadeada.</p><p class="ql-align-center"><br></p><h2><strong>3. Implementando uma classe List genérica</strong></h2><p><br></p><p class="ql-indent-1">O programa das figuras 21.3 a 21.5 utiliza um objeto de nossa classe genérica List para manipular uma lista de objetos</p><p>variados. O programa consiste em quatro classes: ListNode (Figura 21.3, linhas 6 a 37), List (Figura 21.3, linhas 40 a 147),</p><p>EmptyListException (Figura 21.4) e ListTest (Figura 21.5). Encapsulada em cada objeto List está uma lista encadeada de</p><p class="ql-align-justify">objetos ListNode.</p><p><br></p><pre class="ql-syntax" spellcheck="false"><span class="hljs-class"><span class="hljs-keyword">class</span> <span class="hljs-title">ListNode</span>&lt;<span class="hljs-title">T</span>&gt;&nbsp;</span>{
&nbsp; &nbsp;T data;&nbsp;
&nbsp; &nbsp;ListNode&lt;T&gt; nextNode;&nbsp;
&nbsp;&nbsp;
&nbsp; &nbsp;ListNode(T object)&nbsp;{&nbsp;
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">this</span>(object, <span class="hljs-keyword">null</span>);&nbsp;
&nbsp; &nbsp;}&nbsp;&nbsp;
&nbsp;
&nbsp; &nbsp;ListNode(T object, ListNode&lt;T&gt; node) {
&nbsp; &nbsp; &nbsp; data = object;&nbsp; &nbsp;&nbsp;
&nbsp; &nbsp; &nbsp; nextNode = node;&nbsp;&nbsp;
&nbsp; &nbsp;}&nbsp;
&nbsp; &nbsp;
&nbsp; &nbsp;<span class="hljs-function">T <span class="hljs-title">getData</span><span class="hljs-params">()</span>&nbsp;</span>{&nbsp;
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">return</span> data;&nbsp;
&nbsp; &nbsp;}&nbsp;
&nbsp;&nbsp;
&nbsp; &nbsp;<span class="hljs-function">ListNode&lt;T&gt; <span class="hljs-title">getNext</span><span class="hljs-params">()</span> </span>{&nbsp;
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">return</span> nextNode;&nbsp;
&nbsp; &nbsp;}&nbsp;
}

<span class="hljs-keyword">public</span> <span class="hljs-class"><span class="hljs-keyword">class</span> <span class="hljs-title">List</span>&lt;<span class="hljs-title">T</span>&gt; </span>{
&nbsp; &nbsp;<span class="hljs-keyword">private</span> ListNode&lt;T&gt; firstNode;
&nbsp; &nbsp;<span class="hljs-keyword">private</span> ListNode&lt;T&gt; lastNode;
&nbsp; &nbsp;<span class="hljs-keyword">private</span> String name;&nbsp;

&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-title">List</span><span class="hljs-params">()</span> </span>{&nbsp;
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">this</span>(<span class="hljs-string">"list"</span>);&nbsp;
&nbsp; &nbsp;}&nbsp;
&nbsp;&nbsp;
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-title">List</span><span class="hljs-params">(String listName)</span> </span>{
&nbsp; &nbsp; &nbsp; name = listName;
&nbsp; &nbsp; &nbsp; firstNode = lastNode = <span class="hljs-keyword">null</span>;
&nbsp; &nbsp;}&nbsp;
&nbsp;&nbsp;
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">insertAtFront</span><span class="hljs-params">(T insertItem)</span> </span>{
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">if</span> (isEmpty())&nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;firstNode = lastNode = <span class="hljs-keyword">new</span> ListNode&lt;T&gt;(insertItem);
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">else</span>&nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;firstNode = <span class="hljs-keyword">new</span> ListNode&lt;T&gt;(insertItem, firstNode);
&nbsp; &nbsp;}&nbsp;
&nbsp; &nbsp;
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">insertAtBack</span><span class="hljs-params">(T insertItem)</span> </span>{
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">if</span> (isEmpty())&nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;firstNode = lastNode = <span class="hljs-keyword">new</span> ListNode&lt;T&gt;(insertItem);
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">else</span>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;lastNode = lastNode.nextNode = <span class="hljs-keyword">new</span> ListNode&lt;T&gt;(insertItem);
&nbsp; &nbsp;}&nbsp;

&nbsp; &nbsp;
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> T <span class="hljs-title">removeFromFront</span><span class="hljs-params">()</span> <span class="hljs-keyword">throws</span> EmptyListException </span>{
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">if</span> (isEmpty())&nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="hljs-keyword">throw</span> <span class="hljs-keyword">new</span> EmptyListException(name);


&nbsp; &nbsp; &nbsp; T removedItem = firstNode.data;


&nbsp; &nbsp;&nbsp;
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">if</span> (firstNode == lastNode)
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;firstNode = lastNode = <span class="hljs-keyword">null</span>;
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">else</span>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;firstNode = firstNode.nextNode;


&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">return</span> removedItem;&nbsp;
&nbsp; &nbsp;}&nbsp;
&nbsp;&nbsp;
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> T <span class="hljs-title">removeFromBack</span><span class="hljs-params">()</span> <span class="hljs-keyword">throws</span> EmptyListException </span>{
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">if</span> (isEmpty())&nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="hljs-keyword">throw</span> <span class="hljs-keyword">new</span> EmptyListException(name);


&nbsp; &nbsp; &nbsp; T removedItem = lastNode.data;&nbsp;


&nbsp; &nbsp;&nbsp;
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">if</span> (firstNode == lastNode)
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;firstNode = lastNode = <span class="hljs-keyword">null</span>;
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">else</span>&nbsp;
&nbsp; &nbsp; &nbsp; {&nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;ListNode&lt;T&gt; current = firstNode;


&nbsp; &nbsp; &nbsp;&nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="hljs-keyword">while</span> (current.nextNode != lastNode)
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; current = current.nextNode;
&nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;lastNode = current;&nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;current.nextNode = <span class="hljs-keyword">null</span>;
&nbsp; &nbsp; &nbsp; }&nbsp;


&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">return</span> removedItem;&nbsp;
&nbsp; &nbsp;}&nbsp;
&nbsp;&nbsp;
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">boolean</span> <span class="hljs-title">isEmpty</span><span class="hljs-params">()</span> </span>{&nbsp;
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">return</span> firstNode == <span class="hljs-keyword">null</span>;
&nbsp; &nbsp;}&nbsp;

&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">print</span><span class="hljs-params">()</span> </span>{
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">if</span> (isEmpty()) {
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;System.out.printf(<span class="hljs-string">"Empty %s%n"</span>, name);
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="hljs-keyword">return</span>;
&nbsp; &nbsp; &nbsp; }

&nbsp; &nbsp; &nbsp; System.out.printf(<span class="hljs-string">"The %s is: "</span>, name);
&nbsp; &nbsp; &nbsp; ListNode&lt;T&gt; current = firstNode;

&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">while</span> (current != <span class="hljs-keyword">null</span>) {
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;System.out.printf(<span class="hljs-string">"%s "</span>, current.data);
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;current = current.nextNode;
&nbsp; &nbsp; &nbsp; }

&nbsp; &nbsp; &nbsp; System.out.println();
&nbsp; &nbsp;}&nbsp;
}&nbsp;
</pre><p><strong style="color: rgb(92, 0, 0);">Figura 21.3</strong> | Declarações de classe ListNode e List.</p><p><br></p><p><br></p><pre class="ql-syntax" spellcheck="false"><span class="hljs-keyword">public</span> <span class="hljs-class"><span class="hljs-keyword">class</span> <span class="hljs-title">ListTest</span> </span>{
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">static</span> <span class="hljs-keyword">void</span> <span class="hljs-title">main</span><span class="hljs-params">(String[] args)</span> </span>{
&nbsp; &nbsp; &nbsp; List&lt;Integer&gt; list = <span class="hljs-keyword">new</span> List&lt;&gt;();&nbsp;

&nbsp; &nbsp; &nbsp; list.insertAtFront(-<span class="hljs-number">1</span>);
&nbsp; &nbsp; &nbsp; list.print();
&nbsp; &nbsp; &nbsp; list.insertAtFront(<span class="hljs-number">0</span>);
&nbsp; &nbsp; &nbsp; list.print();
&nbsp; &nbsp; &nbsp; list.insertAtBack(<span class="hljs-number">1</span>);
&nbsp; &nbsp; &nbsp; list.print();
&nbsp; &nbsp; &nbsp; list.insertAtBack(<span class="hljs-number">5</span>);
&nbsp; &nbsp; &nbsp; list.print();
&nbsp; &nbsp; &nbsp;
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">try</span> {&nbsp;
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="hljs-keyword">int</span> removedItem = list.removeFromFront();
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;System.out.printf(<span class="hljs-string">"%n%d removed%n"</span>, removedItem);
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;list.print();

&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;removedItem = list.removeFromFront();
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;System.out.printf(<span class="hljs-string">"%n%d removed%n"</span>, removedItem);
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;list.print();

&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;removedItem = list.removeFromBack();
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;System.out.printf(<span class="hljs-string">"%n%d removed%n"</span>, removedItem);
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;list.print();


&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;removedItem = list.removeFromBack();
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;System.out.printf(<span class="hljs-string">"%n%d removed%n"</span>, removedItem);
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;list.print();
&nbsp; &nbsp; &nbsp; }&nbsp;
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">catch</span> (EmptyListException emptyListException){
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;emptyListException.printStackTrace();
&nbsp; &nbsp; &nbsp; }&nbsp;
&nbsp; &nbsp;}&nbsp;
}&nbsp;

</pre><p><strong style="color: rgb(92, 0, 0);">Figura 21.5</strong> | A classe ListTest para demonstrar as capacidades de List.</p><p><br></p><p><br></p>', 'Listas Encadeadas', true, 'APPROVED', '2021-03-16', 2, 3);
INSERT INTO topics (id, creation_date, description, body_html, name, required, status, update_date, created_by_id, discipline_id) VALUES (20, '2021-03-13', 'Listas, pilhas e filas são estruturas de dados lineares (isto é, sequências). Uma árvore é uma estrutura de dados bidimensional, não linear, com propriedades especiais. Os nós da árvore contêm dois ou mais links. Esta seção discute as árvores binárias (Figura 21.15) — árvores cujos nós contêm, cada um, dois links (nenhum, um ou ambos os quais podem ser null). O nó raiz é o primeiro nó em uma árvore. Cada link no nó raiz referencia um filho. O filho esquerdo é o primeiro nó na subárvore esquerda (também conhecido como o nó raiz da subárvore esquerda) e o filho direito é o primeiro nó na subárvore direita (também conhecido como o nó raiz da subárvore direita). Os filhos de um nó específico são chamados irmãos. Um nó sem filhos é chamado nó de folha. Os cientistas da computação normalmente desenham árvores indo do nó raiz para baixo — o oposto da maneira como a maioria das árvores cresce na natureza.', '<h2><strong>Árvores</strong></h2><p><br></p><h3>Listas, pilhas e filas são estruturas de dados lineares (isto é, sequências). Uma árvore é uma estrutura de dados bidimensional, não linear, com propriedades especiais. Os nós da árvore contêm dois ou mais links. Esta seção discute as árvores binárias (Figura 21.15) — árvores cujos nós contêm, cada um, dois links (nenhum, um ou ambos os quais podem ser null). O nó raiz é o primeiro nó em uma árvore. Cada link no nó raiz referencia um filho. O filho esquerdo é o primeiro nó na subárvore esquerda (também conhecido como o nó raiz da subárvore esquerda) e o filho direito é o primeiro nó na subárvore direita (também conhecido como o nó raiz da subárvore direita). Os filhos de um nó específico são chamados irmãos. Um nó sem filhos é chamado nó de folha. Os cientistas da computação normalmente desenham árvores indo do nó raiz para baixo — o oposto da maneira como a maioria das árvores cresce na natureza.</h3><h3><br></h3><h3>Em nosso exemplo, criamos uma árvore binária especial chamada árvore de pesquisa binária. Uma árvore de pesquisa binária (sem valores de nó duplicados) tem a característica de que os valores em qualquer subárvore esquerda são menores que o valor no nó pai dessa subárvore e os valores em qualquer subárvore direita são maiores que o valor no nó pai dessa subárvore. A Figura 21.16 ilustra uma árvore de pesquisa binária com 12 valores de inteiro. A forma da árvore de pesquisa binária que corresponde a um conjunto de dados pode variar, dependendo da ordem em que os valores são inseridos na árvore.</h3><h3><br></h3><h3>As figuras 21.17 e 21.18 criam uma classe genérica de árvore de pesquisa binária e a utilizam para manipular uma árvore de inteiros. O aplicativo na Figura 21.18 percorre a árvore (isto é, atravessa todos os nós) de três maneiras — usando percursos recursivos na ordem, na pré-ordem e na pós-ordem (árvores quase sempre são processadas de forma recursiva). O programa gera 10 números aleatórios e insere cada um na árvore. A classe Tree&lt;T&gt; é declarada no pacote com.deitel.datastructures para reutilização.</h3><p><br></p><p class="ql-align-center"><img src="data:image/png;base64,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"></p><p class="ql-align-center"><strong style="color: rgb(92, 0, 0);">Figura 21.15</strong> | Representação gráfica da árvore binária.</p><p class="ql-align-center"><br></p><p class="ql-align-center"><img src="data:image/png;base64,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"></p><p class="ql-align-center"><strong style="color: rgb(92, 0, 0);">Figura 21.16</strong> | Árvore de pesquisa binária contendo 12 valores.</p><p><br></p><pre class="ql-syntax" spellcheck="false"><span class="hljs-comment">// class TreeNode definition</span>
<span class="hljs-class"><span class="hljs-keyword">class</span> <span class="hljs-title">TreeNode</span>&lt;<span class="hljs-title">T</span> <span class="hljs-keyword">extends</span> <span class="hljs-title">Comparable</span>&lt;<span class="hljs-title">T</span>&gt;&gt; </span>{
&nbsp; &nbsp;<span class="hljs-comment">// package access members</span>
&nbsp; &nbsp;TreeNode&lt;T&gt; leftNode;&nbsp;
&nbsp; &nbsp;T data; <span class="hljs-comment">// node value</span>
&nbsp; &nbsp;TreeNode&lt;T&gt; rightNode;&nbsp;

&nbsp; &nbsp;<span class="hljs-comment">// constructor initializes data and makes this a leaf node</span>
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-title">TreeNode</span><span class="hljs-params">(T nodeData)</span> </span>{&nbsp;
&nbsp; &nbsp; &nbsp; data = nodeData;&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp;&nbsp;
&nbsp; &nbsp; &nbsp; leftNode = rightNode = <span class="hljs-keyword">null</span>; <span class="hljs-comment">// node has no children</span>
&nbsp; &nbsp;}&nbsp;

&nbsp; &nbsp;<span class="hljs-comment">// locate insertion point and insert new node; ignore duplicate values</span>
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">insert</span><span class="hljs-params">(T insertValue)</span>
&nbsp; &nbsp;</span>{
&nbsp; &nbsp; &nbsp; <span class="hljs-comment">// insert in left subtree</span>
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">if</span> (insertValue.compareTo(data) &lt; <span class="hljs-number">0</span>) {
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="hljs-comment">// insert new TreeNode</span>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="hljs-keyword">if</span> (leftNode == <span class="hljs-keyword">null</span>)
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; leftNode = <span class="hljs-keyword">new</span> TreeNode&lt;T&gt;(insertValue);
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="hljs-keyword">else</span> <span class="hljs-comment">// continue traversing left subtree recursively</span>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; leftNode.insert(insertValue);&nbsp;
&nbsp; &nbsp; &nbsp; } <span class="hljs-keyword">else</span> <span class="hljs-keyword">if</span> (insertValue.compareTo(data) &gt; <span class="hljs-number">0</span>) { <span class="hljs-comment">// insert in right subtree</span>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="hljs-comment">// insert new TreeNode</span>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="hljs-keyword">if</span> (rightNode == <span class="hljs-keyword">null</span>)
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; rightNode = <span class="hljs-keyword">new</span> TreeNode&lt;T&gt;(insertValue);
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="hljs-keyword">else</span> <span class="hljs-comment">// continue traversing right subtree recursively</span>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; rightNode.insert(insertValue);&nbsp;
&nbsp; &nbsp; &nbsp; }&nbsp;
&nbsp; &nbsp;}&nbsp;
} <span class="hljs-comment">// end class TreeNode</span>


<span class="hljs-comment">// class Tree definition</span>
<span class="hljs-keyword">public</span> <span class="hljs-class"><span class="hljs-keyword">class</span> <span class="hljs-title">Tree</span>&lt;<span class="hljs-title">T</span> <span class="hljs-keyword">extends</span> <span class="hljs-title">Comparable</span>&lt;<span class="hljs-title">T</span>&gt;&gt; </span>{
&nbsp; &nbsp;<span class="hljs-keyword">private</span> TreeNode&lt;T&gt; root;

&nbsp; &nbsp;<span class="hljs-comment">// constructor initializes an empty Tree of integers</span>
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-title">Tree</span><span class="hljs-params">()</span> </span>{&nbsp;
&nbsp; &nbsp; &nbsp; root = <span class="hljs-keyword">null</span>;&nbsp;
&nbsp; &nbsp;}&nbsp;

&nbsp; &nbsp;<span class="hljs-comment">// insert a new node in the binary search tree</span>
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">insertNode</span><span class="hljs-params">(T insertValue)</span> </span>{
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">if</span> (root == <span class="hljs-keyword">null</span>)
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;root = <span class="hljs-keyword">new</span> TreeNode&lt;T&gt;(insertValue); <span class="hljs-comment">// create root node</span>
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">else</span>
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;root.insert(insertValue); <span class="hljs-comment">// call the insert method</span>
&nbsp; &nbsp;}&nbsp;

&nbsp; &nbsp;<span class="hljs-comment">// begin preorder traversal</span>
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">preorderTraversal</span><span class="hljs-params">()</span> </span>{&nbsp;
&nbsp; &nbsp; &nbsp; preorderHelper(root);&nbsp;
&nbsp; &nbsp;}&nbsp;

&nbsp; &nbsp;<span class="hljs-comment">// recursive method to perform preorder traversal</span>
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">private</span> <span class="hljs-keyword">void</span> <span class="hljs-title">preorderHelper</span><span class="hljs-params">(TreeNode&lt;T&gt; node)</span> </span>{
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">if</span> (node == <span class="hljs-keyword">null</span>)
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="hljs-keyword">return</span>;

&nbsp; &nbsp; &nbsp; System.out.printf(<span class="hljs-string">"%s "</span>, node.data); <span class="hljs-comment">// output node data</span>
&nbsp; &nbsp; &nbsp; preorderHelper(node.leftNode); <span class="hljs-comment">// traverse left subtree</span>
&nbsp; &nbsp; &nbsp; preorderHelper(node.rightNode); <span class="hljs-comment">// traverse right subtree</span>
&nbsp; &nbsp;}&nbsp;

&nbsp; &nbsp;<span class="hljs-comment">// begin inorder traversal</span>
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">inorderTraversal</span><span class="hljs-params">()</span> </span>{&nbsp;
&nbsp; &nbsp; &nbsp; inorderHelper(root);&nbsp;
&nbsp; &nbsp;}&nbsp;

&nbsp; &nbsp;<span class="hljs-comment">// recursive method to perform inorder traversal</span>
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">private</span> <span class="hljs-keyword">void</span> <span class="hljs-title">inorderHelper</span><span class="hljs-params">(TreeNode&lt;T&gt; node)</span> </span>{
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">if</span> (node == <span class="hljs-keyword">null</span>)
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="hljs-keyword">return</span>;

&nbsp; &nbsp; &nbsp; inorderHelper(node.leftNode); <span class="hljs-comment">// traverse left subtree</span>
&nbsp; &nbsp; &nbsp; System.out.printf(<span class="hljs-string">"%s "</span>, node.data); <span class="hljs-comment">// output node data</span>
&nbsp; &nbsp; &nbsp; inorderHelper(node.rightNode); <span class="hljs-comment">// traverse right subtree</span>
&nbsp; &nbsp;}&nbsp;

&nbsp; &nbsp;<span class="hljs-comment">// begin postorder traversal</span>
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">void</span> <span class="hljs-title">postorderTraversal</span><span class="hljs-params">()</span> </span>{&nbsp;
&nbsp; &nbsp; &nbsp; postorderHelper(root);&nbsp;
&nbsp; &nbsp;}&nbsp;

&nbsp; &nbsp;<span class="hljs-comment">// recursive method to perform postorder traversal</span>
&nbsp; &nbsp;<span class="hljs-function"><span class="hljs-keyword">private</span> <span class="hljs-keyword">void</span> <span class="hljs-title">postorderHelper</span><span class="hljs-params">(TreeNode&lt;T&gt; node)</span> </span>{
&nbsp; &nbsp; &nbsp; <span class="hljs-keyword">if</span> (node == <span class="hljs-keyword">null</span>)
&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;<span class="hljs-keyword">return</span>;
&nbsp;&nbsp;
&nbsp; &nbsp; &nbsp; postorderHelper(node.leftNode); <span class="hljs-comment">// traverse left subtree</span>
&nbsp; &nbsp; &nbsp; postorderHelper(node.rightNode); <span class="hljs-comment">// traverse right subtree</span>
&nbsp; &nbsp; &nbsp; System.out.printf(<span class="hljs-string">"%s "</span>, node.data); <span class="hljs-comment">// output node data</span>
&nbsp; &nbsp;}&nbsp;
} <span class="hljs-comment">// end class Tree</span>
</pre><p><strong style="color: rgb(92, 0, 0);">Figura 21.17</strong> | Declarações de classe TreeNode e Tree para uma árvore de pesquisa binária.</p><p><br></p><h2><strong>Resumo</strong></h2><p><br></p><p>• Uma árvore é uma estrutura de dados bidimensional não linear. Os nós da árvore contêm dois ou mais links.</p><p>• Uma árvore binária é uma árvore cujos nós contêm dois ou mais links. O nó raiz é o primeiro nó em uma árvore.</p><p>• Cada link no nó raiz refere-se a um filho. O filho esquerdo é o primeiro nó na subárvore esquerda, e o filho direito é o primeiro nó na subárvore direita.</p><p>• Os filhos de um nó são chamados irmãos. Um nó sem filhos é um nó de folha.</p><p>• Em uma árvore de pesquisa binária sem valores duplicados, os valores em qualquer subárvore esquerda são menores que o valor no nó pai da subárvore e os valores em qualquer subárvore direita são maiores que o valor no nó pai da subárvore. Um nó pode ser inserido apenas como um nó de folha em uma árvore de pesquisa binária.</p><p>• Um percurso na ordem de uma árvore de pesquisa binária processa os valores de nó na ordem crescente.</p><p>• Em um percurso na pré-ordem, o valor em cada nó é processado quando o nó é percorrido. Então, os valores na subárvore esquerda são processados e, em seguida, os valores na subárvore direita.</p><p>• Em um percurso na pós-ordem, o valor em cada nó é processado depois dos valores de seus filhos.</p><p>• A árvore de pesquisa binária facilita a eliminação de duplicatas. Quando a árvore é criada, as tentativas de inserir um valor duplicado são reconhecidas porque uma duplicata segue as mesmas decisões “siga para a esquerda” ou “siga para a direita” em cada comparação que o valor original fez. Portanto, a duplicata acaba sendo comparada com um nó contendo o mesmo valor. O valor duplicado pode ser descartado nesse ponto.</p><p>• Em uma árvore fortemente empacotada, cada nível contém aproximadamente duas vezes o número de elementos que o anterior. Então, uma árvore de pesquisa binária fortemente empacotada com elementos n tem log2 n níveis e, portanto, no máximo log2 n comparações teriam de ser feitas para localizar uma correspondência ou determinar que não existe nenhuma correspondência. Pesquisar em uma árvore de pesquisa binária (fortemente empacotada) de 1.000 elementos requer no máximo 10 comparações, pois 210 &gt; 1.000. Pesquisar em uma árvore de pesquisa binária (fortemente empacotada) de 1.000.000 elementos requer no máximo 20 comparações, pois 220 &gt; 1.000.000.</p>', 'Árvores', true, 'APPROVED', '2021-03-16', 2, 3);


--
-- Data for Name: questions; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (1, '2021-03-13 05:55:02.685', 'Java é:', 'APPROVED', 'QUIZ', '2021-03-13 05:55:02.685', 11, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (2, '2021-03-13 05:55:02.705', 'int x = 10;<br>System.out.print(++x);<br><br>A saída será:', 'APPROVED', 'QUIZ', '2021-03-13 05:55:02.705', 11, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (3, '2021-03-13 05:55:02.723', 'Pergunta 1:', 'APPROVED', 'TEST', '2021-03-13 05:55:02.724', 11, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (4, '2021-03-13 05:55:02.756', 'Pergunta 2:', 'APPROVED', 'TEST', '2021-03-13 05:55:02.756', 8, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (5, '2021-03-13 05:55:02.772', 'Pergunta 3:', 'APPROVED', 'TEST', '2021-03-13 05:55:02.772', 8, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (6, '2021-03-13 05:55:02.786', 'x = 10 + 1;
System.out.print("x--");

 A saída será:', 'APPROVED', 'TEST', '2021-03-13 05:55:02.786', 10, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (7, '2021-03-13 05:55:02.816', 'Considerando que uma queue seqüencial utiliza dois apontadores para indicar suas posições de final e início da estrutura, supondo que a queue foi criada com os apontadores apontando para a posição zero do vetor, qual das alternativas a seguir pode caracterizar uma fila vazia?', 'APPROVED', 'TEST', '2021-03-13 05:55:02.816', 18, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (8, '2021-03-13 05:55:02.83', 'Leia com atenção as afirmativas abaixo e assinale a resposta correta. A estrutura de dados que melhor representa os diretórios ou pastas de arquivos do computador é a árvore II A estrutura de dados FILA é não linear assim como o Grafo.', 'APPROVED', 'TEST', '2021-03-13 05:55:02.83', 18, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (9, '2021-03-13 05:55:02.845', 'Considerando que uma queue seqüencial utiliza dois apontadores para indicar suas posições de final e início da estrutura, supondo que a queue foi criada com os apontadores apontando para a posição zero do vetor, qual das alternativas a seguir pode caracterizar uma fila vazia?', 'APPROVED', 'TEST', '2021-03-13 05:55:02.845', 18, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (10, '2021-03-13 05:55:02.866', 'Considerando que uma queue seqüencial utiliza dois apontadores para indicar suas posições de final e início da estrutura, supondo que a queue foi criada com os apontadores apontando para a posição zero do vetor, qual das alternativas a seguir pode caracterizar uma fila vazia?', 'APPROVED', 'TEST', '2021-03-13 05:55:02.866', 18, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (11, '2021-03-13 05:55:02.879', 'Considerando que uma queue seqüencial utiliza dois apontadores para indicar suas posições de final e início da estrutura, supondo que a queue foi criada com os apontadores apontando para a posição zero do vetor, qual das alternativas a seguir pode caracterizar uma fila vazia?', 'APPROVED', 'TEST', '2021-03-13 05:55:02.88', 18, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (13, '2021-03-15 23:47:50.927', '<p>Um ataque em que uma pessoa liga e finge ser um membro do departamento de TI para obter a senha de um usuário é conhecido como qual das seguintes?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-15 23:47:50.927', 33, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (14, '2021-03-15 23:49:20.289', '<p>Qual aspecto da segurança está preocupado com a prevenção de pessoas não autorizadas modificação de informações?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-15 23:49:20.289', 33, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (15, '2021-03-16 08:50:44.477', '<p>Qual aspecto da segurança é ameaçado por um ataque smurf?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 08:50:44.477', 33, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (16, '2021-03-16 08:51:47.693', '<p>A análise qualitativa de risco considera a probabilidade de ameaças, mas não o valor dos ativos. Verdadeiro ou falso?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 08:51:47.693', 33, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (17, '2021-03-16 08:54:38.478', '<p>Qual dos seguintes ativos é mais difícil de associar a um valor matemático?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 08:54:38.478', 33, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (18, '2021-03-16 08:55:54.472', '<p>Um scanner de vulnerabilidade pode ser usado para identificar vulnerabilidades e avaliar quão críticos eles são. Verdadeiro ou falso?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 08:55:54.472', 33, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (19, '2021-03-16 09:09:44.432', '<p>Qual camada do modelo OSI é responsável pelo roteamento?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 09:09:44.432', 34, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (20, '2021-03-16 09:13:11.789', '<p>Qual protocolo TCP / IP é uma alternativa segura ao Telnet?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 09:13:11.789', 34, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (21, '2021-03-16 09:15:37.369', '<p>Qual porta está associada ao e-mail POP3?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 09:15:37.369', 34, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (22, '2021-03-16 09:25:26.85', '<p>Um scanner de porta identifica que a porta 23 está aberta. O que isso diz a um atacante sobre o computador?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 09:25:26.85', 34, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (23, '2021-03-16 09:38:12.328', '<p>A única maneira de quebrar uma cifra de substituição é com a análise de frequência. Verdadeiro ou falso?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 09:38:12.328', 35, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (24, '2021-03-16 09:39:31.912', '<p>Quais são as primitivas de criptografia?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 09:39:31.912', 35, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (25, '2021-03-16 09:40:22.264', '<p>Qual dos seguintes é um algoritmo de criptografia simétrica que pode usar tamanhos de chave de 128, 192 ou 256 bits?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 09:40:22.264', 35, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (26, '2021-03-16 09:40:49.83', '<p>Uma cifra de fluxo requer preenchimento. Verdadeiro ou falso?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 09:40:49.83', 35, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (27, '2021-03-16 09:41:22.954', '<p>Uma cifra de fluxo fornece integridade. Verdadeiro ou falso?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 09:41:22.954', 35, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (28, '2021-03-16 13:14:54.702', '<p>Preencha a lacuna da seguinte afirmação abaixo:</p><p><br></p><p>Uma classe ________ é utilizada para formar estruturas de dados dinâmicas que podem crescer e encolher em tempo de execução.</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 13:14:54.702', 37, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (29, '2021-03-16 14:06:54.968', '<p>O que acontece quando se deseja inserir um elemento em uma FILA que já está cheia?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 14:06:54.968', 18, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (30, '2021-03-16 14:08:01.619', '<p>Ao inserirmos em uma estrutura de dados do tipo fila sequencial os seguintes elementos: A, B, C, D, exatamente nesta ordem. E em seguida realizarmos duas operações consecutivas de remoção na fila e imediatamente inserirmos dois novos elementos o X e o W. Podemos afirmar que se realizarmos uma nova operação de remoção, o elemento que será removido desta fila será o:</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 14:08:01.619', 18, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (31, '2021-03-16 14:11:16.883', '<p>Em uma pesquisa sequencial a lista deve estar?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 14:11:16.883', 15, 1);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (32, '2021-03-16 14:12:58.957', '<p>Navegadores para internet armazenam os últimos endereços visitados em uma estrutura de dados. Cada vez que um novo site é visitado, o endereço do site é adicionado na estrutura de endereços. Quando se aciona o retorno ("back"), o navegador permite que o usuário retorne no último site visitado e retira o endereço do site da estrutura de dados.</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 14:12:58.957', 17, 1);


--
-- Data for Name: alternatives; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (1, false, 'Linguagem de Marcação de Texto', 'Errado! Estude com mais atenção!', 1);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (2, false, 'Uma linguagem de programação funcional', 'Quasee! Estude com mais atenção!', 1);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (3, true, 'Uma linguagem de programação orientada a objetos', 'Parabéns! Esta é a resposta certa!', 1);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (4, false, 'uma IDE', 'Errado! Estude com mais atenção!', 1);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (5, true, '11', 'Parabéns! Esta é a resposta certa!', 2);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (6, false, '9', 'Quasee! Estude com mais atenção!', 2);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (7, false, 'Error', 'Errado! Estude com mais atenção!', 2);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (8, false, '10', 'Errado! Estude com mais atenção!', 2);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (9, true, 'Resposta 1', 'Parabéns! Esta é a resposta certa!', 3);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (10, false, 'Resposta 2', 'Quasee! Estude com mais atenção!', 3);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (11, false, 'Resposta 3', 'Errado! Estude com mais atenção!', 3);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (12, false, 'Resposta 4', 'Errado! Estude com mais atenção!', 3);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (13, false, 'Resposta 5', 'Errado! Estude com mais atenção!', 3);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (14, true, 'Resposta 1', 'Parabéns! Esta é a resposta certa!', 4);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (15, false, 'Resposta 2', 'Quasee! Estude com mais atenção!', 4);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (16, false, 'Resposta 3', 'Errado! Estude com mais atenção!', 4);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (17, false, 'Resposta 4', 'Errado! Estude com mais atenção!', 4);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (18, false, 'Resposta 5', 'Errado! Estude com mais atenção!', 4);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (19, true, 'Resposta 1', 'Parabéns! Esta é a resposta certa!', 5);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (20, false, 'Resposta 2', 'Quasee! Estude com mais atenção!', 5);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (21, false, 'Resposta 3', 'Errado! Estude com mais atenção!', 5);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (22, false, 'Resposta 4', 'Errado! Estude com mais atenção!', 5);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (23, false, 'Resposta 5', 'Errado! Estude com mais atenção!', 5);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (24, false, '11', 'Errado! Estude com mais atenção!', 6);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (25, false, '9', 'Quasee! Estude com mais atenção!', 6);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (26, false, 'Error', 'Errado! Estude com mais atenção!', 6);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (27, true, 'x--', 'Parabéns! Esta é a resposta certa!', 6);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (28, false, '10', 'Resposta Errada!', 6);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (29, false, 'Quando o apontador de início apontar para zero.', 'Errado! Estude com mais atenção!', 7);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (30, false, 'Quando o apontador de final apontar para zero.', 'Quasee! Estude com mais atenção!', 7);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (31, false, 'Quando o apontador de final menos um (final-1) for igual ao início.', 'Errado! Estude com mais atenção!', 7);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (32, true, 'Quando os apontadores de final e início apontarem para zero.', 'Parabéns! Esta é a resposta certa!', 7);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (33, false, 'Quando o apontador de posição final for igual ao início.', 'Resposta Errada!', 7);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (34, false, 'Quando o apontador de início apontar para zero.', 'Errado! Estude com mais atenção!', 8);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (35, false, 'Quando o apontador de final apontar para zero.', 'Quasee! Estude com mais atenção!', 8);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (36, false, 'Quando o apontador de final menos um (final-1) for igual ao início.', 'Errado! Estude com mais atenção!', 8);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (37, true, 'Quando os apontadores de final e início apontarem para zero.', 'Parabéns! Esta é a resposta certa!', 8);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (38, false, 'Quando o apontador de posição final for igual ao início.', 'Resposta Errada!', 8);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (39, false, 'Quando o apontador de início apontar para zero.', 'Errado! Estude com mais atenção!', 9);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (40, false, 'Quando o apontador de final apontar para zero.', 'Quasee! Estude com mais atenção!', 9);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (41, false, 'Quando o apontador de final menos um (final-1) for igual ao início.', 'Errado! Estude com mais atenção!', 9);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (42, true, 'Quando os apontadores de final e início apontarem para zero.', 'Parabéns! Esta é a resposta certa!', 9);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (43, false, 'Quando o apontador de posição final for igual ao início.', 'Resposta Errada!', 9);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (44, false, 'Quando o apontador de início apontar para zero.', 'Errado! Estude com mais atenção!', 10);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (45, false, 'Quando o apontador de final apontar para zero.', 'Quasee! Estude com mais atenção!', 10);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (46, false, 'Quando o apontador de final menos um (final-1) for igual ao início.', 'Errado! Estude com mais atenção!', 10);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (47, true, 'Quando os apontadores de final e início apontarem para zero.', 'Parabéns! Esta é a resposta certa!', 10);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (48, false, 'Quando o apontador de posição final for igual ao início.', 'Resposta Errada!', 10);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (49, false, 'Quando o apontador de início apontar para zero.', 'Errado! Estude com mais atenção!', 11);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (50, false, 'Quando o apontador de final apontar para zero.', 'Quasee! Estude com mais atenção!', 11);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (51, false, 'Quando o apontador de final menos um (final-1) for igual ao início.', 'Errado! Estude com mais atenção!', 11);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (52, true, 'Quando os apontadores de final e início apontarem para zero.', 'Parabéns! Esta é a resposta certa!', 11);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (53, false, 'Quando o apontador de posição final for igual ao início.', 'Resposta Errada!', 11);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (57, false, 'Script de ataque', '', 13);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (58, false, 'Ataque de força bruta', '', 13);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (59, false, 'Ataque de dicionário', '', 13);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (60, true, 'Ataque de engenharia social', '', 13);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (61, false, 'Autorização', '', 14);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (62, false, 'Confidencialidade', '', 14);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (63, true, 'Integridade', '', 14);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (64, false, 'Não-repúdio', '', 14);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (65, true, 'Disponibilidade', '', 15);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (66, false, 'Responsabilidade', '', 15);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (67, false, 'Integridade', '', 15);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (68, false, 'Confidencialidade', '', 15);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (69, false, 'Verdadeiro', '', 16);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (70, true, 'Falso', '', 16);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (71, false, 'Computador portátil', '', 17);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (72, false, 'Servidor de banco de dados', '', 17);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (73, true, 'Reputação', '', 17);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (74, false, 'Disponibilidade do servidor web', '', 17);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (75, true, 'Verdadeiro', '', 18);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (76, false, 'Falso', '', 18);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (77, false, 'Link de Dados', '', 19);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (78, true, 'Camada de Rede', '', 19);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (79, false, 'Sessão', '', 19);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (80, false, 'Transporte', '', 19);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (81, false, 'ARP', '', 20);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (82, false, 'Finger', '', 20);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (83, false, 'Rlogin', '', 20);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (84, true, 'SSH', '', 20);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (85, false, '25', '', 21);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (86, false, '79', '', 21);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (87, true, '110', '', 21);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (88, false, '445', '', 21);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (89, false, 'É um servidor web.', '', 22);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (90, false, 'Está executando o serviço FTP.', '', 22);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (91, true, 'Pode ser acessado por Telnet.', '', 22);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (92, false, 'Pode ser acessado por SSH.', '', 22);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (93, false, 'Verdadeiro', '', 23);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (94, true, 'Falso', '', 23);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (95, false, 'Confidencialidade, integridade, autenticação', '', 24);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (96, true, 'Geração de número aleatório, criptografia simétrica, assimétrica criptografia, funções hash', '', 24);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (97, false, 'Força da chave, profundidade, previsibilidade', '', 24);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (98, false, 'Confidencialidade, integridade, disponibilidade', '', 24);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (99, true, 'AES', '', 25);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (100, false, 'DES', '', 25);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (101, false, '3DES', '', 25);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (102, false, 'RSA', '', 25);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (103, false, 'Verdadeiro', '', 26);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (104, true, 'Falso', '', 26);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (105, true, 'Verdadeiro', '', 27);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (106, false, 'Falso', '', 27);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (107, false, 'final', '', 28);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (108, false, 'private', '', 28);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (109, true, 'autorreferencial', '', 28);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (110, false, 'genérica', '', 28);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (111, true, 'Overflow.', '', 29);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (112, false, 'Underflow.', '', 29);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (113, false, 'A inserção é feita sem problema.', '', 29);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (114, false, 'Dequeue.', '', 29);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (115, false, 'Enqueue.', '', 29);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (116, false, 'A', '', 30);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (117, true, 'D', '', 30);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (118, false, 'X', '', 30);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (119, false, 'C', '', 30);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (120, false, 'W', '', 30);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (121, true, 'ordenada somente o primeiro da lista.', '', 31);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (122, false, 'desordenada somente da metade da lista até o final.', '', 31);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (123, false, 'ordenada somente do início até a metade da lista.', '', 31);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (124, false, 'ordenada ou desordenada.', '', 31);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (125, false, 'sempre desordenada.', '', 31);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (126, false, 'grafo', '', 32);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (127, true, 'pilha', '', 32);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (128, false, 'árvore', '', 32);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (129, false, 'fila', '', 32);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (130, false, 'lista', '', 32);


--
-- Data for Name: answers; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: comments; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: discipline_users; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO discipline_users (access_date, liked, user_id, discipline_id) VALUES ('2021-03-15 21:01:33.125', false, 1, 1);
INSERT INTO discipline_users (access_date, liked, user_id, discipline_id) VALUES ('2021-03-16 12:24:21.895', false, 1, 2);
INSERT INTO discipline_users (access_date, liked, user_id, discipline_id) VALUES ('2021-03-16 12:24:40.503', false, 1, 12);
INSERT INTO discipline_users (access_date, liked, user_id, discipline_id) VALUES ('2021-03-16 14:12:19.741', false, 1, 3);


--
-- Data for Name: forum_topics; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO forum_topics (id, creation_date, body_html, likes, title, discipline_id, user_id) VALUES (1, '2021-03-13 05:55:02.911', 'alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi', 0, 'Duvida Routers', 4, 4);
INSERT INTO forum_topics (id, creation_date, body_html, likes, title, discipline_id, user_id) VALUES (2, '2021-03-13 05:55:02.923', 'alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi', 0, 'Alguem me ajuda por favoor!!!', 4, 3);
INSERT INTO forum_topics (id, creation_date, body_html, likes, title, discipline_id, user_id) VALUES (3, '2021-03-13 05:55:02.926', 'alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi', 0, 'Configurar um Roteador', 4, 6);


--
-- Data for Name: forum_topic_comments; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO forum_topic_comments (id, body_html, creation_date, likes, forum_topic_id, user_id) VALUES (1, 'Comment 1', '2021-03-13 05:55:02.939', 0, 1, 2);
INSERT INTO forum_topic_comments (id, body_html, creation_date, likes, forum_topic_id, user_id) VALUES (2, 'Comment 2', '2021-03-13 05:55:02.944', 0, 1, 3);
INSERT INTO forum_topic_comments (id, body_html, creation_date, likes, forum_topic_id, user_id) VALUES (3, 'Comment 3', '2021-03-13 05:55:02.951', 0, 1, 4);
INSERT INTO forum_topic_comments (id, body_html, creation_date, likes, forum_topic_id, user_id) VALUES (4, 'Comment 4', '2021-03-13 05:55:02.954', 0, 2, 2);
INSERT INTO forum_topic_comments (id, body_html, creation_date, likes, forum_topic_id, user_id) VALUES (5, 'Comment 5', '2021-03-13 05:55:02.958', 0, 3, 5);
INSERT INTO forum_topic_comments (id, body_html, creation_date, likes, forum_topic_id, user_id) VALUES (6, 'Comment 6', '2021-03-13 05:55:02.961', 0, 3, 6);
INSERT INTO forum_topic_comments (id, body_html, creation_date, likes, forum_topic_id, user_id) VALUES (7, 'Comment 7', '2021-03-13 05:55:02.964', 0, 3, 6);


--
-- Data for Name: games; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: game_users; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: rounds; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: games_rounds; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: games_topics; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: messages; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO messages (id, date, new_message, subject, text, sender_id, recipient_id) VALUES (1, '2021-03-13 05:55:01.99', false, 'Subject 1', 'Text 1', 5, 2);
INSERT INTO messages (id, date, new_message, subject, text, sender_id, recipient_id) VALUES (2, '2021-03-13 05:55:01.995', false, 'Subject 2', 'Text 2', 2, 5);
INSERT INTO messages (id, date, new_message, subject, text, sender_id, recipient_id) VALUES (3, '2021-03-13 05:55:01.998', false, 'Subject 3', 'Text 3', 3, 2);
INSERT INTO messages (id, date, new_message, subject, text, sender_id, recipient_id) VALUES (4, '2021-03-13 05:55:02.002', false, 'Subject 4', 'Text 4', 4, 5);
INSERT INTO messages (id, date, new_message, subject, text, sender_id, recipient_id) VALUES (5, '2021-03-13 05:55:02.005', false, 'Subject 5', 'Text 5', 1, 2);
INSERT INTO messages (id, date, new_message, subject, text, sender_id, recipient_id) VALUES (6, '2021-03-13 05:55:02.009', false, 'Subject 6', 'Text 6', 1, 2);


--
-- Data for Name: rewards; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO rewards (id, date, type, user_id) VALUES (1, '2021-03-13 05:55:02.025', 'RIGHT_ANSWER', 2);
INSERT INTO rewards (id, date, type, user_id) VALUES (2, '2021-03-13 05:55:02.031', 'GAME', 2);
INSERT INTO rewards (id, date, type, user_id) VALUES (3, '2021-03-13 05:55:02.034', 'RIGHT_ANSWER', 6);
INSERT INTO rewards (id, date, type, user_id) VALUES (4, '2021-03-13 05:55:02.037', 'TEST_SUCCESS', 6);
INSERT INTO rewards (id, date, type, user_id) VALUES (5, '2021-03-15 23:13:59.419', 'RIGHT_ANSWER', 1);
INSERT INTO rewards (id, date, type, user_id) VALUES (6, '2021-03-15 23:48:01.983', 'RIGHT_ANSWER', 1);
INSERT INTO rewards (id, date, type, user_id) VALUES (7, '2021-03-16 12:24:57.575', 'WRONG_ANSWER', 1);
INSERT INTO rewards (id, date, type, user_id) VALUES (8, '2021-03-16 12:25:03.084', 'WRONG_ANSWER', 1);
INSERT INTO rewards (id, date, type, user_id) VALUES (9, '2021-03-16 14:04:59.047', 'WRONG_ANSWER', 1);
INSERT INTO rewards (id, date, type, user_id) VALUES (10, '2021-03-16 14:05:04.706', 'WRONG_ANSWER', 1);
INSERT INTO rewards (id, date, type, user_id) VALUES (11, '2021-03-16 14:05:12.28', 'WRONG_ANSWER', 1);
INSERT INTO rewards (id, date, type, user_id) VALUES (12, '2021-03-16 14:05:15.733', 'WRONG_ANSWER', 1);
INSERT INTO rewards (id, date, type, user_id) VALUES (13, '2021-03-16 14:05:19.192', 'WRONG_ANSWER', 1);


--
-- Data for Name: roles; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');


--
-- Data for Name: rounds_users_who_answered; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: tests; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: tests_questions; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: tests_topics; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: topic_users; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: user_activities; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO user_activities (complete_tests, content_uploaded, game_losses, game_wins, right_answers, wrong_answers, user_id) VALUES (0, 0, 0, 0, 0, 0, 2);
INSERT INTO user_activities (complete_tests, content_uploaded, game_losses, game_wins, right_answers, wrong_answers, user_id) VALUES (0, 0, 0, 0, 0, 0, 3);
INSERT INTO user_activities (complete_tests, content_uploaded, game_losses, game_wins, right_answers, wrong_answers, user_id) VALUES (0, 0, 0, 0, 0, 0, 4);
INSERT INTO user_activities (complete_tests, content_uploaded, game_losses, game_wins, right_answers, wrong_answers, user_id) VALUES (0, 0, 0, 0, 0, 0, 5);
INSERT INTO user_activities (complete_tests, content_uploaded, game_losses, game_wins, right_answers, wrong_answers, user_id) VALUES (0, 0, 0, 0, 0, 0, 6);
INSERT INTO user_activities (complete_tests, content_uploaded, game_losses, game_wins, right_answers, wrong_answers, user_id) VALUES (0, 0, 0, 0, 2, 7, 1);


--
-- Data for Name: user_role; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO user_role (user_id, role_id) VALUES (1, 2);
INSERT INTO user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO user_role (user_id, role_id) VALUES (2, 2);
INSERT INTO user_role (user_id, role_id) VALUES (3, 2);
INSERT INTO user_role (user_id, role_id) VALUES (4, 2);
INSERT INTO user_role (user_id, role_id) VALUES (5, 2);
INSERT INTO user_role (user_id, role_id) VALUES (6, 2);


--
-- Name: alternatives_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('alternatives_id_seq', 130, true);


--
-- Name: comments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('comments_id_seq', 1, false);


--
-- Name: courses_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('courses_id_seq', 5, true);


--
-- Name: disciplines_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('disciplines_id_seq', 10, true);


--
-- Name: forum_topic_comments_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('forum_topic_comments_id_seq', 7, true);


--
-- Name: forum_topics_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('forum_topics_id_seq', 3, true);


--
-- Name: games_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('games_id_seq', 1, false);


--
-- Name: institutions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('institutions_id_seq', 2, true);


--
-- Name: messages_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('messages_id_seq', 6, true);


--
-- Name: questions_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('questions_id_seq', 32, true);


--
-- Name: rewards_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('rewards_id_seq', 13, true);


--
-- Name: roles_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('roles_id_seq', 2, true);


--
-- Name: rounds_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('rounds_id_seq', 1, false);


--
-- Name: tests_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('tests_id_seq', 1, false);


--
-- Name: topics_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('topics_id_seq', 37, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('users_id_seq', 6, true);


--
-- PostgreSQL database dump complete
--

