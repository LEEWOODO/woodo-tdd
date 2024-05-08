# woodo-tdd

## Test Doubles 의 다섯 가지 요소
- Stub
  - 테스트 중에 호출되면 **미리 정해진 답**을 반환하는 형태를 말한다.
  - 실제 객체처럼 동작하는 클래스를 직접 구현하는데, 테스트에 필요한 구현에 집중하고 부가적인 기능은 구현하지 않는다(DB커넥션, 외부데이터)
  - 상태검증을 하지 않는다. 어떤 입력에 대해서 어떤 출력이 발생하는지를 검증한다.
  - Input에 대해서 어떤 Output이 반환되었는지 검증한다. 즉, 상태(Value)를 검증한다.
- Mock
  - 실제 객체의 동작을 모방하는 객체를 말한다. 메서드의 호출에 대한 기대를 명세하고 미리 정의 해놓은 내용에 따라 **동작했는지 검증**하기 위해서 사용한다.
  - Input과 Output에 관심이 없다. 정해져 있는 비즈니스 로직대로 행동이 되었는지를 검증한다. 즉, 행동(Behavior)을 검증한다.
- Spy
  - 테스트 중에 호출되면 호출된 내용을 **기록하는** 형태를 말한다.
- Dummy
- Fake


## Mock + InjectMocks vs MockBean + Autowired
- 단위테스트 에서는 Mock + InjectMocks를 사용하고, 통합테스트에서는 MockBean + Autowired를 사용하는게 편리해보인다.
- Mock + InjectMocks
  - 단위테스트에서 사용하는 방법이다.
  - Mock을 사용하여 테스트 대상이 의존하는 객체를 대체하고, InjectMocks를 사용하여 테스트 대상에 주입한다.
- MockBean + Autowired
  - 통합테스트에서 사용하는 방법이다.
  - MockBean을 사용하여 테스트 대상이 의존하는 객체를 대체하고, Autowired를 사용하여 테스트 대상에 주입한다.
  - MockBean은 스프링애플리케이션 컨텍스트에 등록되어, 테스트 대상이 의존하는 Bean을 MockBean으로 대체할 수 있다.

## 통합테스트 SprintBootTest
- @SpringBootTest
  - 통합테스트를 위한 애노테이션이다.
  - @SpringBootTest를 사용하면 스프링 애플리케이션 컨텍스트를 로드하고 테스트에 필요한 Bean을 주입받을 수 있다.
  - @SpringBootTest는 기본적으로 테스트 대상 클래스와 같은 패키지에 있는 @SpringBootApplication을 찾아서 애플리케이션 컨텍스트를 로드한다.
  - @SpringBootTest(classes = {TicketingController.class, TicketingService.class})와 같이 classes 속성을 사용하여 특정 클래스를 지정할 수 있다.
  - @SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)와 같이 webEnvironment 속성을 사용하여 웹 환경을 설정할 수 있다.
  - @SpringBootTest(properties = "key=value")와 같이 properties 속성을 사용하여 테스트에 필요한 프로퍼티를 설정할 수 있다.
  - @SpringBootTest는 기본적으로 테스트 클래스에 @Transactional 애노테이션을 적용하여 테스트 메서드 실행 후 롤백한다.
    - Test가 모두 완료된 후에, Test에서 변경된 데이터를 롤백해주는 어노테이션이다. 
    - @Transactional 애노테이션을 사용하지 않으려면 @SpringBootTest(properties = "spring.datasource.url=jdbc:h2:mem:testdb")와 같이 properties 속성을 사용하여 데이터베이스를 설정할 수 있다.
    - @SpringBootTest(properties = "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1")와 같이 properties 속성을 사용하여 데이터베이스를 설정할 수 있다.
  - @SpringBootTest는 기본적으로 테스트 클래스에 @DirtiesContext 애노테이션을 적용하여 테스트 메서드 실행 후 애플리케이션 컨텍스트를 다시 로드한다.
  - @SpringBootTest는 기본적으로 테스트 클래스에 @AutoConfigureMockMvc 애노테이션을 적용하여 MockMvc를 주입받을 수 있다.
  - @SpringBootTest는 기본적으로 테스트 클래스에 @AutoConfigureRestDocs 애노테이션을 적용하여 RestDocs를 사용할 수 있다.
  - @SpringBootTest는 기본적으로 테스트 클래스에 @AutoConfigureTestDatabase 애노테이션을 적용하여 테스트에 사용할 데이터베이스를 설정할 수 있다.
    - 설정방법 : @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)와 같이 replace 속성을 사용하여 데이터베이스를 설정할 수 있다.
      - Replace.NONE : 실제 데이터베이스를 사용한다.
      - Replace.ANY : 구성과 상관없이 connection 속성에 지정된 데이터베이스를 사용한다.
    - 설정방법 : @AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)와 같이 connection 속성을 사용하여 데이터베이스를 설정할 수 있다.
      - EmbeddedDatabaseConnection.NONE : 데이터베이스를 사용하지 않는다.
      - EmbeddedDatabaseConnection.H2 : H2 데이터베이스를 사용한다.
      - EmbeddedDatabaseConnection.DERBY : Derby 데이터베이스를 사용한다.
      - EmbeddedDatabaseConnection.HSQL : HSQL 데이터베이스를 사용한다.
  - @ActiveProfiles("test")와 같이 @ActiveProfiles 애노테이션을 사용하여 테스트에 필요한 프로파일을 설정할 수 있다.

- @DataJpaTest
  - JPA와 관련된 Bean만 어플리케이션 컨텍스트에 등록하고 영속성과 관련된 테스트에 특화된 어노테이션이다.
  - @DataJpaTest를 사용하면 JPA 관련 설정만 로드하고 테스트에 필요한 Bean을 주입받을 수 있다.
  - @DataJpaTest는 기본적으로 테스트 클래스에 @Transactional 애노테이션을 적용하여 테스트 메서드 실행 후 롤백한다.
  - @DataJpaTest는 기본적으로 테스트 클래스에 @DirtiesContext 애노테이션을 적용하여 테스트 메서드 실행 후 애플리케이션 컨텍스트를 다시 로드한다.
  - @DataJpaTest는 기본적으로 테스트 클래스에 @AutoConfigureMockMvc 애노테이션을 적용하여 MockMvc를 주입받을 수 있다.
  - @DataJpaTest는 기본적으로 테스트 클래스에 @AutoConfigureRestDocs 애노테이션을 적용하여 RestDocs를 사용할 수 있다.
  - @DataJpaTest는 기본적으로 테스트 클래스에 @AutoConfigureTestDatabase 애노테이션을 적용하여 테스트에 사용할 데이터베이스를 설정할 수 있다.
    - 기본 설정값인 Replace.Any 를 사용하며, 기본적으로 내장된 임베디드 데이터베이스를 사용한다. 
    - 원하는 DB 설정방법 : @AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE, connection = EmbeddedDatabaseConnection.H2)와 같이 replace 속성과 connection 속성을 사용하여 데이터베이스를 설정할 수 있다.