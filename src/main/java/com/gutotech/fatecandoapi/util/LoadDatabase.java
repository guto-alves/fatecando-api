package com.gutotech.fatecandoapi.util;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gutotech.fatecandoapi.model.Alternative;
import com.gutotech.fatecandoapi.model.Course;
import com.gutotech.fatecandoapi.model.Discipline;
import com.gutotech.fatecandoapi.model.ForumTopic;
import com.gutotech.fatecandoapi.model.Gender;
import com.gutotech.fatecandoapi.model.Institution;
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
import com.gutotech.fatecandoapi.repository.ForumTopicRepository;
import com.gutotech.fatecandoapi.repository.InstitutionRepository;
import com.gutotech.fatecandoapi.repository.QuestionRepository;
import com.gutotech.fatecandoapi.repository.RewardRepository;
import com.gutotech.fatecandoapi.repository.RoleRepository;
import com.gutotech.fatecandoapi.repository.TestRepository;
import com.gutotech.fatecandoapi.repository.TopicRepository;
import com.gutotech.fatecandoapi.security.Roles;
import com.gutotech.fatecandoapi.service.UserService;

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
	private TestRepository testRepository;

	@Autowired
	private ForumTopicRepository forumTopicRepository;

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

	@Override
	public void run(String... args) throws Exception {
		topicRepository.deleteAll();
		disciplineRepository.deleteAll();
		testRepository.deleteAll();
		institutionRepository.deleteAll();
		courseRepository.deleteAll();
		userService.deleteAll();
		roleRepository.deleteAll();
		questionRepository.deleteAll();

		// Storing Institutions
		Institution fatecZl = new Institution("Fatec Zona Leste");
		Institution fatecSp = new Institution("Fatec São Paulo");
		institutionRepository.saveAll(Arrays.asList(fatecZl, fatecSp));

		// Storing Courses
		Course ads = new Course(null, "Análise e Desenvolvimento de Sistemas", 6);
		Course log = new Course(null, "Logística", 6);
		Course comex = new Course(null, "Comércio Exterior", 5);
		Course rh = new Course(null, "Gestão de Recursos Humanos", 5);
		courseRepository.saveAll(Arrays.asList(ads, log, comex, rh));

		Role admin = new Role(Roles.ADMIN);
		Role user = new Role(Roles.USER);
		roleRepository.saveAll(Arrays.asList(admin, user));

		// Storing Users
		User staff = new User("Staff", "Staff", "staff@fatecando.com", passwordEncoder.encode("123"), Gender.MALE,
				new Date(), null);
		staff.setRoles(Arrays.asList(user, admin));
		userService.save(staff);

		User gustavo = new User("Gustavo", "Alves", "gu@g.com", "123", Gender.MALE, new Date(), ads);
		User kaik = new User("Kayk", "Vida", "kayk@g.com", "123", Gender.MALE, new Date(), ads);
		User kaizer = new User("Kaizer", "Variola", "kaizer@gmail.com", "123", Gender.MALE, new Date(), ads);
		User maria = new User("Maria", "Silva", "maria@hotmail.com", "123", Gender.FEMALE, new Date(), rh);
		User alice = new User("Alice", "Bianca", "alice@hotmail.com", "123", Gender.FEMALE, new Date(), null);
		userService.registerAll(Arrays.asList(gustavo, kaik, kaizer, maria, alice));

		// Storing Rewards
		Reward reward1 = new Reward(RewardType.RIGHT_ANSWER, gustavo);
		Reward reward2 = new Reward(RewardType.GAME, gustavo);
		Reward reward3 = new Reward(RewardType.RIGHT_ANSWER, alice);
		Reward reward4 = new Reward(RewardType.TEST_SUCCESS, alice);
		rewardRepository.saveAll(Arrays.asList(reward1, reward2, reward3, reward4));

		// Storing Disciplines
		Discipline alp = new Discipline("Algoritmos e Logíca de Programação", "IAL002",
				"Projeto e representação de algoritmos. Estruturas de controle de fluxo de execução: seqüência,\r\n"
						+ "seleção e repetição. Tipos de dados básicos e estruturados (vetores e registros). Rotinas. Arquivos.\r\n"
						+ "Implementação de algoritmos usando uma linguagem de programação.",
				"Analisar problemas computacionais e projetar soluções por meio da construção de algorítmos.", 1, ads);
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
		disciplineRepository.saveAll(Arrays.asList(alp, ago, irc1, cee, db, ldb, eng1, eng2, eng3));

		// Storing some Topics tests
		Topic topic1 = new Topic("Topic 1", "Description description description description",
				"<h3>Bla bla bla bla</h3>", UploadStatus.APPROVED, cee, staff);
		Topic topic2 = new Topic("Topic 2", "Description description description description",
				"<h3>Bla bla bla bla</h3>", UploadStatus.WAITING_FOR_RESPONSE, cee, gustavo);
		Topic topic3 = new Topic("Topic 3", "Description description description description",
				"<h3>Bla bla bla bla</h3>", UploadStatus.WAITING_FOR_RESPONSE, ago, staff);
		Topic topic4 = new Topic("Topic 4", "Description description description description",
				"<h3>Bla bla bla bla</h3>", UploadStatus.APPROVED, ago, staff);
		Topic topic5 = new Topic("Topic 5", "Description description description description",
				"<h3>Bla bla bla bla</h3>", UploadStatus.APPROVED, ago, gustavo);
		Topic topic6 = new Topic("Topic 6", "Description description description description",
				"<h3>Bla bla bla bla</h3>", UploadStatus.APPROVED, eng1, staff);
		Topic topic7 = new Topic("Dispositivos Finais e Dispositivos de WAN",
				"Descrever os tipos de dispositvios e a função de cada um", "<p>Bla bla bla bla</p>",
				UploadStatus.APPROVED, irc1, staff);
		Topic topic8 = new Topic("Cisco e ferramentas Cisco", "Description description description description",
				"<h3>Title</h3><br><p>F açsdkfj  aklsdfj çla <b>lçagj</b></p>", UploadStatus.APPROVED, irc1, staff);
		Topic topic9 = new Topic("Wan e Roteadores", "Demonstrar a configuração de um Roteador",
				"<h3>Title</h3><br><p>F afasd f açsdkfj  aklsdfj çla <b>lçagj</b></p>", UploadStatus.APPROVED, irc1,
				staff);
		Topic topic10 = new Topic("Roteamento estático", "Configurar um grupo de roteadores e o roteamento estático",
				"<h3>Title</h3><br><p>F afasd fla lj açsdkfj  aklsdfj çla <b>lçagj</b></p>", UploadStatus.APPROVED,
				irc1, staff);
		Topic topic11 = new Topic("Introdução a Java", "Introdução a linguagem de programação Java.",
				"<h3>Title</h3><br><p>F afasdaklsdfj çla <b>lçagj</b></p>", UploadStatus.APPROVED, alp, gustavo);
		topicRepository.saveAll(Arrays.asList(topic1, topic2, topic3, topic4, topic5, topic6, //
				topic7, topic8, topic9, topic10, topic11));

		// Storing Questions
		Question lpQuestion1 = new Question("Java é:", QuestionType.QUIZ, UploadStatus.APPROVED, Arrays.asList(
				new Alternative("Linguagem de Marcação de Texto", "Errado! Estude com mais atenção!", false),
				new Alternative("Uma linguagem de programação funcional", "Quasee! Estude com mais atenção!", false),
				new Alternative("Uma linguagem de programação orientada a objetos",
						"Parabéns! Esta é a resposta certa!", true),
				new Alternative("uma IDE", "Errado! Estude com mais atenção!", false)), topic11, staff);
		Question lpQuestion2 = new Question("int x = 10;<br>System.out.print(++x);<br><br>A saída será:",
				QuestionType.QUIZ, UploadStatus.APPROVED,
				Arrays.asList(new Alternative("11", "Parabéns! Esta é a resposta certa!", true),
						new Alternative("9", "Quasee! Estude com mais atenção!", false),
						new Alternative("Error", "Errado! Estude com mais atenção!", false),
						new Alternative("10", "Errado! Estude com mais atenção!", false)),
				topic11, staff);
		Question lpQuestion3 = new Question("Pergunta 1:", QuestionType.TEST, UploadStatus.APPROVED,
				Arrays.asList(new Alternative("Resposta 1", "Parabéns! Esta é a resposta certa!", true),
						new Alternative("Resposta 2", "Quasee! Estude com mais atenção!", false),
						new Alternative("Resposta 3", "Errado! Estude com mais atenção!", false),
						new Alternative("Resposta 4", "Errado! Estude com mais atenção!", false),
						new Alternative("Resposta 5", "Errado! Estude com mais atenção!", false)),
				topic11, staff);
		Question lpQuestion4 = new Question("Pergunta 2:", QuestionType.TEST, UploadStatus.APPROVED,
				Arrays.asList(new Alternative("Resposta 1", "Parabéns! Esta é a resposta certa!", true),
						new Alternative("Resposta 2", "Quasee! Estude com mais atenção!", false),
						new Alternative("Resposta 3", "Errado! Estude com mais atenção!", false),
						new Alternative("Resposta 4", "Errado! Estude com mais atenção!", false),
						new Alternative("Resposta 5", "Errado! Estude com mais atenção!", false)),
				topic8, staff);
		Question lpQuestion5 = new Question("Pergunta 3:", QuestionType.TEST, UploadStatus.APPROVED,
				Arrays.asList(new Alternative("Resposta 1", "Parabéns! Esta é a resposta certa!", true),
						new Alternative("Resposta 2", "Quasee! Estude com mais atenção!", false),
						new Alternative("Resposta 3", "Errado! Estude com mais atenção!", false),
						new Alternative("Resposta 4", "Errado! Estude com mais atenção!", false),
						new Alternative("Resposta 5", "Errado! Estude com mais atenção!", false)),
				topic8, staff);
		Question lpQuestion6 = new Question("x = 10 + 1;\nSystem.out.print(\"x--\");\n\n A saída será:",
				QuestionType.TEST, UploadStatus.APPROVED,
				Arrays.asList(new Alternative("11", "Errado! Estude com mais atenção!", false),
						new Alternative("9", "Quasee! Estude com mais atenção!", false),
						new Alternative("Error", "Errado! Estude com mais atenção!", false),
						new Alternative("x--", "Parabéns! Esta é a resposta certa!", true),
						new Alternative("10", "Resposta Errada!", false)),
				topic10, staff);
		questionRepository
				.saveAll(Arrays.asList(lpQuestion1, lpQuestion2, lpQuestion3, lpQuestion4, lpQuestion5, lpQuestion6));

		// Forum Topics
		ForumTopic forumTopic1 = new ForumTopic("Duvida Routers", "alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi",
				irc1, kaizer);
		ForumTopic forumTopic2 = new ForumTopic("Alguem me ajuda por favoor!!!",
				"alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi", irc1, kaik);
		ForumTopic forumTopic3 = new ForumTopic("Configurar um Roteador",
				"alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi", irc1, alice);
		forumTopicRepository.saveAll(Arrays.asList(forumTopic1, forumTopic2, forumTopic3));
	}

}
