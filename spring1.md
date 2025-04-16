#구조
##프로젝트 설정
    ###`name` : 프로젝트 이름
    ###`Location` : 프로젝트가 생성될 위치
    ###`Language` : 프로젝트 개발에 사용할 언어 설정
    ###`Type` : 빌더 및 프로젝트 의존성 관리자 종류 지정(Maven)
    ###`Group` : 프로젝트 그룹 패키지 경로(소유한 도메인 역순)
`Artifact` : 프로젝트 식별자(특별한 이유가 없다면 Name 과 동일하게 지정 단, 케밥 케이싱으로)
`Package Name` : 프로젝트 진입점을 가지는 클래스가 만들어질 패키지 경로(특별한 이유가 없다면 Group 값과 Artifact 값의 합. 단, 스네이크 케이싱으로)
`JDK` : 프로젝트 개발에 사용할 JDK 버전 지정(17)
Packaging : 프로젝트 컴파일 방식 지정
jar : Java 어플리케이션이 동작할 수 있도록 바이트 코드 형태로 컴파일(인코딩)한 형태. Java 리소스와 외부 의존성 파일을 포함한다.
war : 그 형태의 근본이 JAR인 것은 동일하나 웹 컨텐츠(HTML, CSS JS 등)를 함께 포함한다.


#의존성
Developer Tools
Lombok : 어노테이션 기반 엔티티 클래스 도구 의존성
Spring Boot DevTools : 스프링 부트 개발자 도구 의존성

Web
Spring Web : 스프링 부트 웹 개발 확장 의존성

Template Engines
Thymeleaf : 스프링 부트를 활용한 동적 HTML 개발을 위한 의존성

SQL
JDBC API : JDBC 는 자바와 데이터베이스간의 연결을 위한 인터페이스 집합이며, 이는 스프링 부트 프레임워크에서 직접 관리하지 않는 저수준의 자유 개발이 가능한 의존성
Spring Boot Data JDBC : JDBC는 자바와 데이터베이스간의 연결을 위한 인터페이스의 집합이며, 이는 스프링부트 프레임워크에서 직접 관리하는 고수준의 (변형)이 제한되어있지만 사용하기 편리하고 성능이 뛰어난 의존성 
MyBatis Framework :  SQL(쿼리)를 직접 작성하는 매퍼(Mapper) 기반의 ORM(Object-Relational Mapping)의 일종인 MyBatis 를 위한 의존성
MariaDB Driver : JDBC(JDBC API 혹은 Spring Boot Data JDBC)를 통해 MariaDB DBMS 에 접속하기 위한 드라이버 의존성

프로젝트 구조
.idea : IntelliJ IDE 관련 설정을 포함하는 디렉토리 특별한 경우가 아니라면 건드리지 않는다.
.mvn : Maven 빌더/의존성 관리자 관련 설정을 포함하는 디렉토리. 특별한 경우가 아니라면 건드리지 않는다.
src : 자바와 기타 프로젝트 관련 리소스를 포함하는 디렉토리.
main : 프로젝트의 주가 되는 Java 코드 및 리소스를 포함하는 디렉토리
    java : 프로젝트의 java 코드를 포함하는 디렉토리. 해당 디렉토리 밑으로는 Java 코드로 인식하고 Java 문법을 적용한다.
    resources : 프로젝트의 Java 코드 외의 리소스를 담고 있다.
        mappers : MyBatis 에서 사용할 SQL(쿼리)을 작성한 XML 파일 포함하기 위한 디렉토리. 설정에 따라 디렉토리 이름은 변경할 수 있다.
        static : 프로젝트에서 사용할 정적인 리소스(CSS, JS, 이미지, 영상 파일 등)를 포함하는 디렉토리. 해당 디렉토리는 루트(/)에 맵핑되어 있다.
        templates : 프로젝트의 템플릿 엔진을 위한 동적인 HTML 파일을 포함하는 디렉토리.
        application.properties : 서버와 스프링 부트의 설정을 담는 파일
test : 테스트 코드를 포함하는 디렉토리. 단위 테스트(Unit Test)를 위한 클래스를 생성한다.


target : 작성한 코드를 컴파일된 상태로 포함하는 디렉토리. 필요에 따라 삭제하여도 무관하다.
.gitignore : Git VCS 가 버전 관리에서 제외하여야 하는 파일 및 디렉토리에 대한 정보를 담는 파일.
HELP.md : 프로젝트 관련 도움말을 담고 있는 파일. 삭제하여도 무관하다
mvnw : Maven 빌더/의존성 관리자 래퍼(Wrapper) 유닉스 계열 운영체제를 위해 존재한다. 특별한 경우가 아니라면 건드리지 않는다.
mvnw.cmd : Maven 빌더/의존성 관리자 래퍼(Wrapper) 윈도우 계열 운영체제를 위해 존재한다. 특별한 경우가 아니라면 건드리지 않는다
pom.xml : Maven 빌더/의존성 관리자 및 프로젝트에 대한 설정 파일. 의존성을 추가하는 등의 관리를 할 수 있다.


