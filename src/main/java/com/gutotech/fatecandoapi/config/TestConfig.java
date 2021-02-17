package com.gutotech.fatecandoapi.config;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.gutotech.fatecandoapi.model.Alternative;
import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.model.ForumTopic;
import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.model.Student;
import com.gutotech.fatecandoapi.model.Test;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.repository.DisciplineRepository;
import com.gutotech.fatecandoapi.repository.ForumTopicRepository;
import com.gutotech.fatecandoapi.repository.StudentRepository;
import com.gutotech.fatecandoapi.repository.TestRepository;

@Configuration
public class TestConfig implements CommandLineRunner {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private DisciplineRepository disciplineRepository;

	@Autowired
	private TestRepository testRepository;

	@Autowired
	private ForumTopicRepository forumTopicRepository;

	@Override
	public void run(String... args) throws Exception {
		studentRepository.deleteAll();
		disciplineRepository.deleteAll();

		// Storing Students with topics
		Student gustavo = new Student(null, "Gustavo", "Alves", "gu@g.com", "123", "M", new Date());
		Student kaik = new Student(null, "Kayk", "Vida", "kayk@g.com", "123", "M", new Date());
		Student kaizer = new Student(null, "Kaizer", "Variola", "kaizer@gmail.com", "123", "M", new Date());
		Student maria = new Student(null, "Maria", "Silva", "maria@hotmail.com", "123", "F", new Date());
		studentRepository.saveAll(Arrays.asList(gustavo, kaik, kaizer, maria));

		// Storing Disciplines
		Discipline alp = new Discipline("Algoritmos e Logíca de Programação", "IAL002",
				"Projeto e representação de algoritmos. Estruturas de controle de fluxo de execução: seqüência,\r\n"
						+ "seleção e repetição. Tipos de dados básicos e estruturados (vetores e registros). Rotinas. Arquivos.\r\n"
						+ "Implementação de algoritmos usando uma linguagem de programação.",
				"Analisar problemas computacionais e projetar soluções por meio da construção de algorítmos.", 1);

		Discipline db = new Discipline("Banco de Dados", "IBD002",
				"Conceitos sobre empreendedorismo. Características e habilidades do empreendedor. O comportamento empreendedor: análise de oportunidades. O processo de geração de idéias e conceito de negócios. Meios para análise de oportunidades e idéias. Estratégia de negócios. Aspectos de planejamento, abertura, funcionamento e gerenciamento de um negócio. Instituições de apoio e financiamento. Desenvolvimento de planos de negócio.",
				"Entender fundamentos, arquitetura e técnicas de projeto e implementação de banco de dados", 4);

		Discipline ldb = new Discipline("Laboratória de Banco de Dados", "IBD100",
				"Conceitos sobre empreendedorismo. Características e habilidades do empreendedor. O comportamento empreendedor: análise de oportunidades. O processo de geração de idéias e conceito de negócios. Meios para análise de oportunidades e idéias. Estratégia de negócios. Aspectos de planejamento, abertura, funcionamento e gerenciamento de um negócio. Instituições de apoio e financiamento. Desenvolvimento de planos de negócio.",
				"Desenvolver plano de negócio para empreendimento em Tecnologia da Informação.", 5);

		Discipline eng1 = new Discipline("Engenharia de Software I", "IES100",
				"Conceitos sobre empreendedorismo. Características e habilidades do empreendedor. O comportamento empreendedor: análise de oportunidades. O processo de geração de idéias e conceito de negócios. Meios para análise de oportunidades e idéias. Estratégia de negócios. Aspectos de planejamento, abertura, funcionamento e gerenciamento de um negócio. Instituições de apoio e financiamento. Desenvolvimento de planos de negócio.",
				"Desenvolver plano de negócio para empreendimento em Tecnologia da Informação.", 2);

		Discipline eng2 = new Discipline("Engenharia de Software II", "IES200",
				"Contexto atual das empresas em relação aos projetos de tecnologia de informação. Modelagem de\r\n"
						+ "Negócio para o desenvolvimento de software. Conceitos, evolução e importância da Engenharia de\r\n"
						+ "Requisitos. Entendendo e analisando os problemas e as necessidades dos usuários, clientes e envolvidos no\r\n"
						+ "projeto. Técnicas de elicitação. Requisitos, seus tipos e matriz de rastreabilidade. Definição do sistema a partir\r\n"
						+ "dos requisitos. Gerenciamento de requisitos.",
				"Aplicar um processo de desenvolvimento de software, ênfase na definição e elicitação dos requisitos.",
				3);

		Discipline eng3 = new Discipline("Engenharia de Software III", "IES300",
				"Conceitos sobre empreendedorismo. Características e habilidades do empreendedor. O comportamento empreendedor: análise de oportunidades. O processo de geração de idéias e conceito de negócios. Meios para análise de oportunidades e idéias. Estratégia de negócios. Aspectos de planejamento, abertura, funcionamento e gerenciamento de um negócio. Instituições de apoio e financiamento. Desenvolvimento de planos de negócio.",
				"Desenvolver plano de negócio para empreendimento em Tecnologia da Informação.", 4);

		Discipline ago = new Discipline("Gestão de Projetos", "AGO005A",
				"Definição de projeto segundo concepção difundida pelas melhores práticas de gestão de projetos. Histórico do desenvolvimento do conjunto de conhecimentos de gestão de projetos. Comparação ente o gerenciamento por projetos com o gerenciamento tradicional. O ciclo de vida de um projeto. Os fatores de sucesso e insucesso de projetos e sua mensuração. As nove de conhecimento para a gestão de projetos e seus processos : Integração, Escopo, Tempo, Custo, Qualidade, Recursos Humanos, Comunicações, Riscos e Aquisições.",
				"Conhecer e aplicar técnicas, métodos e ferramentas para uma gestão eficaz de projetos.", 6);

		Discipline irc1 = new Discipline("Laboratório de Redes", "IRC100A",
				"Prática em laboratório de instalação física de redes e suas diversas topologias, instalação de equipamentos de conectividade, cabeamento estruturado, protocolos TCP/IP, algorítmos e protocolos de roteamento, análise de tráfego, protocolos de transporte TCP e UDP, protocolos de aplicação e instalação de servidores/serviços  de redes.",
				"Instalar redes", 6);

		Discipline cee = new Discipline("Empreendedorismo", "CEE002A",
				"Conceitos sobre empreendedorismo. Características e habilidades do empreendedor. O comportamento empreendedor: análise de oportunidades. O processo de geração de idéias e conceito de negócios. Meios para análise de oportunidades e idéias. Estratégia de negócios. Aspectos de planejamento, abertura, funcionamento e gerenciamento de um negócio. Instituições de apoio e financiamento. Desenvolvimento de planos de negócio.",
				"Desenvolver plano de negócio para empreendimento em Tecnologia da Informação.", 6);

		Topic topic1 = new Topic("Topic 1", "Description description description description",
				"<h3>Bla bla bla bla</h3>");
		Topic topic2 = new Topic("Topic 2", "Description description description description",
				"<h3>Bla bla bla bla</h3>");
		Topic topic3 = new Topic("Topic 3", "Description description description description",
				"<h3>Bla bla bla bla</h3>");
		Topic topic4 = new Topic("Topic 4", "Description description description description",
				"<h3>Bla bla bla bla</h3>");
		Topic topic5 = new Topic("Topic 5", "Description description description description",
				"<h3>Bla bla bla bla</h3>");
		Topic topic6 = new Topic("Topic 6", "Description description description description",
				"<h3>Bla bla bla bla</h3>");

		Topic topic7 = new Topic("Dispositivos Finais e Dispositivos de WAN",
				"Descrever os tipos de dispositvios e a função de cada um", "<p>Bla bla bla bla</p>");

		Topic topic8 = new Topic("Cisco e ferramentas Cisco", "Description description description description",
				"<h3>Title</h3><br><p>F afasd fla ljk çlajsd kfaçsdjf kasdf çlaksdf jçalsfd çlasdfj açsdkfj  aklsdfj çla <b>lçagj</b></p>");
		Topic topic9 = new Topic("Wan e Roteadores", "Demonstrar a configuração de um Roteador",
				"<h3>Title</h3><br><p>F afasd fla ljk çlajsd kfaçsdjf kasdf çlaksdf jçalsfd çlasdfj açsdkfj  aklsdfj çla <b>lçagj</b></p>");
		Topic topic10 = new Topic("Roteamento estático", "Configurar um grupo de roteadores e o roteamento estático",
				"<h3>Title</h3><br><p>F afasd fla ljk çlajsd kfaçsdjf kasdf çlaksdf jçalsfd çlasdfj açsdkfj  aklsdfj çla <b>lçagj</b></p>");

		Topic topic11 = new Topic("Introdução", "Introdução a linguagem de programação Java.",
				"<h3>Title</h3><br><p>F afasd fla ljk çlajsd kfaçsdjf kasdf çlaksdf jçalsfd çlasdfj açsdkfj  aklsdfj çla <b>lçagj</b></p>");

		alp.addTopic(topic11);

		cee.addTopic(topic1);
		cee.addTopic(topic2);
		ago.addTopic(topic3);
		ago.addTopic(topic4);
		ago.addTopic(topic5);
		cee.addTopic(topic6);

		irc1.addTopic(topic7);
		irc1.addTopic(topic8);
		irc1.addTopic(topic9);
		irc1.addTopic(topic10);

		disciplineRepository.saveAll(Arrays.asList(ago, irc1, cee, db, ldb, eng1, eng2, eng3));

		// Storing the test as an exame (Discipline) and a quiz (Topic)
		Test lpQuiz = new Test("Quiz", "Description description description description");
		Question lpQuestion1 = new Question("Java é:", 50, 250, Arrays.asList(
				new Alternative("Linguagem de Marcação de Texto", "Parabéns! Esta é a resposta certa!", true),
				new Alternative("Uma linguagem de programação funcional", "Quasee! Estude com mais atenção!", false),
				new Alternative("Uma linguagem de programação orientada a objetos", "Errado! Estude com mais atenção!",
						false),
				new Alternative("uma IDE", "Errado! Estude com mais atenção!", false)));
		Question lpQuestion2 = new Question("x = 10;\nSystem.out.print(\"++x\")\n\n A saída será:", 50, 250,
				Arrays.asList(new Alternative("11", "Parabéns! Esta é a resposta certa!", true),
						new Alternative("9", "Quasee! Estude com mais atenção!", false),
						new Alternative("Error", "Errado! Estude com mais atenção!", false),
						new Alternative("10", "Errado! Estude com mais atenção!", false)));
		lpQuiz.addQuestion(lpQuestion1);
		lpQuiz.addQuestion(lpQuestion2);

		Test lpTest = new Test("Quiz", "Description description description description");
		Question lpQuestion3 = new Question("Pergunta 1:", 50, 250,
				Arrays.asList(new Alternative("Resposta 1", "Parabéns! Esta é a resposta certa!", true),
						new Alternative("Resposta 2", "Quasee! Estude com mais atenção!", false),
						new Alternative("Resposta 3", "Errado! Estude com mais atenção!", false),
						new Alternative("Resposta 4", "Errado! Estude com mais atenção!", false),
						new Alternative("Resposta 5", "Errado! Estude com mais atenção!", false)));
		Question lpQuestion4 = new Question("x = 10 + 1;\nSystem.out.print(\"x--\")\n\n A saída será:", 50, 250,
				Arrays.asList(new Alternative("11", "Errado! Estude com mais atenção!", false),
						new Alternative("9", "Quasee! Estude com mais atenção!", false),
						new Alternative("Error", "Errado! Estude com mais atenção!", false),
						new Alternative("10", "Parabéns! Esta é a resposta certa!", false)));
		lpTest.addQuestion(lpQuestion3);
		lpTest.addQuestion(lpQuestion4);

		testRepository.saveAll(Arrays.asList(lpTest, lpQuiz));

		topic11.setTest(lpQuiz);
		disciplineRepository.save(alp);

		// Forum Topics
		ForumTopic forumTopic1 = new ForumTopic("Duvida Routers", "alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi",
				new Date(), irc1);
		ForumTopic forumTopic2 = new ForumTopic("Alguem me ajuda por favoor!!!",
				"alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi", new Date(), irc1);
		ForumTopic forumTopic3 = new ForumTopic("Configurar um Roteador",
				"alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi", new Date(), irc1);

		forumTopicRepository.saveAll(Arrays.asList(forumTopic1, forumTopic2, forumTopic3));
	}

}
