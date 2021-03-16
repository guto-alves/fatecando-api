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

INSERT INTO courses (id, code, description, image_url, name, semesters, institution_id) VALUES (1, 'ADS', 'A matemática, em especial raciocínio lógico e cálculo, é necessária para que o aluno aprenda a otimizar computadores e a desenvolver softwares. O aluno recebe noções sobre Bancos de Dados, sistemas baseados em web (como serviços bancários pela internet) e programação distribuída, que conecta computadores em rede para que funcionem como se fossem um só computador. Administração, contabilidade, economia, estatística e inglês também fazem parte do currículo. Além disso, habilidades para leitura e interpretação de textos são fundamentais para o aprendizado durante o curso. Hoje, o mercado não aceita mais profissionais que se isolam na frente do computador. As empresas exigem pessoas versáteis, dinâmicas, que saibam trabalhar em equipe e possam ter contato com o usuário final do sistema.', 'http://www.fatecsp.br/img/ti.jpg', 'Análise e Desenvolvimento de Sistemas', 6, 1);
INSERT INTO courses (id, code, description, image_url, name, semesters, institution_id) VALUES (2, 'LOG', 'O estudante vai aprender a determinar custos, como fretes e tributos e a planejar rotas de transporte e entrega de mercadorias de maneira eficiente, com qualidade, dentro do prazo estabelecido e a preços competitivos. Por isso, são importantes as disciplinas de cálculo, estatística, matemática financeira, economia e finanças empresariais. O aluno também estuda meios de transporte, suas características e vantagens. Aprende ainda a fazer a gestão de um estoque, a criar embalagens de produtos que facilitem o armazenamento e o transporte e a utilizar softwares de simulação de cargas e roteiros. Gestão, comércio exterior, logística internacional, inglês e espanhol são as disciplinas que completam o currículo.', 'http://www.fateczl.edu.br/imagens/logistica.png', 'Logística', 6, 1);
INSERT INTO courses (id, code, description, image_url, name, semesters, institution_id) VALUES (3, 'COMEX', 'As disciplinas que oferecem base para o curso são administração, economia e comunicação. O aluno vai estudar matemática, estatística, gestão de custos e tributos, gestão financeira, logística, contabilidade, economia internacional e os idiomas inglês e espanhol. As matérias específicas de Comércio Exterior abrangem aspectos geográficos, históricos, políticos e econômicos. O estudante vai aprender sobre blocos econômicos, acordos comerciais firmados entre o Brasil e os demais países do mundo, os organismos internacionais que intervêm no setor, logística internacional, processos de exportação e importação, práticas cambiais, marketing internacional e direito internacional, entre outros temas.', 'http://www.fateczl.edu.br/imagens/comex.jpg', 'Comércio Exterior', 5, 1);
INSERT INTO courses (id, code, description, image_url, name, semesters, institution_id) VALUES (4, 'RH', 'Todos os assuntos são tratados com foco em pessoas, na sua relação com o trabalho. As disciplinas administração financeira, estatística, economia e legislação são os pilares para a aprendizagem de cálculos trabalhistas, análise de retorno de investimento em treinamento etc. Há ainda ênfase no estudo do comportamento do profissional no ambiente de trabalho. Como realizar recrutamento, seleção, treinamento de profissionais, definição de tarefas e funções de acordo com a habilidade de cada indivíduo e cuidados com a qualidade de vida no trabalho completam a formação.', 'http://www.fateczl.edu.br/imagens/gestao_rh.jpg', 'Gestão de Recursos Humanos', 5, 1);
INSERT INTO courses (id, code, description, image_url, name, semesters, institution_id) VALUES (5, 'GEM', 'Contabilidade, economia e administração são as bases de Gestão Empresarial. Direito tributário, logística, empreendedorismo, gestão ambiental, comportamento organizacional (postura do profissional no ambiente de trabalho) e utilização de ferramentas de marketing para motivar e orientar os funcionários também fazem parte da formação. O aluno também aprende a elaborar o planejamento estratégico, que define os objetivos de uma empresa a traçar as estratégias para alcançá-los, usando os recursos disponíveis de maneira eficiente.', 'http://www.fateczl.edu.br/imagens/gestaoempresarial.jpg', 'Gestão Empresarial', 5, 2);


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


INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (7, '2021-03-13', 'Descrever os tipos de dispositvios e a função de cada um', '<p>Bla bla bla bla</p>', 'Dispositivos Finais e Dispositivos de WAN', false, 'APPROVED', '2021-03-13', 1, 4);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (8, '2021-03-13', 'Description description description description', '<h3>Title</h3><br><p>F açsdkfj  aklsdfj çla <b>lçagj</b></p>', 'Cisco e ferramentas Cisco', false, 'APPROVED', '2021-03-13', 1, 4);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (9, '2021-03-13', 'Demonstrar a configuração de um Roteador', '<h3>Title</h3><br><p>F afasd f açsdkfj  aklsdfj çla <b>lçagj</b></p>', 'Wan e Roteadores', true, 'APPROVED', '2021-03-13', 1, 4);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (10, '2021-03-13', 'Configurar um grupo de roteadores e o roteamento estático', '<h3>Title</h3><br><p>F afasd fla lj açsdkfj  aklsdfj çla <b>lçagj</b></p>', 'Roteamento estático', true, 'APPROVED', '2021-03-13', 1, 4);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (11, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Introdução a Java', true, 'APPROVED', '2021-03-13', 2, 1);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (12, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Algoritmos', true, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (13, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Vetores e Matrizes', true, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (14, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Modularização', true, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (15, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Lista Encadeada', true, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (16, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Listas', true, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (17, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Pilha', true, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (18, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Fila', true, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (19, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Recursividade', true, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (20, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Ârvores', true, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (21, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Percurso em Arvores', true, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (22, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Percurso em Profundidade em Ârvores', true, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (23, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Percurso Preordem, Inordem, Posordem', true, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (24, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Ordenação', true, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (25, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Collections Java', true, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (26, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Diretorios e Arquivos', true, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (27, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Sorting Heapsort e Heapfy', true, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (28, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Binary Search', true, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (29, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Sorting - Selection', false, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (30, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Sorting - QuickSort', false, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (31, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Sorting - MergeSort', false, 'APPROVED', '2021-03-13', 2, 3);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (32, '2021-03-15', 'Neste tópico, você irá: Escrever aplicativos Java simples, usar declarações de entrada e saída e aprender os tipos primitivos em Java.', '<h2><strong>1. Introdução</strong></h2><p><br></p><h3>Este capítulo apresenta a programação de aplicativos Java. Começaremos com exemplos de programas que exibem (saída) mensagens na tela. Em seguida, demonstraremos um programa que obtém (aceita a entrada) dois números de um usuário, calcula a soma e exibe o resultado. Você aprenderá como instruir o computador a executar cálculos aritméticos e a salvar os resultados para uso posterior. O último exemplo demonstra como tomar decisões. O aplicativo compara dois números, então exibe mensagens que mostram os resultados da comparação. Você usará as ferramentas de linha de comando JDK ( Java Development Kit) para compilar e executar os programas deste capítulo. Se preferir usar um ambiente de desenvolvimento integrado (integrated development environment — IDE), também postamos vídeos Dive Into® no site dos autores (ver seção Antes de começar, nas páginas iniciais) deste livro para o Eclipse, NetBeans e IntelliJ IDEA.</h3><p><br></p><h2><strong>2 Nosso primeiro programa Java: imprimindo uma linha de texto</strong></h2><p><br></p><h3>Um <span style="color: rgb(161, 0, 0);">aplicativo </span>Java é um programa de computador que é executado quando você utiliza o comando java para carregar a Java Virtual Machine</h3><h3>(JVM). Mais adiante, nesta seção, discutiremos como compilar e executar um aplicativo Java. Primeiro consideramos um aplicativo simples que exibe uma linha de texto. A Figura 2.1 mostra o programa seguido por uma caixa que exibe sua saída. O programa inclui os números de linha. Adicionamos esses números para propósitos instrutivos — eles não fazem parte de um programa Java. Esse exemplo ilustra vários recursos Java importantes. Veremos que a linha 9 faz o trabalho — exibindo a frase <em>Welcome to Java Programming!</em> na tela.</h3><p><br></p><pre class="ql-syntax" spellcheck="false"><span class="hljs-comment">// Figura 2.1: Welcome1.java</span>
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
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (33, '2021-03-15', 'O principal objetivo deste capítulo é fazer com que você pensando nas coisas que podem acontecer quando a segurança não é implementada em um computador ou rede - para aumentar um pouco a sua paranoia - e para lhe dar uma base em alguns conceitos-chave de segurança.', '<h2><strong>1 - Importância da Segurança do Computador e da Rede</strong></h2><p><br></p><h3 class="ql-align-justify"> 	A segurança do computador envolve a implementação de medidas para proteger um único computador. Ao proteger um único computador, você se preocupa em proteger o recursos armazenados nesse computador e protegendo esse computador contra ameaças. A segurança de rede envolve proteger todos os recursos de uma rede de ameaças. Você deve considerar não apenas os computadores da rede, mas outros dispositivos de rede, mídia de transmissão de rede e os dados sendo transmitidos em toda a rede. Nesta seção, você aprenderá a apreciar a importância de segurança de computador e rede, examinando alguns exemplos de ataques que poderia ocorrer. Esses exemplos devem fazer você pensar sobre o que poderia acontecer se a segurança do computador e da rede não for implementada. Também definiremos a segurança como será usado no contexto deste livro.</h3><p><br></p><h2><strong>2 - Expondo segredos</strong></h2><p><br></p><h3 class="ql-align-justify">	Quanto mais conectada nossa sociedade se torna, mais nossos dados confidenciais estão sujeitos a ser descoberto por aqueles que irão usá-lo maliciosamente ou para seu próprio benefício. Por exemplo, na primavera de 2005, os hackers descobriram a senha para T-Mobile © Sidekick © de Paris Hilton e publicou seu catálogo de endereços e outros informações pessoais na Internet. Pense sobre a vulnerabilidade dos dados você armazena no seu celular ou no seu assistente digital pessoal (PDA). Faz você usa senhas difíceis de adivinhar para protegê-lo?</h3><h3 class="ql-align-justify">	Questões de confidencialidade semelhantes são levantadas pelo uso de cartões de crédito para fazer compras pela Internet. Os protocolos básicos da Internet não fornecem proteção de confidencialidade, então as partes localizado entre o cliente e o comerciante poderia capturar números de cartão de crédito e use-os posteriormente para compras fraudulentas. Secure Sockets Layer (SSL) foi desenvolvido pela Netscape ® para lidar com este problema. SSL define o Hypertext Trans- fer Protocolo sobre SSL (HTTPS), que fornece criptografia de dados enviados usando Protocolo de transferência de hipertexto (HTTP), o protocolo usado no mundo inteiro Rede. Transport Layer Security (TLS) oferece proteção mais forte do que SSL e está substituindo-o gradualmente. Embora SSL e TLS possam proteger os dados enquanto eles estão sendo enviados através do Inter net (ou outra rede não segura), seu uso não significa o número do seu cartão de crédito ber está seguro. Verificando o tráfego da Internet em busca de pacotes contendo números de cartão de crédito é uma estratégia de ataque com baixo rendimento. Servidores mal protegidos em um site comercial que mantêm um banco de dados de números de cartão de crédito do cliente são uma recompensa muito mais alvo ing. Há evidências documentadas de que tais ataques ocorreram, ou para obter números de cartão de crédito ou para chantagear o comerciante. Outro risco potencial é o roubo de identidade. Roubo de identidade, ou seja, usando algum a “identidade” do outro (nome, número do seguro social, número da conta bancária, etc.) para obter acesso a um recurso ou serviço, explora uma fraqueza inerente aos serviços que usam informações de identificação não secretas para autenticar solicitações.</h3><p class="ql-align-justify"><br></p><h2><strong>3 - Causando Falhas do Sistema</strong></h2><h3 class="ql-align-justify"><br></h3><h3 class="ql-align-justify">	Alguns invasores não estão atrás de dados confidenciais. Em vez disso, eles querem interromper os negócios ness. Esses invasores usam uma variedade de técnicas para causar danos. Vulnerabilidades em software que aceita entrada do usuário, como navegadores de Internet ou software de e-mail, pode permitir que terceiros assumam o controle de um dispositivo. Atacantes pode corromper os dados no próprio dispositivo ou usar o dispositivo como um trampolim para ataques contra terceiros. Worms e vírus fazem uso de recursos generosos ou vulnerabilidades para espalhar-se amplamente e sobrecarregar redes e sistemas finais com o tráfego que geram erate. O worm da Internet de novembro de 1988 é um dos primeiros exemplos bem documentados desta espécie. Ataques de negação de serviço contra alvos específicos começaram a ocorreram na última década. Um ataque de negação de serviço é aquele que impede um servidor de realizar seu trabalho normal. A resiliência contra ataques de negação de serviço tornou-se um novo critério na concepção de protocolos de segurança.</h3>', 'Princípios de Segurança de Rede', false, 'WAITING_FOR_RESPONSE', '2021-03-15', 1, 12);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (34, '2021-03-16', 'Neste capítulo mais, você aprenderá como reduzir a superfície de ataque para servidores e criar um rede segmentada que protege seus principais recursos contra ataques. O capítulo começa com uma revisão das camadas da pilha de rede e do TCP / IP protocolo.', '<h2>1 - Revisão de protocolos de rede</h2><p><br></p><h3 class="ql-align-justify">Ser capaz de identificar e diminuir o risco de confidencialidade ou integridade de dados violação durante uma transferência de dados de rede, você deve primeiro entender como os dados são transmitido em uma rede. Também é essencial entender a função que os firewalls jogar em uma rede.</h3><p><br></p><h2>1.1 Protocolos de compreensão</h2><h3 class="ql-align-justify"><br></h3><h3 class="ql-align-justify">A palavra protocolo possui várias definições, com base no contexto de seu uso. Na área de comunicações por computador, um protocolo é um conjunto formal de regras que descrevem como os computadores transmitem dados e se comunicam em uma rede. O protocolo define o formato da mensagem e as regras para a troca do mensagens. Por causa da complexidade e múltiplas funções necessárias para iniciar, estabelecer realizar, conduzir e encerrar comunicações entre computadores em uma rede, essas funções são divididas em camadas individuais gerenciáveis. Esta decomposição é conhecida como arquitetura em camadas. Em uma arquitetura em camadas, os protocolos são organizados em uma pilha de camadas em quais dados são passados da camada mais alta para a camada mais baixa para enviar um transmissão. Essa pilha de camadas é chamada de pilha de rede. o protocolos e padrões suportados em cada uma das camadas desempenham funções específicas e anexar informações aos dados conforme eles passam por uma camada específica. Este processo é chamado de encapsulamento de dados. No computador receptor, o processo é revertido e as camadas sucessivas de informações são eliminadas conforme o pacote viaja através da pilha até o camada mais alta. Cada protocolo separa e examina apenas os dados que foram anexado por sua contraparte de protocolo no computador de transmissão. As camadas no modelo variam desde o fornecimento de processos orientados a aplicativos no nível mais alto para a geração de sinais elétricos ou ópticos que são injetado no meio de transmissão (como fios, fibra óptica ou ar), na camada inferior. As camadas intermediárias executam funções adicionais, incluindo configurar a sessão de comunicação, transferir dados e detectar erros.</h3><p><br></p><h2>1.2 O modelo de interconexão de sistemas abertos</h2><p><br></p><h3 class="ql-align-justify">O modelo Open Systems Interconnection (OSI) foi desenvolvido por volta de 1981 pela Organização Internacional de Normalização (ISO). A referência OSI modelo inclui sete camadas funcionais, que fornecem a base para a comunicação cação entre computadores em redes. É útil ter uma compreensão geral posição do modelo de referência OSI ao falar sobre diferentes programas de segurança e como eles funcionam. As sete camadas do modelo OSI, da mais alta à mais baixa, são: Aplicação, apresentação, sessão, transporte, rede, enlace de dados e física. Vocês pode facilmente lembrar deles, usando a frase mnemônica "Todas as pessoas parecem Necessita de processamento de dados.</h3><p class="ql-align-justify"><br></p><h2 class="ql-align-justify">1.3 Portas TCP / IP</h2><p><br></p><h3 class="ql-align-justify">Um protocolo TCP / IP, como HTTP, usa uma porta específica ao transmitir dados. Uma porta é um número incluído no cabeçalho de um pacote. O computador destinatário usa esse número para identificar o serviço que deve processar o pacote. o computador receptor escuta as solicitações em um conjunto de portas. As portas de 0 até 1024 são conhecidas como portas bem conhecidas porque estão associadas a um serviço específico. As portas entre 1025 e 65000 podem ser atribuídas a aplicativos personalizados. Vocês também pode configurar alguns serviços que normalmente usam uma porta conhecida para usar um porta diferente. Por exemplo, você pode configurar seu servidor web para ouvir porta 3295 para um aplicativo de intranet específico.</h3><h3><br></h3><h3>Tabela: Portas conhecidas</h3><h3><br></h3><h3>Número da porta 	Protocolo</h3><h3>20 e 21					FTP</h3><h3>22							SSH</h3><h3>23							Telnet</h3><h3>25							SMTP</h3><h3>53							DNS</h3><h3>80							HTTP</h3><h3>110							POP3</h3><h3>443							HTTPS</h3>', 'Segurança de Rede e do Servidor', false, 'WAITING_FOR_RESPONSE', '2021-03-16', 1, 12);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (35, '2021-03-16', 'A criptografia é uma parte essencial do fornecimento confidencialidade, integridade e autenticação de dados. Um entendimento básico de algoritmos criptográficos (procedimentos passo a passo ou fórmulas matemáticas usados ​​para resolver problemas) e seu papel em fornecer confidencialidade, integridade e a autenticação pode ajudá-lo a tomar boas decisões sobre como usar várias tecnologias que se baseiam neles.', '<h2>1 - Visão geral da criptografia</h2><h3 class="ql-align-justify"><br></h3><h3 class="ql-align-justify">Nesta primeira seção, daremos uma breve olhada na história da criptografia e a vulnerabilidades de alguns algoritmos históricos. A seguir, veremos uma visão geral das quatro principais áreas de criptografia, conhecidas como primitivas criptográficas. De lá, nós brevemente visão geral de como o processo XOR é usado na criptografia. Finalmente, vamos apresentar o elenco de personagens comumente usados ao discutir criptografia.</h3><h2><br></h2><h2>1.1 Uma breve história da criptografia</h2><p><br></p><h3 class="ql-align-justify">A humanidade tem necessidade de criptografar dados muito antes de os computadores serem inventado. Os líderes precisavam entregar dados secretamente aos generais na batalha campo, e os amantes enviaram mensagens um para o outro em código. As primeiras formas de criptografia era fácil de decifrar pelos padrões atuais. No entanto, antes do advento de computadores, analisando e encontrando a fraqueza em um algoritmo criptográfico (a processo conhecido como criptoanálise ) pode levar horas, dias ou anos porque dependia unicamente da engenhosidade e do esforço humanos. O algoritmo criptográfico de hoje ritmos são quebrados por computadores, que podem tentar milhões de combinações cada segundo. À medida que os computadores se tornam mais poderosos, os algoritmos criptográficos devem ser fortalecido para manter os dados seguros. Mas antes de discutirmos os algoritmos usados hoje, vamos dar uma olhada em alguns dos os primeiros métodos de criptografia e analise por que eles são fáceis de quebrar. Cifras de substituição Já em Júlio César, a criptografia era usada para proteger mensagens. César criptografaria suas mensagens antes de entregá-las aos mensageiros, protegendo-os de ser lido durante o trânsito. César usou um método simples de criptografia chamado de cifra de substituição. Uma cifra de substituição mapeia cada letra do alfa- aposta para outra carta. Por exemplo, a letra a pode ser mapeada para f , b para g , e assim por diante ao longo do alfabeto. César costumava substituir cada letra do alfabeto com a letra três letras à direita dela, envolvendo no final do alfabeto. Este mapeamento é mostrado na Figura 3-1, onde as letras na linha superior estão em texto simples (dados em sua forma legível e não criptografada), e aqueles em linha inferior são as letras correspondentes no texto cifrado (dados criptografados, forma ilegível). Usando este esquema de criptografia, ou cifra, se você codificasse a palavra criptografia , você deve procurar a letra c na linha superior e encontrar a letra f correspondente a ele na linha inferior. Aplicando este processo a todas as cartas produz o seguinte: Texto simples: criptografia Texto cifrado : fubswrjudskb Um algoritmo de criptografia requer texto simples e uma chave (um pedaço de dados usado com criptografia e descriptografia) para criar texto cifrado. A chave neste algoritmo ritmo é a tabela mostrada na Figura 3-1. Esta tabela atua como a chave para o algoritmo, mapear letras de texto simples para letras de texto cifrado. Para determinar a mesa, você precisa para saber o deslocamento usado para calcular o texto cifrado. Este valor é conhecido como mudança. Sem a tabela, tentar decodificar fubswrjudskb em criptografia pode parece uma tarefa impossível. No entanto, alguns criptanalistas (pessoas que ana- lyze e crack algoritmos criptográficos) percebeu que quebrar tal cifra foi muito fácil; eles precisavam tentar no máximo 25 substituições ou rotações diferentes do alfabeto antes que o texto cifrado seja convertido em texto simples, mak- sentido das palavras. Outra desvantagem de uma cifra de substituição simples é que é propenso a fre- análise de freqüência. A análise de frequência usa o fato de que algumas letras no lish language aparecem com mais frequência do que outras letras. Por exemplo, considere a seguinte frase: O inimigo planeja esperar até que a tempestade termine para atacar.</h3>', 'CRIPTOGRAFIA', false, 'WAITING_FOR_RESPONSE', '2021-03-16', 1, 12);


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
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (12, '2021-03-15 23:13:43.356', '<p>Quantas letras tem a palavra "palavra"?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-15 23:13:43.356', 12, NULL);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (13, '2021-03-15 23:47:50.927', '<p>Um ataque em que uma pessoa liga e finge ser um membro do departamento de TI para obter a senha de um usuário é conhecido como qual das seguintes?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-15 23:47:50.927', 33, NULL);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (14, '2021-03-15 23:49:20.289', '<p>Qual aspecto da segurança está preocupado com a prevenção de pessoas não autorizadas modificação de informações?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-15 23:49:20.289', 33, NULL);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (15, '2021-03-16 08:50:44.477', '<p>Qual aspecto da segurança é ameaçado por um ataque smurf?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 08:50:44.477', 33, NULL);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (16, '2021-03-16 08:51:47.693', '<p>A análise qualitativa de risco considera a probabilidade de ameaças, mas não o valor dos ativos. Verdadeiro ou falso?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 08:51:47.693', 33, NULL);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (17, '2021-03-16 08:54:38.478', '<p>Qual dos seguintes ativos é mais difícil de associar a um valor matemático?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 08:54:38.478', 33, NULL);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (18, '2021-03-16 08:55:54.472', '<p>Um scanner de vulnerabilidade pode ser usado para identificar vulnerabilidades e avaliar quão críticos eles são. Verdadeiro ou falso?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 08:55:54.472', 33, NULL);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (19, '2021-03-16 09:09:44.432', '<p>Qual camada do modelo OSI é responsável pelo roteamento?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 09:09:44.432', 34, NULL);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (20, '2021-03-16 09:13:11.789', '<p>Qual protocolo TCP / IP é uma alternativa segura ao Telnet?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 09:13:11.789', 34, NULL);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (21, '2021-03-16 09:15:37.369', '<p>Qual porta está associada ao e-mail POP3?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 09:15:37.369', 34, NULL);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (22, '2021-03-16 09:25:26.85', '<p>Um scanner de porta identifica que a porta 23 está aberta. O que isso diz a um atacante sobre o computador?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 09:25:26.85', 34, NULL);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (23, '2021-03-16 09:38:12.328', '<p>A única maneira de quebrar uma cifra de substituição é com a análise de frequência. Verdadeiro ou falso?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 09:38:12.328', 35, NULL);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (24, '2021-03-16 09:39:31.912', '<p>Quais são as primitivas de criptografia?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 09:39:31.912', 35, NULL);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (25, '2021-03-16 09:40:22.264', '<p>Qual dos seguintes é um algoritmo de criptografia simétrica que pode usar tamanhos de chave de 128, 192 ou 256 bits?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 09:40:22.264', 35, NULL);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (26, '2021-03-16 09:40:49.83', '<p>Uma cifra de fluxo requer preenchimento. Verdadeiro ou falso?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 09:40:49.83', 35, NULL);
INSERT INTO questions (id, creation_date, description, status, type, update_date, topic_id, user_id) VALUES (27, '2021-03-16 09:41:22.954', '<p>Uma cifra de fluxo fornece integridade. Verdadeiro ou falso?</p>', 'WAITING_FOR_RESPONSE', 'QUIZ', '2021-03-16 09:41:22.954', 35, NULL);


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
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (54, false, '2', '', 12);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (55, false, '3', '', 12);
INSERT INTO alternatives (id, correct, description, feedback, question_id) VALUES (56, true, '7', '', 12);
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


--
-- Data for Name: answers; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO answers (correct, date, user_id, question_id) VALUES (true, '2021-03-15 23:13:59.435', 1, 12);
INSERT INTO answers (correct, date, user_id, question_id) VALUES (true, '2021-03-15 23:48:01.992', 1, 13);


--
-- Data for Name: comments; Type: TABLE DATA; Schema: public; Owner: -
--



--
-- Data for Name: discipline_users; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO discipline_users (access_date, liked, user_id, discipline_id) VALUES ('2021-03-15 21:01:33.125', false, 1, 1);
INSERT INTO discipline_users (access_date, liked, user_id, discipline_id) VALUES ('2021-03-15 23:06:32.511', false, 1, 2);
INSERT INTO discipline_users (access_date, liked, user_id, discipline_id) VALUES ('2021-03-15 23:22:25.273', false, 1, 3);
INSERT INTO discipline_users (access_date, liked, user_id, discipline_id) VALUES ('2021-03-16 09:36:42.806', false, 1, 12);


--
-- Data for Name: forum_topics; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO forum_topics (id, date, description, likes, title, discipline_id, user_id) VALUES (1, '2021-03-13 05:55:02.911', 'alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi', 0, 'Duvida Routers', 4, 4);
INSERT INTO forum_topics (id, date, description, likes, title, discipline_id, user_id) VALUES (2, '2021-03-13 05:55:02.923', 'alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi', 0, 'Alguem me ajuda por favoor!!!', 4, 3);
INSERT INTO forum_topics (id, date, description, likes, title, discipline_id, user_id) VALUES (3, '2021-03-13 05:55:02.926', 'alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi', 0, 'Configurar um Roteador', 4, 6);


--
-- Data for Name: forum_topic_comments; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO forum_topic_comments (id, content, date, likes, forum_topic_id, user_id) VALUES (1, 'Comment 1', '2021-03-13 05:55:02.939', 0, 1, 2);
INSERT INTO forum_topic_comments (id, content, date, likes, forum_topic_id, user_id) VALUES (2, 'Comment 2', '2021-03-13 05:55:02.944', 0, 1, 3);
INSERT INTO forum_topic_comments (id, content, date, likes, forum_topic_id, user_id) VALUES (3, 'Comment 3', '2021-03-13 05:55:02.951', 0, 1, 4);
INSERT INTO forum_topic_comments (id, content, date, likes, forum_topic_id, user_id) VALUES (4, 'Comment 4', '2021-03-13 05:55:02.954', 0, 2, 2);
INSERT INTO forum_topic_comments (id, content, date, likes, forum_topic_id, user_id) VALUES (5, 'Comment 5', '2021-03-13 05:55:02.958', 0, 3, 5);
INSERT INTO forum_topic_comments (id, content, date, likes, forum_topic_id, user_id) VALUES (6, 'Comment 6', '2021-03-13 05:55:02.961', 0, 3, 6);
INSERT INTO forum_topic_comments (id, content, date, likes, forum_topic_id, user_id) VALUES (7, 'Comment 7', '2021-03-13 05:55:02.964', 0, 3, 6);


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

INSERT INTO topic_users (annotation, finish_date, finished, liked, user_id, topic_id) VALUES ('', '2021-03-15 21:37:02.566', true, false, 1, 32);


--
-- Data for Name: user_activities; Type: TABLE DATA; Schema: public; Owner: -
--

INSERT INTO user_activities (complete_tests, content_uploaded, game_losses, game_wins, right_answers, wrong_answers, user_id) VALUES (0, 0, 0, 0, 0, 0, 2);
INSERT INTO user_activities (complete_tests, content_uploaded, game_losses, game_wins, right_answers, wrong_answers, user_id) VALUES (0, 0, 0, 0, 0, 0, 3);
INSERT INTO user_activities (complete_tests, content_uploaded, game_losses, game_wins, right_answers, wrong_answers, user_id) VALUES (0, 0, 0, 0, 0, 0, 4);
INSERT INTO user_activities (complete_tests, content_uploaded, game_losses, game_wins, right_answers, wrong_answers, user_id) VALUES (0, 0, 0, 0, 0, 0, 5);
INSERT INTO user_activities (complete_tests, content_uploaded, game_losses, game_wins, right_answers, wrong_answers, user_id) VALUES (0, 0, 0, 0, 0, 0, 6);
INSERT INTO user_activities (complete_tests, content_uploaded, game_losses, game_wins, right_answers, wrong_answers, user_id) VALUES (0, 0, 0, 0, 2, 0, 1);


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

SELECT pg_catalog.setval('alternatives_id_seq', 106, true);


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

SELECT pg_catalog.setval('questions_id_seq', 27, true);


--
-- Name: rewards_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('rewards_id_seq', 6, true);


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

SELECT pg_catalog.setval('topics_id_seq', 35, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('users_id_seq', 6, true);


--
-- PostgreSQL database dump complete
--

