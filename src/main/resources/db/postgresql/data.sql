--
-- Data for Name: institutions; 
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
-- Data for Name: courses; 
--

INSERT INTO courses (id, code, description, image_url, name, semesters, institution_id) VALUES (1, 'ADS', 'A matemática, em especial raciocínio lógico e cálculo, é necessária para que o aluno aprenda a otimizar computadores e a desenvolver softwares. O aluno recebe noções sobre Bancos de Dados, sistemas baseados em web (como serviços bancários pela internet) e programação distribuída, que conecta computadores em rede para que funcionem como se fossem um só computador. Administração, contabilidade, economia, estatística e inglês também fazem parte do currículo. Além disso, habilidades para leitura e interpretação de textos são fundamentais para o aprendizado durante o curso. Hoje, o mercado não aceita mais profissionais que se isolam na frente do computador. As empresas exigem pessoas versáteis, dinâmicas, que saibam trabalhar em equipe e possam ter contato com o usuário final do sistema.', 'http://www.fatecsp.br/img/ti.jpg', 'Análise e Desenvolvimento de Sistemas', 6, 1);
INSERT INTO courses (id, code, description, image_url, name, semesters, institution_id) VALUES (2, 'LOG', 'O estudante vai aprender a determinar custos, como fretes e tributos e a planejar rotas de transporte e entrega de mercadorias de maneira eficiente, com qualidade, dentro do prazo estabelecido e a preços competitivos. Por isso, são importantes as disciplinas de cálculo, estatística, matemática financeira, economia e finanças empresariais. O aluno também estuda meios de transporte, suas características e vantagens. Aprende ainda a fazer a gestão de um estoque, a criar embalagens de produtos que facilitem o armazenamento e o transporte e a utilizar softwares de simulação de cargas e roteiros. Gestão, comércio exterior, logística internacional, inglês e espanhol são as disciplinas que completam o currículo.', 'http://www.fateczl.edu.br/imagens/logistica.png', 'Logística', 6, 1);
INSERT INTO courses (id, code, description, image_url, name, semesters, institution_id) VALUES (3, 'COMEX', 'As disciplinas que oferecem base para o curso são administração, economia e comunicação. O aluno vai estudar matemática, estatística, gestão de custos e tributos, gestão financeira, logística, contabilidade, economia internacional e os idiomas inglês e espanhol. As matérias específicas de Comércio Exterior abrangem aspectos geográficos, históricos, políticos e econômicos. O estudante vai aprender sobre blocos econômicos, acordos comerciais firmados entre o Brasil e os demais países do mundo, os organismos internacionais que intervêm no setor, logística internacional, processos de exportação e importação, práticas cambiais, marketing internacional e direito internacional, entre outros temas.', 'http://www.fateczl.edu.br/imagens/comex.jpg', 'Comércio Exterior', 5, 1);
INSERT INTO courses (id, code, description, image_url, name, semesters, institution_id) VALUES (4, 'RH', 'Todos os assuntos são tratados com foco em pessoas, na sua relação com o trabalho. As disciplinas administração financeira, estatística, economia e legislação são os pilares para a aprendizagem de cálculos trabalhistas, análise de retorno de investimento em treinamento etc. Há ainda ênfase no estudo do comportamento do profissional no ambiente de trabalho. Como realizar recrutamento, seleção, treinamento de profissionais, definição de tarefas e funções de acordo com a habilidade de cada indivíduo e cuidados com a qualidade de vida no trabalho completam a formação.', 'http://www.fateczl.edu.br/imagens/gestao_rh.jpg', 'Gestão de Recursos Humanos', 5, 1);
INSERT INTO courses (id, code, description, image_url, name, semesters, institution_id) VALUES (5, 'GEM', 'Contabilidade, economia e administração são as bases de Gestão Empresarial. Direito tributário, logística, empreendedorismo, gestão ambiental, comportamento organizacional (postura do profissional no ambiente de trabalho) e utilização de ferramentas de marketing para motivar e orientar os funcionários também fazem parte da formação. O aluno também aprende a elaborar o planejamento estratégico, que define os objetivos de uma empresa a traçar as estratégias para alcançá-los, usando os recursos disponíveis de maneira eficiente.', 'http://www.fateczl.edu.br/imagens/gestaoempresarial.jpg', 'Gestão Empresarial', 5, 2);


--
-- Data for Name: disciplines; 
--

