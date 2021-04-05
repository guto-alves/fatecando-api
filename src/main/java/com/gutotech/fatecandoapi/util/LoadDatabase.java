package com.gutotech.fatecandoapi.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gutotech.fatecandoapi.model.Alternative;
import com.gutotech.fatecandoapi.model.Course;
import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.model.ForumTopic;
import com.gutotech.fatecandoapi.model.ForumTopicComment;
import com.gutotech.fatecandoapi.model.Gender;
import com.gutotech.fatecandoapi.model.Institution;
import com.gutotech.fatecandoapi.model.Message;
import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.model.QuestionType;
import com.gutotech.fatecandoapi.model.Reward;
import com.gutotech.fatecandoapi.model.RewardType;
import com.gutotech.fatecandoapi.model.Role;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.UploadStatus;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.repository.CourseRepository;
import com.gutotech.fatecandoapi.repository.DisciplineRepository;
import com.gutotech.fatecandoapi.repository.ForumTopicCommentRepository;
import com.gutotech.fatecandoapi.repository.ForumTopicRepository;
import com.gutotech.fatecandoapi.repository.InstitutionRepository;
import com.gutotech.fatecandoapi.repository.MessageRepository;
import com.gutotech.fatecandoapi.repository.QuestionRepository;
import com.gutotech.fatecandoapi.repository.RewardRepository;
import com.gutotech.fatecandoapi.repository.RoleRepository;
import com.gutotech.fatecandoapi.repository.TopicRepository;
import com.gutotech.fatecandoapi.security.Roles;
import com.gutotech.fatecandoapi.service.UserService;

@Profile("dev")
@Configuration
public class LoadDatabase implements CommandLineRunner {

	@Autowired
	private InstitutionRepository institutionRepository;

	@Autowired
	private CourseRepository courseRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private DisciplineRepository disciplineRepository;

	@Autowired
	private ForumTopicRepository forumTopicRepository;

	@Autowired
	private ForumTopicCommentRepository forumTopicCommentRepository;

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private RewardRepository rewardRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private MessageRepository messageRepository;

