package com.gutotech.fatecandoapi.util;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gutotech.fatecandoapi.model.Alternative;
import com.gutotech.fatecandoapi.model.Comment;
import com.gutotech.fatecandoapi.model.Feedback;
import com.gutotech.fatecandoapi.model.ForumThread;
import com.gutotech.fatecandoapi.model.Gender;
import com.gutotech.fatecandoapi.model.Question;
import com.gutotech.fatecandoapi.model.QuestionType;
import com.gutotech.fatecandoapi.model.Reward;
import com.gutotech.fatecandoapi.model.RewardType;
import com.gutotech.fatecandoapi.model.Role;
import com.gutotech.fatecandoapi.model.Subject;
import com.gutotech.fatecandoapi.model.Topic;
import com.gutotech.fatecandoapi.model.UploadStatus;
import com.gutotech.fatecandoapi.model.User;
import com.gutotech.fatecandoapi.repository.CommentRepository;
import com.gutotech.fatecandoapi.repository.ForumThreadRepository;
import com.gutotech.fatecandoapi.repository.QuestionRepository;
import com.gutotech.fatecandoapi.repository.QuestionTypeRepository;
import com.gutotech.fatecandoapi.repository.RewardRepository;
import com.gutotech.fatecandoapi.repository.RoleRepository;
import com.gutotech.fatecandoapi.repository.SubjectRepository;
import com.gutotech.fatecandoapi.repository.TopicRepository;
import com.gutotech.fatecandoapi.security.Roles;
import com.gutotech.fatecandoapi.service.UserService;

@Profile("dev")
@Configuration
public class LoadDatabase implements CommandLineRunner {

	@Autowired
	private UserService userService;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private ForumThreadRepository forumThreadRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionTypeRepository questionTypeRepository;

	@Autowired
	private TopicRepository topicRepository;

	@Autowired
	private RewardRepository rewardRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	private static SecureRandom random = new SecureRandom();