INSERT INTO disciplines (id, name, code, semester, objective, description, course_id) VALUES (1, 'Algoritmos', 'IAL-002', 1, 'Analisar problemas computacionais e projetar soluções por meio da construção de algorítmos.', 'Projeto e representação de algoritmos. Estruturas de controle de fluxo de execução: sequencial, seleção e repetição. Tipos de dados básicos e estruturados (vetores e registros). Rotinas. Arquivos. Implementação de algoritmos usando uma linguagem de programação.', 1);
INSERT INTO disciplines (id, name, code, semester, objective, description, course_id) VALUES (2, 'Linguagem de Programação', 'ILP-010', 2, 'Solucionar problemas utilizando a lógica de programação e a implementação de programas por meio de uma linguagem de programação.', 'Variáveis, constantes, operadores e expressões. Comando de desvio. Controle de malhas. Vetores e ponteiros. Funções de biblioteca. Estruturas, uniões e tipos definidos pelo usuário. Manipulação de arquivos.', 1);
INSERT INTO disciplines (id, name, code, semester, objective, description, course_id) VALUES (3, 'Estrutura de Dados', 'IED-001', 3, 'Criar e manipular tipos abstratos de dados: listas, pilhas, filas e árvores', 'Pilhas, filas, alocação dinâmica, recursividade, listas encadeadas, tabelas de espalhamento e árvores.', 1);
INSERT INTO disciplines (id, name, code, semester, objective, description, course_id) VALUES (4, 'Gestão de Projetos', 'AGO-006', 6, 'Conhecer e aplicar técnicas, métodos e ferramentas para uma gestão eficaz de projetos.', 'Definição de projeto segundo concepção difundida pelas melhores práticas de gestão de projetos. Histórico do desenvolvimento do conjunto de conhecimentos de gestão de projetos. Comparação entre o gerenciamento por projetos com o gerenciamento tradicional. O ciclo de vida de um projeto. Os fatores de sucesso e insucesso de projetos e sua mensuração. As nove de conhecimento para a gestão de projetos e seus processos: Integração, Escopo, Tempo, Custo, Qualidade, Recursos Humanos, Comunicações, Riscos e Aquisições.', 1);
INSERT INTO disciplines (id, name, code, semester, objective, description, course_id) VALUES (5, 'Laboratório de Redes', 'IRC-100', 6, 'Instalar redes.', 'Prática em laboratório de instalação física de redes e suas diversas topologias, instalação de equipamentos de conectividade, cabeamento estruturado, protocolos TCP/IP, algorítmos e protocolos de roteamento, análise de tráfego, protocolos de transporte TCP e UDP, protocolos de aplicação e instalação de servidores/serviços de redes.', 1);
INSERT INTO disciplines (id, name, code, semester, objective, description, course_id) VALUES (6, 'Empreendedorismo', 'CEE-002', 6, 'Conceitos sobre empreendedorismo. Características e habilidades do empreendedor. O comportamento empreendedor: análise de oportunidades. O processo de geração de idéias e conceito de negócios. Meios para análise de oportunidades e idéias. Estratégia de negócios. Aspectos de planejamento, abertura, funcionamento e gerenciamento de um negócio. Instituições de apoio e financiamento. Desenvolvimento de planos de negócio.', 'Desenvolver plano de negócio para empreendimento em Tecnologia da Informação.', 4);
INSERT INTO disciplines (id, name, code, semester, objective, description, course_id) VALUES (7, 'Banco de Dados', 'IBD-002', 4, 'Entender fundamentos, arquitetura e técnicas de projeto e implementação de banco de dados.', 'Conceitos de Base de Dados. Modelos conceituais de informações. Modelos de Dados: Relacional, Redes e Hierárquicos. Modelagem de dados - conceitual, lógica e física. Teoria relacional: dependências funcionais e multivaloradas, formas normais. Restrições de integridade e de segurança em Banco de Dados Relacional. Sistemas Gerenciadores de Banco de Dados – objetivo e funções. Linguagens de declaração e de manipulação de dados.', 1);
INSERT INTO disciplines (id, name, code, semester, objective, description, course_id) VALUES (8, 'Laboratório de Banco de Dados','IBD-100', 5, 'Implementar soluções de Banco de Dados por meio de tecnologias emergentes.', 'Tecnologias emergentes de mercado que serão aplicadas em laboratório.', 1);
INSERT INTO disciplines (id, name, code, semester, objective, description, course_id) VALUES (9, 'Engenharia de Software I', 'IES-100', 2, 'Aplicar os princípios e conceitos da Engenharia de Software na implementação do componente software, como parte dos Sistemas de Informação e iniciar a modelagem de software (requisitos).', 'Objetivos, conceitos e evolução da Engenharia de Software. Paradigmas de desenvolvimento de software. Evolução das metodologias de sistemas e suas principais técnicas. Processo de desenvolvimento de software. Modelos de software. Ciclo de vida. Qualidade de software e seus modelos. Melhores práticas no desenvolvimento de software.', 1);
INSERT INTO disciplines (id, name, code, semester, objective, description, course_id) VALUES (10, 'Engenharia de Software II', 'IES-200', 3, 'Aplicar um processo de desenvolvimento de software, ênfase na definição e elicitação dos requisitos.', 'Contexto atual das empresas em relação aos projetos de tecnologia de informação. Modelagem de Negócio para o desenvolvimento de software. Conceitos, evolução e importância da Engenharia de Requisitos. Entendendo e analisando os problemas e as necessidades dos usuários, clientes e envolvidos no projeto. Técnicas de elicitação. Requisitos, seus tipos e matriz de rastreabilidade. Definição do sistema a partir dos requisitos. Gerenciamento de requisitos.', 1);
INSERT INTO disciplines (id, name, code, semester, objective, description, course_id) VALUES (11, 'Engenharia de Software III', 'IES-300', 4, 'Conhecer e aplicar padrões ao processo de software. Mapear modelos de representação.', 'Conceitos, evolução e importância de arquitetura de software. Padrões de Arquitetura. Padrões de Distribuição. Camadas no desenvolvimento de software. Tipos de Arquitetura de Software. Visões na arquitetura de software. Modelo de Análise e Projetos. Formas de representação. O processo de desenvolvimento. Mapeamento para implementação. Integração do sistema. Testes: planejamento e tipos. Manutenção. Documentação.', 1);
INSERT INTO disciplines (id, name, code, semester, objective, description, course_id) VALUES (12, 'Segurança da Informação', 'ISG-003', 5, 'Compreender e aplicar as melhores práticas de Segurança da Informação de acordo com normas e padrões conhecidos no mercado de TI.', 'Requisitos de segurança de aplicações, de base de dados e de comunicações. Segurança de dispositivos móveis. Políticas de segurança. Criptografia. Firewalls. Vulnerabilidades e principais tecnologias de segurança.', 1);