	@Override
	public void run(String... args) throws Exception {
		// Storing Institutions
		Institution fatecZl = new Institution("Fatec Zona Leste");
		Institution fatecSp = new Institution("Fatec São Paulo");
		institutionRepository.saveAll(Arrays.asList(fatecZl, fatecSp));

		// Storing Courses
		Course ads = new Course("Análise e Desenvolvimento de Sistemas", "ADS", "http://www.fatecsp.br/img/ti.jpg",
				"Descrição ...", 6, fatecZl);
		Course log = new Course("Logística", "LOG", "http://www.fateczl.edu.br/imagens/logistica.png", "Descrição ...",
				6, fatecZl);
		Course comex = new Course("Comércio Exterior", "COMEX", "http://www.fateczl.edu.br/imagens/comex.jpg",
				"Descrição ...", 5, fatecZl);
		Course rh = new Course("Gestão de Recursos Humanos", "RH", "http://www.fateczl.edu.br/imagens/gestao_rh.jpg",
				"Descrição ...", 5, fatecZl);
		Course gem = new Course("Gestão Empresarial", "GEM", "http://www.fateczl.edu.br/imagens/gestaoempresarial.jpg",
				"Descrição ...", 5, fatecSp);
		courseRepository.saveAll(Arrays.asList(ads, log, comex, rh, gem));

		Role admin = new Role(Roles.ADMIN);
		Role user = new Role(Roles.USER);
		roleRepository.saveAll(Arrays.asList(admin, user));

		// Storing Users
		User staff = new User("Staff Staff", "staff@fatecando.com", passwordEncoder.encode("123"), Gender.MALE,
				new Date(), null);
		staff.setRoles(Arrays.asList(user, admin));
		userService.save(staff);

		User gustavo = new User("Gustavo Alves", "guto@guto.com", "123", Gender.MALE, new Date(), ads);
		User kaik = new User("Kayk Vida", "kayk@g.com", "123", Gender.MALE, new Date(), ads);
		User kaizer = new User("Kaizer Variola", "kaizer@gmail.com", "123", Gender.MALE, new Date(), ads);
		User maria = new User("Maria Silva", "maria@hotmail.com", "123", Gender.FEMALE, new Date(), rh);
		User alice = new User("Alice Bianca", "alice@hotmail.com", "123", Gender.FEMALE, new Date(), null);
		userService.registerAll(Arrays.asList(gustavo, kaik, kaizer, maria, alice));

		messageRepository.saveAll(Arrays.asList(new Message("Subject 1", "Text 1", maria, gustavo),
				new Message("Subject 2", "Text 2", gustavo, maria), new Message("Subject 3", "Text 3", kaik, gustavo),
				new Message("Subject 4", "Text 4", kaizer, maria), new Message("Subject 5", "Text 5", staff, gustavo),
				new Message("Subject 6", "Text 6", staff, gustavo)));

		// Storing Rewards
		Reward reward1 = new Reward(RewardType.RIGHT_ANSWER, gustavo);
		Reward reward2 = new Reward(RewardType.GAME, gustavo);
		Reward reward3 = new Reward(RewardType.RIGHT_ANSWER, alice);
		Reward reward4 = new Reward(RewardType.TEST_SUCCESS, alice);
		rewardRepository.saveAll(Arrays.asList(reward1, reward2, reward3, reward4));

		// Storing Disciplines
		Discipline alp = new Discipline("Algoritmos", "IAL002",
				"Projeto e representação de algoritmos. Estruturas de controle de fluxo de execução: seqüência,\r\n"
						+ "seleção e repetição. Tipos de dados básicos e estruturados (vetores e registros). Rotinas. Arquivos.\r\n"
						+ "Implementação de algoritmos usando uma linguagem de programação.",
				"Analisar problemas computacionais e projetar soluções por meio da construção de algorítmos.", 1, ads);
		Discipline ed = new Discipline("Estrutura de Dados", "ED001",
				"Projeto e representação de algoritmos. Estruturas de controle de fluxo de execução: seqüência,\r\n"
						+ "seleção e repetição. Tipos de dados básicos e estruturados (vetores e registros). Rotinas. Arquivos.\r\n"
						+ "Implementação de algoritmos usando uma linguagem de programação.",
				"Analisar problemas computacionais e projetar soluções por meio da construção de algorítmos.", 3, ads);
		Discipline db = new Discipline("Banco de Dados", "IBD002",
				"Conceitos sobre empreendedorismo. Características e habilidades do empreendedor. O comportamento empreendedor: análise de oportunidades. O processo de geração de idéias e conceito de negócios. Meios para análise de oportunidades e idéias. Estratégia de negócios. Aspectos de planejamento, abertura, funcionamento e gerenciamento de um negócio. Instituições de apoio e financiamento. Desenvolvimento de planos de negócio.",
				"Entender fundamentos, arquitetura e técnicas de projeto e implementação de banco de dados", 4, ads);
		Discipline ldb = new Discipline("Laboratório de Banco de Dados", "IBD100",
				"Conceitos sobre empreendedorismo. Características e habilidades do empreendedor. O comportamento empreendedor: análise de oportunidades. O processo de geração de idéias e conceito de negócios. Meios para análise de oportunidades e idéias. Estratégia de negócios. Aspectos de planejamento, abertura, funcionamento e gerenciamento de um negócio. Instituições de apoio e financiamento. Desenvolvimento de planos de negócio.",
				"Desenvolver plano de negócio para empreendimento em Tecnologia da Informação.", 5, ads);
		Discipline ago = new Discipline("Gestão de Projetos", "AGO005A",
				"Definição de projeto segundo concepção difundida pelas melhores práticas de gestão de projetos. Histórico do desenvolvimento do conjunto de conhecimentos de gestão de projetos. Comparação ente o gerenciamento por projetos com o gerenciamento tradicional. O ciclo de vida de um projeto. Os fatores de sucesso e insucesso de projetos e sua mensuração. As nove de conhecimento para a gestão de projetos e seus processos : Integração, Escopo, Tempo, Custo, Qualidade, Recursos Humanos, Comunicações, Riscos e Aquisições.",
				"Conhecer e aplicar técnicas, métodos e ferramentas para uma gestão eficaz de projetos.", 6, ads);
		Discipline irc1 = new Discipline("Laboratório de Redes", "IRC100A",
				"Prática em laboratório de instalação física de redes e suas diversas topologias, instalação de equipamentos de conectividade, cabeamento estruturado, protocolos TCP/IP, algorítmos e protocolos de roteamento, análise de tráfego, protocolos de transporte TCP e UDP, protocolos de aplicação e instalação de servidores/serviços  de redes.",
				"Instalar redes", 6, ads);
		Discipline cee = new Discipline("Empreendedorismo", "CEE002A",
				"Conceitos sobre empreendedorismo. Características e habilidades do empreendedor. O comportamento empreendedor: análise de oportunidades. O processo de geração de idéias e conceito de negócios. Meios para análise de oportunidades e idéias. Estratégia de negócios. Aspectos de planejamento, abertura, funcionamento e gerenciamento de um negócio. Instituições de apoio e financiamento. Desenvolvimento de planos de negócio.",
				"Desenvolver plano de negócio para empreendimento em Tecnologia da Informação.", 6, rh);
		Discipline eng1 = new Discipline("Engenharia de Software I", "IES100",
				"Conceitos sobre empreendedorismo. Características e habilidades do empreendedor. O comportamento empreendedor: análise de oportunidades. O processo de geração de idéias e conceito de negócios. Meios para análise de oportunidades e idéias. Estratégia de negócios. Aspectos de planejamento, abertura, funcionamento e gerenciamento de um negócio. Instituições de apoio e financiamento. Desenvolvimento de planos de negócio.",
				"Desenvolver plano de negócio para empreendimento em Tecnologia da Informação.", 2, ads);
		Discipline eng2 = new Discipline("Engenharia de Software II", "IES200",
				"Contexto atual das empresas em relação aos projetos de tecnologia de informação. Modelagem de\r\n"
						+ "Negócio para o desenvolvimento de software. Conceitos, evolução e importância da Engenharia de\r\n"
						+ "Requisitos. Entendendo e analisando os problemas e as necessidades dos usuários, clientes e envolvidos no\r\n"
						+ "projeto. Técnicas de elicitação. Requisitos, seus tipos e matriz de rastreabilidade. Definição do sistema a partir\r\n"
						+ "dos requisitos. Gerenciamento de requisitos.",
				"Aplicar um processo de desenvolvimento de software, ênfase na definição e elicitação dos requisitos.",
				3, ads);
		Discipline eng3 = new Discipline("Engenharia de Software III", "IES300",
				"Conceitos sobre empreendedorismo. Características e habilidades do empreendedor. O comportamento empreendedor: análise de oportunidades. O processo de geração de idéias e conceito de negócios. Meios para análise de oportunidades e idéias. Estratégia de negócios. Aspectos de planejamento, abertura, funcionamento e gerenciamento de um negócio. Instituições de apoio e financiamento. Desenvolvimento de planos de negócio.",
				"Desenvolver plano de negócio para empreendimento em Tecnologia da Informação.", 4, ads);
		disciplineRepository.saveAll(Arrays.asList(alp, ed, ago, irc1, cee, db, ldb, eng1, eng2, eng3));

		// Storing some Topics tests
		Topic topic1 = new Topic("Topic 1", "Description 1", "<p><b>Topic 1</b></p>", true, UploadStatus.APPROVED, alp,
				staff);
		Topic topic2 = new Topic("Topic 2", "Description 2", "<p><b>Topic 2</b></p>", true, UploadStatus.APPROVED, alp,
				staff);
		Topic topic3 = new Topic("Topic 3", "Description 3", "<p><b>Topic 3</b></p>", true, UploadStatus.APPROVED, alp,
				staff);
		Topic topic4 = new Topic("Topic 4", "Description 4", "<p><b>Topic 4</b></p>", true, UploadStatus.APPROVED, alp,
				staff);
		Topic topic5 = new Topic("Topic 5", "Description 5", "<p><b>Topic 5</b></p>", true, UploadStatus.APPROVED, alp,
				staff);
		Topic topic6 = new Topic("Topic 5", "Description 5", "<p><b>Topic 6</b></p>", true, UploadStatus.APPROVED, alp,
				staff);
		Topic topic7 = new Topic("Topic 5", "Description 5", "<p><b>Topic 7</b></p>", true, UploadStatus.APPROVED, alp,
				staff);
		List<Topic> topics = Arrays.asList(topic1, topic2, topic3, topic4, topic5, topic6, topic7);
		topicRepository.saveAll(topics);

		// Forum Topics
		ForumTopic forumTopic1 = new ForumTopic("Ajuda 1", "questions", irc1, kaizer, Arrays.asList(topic1, topic2));
		ForumTopic forumTopic2 = new ForumTopic("Alguem me ajuda por favoor!!!",
				"alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi", irc1, kaik, Arrays.asList(topic3));
		ForumTopic forumTopic3 = new ForumTopic("Configurar um Roteador",
				"alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi", irc1, alice, Arrays.asList(topic4));
		forumTopicRepository.saveAll(Arrays.asList(forumTopic1, forumTopic2, forumTopic3));

		forumTopicCommentRepository.saveAll(Arrays.asList(new ForumTopicComment("Comment 1", gustavo, forumTopic1),
				new ForumTopicComment("Comment 2", kaik, forumTopic1),
				new ForumTopicComment("Comment 3", kaizer, forumTopic2),
				new ForumTopicComment("Comment 4", gustavo, forumTopic2),
				new ForumTopicComment("Comment 5", maria, forumTopic3),
				new ForumTopicComment("Comment 6", alice, forumTopic3),
				new ForumTopicComment("Comment 7", alice, forumTopic3)));

		// Storing Questions
		List<Question> questions = new ArrayList<>();
		for (int i = 1; i <= 60; i++) {
			Question question = new Question("Pergunta " + i + "?", QuestionType.values()[i % 3], UploadStatus.APPROVED,
					topics.get(i % topics.size()), staff,
					Arrays.asList(new Alternative("Alternativa 1", "Parabéns! Esta é a resposta certa!", true),
							new Alternative("Alternativa 2", "Quasee! Estude com mais atenção!", false),
							new Alternative("Alternativa 3", "Errado! Estude com mais atenção!", false),
							new Alternative("Alterantiva 4", "Errado! Estude com mais atenção!", false)));
			questions.add(question);
		}
		questionRepository.saveAll(questions);
	}

}