	@Override
	public void run(String... args) throws Exception {
		// Roles
		Role user = new Role(Roles.STUDENT);
		Role admin = new Role(Roles.ADMIN);
		Role teacher = new Role(Roles.TEACHER);
		roleRepository.saveAll(Arrays.asList(user, teacher, admin));

		// Users
		User staff = new User("Equipe Fatecando", "staff@fatecando.com", passwordEncoder.encode("123"), Gender.MALE,
				new Date());
		staff.setEnabled(true);
		staff.setRoles(Set.of(user, admin));
		userService.save(staff);

		User gustavo = new User("Gustavo Alves", "guto@guto.com", "123", Gender.MALE, new Date());
		User kaik = new User("Kayk Vida", "kayk@g.com", "123", Gender.MALE, new Date());
		User kaizer = new User("Kaizer Variola", "kaizer@gmail.com", "123", Gender.MALE, new Date());
		
		User alice = new User("Alice Bianca", "alice@hotmail.com", "123", Gender.FEMALE, new Date());
		userService.registerAll(Arrays.asList(gustavo, kaik, kaizer, alice));

		// Rewards
		Reward reward1 = new Reward(RewardType.RIGHT_ANSWER, 100, 0);
		Reward reward3 = new Reward(RewardType.WRONG_ANSWER, -50, 0);
		Reward reward2 = new Reward(RewardType.GAME, 200, 0);
		Reward reward4 = new Reward(RewardType.TEST_COMPLETED, 150, 0);
		Reward reward5 = new Reward(RewardType.CONTRIBUTIONS, 10, 0);
		rewardRepository.saveAll(Arrays.asList(reward1, reward2, reward3, reward4, reward5));

		// Subjects
		Subject alp = new Subject("Algoritmos", "IAL002",
				"Projeto e representação de algoritmos. Estruturas de controle de fluxo de execução: seqüência,\r\n"
						+ "seleção e repetição. Tipos de dados básicos e estruturados (vetores e registros). Rotinas. Arquivos.\r\n"
						+ "Implementação de algoritmos usando uma linguagem de programação.",
				"Analisar problemas computacionais e projetar soluções por meio da construção de algorítmos.", 1, true);
		Subject ed = new Subject("Estrutura de Dados", "ED001",
				"Projeto e representação de algoritmos. Estruturas de controle de fluxo de execução: seqüência,\r\n"
						+ "seleção e repetição. Tipos de dados básicos e estruturados (vetores e registros). Rotinas. Arquivos.\r\n"
						+ "Implementação de algoritmos usando uma linguagem de programação.",
				"Analisar problemas computacionais e projetar soluções por meio da construção de algorítmos.", 3, true);
		Subject db = new Subject("Banco de Dados", "IBD002",
				"Conceitos sobre empreendedorismo. Características e habilidades do empreendedor. O comportamento empreendedor: análise de oportunidades. O processo de geração de idéias e conceito de negócios. Meios para análise de oportunidades e idéias. Estratégia de negócios. Aspectos de planejamento, abertura, funcionamento e gerenciamento de um negócio. Instituições de apoio e financiamento. Desenvolvimento de planos de negócio.",
				"Entender fundamentos, arquitetura e técnicas de projeto e implementação de banco de dados", 4, true);
		Subject ldb = new Subject("Laboratório de Banco de Dados", "IBD100",
				"Conceitos sobre empreendedorismo. Características e habilidades do empreendedor. O comportamento empreendedor: análise de oportunidades. O processo de geração de idéias e conceito de negócios. Meios para análise de oportunidades e idéias. Estratégia de negócios. Aspectos de planejamento, abertura, funcionamento e gerenciamento de um negócio. Instituições de apoio e financiamento. Desenvolvimento de planos de negócio.",
				"Desenvolver plano de negócio para empreendimento em Tecnologia da Informação.", 5, true);
		Subject ago = new Subject("Gestão de Projetos", "AGO005A",
				"Definição de projeto segundo concepção difundida pelas melhores práticas de gestão de projetos. Histórico do desenvolvimento do conjunto de conhecimentos de gestão de projetos. Comparação ente o gerenciamento por projetos com o gerenciamento tradicional. O ciclo de vida de um projeto. Os fatores de sucesso e insucesso de projetos e sua mensuração. As nove de conhecimento para a gestão de projetos e seus processos : Integração, Escopo, Tempo, Custo, Qualidade, Recursos Humanos, Comunicações, Riscos e Aquisições.",
				"Conhecer e aplicar técnicas, métodos e ferramentas para uma gestão eficaz de projetos.", 6, false);
		Subject irc1 = new Subject("Laboratório de Redes", "IRC100A",
				"Prática em laboratório de instalação física de redes e suas diversas topologias, instalação de equipamentos de conectividade, cabeamento estruturado, protocolos TCP/IP, algorítmos e protocolos de roteamento, análise de tráfego, protocolos de transporte TCP e UDP, protocolos de aplicação e instalação de servidores/serviços  de redes.",
				"Instalar redes", 6, false);
		Subject cee = new Subject("Empreendedorismo", "CEE002A",
				"Conceitos sobre empreendedorismo. Características e habilidades do empreendedor. O comportamento empreendedor: análise de oportunidades. O processo de geração de idéias e conceito de negócios. Meios para análise de oportunidades e idéias. Estratégia de negócios. Aspectos de planejamento, abertura, funcionamento e gerenciamento de um negócio. Instituições de apoio e financiamento. Desenvolvimento de planos de negócio.",
				"Desenvolver plano de negócio para empreendimento em Tecnologia da Informação.", 6, false);
		Subject eng1 = new Subject("Engenharia de Software I", "IES100",
				"Conceitos sobre empreendedorismo. Características e habilidades do empreendedor. O comportamento empreendedor: análise de oportunidades. O processo de geração de idéias e conceito de negócios. Meios para análise de oportunidades e idéias. Estratégia de negócios. Aspectos de planejamento, abertura, funcionamento e gerenciamento de um negócio. Instituições de apoio e financiamento. Desenvolvimento de planos de negócio.",
				"Desenvolver plano de negócio para empreendimento em Tecnologia da Informação.", 2, true);
		Subject eng2 = new Subject("Engenharia de Software II", "IES200",
				"Contexto atual das empresas em relação aos projetos de tecnologia de informação. Modelagem de\r\n"
						+ "Negócio para o desenvolvimento de software. Conceitos, evolução e importância da Engenharia de\r\n"
						+ "Requisitos. Entendendo e analisando os problemas e as necessidades dos usuários, clientes e envolvidos no\r\n"
						+ "projeto. Técnicas de elicitação. Requisitos, seus tipos e matriz de rastreabilidade. Definição do sistema a partir\r\n"
						+ "dos requisitos. Gerenciamento de requisitos.",
				"Aplicar um processo de desenvolvimento de software, ênfase na definição e elicitação dos requisitos.",
				3, true);
		Subject eng3 = new Subject("Engenharia de Software III", "IES300",
				"Conceitos sobre empreendedorismo. Características e habilidades do empreendedor. O comportamento empreendedor: análise de oportunidades. O processo de geração de idéias e conceito de negócios. Meios para análise de oportunidades e idéias. Estratégia de negócios. Aspectos de planejamento, abertura, funcionamento e gerenciamento de um negócio. Instituições de apoio e financiamento. Desenvolvimento de planos de negócio.",
				"Desenvolver plano de negócio para empreendimento em Tecnologia da Informação.", 4, true);
		subjectRepository.saveAll(Arrays.asList(alp, ed, ago, irc1, cee, db, ldb, eng1, eng2, eng3));

		// Topics
		Topic topic1 = new Topic("Topic 1", "Description 1", "<p><b>Topic 1</b></p>", true, UploadStatus.APPROVED, alp,
				staff);
		Topic topic2 = new Topic("Topic 2", "Description 2", "<p><b>Topic 2</b></p>", true, UploadStatus.APPROVED, ed,
				staff);
		Topic topic3 = new Topic("Topic 3", "Description 3", "<p><b>Topic 3</b></p>", true, UploadStatus.APPROVED, alp,
				staff);
		Topic topic4 = new Topic("Topic 4", "Description 4", "<p><b>Topic 4</b></p>", true, UploadStatus.APPROVED, alp,
				staff);
		Topic topic5 = new Topic("Topic 5", "Description 5", "<p><b>Topic 5</b></p>", true, UploadStatus.APPROVED, eng3,
				staff);
		Topic topic6 = new Topic("Topic 6", "Description 6", "<p><b>Topic 6</b></p>", true, UploadStatus.APPROVED, alp,
				staff);
		Topic topic7 = new Topic("Topic 7", "Description 7", "<p><b>Topic 7</b></p>", true, UploadStatus.APPROVED, alp,
				staff);
		Topic topic8 = new Topic("Topic 8", "Description 8", "<p><b>Topic 8</b></p>", true, UploadStatus.APPROVED, ed,
				staff);
		List<Topic> topics = Arrays.asList(topic1, topic2, topic3, topic4, topic5, topic6, topic7, topic8);
		topicRepository.saveAll(topics);

		// Forum Topics
		ForumThread forumThread1 = new ForumThread("Ajuda 1", "questions", alp, kaizer, Arrays.asList(topic1, topic2));
		ForumThread forumThread2 = new ForumThread("Alguem me ajuda por favoor!!!",
				"alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi", alp, kaik, Arrays.asList(topic3));
		ForumThread forumThread3 = new ForumThread("Configurar um Roteador",
				"alfajdf jadlfa sasd fjaçsd pogijaefk ajsfpasdfi", alp, alice, Arrays.asList(topic4));
		forumThreadRepository.saveAll(Arrays.asList(forumThread1, forumThread2, forumThread3));

		commentRepository.saveAll(Arrays.asList(new Comment("Comment 1", gustavo, forumThread1),
				new Comment("Comment 2", kaik, forumThread1), new Comment("Comment 3", kaizer, forumThread1),
				new Comment("Comment 4", gustavo, forumThread2), new Comment("Comment 5", staff, forumThread2),
				new Comment("Comment 6", alice, forumThread2), new Comment("Comment 7", alice, forumThread1)));

		// Questions
		List<QuestionType> questionTypes = List.of(new QuestionType("QUIZ"), new QuestionType("TEST"), new QuestionType("GAME"));
		questionTypeRepository.saveAll(questionTypes);
		List<Question> questions = new ArrayList<>();
		for (int i = 0; i <= 100; i++) {
			Question question = new Question("Pergunta " + (i + 1) + "?", List.of(questionTypes.get(random.nextInt(3))),
					UploadStatus.APPROVED, topics.get(i % (topics.size() - 1)), staff,
					Arrays.asList(
							new Alternative("Alternativa 1",
									new Feedback(null, "Parabéns! Esta é a resposta certa!", true)),
							new Alternative("Alternativa 2",
									new Feedback(null, "Quasee! Estude com mais atenção!", false)),
							new Alternative("Alternativa 3",
									new Feedback(null, "Errado! Estude com mais atenção!", false)),
							new Alternative("Alterantiva 4",
									new Feedback(null, "Errado! Estude com mais atenção!", false))));
			questions.add(question);
		}
		questionRepository.saveAll(questions);
		
		User maria = new User("Maria Silva", "maria@hotmail.com", passwordEncoder.encode("123"), Gender.FEMALE, new Date(), true, Arrays.asList(alp));
		maria.setRoles(Set.of(teacher));
		userService.save(maria);
	}

}