--
-- Data for Name: users; 
--

INSERT INTO users (id, birth_date, creation_date, email, enabled, full_name, gender, password, course_id) VALUES (1, '2021-03-13', '2021-03-13 05:55:00.073', 'staff@fatecando.com', true, 'Staff Staff', 'MALE', '$2a$10$NjzYQyDU4sAsq1mZwbG6JupxuuF0DYHkPO5emwMEqb500.kF9RiS2', NULL);
INSERT INTO users (id, birth_date, creation_date, email, enabled, full_name, gender, password, course_id) VALUES (2, '2021-03-13', '2021-03-13 05:55:00.891', 'gustavo.almeida13@fatec.sp.gov.br', true, 'Gustavo Alves', 'MALE', '$2a$10$6hXmEBCXj/qYejdJGUZ/SuSZmJdo5GFhVnkjY8jksLYVPNZdwaZQe', 1);
INSERT INTO users (id, birth_date, creation_date, email, enabled, full_name, gender, password, course_id) VALUES (3, '2021-03-13', '2021-03-13 05:55:01.147', 'caique@gmail.com', true, 'Kayk Vida', 'MALE', '$2a$10$sSlUE7HxQrD9LO7izvds/.eI0X3vieD2ka9lt6jn/sBtPigXz91Q.', 1);
INSERT INTO users (id, birth_date, creation_date, email, enabled, full_name, gender, password, course_id) VALUES (4, '2021-03-13', '2021-03-13 05:55:01.454', 'kaizer@gmail.com', true, 'Kaizer Variola', 'MALE', '$2a$10$0d1LB1BGxZRZZEb6/sfFP.YHxzj6D9DuncKv2nmUvgWtc8.Pz50I6', 1);
INSERT INTO users (id, birth_date, creation_date, email, enabled, full_name, gender, password, course_id) VALUES (5, '2021-03-13', '2021-03-13 05:55:01.717', 'maria@hotmail.com', true, 'Maria Silva', 'FEMALE', '$2a$10$2UsFtP0eSTtgpxVaPcRq5uErs5WMH81jc4NDV/orqNxqrKkmCW5vm', 4);
INSERT INTO users (id, birth_date, creation_date, email, enabled, full_name, gender, password, course_id) VALUES (6, '2021-03-13', '2021-03-13 05:55:01.973', 'alice@hotmail.com', true, 'Alice Bianca', 'FEMALE', '$2a$10$G8cddnXZP1X.MJ4mZOuNwelJXyiSYBhLcFIx5pTIdxJDbElGFUlJ6', NULL);


