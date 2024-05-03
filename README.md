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