--
-- Data for Name: topics; 
--

INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (1, '2021-03-13', 'Description description description description', '<h3>Bla bla bla bla</h3>', 'Topic 1', false, 'APPROVED', '2021-03-13', 1, 5);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (2, '2021-03-13', 'Description description description description', '<h3>Bla bla bla bla</h3>', 'Topic 2', false, 'APPROVED', '2021-03-13', 2, 5);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (3, '2021-03-13', 'Description description description description', '<h3>Bla bla bla bla</h3>', 'Topic 3', false, 'APPROVED', '2021-03-13', 1, 2);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (4, '2021-03-13', 'Description description description description', '<h3>Bla bla bla bla</h3>', 'Topic 4', false, 'APPROVED', '2021-03-13', 1, 2);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (5, '2021-03-13', 'Description description description description', '<h3>Bla bla bla bla</h3>', 'Topic 5', false, 'APPROVED', '2021-03-13', 2, 2);
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (6, '2021-03-13', 'Description description description description', '<h3>Bla bla bla bla</h3>', 'Topic 6', false, 'APPROVED', '2021-03-13', 1, 8);
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
INSERT INTO topics (id, creation_date, description, html_content, name, required, status, update_date, created_by_id, discipline_id) VALUES (20, '2021-03-13', 'Introdução a linguagem de programação Java.', '<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>', 'Ârvores', true, 'APPROVED', '2021-03-13', 2,3);
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
 

--
-- Data for Name: questions; 
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


--
-- Data for Name: alternatives; 
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


--
-- Data for Name: answers; 
--



--
-- Data for Name: comments; 
--



--
-- Data for Name: discipline_users; 
--



--
-- Data for Name: forum_topics; 
--

INSERT INTO forum_topics (id, date, description, likes, title, discipline_id, user_id) VALUES (1, '2021-03-13 05:55:02.911', 'alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi', 0, 'Duvida Routers', 4, 4);
INSERT INTO forum_topics (id, date, description, likes, title, discipline_id, user_id) VALUES (2, '2021-03-13 05:55:02.923', 'alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi', 0, 'Alguem me ajuda por favoor!!!', 4, 3);
INSERT INTO forum_topics (id, date, description, likes, title, discipline_id, user_id) VALUES (3, '2021-03-13 05:55:02.926', 'alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi', 0, 'Configurar um Roteador', 4, 6);


--
-- Data for Name: forum_topic_comments; 
--

INSERT INTO forum_topic_comments (id, content, date, likes, forum_topic_id, user_id) VALUES (1, 'Comment 1', '2021-03-13 05:55:02.939', 0, 1, 2);
INSERT INTO forum_topic_comments (id, content, date, likes, forum_topic_id, user_id) VALUES (2, 'Comment 2', '2021-03-13 05:55:02.944', 0, 1, 3);
INSERT INTO forum_topic_comments (id, content, date, likes, forum_topic_id, user_id) VALUES (3, 'Comment 3', '2021-03-13 05:55:02.951', 0, 1, 4);
INSERT INTO forum_topic_comments (id, content, date, likes, forum_topic_id, user_id) VALUES (4, 'Comment 4', '2021-03-13 05:55:02.954', 0, 2, 2);
INSERT INTO forum_topic_comments (id, content, date, likes, forum_topic_id, user_id) VALUES (5, 'Comment 5', '2021-03-13 05:55:02.958', 0, 3, 5);
INSERT INTO forum_topic_comments (id, content, date, likes, forum_topic_id, user_id) VALUES (6, 'Comment 6', '2021-03-13 05:55:02.961', 0, 3, 6);
INSERT INTO forum_topic_comments (id, content, date, likes, forum_topic_id, user_id) VALUES (7, 'Comment 7', '2021-03-13 05:55:02.964', 0, 3, 6);


--
-- Data for Name: games; 
--



--
-- Data for Name: game_users; 
--



--
-- Data for Name: rounds; 
--



--
-- Data for Name: games_rounds; 
--



--
-- Data for Name: games_topics; 
--



--
-- Data for Name: messages; 
--

INSERT INTO messages (id, date, new_message, subject, text, sender_id, recipient_id) VALUES (1, '2021-03-13 05:55:01.99', false, 'Subject 1', 'Text 1', 5, 2);
INSERT INTO messages (id, date, new_message, subject, text, sender_id, recipient_id) VALUES (2, '2021-03-13 05:55:01.995', false, 'Subject 2', 'Text 2', 2, 5);
INSERT INTO messages (id, date, new_message, subject, text, sender_id, recipient_id) VALUES (3, '2021-03-13 05:55:01.998', false, 'Subject 3', 'Text 3', 3, 2);
INSERT INTO messages (id, date, new_message, subject, text, sender_id, recipient_id) VALUES (4, '2021-03-13 05:55:02.002', false, 'Subject 4', 'Text 4', 4, 5);
INSERT INTO messages (id, date, new_message, subject, text, sender_id, recipient_id) VALUES (5, '2021-03-13 05:55:02.005', false, 'Subject 5', 'Text 5', 1, 2);
INSERT INTO messages (id, date, new_message, subject, text, sender_id, recipient_id) VALUES (6, '2021-03-13 05:55:02.009', false, 'Subject 6', 'Text 6', 1, 2);


--
-- Data for Name: rewards; 
--

INSERT INTO rewards (id, date, type, user_id) VALUES (1, '2021-03-13 05:55:02.025', 'RIGHT_ANSWER', 2);
INSERT INTO rewards (id, date, type, user_id) VALUES (2, '2021-03-13 05:55:02.031', 'GAME', 2);
INSERT INTO rewards (id, date, type, user_id) VALUES (3, '2021-03-13 05:55:02.034', 'RIGHT_ANSWER', 6);
INSERT INTO rewards (id, date, type, user_id) VALUES (4, '2021-03-13 05:55:02.037', 'TEST_SUCCESS', 6);


--
-- Data for Name: roles; 
--

INSERT INTO roles (id, name) VALUES (1, 'ROLE_ADMIN');
INSERT INTO roles (id, name) VALUES (2, 'ROLE_USER');


--
-- Data for Name: rounds_users_who_answered; 
--



--
-- Data for Name: tests; 
--



--
-- Data for Name: tests_questions; 
--



--
-- Data for Name: tests_topics; 
--



--
-- Data for Name: topic_users; 
--



--
-- Data for Name: user_activities; 
--

INSERT INTO user_activities (complete_tests, content_uploaded, game_losses, game_wins, right_answers, wrong_answers, user_id) VALUES (0, 0, 0, 0, 0, 0, 1);
INSERT INTO user_activities (complete_tests, content_uploaded, game_losses, game_wins, right_answers, wrong_answers, user_id) VALUES (0, 0, 0, 0, 0, 0, 2);
INSERT INTO user_activities (complete_tests, content_uploaded, game_losses, game_wins, right_answers, wrong_answers, user_id) VALUES (0, 0, 0, 0, 0, 0, 3);
INSERT INTO user_activities (complete_tests, content_uploaded, game_losses, game_wins, right_answers, wrong_answers, user_id) VALUES (0, 0, 0, 0, 0, 0, 4);
INSERT INTO user_activities (complete_tests, content_uploaded, game_losses, game_wins, right_answers, wrong_answers, user_id) VALUES (0, 0, 0, 0, 0, 0, 5);
INSERT INTO user_activities (complete_tests, content_uploaded, game_losses, game_wins, right_answers, wrong_answers, user_id) VALUES (0, 0, 0, 0, 0, 0, 6);


--
-- Data for Name: user_role; 
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

SELECT pg_catalog.setval('alternatives_id_seq', 53, true);


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

SELECT pg_catalog.setval('questions_id_seq', 11, true);


--
-- Name: rewards_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('rewards_id_seq', 4, true);


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

SELECT pg_catalog.setval('topics_id_seq', 31, true);


--
-- Name: users_id_seq; Type: SEQUENCE SET; Schema: public; Owner: -
--

SELECT pg_catalog.setval('users_id_seq', 6, true);


--
-- PostgreSQL database dump complete
--

